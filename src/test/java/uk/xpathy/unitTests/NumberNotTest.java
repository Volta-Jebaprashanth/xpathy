package uk.xpathy.unitTests;

import static uk.xpathy.Tag.span;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class NumberNotTest {

    @Test
    void notEqualsBecomesNotEquals() {
        assertEquals("//span[number(text()) != 5]", span.byNumber().not().equals(5).getXpath());
    }

    @Test
    void notGreaterThanBecomesLessThanOrEquals() {
        assertEquals("//span[number(text()) <= 5]", span.byNumber().not().greaterThan(5).getXpath());
    }

    @Test
    void notGreaterThanOrEqualsBecomesLessThan() {
        assertEquals("//span[number(text()) < 5]", span.byNumber().not().greaterThanOrEquals(5).getXpath());
    }

    @Test
    void notLessThanBecomesGreaterThanOrEquals() {
        assertEquals("//span[number(text()) >= 5]", span.byNumber().not().lessThan(5).getXpath());
    }

    @Test
    void notLessThanOrEqualsBecomesGreaterThan() {
        assertEquals("//span[number(text()) > 5]", span.byNumber().not().lessThanOrEquals(5).getXpath());
    }

    @Test
    void notBetween() {
        assertEquals("//span[ not ( number(text()) >= 5 and number(text()) <= 15 ) ]",
                span.byNumber().not().between(5, 15).getXpath());
    }
}
