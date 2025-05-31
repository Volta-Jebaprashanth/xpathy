package com.xpathy;

public class _AppendAndOr_ {

    protected XPathy xPathy;

    protected _AppendAndOr_(XPathy xPathy) {
        this.xPathy = xPathy;
    }

    protected String append(String condition) {
        if (xPathy.is_and_or_condition_appendable
                & !xPathy.condition.equals(XPathy.Condition.NONE)) {

            String base = this.xPathy.xpath.trim();
            base = base.substring(0, base.length() - 1);

            if (xPathy.condition.equals(XPathy.Condition.AND)) {
                return base + " and " + condition + "]";

            } else if (xPathy.condition.equals(XPathy.Condition.OR)) {
                return base + " or " + condition + "]";

            }
        }

        if (!xPathy.is_and_or_condition_appendable
                & xPathy.condition.equals(XPathy.Condition.OR)) {
            return this.xPathy.xpath + " | //*" + "[" + condition + "]";
        }

        return this.xPathy.xpath + "[" + condition + "]";


    }

}
