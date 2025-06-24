package com.xpathy;

public class _Condition_Attribute_ {
    protected Attribute attribute;
    protected XPathy xPathy;

    protected _Condition_Attribute_(Attribute attribute) {
        this.attribute = attribute;
        this.xPathy = new XPathy();
    }

    protected _Condition_Attribute_ copy() {
        _Condition_Attribute_ copy = new _Condition_Attribute_(this.attribute);
        copy.xPathy = this.xPathy.copy();
        return copy;
    }

    public _Condition_Attribute_ TRIM() {
        _Condition_Attribute_ copy = this.copy();
        copy.xPathy.is_trim = true;
        return copy;
    }

    public _Condition_Attribute_ NORMALIZE_SPACE() {
        _Condition_Attribute_ copy = this.copy();
        copy.xPathy.is_normalize_space = true;
        return copy;
    }

    public _Condition_Attribute_ CASE(Case thisCase) {
        _Condition_Attribute_ copy = this.copy();
        copy.xPathy = new _TranslateBuilder_(this.xPathy).setCase(thisCase);
        return copy;
    }

    public _Condition_Attribute_ REMOVE(Only... onlyItems) {
        _Condition_Attribute_ copy = this.copy();
        copy.xPathy = new _TranslateBuilder_(this.xPathy).setRemoveChars(onlyItems);
        return copy;
    }

    public _Condition_Attribute_ KEEP(Only... onlyItems) {
        _Condition_Attribute_ copy = this.copy();
        copy.xPathy = new _TranslateBuilder_(this.xPathy).setKeepOnlyChars(onlyItems);
        return copy;
    }

    public _Condition_Attribute_ TRANSLATE(String charactersToReplace, String replacementCharacters) {
        _Condition_Attribute_ copy = this.copy();
        copy.xPathy = new _TranslateBuilder_(this.xPathy).setTranslate(charactersToReplace, replacementCharacters);
        return copy;
    }

    public Condition haveIt() {
        Condition condition = new Condition(Condition.ConditionType.ATTRIBUTE);
        XPathy xPathy = this.xPathy.ATTRIBUTE(this.attribute).haveIt().copy();
        condition.condition = Condition.extractConditionString_fromXpath(xPathy);
        return condition;
    }

    public Condition equals(String equalValue) {
        Condition condition = new Condition(Condition.ConditionType.ATTRIBUTE);
        XPathy xPathy = this.xPathy.ATTRIBUTE(this.attribute).equals(equalValue).copy();
        condition.condition = Condition.extractConditionString_fromXpath(xPathy);
        return condition;
    }

    public Condition contains(String partialValue) {
        Condition condition = new Condition(Condition.ConditionType.ATTRIBUTE);
        XPathy xPathy = this.xPathy.ATTRIBUTE(this.attribute).contains(partialValue).copy();
        condition.condition = Condition.extractConditionString_fromXpath(xPathy);
        return condition;
    }

    public Condition startsWith(String prefix) {
        Condition condition = new Condition(Condition.ConditionType.ATTRIBUTE);
        XPathy xPathy = this.xPathy.ATTRIBUTE(this.attribute).startsWith(prefix).copy();
        condition.condition = Condition.extractConditionString_fromXpath(xPathy);
        return condition;
    }

    public Condition isEmpty() {
        Condition condition = new Condition(Condition.ConditionType.ATTRIBUTE);
        XPathy xPathy = this.xPathy.ATTRIBUTE(this.attribute).isEmpty().copy();
        condition.condition = Condition.extractConditionString_fromXpath(xPathy);
        return condition;
    }

    public Condition isNumeric() {
        Condition condition = new Condition(Condition.ConditionType.ATTRIBUTE);
        XPathy xPathy = this.xPathy.ATTRIBUTE(this.attribute).isNumeric().copy();
        condition.condition = Condition.extractConditionString_fromXpath(xPathy);
        return condition;
    }


    public Condition equals(Number number) {
        Condition condition = new Condition(Condition.ConditionType.ATTRIBUTE);
        XPathy xPathy = this.xPathy.ATTRIBUTE(this.attribute).equals(number).copy();
        condition.condition = Condition.extractConditionString_fromXpath(xPathy);
        return condition;
    }

    public Condition greaterThan(Number number) {
        Condition condition = new Condition(Condition.ConditionType.ATTRIBUTE);
        XPathy xPathy = this.xPathy.ATTRIBUTE(this.attribute).greaterThan(number).copy();
        condition.condition = Condition.extractConditionString_fromXpath(xPathy);
        return condition;
    }

    public Condition greaterThanOrEquals(Number number) {
        Condition condition = new Condition(Condition.ConditionType.ATTRIBUTE);
        XPathy xPathy = this.xPathy.ATTRIBUTE(this.attribute).greaterThanOrEquals(number).copy();
        condition.condition = Condition.extractConditionString_fromXpath(xPathy);
        return condition;
    }

    public Condition lessThan(Number number) {
        Condition condition = new Condition(Condition.ConditionType.ATTRIBUTE);
        XPathy xPathy = this.xPathy.ATTRIBUTE(this.attribute).lessThan(number).copy();
        condition.condition = Condition.extractConditionString_fromXpath(xPathy);
        return condition;
    }

    public Condition lessThanOrEquals(Number number) {
        Condition condition = new Condition(Condition.ConditionType.ATTRIBUTE);
        XPathy xPathy = this.xPathy.ATTRIBUTE(this.attribute).lessThanOrEquals(number).copy();
        condition.condition = Condition.extractConditionString_fromXpath(xPathy);
        return condition;
    }

    public Condition between(Number min, Number max) {
        Condition condition = new Condition(Condition.ConditionType.ATTRIBUTE);
        XPathy xPathy = this.xPathy.ATTRIBUTE(this.attribute).between(min, max).copy();
        condition.condition = Condition.extractConditionString_fromXpath(xPathy);
        return condition;
    }


}
