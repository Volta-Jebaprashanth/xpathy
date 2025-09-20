package com.xpathy;

public class _Text_ {

    private static final String BASE_FUNCTION = "text()";

    protected XPathy xPathy;

    protected _Text_(XPathy xPathy) {
        this.xPathy = xPathy;
    }

    protected _Text_(_Text_ text) {
        this.xPathy = text.xPathy;
    }

    protected _Text_ copy() {
        return new _Text_(this);
    }

    public _Text_Length_ byLength() {
        return new _Text_Length_(this.xPathy);
    }

    public _Text_Not_ not() {
        return new _Text_Not_(this.xPathy);
    }


    public _Text_ withTrim() {
        _Text_ copy = this.copy();
        copy.xPathy.is_trim = true;
        return copy;
    }

    public _Text_ withNormalizeSpace() {
        _Text_ copy = this.copy();
        copy.xPathy.is_normalize_space = true;
        return copy;
    }

    public _Text_ withCase(Case thisCase) {
        _Text_ copy = this.copy();
        copy.xPathy = new _TranslateBuilder_(this.xPathy).setCase(thisCase);
        return copy;
    }

    public _Text_ withRemoveOnly(Only... onlyItems) {
        _Text_ copy = this.copy();
        copy.xPathy = new _TranslateBuilder_(this.xPathy).setRemoveChars(onlyItems);
        return copy;
    }


    public _Text_ withKeepOnly(Only... onlyItems) {
        _Text_ copy = this.copy();
        copy.xPathy = new _TranslateBuilder_(this.xPathy).setKeepOnlyChars(onlyItems);
        return copy;
    }

    public _Text_ withTranslate(String charactersToReplace, String replacementCharacters) {
        _Text_ copy = this.copy();
        copy.xPathy = new _TranslateBuilder_(this.xPathy).setTranslate(charactersToReplace, replacementCharacters);
        return copy;
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


                } else {
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

                }

            } else {
                if (!orCondition.isNot) {
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


                } else {
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
                } else {
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
                }
            } else {
                if (!andCondition.isNot) {
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
                } else {
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
                }
            }
        }

        return output.copy();
    }

    //=====================================


    public XPathy equals(String equalText) {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String function = transformer.buildFunctionExpression(BASE_FUNCTION);
        String value = transformer.applyModifiersToValue(equalText);

        copy.xpath = new _AppendAndOr_(copy).append(function + " = '" + value + "'");

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }


    public XPathy contains(String partialText) {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String function = transformer.buildFunctionExpression(BASE_FUNCTION);
        String value = transformer.applyModifiersToValue(partialText);

        copy.xpath = new _AppendAndOr_(copy).append("contains(" + function + ", '" + value + "')");

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    public XPathy startsWith(String prefixText) {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String function = transformer.buildFunctionExpression(BASE_FUNCTION);
        String value = transformer.applyModifiersToValue(prefixText);

        copy.xpath = new _AppendAndOr_(copy).append("starts-with(" + function + ", '" + value + "')");

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    public XPathy isEmpty() {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);

        // Use normalize-space to handle missing or whitespace-only text nodes
        String function = transformer.buildFunctionExpression("normalize-space(text())");

        copy.xpath = new _AppendAndOr_(copy).append(function + "=''");

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    public XPathy isNumeric() {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String function = transformer.buildFunctionExpression(BASE_FUNCTION);

        copy.xpath = new _AppendAndOr_(copy).append("string-length(" + function + ") > 0 and not(translate(" + function + ", '0123456789', '') != '')");

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    public XPathy equals(Number number) {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String function = transformer.buildFunctionExpression(BASE_FUNCTION);

        copy.xpath = new _AppendAndOr_(copy).append(function + " = " + number);

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    public XPathy greaterThan(Number number) {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String function = transformer.buildFunctionExpression(BASE_FUNCTION);

        copy.xpath = new _AppendAndOr_(copy).append(function + " > " + number);

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    public XPathy greaterThanOrEquals(Number number) {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String function = transformer.buildFunctionExpression(BASE_FUNCTION);

        copy.xpath =new _AppendAndOr_(copy).append(function + " >= " + number);

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    public XPathy lessThan(Number number) {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String function = transformer.buildFunctionExpression(BASE_FUNCTION);

        copy.xpath =new _AppendAndOr_(copy).append(function + " < " + number);

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    public XPathy lessThanOrEquals(Number number) {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String function = transformer.buildFunctionExpression(BASE_FUNCTION);

        copy.xpath =new _AppendAndOr_(copy).append(function + " <= " + number);

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

}
