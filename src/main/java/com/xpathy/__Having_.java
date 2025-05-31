package com.xpathy;

public class __Having_ {

    protected XPathy xPathy;

    protected __Having_(XPathy xPathy){
        this.xPathy = xPathy;
    }

    public __Having_Attribute_ ATTRIBUTE(Attribute attribute) {
        return new __Having_Attribute_(attribute, this.xPathy);
    }

    public __Having_Number_ NUMBER() {
        return new __Having_Number_(this.xPathy);
    }

    public __Having_Text_ TEXT() {
        return new __Having_Text_(this.xPathy);
    }
}
