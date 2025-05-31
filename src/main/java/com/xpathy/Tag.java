package com.xpathy;

public class Tag {

    private final String tag_name;

    private Tag(String tagName) {
        this.tag_name = tagName;
    }

    public static final Tag ANY = new Tag("*");

    // Document metadata
    public static final Tag html = new Tag("html");
    public static final Tag head = new Tag("head");
    public static final Tag title = new Tag("title");
    public static final Tag base = new Tag("base");
    public static final Tag link = new Tag("link");
    public static final Tag meta = new Tag("meta");
    public static final Tag style = new Tag("style");

    // Sectioning
    public static final Tag body = new Tag("body");
    public static final Tag header = new Tag("header");
    public static final Tag nav = new Tag("nav");
    public static final Tag main = new Tag("main");
    public static final Tag section = new Tag("section");
    public static final Tag article = new Tag("article");
    public static final Tag aside = new Tag("aside");
    public static final Tag footer = new Tag("footer");
    public static final Tag address = new Tag("address");

    // Content grouping
    public static final Tag p = new Tag("p");
    public static final Tag hr = new Tag("hr");
    public static final Tag pre = new Tag("pre");
    public static final Tag blockquote = new Tag("blockquote");
    public static final Tag ol = new Tag("ol");
    public static final Tag ul = new Tag("ul");
    public static final Tag li = new Tag("li");
    public static final Tag dl = new Tag("dl");
    public static final Tag dt = new Tag("dt");
    public static final Tag dd = new Tag("dd");
    public static final Tag figure = new Tag("figure");
    public static final Tag figcaption = new Tag("figcaption");
    public static final Tag div = new Tag("div");

    // Text content
    public static final Tag h1 = new Tag("h1");
    public static final Tag h2 = new Tag("h2");
    public static final Tag h3 = new Tag("h3");
    public static final Tag h4 = new Tag("h4");
    public static final Tag h5 = new Tag("h5");
    public static final Tag h6 = new Tag("h6");
    public static final Tag a = new Tag("a");
    public static final Tag em = new Tag("em");
    public static final Tag strong = new Tag("strong");
    public static final Tag small = new Tag("small");
    public static final Tag s = new Tag("s");
    public static final Tag cite = new Tag("cite");
    public static final Tag q = new Tag("q");
    public static final Tag dfn = new Tag("dfn");
    public static final Tag abbr = new Tag("abbr");
    public static final Tag data = new Tag("data");
    public static final Tag time = new Tag("time");
    public static final Tag code = new Tag("code");
    public static final Tag var = new Tag("var");
    public static final Tag samp = new Tag("samp");
    public static final Tag kbd = new Tag("kbd");
    public static final Tag sub = new Tag("sub");
    public static final Tag sup = new Tag("sup");
    public static final Tag i = new Tag("i");
    public static final Tag b = new Tag("b");
    public static final Tag u = new Tag("u");
    public static final Tag mark = new Tag("mark");
    public static final Tag ruby = new Tag("ruby");
    public static final Tag rt = new Tag("rt");
    public static final Tag rp = new Tag("rp");
    public static final Tag bdi = new Tag("bdi");
    public static final Tag bdo = new Tag("bdo");
    public static final Tag span = new Tag("span");
    public static final Tag br = new Tag("br");
    public static final Tag wbr = new Tag("wbr");

    // Edits
    public static final Tag ins = new Tag("ins");
    public static final Tag del = new Tag("del");

    // Embedded content
    public static final Tag picture = new Tag("picture");
    public static final Tag source = new Tag("source");
    public static final Tag img = new Tag("img");
    public static final Tag iframe = new Tag("iframe");
    public static final Tag embed = new Tag("embed");
    public static final Tag object = new Tag("object");
    public static final Tag param = new Tag("param");
    public static final Tag video = new Tag("video");
    public static final Tag audio = new Tag("audio");
    public static final Tag track = new Tag("track");
    public static final Tag map = new Tag("map");
    public static final Tag area = new Tag("area");

    // Table content
    public static final Tag table = new Tag("table");
    public static final Tag caption = new Tag("caption");
    public static final Tag colgroup = new Tag("colgroup");
    public static final Tag col = new Tag("col");
    public static final Tag tbody = new Tag("tbody");
    public static final Tag thead = new Tag("thead");
    public static final Tag tfoot = new Tag("tfoot");
    public static final Tag tr = new Tag("tr");
    public static final Tag td = new Tag("td");
    public static final Tag th = new Tag("th");

    // Forms
    public static final Tag form = new Tag("form");
    public static final Tag fieldset = new Tag("fieldset");
    public static final Tag legend = new Tag("legend");
    public static final Tag label = new Tag("label");
    public static final Tag input = new Tag("input");
    public static final Tag button = new Tag("button");
    public static final Tag select = new Tag("select");
    public static final Tag datalist = new Tag("datalist");
    public static final Tag optgroup = new Tag("optgroup");
    public static final Tag option = new Tag("option");
    public static final Tag textarea = new Tag("textarea");
    public static final Tag output = new Tag("output");
    public static final Tag progress = new Tag("progress");
    public static final Tag meter = new Tag("meter");

    // Interactive
    public static final Tag details = new Tag("details");
    public static final Tag summary = new Tag("summary");
    public static final Tag dialog = new Tag("dialog");
    public static final Tag script = new Tag("script");
    public static final Tag noscript = new Tag("noscript");
    public static final Tag template = new Tag("template");
    public static final Tag canvas = new Tag("canvas");
    public static final Tag slot = new Tag("slot");

    // Web components
    public static final Tag custom_element = new Tag("custom-element");
    public static final Tag shadow = new Tag("shadow");

    // Deprecated (optional)
    public static final Tag center = new Tag("center");
    public static final Tag font = new Tag("font");
    public static final Tag big = new Tag("big");
    public static final Tag tt = new Tag("tt");
    public static final Tag marquee = new Tag("marquee");
    public static final Tag acronym = new Tag("acronym");
    public static final Tag bgsound = new Tag("bgsound");
    public static final Tag frame = new Tag("frame");
    public static final Tag frameset = new Tag("frameset");
    public static final Tag noframes = new Tag("noframes");
    public static final Tag applet = new Tag("applet");

    /**
     * Allows creation of custom or non-standard tag names.
     */
    public static Tag CUSTOM(String tagName) {
        return new Tag(tagName);
    }

    @Override
    public String toString() {
        return tag_name;
    }

    //===================================================================================================================

    public _Text_ TEXT(){
        return new XPathy(this).TEXT();
    }

    public _Number_ NUMBER(){
        return new XPathy(this).NUMBER();
    }

    public _Attribute_ ATTRIBUTE(Attribute attribute){
        return new XPathy(this).ATTRIBUTE(attribute);
    }

    public _Style_ STYLE(Style style){
        return new XPathy(this).STYLE(style);
    }

    public __Having_Init_ HAVING(){
        return new XPathy(this).HAVING();
    }

    //================================================================================================================



}

