/*
 *    GeoTools - The Open Source Java GIS Toolkit
 *    http://geotools.org
 *
 *    (C) 2019, Open Source Geospatial Foundation (OSGeo)
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
 *
 */

package org.geotools.wmts;

import net.opengis.wmts.v_1.impl.wmtsv_1FactoryImpl;
import org.geotools.wmts.bindings.AcceptedFormatsTypeBinding;
import org.geotools.wmts.bindings.BinaryPayloadBinding;
import org.geotools.wmts.bindings.CapabilitiesBinding;
import org.geotools.wmts.bindings.ContentsTypeBinding;
import org.geotools.wmts.bindings.DimensionBinding;
import org.geotools.wmts.bindings.DimensionNameValueBinding;
import org.geotools.wmts.bindings.FeatureInfoResponseBinding;
import org.geotools.wmts.bindings.GetCapabilitiesBinding;
import org.geotools.wmts.bindings.GetCapabilitiesValueTypeBinding;
import org.geotools.wmts.bindings.GetFeatureInfoBinding;
import org.geotools.wmts.bindings.GetFeatureInfoValueTypeBinding;
import org.geotools.wmts.bindings.GetTileBinding;
import org.geotools.wmts.bindings.GetTileValueTypeBinding;
import org.geotools.wmts.bindings.LayerTypeBinding;
import org.geotools.wmts.bindings.LegendURLBinding;
import org.geotools.wmts.bindings.RequestServiceTypeBinding;
import org.geotools.wmts.bindings.SectionsTypeBinding;
import org.geotools.wmts.bindings.StyleBinding;
import org.geotools.wmts.bindings.TextPayloadBinding;
import org.geotools.wmts.bindings.ThemeBinding;
import org.geotools.wmts.bindings.ThemesBinding;
import org.geotools.wmts.bindings.TileMatrixBinding;
import org.geotools.wmts.bindings.TileMatrixLimitsBinding;
import org.geotools.wmts.bindings.TileMatrixSetBinding;
import org.geotools.wmts.bindings.TileMatrixSetLimitsBinding;
import org.geotools.wmts.bindings.TileMatrixSetLinkBinding;
import org.geotools.wmts.bindings.URLTemplateTypeBinding;
import org.geotools.wmts.bindings.VersionTypeBinding;
import org.geotools.xsd.Configuration;
import org.picocontainer.MutablePicoContainer;

/**
 * Parser configuration for the http://www.opengis.net/wmts/1.0 schema.
 *
 * @generated
 */
public class WMTSConfiguration extends Configuration {

    @Override
    protected void configureContext(MutablePicoContainer context) {
        context.registerComponentImplementation(wmtsv_1FactoryImpl.class);
    }

    /**
     * Creates a new configuration.
     *
     * @generated
     */
    public WMTSConfiguration() {
        super(WMTS.getInstance());

        addDependency(new org.geotools.ows.v1_1.OWSConfiguration());
    }

