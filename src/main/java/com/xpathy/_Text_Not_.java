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

    public XPathy OR(Or... orConditions) {
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
                            output = temp.TEXT().NOT().equals(orCondition.value);
                            break;

                        case EQUALS_NUMBER_VALUE:
                            output = temp.TEXT().NOT().equals(orCondition.number);
                            break;

                        case CONTAINS:
                            output = temp.TEXT().NOT().contains(orCondition.value);
                            break;

                        case STARTS_WITH:
                            output = temp.TEXT().NOT().startsWith(orCondition.value);
                            break;

                        case IS_EMPTY:
                            output = temp.TEXT().NOT().empty();
                            break;

                        case IS_NUMERIC:
                            output = temp.TEXT().NOT().numeric();
                            break;

                        case GREATER_THAN:
                            output = temp.TEXT().NOT().greaterThan(orCondition.min);
                            break;

                        case GREATER_THAN_OR_EQUALS:
                            output = temp.TEXT().NOT().greaterThanOrEquals(orCondition.min);
                            break;

                        case LESS_THAN:
                            output = temp.TEXT().NOT().lessThan(orCondition.max);
                            break;

                        case LESS_THAN_OR_EQUALS:
                            output = temp.TEXT().NOT().lessThanOrEquals(orCondition.max);
                            break;
                    }


                } else {
                    switch (orCondition.expressions) {
                        case EQUALS_TEXT_VALUE:
                            output = temp.TEXT().equals(orCondition.value);
                            break;

                        case EQUALS_NUMBER_VALUE:
                            output = temp.TEXT().equals(orCondition.number);
                            break;

                        case CONTAINS:
                            output = temp.TEXT().contains(orCondition.value);
                            break;

                        case STARTS_WITH:
                            output = temp.TEXT().startsWith(orCondition.value);
                            break;

                        case IS_EMPTY:
                            output = temp.TEXT().isEmpty();
                            break;

                        case IS_NUMERIC:
                            output = temp.TEXT().isNumeric();
                            break;

                        case GREATER_THAN:
                            output = temp.TEXT().greaterThan(orCondition.min);
                            break;

                        case GREATER_THAN_OR_EQUALS:
                            output = temp.TEXT().greaterThanOrEquals(orCondition.min);
                            break;

                        case LESS_THAN:
                            output = temp.TEXT().lessThan(orCondition.max);
                            break;

                        case LESS_THAN_OR_EQUALS:
                            output = temp.TEXT().lessThanOrEquals(orCondition.max);
                            break;
                    }

                }

            } else {
                if (!orCondition.isNot) {
                    switch (orCondition.expressions) {
                        case EQUALS_TEXT_VALUE:
                            output = temp.OR().TEXT().NOT().equals(orCondition.value);
                            break;

                        case EQUALS_NUMBER_VALUE:
                            output = temp.OR().TEXT().NOT().equals(orCondition.number);
                            break;

                        case CONTAINS:
                            output = temp.OR().TEXT().NOT().contains(orCondition.value);
                            break;

                        case STARTS_WITH:
                            output = temp.OR().TEXT().NOT().startsWith(orCondition.value);
                            break;

                        case IS_EMPTY:
                            output = temp.OR().TEXT().NOT().empty();
                            break;

                        case IS_NUMERIC:
                            output = temp.OR().TEXT().NOT().numeric();
                            break;

                        case GREATER_THAN:
                            output = temp.OR().TEXT().NOT().greaterThan(orCondition.min);
                            break;

                        case GREATER_THAN_OR_EQUALS:
                            output = temp.OR().TEXT().NOT().greaterThanOrEquals(orCondition.min);
                            break;

                        case LESS_THAN:
                            output = temp.OR().TEXT().NOT().lessThan(orCondition.max);
                            break;

                        case LESS_THAN_OR_EQUALS:
                            output = temp.OR().TEXT().NOT().lessThanOrEquals(orCondition.max);
                            break;
                    }


                } else {
                    switch (orCondition.expressions) {
                        case EQUALS_TEXT_VALUE:
                            output = temp.OR().TEXT().equals(orCondition.value);
                            break;

                        case EQUALS_NUMBER_VALUE:
                            output = temp.OR().TEXT().equals(orCondition.number);
                            break;

                        case CONTAINS:
                            output = temp.OR().TEXT().contains(orCondition.value);
                            break;

                        case STARTS_WITH:
                            output = temp.OR().TEXT().startsWith(orCondition.value);
                            break;

                        case IS_EMPTY:
                            output = temp.OR().TEXT().isEmpty();
                            break;

                        case IS_NUMERIC:
                            output = temp.OR().TEXT().isNumeric();
                            break;

                        case GREATER_THAN:
                            output = temp.OR().TEXT().greaterThan(orCondition.min);
                            break;

                        case GREATER_THAN_OR_EQUALS:
                            output = temp.OR().TEXT().greaterThanOrEquals(orCondition.min);
                            break;

                        case LESS_THAN:
                            output = temp.OR().TEXT().lessThan(orCondition.max);
                            break;

                        case LESS_THAN_OR_EQUALS:
                            output = temp.OR().TEXT().lessThanOrEquals(orCondition.max);
                            break;
                    }

                }
            }
        }

        return output.copy();
    }

    //=====================================

    public XPathy AND(And... andConditions) {
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
                            output = temp.TEXT().NOT().equals(andCondition.value);
                            break;
                        case EQUALS_NUMBER_VALUE:
                            output = temp.TEXT().NOT().equals(andCondition.number);
                            break;
                        case CONTAINS:
                            output = temp.TEXT().NOT().contains(andCondition.value);
                            break;
                        case STARTS_WITH:
                            output = temp.TEXT().NOT().startsWith(andCondition.value);
                            break;
                        case IS_EMPTY:
                            output = temp.TEXT().NOT().empty();
                            break;
                        case IS_NUMERIC:
                            output = temp.TEXT().NOT().numeric();
                            break;
                        case GREATER_THAN:
                            output = temp.TEXT().NOT().greaterThan(andCondition.min);
                            break;
                        case GREATER_THAN_OR_EQUALS:
                            output = temp.TEXT().NOT().greaterThanOrEquals(andCondition.min);
                            break;
                        case LESS_THAN:
                            output = temp.TEXT().NOT().lessThan(andCondition.max);
                            break;
                        case LESS_THAN_OR_EQUALS:
                            output = temp.TEXT().NOT().lessThanOrEquals(andCondition.max);
                            break;
                    }
                } else {
                    switch (andCondition.expressions) {
                        case EQUALS_TEXT_VALUE:
                            output = temp.TEXT().equals(andCondition.value);
                            break;
                        case EQUALS_NUMBER_VALUE:
                            output = temp.TEXT().equals(andCondition.number);
                            break;
                        case CONTAINS:
                            output = temp.TEXT().contains(andCondition.value);
                            break;
                        case STARTS_WITH:
                            output = temp.TEXT().startsWith(andCondition.value);
                            break;
                        case IS_EMPTY:
                            output = temp.TEXT().isEmpty();
                            break;
                        case IS_NUMERIC:
                            output = temp.TEXT().isNumeric();
                            break;
                        case GREATER_THAN:
                            output = temp.TEXT().greaterThan(andCondition.min);
                            break;
                        case GREATER_THAN_OR_EQUALS:
                            output = temp.TEXT().greaterThanOrEquals(andCondition.min);
                            break;
                        case LESS_THAN:
                            output = temp.TEXT().lessThan(andCondition.max);
                            break;
                        case LESS_THAN_OR_EQUALS:
                            output = temp.TEXT().lessThanOrEquals(andCondition.max);
                            break;
                    }
                }
            } else {
                if (!andCondition.isNot) {
                    switch (andCondition.expressions) {
                        case EQUALS_TEXT_VALUE:
                            output = temp.AND().TEXT().NOT().equals(andCondition.value);
                            break;
                        case EQUALS_NUMBER_VALUE:
                            output = temp.AND().TEXT().NOT().equals(andCondition.number);
                            break;
                        case CONTAINS:
                            output = temp.AND().TEXT().NOT().contains(andCondition.value);
                            break;
                        case STARTS_WITH:
                            output = temp.AND().TEXT().NOT().startsWith(andCondition.value);
                            break;
                        case IS_EMPTY:
                            output = temp.AND().TEXT().NOT().empty();
                            break;
                        case IS_NUMERIC:
                            output = temp.AND().TEXT().NOT().numeric();
                            break;
                        case GREATER_THAN:
                            output = temp.AND().TEXT().NOT().greaterThan(andCondition.min);
                            break;
                        case GREATER_THAN_OR_EQUALS:
                            output = temp.AND().TEXT().NOT().greaterThanOrEquals(andCondition.min);
                            break;
                        case LESS_THAN:
                            output = temp.AND().TEXT().NOT().lessThan(andCondition.max);
                            break;
                        case LESS_THAN_OR_EQUALS:
                            output = temp.AND().TEXT().NOT().lessThanOrEquals(andCondition.max);
                            break;
                    }
                } else {
                    switch (andCondition.expressions) {
                        case EQUALS_TEXT_VALUE:
                            output = temp.AND().TEXT().equals(andCondition.value);
                            break;
                        case EQUALS_NUMBER_VALUE:
                            output = temp.AND().TEXT().equals(andCondition.number);
                            break;
                        case CONTAINS:
                            output = temp.AND().TEXT().contains(andCondition.value);
                            break;
                        case STARTS_WITH:
                            output = temp.AND().TEXT().startsWith(andCondition.value);
                            break;
                        case IS_EMPTY:
                            output = temp.AND().TEXT().isEmpty();
                            break;
                        case IS_NUMERIC:
                            output = temp.AND().TEXT().isNumeric();
                            break;
                        case GREATER_THAN:
                            output = temp.AND().TEXT().greaterThan(andCondition.min);
                            break;
                        case GREATER_THAN_OR_EQUALS:
                            output = temp.AND().TEXT().greaterThanOrEquals(andCondition.min);
                            break;
                        case LESS_THAN:
                            output = temp.AND().TEXT().lessThan(andCondition.max);
                            break;
                        case LESS_THAN_OR_EQUALS:
                            output = temp.AND().TEXT().lessThanOrEquals(andCondition.max);
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
