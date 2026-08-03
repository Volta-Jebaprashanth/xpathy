package uk.xpathy.unitTests;

import static uk.xpathy.Attribute.id;
import static uk.xpathy.Attribute.value;
import static uk.xpathy.Case.IGNORED;
import static uk.xpathy.Only.NUMBERS;
import static uk.xpathy.Tag.div;
import static org.junit.jupiter.api.Assertions.assertEquals;

import uk.xpathy.Or;
import org.junit.jupiter.api.Test;

class OrTest {

    @Test
    void haveIt() {
        assertEquals("//div[@id]", div.byAttribute(id).union(Or.haveIt()).getXpath());
    }

    @Test
    void equalsString() {
        assertEquals("//div[@id='a']", div.byAttribute(id).union(Or.equals("a")).getXpath());
    }

    @Test
    void equalsNumber() {
        assertEquals("//div[@value = 5]", div.byAttribute(value).union(Or.equals(5)).getXpath());
    }

    @Test
    void contains() {
        assertEquals("//div[contains(@id, 'a')]", div.byAttribute(id).union(Or.contains("a")).getXpath());
    }

    @Test
    void startsWith() {
        assertEquals("//div[starts-with(@id, 'a')]", div.byAttribute(id).union(Or.startsWith("a")).getXpath());
    }

    @Test
    void greaterThan() {
        assertEquals("//div[@value > 5]", div.byAttribute(value).union(Or.greaterThan(5)).getXpath());
    }

    @Test
    void greaterThanOrEquals() {
        assertEquals("//div[@value >= 5]", div.byAttribute(value).union(Or.greaterThanOrEquals(5)).getXpath());
    }

    @Test
    void lessThan() {
        assertEquals("//div[@value < 5]", div.byAttribute(value).union(Or.lessThan(5)).getXpath());
    }

    @Test
    void lessThanOrEquals() {
        assertEquals("//div[@value <= 5]", div.byAttribute(value).union(Or.lessThanOrEquals(5)).getXpath());
    }

    @Test
    void between() {
        assertEquals("//div[ ( @value > 5 and @value < 10 ) ]", div.byAttribute(value).union(Or.between(5, 10)).getXpath());
    }

    @Test
    void isEmpty() {
        assertEquals("//div[normalize-space(@id)='']", div.byAttribute(id).union(Or.isEmpty()).getXpath());
    }

    @Test
    void isNumeric() {
        assertEquals("//div[not(number(@value) != number(@value))]", div.byAttribute(value).union(Or.isNumeric()).getXpath());
    }

    // ===== _Or_Manipulation_ (withX -> terminal) =====

    @Test
    void withTrimEquals() {
        assertEquals("//div[normalize-space(translate(@id, '\u00A0', ' '))='a']",
                div.byAttribute(id).union(Or.withTrim().equals("a")).getXpath());
    }

    @Test
    void withNormalizeSpaceContains() {
        assertEquals("//div[contains(normalize-space(@id), 'a')]",
                div.byAttribute(id).union(Or.withNormalizeSpace().contains("a")).getXpath());
    }

    @Test
    void withCaseEquals() {
        assertEquals("//div[translate(@id, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz')='a']",
                div.byAttribute(id).union(Or.withCase(IGNORED).equals("a")).getXpath());
    }

    @Test
    void withRemoveOnlyContains() {
        assertEquals("//div[contains(translate(@id, '0123456789', ''), 'a')]",
                div.byAttribute(id).union(Or.withRemoveOnly(NUMBERS).contains("a")).getXpath());
    }

    @Test
    void withKeepOnlyContainsFiltersValueToo() {
        assertEquals("//div[contains(translate(@id, translate(@id, '0123456789', ''), ''), '')]",
                div.byAttribute(id).union(Or.withKeepOnly(NUMBERS).contains("a")).getXpath());
    }

