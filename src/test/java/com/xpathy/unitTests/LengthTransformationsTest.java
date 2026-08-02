package com.xpathy.unitTests;

import static com.xpathy.Attribute.id;
import static com.xpathy.Case.IGNORED;
import static com.xpathy.Only.NUMBERS;
import static com.xpathy.Tag.div;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class LengthTransformationsTest {

    // ===== _Text_Length_ =====

    @Test
    void textLengthWithTrimEquals() {
        assertEquals("//div[string-length(normalize-space(translate(text(), ' ', ' '))) = 5]",
                div.byText().byLength().withTrim().equals(5).getXpath());
    }

    @Test
    void textLengthWithNormalizeSpaceEquals() {
        assertEquals("//div[string-length(normalize-space(text())) = 5]",
                div.byText().byLength().withNormalizeSpace().equals(5).getXpath());
    }

    @Test
    void textLengthWithCaseEquals() {
        assertEquals("//div[string-length(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz')) = 5]",
                div.byText().byLength().withCase(IGNORED).equals(5).getXpath());
    }

    @Test
    void textLengthWithRemoveOnlyEquals() {
        assertEquals("//div[string-length(translate(text(), '0123456789', '')) = 5]",
                div.byText().byLength().withRemoveOnly(NUMBERS).equals(5).getXpath());
    }

    @Test
    void textLengthWithKeepOnlyEquals() {
        assertEquals("//div[string-length(translate(text(), translate(text(), '0123456789', ''), '')) = 5]",
                div.byText().byLength().withKeepOnly(NUMBERS).equals(5).getXpath());
    }

    @Test
    void textLengthWithTranslateEquals() {
        assertEquals("//div[string-length(translate(text(), 'a', 'b')) = 5]",
                div.byText().byLength().withTranslate("a", "b").equals(5).getXpath());
    }

    @Test
    void textLengthGreaterThan() {
        assertEquals("//div[string-length(text()) > 3]", div.byText().byLength().greaterThan(3).getXpath());
    }

    @Test
    void textLengthGreaterThanOrEquals() {
        assertEquals("//div[string-length(text()) >= 3]", div.byText().byLength().greaterThanOrEquals(3).getXpath());
    }

    @Test
    void textLengthLessThan() {
        assertEquals("//div[string-length(text()) < 20]", div.byText().byLength().lessThan(20).getXpath());
    }

    @Test
    void textLengthLessThanOrEquals() {
        assertEquals("//div[string-length(text()) <= 20]", div.byText().byLength().lessThanOrEquals(20).getXpath());
    }

    // ===== _Attribute_Length_ =====

    @Test
    void attributeLengthWithTrimEquals() {
        assertEquals("//*[@id and string-length(normalize-space(translate(@id, ' ', ' '))) = 5]",
                id.byLength().withTrim().equals(5).getXpath());
    }

    @Test
    void attributeLengthWithNormalizeSpaceEquals() {
        assertEquals("//*[@id and string-length(normalize-space(@id)) = 5]",
                id.byLength().withNormalizeSpace().equals(5).getXpath());
    }

    @Test
    void attributeLengthWithCaseEquals() {
        assertEquals("//*[@id and string-length(translate(@id, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz')) = 5]",
                id.byLength().withCase(IGNORED).equals(5).getXpath());
    }

    @Test
    void attributeLengthWithRemoveOnlyEquals() {
        assertEquals("//*[@id and string-length(translate(@id, '0123456789', '')) = 5]",
                id.byLength().withRemoveOnly(NUMBERS).equals(5).getXpath());
    }

    @Test
    void attributeLengthWithKeepOnlyEquals() {
        assertEquals("//*[@id and string-length(translate(@id, translate(@id, '0123456789', ''), '')) = 5]",
                id.byLength().withKeepOnly(NUMBERS).equals(5).getXpath());
    }

    @Test
    void attributeLengthWithTranslateEquals() {
        assertEquals("//*[@id and string-length(translate(@id, 'a', 'b')) = 5]",
                id.byLength().withTranslate("a", "b").equals(5).getXpath());
    }

    @Test
    void attributeLengthLessThan() {
        assertEquals("//*[@id and string-length(@id) < 10]", id.byLength().lessThan(10).getXpath());
    }

    @Test
    void attributeLengthLessThanOrEquals() {
        assertEquals("//*[@id and string-length(@id) <= 10]", id.byLength().lessThanOrEquals(10).getXpath());
    }

    @Test
    void attributeLengthGreaterThan() {
        assertEquals("//*[@id and string-length(@id) > 2]", id.byLength().greaterThan(2).getXpath());
    }

    @Test
    void attributeLengthGreaterThanOrEquals() {
        assertEquals("//*[@id and string-length(@id) >= 2]", id.byLength().greaterThanOrEquals(2).getXpath());
    }
}
