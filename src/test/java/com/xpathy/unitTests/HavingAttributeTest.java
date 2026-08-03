package com.xpathy.unitTests;

import static com.xpathy.Attribute.id;
import static com.xpathy.Attribute.value;
import static com.xpathy.Case.IGNORED;
import static com.xpathy.Only.NUMBERS;
import static com.xpathy.Tag.div;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class HavingAttributeTest {

    // ===== __Having_Attribute_ terminal methods =====

    @Test
    void equals() {
        assertEquals("//div[./*[@id='x']]", div.byHaving().child().byAttribute(id).equals("x").getXpath());
    }

    @Test
    void haveIt() {
        assertEquals("//div[./*[@id]]", div.byHaving().child().byAttribute(id).haveIt().getXpath());
    }

    @Test
    void contains() {
        assertEquals("//div[./*[contains(@id, 'x')]]", div.byHaving().child().byAttribute(id).contains("x").getXpath());
    }

    @Test
    void startsWith() {
        assertEquals("//div[./*[starts-with(@id, 'x')]]", div.byHaving().child().byAttribute(id).startsWith("x").getXpath());
    }

    @Test
    void isEmpty() {
        assertEquals("//div[./*[normalize-space(@id)='']]", div.byHaving().child().byAttribute(id).isEmpty().getXpath());
    }

    @Test
    void isNumeric() {
        assertEquals("//div[./*[not(number(@value) != number(@value))]]", div.byHaving().child().byAttribute(value).isNumeric().getXpath());
    }

    @Test
    void equalsNumber() {
        assertEquals("//div[./*[@value = 5]]", div.byHaving().child().byAttribute(value).equals(5).getXpath());
    }

    @Test
    void greaterThan() {
        assertEquals("//div[./*[@value > 5]]", div.byHaving().child().byAttribute(value).greaterThan(5).getXpath());
    }

    @Test
    void greaterThanOrEquals() {
        assertEquals("//div[./*[@value >= 5]]", div.byHaving().child().byAttribute(value).greaterThanOrEquals(5).getXpath());
    }

    @Test
    void lessThan() {
        assertEquals("//div[./*[@value < 5]]", div.byHaving().child().byAttribute(value).lessThan(5).getXpath());
    }

    @Test
    void lessThanOrEquals() {
        assertEquals("//div[./*[@value <= 5]]", div.byHaving().child().byAttribute(value).lessThanOrEquals(5).getXpath());
    }

    // ===== __Having_Attribute_Not_ =====

    @Test
    void notHaveIt() {
        assertEquals("//div[./*[not(@id)]]", div.byHaving().child().byAttribute(id).not().haveIt().getXpath());
    }

    @Test
    void notEquals() {
        assertEquals("//div[./*[not(@id='x')]]", div.byHaving().child().byAttribute(id).not().equals("x").getXpath());
    }

    @Test
    void notContains() {
        assertEquals("//div[./*[not(contains(@id, 'x'))]]", div.byHaving().child().byAttribute(id).not().contains("x").getXpath());
    }

    @Test
    void notStartsWith() {
        assertEquals("//div[./*[not(starts-with(@id, 'x'))]]", div.byHaving().child().byAttribute(id).not().startsWith("x").getXpath());
    }

    @Test
    void notEmpty() {
        assertEquals("//div[./*[not(normalize-space(@id)='')]]", div.byHaving().child().byAttribute(id).not().empty().getXpath());
    }

    @Test
    void notNumeric() {
        assertEquals("//div[./*[not(not(number(@value) != number(@value)))]]", div.byHaving().child().byAttribute(value).not().numeric().getXpath());
    }

    @Test
    void notEqualsNumber() {
        assertEquals("//div[./*[not(@value = 5)]]", div.byHaving().child().byAttribute(value).not().equals(5).getXpath());
    }

    @Test
    void notGreaterThanBecomesLessThanOrEquals() {
        assertEquals("//div[./*[@value <= 5]]", div.byHaving().child().byAttribute(value).not().greaterThan(5).getXpath());
    }

    @Test
    void notGreaterThanOrEqualsBecomesLessThan() {
        assertEquals("//div[./*[@value < 5]]", div.byHaving().child().byAttribute(value).not().greaterThanOrEquals(5).getXpath());
    }

    @Test
    void notLessThanBecomesGreaterThanOrEquals() {
        assertEquals("//div[./*[@value >= 5]]", div.byHaving().child().byAttribute(value).not().lessThan(5).getXpath());
    }

    @Test
    void notLessThanOrEqualsBecomesGreaterThan() {
        assertEquals("//div[./*[@value > 5]]", div.byHaving().child().byAttribute(value).not().lessThanOrEquals(5).getXpath());
    }

    // ===== __Having_Attribute_Length_ =====

    @Test
    void lengthEquals() {
        assertEquals("//div[./*[@id and string-length(@id) = 5]]", div.byHaving().child().byAttribute(id).length().equals(5).getXpath());
    }

    @Test
    void lengthLessThan() {
        assertEquals("//div[./*[@id and string-length(@id) < 5]]", div.byHaving().child().byAttribute(id).length().lessThan(5).getXpath());
    }

    @Test
    void lengthLessThanOrEquals() {
        assertEquals("//div[./*[@id and string-length(@id) <= 5]]", div.byHaving().child().byAttribute(id).length().lessThanOrEquals(5).getXpath());
    }

    @Test
    void lengthGreaterThan() {
        assertEquals("//div[./*[@id and string-length(@id) > 5]]", div.byHaving().child().byAttribute(id).length().greaterThan(5).getXpath());
    }

    @Test
    void lengthGreaterThanOrEquals() {
        assertEquals("//div[./*[@id and string-length(@id) >= 5]]", div.byHaving().child().byAttribute(id).length().greaterThanOrEquals(5).getXpath());
    }

    // ===== __Having_Attribute_Length_Not_ =====

    @Test
    void lengthNotEquals() {
        assertEquals("//div[./*[@id and string-length(@id) != 5]]", div.byHaving().child().byAttribute(id).length().not().equals(5).getXpath());
    }

    @Test
    void lengthNotLessThanBecomesGreaterThanOrEquals() {
        assertEquals("//div[./*[@id and string-length(@id) >= 5]]", div.byHaving().child().byAttribute(id).length().not().lessThan(5).getXpath());
    }

    @Test
    void lengthNotLessThanOrEqualsBecomesGreaterThan() {
        assertEquals("//div[./*[@id and string-length(@id) > 5]]", div.byHaving().child().byAttribute(id).length().not().lessThanOrEquals(5).getXpath());
    }

    @Test
    void lengthNotGreaterThanBecomesLessThanOrEquals() {
        assertEquals("//div[./*[@id and string-length(@id) <= 5]]", div.byHaving().child().byAttribute(id).length().not().greaterThan(5).getXpath());
    }

    @Test
    void lengthNotGreaterThanOrEqualsBecomesLessThan() {
        assertEquals("//div[./*[@id and string-length(@id) < 5]]", div.byHaving().child().byAttribute(id).length().not().greaterThanOrEquals(5).getXpath());
    }

    // ===== __Having_Attribute_ transformations =====

    @Test
    void withTrimEquals() {
        assertEquals("//div[./*[normalize-space(translate(@id, ' ', ' '))='x']]",
                div.byHaving().child().byAttribute(id).withTrim().equals("x").getXpath());
    }

    @Test
    void withNormalizeSpaceEquals() {
        assertEquals("//div[./*[normalize-space(@id)='x']]",
                div.byHaving().child().byAttribute(id).withNormalizeSpace().equals("x").getXpath());
    }

    @Test
    void withCaseEquals() {
        assertEquals("//div[./*[translate(@id, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz')='x']]",
                div.byHaving().child().byAttribute(id).withCase(IGNORED).equals("x").getXpath());
    }

    @Test
    void withRemoveOnlyContains() {
        assertEquals("//div[./*[contains(translate(@id, '0123456789', ''), 'x')]]",
                div.byHaving().child().byAttribute(id).withRemoveOnly(NUMBERS).contains("x").getXpath());
    }

    @Test
    void withKeepOnlyContainsFiltersValueToo() {
        assertEquals("//div[./*[contains(translate(@id, translate(@id, '0123456789', ''), ''), '')]]",
                div.byHaving().child().byAttribute(id).withKeepOnly(NUMBERS).contains("x").getXpath());
    }

    @Test
    void withTranslateContains() {
        assertEquals("//div[./*[contains(translate(@id, 'a', 'b'), 'x')]]",
                div.byHaving().child().byAttribute(id).withTranslate("a", "b").contains("x").getXpath());
    }

    // ===== __Having_Attribute_Length_ transformations =====

    @Test
    void lengthWithTrimEquals() {
        assertEquals("//div[./*[@id and string-length(normalize-space(translate(@id, ' ', ' '))) = 5]]",
                div.byHaving().child().byAttribute(id).length().withTrim().equals(5).getXpath());
    }

    @Test
    void lengthWithCaseEquals() {
        assertEquals("//div[./*[@id and string-length(translate(@id, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz')) = 5]]",
                div.byHaving().child().byAttribute(id).length().withCase(IGNORED).equals(5).getXpath());
    }

    @Test
    void lengthWithNormalizeSpaceEquals() {
        assertEquals("//div[./*[@id and string-length(normalize-space(@id)) = 5]]",
                div.byHaving().child().byAttribute(id).length().withNormalizeSpace().equals(5).getXpath());
    }

    @Test
    void lengthWithRemoveOnlyEquals() {
        assertEquals("//div[./*[@id and string-length(translate(@id, '0123456789', '')) = 5]]",
                div.byHaving().child().byAttribute(id).length().withRemoveOnly(NUMBERS).equals(5).getXpath());
    }

    @Test
    void lengthWithKeepOnlyEquals() {
        assertEquals("//div[./*[@id and string-length(translate(@id, translate(@id, '0123456789', ''), '')) = 5]]",
                div.byHaving().child().byAttribute(id).length().withKeepOnly(NUMBERS).equals(5).getXpath());
    }

    @Test
    void lengthWithTranslateEquals() {
        assertEquals("//div[./*[@id and string-length(translate(@id, 'a', 'b')) = 5]]",
                div.byHaving().child().byAttribute(id).length().withTranslate("a", "b").equals(5).getXpath());
    }
}
