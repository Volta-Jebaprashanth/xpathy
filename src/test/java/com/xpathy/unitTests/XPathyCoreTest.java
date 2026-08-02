package com.xpathy.unitTests;

import static com.xpathy.Attribute.class_;
import static com.xpathy.Attribute.id;
import static com.xpathy.Attribute.name;
import static com.xpathy.Tag.div;
import static com.xpathy.Tag.input;
import static com.xpathy.Tag.p;
import static com.xpathy.Tag.span;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.xpathy.Text;
import com.xpathy.XPathy;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

class XPathyCoreTest {

    @Test
    void fromTag() {
        assertEquals("//div", XPathy.from(div).getXpath());
    }

    @Test
    void fromXPathy() {
        assertEquals("//div[@id='x']", XPathy.from(div.byAttribute(id).equals("x")).getXpath());
    }

    @Test
    void fromString() {
        assertEquals("//custom/path", XPathy.from("//custom/path").getXpath());
    }

    @Test
    void asLocatorReturnsByXpath() {
        assertEquals(By.xpath("//div[@id='x']"), div.byAttribute(id).equals("x").asLocator());
    }

    @Test
    void upNoArgMovesOneLevel() {
        assertEquals("//input[@name='email']/..[@id='form']",
                input.byAttribute(name).equals("email").$up().byAttribute(id).equals("form").getXpath());
    }

    @Test
    void orWithBy() {
        assertEquals("//div[@id='a'] | //*[@id='b']",
                div.byAttribute(id).equals("a").or(By.id("b")).getXpath());
    }

    @Test
    void orVarargsWithMultipleXPathies() {
        assertEquals("//div[@id='a'] | //span[@id='b'] | //p[@id='c']",
                div.byAttribute(id).equals("a").or(
                        span.byAttribute(id).equals("b"),
                        p.byAttribute(id).equals("c")
                ).getXpath());
    }

    @Test
    void appendBy() {
        assertEquals("//div[@id='a']/span",
                div.byAttribute(id).equals("a").append(By.xpath("/span")).getXpath());
    }

    @Test
    void appendXPathy() {
        assertEquals("//div[@id='a']/span",
                div.byAttribute(id).equals("a").append(XPathy.from("/span")).getXpath());
    }

    @Test
    void constructFromBy() {
        assertEquals("//*[@id='myid']", new XPathy(By.id("myid")).getXpath());
    }

    @Test
    void byHavingDirectOnInstanceAppendsSeparatePredicate() {
        assertEquals("//div[@class='card'][( span[contains(text(), 'x')] )]",
                div.byAttribute(class_).equals("card").byHaving(span.byText().contains("x")).getXpath());
    }

    // Text and the internal AND/OR merger are public utility classes with only
    // static members; these calls exist solely to cover their implicit public constructors.
    @Test
    void utilityClassesHavePublicDefaultConstructors() {
        assertEquals(new Text().getClass(), Text.class);
        assertEquals(new com.xpathy._Multiple_And_Or_Merger_().getClass(), com.xpathy._Multiple_And_Or_Merger_.class);
    }
}
