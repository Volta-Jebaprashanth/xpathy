package com.xpathy;

public class _Attribute_ {

    protected XPathy xPathy;
    protected String attribute;

    protected _Attribute_(XPathy xPathy, Attribute attribute) {
        this.xPathy = xPathy;
        this.attribute = attribute.toString();
    }

    protected _Attribute_(XPathy xPathy, String attribute) {
        this.xPathy = xPathy;
        this.attribute = attribute;
    }

    protected _Attribute_ copy() {
        return new _Attribute_(this.xPathy, this.attribute);
    }

    public _Attribute_Not_ NOT() {
        return new _Attribute_Not_(this.xPathy, this.attribute);
    }

    public _Attribute_Length_ LENGTH() {
        return new _Attribute_Length_(this.xPathy, this.attribute);
    }


    public _Attribute_ TRIM() {
        _Attribute_ copy = this.copy();
        copy.xPathy.is_trim = true;
        return copy;
    }


    public _Attribute_ NORMALIZE_SPACE() {
        _Attribute_ copy = this.copy();
        copy.xPathy.is_normalize_space = true;
        return copy;
    }

    public _Attribute_ CASE(Case thisCase) {
        _Attribute_ copy = this.copy();
        copy.xPathy = new _TranslateBuilder_(this.xPathy).setCase(thisCase);
        return copy;
    }

    public _Attribute_ REMOVE(Only... onlyItems) {
        _Attribute_ copy = this.copy();
        copy.xPathy = new _TranslateBuilder_(this.xPathy).setRemoveChars(onlyItems);
        return copy;
    }

    public _Attribute_ KEEP(Only... onlyItems) {
        _Attribute_ copy = this.copy();
        copy.xPathy = new _TranslateBuilder_(this.xPathy).setKeepOnlyChars(onlyItems);
        return copy;
    }

    public _Attribute_ TRANSLATE(String charactersToReplace, String replacementCharacters) {
        _Attribute_ copy = this.copy();
        copy.xPathy = new _TranslateBuilder_(this.xPathy).setTranslate(charactersToReplace, replacementCharacters);
        return copy;
    }

    //=============================================================================

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
                            output = temp.ATTRIBUTE(Attribute.CUSTOM(this.attribute)).equals(orCondition.value);
                            break;

                        case EQUALS_NUMBER_VALUE:
                            output = temp.ATTRIBUTE(Attribute.CUSTOM(this.attribute)).equals(orCondition.number);
                            break;

                        case CONTAINS:
                            output = temp.ATTRIBUTE(Attribute.CUSTOM(this.attribute)).contains(orCondition.value);
                            break;

                        case STARTS_WITH:
                            output = temp.ATTRIBUTE(Attribute.CUSTOM(this.attribute)).startsWith(orCondition.value);
                            break;

                        case IS_EMPTY:
                            output = temp.ATTRIBUTE(Attribute.CUSTOM(this.attribute)).isEmpty();
                            break;

                        case IS_NUMERIC:
                            output = temp.ATTRIBUTE(Attribute.CUSTOM(this.attribute)).isNumeric();
                            break;

                        case GREATER_THAN:
                            output = temp.ATTRIBUTE(Attribute.CUSTOM(this.attribute)).greaterThan(orCondition.min);
                            break;

                        case GREATER_THAN_OR_EQUALS:
                            output = temp.ATTRIBUTE(Attribute.CUSTOM(this.attribute)).greaterThanOrEquals(orCondition.min);
                            break;

                        case LESS_THAN:
                            output = temp.ATTRIBUTE(Attribute.CUSTOM(this.attribute)).lessThan(orCondition.max);
                            break;

                        case LESS_THAN_OR_EQUALS:
                            output = temp.ATTRIBUTE(Attribute.CUSTOM(this.attribute)).lessThanOrEquals(orCondition.max);
                            break;

                        case HAVE_IT:
                            output = temp.ATTRIBUTE(Attribute.CUSTOM(this.attribute)).haveIt();
                            break;

