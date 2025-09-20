package com.xpathy;

public class Text {
    public static _Text_Length_ byLength() {
        return new _Text_Length_(new XPathy(Tag.any));
    }

    public static _Text_Not_ not() {
        return new _Text_Not_(new XPathy(Tag.any));
    }


    public static _Text_ withTrim() {

        XPathy xPathy = new XPathy(Tag.any);
        xPathy.is_trim = true;
        return new _Text_(xPathy);

    }

    public static _Text_ withNormalizeSpace() {

        XPathy xPathy = new XPathy(Tag.any);
        xPathy.is_normalize_space = true;
        return new _Text_(xPathy);

    }

    public static _Text_ withCase(Case thisCase) {

        XPathy xPathy = new _TranslateBuilder_(new XPathy(Tag.any)).setCase(thisCase);
        return new _Text_(xPathy);
    }

    public static _Text_ withRemoveOnly(Only... onlyItems) {

        XPathy xPathy = new _TranslateBuilder_(new XPathy(Tag.any)).setRemoveChars(onlyItems);
        return new _Text_(xPathy);
    }


    public static _Text_ withKeepOnly(Only... onlyItems) {

        XPathy xPathy = new _TranslateBuilder_(new XPathy(Tag.any)).setKeepOnlyChars(onlyItems);
        return new _Text_(xPathy);
    }

    public static _Text_ withTranslate(String charactersToReplace, String replacementCharacters) {

        XPathy xPathy = new _TranslateBuilder_(new XPathy(Tag.any)).setTranslate(charactersToReplace, replacementCharacters);
        return new _Text_(xPathy);
    }

    public static XPathy equals(String equalText) {
        return new XPathy(Tag.any).byText().equals(equalText);
    }


    public static XPathy contains(String partialText) {
        return new XPathy(Tag.any).byText().contains(partialText);
    }

    public static XPathy startsWith(String prefixText) {
        return new XPathy(Tag.any).byText().startsWith(prefixText);
    }

    public static XPathy isEmpty() {
        return new XPathy(Tag.any).byText().isEmpty();
    }

    public static XPathy isNumeric() {
        return new XPathy(Tag.any).byText().isNumeric();
    }

    public static XPathy equals(Number number) {
        return new XPathy(Tag.any).byText().equals(number);
    }

    public static XPathy greaterThan(Number number) {
        return new XPathy(Tag.any).byText().greaterThan(number);
    }

    public static XPathy greaterThanOrEquals(Number number) {
        return new XPathy(Tag.any).byText().greaterThanOrEquals(number);
    }

    public static XPathy lessThan(Number number) {
        return new XPathy(Tag.any).byText().lessThan(number);
    }

    public static XPathy lessThanOrEquals(Number number) {
        return new XPathy(Tag.any).byText().lessThanOrEquals(number);
    }

    //=======================================================

    public static XPathy union(Or... orConditions){
        return new XPathy(Tag.any).byText().union(orConditions);
    }

    public static XPathy intersect(And... andConditions){
        return new XPathy(Tag.any).byText().intersect(andConditions);
    }

}
