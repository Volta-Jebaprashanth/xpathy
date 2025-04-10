package com.xpathy;

public class Attribute {

    private final String this_attribute;

    private Attribute(String name) {
        this.this_attribute = name;
    }

    // Global attributes
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

    /**
     * Creates a custom attribute, such as data-* or aria-*.
     */
    public static Attribute CUSTOM(String attributeName) {
        return new Attribute(attributeName);
    }

    @Override
    public String toString() {
        return this_attribute;
    }

    public XPathy equals(String value) {
        return new XPathy("//*[@" + this.this_attribute + "='" + value + "']");
    }

    public XPathy contains(String value) {
        return new XPathy("//*[contains(@" + this.this_attribute + ", '" + value + "')]");
    }


    public XPathy startsWith(String value) {
        return new XPathy("//*[starts-with(@" + this.this_attribute + ", '" + value + "')]");
    }


}

