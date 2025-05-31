package com.xpathy;

public class __Having_Text_Length_Not_ {

    protected XPathy xPathy;

    protected __Having_Text_Length_Not_(XPathy xPathy){
        this.xPathy = xPathy;
    }
    protected __Having_Text_Length_Not_ copy(){
        return new __Having_Text_Length_Not_(this.xPathy);
    }

    private String wrappedLengthFunction() {
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(this.xPathy);
        return "string-length(" + transformer.buildFunctionExpression("text()") + ")";
    }


    public XPathy equals(int expectedLength) {
        XPathy copy = this.xPathy.copy();

        copy.xpath = new _AppendAndOr_(copy).append(
                this.xPathy.having_condition_prefix + "["+
                wrappedLengthFunction() + " != " + expectedLength + "]");

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    public XPathy greaterThan(int minLength) {
        XPathy copy = this.xPathy.copy();

        copy.xpath = new _AppendAndOr_(copy).append(
                this.xPathy.having_condition_prefix + "["+
                wrappedLengthFunction() + " <= " + minLength + "]");

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    public XPathy greaterThanOrEquals(int minLength) {
        XPathy copy = this.xPathy.copy();

        copy.xpath = new _AppendAndOr_(copy).append(
                this.xPathy.having_condition_prefix + "["+
                wrappedLengthFunction() + " < " + minLength + "]");

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    public XPathy lessThan(int maxLength) {
        XPathy copy = this.xPathy.copy();

        copy.xpath = new _AppendAndOr_(copy).append(
                this.xPathy.having_condition_prefix + "["+
                wrappedLengthFunction() + " >= " + maxLength + "]");

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    public XPathy lessThanOrEquals(int maxLength) {
        XPathy copy = this.xPathy.copy();

        copy.xpath = new _AppendAndOr_(copy).append(
                this.xPathy.having_condition_prefix + "["+
                wrappedLengthFunction() + " > " + maxLength + "]");

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

}
