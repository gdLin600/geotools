/*
 *    GeoTools - The Open Source Java GIS Toolkit
 *    http://geotools.org
 *
 *    (C) 2012, Open Source Geospatial Foundation (OSGeo)
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
package org.geotools.filter.function.math;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.geotools.api.filter.capability.FunctionName;
import org.geotools.api.filter.expression.Expression;
import org.geotools.api.filter.expression.ExpressionVisitor;
import org.geotools.api.filter.expression.Function;
import org.geotools.api.filter.expression.Literal;
import org.geotools.filter.capability.FunctionNameImpl;
import org.geotools.util.Converters;

/**
 * Implements the Knuth floored division modulo_operation
 *
 * @see <a
 *     href="http://en.wikipedia.org/wiki/Modulo_operation#Remainder_calculation_for_the_modulo_operation">Modulo_operation</a>
 */
public class ModuloFunction implements Function {

    static FunctionName NAME = new FunctionNameImpl(
            "modulo",
            Integer.class,
            FunctionNameImpl.parameter("dividend", Integer.class),
            FunctionNameImpl.parameter("divisor", Integer.class));

    private final FunctionName functionName;

    private final List<Expression> parameters;

    private final Literal fallback;

    public ModuloFunction() {
        this.functionName = NAME;
        this.parameters = Collections.emptyList();
        this.fallback = null;
    }

    public ModuloFunction(List<Expression> parameters, Literal fallback) {
        if (parameters == null) {
            throw new NullPointerException("parameters must be provided");
        }

        if (parameters.size() != NAME.getArguments().size()) {
            throw new IllegalArgumentException(NAME.getArguments().size() + " function parameters are required");
        }

        this.functionName = NAME;
        this.parameters = parameters;
        this.fallback = fallback;
    }

    @Override
    public Object evaluate(Object object) {
        return evaluate(object, functionName.getReturn().getType());
    }

    @Override
    public <T> T evaluate(Object object, Class<T> context) {
        Expression dividendExpression = parameters.get(0);
        int dividend = dividendExpression.evaluate(object, Integer.class);

        Expression divisorExpression = parameters.get(1);
        int divisor = divisorExpression.evaluate(object, Integer.class);

        if (divisor == 0) {
            throw new IllegalArgumentException("divisor cannot be 0");
        }

        int modulo = dividend - divisor * (int) Math.floor((double) dividend / divisor);

        return Converters.convert(modulo, context);
    }

    @Override
    public Object accept(ExpressionVisitor visitor, Object extraData) {
        return visitor.visit(this, extraData);
    }

    @Override
    public String getName() {
        return functionName.getName();
    }

    @Override
    public FunctionName getFunctionName() {
        return functionName;
    }

    @Override
    public List<Expression> getParameters() {
        return Collections.unmodifiableList(parameters);
    }

    @Override
    public Literal getFallbackValue() {
        return fallback;
    }

    /** Creates a String representation of this Function with the function name and the arguments. */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getName());
        sb.append("(");
        List<org.geotools.api.filter.expression.Expression> params = getParameters();
        if (params != null) {
            org.geotools.api.filter.expression.Expression exp;
            for (Iterator<org.geotools.api.filter.expression.Expression> it = params.iterator(); it.hasNext(); ) {
                exp = it.next();
                sb.append("[");
                sb.append(exp);
                sb.append("]");
                if (it.hasNext()) {
                    sb.append(", ");
                }
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
