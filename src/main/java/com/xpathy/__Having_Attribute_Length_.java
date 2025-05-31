package com.xpathy;

public class __Having_Attribute_Length_ {

    protected XPathy xPathy;
    protected String attribute;

    protected __Having_Attribute_Length_(Attribute attribute, XPathy xPathy){
        this.xPathy = xPathy;
        this.attribute = attribute.toString();
    }

    protected __Having_Attribute_Length_(String attribute, XPathy xPathy){
        this.attribute = attribute;
        this.xPathy = xPathy;
    }

    protected __Having_Attribute_Length_ copy(){
        return new __Having_Attribute_Length_(this.attribute, this.xPathy);
    }

    public __Having_Attribute_Length_ TRIM() {
        __Having_Attribute_Length_ copy = this.copy();
        copy.xPathy.is_trim = true;
        return copy;
    }

    public __Having_Attribute_Length_ NORMALIZE_SPACE() {
        __Having_Attribute_Length_ copy = this.copy();
        copy.xPathy.is_normalize_space = true;
        return copy;
    }

    public __Having_Attribute_Length_ CASE(Case thisCase) {
        __Having_Attribute_Length_ copy = this.copy();
        copy.xPathy = new _TranslateBuilder_(this.xPathy).setCase(thisCase);
        return copy;
    }

    public __Having_Attribute_Length_ REMOVE(Only... onlyItems) {
        __Having_Attribute_Length_ copy = this.copy();
        copy.xPathy = new _TranslateBuilder_(this.xPathy).setRemoveChars(onlyItems);
        return copy;
    }


    public __Having_Attribute_Length_ KEEP(Only... onlyItems) {
        __Having_Attribute_Length_ copy = this.copy();
        copy.xPathy = new _TranslateBuilder_(this.xPathy).setKeepOnlyChars(onlyItems);
        return copy;
    }

    public __Having_Attribute_Length_ TRANSLATE(String charactersToReplace, String replacementCharacters) {
        __Having_Attribute_Length_ copy = this.copy();
        copy.xPathy = new _TranslateBuilder_(this.xPathy).setTranslate(charactersToReplace, replacementCharacters);
        return copy;
    }

    //----------------------------

    public __Having_Attribute_Length_Not_ NOT(){
        return new __Having_Attribute_Length_Not_(this.attribute, this.xPathy);
    }

    //----------------------------

    public XPathy equals(int length) {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String attr = transformer.buildFunctionExpression("@" + this.attribute);

        copy.xpath = new _AppendAndOr_(copy).append(
                this.xPathy.having_condition_prefix + "["+
                "@" + this.attribute + " and string-length(" + attr + ") = " + length + "]");

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
                "@" + this.attribute + " and string-length(" + attr + ") < " + length + "]");

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
                "@" + this.attribute + " and string-length(" + attr + ") <= " + length + "]");

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
                "@" + this.attribute + " and string-length(" + attr + ") > " + length + "]");

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
                "@" + this.attribute + " and string-length(" + attr + ") >= " + length + "]");

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }


}
