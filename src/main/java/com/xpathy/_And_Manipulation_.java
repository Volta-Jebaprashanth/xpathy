package com.xpathy;

public class _And_Manipulation_ {

    protected And and;

    protected _And_Manipulation_(And and) {
        this.and = and;
    }

    //======================================================

    public _And_Not_ not() {
        return new _And_Not_(this.and);
    }

    //======================================================

    public _And_Manipulation_ withTrim() {
        this.and.xPathy.is_trim = true;
        return new _And_Manipulation_(this.and);
    }

    public _And_Manipulation_ withNormalizeSpace() {
        this.and.xPathy.is_normalize_space = true;
        return new _And_Manipulation_(this.and);
    }

    public _And_Manipulation_ withCase(Case thisCase) {
        this.and.xPathy = new _TranslateBuilder_(this.and.xPathy).setCase(thisCase);
        return new _And_Manipulation_(this.and);
    }

    public _And_Manipulation_ withRemoveOnly(Only... onlyItems) {
        this.and.xPathy = new _TranslateBuilder_(this.and.xPathy).setRemoveChars(onlyItems);
        return new _And_Manipulation_(this.and);
    }

    public _And_Manipulation_ withKeepOnly(Only... onlyItems) {
        this.and.xPathy = new _TranslateBuilder_(this.and.xPathy).setKeepOnlyChars(onlyItems);
        return new _And_Manipulation_(this.and);
    }

    public _And_Manipulation_ withTranslate(String charactersToReplace, String replacementCharacters) {
        this.and.xPathy = new _TranslateBuilder_(this.and.xPathy).setTranslate(charactersToReplace, replacementCharacters);
        return new _And_Manipulation_(this.and);
    }

    //=====================================================================

    public And haveIt() {
        this.and.expressions = Expressions.HAVE_IT;
        return this.and;
    }

    public And equals(String equalValue) {
        this.and.expressions = Expressions.EQUALS_TEXT_VALUE;
        this.and.value = equalValue;
        return this.and;
    }

    public And equals(Number equalNumber) {
        this.and.expressions = Expressions.EQUALS_NUMBER_VALUE;
        this.and.number = equalNumber;
        return this.and;
    }

    public And contains(String containsValue) {
        this.and.expressions = Expressions.CONTAINS;
        this.and.value = containsValue;
        return this.and;
    }

    public And startsWith(String startsWithValue) {
        this.and.expressions = Expressions.STARTS_WITH;
        this.and.value = startsWithValue;
        return this.and;
    }

    public And greaterThan(Number min) {
        this.and.expressions = Expressions.GREATER_THAN;
        this.and.min = min;
        return this.and;
    }

    public And greaterThanOrEquals(Number min) {
        this.and.expressions = Expressions.GREATER_THAN_OR_EQUALS;
        this.and.min = min;
        return this.and;
    }

    public And lessThan(Number max) {
        this.and.expressions = Expressions.LESS_THAN;
        this.and.max = max;
        return this.and;
    }

    public And lessThanOrEquals(Number max) {
        this.and.expressions = Expressions.LESS_THAN_OR_EQUALS;
        this.and.max = max;
        return this.and;
    }

    public And between(Number min, Number max) {
        this.and.expressions = Expressions.BETWEEN;
        this.and.min = min;
        this.and.max = max;
        return this.and;
    }

    public And isEmpty() {
        this.and.expressions = Expressions.IS_EMPTY;
        return this.and;
    }

    public And isNumeric() {
        this.and.expressions = Expressions.IS_NUMERIC;
        return this.and;
    }
}
