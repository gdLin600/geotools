/*
 *    GeoTools - The Open Source Java GIS Toolkit
 *    http://geotools.org
 *
 *    (C) 2005-2008, Open Source Geospatial Foundation (OSGeo)
 *
 *    This library is free software; you can redistribute it and/or
 *    modify it under the terms of the GNU Lesser General Public
 *    License as published by the Free Software Foundation;
 *    version 2.1 of the License.
 *
 *    This library is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *    Lesser General Public License for more details.
 */
package org.geotools.filter.visitor;

import static org.geotools.api.filter.Filter.EXCLUDE;
import static org.geotools.api.filter.Filter.INCLUDE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Arrays;
import org.geotools.api.filter.Filter;
import org.geotools.api.filter.PropertyIsEqualTo;
import org.geotools.api.filter.expression.Expression;
import org.geotools.filter.Capabilities;
import org.geotools.filter.function.math.FilterFunction_abs;
import org.geotools.filter.function.math.FilterFunction_max;
import org.junit.Test;

/**
 * Test case where only specific functions are supported.
 *
 * @author Jesse
 * @author ported from PostPreProcessFilterSplittingVisitor at 2.5.2 by Gabriel Roldan
 */
public class CapabilitiesFilterSplitterFunctionTest extends AbstractCapabilitiesFilterSplitterTests {

    CapabilitiesFilterSplitter visitor;

    @Test
    public void testSupportAll() throws Exception {

        PropertyIsEqualTo filter1 = createFunctionFilter();
        FilterFunction_abs filterFunction_abs = new FilterFunction_abs();
        filterFunction_abs.setParameters(Arrays.asList(new Expression[] {ff.property("name")}));
        PropertyIsEqualTo filter2 = ff.equals(ff.property("name"), filterFunction_abs);

        Filter filter = ff.and(filter1, filter2);

        visitor = newVisitor(new Capabilities());
        filter.accept(visitor, null);

        assertEquals(Filter.INCLUDE, visitor.getFilterPre());
        assertEquals(filter, visitor.getFilterPost());

        Capabilities filterCapabilitiesMask = new Capabilities();

        filterCapabilitiesMask.addName(testFunction.getName());
        filterFunction_abs = new FilterFunction_abs();
        filterCapabilitiesMask.addName(filterFunction_abs.getName());
        filterCapabilitiesMask.addAll(Capabilities.SIMPLE_COMPARISONS_OPENGIS);
        filterCapabilitiesMask.addAll(Capabilities.LOGICAL_OPENGIS);
        visitor = newVisitor(filterCapabilitiesMask);

        filter.accept(visitor, null);

        assertEquals(Filter.INCLUDE, visitor.getFilterPost());
        assertEquals(filter, visitor.getFilterPre());
    }

    @Test
    public void testSupportOnlySome() throws Exception {

        PropertyIsEqualTo filter1 = createFunctionFilter();
        FilterFunction_abs filterFunction_abs = new FilterFunction_abs();
        filterFunction_abs.setParameters(Arrays.asList(new Expression[] {ff.property("name")}));
        PropertyIsEqualTo filter2 = ff.equals(ff.property("name"), filterFunction_abs);

        Filter filter = ff.and(filter1, filter2);

        Capabilities filterCapabilitiesMask = new Capabilities();
        filterCapabilitiesMask.addName(
                testFunction.getName(), testFunction.getParameters().size());
        filterCapabilitiesMask.addAll(Capabilities.SIMPLE_COMPARISONS_OPENGIS);
        filterCapabilitiesMask.addAll(Capabilities.LOGICAL_OPENGIS);
        visitor = newVisitor(filterCapabilitiesMask);

        filter.accept(visitor, null);

        assertEquals(filter1, visitor.getFilterPre());
        assertEquals(filter2, visitor.getFilterPost());
    }

    @Test
    public void testFunctionParameters() throws Exception {

        FilterFunction_max filterFunction_max = new FilterFunction_max();
        filterFunction_max.setParameters(Arrays.asList(ff.property("name"), ff.literal(1.0)));
        PropertyIsEqualTo filter1 = ff.equals(ff.property("name"), filterFunction_max);

        Capabilities filterCapabilitiesMask = new Capabilities();
        filterCapabilitiesMask.addAll(Capabilities.SIMPLE_COMPARISONS_OPENGIS);
        filterCapabilitiesMask.addAll(Capabilities.LOGICAL_OPENGIS);
        filterCapabilitiesMask.addName(filterFunction_max.getName());
        visitor = newVisitor(filterCapabilitiesMask);

        // pre-flight to ensure post stack size is bigger than params size at visit(Function,...)
        assertFalse(filterCapabilitiesMask.supports(Filter.EXCLUDE));
        // Produces "IndexOutOfBoundsException: Index: 3, Size: 2" as of GEOT-6717
        Filter filter = ff.or(Arrays.asList(EXCLUDE, EXCLUDE, EXCLUDE, filter1));

        filter.accept(visitor, null);

        assertEquals(INCLUDE, visitor.getFilterPre());
        assertEquals(filter, visitor.getFilterPost());
    }
}
