package com.xpathy;

public class _Style_ {

    protected XPathy xPathy;
    protected String style;

    protected _Style_(XPathy xPathy, Style style){
        this.xPathy = new _TranslateBuilder_(xPathy).setRemoveChars(Only.SPACES);
        this.style = style.toString();
    }

    protected _Style_(XPathy xPathy, String style){
        this.xPathy = new _TranslateBuilder_(xPathy).setRemoveChars(Only.SPACES);
        this.style = style;
    }

    public _Style_Not_ NOT(){
        return new _Style_Not_(this.xPathy, this.style);
    }

    public XPathy haveIt(){
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String function = transformer.buildFunctionExpression("@style");

        String key = transformer.applyModifiersToValue(this.style + ":");

        String condition = "contains(" + function + ", '" + key + "')";

        copy.xpath = new _AppendAndOr_(copy).append(condition);
        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    public XPathy equals(String Value) {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String function = transformer.buildFunctionExpression("@style");
        String value = transformer.applyModifiersToValue(this.style + ":" + Value + ";");

        copy.xpath = new _AppendAndOr_(copy).append("contains(" + function + ", '" + value + "')");

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }
}
