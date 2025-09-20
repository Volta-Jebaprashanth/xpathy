package com.xpathy;

public class And {

    protected XPathy xPathy;
    protected boolean isNot;

    protected Expressions expressions;

    protected String value;
    protected Number number;

    protected Number min;
    protected Number max;

    protected And(Expressions expressions) {
        this.expressions = expressions;
    }

    protected And(XPathy xPathy) {
        this.xPathy = xPathy;
    }

    //===============================================================

    public static _And_Not_ not() {
        return new _And_Not_(new And(new XPathy()));
    }

    public static _And_Manipulation_ withTrim() {
        XPathy xPathy = new XPathy();
        xPathy.is_trim = true;
        return new _And_Manipulation_(new And(xPathy));
    }

    public static _And_Manipulation_ withNormalizeSpace() {
        XPathy xPathy = new XPathy();
        xPathy.is_normalize_space = true;
        return new _And_Manipulation_(new And(xPathy));
    }

    public static _And_Manipulation_ withCase(Case thisCase) {
        XPathy xPathy = new _TranslateBuilder_(new XPathy()).setCase(thisCase);
        return new _And_Manipulation_(new And(xPathy));
    }

    public static _And_Manipulation_ withRemoveOnly(Only... onlyItems) {
        XPathy xPathy = new _TranslateBuilder_(new XPathy()).setRemoveChars(onlyItems);
        return new _And_Manipulation_(new And(xPathy));
    }

    public static _And_Manipulation_ withKeepOnly(Only... onlyItems) {
        XPathy xPathy = new _TranslateBuilder_(new XPathy()).setKeepOnlyChars(onlyItems);
        return new _And_Manipulation_(new And(xPathy));
    }

    public static _And_Manipulation_ withTranslate(String charactersToReplace, String replacementCharacters) {
        XPathy xPathy = new _TranslateBuilder_(new XPathy()).setTranslate(charactersToReplace, replacementCharacters);
        return new _And_Manipulation_(new And(xPathy));
    }

    //===============================================================

    public static And haveIt() {
        return new And(Expressions.HAVE_IT);
    }

    public static And equals(String equalValue) {
        And and = new And(Expressions.EQUALS_TEXT_VALUE);
        and.value = equalValue;
        return and;
    }

    public static And equals(Number equalNumber) {
        And and = new And(Expressions.EQUALS_NUMBER_VALUE);
        and.number = equalNumber;
        return and;
    }

    public static And contains(String containsValue) {
        And and = new And(Expressions.CONTAINS);
        and.value = containsValue;
        return and;
    }

    public static And startsWith(String startsWithValue) {
        And and = new And(Expressions.STARTS_WITH);
        and.value = startsWithValue;
        return and;
    }

    public static And greaterThan(Number min) {
        And and = new And(Expressions.GREATER_THAN);
        and.min = min;
        return and;
    }

    public static And greaterThanOrEquals(Number min) {
        And and = new And(Expressions.GREATER_THAN_OR_EQUALS);
        and.min = min;
        return and;
    }

    public static And lessThan(Number max) {
        And and = new And(Expressions.LESS_THAN);
        and.max = max;
        return and;
    }

    public static And lessThanOrEquals(Number max) {
        And and = new And(Expressions.LESS_THAN_OR_EQUALS);
        and.max = max;
        return and;
    }

    public static And between(Number min, Number max) {
        And and = new And(Expressions.BETWEEN);
        and.min = min;
        and.max = max;
        return and;
    }

    public static And isEmpty() {
        return new And(Expressions.IS_EMPTY);
    }

    public static And isNumeric() {
        return new And(Expressions.IS_NUMERIC);
    }

}

