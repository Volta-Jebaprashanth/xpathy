package com.xpathy;

public class _Text_Length_ {

    protected XPathy xPathy;

    protected _Text_Length_(XPathy xPathy) {
        this.xPathy = xPathy;
    }

    protected _Text_Length_(_Text_Length_ text) {
        this.xPathy = text.xPathy;
    }

    protected _Text_Length_ copy() {
        return new _Text_Length_(this);
    }

    public _Text_Length_Not_ NOT() {
        return new _Text_Length_Not_(this.xPathy);
    }


    public _Text_Length_ TRIM() {
        _Text_Length_ copy = this.copy();
        copy.xPathy.is_trim = true;
        return copy;
    }

    public _Text_Length_ NORMALIZE_SPACE() {
        _Text_Length_ copy = this.copy();
        copy.xPathy.is_normalize_space = true;
        return copy;
    }

    public _Text_Length_ CASE(Case thisCase) {
        _Text_Length_ copy = this.copy();
        copy.xPathy = new _TranslateBuilder_(this.xPathy).setCase(thisCase);
        return copy;
    }

    public _Text_Length_ REMOVE(Only... onlyItems) {
        _Text_Length_ copy = this.copy();
        copy.xPathy = new _TranslateBuilder_(this.xPathy).setRemoveChars(onlyItems);
        return copy;
    }


    public _Text_Length_ KEEP(Only... onlyItems) {
        _Text_Length_ copy = this.copy();
        copy.xPathy = new _TranslateBuilder_(this.xPathy).setKeepOnlyChars(onlyItems);
        return copy;
    }

    public _Text_Length_ TRANSLATE(String charactersToReplace, String replacementCharacters) {
        _Text_Length_ copy = this.copy();
        copy.xPathy = new _TranslateBuilder_(this.xPathy).setTranslate(charactersToReplace, replacementCharacters);
        return copy;
    }

    private String wrappedLengthFunction() {
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(this.xPathy);
        return "string-length(" + transformer.buildFunctionExpression("text()") + ")";
    }

    public XPathy equals(int expectedLength) {
        XPathy copy = this.xPathy.copy();

        copy.xpath = new _AppendAndOr_(copy).append(wrappedLengthFunction() + " = " + expectedLength);

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    public XPathy greaterThan(int minLength) {
        XPathy copy = this.xPathy.copy();

        copy.xpath = new _AppendAndOr_(copy).append(wrappedLengthFunction() + " > " + minLength);

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    public XPathy greaterThanOrEquals(int minLength) {
        XPathy copy = this.xPathy.copy();

        copy.xpath = new _AppendAndOr_(copy).append(wrappedLengthFunction() + " >= " + minLength);

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    public XPathy lessThan(int maxLength) {
        XPathy copy = this.xPathy.copy();

        copy.xpath = new _AppendAndOr_(copy).append(wrappedLengthFunction() + " < " + maxLength);

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    public XPathy lessThanOrEquals(int maxLength) {
        XPathy copy = this.xPathy.copy();

        copy.xpath = new _AppendAndOr_(copy).append(wrappedLengthFunction() + " <= " + maxLength);

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }
}
