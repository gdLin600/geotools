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
package org.geotools.gml;

import java.util.logging.Logger;
import org.geotools.util.logging.Logging;
import org.locationtech.jts.geom.Geometry;
import org.xml.sax.helpers.XMLFilterImpl;

/**
 * Simple test implementation of <code>GMLHandlerJTS</code>. This very simple handler just prints every JTS geometry
 * that it gets to the standard output.
 *
 * @author Rob Hranac, Vision for New York
 * @version $Id$
 */
public class TestHandler extends XMLFilterImpl implements GMLHandlerJTS {

    static final Logger LOGGER = Logging.getLogger(TestHandler.class);

    @Override
    public void geometry(Geometry geometry) {
        LOGGER.info("here is the geometry: " + geometry);
    }
}
