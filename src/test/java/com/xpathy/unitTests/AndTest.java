package com.xpathy.unitTests;

import static com.xpathy.Attribute.id;
import static com.xpathy.Attribute.value;
import static com.xpathy.Case.IGNORED;
import static com.xpathy.Only.NUMBERS;
import static com.xpathy.Tag.div;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.xpathy.And;
import org.junit.jupiter.api.Test;

class AndTest {

    @Test
    void haveIt() {
        assertEquals("//div[@id]", div.byAttribute(id).intersect(And.haveIt()).getXpath());
    }

    @Test
    void equalsString() {
        assertEquals("//div[@id='a']", div.byAttribute(id).intersect(And.equals("a")).getXpath());
    }

    @Test
    void equalsNumber() {
        assertEquals("//div[@value = 5]", div.byAttribute(value).intersect(And.equals(5)).getXpath());
    }

    @Test
    void contains() {
        assertEquals("//div[contains(@id, 'a')]", div.byAttribute(id).intersect(And.contains("a")).getXpath());
    }

    @Test
    void startsWith() {
        assertEquals("//div[starts-with(@id, 'a')]", div.byAttribute(id).intersect(And.startsWith("a")).getXpath());
    }

    @Test
    void greaterThan() {
        assertEquals("//div[@value > 5]", div.byAttribute(value).intersect(And.greaterThan(5)).getXpath());
    }

    @Test
    void greaterThanOrEquals() {
        assertEquals("//div[@value >= 5]", div.byAttribute(value).intersect(And.greaterThanOrEquals(5)).getXpath());
    }

    @Test
    void lessThan() {
        assertEquals("//div[@value < 5]", div.byAttribute(value).intersect(And.lessThan(5)).getXpath());
    }

    @Test
    void lessThanOrEquals() {
        assertEquals("//div[@value <= 5]", div.byAttribute(value).intersect(And.lessThanOrEquals(5)).getXpath());
    }

    @Test
    void between() {
        assertEquals("//div[ ( @value > 5 and @value < 10 ) ]", div.byAttribute(value).intersect(And.between(5, 10)).getXpath());
    }

    @Test
    void isEmpty() {
        assertEquals("//div[normalize-space(@id)='']", div.byAttribute(id).intersect(And.isEmpty()).getXpath());
    }

    @Test
    void isNumeric() {
        assertEquals("//div[not(number(@value) != number(@value))]", div.byAttribute(value).intersect(And.isNumeric()).getXpath());
    }

    // ===== _And_Manipulation_ (withX -> terminal) =====

    @Test
    void withTrimEquals() {
        assertEquals("//div[normalize-space(translate(@id, '\u00A0', ' '))='a']",
                div.byAttribute(id).intersect(And.withTrim().equals("a")).getXpath());
    }

    @Test
    void withNormalizeSpaceContains() {
        assertEquals("//div[contains(normalize-space(@id), 'a')]",
                div.byAttribute(id).intersect(And.withNormalizeSpace().contains("a")).getXpath());
    }

    @Test
    void withCaseEquals() {
        assertEquals("//div[translate(@id, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz')='a']",
                div.byAttribute(id).intersect(And.withCase(IGNORED).equals("a")).getXpath());
    }

    @Test
    void withRemoveOnlyContains() {
        assertEquals("//div[contains(translate(@id, '0123456789', ''), 'a')]",
                div.byAttribute(id).intersect(And.withRemoveOnly(NUMBERS).contains("a")).getXpath());
    }

    @Test
    void withKeepOnlyContainsFiltersValueToo() {
        assertEquals("//div[contains(translate(@id, translate(@id, '0123456789', ''), ''), '')]",
                div.byAttribute(id).intersect(And.withKeepOnly(NUMBERS).contains("a")).getXpath());
    }

    @Test
    void withTranslateContains() {
        assertEquals("//div[contains(translate(@id, 'a', 'b'), 'b')]",
                div.byAttribute(id).intersect(And.withTranslate("a", "b").contains("a")).getXpath());
    }

