package com.xpathy;

public class _Attribute_Length_ {

    protected XPathy xPathy;
    protected String attribute;

    protected _Attribute_Length_(XPathy xPathy, Attribute attribute) {
        this.xPathy = xPathy;
        this.attribute = attribute.toString();
    }

    protected _Attribute_Length_(XPathy xPathy, String attribute) {
        this.xPathy = xPathy;
        this.attribute = attribute;
    }

    protected _Attribute_Length_ copy() {
        return new _Attribute_Length_(this.xPathy, this.attribute);
    }


    public _Attribute_Length_ TRIM() {
        _Attribute_Length_ copy = this.copy();
        copy.xPathy.is_trim = true;
        return copy;
    }


    public _Attribute_Length_ NORMALIZE_SPACE() {
        _Attribute_Length_ copy = this.copy();
        copy.xPathy.is_normalize_space = true;
        return copy;
    }

    public _Attribute_Length_ CASE(Case thisCase) {
        _Attribute_Length_ copy = this.copy();
        copy.xPathy = new _TranslateBuilder_(this.xPathy).setCase(thisCase);
        return copy;
    }

    public _Attribute_Length_ REMOVE(Only... onlyItems) {
        _Attribute_Length_ copy = this.copy();
        copy.xPathy = new _TranslateBuilder_(this.xPathy).setRemoveChars(onlyItems);
        return copy;
    }

    public _Attribute_Length_ KEEP(Only... onlyItems) {
        _Attribute_Length_ copy = this.copy();
        copy.xPathy = new _TranslateBuilder_(this.xPathy).setKeepOnlyChars(onlyItems);
        return copy;
    }

    public _Attribute_Length_ TRANSLATE(String charactersToReplace, String replacementCharacters) {
        _Attribute_Length_ copy = this.copy();
        copy.xPathy = new _TranslateBuilder_(this.xPathy).setTranslate(charactersToReplace, replacementCharacters);
        return copy;
    }

    //-----------------------------

    public _Attribute_Length_Not_ NOT(){
        return new _Attribute_Length_Not_(this.xPathy, this.attribute);
    }


    public XPathy equals(int length) {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String attr = transformer.buildFunctionExpression("@" + this.attribute);

        copy.xpath = new _AppendAndOr_(copy).append("@" + this.attribute + " and string-length(" + attr + ") = " + length);

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    public XPathy lessThan(int length) {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String attr = transformer.buildFunctionExpression("@" + this.attribute);

        copy.xpath = new _AppendAndOr_(copy).append("@" + this.attribute + " and string-length(" + attr + ") < " + length);

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    public XPathy lessThanOrEquals(int length) {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String attr = transformer.buildFunctionExpression("@" + this.attribute);

        copy.xpath = new _AppendAndOr_(copy).append("@" + this.attribute + " and string-length(" + attr + ") <= " + length);

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    public XPathy greaterThan(int length) {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String attr = transformer.buildFunctionExpression("@" + this.attribute);

        copy.xpath = new _AppendAndOr_(copy).append("@" + this.attribute + " and string-length(" + attr + ") > " + length);

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    public XPathy greaterThanOrEquals(int length) {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String attr = transformer.buildFunctionExpression("@" + this.attribute);

        copy.xpath = new _AppendAndOr_(copy).append("@" + this.attribute + " and string-length(" + attr + ") >= " + length);

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }


}
