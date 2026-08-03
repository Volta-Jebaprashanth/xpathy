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
        if (orConditions == null || orConditions.length == 0) {
            return this.xPathy;
        }

        XPathy origin = this.xPathy.copy();

        XPathy template = origin.copy();
        template.xpath = new XPathy().getXpath();
        template.condition = XPathy.Condition.NONE;
        template.is_and_or_condition_appendable = false;

        XPathy group = template.copy();

        for (int i = 0; i < orConditions.length; i++) {
            Or orCondition = orConditions[i];
            XPathy temp = _Multiple_And_Or_Merger_.merge(template, orCondition.xPathy);
            temp = _Multiple_And_Or_Merger_.merge(group, temp).copy();

            if (i == 0) {
                if (!orCondition.isNot) {
                    switch (orCondition.expressions) {
                        case EQUALS_TEXT_VALUE:
                            group = temp.byText().not().equals(orCondition.value);
                            break;

                        case EQUALS_NUMBER_VALUE:
                            group = temp.byText().not().equals(orCondition.number);
                            break;

                        case CONTAINS:
                            group = temp.byText().not().contains(orCondition.value);
                            break;

                        case STARTS_WITH:
                            group = temp.byText().not().startsWith(orCondition.value);
                            break;

                        case IS_EMPTY:
                            group = temp.byText().not().empty();
                            break;

                        case IS_NUMERIC:
                            group = temp.byText().not().numeric();
                            break;

                        case GREATER_THAN:
                            group = temp.byText().not().greaterThan(orCondition.min);
                            break;

                        case GREATER_THAN_OR_EQUALS:
                            group = temp.byText().not().greaterThanOrEquals(orCondition.min);
                            break;

                        case LESS_THAN:
                            group = temp.byText().not().lessThan(orCondition.max);
                            break;

                        case LESS_THAN_OR_EQUALS:
                            group = temp.byText().not().lessThanOrEquals(orCondition.max);
                            break;

                        case HAVE_IT:
                        case BETWEEN:
                            throw new IllegalArgumentException("Unsupported expression for text condition: " + orCondition.expressions);
                    }


                } else {
                    switch (orCondition.expressions) {
                        case EQUALS_TEXT_VALUE:
                            group = temp.byText().equals(orCondition.value);
                            break;

                        case EQUALS_NUMBER_VALUE:
                            group = temp.byText().equals(orCondition.number);
                            break;

                        case CONTAINS:
                            group = temp.byText().contains(orCondition.value);
                            break;

                        case STARTS_WITH:
                            group = temp.byText().startsWith(orCondition.value);
                            break;

                        case IS_EMPTY:
                            group = temp.byText().isEmpty();
                            break;

                        case IS_NUMERIC:
                            group = temp.byText().isNumeric();
                            break;

                        case GREATER_THAN:
                            group = temp.byText().greaterThan(orCondition.min);
                            break;

                        case GREATER_THAN_OR_EQUALS:
                            group = temp.byText().greaterThanOrEquals(orCondition.min);
                            break;

                        case LESS_THAN:
                            group = temp.byText().lessThan(orCondition.max);
                            break;

                        case LESS_THAN_OR_EQUALS:
                            group = temp.byText().lessThanOrEquals(orCondition.max);
                            break;

                        case HAVE_IT:
                        case BETWEEN:
                            throw new IllegalArgumentException("Unsupported expression for text condition: " + orCondition.expressions);
                    }

                }

            } else {
                if (!orCondition.isNot) {
                    switch (orCondition.expressions) {
                        case EQUALS_TEXT_VALUE:
                            group = temp.or().byText().equals(orCondition.value);
                            break;

                        case EQUALS_NUMBER_VALUE:
                            group = temp.or().byText().equals(orCondition.number);
                            break;

                        case CONTAINS:
                            group = temp.or().byText().contains(orCondition.value);
                            break;

                        case STARTS_WITH:
                            group = temp.or().byText().startsWith(orCondition.value);
                            break;

                        case IS_EMPTY:
                            group = temp.or().byText().isEmpty();
                            break;

                        case IS_NUMERIC:
                            group = temp.or().byText().isNumeric();
                            break;

                        case GREATER_THAN:
                            group = temp.or().byText().greaterThan(orCondition.min);
                            break;

                        case GREATER_THAN_OR_EQUALS:
                            group = temp.or().byText().greaterThanOrEquals(orCondition.min);
                            break;

                        case LESS_THAN:
                            group = temp.or().byText().lessThan(orCondition.max);
                            break;

                        case LESS_THAN_OR_EQUALS:
                            group = temp.or().byText().lessThanOrEquals(orCondition.max);
                            break;

                        case HAVE_IT:
                        case BETWEEN:
                            throw new IllegalArgumentException("Unsupported expression for text condition: " + orCondition.expressions);
                    }


                } else {
                    switch (orCondition.expressions) {
                        case EQUALS_TEXT_VALUE:
                            group = temp.or().byText().not().equals(orCondition.value);
                            break;

                        case EQUALS_NUMBER_VALUE:
                            group = temp.or().byText().not().equals(orCondition.number);
                            break;

                        case CONTAINS:
                            group = temp.or().byText().not().contains(orCondition.value);
                            break;

                        case STARTS_WITH:
                            group = temp.or().byText().not().startsWith(orCondition.value);
                            break;

                        case IS_EMPTY:
                            group = temp.or().byText().not().empty();
                            break;

                        case IS_NUMERIC:
                            group = temp.or().byText().not().numeric();
                            break;

                        case GREATER_THAN:
                            group = temp.or().byText().not().greaterThan(orCondition.min);
                            break;

                        case GREATER_THAN_OR_EQUALS:
                            group = temp.or().byText().not().greaterThanOrEquals(orCondition.min);
                            break;

                        case LESS_THAN:
                            group = temp.or().byText().not().lessThan(orCondition.max);
                            break;

                        case LESS_THAN_OR_EQUALS:
                            group = temp.or().byText().not().lessThanOrEquals(orCondition.max);
                            break;

                        case HAVE_IT:
                        case BETWEEN:
                            throw new IllegalArgumentException("Unsupported expression for text condition: " + orCondition.expressions);
                    }

                }
            }
        }

        String groupXpath = group.getXpath();
        String innerCondition = groupXpath.substring(groupXpath.indexOf('[') + 1, groupXpath.length() - 1);
        String combinedCondition = orConditions.length > 1 ? "(" + innerCondition + ")" : innerCondition;

        XPathy result = origin.copy();
        result.xpath = new _AppendAndOr_(result).append(combinedCondition);
        result.is_and_or_condition_appendable = true;
        result.reset_values();

        return result.copy();
    }

    //=====================================

    public XPathy intersect(And... andConditions) {
        if (andConditions == null || andConditions.length == 0) {
            return this.xPathy;
        }

        XPathy origin = this.xPathy.copy();

        XPathy template = origin.copy();
        template.xpath = new XPathy().getXpath();
        template.condition = XPathy.Condition.NONE;
        template.is_and_or_condition_appendable = false;

        XPathy group = template.copy();

        for (int i = 0; i < andConditions.length; i++) {
            And andCondition = andConditions[i];
            XPathy temp = _Multiple_And_Or_Merger_.merge(template, andCondition.xPathy);
            temp = _Multiple_And_Or_Merger_.merge(group, temp).copy();

            if (i == 0) {
                if (!andCondition.isNot) {
                    switch (andCondition.expressions) {
                        case EQUALS_TEXT_VALUE:
                            group = temp.byText().not().equals(andCondition.value);
                            break;
                        case EQUALS_NUMBER_VALUE:
                            group = temp.byText().not().equals(andCondition.number);
                            break;
                        case CONTAINS:
                            group = temp.byText().not().contains(andCondition.value);
                            break;
                        case STARTS_WITH:
                            group = temp.byText().not().startsWith(andCondition.value);
                            break;
                        case IS_EMPTY:
                            group = temp.byText().not().empty();
                            break;
                        case IS_NUMERIC:
                            group = temp.byText().not().numeric();
                            break;
                        case GREATER_THAN:
                            group = temp.byText().not().greaterThan(andCondition.min);
                            break;
                        case GREATER_THAN_OR_EQUALS:
                            group = temp.byText().not().greaterThanOrEquals(andCondition.min);
                            break;
                        case LESS_THAN:
                            group = temp.byText().not().lessThan(andCondition.max);
                            break;
                        case LESS_THAN_OR_EQUALS:
                            group = temp.byText().not().lessThanOrEquals(andCondition.max);
                            break;

                        case HAVE_IT:
                        case BETWEEN:
                            throw new IllegalArgumentException("Unsupported expression for text condition: " + andCondition.expressions);
                    }
                } else {
                    switch (andCondition.expressions) {
                        case EQUALS_TEXT_VALUE:
                            group = temp.byText().equals(andCondition.value);
                            break;
                        case EQUALS_NUMBER_VALUE:
                            group = temp.byText().equals(andCondition.number);
                            break;
                        case CONTAINS:
                            group = temp.byText().contains(andCondition.value);
                            break;
                        case STARTS_WITH:
                            group = temp.byText().startsWith(andCondition.value);
                            break;
                        case IS_EMPTY:
                            group = temp.byText().isEmpty();
                            break;
                        case IS_NUMERIC:
                            group = temp.byText().isNumeric();
                            break;
                        case GREATER_THAN:
                            group = temp.byText().greaterThan(andCondition.min);
                            break;
                        case GREATER_THAN_OR_EQUALS:
                            group = temp.byText().greaterThanOrEquals(andCondition.min);
                            break;
                        case LESS_THAN:
                            group = temp.byText().lessThan(andCondition.max);
                            break;
                        case LESS_THAN_OR_EQUALS:
                            group = temp.byText().lessThanOrEquals(andCondition.max);
                            break;

                        case HAVE_IT:
                        case BETWEEN:
                            throw new IllegalArgumentException("Unsupported expression for text condition: " + andCondition.expressions);
                    }
                }
            } else {
                if (!andCondition.isNot) {
                    switch (andCondition.expressions) {
                        case EQUALS_TEXT_VALUE:
                            group = temp.and().byText().equals(andCondition.value);
                            break;
                        case EQUALS_NUMBER_VALUE:
                            group = temp.and().byText().equals(andCondition.number);
                            break;
                        case CONTAINS:
                            group = temp.and().byText().contains(andCondition.value);
                            break;
                        case STARTS_WITH:
                            group = temp.and().byText().startsWith(andCondition.value);
                            break;
                        case IS_EMPTY:
                            group = temp.and().byText().isEmpty();
                            break;
                        case IS_NUMERIC:
                            group = temp.and().byText().isNumeric();
                            break;
                        case GREATER_THAN:
                            group = temp.and().byText().greaterThan(andCondition.min);
                            break;
                        case GREATER_THAN_OR_EQUALS:
                            group = temp.and().byText().greaterThanOrEquals(andCondition.min);
                            break;
                        case LESS_THAN:
                            group = temp.and().byText().lessThan(andCondition.max);
                            break;
                        case LESS_THAN_OR_EQUALS:
                            group = temp.and().byText().lessThanOrEquals(andCondition.max);
                            break;

                        case HAVE_IT:
                        case BETWEEN:
                            throw new IllegalArgumentException("Unsupported expression for text condition: " + andCondition.expressions);
                    }
                } else {
                    switch (andCondition.expressions) {
                        case EQUALS_TEXT_VALUE:
                            group = temp.and().byText().not().equals(andCondition.value);
                            break;
                        case EQUALS_NUMBER_VALUE:
                            group = temp.and().byText().not().equals(andCondition.number);
                            break;
                        case CONTAINS:
                            group = temp.and().byText().not().contains(andCondition.value);
                            break;
                        case STARTS_WITH:
                            group = temp.and().byText().not().startsWith(andCondition.value);
                            break;
                        case IS_EMPTY:
                            group = temp.and().byText().not().empty();
                            break;
                        case IS_NUMERIC:
                            group = temp.and().byText().not().numeric();
                            break;
                        case GREATER_THAN:
                            group = temp.and().byText().not().greaterThan(andCondition.min);
                            break;
                        case GREATER_THAN_OR_EQUALS:
                            group = temp.and().byText().not().greaterThanOrEquals(andCondition.min);
                            break;
                        case LESS_THAN:
                            group = temp.and().byText().not().lessThan(andCondition.max);
                            break;
                        case LESS_THAN_OR_EQUALS:
                            group = temp.and().byText().not().lessThanOrEquals(andCondition.max);
                            break;

                        case HAVE_IT:
                        case BETWEEN:
                            throw new IllegalArgumentException("Unsupported expression for text condition: " + andCondition.expressions);
                    }
                }
            }
        }

        String groupXpath = group.getXpath();
        String innerCondition = groupXpath.substring(groupXpath.indexOf('[') + 1, groupXpath.length() - 1);
        String combinedCondition = andConditions.length > 1 ? "(" + innerCondition + ")" : innerCondition;

        XPathy result = origin.copy();
        result.xpath = new _AppendAndOr_(result).append(combinedCondition);
        result.is_and_or_condition_appendable = true;
        result.reset_values();

        return result.copy();
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
        String function = transformer.buildFunctionExpression("text()");

        copy.xpath = new _AppendAndOr_(copy).append("not(" + function + " = " + number + ")");

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
