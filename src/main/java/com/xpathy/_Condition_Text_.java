package com.xpathy;

public class _Condition_Text_ {

    protected XPathy xPathy;

    protected _Condition_Text_(){
        this.xPathy = new XPathy();
    }

    protected _Condition_Text_ copy() {
        _Condition_Text_ copy = new _Condition_Text_();
        copy.xPathy = this.xPathy.copy();
        return copy;
    }

    public _Condition_Text_ withTrim() {
        _Condition_Text_ copy = this.copy();
        copy.xPathy.is_trim = true;
        return copy;
    }

    public _Condition_Text_ withNormalizeSpace() {
        _Condition_Text_ copy = this.copy();
        copy.xPathy.is_normalize_space = true;
        return copy;
    }

    public _Condition_Text_ withCase(Case thisCase) {
        _Condition_Text_ copy = this.copy();
        copy.xPathy = new _TranslateBuilder_(this.xPathy).setCase(thisCase);
        return copy;
    }

    public _Condition_Text_ withRemoveOnly(Only... onlyItems) {
        _Condition_Text_ copy = this.copy();
        copy.xPathy = new _TranslateBuilder_(this.xPathy).setRemoveChars(onlyItems);
        return copy;
    }

    public _Condition_Text_ withKeepOnly(Only... onlyItems) {
        _Condition_Text_ copy = this.copy();
        copy.xPathy = new _TranslateBuilder_(this.xPathy).setKeepOnlyChars(onlyItems);
        return copy;
    }

    public _Condition_Text_ withTranslate(String charactersToReplace, String replacementCharacters) {
        _Condition_Text_ copy = this.copy();
        copy.xPathy = new _TranslateBuilder_(this.xPathy).setTranslate(charactersToReplace, replacementCharacters);
        return copy;
    }

    //==============================================

    public Condition equals(String equalText) {
        Condition condition = new Condition(Condition.ConditionType.TEXT);
        XPathy xPathy = this.xPathy.byText().equals(equalText).copy();
        condition.condition = Condition.extractConditionString_fromXpath(xPathy);
        return condition;
    }


    public Condition contains(String partialText) {
        Condition condition = new Condition(Condition.ConditionType.TEXT);
        XPathy xPathy = this.xPathy.byText().contains(partialText).copy();
        condition.condition = Condition.extractConditionString_fromXpath(xPathy);
        return condition;
    }

    public Condition startsWith(String prefixText) {
        Condition condition = new Condition(Condition.ConditionType.TEXT);
        XPathy xPathy = this.xPathy.byText().startsWith(prefixText).copy();
        condition.condition = Condition.extractConditionString_fromXpath(xPathy);
        return condition;
    }

    public Condition isEmpty() {
        Condition condition = new Condition(Condition.ConditionType.TEXT);
        XPathy xPathy = this.xPathy.byText().isEmpty().copy();
        condition.condition = Condition.extractConditionString_fromXpath(xPathy);
        return condition;
    }

    public Condition isNumeric() {
        Condition condition = new Condition(Condition.ConditionType.TEXT);
        XPathy xPathy = this.xPathy.byText().isNumeric().copy();
        condition.condition = Condition.extractConditionString_fromXpath(xPathy);
        return condition;
    }

    public Condition equals(Number number) {
        Condition condition = new Condition(Condition.ConditionType.TEXT);
        XPathy xPathy = this.xPathy.byText().equals(number).copy();
        condition.condition = Condition.extractConditionString_fromXpath(xPathy);
        return condition;
    }

    public Condition greaterThan(Number number) {
        Condition condition = new Condition(Condition.ConditionType.TEXT);
        XPathy xPathy = this.xPathy.byText().greaterThan(number).copy();
        condition.condition = Condition.extractConditionString_fromXpath(xPathy);
        return condition;
    }

    public Condition greaterThanOrEquals(Number number) {
        Condition condition = new Condition(Condition.ConditionType.TEXT);
        XPathy xPathy = this.xPathy.byText().greaterThanOrEquals(number).copy();
        condition.condition = Condition.extractConditionString_fromXpath(xPathy);
        return condition;
    }

    public Condition lessThan(Number number) {
        Condition condition = new Condition(Condition.ConditionType.TEXT);
        XPathy xPathy = this.xPathy.byText().lessThan(number).copy();
        condition.condition = Condition.extractConditionString_fromXpath(xPathy);
        return condition;
    }

    public Condition lessThanOrEquals(Number number) {
        Condition condition = new Condition(Condition.ConditionType.TEXT);
        XPathy xPathy = this.xPathy.byText().lessThanOrEquals(number).copy();
        condition.condition = Condition.extractConditionString_fromXpath(xPathy);
        return condition;
    }



}
