package com.xpathy;

public class _Attribute_Not_ {

    protected XPathy xPathy;
    protected String attribute;

    protected _Attribute_Not_(XPathy xPathy, Attribute attribute) {
        this.xPathy = xPathy;
        this.attribute = attribute.toString();
    }

    protected _Attribute_Not_(XPathy xPathy, String attribute) {
        this.xPathy = xPathy;
        this.attribute = attribute;
    }

    protected _Attribute_Not_ copy() {
        return new _Attribute_Not_(this.xPathy, this.attribute);
    }

    //=============================================================================

    public XPathy union(Or... orConditions) {
        if (orConditions == null) {
            return this.xPathy;
        }

        XPathy origin = this.xPathy.copy();
        XPathy output = this.xPathy.copy();

        for (int i = 0; i < orConditions.length; i++) {
            Or orCondition = orConditions[i];
            XPathy temp = _Multiple_And_Or_Merger_.merge(origin, orCondition.xPathy);
            temp = _Multiple_And_Or_Merger_.merge(output, temp).copy();

            if (i == 0) {
                if (!orCondition.isNot) {
                    switch (orCondition.expressions) {
                        case EQUALS_TEXT_VALUE:
                            output = temp.byAttribute(Attribute.custom(this.attribute)).not().equals(orCondition.value);
                            break;

                        case EQUALS_NUMBER_VALUE:
                            output = temp.byAttribute(Attribute.custom(this.attribute)).not().equals(orCondition.number);
                            break;

                        case CONTAINS:
                            output = temp.byAttribute(Attribute.custom(this.attribute)).not().contains(orCondition.value);
                            break;

                        case STARTS_WITH:
                            output = temp.byAttribute(Attribute.custom(this.attribute)).not().startsWith(orCondition.value);
                            break;

                        case IS_EMPTY:
                            output = temp.byAttribute(Attribute.custom(this.attribute)).not().empty();
                            break;

                        case IS_NUMERIC:
                            output = temp.byAttribute(Attribute.custom(this.attribute)).not().numeric();
                            break;

                        case GREATER_THAN:
                            output = temp.byAttribute(Attribute.custom(this.attribute)).not().greaterThan(orCondition.min);
                            break;

                        case GREATER_THAN_OR_EQUALS:
                            output = temp.byAttribute(Attribute.custom(this.attribute)).not().greaterThanOrEquals(orCondition.min);
                            break;

                        case LESS_THAN:
                            output = temp.byAttribute(Attribute.custom(this.attribute)).not().lessThan(orCondition.max);
                            break;

                        case LESS_THAN_OR_EQUALS:
                            output = temp.byAttribute(Attribute.custom(this.attribute)).not().lessThanOrEquals(orCondition.max);
                            break;

                        case HAVE_IT:
                            output = temp.byAttribute(Attribute.custom(this.attribute)).not().haveIt();
                            break;

                        case BETWEEN:
                            output = temp.byAttribute(Attribute.custom(this.attribute)).not().between(orCondition.min, orCondition.max);
                            break;
                    }


                } else {
                    switch (orCondition.expressions) {
                        case EQUALS_TEXT_VALUE:
                            output = temp.byAttribute(Attribute.custom(this.attribute)).equals(orCondition.value);
                            break;

                        case EQUALS_NUMBER_VALUE:
                            output = temp.byAttribute(Attribute.custom(this.attribute)).equals(orCondition.number);
                            break;

                        case CONTAINS:
                            output = temp.byAttribute(Attribute.custom(this.attribute)).contains(orCondition.value);
                            break;

                        case STARTS_WITH:
                            output = temp.byAttribute(Attribute.custom(this.attribute)).startsWith(orCondition.value);
                            break;

                        case IS_EMPTY:
                            output = temp.byAttribute(Attribute.custom(this.attribute)).isEmpty();
                            break;

                        case IS_NUMERIC:
                            output = temp.byAttribute(Attribute.custom(this.attribute)).isNumeric();
                            break;

                        case GREATER_THAN:
                            output = temp.byAttribute(Attribute.custom(this.attribute)).greaterThan(orCondition.min);
                            break;

                        case GREATER_THAN_OR_EQUALS:
                            output = temp.byAttribute(Attribute.custom(this.attribute)).greaterThanOrEquals(orCondition.min);
                            break;

                        case LESS_THAN:
                            output = temp.byAttribute(Attribute.custom(this.attribute)).lessThan(orCondition.max);
                            break;

                        case LESS_THAN_OR_EQUALS:
                            output = temp.byAttribute(Attribute.custom(this.attribute)).lessThanOrEquals(orCondition.max);
                            break;

                        case HAVE_IT:
                            output = temp.byAttribute(Attribute.custom(this.attribute)).haveIt();
                            break;

                        case BETWEEN:
                            output = temp.byAttribute(Attribute.custom(this.attribute)).between(orCondition.min, orCondition.max);
                            break;
                    }

                }

            } else {
                if (!orCondition.isNot) {
                    switch (orCondition.expressions) {
                        case EQUALS_TEXT_VALUE:
                            output = temp.or().byAttribute(Attribute.custom(this.attribute)).not().equals(orCondition.value);
                            break;

                        case EQUALS_NUMBER_VALUE:
                            output = temp.or().byAttribute(Attribute.custom(this.attribute)).not().equals(orCondition.number);
                            break;

                        case CONTAINS:
                            output = temp.or().byAttribute(Attribute.custom(this.attribute)).not().contains(orCondition.value);
                            break;

                        case STARTS_WITH:
                            output = temp.or().byAttribute(Attribute.custom(this.attribute)).not().startsWith(orCondition.value);
                            break;

                        case IS_EMPTY:
                            output = temp.or().byAttribute(Attribute.custom(this.attribute)).not().empty();
                            break;

                        case IS_NUMERIC:
                            output = temp.or().byAttribute(Attribute.custom(this.attribute)).not().numeric();
                            break;

                        case GREATER_THAN:
                            output = temp.or().byAttribute(Attribute.custom(this.attribute)).not().greaterThan(orCondition.min);
                            break;

                        case GREATER_THAN_OR_EQUALS:
                            output = temp.or().byAttribute(Attribute.custom(this.attribute)).not().greaterThanOrEquals(orCondition.min);
                            break;

                        case LESS_THAN:
                            output = temp.or().byAttribute(Attribute.custom(this.attribute)).not().lessThan(orCondition.max);
                            break;

                        case LESS_THAN_OR_EQUALS:
                            output = temp.or().byAttribute(Attribute.custom(this.attribute)).not().lessThanOrEquals(orCondition.max);
                            break;

                        case HAVE_IT:
                            output = temp.or().byAttribute(Attribute.custom(this.attribute)).not().haveIt();
                            break;

                        case BETWEEN:
                            output = temp.or().byAttribute(Attribute.custom(this.attribute)).not().between(orCondition.min, orCondition.max);
                            break;
                    }


                } else {
                    switch (orCondition.expressions) {
                        case EQUALS_TEXT_VALUE:
                            output = temp.or().byAttribute(Attribute.custom(this.attribute)).equals(orCondition.value);
                            break;

                        case EQUALS_NUMBER_VALUE:
                            output = temp.or().byAttribute(Attribute.custom(this.attribute)).equals(orCondition.number);
                            break;

                        case CONTAINS:
                            output = temp.or().byAttribute(Attribute.custom(this.attribute)).contains(orCondition.value);
                            break;

                        case STARTS_WITH:
                            output = temp.or().byAttribute(Attribute.custom(this.attribute)).startsWith(orCondition.value);
                            break;

                        case IS_EMPTY:
                            output = temp.or().byAttribute(Attribute.custom(this.attribute)).isEmpty();
                            break;

                        case IS_NUMERIC:
                            output = temp.or().byAttribute(Attribute.custom(this.attribute)).isNumeric();
                            break;

                        case GREATER_THAN:
                            output = temp.or().byAttribute(Attribute.custom(this.attribute)).greaterThan(orCondition.min);
                            break;

                        case GREATER_THAN_OR_EQUALS:
                            output = temp.or().byAttribute(Attribute.custom(this.attribute)).greaterThanOrEquals(orCondition.min);
                            break;

                        case LESS_THAN:
                            output = temp.or().byAttribute(Attribute.custom(this.attribute)).lessThan(orCondition.max);
                            break;

                        case LESS_THAN_OR_EQUALS:
                            output = temp.or().byAttribute(Attribute.custom(this.attribute)).lessThanOrEquals(orCondition.max);
                            break;

                        case HAVE_IT:
                            output = temp.or().byAttribute(Attribute.custom(this.attribute)).haveIt();
                            break;

                        case BETWEEN:
                            output = temp.or().byAttribute(Attribute.custom(this.attribute)).between(orCondition.min, orCondition.max);
                            break;
                    }

                }
            }
        }

        return output.copy();
    }

