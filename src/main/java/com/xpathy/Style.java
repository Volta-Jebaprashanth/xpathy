package com.xpathy;
public class Style {

    private final String name;

    private Style(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Display & Visibility
    public static final Style display = new Style("display");
    public static final Style visibility = new Style("visibility");
    public static final Style opacity = new Style("opacity");
    public static final Style overflow = new Style("overflow");
    public static final Style zIndex = new Style("z-index");

    // Positioning
    public static final Style position = new Style("position");
    public static final Style top = new Style("top");
    public static final Style right = new Style("right");
    public static final Style bottom = new Style("bottom");
    public static final Style left = new Style("left");

    // Dimensions
    public static final Style width = new Style("width");
    public static final Style height = new Style("height");
    public static final Style minWidth = new Style("min-width");
    public static final Style minHeight = new Style("min-height");
    public static final Style maxWidth = new Style("max-width");
    public static final Style maxHeight = new Style("max-height");

    // Margin & Padding
    public static final Style margin = new Style("margin");
    public static final Style marginTop = new Style("margin-top");
    public static final Style marginRight = new Style("margin-right");
    public static final Style marginBottom = new Style("margin-bottom");
    public static final Style marginLeft = new Style("margin-left");

    public static final Style padding = new Style("padding");
    public static final Style paddingTop = new Style("padding-top");
    public static final Style paddingRight = new Style("padding-right");
    public static final Style paddingBottom = new Style("padding-bottom");
    public static final Style paddingLeft = new Style("padding-left");

    // Border & Box
    public static final Style border = new Style("border");
    public static final Style borderTop = new Style("border-top");
    public static final Style borderRight = new Style("border-right");
    public static final Style borderBottom = new Style("border-bottom");
    public static final Style borderLeft = new Style("border-left");
    public static final Style borderColor = new Style("border-color");
    public static final Style borderRadius = new Style("border-radius");
    public static final Style boxShadow = new Style("box-shadow");

    // Background
    public static final Style background = new Style("background");
    public static final Style backgroundColor = new Style("background-color");
    public static final Style backgroundImage = new Style("background-image");
    public static final Style backgroundPosition = new Style("background-position");
    public static final Style backgroundSize = new Style("background-size");
    public static final Style backgroundRepeat = new Style("background-repeat");

    // Text
    public static final Style color = new Style("color");
    public static final Style fontSize = new Style("font-size");
    public static final Style fontWeight = new Style("font-weight");
    public static final Style fontStyle = new Style("font-style");
    public static final Style fontFamily = new Style("font-family");
    public static final Style textAlign = new Style("text-align");
    public static final Style textDecoration = new Style("text-decoration");
    public static final Style textTransform = new Style("text-transform");
    public static final Style lineHeight = new Style("line-height");
    public static final Style letterSpacing = new Style("letter-spacing");
    public static final Style whiteSpace = new Style("white-space");
    public static final Style wordBreak = new Style("word-break");

    // Cursor & Interactivity
    public static final Style cursor = new Style("cursor");
    public static final Style pointerEvents = new Style("pointer-events");
    public static final Style userSelect = new Style("user-select");

    // Flexbox
    public static final Style flexDirection = new Style("flex-direction");
    public static final Style flexWrap = new Style("flex-wrap");
    public static final Style justifyContent = new Style("justify-content");
    public static final Style alignItems = new Style("align-items");
    public static final Style alignContent = new Style("align-content");
    public static final Style flexGrow = new Style("flex-grow");
    public static final Style flexShrink = new Style("flex-shrink");

    // Grid
    public static final Style gridTemplateColumns = new Style("grid-template-columns");
    public static final Style gridTemplateRows = new Style("grid-template-rows");
    public static final Style gridColumn = new Style("grid-column");
    public static final Style gridRow = new Style("grid-row");

    // Transforms & Effects
    public static final Style transform = new Style("transform");
    public static final Style transition = new Style("transition");
    public static final Style animation = new Style("animation");
    public static final Style filter = new Style("filter");

    // Miscellaneous
    public static final Style clip = new Style("clip");
    public static final Style clipPath = new Style("clip-path");
    public static final Style outline = new Style("outline");
    public static final Style boxSizing = new Style("box-sizing");
    public static final Style content = new Style("content");
    public static final Style float_ = new Style("float"); // float is a keyword
    public static final Style clear = new Style("clear");


    public static Style CUSTOM(String style){
        return new Style(style);
    }

    @Override
    public String toString() {
        return this.name;
    }

    //===========================================

    public _Style_Not_ NOT(){
        return new _Style_Not_( new XPathy(Tag.ANY), this);
    }

    public XPathy haveIt(){
        return new XPathy(Tag.ANY).STYLE(this).haveIt();
    }

    public XPathy equals(String Value) {
        return new XPathy(Tag.ANY).STYLE(this).equals(Value);
    }


}
