package com.xpathy;

public class __Having_Attribute_Length_Not_ {

    protected XPathy xPathy;
    protected String attribute;

    protected __Having_Attribute_Length_Not_(Attribute attribute, XPathy xPathy){
        this.xPathy = xPathy;
        this.attribute = attribute.toString();
    }

    protected __Having_Attribute_Length_Not_(String attribute, XPathy xPathy){
        this.attribute = attribute;
        this.xPathy = xPathy;
    }

    protected __Having_Attribute_Length_Not_ copy(){
        return new __Having_Attribute_Length_Not_(this.attribute, this.xPathy);
    }

    public XPathy equals(int length) {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String attr = transformer.buildFunctionExpression("@" + this.attribute);

        copy.xpath = new _AppendAndOr_(copy).append(
                this.xPathy.having_condition_prefix + "["+
                "@" + this.attribute + " and string-length(" + attr + ") != " + length + "]");

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }


    public XPathy lessThan(int length) {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String attr = transformer.buildFunctionExpression("@" + this.attribute);

        copy.xpath = new _AppendAndOr_(copy).append(
                this.xPathy.having_condition_prefix + "["+
                "@" + this.attribute + " and string-length(" + attr + ") >= " + length + "]");

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    public XPathy lessThanOrEquals(int length) {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String attr = transformer.buildFunctionExpression("@" + this.attribute);

        copy.xpath = new _AppendAndOr_(copy).append(
                this.xPathy.having_condition_prefix + "["+
                "@" + this.attribute + " and string-length(" + attr + ") > " + length + "]");

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    public XPathy greaterThan(int length) {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String attr = transformer.buildFunctionExpression("@" + this.attribute);

        copy.xpath = new _AppendAndOr_(copy).append(
                this.xPathy.having_condition_prefix + "["+
                "@" + this.attribute + " and string-length(" + attr + ") <= " + length + "]");

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    public XPathy greaterThanOrEquals(int length) {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String attr = transformer.buildFunctionExpression("@" + this.attribute);

        copy.xpath = new _AppendAndOr_(copy).append(
                this.xPathy.having_condition_prefix + "["+
                "@" + this.attribute + " and string-length(" + attr + ") < " + length + "]");

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }


}
