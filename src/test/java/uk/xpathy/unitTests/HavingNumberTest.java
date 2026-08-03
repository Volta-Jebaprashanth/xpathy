package uk.xpathy.unitTests;

import static uk.xpathy.Case.IGNORED;
import static uk.xpathy.Only.NUMBERS;
import static uk.xpathy.Tag.div;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class HavingNumberTest {

    // ===== __Having_Number_ terminal methods =====

    @Test
    void equals() {
        assertEquals("//div[ancestor::*[number(text()) = 5]]", div.byHaving().ancestor().byNumber().equals(5).getXpath());
    }

    @Test
    void greaterThan() {
        assertEquals("//div[ancestor::*[number(text()) > 5]]", div.byHaving().ancestor().byNumber().greaterThan(5).getXpath());
    }

    @Test
    void greaterThanOrEquals() {
        assertEquals("//div[ancestor::*[number(text()) >= 5]]", div.byHaving().ancestor().byNumber().greaterThanOrEquals(5).getXpath());
    }

    @Test
    void lessThan() {
        assertEquals("//div[ancestor::*[number(text()) < 5]]", div.byHaving().ancestor().byNumber().lessThan(5).getXpath());
    }

    @Test
    void lessThanOrEquals() {
        assertEquals("//div[ancestor::*[number(text()) <= 5]]", div.byHaving().ancestor().byNumber().lessThanOrEquals(5).getXpath());
    }

    @Test
    void between() {
        assertEquals("//div[ancestor::*[number(text()) >= 5 and number(text()) <= 10]]", div.byHaving().ancestor().byNumber().between(5, 10).getXpath());
    }

    // ===== __Having_Number_Not_ (NOT()) =====

    @Test
    void notEqualsBecomesNotEquals() {
        assertEquals("//div[ancestor::*[number(text()) != 5]]", div.byHaving().ancestor().byNumber().NOT().equals(5).getXpath());
    }

    @Test
    void notGreaterThanBecomesLessThanOrEquals() {
        assertEquals("//div[ancestor::*[number(text()) <= 5]]", div.byHaving().ancestor().byNumber().NOT().greaterThan(5).getXpath());
    }

    @Test
    void notGreaterThanOrEqualsBecomesLessThan() {
        assertEquals("//div[ancestor::*[number(text()) < 5]]", div.byHaving().ancestor().byNumber().NOT().greaterThanOrEquals(5).getXpath());
    }

    @Test
    void notLessThanBecomesGreaterThanOrEquals() {
        assertEquals("//div[ancestor::*[number(text()) >= 5]]", div.byHaving().ancestor().byNumber().NOT().lessThan(5).getXpath());
    }

    @Test
    void notLessThanOrEqualsBecomesGreaterThan() {
        assertEquals("//div[ancestor::*[number(text()) > 5]]", div.byHaving().ancestor().byNumber().NOT().lessThanOrEquals(5).getXpath());
    }

    @Test
    void notBetweenBecomesOutsideRange() {
        assertEquals("//div[ancestor::*[number(text()) <= 5 or number(text()) >= 10]]", div.byHaving().ancestor().byNumber().NOT().between(5, 10).getXpath());
    }

    // ===== __Having_Number_ transformations (TRIM/NORMALIZE_SPACE/CASE/REMOVE/KEEP/TRANSLATE) =====

    @Test
    void trimGreaterThan() {
        assertEquals("//div[ancestor::*[number(normalize-space(translate(text(), ' ', ' '))) > 5]]",
                div.byHaving().ancestor().byNumber().TRIM().greaterThan(5).getXpath());
    }

    @Test
    void normalizeSpaceGreaterThan() {
        assertEquals("//div[ancestor::*[number(normalize-space(text())) > 5]]",
                div.byHaving().ancestor().byNumber().NORMALIZE_SPACE().greaterThan(5).getXpath());
    }

    @Test
    void caseGreaterThan() {
        assertEquals("//div[ancestor::*[number(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz')) > 5]]",
                div.byHaving().ancestor().byNumber().CASE(IGNORED).greaterThan(5).getXpath());
    }

    @Test
    void removeGreaterThan() {
        assertEquals("//div[ancestor::*[number(translate(text(), '0123456789', '')) > 5]]",
                div.byHaving().ancestor().byNumber().REMOVE(NUMBERS).greaterThan(5).getXpath());
    }

    @Test
    void keepGreaterThan() {
        assertEquals("//div[ancestor::*[number(translate(text(), translate(text(), '0123456789', ''), '')) > 5]]",
                div.byHaving().ancestor().byNumber().KEEP(NUMBERS).greaterThan(5).getXpath());
    }

    @Test
    void translateGreaterThan() {
        assertEquals("//div[ancestor::*[number(translate(text(), 'a', 'b')) > 5]]",
                div.byHaving().ancestor().byNumber().TRANSLATE("a", "b").greaterThan(5).getXpath());
    }
}