    //==========================================================================

    public XPathy intersect(And... andConditions) {
        if (andConditions == null) {
            return this.xPathy;
        }

        XPathy origin = this.xPathy.copy();
        XPathy output = this.xPathy.copy();

        for (int i = 0; i < andConditions.length; i++) {
            And andCondition = andConditions[i];
            XPathy temp = _Multiple_And_Or_Merger_.merge(origin, andCondition.xPathy);
            temp = _Multiple_And_Or_Merger_.merge(output, temp).copy();

            if (i == 0) {
                if (!andCondition.isNot) {
                    switch (andCondition.expressions) {
                        case EQUALS_TEXT_VALUE:
                            output = temp.byAttribute(Attribute.custom(this.attribute)).not().equals(andCondition.value);
                            break;
                        case EQUALS_NUMBER_VALUE:
                            output = temp.byAttribute(Attribute.custom(this.attribute)).not().equals(andCondition.number);
                            break;
                        case CONTAINS:
                            output = temp.byAttribute(Attribute.custom(this.attribute)).not().contains(andCondition.value);
                            break;
                        case STARTS_WITH:
                            output = temp.byAttribute(Attribute.custom(this.attribute)).not().startsWith(andCondition.value);
                            break;
                        case IS_EMPTY:
                            output = temp.byAttribute(Attribute.custom(this.attribute)).not().empty();
                            break;
                        case IS_NUMERIC:
                            output = temp.byAttribute(Attribute.custom(this.attribute)).not().numeric();
                            break;
                        case GREATER_THAN:
                            output = temp.byAttribute(Attribute.custom(this.attribute)).not().greaterThan(andCondition.min);
                            break;
                        case GREATER_THAN_OR_EQUALS:
                            output = temp.byAttribute(Attribute.custom(this.attribute)).not().greaterThanOrEquals(andCondition.min);
                            break;
                        case LESS_THAN:
                            output = temp.byAttribute(Attribute.custom(this.attribute)).not().lessThan(andCondition.max);
                            break;
                        case LESS_THAN_OR_EQUALS:
                            output = temp.byAttribute(Attribute.custom(this.attribute)).not().lessThanOrEquals(andCondition.max);
                            break;
                        case HAVE_IT:
                            output = temp.byAttribute(Attribute.custom(this.attribute)).not().haveIt();
                            break;
                        case BETWEEN:
                            output = temp.byAttribute(Attribute.custom(this.attribute)).not().between(andCondition.min, andCondition.max);
                            break;
                    }
                } else {
                    switch (andCondition.expressions) {
                        case EQUALS_TEXT_VALUE:
                            output = temp.byAttribute(Attribute.custom(this.attribute)).equals(andCondition.value);
                            break;
                        case EQUALS_NUMBER_VALUE:
                            output = temp.byAttribute(Attribute.custom(this.attribute)).equals(andCondition.number);
                            break;
                        case CONTAINS:
                            output = temp.byAttribute(Attribute.custom(this.attribute)).contains(andCondition.value);
                            break;
                        case STARTS_WITH:
                            output = temp.byAttribute(Attribute.custom(this.attribute)).startsWith(andCondition.value);
                            break;
                        case IS_EMPTY:
                            output = temp.byAttribute(Attribute.custom(this.attribute)).isEmpty();
                            break;
                        case IS_NUMERIC:
                            output = temp.byAttribute(Attribute.custom(this.attribute)).isNumeric();
                            break;
                        case GREATER_THAN:
                            output = temp.byAttribute(Attribute.custom(this.attribute)).greaterThan(andCondition.min);
                            break;
                        case GREATER_THAN_OR_EQUALS:
                            output = temp.byAttribute(Attribute.custom(this.attribute)).greaterThanOrEquals(andCondition.min);
                            break;
                        case LESS_THAN:
                            output = temp.byAttribute(Attribute.custom(this.attribute)).lessThan(andCondition.max);
                            break;
                        case LESS_THAN_OR_EQUALS:
                            output = temp.byAttribute(Attribute.custom(this.attribute)).lessThanOrEquals(andCondition.max);
                            break;
                        case HAVE_IT:
                            output = temp.byAttribute(Attribute.custom(this.attribute)).haveIt();
                            break;
                        case BETWEEN:
                            output = temp.byAttribute(Attribute.custom(this.attribute)).between(andCondition.min, andCondition.max);
                            break;
                    }
                }
            } else {
                if (!andCondition.isNot) {
                    switch (andCondition.expressions) {
                        case EQUALS_TEXT_VALUE:
                            output = temp.and().byAttribute(Attribute.custom(this.attribute)).not().equals(andCondition.value);
                            break;
                        case EQUALS_NUMBER_VALUE:
                            output = temp.and().byAttribute(Attribute.custom(this.attribute)).not().equals(andCondition.number);
                            break;
                        case CONTAINS:
                            output = temp.and().byAttribute(Attribute.custom(this.attribute)).not().contains(andCondition.value);
                            break;
                        case STARTS_WITH:
                            output = temp.and().byAttribute(Attribute.custom(this.attribute)).not().startsWith(andCondition.value);
                            break;
                        case IS_EMPTY:
                            output = temp.and().byAttribute(Attribute.custom(this.attribute)).not().empty();
                            break;
                        case IS_NUMERIC:
                            output = temp.and().byAttribute(Attribute.custom(this.attribute)).not().numeric();
                            break;
                        case GREATER_THAN:
                            output = temp.and().byAttribute(Attribute.custom(this.attribute)).not().greaterThan(andCondition.min);
                            break;
                        case GREATER_THAN_OR_EQUALS:
                            output = temp.and().byAttribute(Attribute.custom(this.attribute)).not().greaterThanOrEquals(andCondition.min);
                            break;
                        case LESS_THAN:
                            output = temp.and().byAttribute(Attribute.custom(this.attribute)).not().lessThan(andCondition.max);
                            break;
                        case LESS_THAN_OR_EQUALS:
                            output = temp.and().byAttribute(Attribute.custom(this.attribute)).not().lessThanOrEquals(andCondition.max);
                            break;
                        case HAVE_IT:
                            output = temp.and().byAttribute(Attribute.custom(this.attribute)).not().haveIt();
                            break;
                        case BETWEEN:
                            output = temp.and().byAttribute(Attribute.custom(this.attribute)).not().between(andCondition.min, andCondition.max);
                            break;
                    }
                } else {
                    switch (andCondition.expressions) {
                        case EQUALS_TEXT_VALUE:
                            output = temp.and().byAttribute(Attribute.custom(this.attribute)).equals(andCondition.value);
                            break;
                        case EQUALS_NUMBER_VALUE:
                            output = temp.and().byAttribute(Attribute.custom(this.attribute)).equals(andCondition.number);
                            break;
                        case CONTAINS:
                            output = temp.and().byAttribute(Attribute.custom(this.attribute)).contains(andCondition.value);
                            break;
                        case STARTS_WITH:
                            output = temp.and().byAttribute(Attribute.custom(this.attribute)).startsWith(andCondition.value);
                            break;
                        case IS_EMPTY:
                            output = temp.and().byAttribute(Attribute.custom(this.attribute)).isEmpty();
                            break;
                        case IS_NUMERIC:
                            output = temp.and().byAttribute(Attribute.custom(this.attribute)).isNumeric();
                            break;
                        case GREATER_THAN:
                            output = temp.and().byAttribute(Attribute.custom(this.attribute)).greaterThan(andCondition.min);
                            break;
                        case GREATER_THAN_OR_EQUALS:
                            output = temp.and().byAttribute(Attribute.custom(this.attribute)).greaterThanOrEquals(andCondition.min);
                            break;
                        case LESS_THAN:
                            output = temp.and().byAttribute(Attribute.custom(this.attribute)).lessThan(andCondition.max);
                            break;
                        case LESS_THAN_OR_EQUALS:
                            output = temp.and().byAttribute(Attribute.custom(this.attribute)).lessThanOrEquals(andCondition.max);
                            break;
                        case HAVE_IT:
                            output = temp.and().byAttribute(Attribute.custom(this.attribute)).haveIt();
                            break;
                        case BETWEEN:
                            output = temp.and().byAttribute(Attribute.custom(this.attribute)).between(andCondition.min, andCondition.max);
                            break;
                    }
                }
            }
        }

        return output.copy();
    }


