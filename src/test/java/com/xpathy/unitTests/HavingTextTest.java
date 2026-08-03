package com.xpathy.unitTests;

import static com.xpathy.Case.IGNORED;
import static com.xpathy.Only.NUMBERS;
import static com.xpathy.Tag.div;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class HavingTextTest {

    // ===== __Having_Text_ terminal methods =====

    @Test
    void equals() {
        assertEquals("//div[.//*[text() = 'x']]", div.byHaving().descendant().byText().equals("x").getXpath());
    }

    @Test
    void contains() {
        assertEquals("//div[.//*[contains(text(), 'x')]]", div.byHaving().descendant().byText().contains("x").getXpath());
    }

    @Test
    void startsWith() {
        assertEquals("//div[.//*[starts-with(text(), 'x')]]", div.byHaving().descendant().byText().startsWith("x").getXpath());
    }

    @Test
    void isEmpty() {
        assertEquals("//div[.//*[normalize-space(text())='']]", div.byHaving().descendant().byText().isEmpty().getXpath());
    }

    @Test
    void isNumeric() {
        assertEquals("//div[.//*[not(number(text()) != number(text()))]]", div.byHaving().descendant().byText().isNumeric().getXpath());
    }

    @Test
    void equalsNumber() {
        assertEquals("//div[.//*[text() = 5]]", div.byHaving().descendant().byText().equals(5).getXpath());
    }

    @Test
    void greaterThan() {
        assertEquals("//div[.//*[text() > 5]]", div.byHaving().descendant().byText().greaterThan(5).getXpath());
    }

    @Test
    void greaterThanOrEquals() {
        assertEquals("//div[.//*[text() >= 5]]", div.byHaving().descendant().byText().greaterThanOrEquals(5).getXpath());
    }

    @Test
    void lessThan() {
        assertEquals("//div[.//*[text() < 5]]", div.byHaving().descendant().byText().lessThan(5).getXpath());
    }

    @Test
    void lessThanOrEquals() {
        assertEquals("//div[.//*[text() <= 5]]", div.byHaving().descendant().byText().lessThanOrEquals(5).getXpath());
    }

    // ===== __Having_Text_Not_ (NOT()) =====

    @Test
    void notEquals() {
        assertEquals("//div[.//*[not(text()='x')]]", div.byHaving().descendant().byText().NOT().equals("x").getXpath());
    }

    @Test
    void notContains() {
        assertEquals("//div[.//*[not(contains(text(), 'x'))]]", div.byHaving().descendant().byText().NOT().contains("x").getXpath());
    }

    @Test
    void notStartsWith() {
        assertEquals("//div[.//*[not(starts-with(text(), 'x'))]]", div.byHaving().descendant().byText().NOT().startsWith("x").getXpath());
    }

    @Test
    void notEmpty() {
        assertEquals("//div[.//*[text()!='']]", div.byHaving().descendant().byText().NOT().empty().getXpath());
    }

    @Test
    void notNumeric() {
        assertEquals("//div[.//*[not(not(number(text()) != number(text())))]]", div.byHaving().descendant().byText().NOT().numeric().getXpath());
    }

    @Test
    void notEqualsNumber() {
        assertEquals("//div[.//*[not(text() = 5)]]", div.byHaving().descendant().byText().NOT().equals(5).getXpath());
    }

    @Test
    void notGreaterThanBecomesLessThanOrEquals() {
        assertEquals("//div[.//*[text() <= 5]]", div.byHaving().descendant().byText().NOT().greaterThan(5).getXpath());
    }

    @Test
    void notGreaterThanOrEqualsBecomesLessThan() {
        assertEquals("//div[.//*[text() < 5]]", div.byHaving().descendant().byText().NOT().greaterThanOrEquals(5).getXpath());
    }

    @Test
    void notLessThanBecomesGreaterThanOrEquals() {
        assertEquals("//div[.//*[text() >= 5]]", div.byHaving().descendant().byText().NOT().lessThan(5).getXpath());
    }

    @Test
    void notLessThanOrEqualsBecomesGreaterThan() {
        assertEquals("//div[.//*[text() > 5]]", div.byHaving().descendant().byText().NOT().lessThanOrEquals(5).getXpath());
    }

    // ===== __Having_Text_Length_ (LENGTH()) =====

    @Test
    void lengthEquals() {
        assertEquals("//div[.//*[string-length(text()) = 5]]", div.byHaving().descendant().byText().LENGTH().equals(5).getXpath());
    }

    @Test
    void lengthGreaterThan() {
        assertEquals("//div[.//*[string-length(text()) > 5]]", div.byHaving().descendant().byText().LENGTH().greaterThan(5).getXpath());
    }

    @Test
    void lengthGreaterThanOrEquals() {
        assertEquals("//div[.//*[string-length(text()) >= 5]]", div.byHaving().descendant().byText().LENGTH().greaterThanOrEquals(5).getXpath());
    }

    @Test
    void lengthLessThan() {
        assertEquals("//div[.//*[string-length(text()) < 5]]", div.byHaving().descendant().byText().LENGTH().lessThan(5).getXpath());
    }

    @Test
    void lengthLessThanOrEquals() {
        assertEquals("//div[.//*[string-length(text()) <= 5]]", div.byHaving().descendant().byText().LENGTH().lessThanOrEquals(5).getXpath());
    }

    // ===== __Having_Text_Length_Not_ (LENGTH().NOT()) =====

    @Test
    void lengthNotEquals() {
        assertEquals("//div[.//*[string-length(text()) != 5]]", div.byHaving().descendant().byText().LENGTH().NOT().equals(5).getXpath());
    }

    @Test
    void lengthNotGreaterThanBecomesLessThanOrEquals() {
        assertEquals("//div[.//*[string-length(text()) <= 5]]", div.byHaving().descendant().byText().LENGTH().NOT().greaterThan(5).getXpath());
    }

    @Test
    void lengthNotGreaterThanOrEqualsBecomesLessThan() {
        assertEquals("//div[.//*[string-length(text()) < 5]]", div.byHaving().descendant().byText().LENGTH().NOT().greaterThanOrEquals(5).getXpath());
    }

    @Test
    void lengthNotLessThanBecomesGreaterThanOrEquals() {
        assertEquals("//div[.//*[string-length(text()) >= 5]]", div.byHaving().descendant().byText().LENGTH().NOT().lessThan(5).getXpath());
    }

    @Test
    void lengthNotLessThanOrEqualsBecomesGreaterThan() {
        assertEquals("//div[.//*[string-length(text()) > 5]]", div.byHaving().descendant().byText().LENGTH().NOT().lessThanOrEquals(5).getXpath());
    }

    // ===== __Having_Text_ transformations (TRIM/NORMALIZE_SPACE/CASE/REMOVE/KEEP/TRANSLATE) =====

    @Test
    void trimEquals() {
        assertEquals("//div[.//*[normalize-space(translate(text(), ' ', ' ')) = 'x']]",
                div.byHaving().descendant().byText().TRIM().equals("x").getXpath());
    }

    @Test
    void normalizeSpaceEquals() {
        assertEquals("//div[.//*[normalize-space(text()) = 'x']]",
                div.byHaving().descendant().byText().NORMALIZE_SPACE().equals("x").getXpath());
    }

    @Test
    void caseEquals() {
        assertEquals("//div[.//*[translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz') = 'x']]",
                div.byHaving().descendant().byText().CASE(IGNORED).equals("x").getXpath());
    }

    @Test
    void removeContains() {
        assertEquals("//div[.//*[contains(translate(text(), '0123456789', ''), 'x')]]",
                div.byHaving().descendant().byText().REMOVE(NUMBERS).contains("x").getXpath());
    }

    @Test
    void keepContainsFiltersValueToo() {
        assertEquals("//div[.//*[contains(translate(text(), translate(text(), '0123456789', ''), ''), '')]]",
                div.byHaving().descendant().byText().KEEP(NUMBERS).contains("x").getXpath());
    }

    @Test
    void translateContains() {
        assertEquals("//div[.//*[contains(translate(text(), 'a', 'b'), 'x')]]",
                div.byHaving().descendant().byText().TRANSLATE("a", "b").contains("x").getXpath());
    }

    // ===== __Having_Text_Length_ transformations (TRIM/NORMALIZE_SPACE/CASE/REMOVE/KEEP/TRANSLATE) =====

    @Test
    void lengthTrimEquals() {
        assertEquals("//div[.//*[string-length(normalize-space(translate(text(), ' ', ' '))) = 5]]",
                div.byHaving().descendant().byText().LENGTH().TRIM().equals(5).getXpath());
    }

    @Test
    void lengthNormalizeSpaceEquals() {
        assertEquals("//div[.//*[string-length(normalize-space(text())) = 5]]",
                div.byHaving().descendant().byText().LENGTH().NORMALIZE_SPACE().equals(5).getXpath());
    }

    @Test
    void lengthCaseEquals() {
        assertEquals("//div[.//*[string-length(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz')) = 5]]",
                div.byHaving().descendant().byText().LENGTH().CASE(IGNORED).equals(5).getXpath());
    }

    @Test
    void lengthRemoveEquals() {
        assertEquals("//div[.//*[string-length(translate(text(), '0123456789', '')) = 5]]",
                div.byHaving().descendant().byText().LENGTH().REMOVE(NUMBERS).equals(5).getXpath());
    }

    @Test
    void lengthKeepEquals() {
        assertEquals("//div[.//*[string-length(translate(text(), translate(text(), '0123456789', ''), '')) = 5]]",
                div.byHaving().descendant().byText().LENGTH().KEEP(NUMBERS).equals(5).getXpath());
    }

    @Test
    void lengthTranslateEquals() {
        assertEquals("//div[.//*[string-length(translate(text(), 'a', 'b')) = 5]]",
                div.byHaving().descendant().byText().LENGTH().TRANSLATE("a", "b").equals(5).getXpath());
    }
}
