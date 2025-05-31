package com.xpathy;

public class __Having_Init_ {
    protected XPathy xPathy;

    protected __Having_Init_(XPathy xPathy) {
        this.xPathy = xPathy;
    }

    public __Having_ ANY_ANCESTOR() {
        __Having_ after = new __Having_(xPathy);
        after.xPathy.having_condition_prefix = "ancestor::*";
        return after;
    }

    public __Having_ ANCESTOR(Tag tag) {
        __Having_ after = new __Having_(xPathy);
        after.xPathy.having_condition_prefix = "ancestor::" + tag.toString();
        return after;
    }

    public __Having_ PARENT() {
        __Having_ after = new __Having_(xPathy);
        after.xPathy.having_condition_prefix = "parent::*";
        return after;
    }

    public __Having_ PARENT(Tag tag) {
        __Having_ after = new __Having_(xPathy);
        after.xPathy.having_condition_prefix = "parent::" + tag.toString();
        return after;
    }

    public __Having_ ANY_DESCENDANT() {
        __Having_ after = new __Having_(xPathy);
        after.xPathy.having_condition_prefix = ".//*";
        return after;
    }

    public __Having_ DESCENDANT(Tag tag) {
        __Having_ after = new __Having_(xPathy);
        after.xPathy.having_condition_prefix = ".//" + tag.toString();
        return after;
    }

    public __Having_ ANY_CHILD() {
        __Having_ after = new __Having_(xPathy);
        after.xPathy.having_condition_prefix = "./*";
        return after;
    }

    public __Having_ CHILD(Tag tag) {
        __Having_ after = new __Having_(xPathy);
        after.xPathy.having_condition_prefix = "./" + tag.toString();
        return after;
    }

    public __Having_ ANY_FOLLOWING_SIBLING() {
        __Having_ after = new __Having_(xPathy);
        after.xPathy.having_condition_prefix = "following-sibling::*";
        return after;
    }

    public __Having_ FOLLOWING_SIBLING(Tag tag) {
        __Having_ after = new __Having_(xPathy);
        after.xPathy.having_condition_prefix = "following-sibling::" + tag.toString();
        return after;
    }

    public __Having_ ANY_PRECEDING_SIBLING() {
        __Having_ after = new __Having_(xPathy);
        after.xPathy.having_condition_prefix = "preceding-sibling::*";
        return after;
    }

    public __Having_ PRECEDING_SIBLING(Tag tag) {
        __Having_ after = new __Having_(xPathy);
        after.xPathy.having_condition_prefix = "preceding-sibling::" + tag.toString();
        return after;
    }
}