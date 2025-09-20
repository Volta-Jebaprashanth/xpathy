package com.xpathy;

public class Attribute {

    private final String this_attribute;

    private Attribute(String name) {
        this.this_attribute = name;
    }

    // Global attributes
    public static final Attribute any = new Attribute("*");
    public static final Attribute accesskey = new Attribute("accesskey");
    public static final Attribute autocapitalize = new Attribute("autocapitalize");
    public static final Attribute class_ = new Attribute("class"); // 'class' is a reserved word
    public static final Attribute contenteditable = new Attribute("contenteditable");
    public static final Attribute contextmenu = new Attribute("contextmenu");
    public static final Attribute dir = new Attribute("dir");
    public static final Attribute draggable = new Attribute("draggable");
    public static final Attribute hidden = new Attribute("hidden");
    public static final Attribute id = new Attribute("id");
    public static final Attribute lang = new Attribute("lang");
    public static final Attribute spellcheck = new Attribute("spellcheck");
    public static final Attribute style = new Attribute("style");
    public static final Attribute tabindex = new Attribute("tabindex");
    public static final Attribute title = new Attribute("title");
    public static final Attribute translate = new Attribute("translate");

    // Form-related
    public static final Attribute name = new Attribute("name");
    public static final Attribute type = new Attribute("type");
    public static final Attribute value = new Attribute("value");
    public static final Attribute placeholder = new Attribute("placeholder");
    public static final Attribute required = new Attribute("required");
    public static final Attribute disabled = new Attribute("disabled");
    public static final Attribute readonly = new Attribute("readonly");
    public static final Attribute checked = new Attribute("checked");
    public static final Attribute selected = new Attribute("selected");
    public static final Attribute action = new Attribute("action");
    public static final Attribute method = new Attribute("method");
    public static final Attribute role = new Attribute("role");
    public static final Attribute for_ = new Attribute("for"); // 'for' is a reserved word
    public static final Attribute autofocus = new Attribute("autofocus");

    // Anchor and link
    public static final Attribute href = new Attribute("href");
    public static final Attribute target = new Attribute("target");
    public static final Attribute rel = new Attribute("rel");
    public static final Attribute download = new Attribute("download");

    // Media
    public static final Attribute src = new Attribute("src");
    public static final Attribute alt = new Attribute("alt");
    public static final Attribute width = new Attribute("width");
    public static final Attribute height = new Attribute("height");
    public static final Attribute controls = new Attribute("controls");
    public static final Attribute autoplay = new Attribute("autoplay");
    public static final Attribute loop = new Attribute("loop");
    public static final Attribute poster = new Attribute("poster");

    // ARIA & data
    public static final Attribute aria_label = new Attribute("aria-label");
    public static final Attribute aria_hidden = new Attribute("aria-hidden");
    public static final Attribute data_testid = new Attribute("data-testid");
    public static final Attribute onclick = new Attribute("onclick");

    /**
     * Creates a custom attribute, such as data-* or aria-*.
     */
    public static Attribute custom(String attributeName) {
        return new Attribute(attributeName);
    }

    public static Attribute of(String attributeName) {
        return new Attribute(attributeName);
    }

    public static Attribute create(String attributeName) {
        return new Attribute(attributeName);
    }

    @Override
    public String toString() {
        return this_attribute;
    }

    //==================================================================

    public _Attribute_Not_ not() {
        return new _Attribute_Not_(new XPathy(Tag.any), this);
    }

    public _Attribute_Length_ byLength() {
        return new _Attribute_Length_(new XPathy(Tag.any), this);
    }


    //===================================================================

    public XPathy union(Or... orConditions){
        return new XPathy(Tag.any).byAttribute(this).union(orConditions);
    }

    public XPathy intersect(And... andConditions){
        return new XPathy(Tag.any).byAttribute(this).intersect(andConditions);
    }

    //===================================================================

    public _Attribute_ withTrim() {

        XPathy xPathy = new XPathy(Tag.any);
        xPathy.is_trim = true;

        return new _Attribute_(xPathy, this);
    }


    public _Attribute_ withNormalizeSpace() {

        XPathy xPathy = new XPathy(Tag.any);
        xPathy.is_normalize_space = true;

        return new _Attribute_(xPathy, this);

    }

    public _Attribute_ withCase(Case thisCase) {

        XPathy xPathy = new _TranslateBuilder_(new XPathy(Tag.any)).setCase(thisCase);
        return new _Attribute_(xPathy, this);

    }

    public _Attribute_ withRemoveOnly(Only... onlyItems) {

        XPathy xPathy = new _TranslateBuilder_(new XPathy(Tag.any)).setRemoveChars(onlyItems);
        return new _Attribute_(xPathy, this);

    }

    public _Attribute_ withKeepOnly(Only... onlyItems) {

        XPathy xPathy = new _TranslateBuilder_(new XPathy(Tag.any)).setKeepOnlyChars(onlyItems);
        return new _Attribute_(xPathy, this);
    }

    public _Attribute_ withTranslate(String charactersToReplace, String replacementCharacters) {

        XPathy xPathy = new _TranslateBuilder_(new XPathy(Tag.any)).setTranslate(charactersToReplace, replacementCharacters);
        return new _Attribute_(xPathy, this);
    }

    //=================================================================

    public XPathy haveIt() {
        return new XPathy(Tag.any).byAttribute(this).haveIt();

    }

    public XPathy equals(String equalValue) {
        return new XPathy(Tag.any).byAttribute(this).equals(equalValue);
    }

    public XPathy contains(String partialValue) {
        return new XPathy(Tag.any).byAttribute(this).contains(partialValue);
    }

    public XPathy startsWith(String prefix) {
        return new XPathy(Tag.any).byAttribute(this).startsWith(prefix);
    }

    public XPathy isEmpty() {
        return new XPathy(Tag.any).byAttribute(this).isEmpty();
    }

    public XPathy isNumeric() {
        return new XPathy(Tag.any).byAttribute(this).isNumeric();
    }


    public XPathy equals(Number number) {
        return new XPathy(Tag.any).byAttribute(this).equals(number);
    }

    public XPathy greaterThan(Number number) {
        return new XPathy(Tag.any).byAttribute(this).greaterThan(number);
    }

    public XPathy greaterThanOrEquals(Number number) {
        return new XPathy(Tag.any).byAttribute(this).greaterThanOrEquals(number);
    }

    public XPathy lessThan(Number number) {
        return new XPathy(Tag.any).byAttribute(this).lessThan(number);
    }

    public XPathy lessThanOrEquals(Number number) {
        return new XPathy(Tag.any).byAttribute(this).lessThanOrEquals(number);
    }




}

