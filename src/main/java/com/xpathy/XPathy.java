package com.xpathy;

import org.openqa.selenium.By;

public class XPathy {

    protected String xpath;
    protected boolean isByCss = false;
    protected By cssBy = null;

    protected boolean is_and_or_condition_appendable;

    protected Condition condition = Condition.NONE;

    //-----------------------------
    protected String removeChars = null;
    protected String keepOnlyChars = null;
    protected Case thisCase = null;
    protected String translate_charactersToReplace = null;
    protected String translate_replacementCharacters = null;

    //-------------
    protected boolean is_trim;
    protected boolean is_normalize_space;

    //-------------

    protected String having_condition_prefix = null;

    //--------------

    protected void reset_values() {

        this.is_trim = false;
        this.is_normalize_space = false;
        this.condition = Condition.NONE;

        this.removeChars = null;
        this.keepOnlyChars = null;
        this.thisCase = null;
        this.translate_charactersToReplace = null;
        this.translate_replacementCharacters = null;

        this.having_condition_prefix = null;

    }

    protected enum Condition {
        AND,
        OR,
        NONE;
    }

    //===========================================================================================


    public XPathy TAG(Tag tag) {
        is_and_or_condition_appendable = false;

        XPathy copy = this.copy();
        copy.xpath = this.xpath + "//" + tag;
        copy.reset_values();
        return copy;
    }

    public _Attribute_ ATTRIBUTE(Attribute attribute) {
        return new _Attribute_(this, attribute);
    }

    public _Number_ NUMBER() {
        return new _Number_(this);
    }

    public _Text_ TEXT() {
        return new _Text_(this);
    }

    public _Style_ STYLE(Style style) {
        return new _Style_(this, style);
    }

    public __Having_Init_ HAVING(){
        return new __Having_Init_(this);
    }

    public XPathy AND() {
        XPathy copy = this.copy();
        copy.condition = Condition.AND;
        return copy;
    }

    public XPathy OR() {
        XPathy copy = this.copy();
        copy.condition = Condition.OR;
        return copy;
    }

    //======================================== CONSTRUCTORS ========================================

    private static final String TAG_ANY = new XPathy(Tag.ANY).getXpath();
    public XPathy() {
        this.xpath = TAG_ANY;
    }

    public XPathy(String baseXPath) {
        this.xpath = baseXPath;
    }

    public XPathy(Tag tag) {
        this.xpath = "//" + tag;
    }

    public XPathy(By by) {
        this.xpath = XPathy.from(by).xpath;
        this.isByCss = XPathy.from(by).isByCss;
        this.cssBy = XPathy.from(by).cssBy;
    }

    public XPathy(XPathy xPathy) {
        this.xpath = xPathy.xpath;
        this.isByCss = xPathy.isByCss;
        this.cssBy = xPathy.cssBy;
        this.is_and_or_condition_appendable = xPathy.is_and_or_condition_appendable;
        this.condition = xPathy.condition;

        this.is_trim = xPathy.is_trim;
        this.is_normalize_space = xPathy.is_normalize_space;

        this.removeChars = xPathy.removeChars;
        this.keepOnlyChars = xPathy.keepOnlyChars;
        this.thisCase = xPathy.thisCase;
        this.translate_charactersToReplace = xPathy.translate_charactersToReplace;
        this.translate_replacementCharacters = xPathy.translate_replacementCharacters;

        this.having_condition_prefix = xPathy.having_condition_prefix;

    }


    //======================================== STATIC CREATOR ========================================

