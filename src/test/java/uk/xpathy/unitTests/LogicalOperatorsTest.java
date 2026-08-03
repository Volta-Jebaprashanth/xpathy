package uk.xpathy.unitTests;

import static uk.xpathy.Attribute.class_;
import static uk.xpathy.Attribute.id;
import static uk.xpathy.Style.backgroundColor;
import static uk.xpathy.Tag.div;
import static uk.xpathy.Tag.span;
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

    @Test
    void threeWayAndAnd() {
        assertEquals("//div[@id='a' and contains(text(), 'b') and number(text()) > 5]",
                div.byAttribute(id).equals("a")
                        .and().byText().contains("b")
                        .and().byNumber().greaterThan(5)
                        .getXpath());
    }

    @Test
    void threeWayOrOr() {
        assertEquals("//div[@id='a' or contains(text(), 'b') or number(text()) > 5]",
                div.byAttribute(id).equals("a")
                        .or().byText().contains("b")
                        .or().byNumber().greaterThan(5)
                        .getXpath());
    }

    @Test
    void threeWayAndOr() {
        assertEquals("//div[@id='a' and contains(text(), 'b') or number(text()) > 5]",
                div.byAttribute(id).equals("a")
                        .and().byText().contains("b")
                        .or().byNumber().greaterThan(5)
                        .getXpath());
    }

    @Test
    void threeWayOrAnd() {
        assertEquals("//div[@id='a' or contains(text(), 'b') and number(text()) > 5]",
                div.byAttribute(id).equals("a")
                        .or().byText().contains("b")
                        .and().byNumber().greaterThan(5)
                        .getXpath());
    }

    @Test
    void andThenNot() {
        assertEquals("//div[@id='a' and not(contains(text(), 'b'))]",
                div.byAttribute(id).equals("a").and().byText().not().contains("b").getXpath());
    }

    @Test
    void orThenNot() {
        assertEquals("//div[@id='a' or not(contains(text(), 'b'))]",
                div.byAttribute(id).equals("a").or().byText().not().contains("b").getXpath());
    }

    @Test
    void notThenAnd() {
        assertEquals("//div[not(@id='a') and contains(text(), 'b')]",
                div.byAttribute(id).not().equals("a").and().byText().contains("b").getXpath());
    }

    @Test
    void notThenOr() {
        assertEquals("//div[not(@id='a') or contains(text(), 'b')]",
                div.byAttribute(id).not().equals("a").or().byText().contains("b").getXpath());
    }

    @Test
    void notAndNot() {
        assertEquals("//div[not(@id='a') and not(contains(text(), 'b'))]",
                div.byAttribute(id).not().equals("a").and().byText().not().contains("b").getXpath());
    }

    @Test
    void notOrNot() {
        assertEquals("//div[not(@id='a') or not(contains(text(), 'b'))]",
                div.byAttribute(id).not().equals("a").or().byText().not().contains("b").getXpath());
    }

    @Test
    void fourWayAcrossAllContexts() {
        assertEquals("//div[@id='a' and contains(text(), 'b') and number(text()) > 5 and contains(translate(@style, ' ', ''), 'background-color:red;')]",
                div.byAttribute(id).equals("a")
                        .and().byText().contains("b")
                        .and().byNumber().greaterThan(5)
                        .and().byStyle(backgroundColor).equals("red")
                        .getXpath());
    }

    @Test
    void fourWayMixedWithNot() {
        assertEquals("//div[not(@id='a') and contains(text(), 'b') or number(text()) <= 5 and contains(translate(@style, ' ', ''), 'background-color:') and not(contains(translate(@style, ' ', ''), 'background-color:red;'))]",
                div.byAttribute(id).not().equals("a")
                        .and().byText().contains("b")
                        .or().byNumber().not().greaterThan(5)
                        .and().byStyle(backgroundColor).not().equals("red")
                        .getXpath());
    }
}
