package com.xpathy;

public class _Number_Not_ {

    protected XPathy xPathy;

    protected _Number_Not_(XPathy xPathy) {
        this.xPathy = xPathy;
    }

    protected _Number_Not_(_Number_Not_ _Number_Not_) {
        this.xPathy = _Number_Not_.xPathy;
    }

    protected _Number_Not_ copy() {
        return new _Number_Not_(this);
    }

    private XPathy buildNumberCondition(String operator, Number number) {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        // Pass raw text() into the transformer first
        String transformedText = transformer.buildFunctionExpression("text()");
        // Then wrap it in number(...)
        String function = "number(" + transformedText + ")";

        copy.xpath = new _AppendAndOr_(copy).append(function + " " + operator + " " + number);

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }


    public XPathy equals(Number number) {
        return buildNumberCondition("!=", number);
    }

    public XPathy greaterThan(Number number) {
        return buildNumberCondition("<=", number);
    }

    public XPathy greaterThanOrEquals(Number number) {
        return buildNumberCondition("<", number);
    }

    public XPathy lessThan(Number number) {
        return buildNumberCondition(">=", number);
    }

    public XPathy lessThanOrEquals(Number number) {
        return buildNumberCondition(">", number);
    }

    public XPathy between(Number min, Number max) {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String transformedText = transformer.buildFunctionExpression("text()");
        String function = "number(" + transformedText + ")";

        copy.xpath = new _AppendAndOr_(copy).append(function + " <= " + min + " or " + function + " >= " + max);

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }


}
