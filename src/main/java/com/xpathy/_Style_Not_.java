package com.xpathy;

public class _Style_Not_ {

    protected XPathy xPathy;
    protected String style;

    protected _Style_Not_(XPathy xPathy, Style style){
        this.xPathy = new _TranslateBuilder_(xPathy).setRemoveChars(Only.SPACES);
        this.style = style.toString();
    }

    protected _Style_Not_(XPathy xPathy, String style){
        this.xPathy = new _TranslateBuilder_(xPathy).setRemoveChars(Only.SPACES);
        this.style = style;
    }

    public XPathy haveIt() {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String function = transformer.buildFunctionExpression("@style");
        String key = transformer.applyModifiersToValue(this.style + ":");

        String condition = "@style and not(contains(" + function + ", '" + key + "'))";

        copy.xpath = new _AppendAndOr_(copy).append(condition);
        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }


    public XPathy equals(String value) {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String function = transformer.buildFunctionExpression("@style");

        String key = transformer.applyModifiersToValue(this.style + ":");
        String fullValue = transformer.applyModifiersToValue(this.style + ":" + value + ";");

        String condition = "contains(" + function + ", '" + key + "')" +
                " and not(contains(" + function + ", '" + fullValue + "'))";

        copy.xpath = new _AppendAndOr_(copy).append(condition);
        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }
}
