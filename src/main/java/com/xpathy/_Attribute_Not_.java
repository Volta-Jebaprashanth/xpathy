package com.xpathy;

public class _Attribute_Not_ {

    protected XPathy xPathy;
    protected String attribute;

    protected _Attribute_Not_(XPathy xPathy, Attribute attribute) {
        this.xPathy = xPathy;
        this.attribute = attribute.toString();
    }

    protected _Attribute_Not_(XPathy xPathy, String attribute) {
        this.xPathy = xPathy;
        this.attribute = attribute;
    }

    protected _Attribute_Not_ copy() {
        return new _Attribute_Not_(this.xPathy, this.attribute);
    }

    public XPathy haveIt() {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String function = transformer.buildFunctionExpression("@" + this.attribute);

        copy.xpath = new _AppendAndOr_(copy).append("not(" + function + ")");

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    public XPathy equals(String value) {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String function = transformer.buildFunctionExpression("@" + this.attribute);
        String transformedValue = transformer.applyModifiersToValue(value);

        copy.xpath = new _AppendAndOr_(copy).append("not(" + function + "='" + transformedValue + "')");

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    public XPathy contains(String value) {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String function = transformer.buildFunctionExpression("@" + this.attribute);
        String transformedValue = transformer.applyModifiersToValue(value);

        copy.xpath = new _AppendAndOr_(copy).append("not(contains(" + function + ", '" + transformedValue + "'))");

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    public XPathy startsWith(String prefix) {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String function = transformer.buildFunctionExpression("@" + this.attribute);
        String transformedPrefix = transformer.applyModifiersToValue(prefix);

        copy.xpath = new _AppendAndOr_(copy).append("not(starts-with(" + function + ", '" + transformedPrefix + "'))");

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    public XPathy empty() {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String function = transformer.buildFunctionExpression("normalize-space(@" + this.attribute + ")");

        copy.xpath = new _AppendAndOr_(copy).append("not(" + function + "='')");

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    public XPathy numeric() {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String function = transformer.buildFunctionExpression("@" + this.attribute);

        copy.xpath = new _AppendAndOr_(copy).append("not(string-length(" + function + ") > 0 and not(translate(" + function + ", '0123456789', '') != ''))");

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    public XPathy equals(Number number) {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String attr = transformer.buildFunctionExpression("@" + this.attribute);

        copy.xpath = new _AppendAndOr_(copy).append("not(" + attr + " = " + number + ")");

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    public XPathy greaterThan(Number number) {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String attr = transformer.buildFunctionExpression("@" + this.attribute);

        copy.xpath = new _AppendAndOr_(copy).append(attr + " <= " + number);

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    public XPathy greaterThanOrEquals(Number number) {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String attr = transformer.buildFunctionExpression("@" + this.attribute);

        copy.xpath = new _AppendAndOr_(copy).append(attr + " < " + number);

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    public XPathy lessThan(Number number) {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String attr = transformer.buildFunctionExpression("@" + this.attribute);

        copy.xpath = new _AppendAndOr_(copy).append(attr + " >= " + number);

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    public XPathy lessThanOrEquals(Number number) {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String attr = transformer.buildFunctionExpression("@" + this.attribute);

        copy.xpath = new _AppendAndOr_(copy).append(attr + " > " + number);

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

}
