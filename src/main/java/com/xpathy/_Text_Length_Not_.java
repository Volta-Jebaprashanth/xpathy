package com.xpathy;

public class _Text_Length_Not_ {

    protected XPathy xPathy;

    protected _Text_Length_Not_(XPathy xPathy) {
        this.xPathy = xPathy;
    }

    protected _Text_Length_Not_(_Text_Length_Not_ text) {
        this.xPathy = text.xPathy;
    }

    protected _Text_Length_Not_ copy() {
        return new _Text_Length_Not_(this);
    }


    private String wrappedLengthFunction() {
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(this.xPathy);
        return "string-length(" + transformer.buildFunctionExpression("text()") + ")";
    }


    public XPathy equals(int expectedLength) {
        XPathy copy = this.xPathy.copy();

        copy.xpath = new _AppendAndOr_(copy).append(wrappedLengthFunction() + " != " + expectedLength);

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    public XPathy greaterThan(int minLength) {
        XPathy copy = this.xPathy.copy();

        copy.xpath = new _AppendAndOr_(copy).append(wrappedLengthFunction() + " <= " + minLength);

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    public XPathy greaterThanOrEquals(int minLength) {
        XPathy copy = this.xPathy.copy();

        copy.xpath = new _AppendAndOr_(copy).append(wrappedLengthFunction() + " < " + minLength);

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    public XPathy lessThan(int maxLength) {
        XPathy copy = this.xPathy.copy();

        copy.xpath = new _AppendAndOr_(copy).append(wrappedLengthFunction() + " >= " + maxLength);

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    public XPathy lessThanOrEquals(int maxLength) {
        XPathy copy = this.xPathy.copy();

        copy.xpath = new _AppendAndOr_(copy).append(wrappedLengthFunction() + " > " + maxLength);

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

}
