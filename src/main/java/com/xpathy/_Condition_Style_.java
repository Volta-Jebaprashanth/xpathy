package com.xpathy;

public class _Condition_Style_ {
    protected XPathy xPathy;
    protected Style style;

    protected _Condition_Style_(Style style){
        this.xPathy = new XPathy();
        this.style = style;
    }

    public Condition haveIt(){
        Condition condition = new Condition(Condition.ConditionType.STYLE);
        XPathy xPathy = this.xPathy.STYLE(this.style).haveIt().copy();
        condition.condition = Condition.extractConditionString_fromXpath(xPathy);
        return condition;
    }

    public Condition equals(String Value) {
        Condition condition = new Condition(Condition.ConditionType.STYLE);
        XPathy xPathy = this.xPathy.STYLE(this.style).equals(Value).copy();
        condition.condition = Condition.extractConditionString_fromXpath(xPathy);
        return condition;
    }

}
