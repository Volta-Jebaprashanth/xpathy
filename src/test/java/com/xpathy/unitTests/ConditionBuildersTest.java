package com.xpathy.unitTests;

import static com.xpathy.Attribute.class_;
import static com.xpathy.Attribute.id;
import static com.xpathy.Attribute.value;
import static com.xpathy.Case.IGNORED;
import static com.xpathy.Condition.attribute;
import static com.xpathy.Condition.number;
import static com.xpathy.Condition.style;
import static com.xpathy.Condition.text;
import static com.xpathy.Only.NUMBERS;
import static com.xpathy.Style.backgroundColor;
import static com.xpathy.Tag.div;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ConditionBuildersTest {

    // ===== Condition.attribute() =====

    @Test
    void attributeHaveIt() {
        assertEquals("//div[@id]", div.byCondition(attribute(id).haveIt()).getXpath());
    }

    @Test
    void attributeEquals() {
        assertEquals("//div[@id='a']", div.byCondition(attribute(id).equals("a")).getXpath());
    }

    @Test
    void attributeContains() {
        assertEquals("//div[contains(@id, 'a')]", div.byCondition(attribute(id).contains("a")).getXpath());
    }

    @Test
    void attributeStartsWith() {
        assertEquals("//div[starts-with(@id, 'a')]", div.byCondition(attribute(id).startsWith("a")).getXpath());
    }

    @Test
    void attributeIsEmpty() {
        assertEquals("//div[normalize-space(@id)='']", div.byCondition(attribute(id).isEmpty()).getXpath());
    }

    @Test
    void attributeIsNumeric() {
        assertEquals("//div[not(number(@value) != number(@value))]", div.byCondition(attribute(value).isNumeric()).getXpath());
    }

    @Test
    void attributeEqualsNumber() {
        assertEquals("//div[@value = 5]", div.byCondition(attribute(value).equals(5)).getXpath());
    }

    @Test
    void attributeGreaterThan() {
        assertEquals("//div[@value > 5]", div.byCondition(attribute(value).greaterThan(5)).getXpath());
    }

    @Test
    void attributeGreaterThanOrEquals() {
        assertEquals("//div[@value >= 5]", div.byCondition(attribute(value).greaterThanOrEquals(5)).getXpath());
    }

    @Test
    void attributeLessThan() {
        assertEquals("//div[@value < 5]", div.byCondition(attribute(value).lessThan(5)).getXpath());
    }

    @Test
    void attributeLessThanOrEquals() {
        assertEquals("//div[@value <= 5]", div.byCondition(attribute(value).lessThanOrEquals(5)).getXpath());
    }

    @Test
    void attributeBetween() {
        assertEquals("//div[ ( @value > 5 and @value < 10 ) ]", div.byCondition(attribute(value).between(5, 10)).getXpath());
    }

    @Test
    void attributeWithCaseEquals() {
        assertEquals("//div[translate(@class, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz')='a']",
                div.byCondition(attribute(class_).withCase(IGNORED).equals("a")).getXpath());
    }

    @Test
    void attributeWithTrimEquals() {
        assertEquals("//div[normalize-space(translate(@class, '\u00A0', ' '))='a']",
                div.byCondition(attribute(class_).withTrim().equals("a")).getXpath());
    }

    @Test
    void attributeWithNormalizeSpaceEquals() {
        assertEquals("//div[normalize-space(@class)='a']",
                div.byCondition(attribute(class_).withNormalizeSpace().equals("a")).getXpath());
    }

    @Test
    void attributeWithRemoveOnlyEquals() {
        assertEquals("//div[translate(@class, '0123456789', '')='a']",
                div.byCondition(attribute(class_).withRemoveOnly(NUMBERS).equals("a")).getXpath());
    }

    @Test
    void attributeWithKeepOnlyEqualsFiltersValueToo() {
        assertEquals("//div[translate(@class, translate(@class, '0123456789', ''), '')='']",
                div.byCondition(attribute(class_).withKeepOnly(NUMBERS).equals("a")).getXpath());
    }

    @Test
    void attributeWithTranslateEquals() {
        assertEquals("//div[translate(@class, 'a', 'b')='b']",
                div.byCondition(attribute(class_).withTranslate("a", "b").equals("a")).getXpath());
    }

    // ===== Condition.text() =====

    @Test
    void textEquals() {
        assertEquals("//div[text() = 'a']", div.byCondition(text().equals("a")).getXpath());
    }

    @Test
    void textContains() {
        assertEquals("//div[contains(text(), 'a')]", div.byCondition(text().contains("a")).getXpath());
    }

    @Test
    void textStartsWith() {
        assertEquals("//div[starts-with(text(), 'a')]", div.byCondition(text().startsWith("a")).getXpath());
    }

    @Test
    void textIsEmpty() {
        assertEquals("//div[normalize-space(text())='']", div.byCondition(text().isEmpty()).getXpath());
    }

    @Test
    void textIsNumeric() {
        assertEquals("//div[not(number(text()) != number(text()))]", div.byCondition(text().isNumeric()).getXpath());
    }

    @Test
    void textEqualsNumber() {
        assertEquals("//div[text() = 5]", div.byCondition(text().equals(5)).getXpath());
    }

    @Test
    void textGreaterThan() {
        assertEquals("//div[text() > 5]", div.byCondition(text().greaterThan(5)).getXpath());
    }

    @Test
    void textGreaterThanOrEquals() {
        assertEquals("//div[text() >= 5]", div.byCondition(text().greaterThanOrEquals(5)).getXpath());
    }

    @Test
    void textLessThan() {
        assertEquals("//div[text() < 5]", div.byCondition(text().lessThan(5)).getXpath());
    }

    @Test
    void textLessThanOrEquals() {
        assertEquals("//div[text() <= 5]", div.byCondition(text().lessThanOrEquals(5)).getXpath());
    }

    @Test
    void textWithCaseEquals() {
        assertEquals("//div[translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz') = 'a']",
                div.byCondition(text().withCase(IGNORED).equals("a")).getXpath());
    }

    @Test
    void textWithTrimEquals() {
        assertEquals("//div[normalize-space(translate(text(), '\u00A0', ' ')) = 'a']",
                div.byCondition(text().withTrim().equals("a")).getXpath());
    }

    @Test
    void textWithNormalizeSpaceEquals() {
        assertEquals("//div[normalize-space(text()) = 'a']",
                div.byCondition(text().withNormalizeSpace().equals("a")).getXpath());
    }

    @Test
    void textWithRemoveOnlyEquals() {
        assertEquals("//div[translate(text(), '0123456789', '') = 'a']",
                div.byCondition(text().withRemoveOnly(NUMBERS).equals("a")).getXpath());
    }

    @Test
    void textWithKeepOnlyEqualsFiltersValueToo() {
        assertEquals("//div[translate(text(), translate(text(), '0123456789', ''), '') = '']",
                div.byCondition(text().withKeepOnly(NUMBERS).equals("a")).getXpath());
    }

    @Test
    void textWithTranslateEquals() {
        assertEquals("//div[translate(text(), 'a', 'b') = 'b']",
                div.byCondition(text().withTranslate("a", "b").equals("a")).getXpath());
    }

    // ===== Condition.number() =====

    @Test
    void numberEquals() {
        assertEquals("//div[number(text()) = 5]", div.byCondition(number().equals(5)).getXpath());
    }

    @Test
    void numberGreaterThan() {
        assertEquals("//div[number(text()) > 5]", div.byCondition(number().greaterThan(5)).getXpath());
    }

    @Test
    void numberGreaterThanOrEquals() {
        assertEquals("//div[number(text()) >= 5]", div.byCondition(number().greaterThanOrEquals(5)).getXpath());
    }

    @Test
    void numberLessThan() {
        assertEquals("//div[number(text()) < 5]", div.byCondition(number().lessThan(5)).getXpath());
    }

    @Test
    void numberLessThanOrEquals() {
        assertEquals("//div[number(text()) <= 5]", div.byCondition(number().lessThanOrEquals(5)).getXpath());
    }

    @Test
    void numberBetween() {
        assertEquals("//div[ ( number(text()) >= 5 and number(text()) <= 10 ) ]", div.byCondition(number().between(5, 10)).getXpath());
    }

    @Test
    void numberWithCaseGreaterThan() {
        assertEquals("//div[number(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz')) > 5]",
                div.byCondition(number().withCase(IGNORED).greaterThan(5)).getXpath());
    }

    @Test
    void numberWithTrimGreaterThan() {
        assertEquals("//div[number(normalize-space(translate(text(), '\u00A0', ' '))) > 5]",
                div.byCondition(number().withTrim().greaterThan(5)).getXpath());
    }

    @Test
    void numberWithNormalizeSpaceGreaterThan() {
        assertEquals("//div[number(normalize-space(text())) > 5]",
                div.byCondition(number().withNormalizeSpace().greaterThan(5)).getXpath());
    }

    @Test
    void numberWithRemoveOnlyGreaterThan() {
        assertEquals("//div[number(translate(text(), '0123456789', '')) > 5]",
                div.byCondition(number().withRemoveOnly(NUMBERS).greaterThan(5)).getXpath());
    }

    @Test
    void numberWithKeepOnlyGreaterThan() {
        assertEquals("//div[number(translate(text(), translate(text(), '0123456789', ''), '')) > 5]",
                div.byCondition(number().withKeepOnly(NUMBERS).greaterThan(5)).getXpath());
    }

    @Test
    void numberWithTranslateGreaterThan() {
        assertEquals("//div[number(translate(text(), 'a', 'b')) > 5]",
                div.byCondition(number().withTranslate("a", "b").greaterThan(5)).getXpath());
    }

    // ===== Condition.style() =====

    @Test
    void styleHaveIt() {
        assertEquals("//div[contains(translate(@style, ' ', ''), 'background-color:')]",
                div.byCondition(style(backgroundColor).haveIt()).getXpath());
    }

    @Test
    void styleEquals() {
        assertEquals("//div[contains(translate(@style, ' ', ''), 'background-color:red;')]",
                div.byCondition(style(backgroundColor).equals("red")).getXpath());
    }
}
