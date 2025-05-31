package com.xpathy;

public class _Text_ {

    private static final String BASE_FUNCTION = "text()";

    protected XPathy xPathy;

    protected _Text_(XPathy xPathy) {
        this.xPathy = xPathy;
    }

    protected _Text_(_Text_ text) {
        this.xPathy = text.xPathy;
    }

    protected _Text_ copy() {
        return new _Text_(this);
    }

    public _Text_Length_ LENGTH() {
        return new _Text_Length_(this.xPathy);
    }

    public _Text_Not_ NOT() {
        return new _Text_Not_(this.xPathy);
    }


    public _Text_ TRIM() {
        _Text_ copy = this.copy();
        copy.xPathy.is_trim = true;
        return copy;
    }

    public _Text_ NORMALIZE_SPACE() {
        _Text_ copy = this.copy();
        copy.xPathy.is_normalize_space = true;
        return copy;
    }

    public _Text_ CASE(Case thisCase) {
        _Text_ copy = this.copy();
        copy.xPathy = new _TranslateBuilder_(this.xPathy).setCase(thisCase);
        return copy;
    }

    public _Text_ REMOVE(Only... onlyItems) {
        _Text_ copy = this.copy();
        copy.xPathy = new _TranslateBuilder_(this.xPathy).setRemoveChars(onlyItems);
        return copy;
    }


    public _Text_ KEEP(Only... onlyItems) {
        _Text_ copy = this.copy();
        copy.xPathy = new _TranslateBuilder_(this.xPathy).setKeepOnlyChars(onlyItems);
        return copy;
    }

    public _Text_ TRANSLATE(String charactersToReplace, String replacementCharacters) {
        _Text_ copy = this.copy();
        copy.xPathy = new _TranslateBuilder_(this.xPathy).setTranslate(charactersToReplace, replacementCharacters);
        return copy;
    }

    public XPathy equals(String equalText) {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String function = transformer.buildFunctionExpression(BASE_FUNCTION);
        String value = transformer.applyModifiersToValue(equalText);

        copy.xpath = new _AppendAndOr_(copy).append(function + " = '" + value + "'");

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }


    public XPathy contains(String partialText) {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String function = transformer.buildFunctionExpression(BASE_FUNCTION);
        String value = transformer.applyModifiersToValue(partialText);

        copy.xpath = new _AppendAndOr_(copy).append("contains(" + function + ", '" + value + "')");

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    public XPathy startsWith(String prefixText) {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String function = transformer.buildFunctionExpression(BASE_FUNCTION);
        String value = transformer.applyModifiersToValue(prefixText);

        copy.xpath = new _AppendAndOr_(copy).append("starts-with(" + function + ", '" + value + "')");

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    public XPathy isEmpty() {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);

        // Use normalize-space to handle missing or whitespace-only text nodes
        String function = transformer.buildFunctionExpression("normalize-space(text())");

        copy.xpath = new _AppendAndOr_(copy).append(function + "=''");

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    public XPathy isNumeric() {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String function = transformer.buildFunctionExpression(BASE_FUNCTION);

        copy.xpath = new _AppendAndOr_(copy).append("string-length(" + function + ") > 0 and not(translate(" + function + ", '0123456789', '') != '')");

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    public XPathy equals(Number number) {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String function = transformer.buildFunctionExpression(BASE_FUNCTION);

        copy.xpath = new _AppendAndOr_(copy).append(function + " = " + number);

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    public XPathy greaterThan(Number number) {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String function = transformer.buildFunctionExpression(BASE_FUNCTION);

        copy.xpath = new _AppendAndOr_(copy).append(function + " > " + number);

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    public XPathy greaterThanOrEquals(Number number) {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String function = transformer.buildFunctionExpression(BASE_FUNCTION);

        copy.xpath =new _AppendAndOr_(copy).append(function + " >= " + number);

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    public XPathy lessThan(Number number) {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String function = transformer.buildFunctionExpression(BASE_FUNCTION);

        copy.xpath =new _AppendAndOr_(copy).append(function + " < " + number);

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

    public XPathy lessThanOrEquals(Number number) {
        XPathy copy = this.xPathy.copy();
        _XPathValueTransformer_ transformer = new _XPathValueTransformer_(copy);
        String function = transformer.buildFunctionExpression(BASE_FUNCTION);

        copy.xpath =new _AppendAndOr_(copy).append(function + " <= " + number);

        copy.is_and_or_condition_appendable = true;
        copy.reset_values();
        return copy;
    }

}