    @Test
    void withCaseThenNotEquals() {
        assertEquals("//div[not(translate(@id, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz')='a')]",
                div.byAttribute(id).intersect(And.withCase(IGNORED).not().equals("a")).getXpath());
    }

    @Test
    void withTrimHaveIt() {
        assertEquals("//div[normalize-space(translate(@id, '\u00A0', ' '))]",
                div.byAttribute(id).intersect(And.withTrim().haveIt()).getXpath());
    }

    @Test
    void manipulationStartsWith() {
        assertEquals("//div[starts-with(normalize-space(translate(@id, '\u00A0', ' ')), 'a')]",
                div.byAttribute(id).intersect(And.withTrim().startsWith("a")).getXpath());
    }

    @Test
    void manipulationEqualsNumber() {
        assertEquals("//div[normalize-space(translate(@value, '\u00A0', ' ')) = 5]",
                div.byAttribute(value).intersect(And.withTrim().equals(5)).getXpath());
    }

    @Test
    void manipulationGreaterThan() {
        assertEquals("//div[normalize-space(translate(@value, '\u00A0', ' ')) > 5]",
                div.byAttribute(value).intersect(And.withTrim().greaterThan(5)).getXpath());
    }

    @Test
    void manipulationGreaterThanOrEquals() {
        assertEquals("//div[normalize-space(translate(@value, '\u00A0', ' ')) >= 5]",
                div.byAttribute(value).intersect(And.withTrim().greaterThanOrEquals(5)).getXpath());
    }

    @Test
    void manipulationLessThan() {
        assertEquals("//div[normalize-space(translate(@value, '\u00A0', ' ')) < 5]",
                div.byAttribute(value).intersect(And.withTrim().lessThan(5)).getXpath());
    }

    @Test
    void manipulationLessThanOrEquals() {
        assertEquals("//div[normalize-space(translate(@value, '\u00A0', ' ')) <= 5]",
                div.byAttribute(value).intersect(And.withTrim().lessThanOrEquals(5)).getXpath());
    }

    @Test
    void manipulationBetween() {
        assertEquals("//div[ ( normalize-space(translate(@value, '\u00A0', ' ')) > 5 and normalize-space(translate(@value, '\u00A0', ' ')) < 10 ) ]",
                div.byAttribute(value).intersect(And.withTrim().between(5, 10)).getXpath());
    }

    @Test
    void manipulationIsEmpty() {
        assertEquals("//div[normalize-space(translate(normalize-space(@id), '\u00A0', ' '))='']",
                div.byAttribute(id).intersect(And.withTrim().isEmpty()).getXpath());
    }

    @Test
    void manipulationIsNumeric() {
        assertEquals("//div[not(number(normalize-space(translate(@value, '\u00A0', ' '))) != number(normalize-space(translate(@value, '\u00A0', ' '))))]",
                div.byAttribute(value).intersect(And.withTrim().isNumeric()).getXpath());
    }

    // ===== _And_Not_ extra terminals =====

    @Test
    void notEqualsNumber() {
        assertEquals("//div[not(@value = 5)]", div.byAttribute(value).intersect(And.not().equals(5)).getXpath());
    }

    @Test
    void notGreaterThanOrEqualsBecomesLessThan() {
        assertEquals("//div[@value < 5]", div.byAttribute(value).intersect(And.not().greaterThanOrEquals(5)).getXpath());
    }

    @Test
    void notLessThanBecomesGreaterThanOrEquals() {
        assertEquals("//div[@value >= 5]", div.byAttribute(value).intersect(And.not().lessThan(5)).getXpath());
    }

    @Test
    void notLessThanOrEqualsBecomesGreaterThan() {
        assertEquals("//div[@value > 5]", div.byAttribute(value).intersect(And.not().lessThanOrEquals(5)).getXpath());
    }
}
