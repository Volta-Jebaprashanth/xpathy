package uk.xpathy.unitTests;

import static uk.xpathy.Attribute.class_;
import static uk.xpathy.Attribute.href;
import static uk.xpathy.Attribute.id;
import static uk.xpathy.Attribute.name;
import static uk.xpathy.Attribute.type;
import static uk.xpathy.Tag.a;
import static uk.xpathy.Tag.button;
import static uk.xpathy.Tag.div;
import static uk.xpathy.Tag.h2;
import static uk.xpathy.Tag.input;
import static uk.xpathy.Tag.label;
import static uk.xpathy.Tag.li;
import static uk.xpathy.Tag.option;
import static uk.xpathy.Tag.p;
import static uk.xpathy.Tag.section;
import static uk.xpathy.Tag.span;
import static uk.xpathy.Tag.ul;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class DomNavigationTest {

    @Test
    void tag() {
        assertEquals("//div[@class='container']//button[text() = 'Submit']",
                div.byAttribute(class_).equals("container").$tag(button).byText().equals("Submit").getXpath());
    }

    @Test
    void childAny() {
        assertEquals("//ul[@id='menu']/child::*[contains(text(), 'Home')]",
                ul.byAttribute(id).equals("menu").$child().byText().contains("Home").getXpath());
    }

    @Test
    void childSpecificTag() {
        assertEquals("//ul[@id='menu']/child::li[contains(text(), 'Contact')]",
                ul.byAttribute(id).equals("menu").$child(li).byText().contains("Contact").getXpath());
    }

    @Test
    void ancestorAny() {
        assertEquals("//a[contains(@href, 'profile')]/ancestor::*[@id='navbar']",
                a.byAttribute(href).contains("profile").$ancestor().byAttribute(id).equals("navbar").getXpath());
    }

    @Test
    void ancestorSpecificTag() {
        assertEquals("//span[text() = 'Settings']/ancestor::div[@class='dropdown']",
                span.byText().equals("Settings").$ancestor(div).byAttribute(class_).equals("dropdown").getXpath());
    }

    @Test
    void descendantSpecificTag() {
        assertEquals("//section[@id='content']/descendant::p[contains(text(), 'Welcome')]",
                section.byAttribute(id).equals("content").$descendant(p).byText().contains("Welcome").getXpath());
    }

    @Test
    void descendantAny() {
        assertEquals("//div[@class='card']/descendant::*[@class='price']",
                div.byAttribute(class_).equals("card").$descendant().byAttribute(class_).equals("price").getXpath());
    }

    @Test
    void parentSpecificTag() {
        assertEquals("//span[text() = '$19.99']/parent::div[@class='product']",
                span.byText().equals("$19.99").$parent(div).byAttribute(class_).equals("product").getXpath());
    }

    @Test
    void upMultipleLevels() {
        assertEquals("//input[@name='email']/../..[@id='form-container']",
                input.byAttribute(name).equals("email").$up(2).byAttribute(id).equals("form-container").getXpath());
    }

    @Test
    void followingSiblingSpecificTag() {
        assertEquals("//label[text() = 'Username']/following-sibling::input[@type='text']",
                label.byText().equals("Username").$followingSibling(input).byAttribute(type).equals("text").getXpath());
    }

    @Test
    void followingSiblingAny() {
        assertEquals("//h2[text() = 'Features']/following-sibling::*[@class='description']",
                h2.byText().equals("Features").$followingSibling().byAttribute(class_).equals("description").getXpath());
    }

    @Test
    void precedingSiblingAny() {
        assertEquals("//li[text() = 'Contact']/preceding-sibling::*[text() = 'About']",
                li.byText().equals("Contact").$precedingSibling().byText().equals("About").getXpath());
    }

    @Test
    void precedingSiblingSpecificTag() {
        assertEquals("//option[text() = 'Canada']/preceding-sibling::option[text() = 'USA']",
                option.byText().equals("Canada").$precedingSibling(option).byText().equals("USA").getXpath());
    }

    @Test
    void multipleNavigationsChained() {
        assertEquals("//div[contains(@id, 'main-container')]/../following-sibling::div/descendant::*[contains(text(), 'Hello World')]",
                div.byAttribute(id).contains("main-container")
                        .$parent()
                        .$followingSibling(div)
                        .$descendant()
                        .byText().contains("Hello World")
                        .getXpath());
    }
}
