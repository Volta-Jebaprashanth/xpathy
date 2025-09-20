package com.xpathy;

public class Condition {

    protected ConditionType conditionType;
    protected String condition = null;

    protected boolean isSkip = false;

    protected Condition[] conditions;

    protected Condition(ConditionType type){
        this.conditionType = type;
    }

    public static Condition and(Condition... conditions){
        Condition condition = new Condition(ConditionType.AND);
        condition.conditions = conditions;
        return condition;
    }

    public static Condition and(){
        Condition condition = new Condition(ConditionType.AND);
        condition.isSkip = true;
        return condition;
    }

    public static Condition or(Condition... conditions){
        Condition condition = new Condition(ConditionType.OR);
        condition.conditions = conditions;
        return condition;
    }

    public static Condition or(){
        Condition condition = new Condition(ConditionType.OR);
        condition.isSkip = true;
        return condition;
    }

    public static Condition not(Condition condition){
        Condition condition1 =  new Condition(ConditionType.NOT);
        condition1.conditions = new Condition[]{condition};
        return condition1;


    }

    public static _Condition_Attribute_ attribute(Attribute attribute){
        return new _Condition_Attribute_(attribute);
    }

    public static _Condition_Text_ text(){
        return new _Condition_Text_();
    }

    public static _Condition_Number_ number(){
        return new _Condition_Number_();
    }

    public static _Condition_Style_ style(Style style){
        return new _Condition_Style_(style);
    }

    protected String getCondition(){

        String beginning = "( ";
        String end = " )";

        if (this.conditionType.equals(ConditionType.AND) && conditions != null){
            StringBuilder sb = new StringBuilder(beginning);

            for (int i = 0; i < conditions.length; i++) {
                if (i > 0 && !conditions[i].isSkip && !conditions[i-1].isSkip) {
                    sb.append(" and ");
                }
                sb.append(conditions[i].getCondition());
            }

            sb.append(end);
            return sb.toString();
        }

        if (this.conditionType.equals(ConditionType.OR) && conditions != null){
            StringBuilder sb = new StringBuilder(beginning);

            for (int i = 0; i < conditions.length; i++) {
                if (i > 0 && !conditions[i].isSkip && !conditions[i-1].isSkip) {
                    sb.append(" or ");
                }
                sb.append(conditions[i].getCondition());
            }

            sb.append(end);
            return sb.toString();
        }

        if (this.conditionType.equals(ConditionType.NOT) && conditions != null){
            return "not (" + this.conditions[0].getCondition() + ")";
        }

        else if (!this.isSkip){
            return this.condition;
        }

        return "";

    }


    protected enum ConditionType {
        ATTRIBUTE,
        TEXT,
        NUMBER,
        STYLE,
        HAVING,
        AND,
        OR,
        NOT
    }

    protected static String extractConditionString_fromXpath(XPathy xPathy){
        return xPathy.xpath.substring(4, xPathy.xpath.length() - 1);
    }


}
