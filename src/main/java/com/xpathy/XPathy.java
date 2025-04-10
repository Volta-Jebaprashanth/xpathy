package com.xpathy;

import org.openqa.selenium.By;


public class XPathy {

    private String xpath;
    private boolean isByCss = false;
    private By cssBy = null;

    //================== Constructors ========================

    public XPathy() {
        this.xpath = "//*";
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
    }

    //===================================================================


    private XPathy copy() {
        return new XPathy(this);
    }

    //======================= Static creators ===================

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

    public static XPathy from(Tag tag){
        return new XPathy("//" + tag);
    }

    public static XPathy from(XPathy xPathy){
        return new XPathy(xPathy);
    }

    public static XPathy from(String baseXpath){
        return new XPathy(baseXpath);
    }
    public static XPathy of(Tag tag){
        return new XPathy("//" + tag);
    }


    //======================================================================

    private boolean checkXpathFormatToAppendAndOr() {
        String trimmedXpath = this.xpath.trim();
        return !trimmedXpath.matches(".*\\[\\d+\\]$") && !trimmedXpath.endsWith("[last()]");
    }


    public By toBy() {
        return isByCss ? cssBy : By.xpath(xpath);
    }

    public By asLocator(){
        return toBy();
    }

    public By getLocator(){
        return toBy();
    }

    public String getXpath(){
        return this.xpath;
    }

    public XPathy nth(int elementNumber) {
        XPathy copy = this.copy();
        copy.xpath = "(" + this.xpath + ")[" + elementNumber + "]";
        return copy;
    }

    public XPathy last() {
        XPathy copy = this.copy();
        copy.xpath = "(" + this.xpath + ")[last()]";
        return copy;
    }

    public XPathy tag(Tag tag) {
        XPathy copy = this.copy();
        copy.xpath = this.xpath + "//" + tag;
        return copy;
    }

    public XPathy equals(Attribute attribute, String value) {
        XPathy copy = this.copy();
        copy.xpath = this.xpath + "[@" + attribute + "='" + value + "']";
        return copy;
    }

    public XPathy textEquals(String text) {
        XPathy copy = this.copy();
        copy.xpath = this.xpath + "[text()='" + text + "']";
        return copy;
    }

    public XPathy contains(Attribute attribute, String value) {
        XPathy copy = this.copy();
        copy.xpath = this.xpath + "[contains(@" + attribute + ", '" + value + "')]";
        return copy;
    }

    public XPathy textContains(String value) {
        XPathy copy = this.copy();
        copy.xpath = this.xpath + "[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" + value + "')]";
        return copy;
    }



    public XPathy startsWith(Attribute attribute, String value) {
        XPathy copy = this.copy();
        copy.xpath = this.xpath + "[starts-with(@" + attribute + ", '" + value + "')]" ;
        return copy;
    }

    public XPathy textStartsWith(String text) {
        XPathy copy = this.copy();
        copy.xpath = this.xpath + "[starts-with(text(), '" + text + "')]";
        return copy;
    }


    public XPathy andEquals(Attribute attribute, String value) {
        String trimmed = this.xpath.trim();

        if (checkXpathFormatToAppendAndOr() &&
                        (trimmed.endsWith("']") || trimmed.endsWith(")]")))
        {
            XPathy copy = this.copy();
            copy.xpath = this.xpath.substring(0, xpath.length() - 1) + " and @" + attribute + "='" + value + "']";
            return copy;
        }

        return equals(attribute, value);

    }

    public XPathy andTextEquals(String value) {
        String trimmed = this.xpath.trim();

        if (checkXpathFormatToAppendAndOr() &&
                (trimmed.endsWith("']") || trimmed.endsWith(")]")))
        {
            XPathy copy = this.copy();
            copy.xpath = this.xpath.substring(0, xpath.length() - 1) + " and text()='" + value + "']";
            return copy;
        }

        return textEquals(value);

    }

    public XPathy andContains(Attribute attribute, String value) {
        String trimmed = this.xpath.trim();

        if (checkXpathFormatToAppendAndOr() &&
                (trimmed.endsWith("']") || trimmed.endsWith(")]")))
        {
            XPathy copy = this.copy();
            copy.xpath = this.xpath.substring(0, xpath.length() - 1)
                    + " and contains(@" + attribute + ", '" + value + "')]";
            return copy;
        }

        return contains(attribute, value);
    }

