package com.xpathy;

import org.openqa.selenium.By;

public class _XPathy_Or_ {

   protected XPathy xPathy;

   protected _XPathy_Or_(XPathy xPathy){
       this.xPathy = xPathy;
   }

    public _Attribute_ ATTRIBUTE(Attribute attribute) {
        return new _Attribute_(this.xPathy, attribute);
    }

    public _Number_ NUMBER() {
        return new _Number_(this.xPathy);
    }

    public _Text_ TEXT() {
        return new _Text_(this.xPathy);
    }

    public _Style_ STYLE(Style style) {
        return new _Style_(this.xPathy, style);
    }

    public __Having_Init_ HAVING(){
        return new __Having_Init_(this.xPathy);
    }



    //======================================== DOM NAVIGATION ========================================

    public XPathy tag(Tag tag) {
       return xPathy.tag(tag);
    }

}
