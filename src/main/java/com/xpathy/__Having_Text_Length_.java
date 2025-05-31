package com.xpathy;

public class __Having_Text_Length_ {

    protected XPathy xPathy;

    protected __Having_Text_Length_(XPathy xPathy){
        this.xPathy = xPathy;
    }

    protected __Having_Text_Length_ copy(){
        return new __Having_Text_Length_(this.xPathy);
    }

    public __Having_Text_Length_ TRIM() {
        __Having_Text_Length_ copy = this.copy();
        copy.xPathy.is_trim = true;
        return copy;
    }

    public __Having_Text_Length_ NORMALIZE_SPACE() {
        __Having_Text_Length_ copy = this.copy();
        copy.xPathy.is_normalize_space = true;
        return copy;
    }

    public __Having_Text_Length_ CASE(Case thisCase) {
        __Having_Text_Length_ copy = this.copy();
        copy.xPathy = new _TranslateBuilder_(this.xPathy).setCase(thisCase);
        return copy;
    }

    public __Having_Text_Length_ REMOVE(Only... onlyItems) {
        __Having_Text_Length_ copy = this.copy();
        copy.xPathy = new _TranslateBuilder_(this.xPathy).setRemoveChars(onlyItems);
        return copy;
    }


    public __Having_Text_Length_ KEEP(Only... onlyItems) {
        __Having_Text_Length_ copy = this.copy();
        copy.xPathy = new _TranslateBuilder_(this.xPathy).setKeepOnlyChars(onlyItems);
        return copy;
    }

    public __Having_Text_Length_ TRANSLATE(String charactersToReplace, String replacementCharacters) {
        __Having_Text_Length_ copy = this.copy();
        copy.xPathy = new _TranslateBuilder_(this.xPathy).setTranslate(charactersToReplace, replacementCharacters);
        return copy;
    }

    //-------------------------

    public __Having_Text_Length_Not_ NOT(){
        return new __Having_Text_Length_Not_(this.xPathy);
    }

    //-------------------------

    private String wrappedLengthFunction() {
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(this.xPathy);
        return "string-length(" + transformer.buildFunctionExpression("text()") + ")";
    }

    public XPathy equals(int expectedLength) {
        XPathy copy = this.xPathy.copy();

        copy.xpath = new _AppendAndOr_(copy).append(
                this.xPathy.having_condition_prefix + "["+
                wrappedLengthFunction() + " = " + expectedLength + "]");

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    public XPathy greaterThan(int minLength) {
        XPathy copy = this.xPathy.copy();

        copy.xpath = new _AppendAndOr_(copy).append(
                this.xPathy.having_condition_prefix + "["+
                wrappedLengthFunction() + " > " + minLength + "]");

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    public XPathy greaterThanOrEquals(int minLength) {
        XPathy copy = this.xPathy.copy();

        copy.xpath = new _AppendAndOr_(copy).append(
                this.xPathy.having_condition_prefix + "["+
                wrappedLengthFunction() + " >= " + minLength + "]");

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    public XPathy lessThan(int maxLength) {
        XPathy copy = this.xPathy.copy();

        copy.xpath = new _AppendAndOr_(copy).append(
                this.xPathy.having_condition_prefix + "["+
                wrappedLengthFunction() + " < " + maxLength + "]");

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    public XPathy lessThanOrEquals(int maxLength) {
        XPathy copy = this.xPathy.copy();

        copy.xpath = new _AppendAndOr_(copy).append(
                this.xPathy.having_condition_prefix + "["+
                wrappedLengthFunction() + " <= " + maxLength + "]");

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }
}
