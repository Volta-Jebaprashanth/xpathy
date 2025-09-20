package com.xpathy;

public class _Text_Not_ {

    protected XPathy xPathy;

    protected _Text_Not_(XPathy xPathy) {
        this.xPathy = xPathy;
    }

    protected _Text_Not_(_Text_Not_ text) {
        this.xPathy = text.xPathy;
    }

    protected _Text_Not_ copy() {
        return new _Text_Not_(this);
    }

    //================================================

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
                            output = temp.byText().not().equals(orCondition.value);
                            break;

                        case EQUALS_NUMBER_VALUE:
                            output = temp.byText().not().equals(orCondition.number);
                            break;

                        case CONTAINS:
                            output = temp.byText().not().contains(orCondition.value);
                            break;

                        case STARTS_WITH:
                            output = temp.byText().not().startsWith(orCondition.value);
                            break;

                        case IS_EMPTY:
                            output = temp.byText().not().empty();
                            break;

                        case IS_NUMERIC:
                            output = temp.byText().not().numeric();
                            break;

                        case GREATER_THAN:
                            output = temp.byText().not().greaterThan(orCondition.min);
                            break;

                        case GREATER_THAN_OR_EQUALS:
                            output = temp.byText().not().greaterThanOrEquals(orCondition.min);
                            break;

                        case LESS_THAN:
                            output = temp.byText().not().lessThan(orCondition.max);
                            break;

