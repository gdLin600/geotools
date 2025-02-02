/*
 *    GeoTools - The Open Source Java GIS Toolkit
 *    http://geotools.org
 *
 *    (C) 2002-2008, Open Source Geospatial Foundation (OSGeo)
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
package org.geotools.sld.bindings;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.geotools.api.style.FeatureTypeConstraint;
import org.junit.Test;

public class SLDFeatureTypeConstraintBindingTest extends SLDTestSupport {
    @Test
    public void testType() throws Exception {
        assertEquals(FeatureTypeConstraint.class, new SLDFeatureTypeConstraintBinding(null).getType());
    }

    @Test
    public void testNormal() throws Exception {
        SLDMockData.featureTypeConstraint(document, document);

        FeatureTypeConstraint ftc = (FeatureTypeConstraint) parse();
        assertNotNull(ftc);

        assertEquals("theFeatureTypeName", ftc.getFeatureTypeName());
        assertNotNull(ftc.getFilter());
        assertEquals(2, ftc.getExtents().length);
    }
}
