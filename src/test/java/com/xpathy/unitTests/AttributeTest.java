package com.xpathy.unitTests;

import static com.xpathy.Attribute.*;
import static com.xpathy.Tag.div;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class AttributeTest {

    @Test
    void contains() {
        assertEquals("//*[contains(@id, 'login-button')]", id.contains("login-button").getXpath());
    }

    @Test
    void equals() {
        assertEquals("//*[@class='active']", class_.equals("active").getXpath());
    }

    @Test
    void startsWith() {
        assertEquals("//*[starts-with(@data-testid, 'menu-')]", data_testid.startsWith("menu-").getXpath());
    }

    @Test
    void greaterThan() {
        assertEquals("//*[@value > 100]", value.greaterThan(100).getXpath());
    }

    @Test
    void lessThan() {
        assertEquals("//*[@value < 50]", value.lessThan(50).getXpath());
    }

    @Test
    void greaterThanOrEquals() {
        assertEquals("//*[@value >= 100]", value.greaterThanOrEquals(100).getXpath());
    }

    @Test
    void lessThanOrEquals() {
        assertEquals("//*[@value <= 100]", value.lessThanOrEquals(100).getXpath());
    }

    @Test
    void between() {
        assertEquals("//div[ ( @value > 10 and @value < 20 ) ]", div.byAttribute(value).between(10, 20).getXpath());
    }

    @Test
    void haveIt() {
        assertEquals("//*[@id]", id.haveIt().getXpath());
    }

    @Test
    void isEmpty() {
        assertEquals("//*[normalize-space(@id)='']", id.isEmpty().getXpath());
    }

    @Test
    void isNumeric() {
        assertEquals("//*[not(number(@value) != number(@value))]", value.isNumeric().getXpath());
    }

    @Test
    void notEquals() {
        assertEquals("//*[not(@id='x')]", id.not().equals("x").getXpath());
    }

    @Test
    void byLengthEquals() {
        assertEquals("//*[@id and string-length(@id) = 5]", id.byLength().equals(5).getXpath());
    }
}