                        case BETWEEN:
                            output = temp.ATTRIBUTE(Attribute.CUSTOM(this.attribute)).between(orCondition.min, orCondition.max);
                            break;
                    }


                } else {
                    switch (orCondition.expressions) {
                        case EQUALS_TEXT_VALUE:
                            output = temp.ATTRIBUTE(Attribute.CUSTOM(this.attribute)).NOT().equals(orCondition.value);
                            break;

                        case EQUALS_NUMBER_VALUE:
                            output = temp.ATTRIBUTE(Attribute.CUSTOM(this.attribute)).NOT().equals(orCondition.number);
                            break;

                        case CONTAINS:
                            output = temp.ATTRIBUTE(Attribute.CUSTOM(this.attribute)).NOT().contains(orCondition.value);
                            break;

                        case STARTS_WITH:
                            output = temp.ATTRIBUTE(Attribute.CUSTOM(this.attribute)).NOT().startsWith(orCondition.value);
                            break;

                        case IS_EMPTY:
                            output = temp.ATTRIBUTE(Attribute.CUSTOM(this.attribute)).NOT().empty();
                            break;

                        case IS_NUMERIC:
                            output = temp.ATTRIBUTE(Attribute.CUSTOM(this.attribute)).NOT().numeric();
                            break;

                        case GREATER_THAN:
                            output = temp.ATTRIBUTE(Attribute.CUSTOM(this.attribute)).NOT().greaterThan(orCondition.min);
                            break;

                        case GREATER_THAN_OR_EQUALS:
                            output = temp.ATTRIBUTE(Attribute.CUSTOM(this.attribute)).NOT().greaterThanOrEquals(orCondition.min);
                            break;

                        case LESS_THAN:
                            output = temp.ATTRIBUTE(Attribute.CUSTOM(this.attribute)).NOT().lessThan(orCondition.max);
                            break;

                        case LESS_THAN_OR_EQUALS:
                            output = temp.ATTRIBUTE(Attribute.CUSTOM(this.attribute)).NOT().lessThanOrEquals(orCondition.max);
                            break;

                        case HAVE_IT:
                            output = temp.ATTRIBUTE(Attribute.CUSTOM(this.attribute)).NOT().haveIt();
                            break;

                        case BETWEEN:
                            output = temp.ATTRIBUTE(Attribute.CUSTOM(this.attribute)).NOT().between(orCondition.min, orCondition.max);
                            break;
                    }

                }

            } else {
                if (!orCondition.isNot) {
                    switch (orCondition.expressions) {
                        case EQUALS_TEXT_VALUE:
                            output = temp.OR().ATTRIBUTE(Attribute.CUSTOM(this.attribute)).equals(orCondition.value);
                            break;

                        case EQUALS_NUMBER_VALUE:
                            output = temp.OR().ATTRIBUTE(Attribute.CUSTOM(this.attribute)).equals(orCondition.number);
                            break;

                        case CONTAINS:
                            output = temp.OR().ATTRIBUTE(Attribute.CUSTOM(this.attribute)).contains(orCondition.value);
                            break;

                        case STARTS_WITH:
                            output = temp.OR().ATTRIBUTE(Attribute.CUSTOM(this.attribute)).startsWith(orCondition.value);
                            break;

                        case IS_EMPTY:
                            output = temp.OR().ATTRIBUTE(Attribute.CUSTOM(this.attribute)).isEmpty();
                            break;

                        case IS_NUMERIC:
                            output = temp.OR().ATTRIBUTE(Attribute.CUSTOM(this.attribute)).isNumeric();
                            break;

                        case GREATER_THAN:
                            output = temp.OR().ATTRIBUTE(Attribute.CUSTOM(this.attribute)).greaterThan(orCondition.min);
                            break;

                        case GREATER_THAN_OR_EQUALS:
                            output = temp.OR().ATTRIBUTE(Attribute.CUSTOM(this.attribute)).greaterThanOrEquals(orCondition.min);
                            break;

                        case LESS_THAN:
                            output = temp.OR().ATTRIBUTE(Attribute.CUSTOM(this.attribute)).lessThan(orCondition.max);
                            break;

                        case LESS_THAN_OR_EQUALS:
                            output = temp.OR().ATTRIBUTE(Attribute.CUSTOM(this.attribute)).lessThanOrEquals(orCondition.max);
                            break;

                        case HAVE_IT:
                            output = temp.OR().ATTRIBUTE(Attribute.CUSTOM(this.attribute)).haveIt();
                            break;

                        case BETWEEN:
                            output = temp.OR().ATTRIBUTE(Attribute.CUSTOM(this.attribute)).between(orCondition.min, orCondition.max);
                            break;
                    }


                } else {
                    switch (orCondition.expressions) {
                        case EQUALS_TEXT_VALUE:
                            output = temp.OR().ATTRIBUTE(Attribute.CUSTOM(this.attribute)).NOT().equals(orCondition.value);
                            break;

                        case EQUALS_NUMBER_VALUE:
                            output = temp.OR().ATTRIBUTE(Attribute.CUSTOM(this.attribute)).NOT().equals(orCondition.number);
                            break;

                        case CONTAINS:
                            output = temp.OR().ATTRIBUTE(Attribute.CUSTOM(this.attribute)).NOT().contains(orCondition.value);
                            break;

                        case STARTS_WITH:
                            output = temp.OR().ATTRIBUTE(Attribute.CUSTOM(this.attribute)).NOT().startsWith(orCondition.value);
                            break;

                        case IS_EMPTY:
                            output = temp.OR().ATTRIBUTE(Attribute.CUSTOM(this.attribute)).NOT().empty();
                            break;

                        case IS_NUMERIC:
                            output = temp.OR().ATTRIBUTE(Attribute.CUSTOM(this.attribute)).NOT().numeric();
                            break;

                        case GREATER_THAN:
                            output = temp.OR().ATTRIBUTE(Attribute.CUSTOM(this.attribute)).NOT().greaterThan(orCondition.min);
                            break;

                        case GREATER_THAN_OR_EQUALS:
                            output = temp.OR().ATTRIBUTE(Attribute.CUSTOM(this.attribute)).NOT().greaterThanOrEquals(orCondition.min);
                            break;

                        case LESS_THAN:
                            output = temp.OR().ATTRIBUTE(Attribute.CUSTOM(this.attribute)).NOT().lessThan(orCondition.max);
                            break;

                        case LESS_THAN_OR_EQUALS:
                            output = temp.OR().ATTRIBUTE(Attribute.CUSTOM(this.attribute)).NOT().lessThanOrEquals(orCondition.max);
                            break;

                        case HAVE_IT:
                            output = temp.OR().ATTRIBUTE(Attribute.CUSTOM(this.attribute)).NOT().haveIt();
                            break;

                        case BETWEEN:
                            output = temp.OR().ATTRIBUTE(Attribute.CUSTOM(this.attribute)).NOT().between(orCondition.min, orCondition.max);
                            break;
                    }

                }
            }
        }

        return output.copy();
    }

    //=============================================================================

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
                            output = temp.ATTRIBUTE(Attribute.CUSTOM(this.attribute)).equals(andCondition.value);
                            break;
                        case EQUALS_NUMBER_VALUE:
                            output = temp.ATTRIBUTE(Attribute.CUSTOM(this.attribute)).equals(andCondition.number);
                            break;
                        case CONTAINS:
                            output = temp.ATTRIBUTE(Attribute.CUSTOM(this.attribute)).contains(andCondition.value);
                            break;
                        case STARTS_WITH:
                            output = temp.ATTRIBUTE(Attribute.CUSTOM(this.attribute)).startsWith(andCondition.value);
                            break;
                        case IS_EMPTY:
                            output = temp.ATTRIBUTE(Attribute.CUSTOM(this.attribute)).isEmpty();
                            break;
                        case IS_NUMERIC:
                            output = temp.ATTRIBUTE(Attribute.CUSTOM(this.attribute)).isNumeric();
                            break;
                        case GREATER_THAN:
                            output = temp.ATTRIBUTE(Attribute.CUSTOM(this.attribute)).greaterThan(andCondition.min);
                            break;
                        case GREATER_THAN_OR_EQUALS:
                            output = temp.ATTRIBUTE(Attribute.CUSTOM(this.attribute)).greaterThanOrEquals(andCondition.min);
                            break;
                        case LESS_THAN:
                            output = temp.ATTRIBUTE(Attribute.CUSTOM(this.attribute)).lessThan(andCondition.max);
                            break;
                        case LESS_THAN_OR_EQUALS:
                            output = temp.ATTRIBUTE(Attribute.CUSTOM(this.attribute)).lessThanOrEquals(andCondition.max);
                            break;
                        case HAVE_IT:
                            output = temp.ATTRIBUTE(Attribute.CUSTOM(this.attribute)).haveIt();
                            break;
                        case BETWEEN:
                            output = temp.ATTRIBUTE(Attribute.CUSTOM(this.attribute)).between(andCondition.min, andCondition.max);
                            break;
                    }
                } else {
                    switch (andCondition.expressions) {
                        case EQUALS_TEXT_VALUE:
                            output = temp.ATTRIBUTE(Attribute.CUSTOM(this.attribute)).NOT().equals(andCondition.value);
                            break;
                        case EQUALS_NUMBER_VALUE:
                            output = temp.ATTRIBUTE(Attribute.CUSTOM(this.attribute)).NOT().equals(andCondition.number);
                            break;
                        case CONTAINS:
                            output = temp.ATTRIBUTE(Attribute.CUSTOM(this.attribute)).NOT().contains(andCondition.value);
                            break;
                        case STARTS_WITH:
                            output = temp.ATTRIBUTE(Attribute.CUSTOM(this.attribute)).NOT().startsWith(andCondition.value);
                            break;
                        case IS_EMPTY:
                            output = temp.ATTRIBUTE(Attribute.CUSTOM(this.attribute)).NOT().empty();
                            break;
                        case IS_NUMERIC:
                            output = temp.ATTRIBUTE(Attribute.CUSTOM(this.attribute)).NOT().numeric();
                            break;
                        case GREATER_THAN:
                            output = temp.ATTRIBUTE(Attribute.CUSTOM(this.attribute)).NOT().greaterThan(andCondition.min);
                            break;
                        case GREATER_THAN_OR_EQUALS:
                            output = temp.ATTRIBUTE(Attribute.CUSTOM(this.attribute)).NOT().greaterThanOrEquals(andCondition.min);
                            break;
                        case LESS_THAN:
                            output = temp.ATTRIBUTE(Attribute.CUSTOM(this.attribute)).NOT().lessThan(andCondition.max);
                            break;
                        case LESS_THAN_OR_EQUALS:
                            output = temp.ATTRIBUTE(Attribute.CUSTOM(this.attribute)).NOT().lessThanOrEquals(andCondition.max);
                            break;
                        case HAVE_IT:
                            output = temp.ATTRIBUTE(Attribute.CUSTOM(this.attribute)).NOT().haveIt();
                            break;
                        case BETWEEN:
                            output = temp.ATTRIBUTE(Attribute.CUSTOM(this.attribute)).NOT().between(andCondition.min, andCondition.max);
                            break;
                    }
                }
            } else {
                if (!andCondition.isNot) {
                    switch (andCondition.expressions) {
                        case EQUALS_TEXT_VALUE:
                            output = temp.AND().ATTRIBUTE(Attribute.CUSTOM(this.attribute)).equals(andCondition.value);
                            break;
                        case EQUALS_NUMBER_VALUE:
                            output = temp.AND().ATTRIBUTE(Attribute.CUSTOM(this.attribute)).equals(andCondition.number);
                            break;
                        case CONTAINS:
                            output = temp.AND().ATTRIBUTE(Attribute.CUSTOM(this.attribute)).contains(andCondition.value);
                            break;
                        case STARTS_WITH:
                            output = temp.AND().ATTRIBUTE(Attribute.CUSTOM(this.attribute)).startsWith(andCondition.value);
                            break;
                        case IS_EMPTY:
                            output = temp.AND().ATTRIBUTE(Attribute.CUSTOM(this.attribute)).isEmpty();
                            break;
                        case IS_NUMERIC:
                            output = temp.AND().ATTRIBUTE(Attribute.CUSTOM(this.attribute)).isNumeric();
                            break;
                        case GREATER_THAN:
                            output = temp.AND().ATTRIBUTE(Attribute.CUSTOM(this.attribute)).greaterThan(andCondition.min);
                            break;
                        case GREATER_THAN_OR_EQUALS:
                            output = temp.AND().ATTRIBUTE(Attribute.CUSTOM(this.attribute)).greaterThanOrEquals(andCondition.min);
                            break;
                        case LESS_THAN:
                            output = temp.AND().ATTRIBUTE(Attribute.CUSTOM(this.attribute)).lessThan(andCondition.max);
                            break;
                        case LESS_THAN_OR_EQUALS:
                            output = temp.AND().ATTRIBUTE(Attribute.CUSTOM(this.attribute)).lessThanOrEquals(andCondition.max);
                            break;
                        case HAVE_IT:
                            output = temp.AND().ATTRIBUTE(Attribute.CUSTOM(this.attribute)).haveIt();
                            break;
                        case BETWEEN:
                            output = temp.AND().ATTRIBUTE(Attribute.CUSTOM(this.attribute)).between(andCondition.min, andCondition.max);
                            break;
                    }
                } else {
                    switch (andCondition.expressions) {
                        case EQUALS_TEXT_VALUE:
                            output = temp.AND().ATTRIBUTE(Attribute.CUSTOM(this.attribute)).NOT().equals(andCondition.value);
                            break;
                        case EQUALS_NUMBER_VALUE:
                            output = temp.AND().ATTRIBUTE(Attribute.CUSTOM(this.attribute)).NOT().equals(andCondition.number);
                            break;
                        case CONTAINS:
                            output = temp.AND().ATTRIBUTE(Attribute.CUSTOM(this.attribute)).NOT().contains(andCondition.value);
                            break;
                        case STARTS_WITH:
                            output = temp.AND().ATTRIBUTE(Attribute.CUSTOM(this.attribute)).NOT().startsWith(andCondition.value);
                            break;
                        case IS_EMPTY:
                            output = temp.AND().ATTRIBUTE(Attribute.CUSTOM(this.attribute)).NOT().empty();
                            break;
                        case IS_NUMERIC:
                            output = temp.AND().ATTRIBUTE(Attribute.CUSTOM(this.attribute)).NOT().numeric();
                            break;
                        case GREATER_THAN:
                            output = temp.AND().ATTRIBUTE(Attribute.CUSTOM(this.attribute)).NOT().greaterThan(andCondition.min);
                            break;
                        case GREATER_THAN_OR_EQUALS:
                            output = temp.AND().ATTRIBUTE(Attribute.CUSTOM(this.attribute)).NOT().greaterThanOrEquals(andCondition.min);
                            break;
                        case LESS_THAN:
                            output = temp.AND().ATTRIBUTE(Attribute.CUSTOM(this.attribute)).NOT().lessThan(andCondition.max);
                            break;
                        case LESS_THAN_OR_EQUALS:
                            output = temp.AND().ATTRIBUTE(Attribute.CUSTOM(this.attribute)).NOT().lessThanOrEquals(andCondition.max);
                            break;
                        case HAVE_IT:
                            output = temp.AND().ATTRIBUTE(Attribute.CUSTOM(this.attribute)).NOT().haveIt();
                            break;
                        case BETWEEN:
                            output = temp.AND().ATTRIBUTE(Attribute.CUSTOM(this.attribute)).NOT().between(andCondition.min, andCondition.max);
                            break;
                    }
                }
            }
        }

        return output.copy();
    }


    //============================================================

    public XPathy haveIt() {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String function = transformer.buildFunctionExpression("@" + this.attribute);

        copy.xpath = new _AppendAndOr_(copy).append(function);

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    public XPathy equals(String equalValue) {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String function = transformer.buildFunctionExpression("@" + this.attribute);
        String value = transformer.applyModifiersToValue(equalValue);

        copy.xpath = new _AppendAndOr_(copy).append(function + "='" + value + "'");

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    public XPathy contains(String partialValue) {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String function = transformer.buildFunctionExpression("@" + this.attribute);
        String value = transformer.applyModifiersToValue(partialValue);

        copy.xpath = new _AppendAndOr_(copy).append("contains(" + function + ", '" + value + "')");

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    public XPathy startsWith(String prefix) {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String function = transformer.buildFunctionExpression("@" + this.attribute);
        String value = transformer.applyModifiersToValue(prefix);

        copy.xpath = new _AppendAndOr_(copy).append("starts-with(" + function + ", '" + value + "')");

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    public XPathy isEmpty() {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String function = transformer.buildFunctionExpression("normalize-space(@" + this.attribute + ")");

        copy.xpath = new _AppendAndOr_(copy).append(function + "=''");

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    public XPathy isNumeric() {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String function = transformer.buildFunctionExpression("@" + this.attribute);

        copy.xpath = new _AppendAndOr_(copy).append("string-length(" + function + ") > 0 and not(translate(" + function + ", '0123456789', '') != '')");

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }


    public XPathy equals(Number number) {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String attr = transformer.buildFunctionExpression("@" + this.attribute);

        copy.xpath = new _AppendAndOr_(copy).append(attr + " = " + number);

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    public XPathy greaterThan(Number number) {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String attr = transformer.buildFunctionExpression("@" + this.attribute);

        copy.xpath = new _AppendAndOr_(copy).append(attr + " > " + number);

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    public XPathy greaterThanOrEquals(Number number) {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String attr = transformer.buildFunctionExpression("@" + this.attribute);

        copy.xpath = new _AppendAndOr_(copy).append(attr + " >= " + number);

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    public XPathy lessThan(Number number) {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String attr = transformer.buildFunctionExpression("@" + this.attribute);

        copy.xpath = new _AppendAndOr_(copy).append(attr + " < " + number);

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    public XPathy lessThanOrEquals(Number number) {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String attr = transformer.buildFunctionExpression("@" + this.attribute);

        copy.xpath = new _AppendAndOr_(copy).append(attr + " <= " + number);

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    public XPathy between(Number min, Number max) {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String attr = transformer.buildFunctionExpression("@" + this.attribute);

        String expression = " ( " + attr + " > " + min + " and " + attr + " < " + max + " ) ";
        copy.xpath = new _AppendAndOr_(copy).append(expression);

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }


}
