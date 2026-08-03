package uk.xpathy.unitTests;

import static uk.xpathy.Attribute.id;
import static uk.xpathy.Attribute.value;
import static uk.xpathy.Tag.div;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class AttributeNotTest {

    @Test
    void notEqualsString() {
        assertEquals("//*[not(@id='main-container')]", id.not().equals("main-container").getXpath());
    }

    @Test
    void notContains() {
        assertEquals("//*[not(contains(@id, 'btn'))]", id.not().contains("btn").getXpath());
    }

    @Test
    void notStartsWith() {
        assertEquals("//*[not(starts-with(@id, 'menu-'))]", id.not().startsWith("menu-").getXpath());
    }

    @Test
    void notHaveIt() {
        assertEquals("//*[not(@id)]", id.not().haveIt().getXpath());
    }

    @Test
    void notEmpty() {
        assertEquals("//*[not(normalize-space(@id)='')]", id.not().empty().getXpath());
    }

    @Test
    void notNumeric() {
        assertEquals("//*[not(not(number(@value) != number(@value)))]", value.not().numeric().getXpath());
    }

    @Test
    void notEqualsNumber() {
        assertEquals("//*[not(@value = 100)]", value.not().equals(100).getXpath());
    }

    @Test
    void notGreaterThanBecomesLessThanOrEquals() {
        assertEquals("//*[@value <= 100]", value.not().greaterThan(100).getXpath());
    }

    @Test
    void notGreaterThanOrEqualsBecomesLessThan() {
        assertEquals("//*[@value < 100]", value.not().greaterThanOrEquals(100).getXpath());
    }

    @Test
    void notLessThanBecomesGreaterThanOrEquals() {
        assertEquals("//*[@value >= 100]", value.not().lessThan(100).getXpath());
    }

    @Test
    void notLessThanOrEqualsBecomesGreaterThan() {
        assertEquals("//*[@value > 100]", value.not().lessThanOrEquals(100).getXpath());
    }

    @Test
    void notBetween() {
        assertEquals("//div[ not ( @value > 10 and @value < 20 ) ]",
                div.byAttribute(value).not().between(10, 20).getXpath());
    }

    // ===== byLength().not() =====

    @Test
    void notLengthEquals() {
        assertEquals("//*[@id and string-length(@id) != 5]", id.byLength().not().equals(5).getXpath());
    }

    @Test
    void notLengthLessThanBecomesGreaterThanOrEquals() {
        assertEquals("//*[@id and string-length(@id) >= 10]", id.byLength().not().lessThan(10).getXpath());
    }

    @Test
    void notLengthLessThanOrEqualsBecomesGreaterThan() {
        assertEquals("//*[@id and string-length(@id) > 10]", id.byLength().not().lessThanOrEquals(10).getXpath());
    }

    @Test
    void notLengthGreaterThanBecomesLessThanOrEquals() {
        assertEquals("//*[@id and string-length(@id) <= 2]", id.byLength().not().greaterThan(2).getXpath());
    }

    @Test
    void notLengthGreaterThanOrEqualsBecomesLessThan() {
        assertEquals("//*[@id and string-length(@id) < 2]", id.byLength().not().greaterThanOrEquals(2).getXpath());
    }
}
