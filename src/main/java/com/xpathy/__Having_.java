package com.xpathy;

public class __Having_ {

    protected XPathy xPathy;

    protected __Having_(XPathy xPathy){
        this.xPathy = xPathy;
    }

    public __Having_Attribute_ byAttribute(Attribute attribute) {
        return new __Having_Attribute_(attribute, this.xPathy);
    }

    public __Having_Number_ byNumber() {
        return new __Having_Number_(this.xPathy);
    }

    public __Having_Text_ byText() {
        return new __Having_Text_(this.xPathy);
    }
}
