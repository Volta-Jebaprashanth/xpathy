package com.xpathy;

public class __HavingXpathTransformer_ {

    protected XPathy thisXPathy;

    protected __HavingXpathTransformer_(XPathy xPathy){
        this.thisXPathy = xPathy;
    }


    protected static String removeDoubleSlash(String xpath){
        if(xpath.trim().startsWith("//")){
            return xpath.trim().substring(2);
        }
        return xpath;
    }

    protected XPathy direct(XPathy xPathy){
        XPathy copy = thisXPathy.copy();
        String function = removeDoubleSlash(xPathy.xpath);

        copy.xpath = new _AppendAndOr_(copy).append("( " + function + " )");

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    protected XPathy anyAncestors(XPathy xPathy){
        XPathy copy = this.thisXPathy.copy();
        String function = removeDoubleSlash(xPathy.xpath);
        String prefix = "ancestor::";

        copy.xpath = new _AppendAndOr_(copy).append("( " + prefix + function + " )");

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    protected XPathy parent(XPathy xPathy){
        XPathy copy = thisXPathy.copy();
        String function = removeDoubleSlash(xPathy.xpath);
        String prefix = "parent::";

        copy.xpath = new _AppendAndOr_(copy).append("( " + prefix + function + " )");

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    protected XPathy anyDescendants(XPathy xPathy){
        XPathy copy = thisXPathy.copy();
        String function = removeDoubleSlash(xPathy.xpath);
        String prefix = ".//";

        copy.xpath = new _AppendAndOr_(copy).append("( " + prefix + function + " )");

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    protected  XPathy anyChild(XPathy xPathy){
        XPathy copy = thisXPathy.copy();
        String function = removeDoubleSlash(xPathy.xpath);
        String prefix = "./";

        copy.xpath = new _AppendAndOr_(copy).append("( " + prefix + function + " )");

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    public XPathy anyFollowingSibling(XPathy xPathy){
        XPathy copy = thisXPathy.copy();
        String function = removeDoubleSlash(xPathy.xpath);
        String prefix = "following-sibling::";

        copy.xpath = new _AppendAndOr_(copy).append("( " + prefix + function + " )");

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    public XPathy anyPrecedingSibling(XPathy xPathy){
        XPathy copy = thisXPathy.copy();
        String function = removeDoubleSlash(xPathy.xpath);
        String prefix = "preceding-sibling::";

        copy.xpath = new _AppendAndOr_(copy).append("( " + prefix + function + " )");

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }







}
