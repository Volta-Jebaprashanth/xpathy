package com.xpathy.unitTests;

import static com.xpathy.Case.IGNORED;
import static com.xpathy.Only.NUMBERS;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.xpathy.And;
import com.xpathy.Or;
import com.xpathy.Text;
import org.junit.jupiter.api.Test;

class TextStaticTest {

    @Test
    void equalsString() {
        assertEquals("//*[text() = 'Exact']", Text.equals("Exact").getXpath());
    }

    @Test
    void isEmpty() {
        assertEquals("//*[normalize-space(text())='']", Text.isEmpty().getXpath());
    }

    @Test
    void isNumeric() {
        assertEquals("//*[not(number(text()) != number(text()))]", Text.isNumeric().getXpath());
    }

    @Test
    void equalsNumber() {
        assertEquals("//*[text() = 5]", Text.equals(5).getXpath());
    }

    @Test
    void greaterThan() {
        assertEquals("//*[text() > 5]", Text.greaterThan(5).getXpath());
    }

    @Test
    void greaterThanOrEquals() {
        assertEquals("//*[text() >= 5]", Text.greaterThanOrEquals(5).getXpath());
    }

    @Test
    void lessThan() {
        assertEquals("//*[text() < 5]", Text.lessThan(5).getXpath());
    }

    @Test
    void lessThanOrEquals() {
        assertEquals("//*[text() <= 5]", Text.lessThanOrEquals(5).getXpath());
    }

    @Test
    void byLengthEquals() {
        assertEquals("//*[string-length(text()) = 5]", Text.byLength().equals(5).getXpath());
    }

    @Test
    void notEquals() {
        assertEquals("//*[not(text()='x')]", Text.not().equals("x").getXpath());
    }

    @Test
    void withTrimEquals() {
        assertEquals("//*[normalize-space(translate(text(), '\u00A0', ' ')) = 'x']", Text.withTrim().equals("x").getXpath());
    }

    @Test
    void withNormalizeSpaceEquals() {
        assertEquals("//*[normalize-space(text()) = 'x']", Text.withNormalizeSpace().equals("x").getXpath());
    }

    @Test
    void withCaseEquals() {
        assertEquals("//*[translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz') = 'x']",
                Text.withCase(IGNORED).equals("x").getXpath());
    }

    @Test
    void withRemoveOnlyContains() {
        assertEquals("//*[contains(translate(text(), '0123456789', ''), 'x')]", Text.withRemoveOnly(NUMBERS).contains("x").getXpath());
    }

    @Test
    void withKeepOnlyContainsFiltersValueToo() {
        assertEquals("//*[contains(translate(text(), translate(text(), '0123456789', ''), ''), '')]",
                Text.withKeepOnly(NUMBERS).contains("x").getXpath());
    }

    @Test
    void withTranslateContains() {
        assertEquals("//*[contains(translate(text(), 'a', 'b'), 'x')]", Text.withTranslate("a", "b").contains("x").getXpath());
    }

    @Test
    void union() {
        assertEquals("//*[(text() = 'a' or contains(text(), 'b'))]", Text.union(Or.equals("a"), Or.contains("b")).getXpath());
    }

    @Test
    void intersect() {
        assertEquals("//*[(text() = 'a' and contains(text(), 'b'))]", Text.intersect(And.equals("a"), And.contains("b")).getXpath());
    }
}