    //==========================================================================

    public XPathy haveIt() {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String function = transformer.buildFunctionExpression("@" + this.attribute);

        copy.xpath = new _AppendAndOr_(copy).append("not(" + function + ")");

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    public XPathy equals(String value) {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String function = transformer.buildFunctionExpression("@" + this.attribute);
        String transformedValue = transformer.applyModifiersToValue(value);

        copy.xpath = new _AppendAndOr_(copy).append("not(" + function + "='" + transformedValue + "')");

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    public XPathy contains(String value) {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String function = transformer.buildFunctionExpression("@" + this.attribute);
        String transformedValue = transformer.applyModifiersToValue(value);

        copy.xpath = new _AppendAndOr_(copy).append("not(contains(" + function + ", '" + transformedValue + "'))");

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    public XPathy startsWith(String prefix) {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String function = transformer.buildFunctionExpression("@" + this.attribute);
        String transformedPrefix = transformer.applyModifiersToValue(prefix);

        copy.xpath = new _AppendAndOr_(copy).append("not(starts-with(" + function + ", '" + transformedPrefix + "'))");

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    public XPathy empty() {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String function = transformer.buildFunctionExpression("normalize-space(@" + this.attribute + ")");

        copy.xpath = new _AppendAndOr_(copy).append("not(" + function + "='')");

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    public XPathy numeric() {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String function = transformer.buildFunctionExpression("@" + this.attribute);

        copy.xpath = new _AppendAndOr_(copy).append(
                        "not(" +
                        "not(number(" + function + ") != number("+ function +"))" +
                        ")");

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    public XPathy equals(Number number) {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String attr = transformer.buildFunctionExpression("@" + this.attribute);

        copy.xpath = new _AppendAndOr_(copy).append("not(" + attr + " = " + number + ")");

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    public XPathy greaterThan(Number number) {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String attr = transformer.buildFunctionExpression("@" + this.attribute);

        copy.xpath = new _AppendAndOr_(copy).append(attr + " <= " + number);

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    public XPathy greaterThanOrEquals(Number number) {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String attr = transformer.buildFunctionExpression("@" + this.attribute);

        copy.xpath = new _AppendAndOr_(copy).append(attr + " < " + number);

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    public XPathy lessThan(Number number) {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String attr = transformer.buildFunctionExpression("@" + this.attribute);

        copy.xpath = new _AppendAndOr_(copy).append(attr + " >= " + number);

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    public XPathy lessThanOrEquals(Number number) {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String attr = transformer.buildFunctionExpression("@" + this.attribute);

        copy.xpath = new _AppendAndOr_(copy).append(attr + " > " + number);

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    public XPathy between(Number min, Number max) {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String attr = transformer.buildFunctionExpression("@" + this.attribute);

        String expression = " not ( " + attr + " > " + min + " and " + attr + " < " + max + " ) ";
        copy.xpath = new _AppendAndOr_(copy).append(expression);

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

}
