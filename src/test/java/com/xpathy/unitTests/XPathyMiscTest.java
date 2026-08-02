package com.xpathy.unitTests;

import static com.xpathy.Attribute.class_;
import static com.xpathy.Attribute.id;
import static com.xpathy.Tag.div;
import static com.xpathy.Tag.span;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.xpathy.XPathy;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

class XPathyMiscTest {

    @Test
    void nth() {
        assertEquals("(//div[@class='item'])[2]", div.byAttribute(class_).equals("item").nth(2).getXpath());
    }

    @Test
    void index() {
        assertEquals("(//div[@class='item'])[3]", div.byAttribute(class_).equals("item").index(3).getXpath());
    }

    @Test
    void last() {
        assertEquals("(//div[@class='item'])[last()]", div.byAttribute(class_).equals("item").last().getXpath());
    }

    @Test
    void appendString() {
        assertEquals("//div[@id='a']/span", div.byAttribute(id).equals("a").append("/span").getXpath());
    }

    @Test
    void orWithAnotherXPathy() {
        assertEquals("//div[@id='a'] | //span[@id='b']",
                div.byAttribute(id).equals("a").or(span.byAttribute(id).equals("b")).getXpath());
    }

    @Test
    void fromById() {
        assertEquals("//*[@id='myid']", XPathy.from(By.id("myid")).getXpath());
    }

    @Test
    void fromByClassName() {
        assertEquals("//*[contains(concat(' ', normalize-space(@class), ' '), ' myclass ')]",
                XPathy.from(By.className("myclass")).getXpath());
    }

    @Test
    void ofTag() {
        assertEquals("//div", XPathy.of(div).getXpath());
    }

    @Test
    void getLocatorReturnsByXpath() {
        By locator = div.byAttribute(id).equals("main").getLocator();
        assertEquals(By.xpath("//div[@id='main']"), locator);
    }

    @Test
    void toStringReturnsXpath() {
        XPathy xpathy = div.byAttribute(id).equals("main");
        assertEquals(xpathy.getXpath(), xpathy.toString());
    }
}
