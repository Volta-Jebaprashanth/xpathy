package com.xpathy;

public class _Condition_Number_ {
    protected XPathy xPathy;

    protected _Condition_Number_(){
        this.xPathy = new XPathy();
    }

    protected _Condition_Number_ copy() {
        _Condition_Number_ copy = new _Condition_Number_();
        copy.xPathy = this.xPathy.copy();
        return copy;
    }

    public _Condition_Number_ TRIM() {
        _Condition_Number_ copy = this.copy();
        copy.xPathy.is_trim = true;
        return copy;
    }

    public _Condition_Number_ NORMALIZE_SPACE() {
        _Condition_Number_ copy = this.copy();
        copy.xPathy.is_normalize_space = true;
        return copy;
    }

    public _Condition_Number_ CASE(Case thisCase) {
        _Condition_Number_ copy = this.copy();
        copy.xPathy = new _TranslateBuilder_(this.xPathy).setCase(thisCase);
        return copy;
    }

    public _Condition_Number_ REMOVE(Only... onlyItems) {
        _Condition_Number_ copy = this.copy();
        copy.xPathy = new _TranslateBuilder_(this.xPathy).setRemoveChars(onlyItems);
        return copy;
    }

    public _Condition_Number_ KEEP(Only... onlyItems) {
        _Condition_Number_ copy = this.copy();
        copy.xPathy = new _TranslateBuilder_(this.xPathy).setKeepOnlyChars(onlyItems);
        return copy;
    }

    public _Condition_Number_ TRANSLATE(String charactersToReplace, String replacementCharacters) {
        _Condition_Number_ copy = this.copy();
        copy.xPathy = new _TranslateBuilder_(this.xPathy).setTranslate(charactersToReplace, replacementCharacters);
        return copy;
    }

    //=============================


    public Condition equals(Number number) {
        Condition condition = new Condition(Condition.ConditionType.TEXT);
        XPathy xPathy = this.xPathy.NUMBER().equals(number).copy();
        condition.condition = Condition.extractConditionString_fromXpath(xPathy);
        return condition;
    }

    public Condition greaterThan(Number number) {
        Condition condition = new Condition(Condition.ConditionType.TEXT);
        XPathy xPathy = this.xPathy.NUMBER().greaterThan(number).copy();
        condition.condition = Condition.extractConditionString_fromXpath(xPathy);
        return condition;
    }

    public Condition greaterThanOrEquals(Number number) {
        Condition condition = new Condition(Condition.ConditionType.TEXT);
        XPathy xPathy = this.xPathy.NUMBER().greaterThanOrEquals(number).copy();
        condition.condition = Condition.extractConditionString_fromXpath(xPathy);
        return condition;
    }

    public Condition lessThan(Number number) {
        Condition condition = new Condition(Condition.ConditionType.TEXT);
        XPathy xPathy = this.xPathy.NUMBER().lessThan(number).copy();
        condition.condition = Condition.extractConditionString_fromXpath(xPathy);
        return condition;
    }

    public Condition lessThanOrEquals(Number number) {
        Condition condition = new Condition(Condition.ConditionType.TEXT);
        XPathy xPathy = this.xPathy.NUMBER().lessThanOrEquals(number).copy();
        condition.condition = Condition.extractConditionString_fromXpath(xPathy);
        return condition;
    }

    public Condition between(Number min, Number max) {
        Condition condition = new Condition(Condition.ConditionType.TEXT);
        XPathy xPathy = this.xPathy.NUMBER().between(min, max).copy();
        condition.condition = Condition.extractConditionString_fromXpath(xPathy);
        return condition;
    }

}
