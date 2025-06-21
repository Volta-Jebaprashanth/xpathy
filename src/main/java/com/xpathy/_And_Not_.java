package com.xpathy;

public class _And_Not_ {

    protected And and;

    protected _And_Not_(And and) {
        this.and = and;
    }

    public And haveIt() {
        this.and.expressions = Expressions.HAVE_IT;
        this.and.isNot = true;
        return this.and;
    }

    public And equals(String equalValue) {
        this.and.expressions = Expressions.EQUALS_TEXT_VALUE;
        this.and.isNot = true;
        this.and.value = equalValue;
        return this.and;
    }

    public And equals(Number equalNumber) {
        this.and.expressions = Expressions.EQUALS_NUMBER_VALUE;
        this.and.isNot = true;
        this.and.number = equalNumber;
        return this.and;
    }

    public And contains(String containsValue) {
        this.and.expressions = Expressions.CONTAINS;
        this.and.isNot = true;
        this.and.value = containsValue;
        return this.and;
    }

    public And startsWith(String startsWithValue) {
        this.and.expressions = Expressions.STARTS_WITH;
        this.and.isNot = true;
        this.and.value = startsWithValue;
        return this.and;
    }

    public And greaterThan(Number min) {
        this.and.expressions = Expressions.GREATER_THAN;
        this.and.isNot = true;
        this.and.min = min;
        return this.and;
    }

    public And greaterThanOrEquals(Number min) {
        this.and.expressions = Expressions.GREATER_THAN_OR_EQUALS;
        this.and.isNot = true;
        this.and.min = min;
        return this.and;
    }

    public And lessThan(Number max) {
        this.and.expressions = Expressions.LESS_THAN;
        this.and.isNot = true;
        this.and.max = max;
        return this.and;
    }

    public And lessThanOrEquals(Number max) {
        this.and.expressions = Expressions.LESS_THAN_OR_EQUALS;
        this.and.isNot = true;
        this.and.max = max;
        return this.and;
    }

    public And between(Number min, Number max) {
        this.and.expressions = Expressions.BETWEEN;
        this.and.isNot = true;
        this.and.min = min;
        this.and.max = max;
        return this.and;
    }

    public And isEmpty() {
        this.and.expressions = Expressions.IS_EMPTY;
        this.and.isNot = true;
        return this.and;
    }

    public And isNumeric() {
        this.and.expressions = Expressions.IS_NUMERIC;
        this.and.isNot = true;
        return this.and;
    }
}