    public XPathy andTextContains(String value) {
        String trimmed = this.xpath.trim();

        if (checkXpathFormatToAppendAndOr() &&
                (trimmed.endsWith("']") || trimmed.endsWith(")]")))
        {
            XPathy copy = this.copy();
            copy.xpath = this.xpath.substring(0, xpath.length() - 1)
                    + " and contains(text(), '" + value + "')]";
            return copy;
        }

        return textContains(value);
    }

    public XPathy or(Tag tag) {
        XPathy copy = this.copy();
        copy.xpath = this.xpath + " | //" + tag;
        return copy;
    }

    public XPathy or(By by) {
        XPathy copy = this.copy();
        copy.xpath = this.xpath + " | " + XPathy.from(by).xpath;
        return copy;
    }

    public XPathy or() {
        XPathy copy = this.copy();
        copy.xpath = this.xpath + " | //*" ;
        return copy;
    }

    public XPathy or(XPathy xPathy){
        XPathy copy = this.copy();
        copy.xpath = this.xpath + " | " + xPathy.xpath;
        return copy;
    }

    public XPathy or(XPathy... xPathies) {
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



    public XPathy orEquals(Attribute attribute, String value) {
        String trimmed = this.xpath.trim();

        if (checkXpathFormatToAppendAndOr() &&
                (trimmed.endsWith("']") || trimmed.endsWith(")]")))
        {
            XPathy copy = this.copy();
            copy.xpath = this.xpath.substring(0, xpath.length() - 1) + " or @" + attribute + "='" + value + "']";
            return copy;
        }

        if(trimmed.replaceAll(" +", "").endsWith("|//*")){
            XPathy copy = this.copy();
            copy.xpath = new XPathy(this.xpath).equals(attribute, value).xpath ;
            return copy;
        }

        XPathy copy = this.copy();
        copy.xpath = new XPathy(this.xpath + " | " + "//*").equals(attribute, value).xpath ;
        return copy;
    }

    public XPathy orTextEquals(String value) {
        String trimmed = this.xpath.trim();

        if (checkXpathFormatToAppendAndOr() &&
                (trimmed.endsWith("']") || trimmed.endsWith(")]")))
        {
            XPathy copy = this.copy();
            copy.xpath = this.xpath.substring(0, xpath.length() - 1) + " or text()='" + value + "']";
            return copy;
        }

        if(trimmed.replaceAll(" +", "").endsWith("|//*")){
            XPathy copy = this.copy();
            copy.xpath = new XPathy(this.xpath).textEquals(value).xpath ;
            return copy;
        }

        XPathy copy = this.copy();
        copy.xpath = new XPathy(this.xpath + " | " + "//*").textEquals(value).xpath ;
        return copy;
    }

    public XPathy orContains(Attribute attribute, String value) {
        String trimmed = this.xpath.trim();

        if (checkXpathFormatToAppendAndOr() &&
                (trimmed.endsWith("']") || trimmed.endsWith(")]")))
        {
            XPathy copy = this.copy();
            copy.xpath = this.xpath.substring(0, xpath.length() - 1)
                    + " or contains(@" + attribute + ", '" + value + "')]";
            return copy;
        }

        if(trimmed.replaceAll(" +", "").endsWith("|//*")){
            XPathy copy = this.copy();
            copy.xpath = new XPathy(this.xpath).contains(attribute, value).xpath ;
            return copy;
        }

        XPathy copy = this.copy();
        copy.xpath = new XPathy(this.xpath + " | " + "//*").contains(attribute, value).xpath ;
        return copy;
    }

    public XPathy orTextContains(String value) {
        String trimmed = this.xpath.trim();

        if (checkXpathFormatToAppendAndOr() &&
                (trimmed.endsWith("']") || trimmed.endsWith(")]")))
        {
            XPathy copy = this.copy();
            copy.xpath = this.xpath.substring(0, xpath.length() - 1)
                    + " or contains(text(), '" + value + "')]";
            return copy;
        }

        if(trimmed.replaceAll(" +", "").endsWith("|//*")){
            XPathy copy = this.copy();
            copy.xpath = new XPathy(this.xpath).textContains(value).xpath ;
            return copy;
        }

        XPathy copy = this.copy();
        copy.xpath = new XPathy(this.xpath + " | " + "//*").textContains(value).xpath ;
        return copy;
    }


    public XPathy parent(Tag tag) {
        XPathy copy = this.copy();
        copy.xpath = this.xpath + "/parent::" + tag;
        return copy;
    }

    public XPathy parent() {
        XPathy copy = this.copy();
        copy.xpath = this.xpath + "/..";
        return copy;
    }

    public XPathy up(int count) {
        XPathy copy = this.copy();
        StringBuilder upPath = new StringBuilder();
        for (int i = 0; i < count; i++) {
            upPath.append("/..");
        }
        copy.xpath = this.xpath + upPath.toString();
        return copy;
    }


    public XPathy ancestors(Tag tag) {
        XPathy copy = this.copy();
        copy.xpath = this.xpath + "/ancestor::" + tag;
        return copy;
    }

    public XPathy ancestors() {
        XPathy copy = this.copy();
        copy.xpath = this.xpath + "/ancestor::*";
        return copy;
    }

    public XPathy children(Tag tag) {
        XPathy copy = this.copy();
        copy.xpath = this.xpath + "/child::" + tag ;
        return copy;
    }

    public XPathy children() {
        XPathy copy = this.copy();
        copy.xpath = this.xpath + "/child::*";
        return copy;
    }

    public XPathy descendants(Tag tag) {
        XPathy copy = this.copy();
        copy.xpath = this.xpath + "/descendant::" + tag;
        return copy;
    }

    public XPathy descendants() {
        XPathy copy = this.copy();
        copy.xpath = this.xpath + "/descendant::*";
        return copy;
    }

    public XPathy following_siblings(Tag tag) {
        XPathy copy = this.copy();
        copy.xpath = this.xpath + "/following-sibling::" + tag;
        return copy;
    }

    public XPathy following_siblings() {
        XPathy copy = this.copy();
        copy.xpath = this.xpath + "/following-sibling::*";
        return copy;
    }

    public XPathy preceding_siblings(Tag tag) {
        XPathy copy = this.copy();
        copy.xpath = this.xpath + "/preceding-sibling::" + tag;
        return copy;
    }

    public XPathy preceding_siblings() {
        XPathy copy = this.copy();
        copy.xpath = this.xpath + "/preceding-sibling::*";
        return copy;
    }

    public XPathy greaterThan(int number) {
        XPathy copy = this.copy();
        copy.xpath = this.xpath + "[. > " + number +  "]";
        return copy;
    }

    public XPathy attributeGreaterThan(Attribute attribute, int number) {
        XPathy copy = this.copy();
        copy.xpath = this.xpath + "[@" + attribute + " > " + number + "]";
        return copy;
    }

    public XPathy greaterOrEquals(int number) {
        XPathy copy = this.copy();
        copy.xpath = this.xpath + "[. >= " + number +  "]";
        return copy;
    }

    public XPathy attributeGreaterOrEquals(Attribute attribute, int number) {
        XPathy copy = this.copy();
        copy.xpath = this.xpath + "[@" + attribute + " >= " + number + "]";
        return copy;
    }

    public XPathy lessThan(int number) {
        XPathy copy = this.copy();
        copy.xpath = this.xpath + "[. < " + number +  "]";
        return copy;
    }

    public XPathy attributeLessThan(Attribute attribute, int number) {
        XPathy copy = this.copy();
        copy.xpath = this.xpath + "[@" + attribute + " < " + number + "]";
        return copy;
    }

    public XPathy lessOrEquals(int number) {
        XPathy copy = this.copy();
        copy.xpath = this.xpath + "[. <= " + number +  "]";
        return copy;
    }

    public XPathy attributeLessOrEquals(Attribute attribute, int number) {
        XPathy copy = this.copy();
        copy.xpath = this.xpath + "[@" + attribute + " <= " + number + "]";
        return copy;
    }

    public XPathy notEquals(Attribute attribute, String value) {
        XPathy copy = this.copy();
        copy.xpath = this.xpath + "[not(@" + attribute + "='" + value +  "')]";
        return copy;
    }

    public XPathy textNotEquals(String value) {
        XPathy copy = this.copy();
        copy.xpath = this.xpath + "[not(text() = '" + value + "')]";
        return copy;
    }


}