    /**
     * Registers the bindings for the configuration.
     *
     * @generated
     */
    @Override
    protected final void registerBindings(MutablePicoContainer container) {
        // Types
        container.registerComponentImplementation(WMTS.AcceptedFormatsType, AcceptedFormatsTypeBinding.class);
        container.registerComponentImplementation(WMTS.ContentsType, ContentsTypeBinding.class);
        container.registerComponentImplementation(WMTS.GetCapabilitiesValueType, GetCapabilitiesValueTypeBinding.class);
        container.registerComponentImplementation(WMTS.GetFeatureInfoValueType, GetFeatureInfoValueTypeBinding.class);
        container.registerComponentImplementation(WMTS.GetTileValueType, GetTileValueTypeBinding.class);
        container.registerComponentImplementation(WMTS.LayerType, LayerTypeBinding.class);
        // container.registerComponentImplementation(WMTS.Layer, LayerBinding.class);
        // container.registerComponentImplementation(
        //     OWS.DatasetDescriptionSummary, LayerTypeBinding.class);
        container.registerComponentImplementation(WMTS.RequestServiceType, RequestServiceTypeBinding.class);
        container.registerComponentImplementation(WMTS.SectionsType, SectionsTypeBinding.class);
        container.registerComponentImplementation(WMTS.URLTemplateType, URLTemplateTypeBinding.class);
        container.registerComponentImplementation(WMTS.VersionType, VersionTypeBinding.class);

        // Elements
        container.registerComponentImplementation(WMTS.BinaryPayload, BinaryPayloadBinding.class);
        container.registerComponentImplementation(WMTS._BinaryPayload, BinaryPayloadBinding.class);
        container.registerComponentImplementation(WMTS.Capabilities, CapabilitiesBinding.class);
        container.registerComponentImplementation(WMTS._Capabilities, CapabilitiesBinding.class);
        container.registerComponentImplementation(WMTS.Dimension, DimensionBinding.class);
        container.registerComponentImplementation(WMTS._Dimension, DimensionBinding.class);
        container.registerComponentImplementation(WMTS.DimensionNameValue, DimensionNameValueBinding.class);
        container.registerComponentImplementation(WMTS._DimensionNameValue, DimensionNameValueBinding.class);
        container.registerComponentImplementation(WMTS.FeatureInfoResponse, FeatureInfoResponseBinding.class);
        container.registerComponentImplementation(WMTS._FeatureInfoResponse, FeatureInfoResponseBinding.class);
        container.registerComponentImplementation(WMTS.GetCapabilities, GetCapabilitiesBinding.class);
        container.registerComponentImplementation(WMTS._GetCapabilities, GetCapabilitiesBinding.class);
        container.registerComponentImplementation(WMTS.GetFeatureInfo, GetFeatureInfoBinding.class);
        container.registerComponentImplementation(WMTS._GetFeatureInfo, GetFeatureInfoBinding.class);
        container.registerComponentImplementation(WMTS.GetTile, GetTileBinding.class);
        container.registerComponentImplementation(WMTS._GetTile, GetTileBinding.class);
        container.registerComponentImplementation(WMTS.Layer, LayerTypeBinding.class);
        container.registerComponentImplementation(WMTS.LegendURL, LegendURLBinding.class);
        container.registerComponentImplementation(WMTS._LegendURL, LegendURLBinding.class);
        container.registerComponentImplementation(WMTS.Style, StyleBinding.class);
        container.registerComponentImplementation(WMTS._Style, StyleBinding.class);
        container.registerComponentImplementation(WMTS.TextPayload, TextPayloadBinding.class);
        container.registerComponentImplementation(WMTS._TextPayload, TextPayloadBinding.class);
        container.registerComponentImplementation(WMTS.Theme, ThemeBinding.class);
        container.registerComponentImplementation(WMTS._Theme, ThemeBinding.class);
        container.registerComponentImplementation(WMTS.Themes, ThemesBinding.class);
        container.registerComponentImplementation(WMTS._Themes, ThemesBinding.class);
        container.registerComponentImplementation(WMTS.TileMatrix, TileMatrixBinding.class);
        container.registerComponentImplementation(WMTS._TileMatrix, TileMatrixBinding.class);
        container.registerComponentImplementation(WMTS.TileMatrixLimits, TileMatrixLimitsBinding.class);
        container.registerComponentImplementation(WMTS._TileMatrixLimits, TileMatrixLimitsBinding.class);
        container.registerComponentImplementation(WMTS.TileMatrixSet, TileMatrixSetBinding.class);
        container.registerComponentImplementation(WMTS._TileMatrixSet, TileMatrixSetBinding.class);
        container.registerComponentImplementation(WMTS.TileMatrixSetLimits, TileMatrixSetLimitsBinding.class);
        container.registerComponentImplementation(WMTS._TileMatrixSetLimits, TileMatrixSetLimitsBinding.class);
        container.registerComponentImplementation(WMTS.TileMatrixSetLink, TileMatrixSetLinkBinding.class);
        container.registerComponentImplementation(WMTS._TileMatrixSetLink, TileMatrixSetLinkBinding.class);
        /*container.registerComponentImplementation(WMTS.Format, MimeTypeBinding.class);
        container.registerComponentImplementation(WMTS.InfoFormat, MimeTypeBinding.class);*/
    }
}
