package com.xpathy;

public class _Or_Manipulation_ {

    protected Or or;

    protected _Or_Manipulation_(Or or) {
        this.or = or;
    }

    //======================================================

    public _Or_Not_ NOT(){
        return new _Or_Not_(this.or);
    }

    //======================================================

    public _Or_Manipulation_ TRIM() {
        this.or.xPathy.is_trim = true;
        return new _Or_Manipulation_(this.or);
    }

    public _Or_Manipulation_ NORMALIZE_SPACE() {
        this.or.xPathy.is_normalize_space = true;
        return new _Or_Manipulation_(this.or);
    }

    public _Or_Manipulation_ CASE(Case thisCase) {
        this.or.xPathy = new _TranslateBuilder_(this.or.xPathy).setCase(thisCase);
        return new _Or_Manipulation_(this.or);
    }

    public _Or_Manipulation_ REMOVE(Only... onlyItems) {
        this.or.xPathy = new _TranslateBuilder_(this.or.xPathy).setRemoveChars(onlyItems);
        return new _Or_Manipulation_(this.or);
    }

    public _Or_Manipulation_ KEEP(Only... onlyItems) {
        this.or.xPathy = new _TranslateBuilder_(this.or.xPathy).setKeepOnlyChars(onlyItems);
        return new _Or_Manipulation_(this.or);
    }

    public _Or_Manipulation_ TRANSLATE(String charactersToReplace, String replacementCharacters) {
        this.or.xPathy = new _TranslateBuilder_(this.or.xPathy).setTranslate(charactersToReplace, replacementCharacters);
        return new _Or_Manipulation_(this.or);
    }

    //=====================================================================

    public Or haveIt() {
        this.or.expressions = Expressions.HAVE_IT;
        return this.or;
    }

    public Or equals(String equalValue) {
        this.or.expressions = Expressions.EQUALS_TEXT_VALUE;
        this.or.value = equalValue;
        return this.or;
    }

    public Or equals(Number equalNumber) {
        this.or.expressions = Expressions.EQUALS_NUMBER_VALUE;
        this.or.number = equalNumber;
        return this.or;
    }

    public Or contains(String containsValue) {
        this.or.expressions = Expressions.CONTAINS;
        this.or.value = containsValue;
        return this.or;
    }

    public Or startsWith(String startsWithValue) {
        this.or.expressions = Expressions.STARTS_WITH;
        this.or.value = startsWithValue;
        return this.or;
    }

    public Or greaterThan(Number min) {
        this.or.expressions = Expressions.GREATER_THAN;
        this.or.min = min;
        return this.or;
    }

    public Or greaterThanOrEquals(Number min) {
        this.or.expressions = Expressions.GREATER_THAN_OR_EQUALS;
        this.or.min = min;
        return this.or;
    }

    public Or lessThan(Number max) {
        this.or.expressions = Expressions.LESS_THAN;
        this.or.max = max;
        return this.or;
    }

    public Or lessThanOrEquals(Number max) {
        this.or.expressions = Expressions.LESS_THAN_OR_EQUALS;
        this.or.max = max;
        return this.or;
    }

    public Or between(Number min, Number max) {
        this.or.expressions = Expressions.BETWEEN;
        this.or.min = min;
        this.or.max = max;
        return this.or;
    }

    public Or isEmpty() {
        this.or.expressions = Expressions.IS_EMPTY;
        return this.or;
    }

    public Or isNumeric() {
        this.or.expressions = Expressions.IS_NUMERIC;
        return this.or;
    }

}
