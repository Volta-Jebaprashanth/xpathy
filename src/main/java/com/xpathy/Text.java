package com.xpathy;

public class Text {
    public static _Text_Length_ LENGTH() {
        return new _Text_Length_(new XPathy(Tag.ANY));
    }

    public static _Text_Not_ NOT() {
        return new _Text_Not_(new XPathy(Tag.ANY));
    }


    public static _Text_ TRIM() {

        XPathy xPathy = new XPathy(Tag.ANY);
        xPathy.is_trim = true;
        return new _Text_(xPathy);

    }

    public static _Text_ NORMALIZE_SPACE() {

        XPathy xPathy = new XPathy(Tag.ANY);
        xPathy.is_normalize_space = true;
        return new _Text_(xPathy);

    }

    public static _Text_ CASE(Case thisCase) {

        XPathy xPathy = new _TranslateBuilder_(new XPathy(Tag.ANY)).setCase(thisCase);
        return new _Text_(xPathy);
    }

    public static _Text_ REMOVE(Only... onlyItems) {

        XPathy xPathy = new _TranslateBuilder_(new XPathy(Tag.ANY)).setRemoveChars(onlyItems);
        return new _Text_(xPathy);
    }


    public static _Text_ KEEP(Only... onlyItems) {

        XPathy xPathy = new _TranslateBuilder_(new XPathy(Tag.ANY)).setKeepOnlyChars(onlyItems);
        return new _Text_(xPathy);
    }

    public static _Text_ TRANSLATE(String charactersToReplace, String replacementCharacters) {

        XPathy xPathy = new _TranslateBuilder_(new XPathy(Tag.ANY)).setTranslate(charactersToReplace, replacementCharacters);
        return new _Text_(xPathy);
    }

    public static XPathy equals(String equalText) {
        return new XPathy(Tag.ANY).TEXT().equals(equalText);
    }


    public static XPathy contains(String partialText) {
        return new XPathy(Tag.ANY).TEXT().contains(partialText);
    }

    public static XPathy startsWith(String prefixText) {
        return new XPathy(Tag.ANY).TEXT().startsWith(prefixText);
    }

    public static XPathy isEmpty() {
        return new XPathy(Tag.ANY).TEXT().isEmpty();
    }

    public static XPathy isNumeric() {
        return new XPathy(Tag.ANY).TEXT().isNumeric();
    }

    public static XPathy equals(Number number) {
        return new XPathy(Tag.ANY).TEXT().equals(number);
    }

    public static XPathy greaterThan(Number number) {
        return new XPathy(Tag.ANY).TEXT().greaterThan(number);
    }

    public static XPathy greaterThanOrEquals(Number number) {
        return new XPathy(Tag.ANY).TEXT().greaterThanOrEquals(number);
    }

    public static XPathy lessThan(Number number) {
        return new XPathy(Tag.ANY).TEXT().lessThan(number);
    }

    public static XPathy lessThanOrEquals(Number number) {
        return new XPathy(Tag.ANY).TEXT().lessThanOrEquals(number);
    }

}
