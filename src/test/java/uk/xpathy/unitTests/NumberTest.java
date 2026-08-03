package uk.xpathy.unitTests;

import static uk.xpathy.Tag.span;
import static uk.xpathy.Tag.td;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class NumberTest {

    @Test
    void greaterThan() {
        assertEquals("//td[number(text()) > 10]", td.byNumber().greaterThan(10).getXpath());
    }

    @Test
    void between() {
        assertEquals("//span[ ( number(text()) >= 5 and number(text()) <= 15 ) ]", span.byNumber().between(5, 15).getXpath());
    }

    @Test
    void equals() {
        assertEquals("//span[number(text()) = 5]", span.byNumber().equals(5).getXpath());
    }

    @Test
    void lessThan() {
        assertEquals("//span[number(text()) < 5]", span.byNumber().lessThan(5).getXpath());
    }

    @Test
    void notGreaterThanBecomesLessThanOrEquals() {
        assertEquals("//span[number(text()) <= 5]", span.byNumber().not().greaterThan(5).getXpath());
    }
}
