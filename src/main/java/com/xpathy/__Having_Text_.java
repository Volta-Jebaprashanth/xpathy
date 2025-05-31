package com.xpathy;

public class __Having_Text_ {

    protected XPathy xPathy;
    private static final String BASE_FUNCTION = "text()";

    protected __Having_Text_(XPathy xPathy){
        this.xPathy = xPathy;
    }

    protected __Having_Text_ copy(){
        return new __Having_Text_(this.xPathy);
    }

    public __Having_Text_ TRIM() {
        __Having_Text_ copy = this.copy();
        copy.xPathy.is_trim = true;
        return copy;
    }

    public __Having_Text_ NORMALIZE_SPACE() {
        __Having_Text_ copy = this.copy();
        copy.xPathy.is_normalize_space = true;
        return copy;
    }

    public __Having_Text_ CASE(Case thisCase) {
        __Having_Text_ copy = this.copy();
        copy.xPathy = new _TranslateBuilder_(this.xPathy).setCase(thisCase);
        return copy;
    }

    public __Having_Text_ REMOVE(Only... onlyItems) {
        __Having_Text_ copy = this.copy();
        copy.xPathy = new _TranslateBuilder_(this.xPathy).setRemoveChars(onlyItems);
        return copy;
    }


    public __Having_Text_ KEEP(Only... onlyItems) {
        __Having_Text_ copy = this.copy();
        copy.xPathy = new _TranslateBuilder_(this.xPathy).setKeepOnlyChars(onlyItems);
        return copy;
    }

    public __Having_Text_ TRANSLATE(String charactersToReplace, String replacementCharacters) {
        __Having_Text_ copy = this.copy();
        copy.xPathy = new _TranslateBuilder_(this.xPathy).setTranslate(charactersToReplace, replacementCharacters);
        return copy;
    }

    //-----------------------------------------------------------------

    public __Having_Text_Not_ NOT(){
        return new __Having_Text_Not_(this.xPathy);
    }

    public __Having_Text_Length_ LENGTH(){
        return new __Having_Text_Length_(this.xPathy);
    }

    //-----------------------------------------------------------------

    public XPathy equals(String equalText) {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String function = transformer.buildFunctionExpression(BASE_FUNCTION);
        String value = transformer.applyModifiersToValue(equalText);

        copy.xpath = new _AppendAndOr_(copy).append(
                this.xPathy.having_condition_prefix + "["+
                function + " = '" + value + "']");

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }


    public XPathy contains(String partialText) {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String function = transformer.buildFunctionExpression(BASE_FUNCTION);
        String value = transformer.applyModifiersToValue(partialText);

        copy.xpath = new _AppendAndOr_(copy).append(
                this.xPathy.having_condition_prefix + "["+
                "contains(" + function + ", '" + value + "')]");

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    public XPathy startsWith(String prefixText) {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String function = transformer.buildFunctionExpression(BASE_FUNCTION);
        String value = transformer.applyModifiersToValue(prefixText);

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

        // Use normalize-space to handle missing or whitespace-only text nodes
        String function = transformer.buildFunctionExpression("normalize-space(text())");

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
        String function = transformer.buildFunctionExpression(BASE_FUNCTION);

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
        String function = transformer.buildFunctionExpression(BASE_FUNCTION);

        copy.xpath = new _AppendAndOr_(copy).append(
                this.xPathy.having_condition_prefix + "["+
                function + " = " + number + "]");

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    public XPathy greaterThan(Number number) {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String function = transformer.buildFunctionExpression(BASE_FUNCTION);

        copy.xpath = new _AppendAndOr_(copy).append(
                this.xPathy.having_condition_prefix + "["+
                function + " > " + number + "]");

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    public XPathy greaterThanOrEquals(Number number) {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String function = transformer.buildFunctionExpression(BASE_FUNCTION);

        copy.xpath =new _AppendAndOr_(copy).append(
                this.xPathy.having_condition_prefix + "["+
                function + " >= " + number + "]");

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    public XPathy lessThan(Number number) {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String function = transformer.buildFunctionExpression(BASE_FUNCTION);

        copy.xpath =new _AppendAndOr_(copy).append(
                this.xPathy.having_condition_prefix + "["+
                function + " < " + number + "]");

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    public XPathy lessThanOrEquals(Number number) {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String function = transformer.buildFunctionExpression(BASE_FUNCTION);

        copy.xpath =new _AppendAndOr_(copy).append(
                this.xPathy.having_condition_prefix + "["+
                function + " <= " + number + "]");

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

}
