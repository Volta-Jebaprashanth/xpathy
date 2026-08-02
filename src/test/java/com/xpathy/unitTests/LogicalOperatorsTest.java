package com.xpathy.unitTests;

import static com.xpathy.Attribute.class_;
import static com.xpathy.Attribute.id;
import static com.xpathy.Tag.div;
import static com.xpathy.Tag.span;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class LogicalOperatorsTest {

    @Test
    void and() {
        assertEquals("//div[@id='main-container' and contains(text(), 'Hello World')]",
                div.byAttribute(id).equals("main-container").and().byText().contains("Hello World").getXpath());
    }

    @Test
    void or() {
        assertEquals("//div[@id='main-container' or contains(text(), 'Hello World')]",
                div.byAttribute(id).equals("main-container").or().byText().contains("Hello World").getXpath());
    }

    @Test
    void not() {
        assertEquals("//div[contains(text(), 'Hello World') and not(@id='main-container')]",
                div.byText().contains("Hello World").and().byAttribute(id).not().equals("main-container").getXpath());
    }

    @Test
    void chainedMultipleLogicalOperations() {
        assertEquals("//span[contains(text(), 'Discount') and not(@class='expired') or number(text()) > 50]",
                span.byText().contains("Discount")
                        .and().byAttribute(class_).not().equals("expired")
                        .or().byNumber().greaterThan(50)
                        .getXpath());
    }
}
