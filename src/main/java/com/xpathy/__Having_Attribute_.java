package com.xpathy;

public class __Having_Attribute_ {

    protected XPathy xPathy;
    protected String attribute;

    protected __Having_Attribute_(Attribute attribute, XPathy xPathy){
        this.xPathy = xPathy;
        this.attribute = attribute.toString();
    }

    protected __Having_Attribute_(String attribute, XPathy xPathy){
        this.attribute = attribute;
        this.xPathy = xPathy;
    }

    protected __Having_Attribute_ copy(){
        return new __Having_Attribute_(this.attribute, this.xPathy);
    }

    public __Having_Attribute_ TRIM() {
        __Having_Attribute_ copy = this.copy();
        copy.xPathy.is_trim = true;
        return copy;
    }

    public __Having_Attribute_ NORMALIZE_SPACE() {
        __Having_Attribute_ copy = this.copy();
        copy.xPathy.is_normalize_space = true;
        return copy;
    }

    public __Having_Attribute_ CASE(Case thisCase) {
        __Having_Attribute_ copy = this.copy();
        copy.xPathy = new _TranslateBuilder_(this.xPathy).setCase(thisCase);
        return copy;
    }

    public __Having_Attribute_ REMOVE(Only... onlyItems) {
        __Having_Attribute_ copy = this.copy();
        copy.xPathy = new _TranslateBuilder_(this.xPathy).setRemoveChars(onlyItems);
        return copy;
    }


    public __Having_Attribute_ KEEP(Only... onlyItems) {
        __Having_Attribute_ copy = this.copy();
        copy.xPathy = new _TranslateBuilder_(this.xPathy).setKeepOnlyChars(onlyItems);
        return copy;
    }

    public __Having_Attribute_ TRANSLATE(String charactersToReplace, String replacementCharacters) {
        __Having_Attribute_ copy = this.copy();
        copy.xPathy = new _TranslateBuilder_(this.xPathy).setTranslate(charactersToReplace, replacementCharacters);
        return copy;
    }

    //---------------------

    public __Having_Attribute_Not_ NOT(){
        return new __Having_Attribute_Not_(this.attribute, this.xPathy);
    }

    public __Having_Attribute_Length_ LENGTH(){
        return new __Having_Attribute_Length_(this.attribute, this.xPathy);
    }

    //--------------------


    public XPathy haveIt() {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String function = transformer.buildFunctionExpression("@" + this.attribute);

        copy.xpath = new _AppendAndOr_(copy).append(
                this.xPathy.having_condition_prefix + "["+
                function + "]");

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    public XPathy equals(String equalValue) {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String function = transformer.buildFunctionExpression("@" + this.attribute);
        String value = transformer.applyModifiersToValue(equalValue);

        copy.xpath = new _AppendAndOr_(copy).append(
                this.xPathy.having_condition_prefix + "["+
                function + "='" + value + "']");

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    public XPathy contains(String partialValue) {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String function = transformer.buildFunctionExpression("@" + this.attribute);
        String value = transformer.applyModifiersToValue(partialValue);

        copy.xpath = new _AppendAndOr_(copy).append(
                this.xPathy.having_condition_prefix + "["+
                "contains(" + function + ", '" + value + "')]");

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    public XPathy startsWith(String prefix) {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String function = transformer.buildFunctionExpression("@" + this.attribute);
        String value = transformer.applyModifiersToValue(prefix);

        copy.xpath = new _AppendAndOr_(copy).append(
                this.xPathy.having_condition_prefix + "["+
                "starts-with(" + function + ", '" + value + "')]");

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    public XPathy isEmpty() {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String function = transformer.buildFunctionExpression("normalize-space(@" + this.attribute + ")");

        copy.xpath = new _AppendAndOr_(copy).append(
                this.xPathy.having_condition_prefix + "["+
                function + "='']");

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    public XPathy isNumeric() {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String function = transformer.buildFunctionExpression("@" + this.attribute);

        copy.xpath = new _AppendAndOr_(copy).append(
                this.xPathy.having_condition_prefix + "["+
                "string-length(" + function + ") > 0 and not(translate(" + function + ", '0123456789', '') != '')]");

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }


    public XPathy equals(Number number) {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String attr = transformer.buildFunctionExpression("@" + this.attribute);

        copy.xpath = new _AppendAndOr_(copy).append(
                this.xPathy.having_condition_prefix + "["+
                attr + " = " + number + "]");

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    public XPathy greaterThan(Number number) {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String attr = transformer.buildFunctionExpression("@" + this.attribute);

        copy.xpath = new _AppendAndOr_(copy).append(
                this.xPathy.having_condition_prefix + "["+
                attr + " > " + number + "]");

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    public XPathy greaterThanOrEquals(Number number) {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String attr = transformer.buildFunctionExpression("@" + this.attribute);

        copy.xpath = new _AppendAndOr_(copy).append(
                this.xPathy.having_condition_prefix + "["+
                attr + " >= " + number + "]");

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    public XPathy lessThan(Number number) {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String attr = transformer.buildFunctionExpression("@" + this.attribute);

        copy.xpath = new _AppendAndOr_(copy).append(
                this.xPathy.having_condition_prefix + "["+
                attr + " < " + number + "]");

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    public XPathy lessThanOrEquals(Number number) {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String attr = transformer.buildFunctionExpression("@" + this.attribute);

        copy.xpath = new _AppendAndOr_(copy).append(
                this.xPathy.having_condition_prefix + "["+
                attr + " <= " + number + "]");

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }


}
