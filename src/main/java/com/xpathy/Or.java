package com.xpathy;

public class Or {

    protected XPathy xPathy;
    protected boolean isNot;

    protected Expressions expressions;

    protected String value;
    protected Number number;

    protected Number min;
    protected Number max;


    protected Or(Expressions expressions) {
        this.expressions = expressions;
    }

    protected Or(XPathy xPathy) {
        this.xPathy = xPathy;
    }

    //=====================================================================

    public static _Or_Not_ not(){
        return new _Or_Not_(new Or(new XPathy()));
    }

    public static _Or_Manipulation_ withTrim() {
        XPathy xPathy = new XPathy();
        xPathy.is_trim = true;
        return new _Or_Manipulation_(new Or(xPathy));
    }


    public static _Or_Manipulation_ withNormalizeSpace() {
        XPathy xPathy = new XPathy();
        xPathy.is_normalize_space = true;
        return new _Or_Manipulation_(new Or(xPathy));
    }

    public static _Or_Manipulation_ withCase(Case thisCase) {
        XPathy xPathy = new _TranslateBuilder_(new XPathy()).setCase(thisCase);
        return new _Or_Manipulation_(new Or(xPathy));
    }

    public static _Or_Manipulation_ withRemoveOnly(Only... onlyItems) {
        XPathy xPathy = new _TranslateBuilder_(new XPathy()).setRemoveChars(onlyItems);
        return new _Or_Manipulation_(new Or(xPathy));
    }

    public static  _Or_Manipulation_ withKeepOnly(Only... onlyItems) {
        XPathy xPathy = new _TranslateBuilder_(new XPathy()).setKeepOnlyChars(onlyItems);
        return new _Or_Manipulation_(new Or(xPathy));
    }

    public static _Or_Manipulation_ withTranslate(String charactersToReplace, String replacementCharacters) {
        XPathy xPathy = new _TranslateBuilder_(new XPathy()).setTranslate(charactersToReplace, replacementCharacters);
        return new _Or_Manipulation_(new Or(xPathy));
    }

    //=====================================================================

    public static Or haveIt() {
        return new Or(Expressions.HAVE_IT);
    }

    public static Or equals(String equalValue) {
        Or or = new Or(Expressions.EQUALS_TEXT_VALUE);
        or.value = equalValue;
        return or;
    }

    public static Or equals(Number equalNumber) {
        Or or = new Or(Expressions.EQUALS_NUMBER_VALUE);
        or.number = equalNumber;
        return or;
    }

    public static Or contains(String containsValue) {
        Or or = new Or(Expressions.CONTAINS);
        or.value = containsValue;
        return or;
    }

    public static Or startsWith(String startsWithValue) {
        Or or = new Or(Expressions.STARTS_WITH);
        or.value = startsWithValue;
        return or;
    }

    public static Or greaterThan(Number min) {
        Or or = new Or(Expressions.GREATER_THAN);
        or.min = min;
        return or;
    }

    public static Or greaterThanOrEquals(Number min) {
        Or or = new Or(Expressions.GREATER_THAN_OR_EQUALS);
        or.min = min;
        return or;
    }

    public static Or lessThan(Number max) {
        Or or = new Or(Expressions.LESS_THAN);
        or.max = max;
        return or;
    }

    public static Or lessThanOrEquals(Number max) {
        Or or = new Or(Expressions.LESS_THAN_OR_EQUALS);
        or.max = max;
        return or;
    }

    public static Or between(Number min, Number max) {
        Or or = new Or(Expressions.BETWEEN);
        or.min = min;
        or.max = max;
        return or;
    }

    public static Or isEmpty() {
        return new Or(Expressions.IS_EMPTY);
    }

    public static Or isNumeric() {
        return new Or(Expressions.IS_NUMERIC);
    }


}
