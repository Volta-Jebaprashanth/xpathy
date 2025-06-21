package com.xpathy;

public class _Or_Not_ {

    protected Or or;

    protected _Or_Not_(Or or) {
        this.or = or;
    }

    public Or haveIt() {
        this.or.expressions = Expressions.HAVE_IT;
        this.or.isNot = true;
        return this.or;
    }


    public Or equals(String equalValue) {
        this.or.expressions = Expressions.EQUALS_TEXT_VALUE;
        this.or.isNot = true;
        this.or.value = equalValue;
        return this.or;
    }

    public Or equals(Number equalNumber) {
        this.or.expressions = Expressions.EQUALS_NUMBER_VALUE;
        this.or.isNot = true;
        this.or.number = equalNumber;
        return this.or;
    }

    public Or contains(String containsValue) {
        this.or.expressions = Expressions.CONTAINS;
        this.or.isNot = true;
        this.or.value = containsValue;
        return this.or;
    }

    public Or startsWith(String startsWithValue) {
        this.or.expressions = Expressions.STARTS_WITH;
        this.or.isNot = true;
        this.or.value = startsWithValue;
        return this.or;
    }

    public Or greaterThan(Number min) {
        this.or.expressions = Expressions.GREATER_THAN;
        this.or.isNot = true;
        this.or.min = min;
        return this.or;
    }

    public Or greaterThanOrEquals(Number min) {
        this.or.expressions = Expressions.GREATER_THAN_OR_EQUALS;
        this.or.isNot = true;
        this.or.min = min;
        return this.or;
    }

    public Or lessThan(Number max) {
        this.or.expressions = Expressions.LESS_THAN;
        this.or.isNot = true;
        this.or.max = max;
        return this.or;
    }

    public Or lessThanOrEquals(Number max) {
        this.or.expressions = Expressions.LESS_THAN_OR_EQUALS;
        this.or.isNot = true;
        this.or.max = max;
        return this.or;
    }

    public Or between(Number min, Number max) {
        this.or.expressions = Expressions.BETWEEN;
        this.or.isNot = true;
        this.or.max = max;
        this.or.min = min;
        return this.or;
    }

    public Or isEmpty() {
        this.or.expressions = Expressions.IS_EMPTY;
        this.or.isNot = true;
        return this.or;
    }

    public Or isNumeric() {
        this.or.expressions = Expressions.IS_NUMERIC;
        this.or.isNot = true;
        return this.or;
    }
}
