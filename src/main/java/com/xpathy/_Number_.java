package com.xpathy;

public class _Number_ {

    protected XPathy xPathy;

    protected _Number_(XPathy xPathy) {
        this.xPathy = xPathy;
    }

    protected _Number_(_Number_ _Number_) {
        this.xPathy = _Number_.xPathy;
    }

    protected _Number_ copy() {
        return new _Number_(this);
    }

    public _Number_Not_ not() {
        return new _Number_Not_(this.xPathy);
    }


    public _Number_ withTrim() {
        _Number_ copy = this.copy();
        copy.xPathy.is_trim = true;
        return copy;
    }

    public _Number_ withNormalizeSpace() {
        _Number_ copy = this.copy();
        copy.xPathy.is_normalize_space = true;
        return copy;
    }


//    public _Number_ CASE(Case thisCase) {
//        _Number_ copy = this.copy();
//        copy.xPathy = new _TranslateBuilder_(this.xPathy).setCase(thisCase);
//        return copy;
//    }

    public _Number_ withRemoveOnly(Only... onlyItems) {
        _Number_ copy = this.copy();
        copy.xPathy = new _TranslateBuilder_(this.xPathy).setRemoveChars(onlyItems);
        return copy;
    }

    public _Number_ withKeepOnly(Only... onlyItems) {
        _Number_ copy = this.copy();
        copy.xPathy = new _TranslateBuilder_(this.xPathy).setKeepOnlyChars(onlyItems);
        return copy;
    }

    public _Number_ withTranslate(String charactersToReplace, String replacementCharacters) {
        _Number_ copy = this.copy();
        copy.xPathy = new _TranslateBuilder_(this.xPathy).setTranslate(charactersToReplace, replacementCharacters);
        return copy;
    }

    private XPathy buildNumberCondition(String operator, Number number) {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        // Pass raw text() into the transformer first
        String transformedText = transformer.buildFunctionExpression("text()");
        // Then wrap it in number(...)
        String function = "number(" + transformedText + ")";

        copy.xpath = new _AppendAndOr_(copy).append(function + " " + operator + " " + number);

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }


    public XPathy equals(Number number) {
        return buildNumberCondition("=", number);
    }

    public XPathy greaterThan(Number number) {
        return buildNumberCondition(">", number);
    }

    public XPathy greaterThanOrEquals(Number number) {
        return buildNumberCondition(">=", number);
    }

    public XPathy lessThan(Number number) {
        return buildNumberCondition("<", number);
    }

    public XPathy lessThanOrEquals(Number number) {
        return buildNumberCondition("<=", number);
    }

    public XPathy between(Number min, Number max) {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String transformedText = transformer.buildFunctionExpression("text()");
        String function = "number(" + transformedText + ")";

        copy.xpath = new _AppendAndOr_(copy).append(" ( " + function + " >= " + min + " and " + function + " <= " + max + " ) ");

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }


}