    public static XPathy from(By by) {
        String byString = by.toString();
        String xpath = null;

        if (byString.startsWith("By.xpath: ")) {
            xpath = byString.replace("By.xpath: ", "").trim();
        } else if (byString.startsWith("By.id: ")) {
            String value = byString.replace("By.id: ", "").trim();
            xpath = "//*[@id='" + value + "']";
        } else if (byString.startsWith("By.name: ")) {
            String value = byString.replace("By.name: ", "").trim();
            xpath = "//*[@name='" + value + "']";
        } else if (byString.startsWith("By.className: ")) {
            String value = byString.replace("By.className: ", "").trim();
            xpath = "//*[contains(concat(' ', normalize-space(@class), ' '), ' " + value + " ')]";
        } else if (byString.startsWith("By.tagName: ")) {
            String value = byString.replace("By.tagName: ", "").trim();
            xpath = "//" + value;
        } else if (byString.startsWith("By.linkText: ")) {
            String value = byString.replace("By.linkText: ", "").trim();
            xpath = "//a[text()='" + value + "']";
        } else if (byString.startsWith("By.partialLinkText: ")) {
            String value = byString.replace("By.partialLinkText: ", "").trim();
            xpath = "//a[contains(text(),'" + value + "')]";
        } else if (byString.startsWith("By.cssSelector: ")) {

            XPathy newXpath = new XPathy();
            newXpath.isByCss = true;
            newXpath.cssBy = by;
            return newXpath;
        }

        return new XPathy(xpath);
    }

    public static XPathy from(Tag tag) {
        return new XPathy("//" + tag);
    }

    public static XPathy from(XPathy xPathy) {
        return new XPathy(xPathy);
    }

    public static XPathy from(String baseXpath) {
        return new XPathy(baseXpath);
    }

    public static XPathy of(Tag tag) {
        return new XPathy("//" + tag);
    }


    // ======================================== PRIVATE METHODS ========================================
    private boolean checkXpathFormatToAppendAndOr() {
        String trimmedXpath = this.xpath.trim();
        return !trimmedXpath.matches(".*\\[\\d+\\]$") && !trimmedXpath.endsWith("[last()]");
    }

    protected XPathy copy() {
        return new XPathy(this);
    }


    //======================================== CONVERTERS ========================================

    public By toBy() {
        return isByCss ? cssBy : By.xpath(xpath);
    }

    public By asLocator() {
        return toBy();
    }

    public By getLocator() {
        return toBy();
    }

    public String getXpath() {
        return this.xpath;
    }

    //======================================== ELEMENT INDEX ========================================

    public XPathy nth(int elementNumber) {

        is_and_or_condition_appendable = false;

        XPathy copy = this.copy();
        copy.xpath = "(" + this.xpath + ")[" + elementNumber + "]";
        return copy;
    }

    public XPathy index(int index){
        return nth(index);
    }

    public XPathy last() {

        is_and_or_condition_appendable = false;

        XPathy copy = this.copy();
        copy.xpath = "(" + this.xpath + ")[last()]";
        return copy;
    }

    //======================================== DOM NAVIGATION ========================================

    public XPathy tag(Tag tag) {

        this.is_and_or_condition_appendable = false;

        XPathy copy = this.copy();

        if(copy.condition.equals(Condition.OR)){
            copy.xpath = copy.xpath + " | " + TAG_ANY;
        }

        if (copy.xpath.endsWith(TAG_ANY)) {

            copy.xpath = copy.xpath.substring(0, copy.xpath.lastIndexOf(TAG_ANY)) + new XPathy(tag).getXpath();
            copy.reset_values();

            return copy;
        }

        copy.xpath = this.xpath + "//" + tag;
        copy.reset_values();

        return copy;
    }

    public XPathy parent(Tag tag) {

        is_and_or_condition_appendable = false;
        reset_values();

        XPathy copy = this.copy();
        copy.xpath = this.xpath + "/parent::" + tag;
        return copy;
    }

    public XPathy parent() {

        is_and_or_condition_appendable = false;
        reset_values();

        XPathy copy = this.copy();
        copy.xpath = this.xpath + "/..";
        return copy;
    }

    public XPathy up() {
        return parent();
    }

    public XPathy up(int count) {

        is_and_or_condition_appendable = false;
        reset_values();

        XPathy copy = this.copy();
        copy.xpath = this.xpath + "/..".repeat(count);
        return copy;
    }

    public XPathy ancestors(Tag tag) {

        is_and_or_condition_appendable = false;
        reset_values();

        XPathy copy = this.copy();
        copy.xpath = this.xpath + "/ancestor::" + tag;
        return copy;
    }

