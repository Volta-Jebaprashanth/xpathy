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

    public _Condition_Attribute_ withTrim() {
        _Condition_Attribute_ copy = this.copy();
        copy.xPathy.is_trim = true;
        return copy;
    }

    public _Condition_Attribute_ withNormalizeSpace() {
        _Condition_Attribute_ copy = this.copy();
        copy.xPathy.is_normalize_space = true;
        return copy;
    }

    public _Condition_Attribute_ withCase(Case thisCase) {
        _Condition_Attribute_ copy = this.copy();
        copy.xPathy = new _TranslateBuilder_(this.xPathy).setCase(thisCase);
        return copy;
    }

    public _Condition_Attribute_ withRemoveOnly(Only... onlyItems) {
        _Condition_Attribute_ copy = this.copy();
        copy.xPathy = new _TranslateBuilder_(this.xPathy).setRemoveChars(onlyItems);
        return copy;
    }

    public _Condition_Attribute_ withKeepOnly(Only... onlyItems) {
        _Condition_Attribute_ copy = this.copy();
        copy.xPathy = new _TranslateBuilder_(this.xPathy).setKeepOnlyChars(onlyItems);
        return copy;
    }

    public _Condition_Attribute_ withTranslate(String charactersToReplace, String replacementCharacters) {
        _Condition_Attribute_ copy = this.copy();
        copy.xPathy = new _TranslateBuilder_(this.xPathy).setTranslate(charactersToReplace, replacementCharacters);
        return copy;
    }

    public Condition haveIt() {
        Condition condition = new Condition(Condition.ConditionType.ATTRIBUTE);
        XPathy xPathy = this.xPathy.byAttribute(this.attribute).haveIt().copy();
        condition.condition = Condition.extractConditionString_fromXpath(xPathy);
        return condition;
    }

    public Condition equals(String equalValue) {
        Condition condition = new Condition(Condition.ConditionType.ATTRIBUTE);
        XPathy xPathy = this.xPathy.byAttribute(this.attribute).equals(equalValue).copy();
        condition.condition = Condition.extractConditionString_fromXpath(xPathy);
        return condition;
    }

    public Condition contains(String partialValue) {
        Condition condition = new Condition(Condition.ConditionType.ATTRIBUTE);
        XPathy xPathy = this.xPathy.byAttribute(this.attribute).contains(partialValue).copy();
        condition.condition = Condition.extractConditionString_fromXpath(xPathy);
        return condition;
    }

    public Condition startsWith(String prefix) {
        Condition condition = new Condition(Condition.ConditionType.ATTRIBUTE);
        XPathy xPathy = this.xPathy.byAttribute(this.attribute).startsWith(prefix).copy();
        condition.condition = Condition.extractConditionString_fromXpath(xPathy);
        return condition;
    }

    public Condition isEmpty() {
        Condition condition = new Condition(Condition.ConditionType.ATTRIBUTE);
        XPathy xPathy = this.xPathy.byAttribute(this.attribute).isEmpty().copy();
        condition.condition = Condition.extractConditionString_fromXpath(xPathy);
        return condition;
    }

    public Condition isNumeric() {
        Condition condition = new Condition(Condition.ConditionType.ATTRIBUTE);
        XPathy xPathy = this.xPathy.byAttribute(this.attribute).isNumeric().copy();
        condition.condition = Condition.extractConditionString_fromXpath(xPathy);
        return condition;
    }


    public Condition equals(Number number) {
        Condition condition = new Condition(Condition.ConditionType.ATTRIBUTE);
        XPathy xPathy = this.xPathy.byAttribute(this.attribute).equals(number).copy();
        condition.condition = Condition.extractConditionString_fromXpath(xPathy);
        return condition;
    }

    public Condition greaterThan(Number number) {
        Condition condition = new Condition(Condition.ConditionType.ATTRIBUTE);
        XPathy xPathy = this.xPathy.byAttribute(this.attribute).greaterThan(number).copy();
        condition.condition = Condition.extractConditionString_fromXpath(xPathy);
        return condition;
    }

    public Condition greaterThanOrEquals(Number number) {
        Condition condition = new Condition(Condition.ConditionType.ATTRIBUTE);
        XPathy xPathy = this.xPathy.byAttribute(this.attribute).greaterThanOrEquals(number).copy();
        condition.condition = Condition.extractConditionString_fromXpath(xPathy);
        return condition;
    }

    public Condition lessThan(Number number) {
        Condition condition = new Condition(Condition.ConditionType.ATTRIBUTE);
        XPathy xPathy = this.xPathy.byAttribute(this.attribute).lessThan(number).copy();
        condition.condition = Condition.extractConditionString_fromXpath(xPathy);
        return condition;
    }

    public Condition lessThanOrEquals(Number number) {
        Condition condition = new Condition(Condition.ConditionType.ATTRIBUTE);
        XPathy xPathy = this.xPathy.byAttribute(this.attribute).lessThanOrEquals(number).copy();
        condition.condition = Condition.extractConditionString_fromXpath(xPathy);
        return condition;
    }

    public Condition between(Number min, Number max) {
        Condition condition = new Condition(Condition.ConditionType.ATTRIBUTE);
        XPathy xPathy = this.xPathy.byAttribute(this.attribute).between(min, max).copy();
        condition.condition = Condition.extractConditionString_fromXpath(xPathy);
        return condition;
    }


}
