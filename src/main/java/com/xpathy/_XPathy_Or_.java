package com.xpathy;

public class _XPathy_Or_ {

   protected XPathy xPathy;

   protected _XPathy_Or_(XPathy xPathy){
       this.xPathy = xPathy;
   }

    public _Attribute_ byAttribute(Attribute attribute) {
        return new _Attribute_(this.xPathy, attribute);
    }

    public _Number_ byNumber() {
        return new _Number_(this.xPathy);
    }

    public _Text_ byText() {
        return new _Text_(this.xPathy);
    }

    public _Style_ byStyle(Style style) {
        return new _Style_(this.xPathy, style);
    }

    public __Having_Init_ byHaving(){
        return new __Having_Init_(this.xPathy);
    }

    public XPathy byHaving(XPathy xPathy){
        return new __HavingXpathTransformer_(this.xPathy).direct(xPathy);
    }



    //======================================== DOM NAVIGATION ========================================

    public XPathy tag(Tag tag) {
       return xPathy.$tag(tag);
    }

}
