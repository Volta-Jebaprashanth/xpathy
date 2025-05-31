package com.xpathy;

public class __Having_Number_ {

    protected XPathy xPathy;

    protected __Having_Number_(XPathy xPathy){
        this.xPathy = xPathy;
    }

    protected __Having_Number_ copy(){
        return new __Having_Number_(this.xPathy);
    }

    public __Having_Number_ TRIM() {
        __Having_Number_ copy = this.copy();
        copy.xPathy.is_trim = true;
        return copy;
    }

    public __Having_Number_ NORMALIZE_SPACE() {
        __Having_Number_ copy = this.copy();
        copy.xPathy.is_normalize_space = true;
        return copy;
    }


    public __Having_Number_ CASE(Case thisCase) {
        __Having_Number_ copy = this.copy();
        copy.xPathy = new _TranslateBuilder_(this.xPathy).setCase(thisCase);
        return copy;
    }

    public __Having_Number_ REMOVE(Only... onlyItems) {
        __Having_Number_ copy = this.copy();
        copy.xPathy = new _TranslateBuilder_(this.xPathy).setRemoveChars(onlyItems);
        return copy;
    }

    public __Having_Number_ KEEP(Only... onlyItems) {
        __Having_Number_ copy = this.copy();
        copy.xPathy = new _TranslateBuilder_(this.xPathy).setKeepOnlyChars(onlyItems);
        return copy;
    }

    public __Having_Number_ TRANSLATE(String charactersToReplace, String replacementCharacters) {
        __Having_Number_ copy = this.copy();
        copy.xPathy = new _TranslateBuilder_(this.xPathy).setTranslate(charactersToReplace, replacementCharacters);
        return copy;
    }

    //==================

    public __Having_Number_Not_ NOT(){
        return new __Having_Number_Not_(this.xPathy);
    }

    private XPathy buildNumberCondition(String operator, Number number) {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        // Pass raw text() into the transformer first
        String transformedText = transformer.buildFunctionExpression("text()");
        // Then wrap it in number(...)
        String function = "number(" + transformedText + ")";

        copy.xpath = new _AppendAndOr_(copy).append(
                this.xPathy.having_condition_prefix + "["+
                function + " " + operator + " " + number + "]");

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

        copy.xpath = new _AppendAndOr_(copy).append(
                this.xPathy.having_condition_prefix + "["+
                function + " >= " + min + " and " + function + " <= " + max + "]");

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

}