    @Test
    void withTranslateContains() {
        assertEquals("//div[contains(translate(@id, 'a', 'b'), 'b')]",
                div.byAttribute(id).union(Or.withTranslate("a", "b").contains("a")).getXpath());
    }

    @Test
    void withCaseThenNotEquals() {
        assertEquals("//div[not(translate(@id, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz')='a')]",
                div.byAttribute(id).union(Or.withCase(IGNORED).not().equals("a")).getXpath());
    }

    @Test
    void withTrimHaveIt() {
        assertEquals("//div[normalize-space(translate(@id, '\u00A0', ' '))]",
                div.byAttribute(id).union(Or.withTrim().haveIt()).getXpath());
    }

    @Test
    void manipulationStartsWith() {
        assertEquals("//div[starts-with(normalize-space(translate(@id, '\u00A0', ' ')), 'a')]",
                div.byAttribute(id).union(Or.withTrim().startsWith("a")).getXpath());
    }

    @Test
    void manipulationEqualsNumber() {
        assertEquals("//div[normalize-space(translate(@value, '\u00A0', ' ')) = 5]",
                div.byAttribute(value).union(Or.withTrim().equals(5)).getXpath());
    }

    @Test
    void manipulationGreaterThan() {
        assertEquals("//div[normalize-space(translate(@value, '\u00A0', ' ')) > 5]",
                div.byAttribute(value).union(Or.withTrim().greaterThan(5)).getXpath());
    }

    @Test
    void manipulationGreaterThanOrEquals() {
        assertEquals("//div[normalize-space(translate(@value, '\u00A0', ' ')) >= 5]",
                div.byAttribute(value).union(Or.withTrim().greaterThanOrEquals(5)).getXpath());
    }

    @Test
    void manipulationLessThan() {
        assertEquals("//div[normalize-space(translate(@value, '\u00A0', ' ')) < 5]",
                div.byAttribute(value).union(Or.withTrim().lessThan(5)).getXpath());
    }

    @Test
    void manipulationLessThanOrEquals() {
        assertEquals("//div[normalize-space(translate(@value, '\u00A0', ' ')) <= 5]",
                div.byAttribute(value).union(Or.withTrim().lessThanOrEquals(5)).getXpath());
    }

    @Test
    void manipulationBetween() {
        assertEquals("//div[ ( normalize-space(translate(@value, '\u00A0', ' ')) > 5 and normalize-space(translate(@value, '\u00A0', ' ')) < 10 ) ]",
                div.byAttribute(value).union(Or.withTrim().between(5, 10)).getXpath());
    }

    @Test
    void manipulationIsEmpty() {
        assertEquals("//div[normalize-space(translate(normalize-space(@id), '\u00A0', ' '))='']",
                div.byAttribute(id).union(Or.withTrim().isEmpty()).getXpath());
    }

    @Test
    void manipulationIsNumeric() {
        assertEquals("//div[not(number(normalize-space(translate(@value, '\u00A0', ' '))) != number(normalize-space(translate(@value, '\u00A0', ' '))))]",
                div.byAttribute(value).union(Or.withTrim().isNumeric()).getXpath());
    }

    // ===== _Or_Not_ extra terminals =====

    @Test
    void notEqualsNumber() {
        assertEquals("//div[not(@value = 5)]", div.byAttribute(value).union(Or.not().equals(5)).getXpath());
    }

    @Test
    void notGreaterThanOrEqualsBecomesLessThan() {
        assertEquals("//div[@value < 5]", div.byAttribute(value).union(Or.not().greaterThanOrEquals(5)).getXpath());
    }

    @Test
    void notLessThanBecomesGreaterThanOrEquals() {
        assertEquals("//div[@value >= 5]", div.byAttribute(value).union(Or.not().lessThan(5)).getXpath());
    }

    @Test
    void notLessThanOrEqualsBecomesGreaterThan() {
        assertEquals("//div[@value > 5]", div.byAttribute(value).union(Or.not().lessThanOrEquals(5)).getXpath());
    }
}
