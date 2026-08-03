package uk.xpathy.unitTests;

import static uk.xpathy.Tag.div;
import static uk.xpathy.Tag.span;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TextNotTest {

    @Test
    void notEqualsString() {
        assertEquals("//div[not(text()='Exact')]", div.byText().not().equals("Exact").getXpath());
    }

    @Test
    void notContains() {
        assertEquals("//div[not(contains(text(), 'X'))]", div.byText().not().contains("X").getXpath());
    }

    @Test
    void notStartsWith() {
        assertEquals("//div[not(starts-with(text(), 'Chapter'))]", div.byText().not().startsWith("Chapter").getXpath());
    }

    @Test
    void notEmpty() {
        assertEquals("//div[text()!='']", div.byText().not().empty().getXpath());
    }

    @Test
    void notNumeric() {
        assertEquals("//div[not(not(number(text()) != number(text())))]", div.byText().not().numeric().getXpath());
    }

    @Test
    void notEqualsNumber() {
        assertEquals("//span[not(text() = 5)]", span.byText().not().equals(5).getXpath());
    }

    @Test
    void notGreaterThanBecomesLessThanOrEquals() {
        assertEquals("//span[text() <= 5]", span.byText().not().greaterThan(5).getXpath());
    }

    @Test
    void notGreaterThanOrEqualsBecomesLessThan() {
        assertEquals("//span[text() < 5]", span.byText().not().greaterThanOrEquals(5).getXpath());
    }

    @Test
    void notLessThanBecomesGreaterThanOrEquals() {
        assertEquals("//span[text() >= 5]", span.byText().not().lessThan(5).getXpath());
    }

    @Test
    void notLessThanOrEqualsBecomesGreaterThan() {
        assertEquals("//span[text() > 5]", span.byText().not().lessThanOrEquals(5).getXpath());
    }

    // ===== byLength().not() =====

    @Test
    void notLengthEquals() {
        assertEquals("//div[string-length(text()) != 10]", div.byText().byLength().not().equals(10).getXpath());
    }

    @Test
    void notLengthGreaterThanBecomesLessThanOrEquals() {
        assertEquals("//div[string-length(text()) <= 3]", div.byText().byLength().not().greaterThan(3).getXpath());
    }

    @Test
    void notLengthGreaterThanOrEqualsBecomesLessThan() {
        assertEquals("//div[string-length(text()) < 3]", div.byText().byLength().not().greaterThanOrEquals(3).getXpath());
    }

    @Test
    void notLengthLessThanBecomesGreaterThanOrEquals() {
        assertEquals("//div[string-length(text()) >= 20]", div.byText().byLength().not().lessThan(20).getXpath());
    }

    @Test
    void notLengthLessThanOrEqualsBecomesGreaterThan() {
        assertEquals("//div[string-length(text()) > 20]", div.byText().byLength().not().lessThanOrEquals(20).getXpath());
    }
}