    public XPathy ancestors() {

        is_and_or_condition_appendable = false;
        reset_values();

        XPathy copy = this.copy();
        copy.xpath = this.xpath + "/ancestor::*";
        return copy;
    }

    public XPathy children(Tag tag) {

        is_and_or_condition_appendable = false;
        reset_values();

        XPathy copy = this.copy();
        copy.xpath = this.xpath + "/child::" + tag;
        return copy;
    }

    public XPathy children() {

        is_and_or_condition_appendable = false;
        reset_values();

        XPathy copy = this.copy();
        copy.xpath = this.xpath + "/child::*";
        return copy;
    }

    public XPathy descendants(Tag tag) {

        is_and_or_condition_appendable = false;
        reset_values();

        XPathy copy = this.copy();
        copy.xpath = this.xpath + "/descendant::" + tag;
        return copy;
    }

    public XPathy descendants() {

        is_and_or_condition_appendable = false;
        reset_values();

        XPathy copy = this.copy();
        copy.xpath = this.xpath + "/descendant::*";
        return copy;
    }

    public XPathy following_siblings(Tag tag) {

        is_and_or_condition_appendable = false;
        reset_values();

        XPathy copy = this.copy();
        copy.xpath = this.xpath + "/following-sibling::" + tag;
        return copy;
    }

    public XPathy following_siblings() {

        is_and_or_condition_appendable = false;
        reset_values();

        XPathy copy = this.copy();
        copy.xpath = this.xpath + "/following-sibling::*";
        return copy;
    }

    public XPathy preceding_siblings(Tag tag) {

        is_and_or_condition_appendable = false;
        reset_values();

        XPathy copy = this.copy();
        copy.xpath = this.xpath + "/preceding-sibling::" + tag;
        return copy;
    }

    public XPathy preceding_siblings() {

        is_and_or_condition_appendable = false;
        reset_values();

        XPathy copy = this.copy();
        copy.xpath = this.xpath + "/preceding-sibling::*";
        return copy;
    }


    //======================================== OR ========================================

    public XPathy or(Tag tag) {

        is_and_or_condition_appendable = false;

        XPathy copy = this.copy();
        copy.xpath = this.xpath + " | //" + tag;
        return copy;
    }

    public XPathy or(By by) {

        is_and_or_condition_appendable = false;

        XPathy copy = this.copy();
        copy.xpath = this.xpath + " | " + XPathy.from(by).xpath;
        return copy;
    }

    public XPathy or() {

        is_and_or_condition_appendable = false;

        XPathy copy = this.copy();
        copy.xpath = this.xpath + " | " + TAG_ANY;
        return copy;
    }

    public XPathy or(XPathy xPathy) {

        is_and_or_condition_appendable = false;

        XPathy copy = this.copy();
        copy.xpath = this.xpath + " | " + xPathy.xpath;
        return copy;
    }

    public XPathy or(XPathy... xPathies) {

        is_and_or_condition_appendable = false;

        XPathy copy = this.copy();
        StringBuilder sb = new StringBuilder();


        if (!copy.xpath.replaceAll("\\s+", "").equals("//*")) {
            sb.append(copy.xpath);
        }

        for (XPathy xPathy : xPathies) {
            if (sb.length() > 0) {
                sb.append(" | ");
            }
            sb.append(xPathy.xpath);
        }

        copy.xpath = sb.toString();
        return copy;
    }


    //======================================== APPEND ========================================

    public XPathy append(By by) {

        is_and_or_condition_appendable = false;

        XPathy copy = this.copy();
        copy.xpath = this.xpath + XPathy.from(by).xpath;
        return copy;
    }

    public XPathy append(XPathy xPathy) {

        is_and_or_condition_appendable = false;

        XPathy copy = this.copy();
        copy.xpath = this.xpath + xPathy.xpath;
        return copy;
    }

    public XPathy append(String xpath) {

        is_and_or_condition_appendable = false;

        XPathy copy = this.copy();
        copy.xpath = this.xpath + xpath;
        return copy;
    }


    @Override
    public String toString(){
        return this.xpath;
    }

}