                        case LESS_THAN_OR_EQUALS:
                            output = temp.byText().not().lessThanOrEquals(orCondition.max);
                            break;
                    }


                } else {
                    switch (orCondition.expressions) {
                        case EQUALS_TEXT_VALUE:
                            output = temp.byText().equals(orCondition.value);
                            break;

                        case EQUALS_NUMBER_VALUE:
                            output = temp.byText().equals(orCondition.number);
                            break;

                        case CONTAINS:
                            output = temp.byText().contains(orCondition.value);
                            break;

                        case STARTS_WITH:
                            output = temp.byText().startsWith(orCondition.value);
                            break;

                        case IS_EMPTY:
                            output = temp.byText().isEmpty();
                            break;

                        case IS_NUMERIC:
                            output = temp.byText().isNumeric();
                            break;

                        case GREATER_THAN:
                            output = temp.byText().greaterThan(orCondition.min);
                            break;

                        case GREATER_THAN_OR_EQUALS:
                            output = temp.byText().greaterThanOrEquals(orCondition.min);
                            break;

                        case LESS_THAN:
                            output = temp.byText().lessThan(orCondition.max);
                            break;

                        case LESS_THAN_OR_EQUALS:
                            output = temp.byText().lessThanOrEquals(orCondition.max);
                            break;
                    }

                }

            } else {
                if (!orCondition.isNot) {
                    switch (orCondition.expressions) {
                        case EQUALS_TEXT_VALUE:
                            output = temp.or().byText().not().equals(orCondition.value);
                            break;

                        case EQUALS_NUMBER_VALUE:
                            output = temp.or().byText().not().equals(orCondition.number);
                            break;

                        case CONTAINS:
                            output = temp.or().byText().not().contains(orCondition.value);
                            break;

                        case STARTS_WITH:
                            output = temp.or().byText().not().startsWith(orCondition.value);
                            break;

                        case IS_EMPTY:
                            output = temp.or().byText().not().empty();
                            break;

                        case IS_NUMERIC:
                            output = temp.or().byText().not().numeric();
                            break;

                        case GREATER_THAN:
                            output = temp.or().byText().not().greaterThan(orCondition.min);
                            break;

                        case GREATER_THAN_OR_EQUALS:
                            output = temp.or().byText().not().greaterThanOrEquals(orCondition.min);
                            break;

                        case LESS_THAN:
                            output = temp.or().byText().not().lessThan(orCondition.max);
                            break;

                        case LESS_THAN_OR_EQUALS:
                            output = temp.or().byText().not().lessThanOrEquals(orCondition.max);
                            break;
                    }


                } else {
                    switch (orCondition.expressions) {
                        case EQUALS_TEXT_VALUE:
                            output = temp.or().byText().equals(orCondition.value);
                            break;

                        case EQUALS_NUMBER_VALUE:
                            output = temp.or().byText().equals(orCondition.number);
                            break;

                        case CONTAINS:
                            output = temp.or().byText().contains(orCondition.value);
                            break;

                        case STARTS_WITH:
                            output = temp.or().byText().startsWith(orCondition.value);
                            break;

                        case IS_EMPTY:
                            output = temp.or().byText().isEmpty();
                            break;

                        case IS_NUMERIC:
                            output = temp.or().byText().isNumeric();
                            break;

                        case GREATER_THAN:
                            output = temp.or().byText().greaterThan(orCondition.min);
                            break;

                        case GREATER_THAN_OR_EQUALS:
                            output = temp.or().byText().greaterThanOrEquals(orCondition.min);
                            break;

                        case LESS_THAN:
                            output = temp.or().byText().lessThan(orCondition.max);
                            break;

                        case LESS_THAN_OR_EQUALS:
                            output = temp.or().byText().lessThanOrEquals(orCondition.max);
                            break;
                    }

                }
            }
        }

        return output.copy();
    }

    //=====================================

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
                            output = temp.byText().not().equals(andCondition.value);
                            break;
                        case EQUALS_NUMBER_VALUE:
                            output = temp.byText().not().equals(andCondition.number);
                            break;
                        case CONTAINS:
                            output = temp.byText().not().contains(andCondition.value);
                            break;
                        case STARTS_WITH:
                            output = temp.byText().not().startsWith(andCondition.value);
                            break;
                        case IS_EMPTY:
                            output = temp.byText().not().empty();
                            break;
                        case IS_NUMERIC:
                            output = temp.byText().not().numeric();
                            break;
                        case GREATER_THAN:
                            output = temp.byText().not().greaterThan(andCondition.min);
                            break;
                        case GREATER_THAN_OR_EQUALS:
                            output = temp.byText().not().greaterThanOrEquals(andCondition.min);
                            break;
                        case LESS_THAN:
                            output = temp.byText().not().lessThan(andCondition.max);
                            break;
                        case LESS_THAN_OR_EQUALS:
                            output = temp.byText().not().lessThanOrEquals(andCondition.max);
                            break;
                    }
                } else {
                    switch (andCondition.expressions) {
                        case EQUALS_TEXT_VALUE:
                            output = temp.byText().equals(andCondition.value);
                            break;
                        case EQUALS_NUMBER_VALUE:
                            output = temp.byText().equals(andCondition.number);
                            break;
                        case CONTAINS:
                            output = temp.byText().contains(andCondition.value);
                            break;
                        case STARTS_WITH:
                            output = temp.byText().startsWith(andCondition.value);
                            break;
                        case IS_EMPTY:
                            output = temp.byText().isEmpty();
                            break;
                        case IS_NUMERIC:
                            output = temp.byText().isNumeric();
                            break;
                        case GREATER_THAN:
                            output = temp.byText().greaterThan(andCondition.min);
                            break;
                        case GREATER_THAN_OR_EQUALS:
                            output = temp.byText().greaterThanOrEquals(andCondition.min);
                            break;
                        case LESS_THAN:
                            output = temp.byText().lessThan(andCondition.max);
                            break;
                        case LESS_THAN_OR_EQUALS:
                            output = temp.byText().lessThanOrEquals(andCondition.max);
                            break;
                    }
                }
            } else {
                if (!andCondition.isNot) {
                    switch (andCondition.expressions) {
                        case EQUALS_TEXT_VALUE:
                            output = temp.and().byText().not().equals(andCondition.value);
                            break;
                        case EQUALS_NUMBER_VALUE:
                            output = temp.and().byText().not().equals(andCondition.number);
                            break;
                        case CONTAINS:
                            output = temp.and().byText().not().contains(andCondition.value);
                            break;
                        case STARTS_WITH:
                            output = temp.and().byText().not().startsWith(andCondition.value);
                            break;
                        case IS_EMPTY:
                            output = temp.and().byText().not().empty();
                            break;
                        case IS_NUMERIC:
                            output = temp.and().byText().not().numeric();
                            break;
                        case GREATER_THAN:
                            output = temp.and().byText().not().greaterThan(andCondition.min);
                            break;
                        case GREATER_THAN_OR_EQUALS:
                            output = temp.and().byText().not().greaterThanOrEquals(andCondition.min);
                            break;
                        case LESS_THAN:
                            output = temp.and().byText().not().lessThan(andCondition.max);
                            break;
                        case LESS_THAN_OR_EQUALS:
                            output = temp.and().byText().not().lessThanOrEquals(andCondition.max);
                            break;
                    }
                } else {
                    switch (andCondition.expressions) {
                        case EQUALS_TEXT_VALUE:
                            output = temp.and().byText().equals(andCondition.value);
                            break;
                        case EQUALS_NUMBER_VALUE:
                            output = temp.and().byText().equals(andCondition.number);
                            break;
                        case CONTAINS:
                            output = temp.and().byText().contains(andCondition.value);
                            break;
                        case STARTS_WITH:
                            output = temp.and().byText().startsWith(andCondition.value);
                            break;
                        case IS_EMPTY:
                            output = temp.and().byText().isEmpty();
                            break;
                        case IS_NUMERIC:
                            output = temp.and().byText().isNumeric();
                            break;
                        case GREATER_THAN:
                            output = temp.and().byText().greaterThan(andCondition.min);
                            break;
                        case GREATER_THAN_OR_EQUALS:
                            output = temp.and().byText().greaterThanOrEquals(andCondition.min);
                            break;
                        case LESS_THAN:
                            output = temp.and().byText().lessThan(andCondition.max);
                            break;
                        case LESS_THAN_OR_EQUALS:
                            output = temp.and().byText().lessThanOrEquals(andCondition.max);
                            break;
                    }
                }
            }
        }

        return output.copy();
    }


    //======================================

    public XPathy equals(String text) {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String function = transformer.buildFunctionExpression("text()");
        String value = transformer.applyModifiersToValue(text);

        copy.xpath = new _AppendAndOr_(copy).append("not(" + function + "='" + value + "')");

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    public XPathy contains(String text) {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String function = transformer.buildFunctionExpression("text()");
        String value = transformer.applyModifiersToValue(text);

        copy.xpath = new _AppendAndOr_(copy).append("not(contains(" + function + ", '" + value + "'))");

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    public XPathy startsWith(String text) {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String function = transformer.buildFunctionExpression("text()");
        String value = transformer.applyModifiersToValue(text);

        copy.xpath = new _AppendAndOr_(copy).append("not(starts-with(" + function + ", '" + value + "'))");

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    public XPathy empty() {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String function = transformer.buildFunctionExpression("text()");

        copy.xpath = new _AppendAndOr_(copy).append(function + "!=''");

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    public XPathy numeric() {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String function = transformer.buildFunctionExpression("text()");

        copy.xpath = new _AppendAndOr_(copy).append("normalize-space(" + function + ") != ''"  + " and translate(" + function + ", '0123456789', '') != ''");

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    public XPathy equals(Number number) {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String function = transformer.buildFunctionExpression("text()");

        copy.xpath = new _AppendAndOr_(copy).append(function + "='" + number);

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    public XPathy greaterThan(Number number) {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String function = transformer.buildFunctionExpression("text()");

        copy.xpath = new _AppendAndOr_(copy).append(function + " <= " + number);

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    public XPathy greaterThanOrEquals(Number number) {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String function = transformer.buildFunctionExpression("text()");

        copy.xpath = new _AppendAndOr_(copy).append(function + " < " + number);

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    public XPathy lessThan(Number number) {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String function = transformer.buildFunctionExpression("text()");

        copy.xpath = new _AppendAndOr_(copy).append(function + " >= " + number);

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    public XPathy lessThanOrEquals(Number number) {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String function = transformer.buildFunctionExpression("text()");

        copy.xpath = new _AppendAndOr_(copy).append(function + " > " + number);

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }








}
