package com.xpathy;

public class __Having_Attribute_Not_ {

    protected XPathy xPathy;
    protected String attribute;

    protected __Having_Attribute_Not_(Attribute attribute, XPathy xPathy){
        this.xPathy = xPathy;
        this.attribute = attribute.toString();
    }

    protected __Having_Attribute_Not_(String attribute, XPathy xPathy){
        this.attribute = attribute;
        this.xPathy = xPathy;
    }

    protected __Having_Attribute_Not_ copy(){
        return new __Having_Attribute_Not_(this.attribute, this.xPathy);
    }


    public XPathy haveIt() {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String function = transformer.buildFunctionExpression("@" + this.attribute);

        copy.xpath = new _AppendAndOr_(copy).append(
                this.xPathy.having_condition_prefix + "["+
                "not(" + function + ")" + "]");

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    public XPathy equals(String value) {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String function = transformer.buildFunctionExpression("@" + this.attribute);
        String transformedValue = transformer.applyModifiersToValue(value);

        copy.xpath = new _AppendAndOr_(copy).append(
                this.xPathy.having_condition_prefix + "["+
                "not(" + function + "='" + transformedValue + "')]");

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    public XPathy contains(String value) {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String function = transformer.buildFunctionExpression("@" + this.attribute);
        String transformedValue = transformer.applyModifiersToValue(value);

        copy.xpath = new _AppendAndOr_(copy).append(
                this.xPathy.having_condition_prefix + "["+
                "not(contains(" + function + ", '" + transformedValue + "'))]");

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    public XPathy startsWith(String prefix) {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String function = transformer.buildFunctionExpression("@" + this.attribute);
        String transformedPrefix = transformer.applyModifiersToValue(prefix);

        copy.xpath = new _AppendAndOr_(copy).append(
                this.xPathy.having_condition_prefix + "["+
                "not(starts-with(" + function + ", '" + transformedPrefix + "'))]");

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    public XPathy empty() {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String function = transformer.buildFunctionExpression("normalize-space(@" + this.attribute + ")");

        copy.xpath = new _AppendAndOr_(copy).append(
                this.xPathy.having_condition_prefix + "["+
                "not(" + function + "='')]");

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    public XPathy numeric() {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String function = transformer.buildFunctionExpression("@" + this.attribute);

        copy.xpath = new _AppendAndOr_(copy).append(
                this.xPathy.having_condition_prefix +
                        "[not("+
                        "not(number(" + function + ") != number("+ function +"))" +
                        ")]");

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    public XPathy equals(Number number) {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String attr = transformer.buildFunctionExpression("@" + this.attribute);

        copy.xpath = new _AppendAndOr_(copy).append(
                this.xPathy.having_condition_prefix + "["+
                "not(" + attr + " = " + number + ")]");

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    public XPathy greaterThan(Number number) {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String attr = transformer.buildFunctionExpression("@" + this.attribute);

        copy.xpath = new _AppendAndOr_(copy).append(
                this.xPathy.having_condition_prefix + "["+
                attr + " <= " + number + "]");

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    public XPathy greaterThanOrEquals(Number number) {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String attr = transformer.buildFunctionExpression("@" + this.attribute);

        copy.xpath = new _AppendAndOr_(copy).append(
                this.xPathy.having_condition_prefix + "["+
                attr + " < " + number + "]");

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    public XPathy lessThan(Number number) {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String attr = transformer.buildFunctionExpression("@" + this.attribute);

        copy.xpath = new _AppendAndOr_(copy).append(
                this.xPathy.having_condition_prefix + "["+
                attr + " >= " + number + "]");

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    public XPathy lessThanOrEquals(Number number) {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String attr = transformer.buildFunctionExpression("@" + this.attribute);

        copy.xpath = new _AppendAndOr_(copy).append(
                this.xPathy.having_condition_prefix + "["+
                attr + " > " + number + "]");

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

}
