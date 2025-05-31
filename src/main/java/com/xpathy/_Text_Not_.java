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
