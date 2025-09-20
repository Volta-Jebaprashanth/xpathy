package com.xpathy;

public class __Having_Init_ {
    protected XPathy xPathy;

    protected __Having_Init_(XPathy xPathy) {
        this.xPathy = xPathy;
    }

    public __Having_ ancestor() {
        __Having_ after = new __Having_(xPathy);
        after.xPathy.having_condition_prefix = "ancestor::*";
        return after;
    }

    public __Having_ ancestor(Tag tag) {
        __Having_ after = new __Having_(xPathy);
        after.xPathy.having_condition_prefix = "ancestor::" + tag.toString();
        return after;
    }

    public XPathy ancestor(XPathy xPathy){
        return new __HavingXpathTransformer_(this.xPathy).anyAncestors(xPathy);
    }

    public __Having_ parent() {
        __Having_ after = new __Having_(xPathy);
        after.xPathy.having_condition_prefix = "parent::*";
        return after;
    }

    public __Having_ parent(Tag tag) {
        __Having_ after = new __Having_(xPathy);
        after.xPathy.having_condition_prefix = "parent::" + tag.toString();
        return after;
    }

    public XPathy parent(XPathy xPathy){
        return new __HavingXpathTransformer_(this.xPathy).parent(xPathy);
    }

    public __Having_ descendant() {
        __Having_ after = new __Having_(xPathy);
        after.xPathy.having_condition_prefix = ".//*";
        return after;
    }

    public __Having_ descendant(Tag tag) {
        __Having_ after = new __Having_(xPathy);
        after.xPathy.having_condition_prefix = ".//" + tag.toString();
        return after;
    }

    public XPathy descendant(XPathy xPathy){
        return new __HavingXpathTransformer_(this.xPathy).anyDescendants(xPathy);
    }

    public __Having_ child() {
        __Having_ after = new __Having_(xPathy);
        after.xPathy.having_condition_prefix = "./*";
        return after;
    }

    public __Having_ child(Tag tag) {
        __Having_ after = new __Having_(xPathy);
        after.xPathy.having_condition_prefix = "./" + tag.toString();
        return after;
    }

    public XPathy child(XPathy xPathy){
        return new __HavingXpathTransformer_(this.xPathy).anyChild(xPathy);
    }

    public __Having_ followingSibling() {
        __Having_ after = new __Having_(xPathy);
        after.xPathy.having_condition_prefix = "following-sibling::*";
        return after;
    }

    public __Having_ followingSibling(Tag tag) {
        __Having_ after = new __Having_(xPathy);
        after.xPathy.having_condition_prefix = "following-sibling::" + tag.toString();
        return after;
    }

    public XPathy followingSibling(XPathy xPathy){
        return new __HavingXpathTransformer_(this.xPathy).anyFollowingSibling(xPathy);
    }

    public __Having_ precedingSibling() {
        __Having_ after = new __Having_(xPathy);
        after.xPathy.having_condition_prefix = "preceding-sibling::*";
        return after;
    }

    public __Having_ precedingSibling(Tag tag) {
        __Having_ after = new __Having_(xPathy);
        after.xPathy.having_condition_prefix = "preceding-sibling::" + tag.toString();
        return after;
    }

    public XPathy precedingSibling(XPathy xPathy){
        return new __HavingXpathTransformer_(this.xPathy).anyPrecedingSibling(xPathy);
    }
}