package uk.xpathy.unitTests;

import static uk.xpathy.Attribute.class_;
import static uk.xpathy.Attribute.id;
import static uk.xpathy.Attribute.value;
import static uk.xpathy.Tag.div;
import static org.junit.jupiter.api.Assertions.assertEquals;

import uk.xpathy.And;
import uk.xpathy.Or;
import org.junit.jupiter.api.Test;

class UnionIntersectNotTest {

    @Test
    void intersectNotHaveIt() {
        assertEquals("//div[not(@id)]", div.byAttribute(id).intersect(And.not().haveIt()).getXpath());
    }

    @Test
    void intersectNotContains() {
        assertEquals("//div[not(contains(@id, 'x'))]", div.byAttribute(id).intersect(And.not().contains("x")).getXpath());
    }

    @Test
    void intersectNotStartsWith() {
        assertEquals("//div[not(starts-with(@id, 'x'))]", div.byAttribute(id).intersect(And.not().startsWith("x")).getXpath());
    }

    @Test
    void intersectNotGreaterThanBecomesLessThanOrEquals() {
        assertEquals("//div[@value <= 5]", div.byAttribute(value).intersect(And.not().greaterThan(5)).getXpath());
    }

    @Test
    void intersectNotBetween() {
        assertEquals("//div[ not ( @value > 5 and @value < 10 ) ]",
                div.byAttribute(value).intersect(And.not().between(5, 10)).getXpath());
    }

    @Test
    void intersectNotIsEmpty() {
        assertEquals("//div[not(normalize-space(@id)='')]", div.byAttribute(id).intersect(And.not().isEmpty()).getXpath());
    }

    @Test
    void intersectNotIsNumeric() {
        assertEquals("//div[not(not(number(@value) != number(@value)))]",
                div.byAttribute(value).intersect(And.not().isNumeric()).getXpath());
    }

    @Test
    void intersectMixOfPlainAndNotConditions() {
        assertEquals("//div[(contains(@class, 'active') and not(contains(@class, 'disabled')))]",
                div.byAttribute(class_).intersect(
                        And.contains("active"),
                        And.not().contains("disabled")
                ).getXpath());
    }

    @Test
    void unionNotHaveIt() {
        assertEquals("//div[not(@id)]", div.byAttribute(id).union(Or.not().haveIt()).getXpath());
    }

    @Test
    void unionNotContains() {
        assertEquals("//div[not(contains(@id, 'x'))]", div.byAttribute(id).union(Or.not().contains("x")).getXpath());
    }

    @Test
    void unionNotStartsWith() {
        assertEquals("//div[not(starts-with(@id, 'x'))]", div.byAttribute(id).union(Or.not().startsWith("x")).getXpath());
    }

    @Test
    void unionNotGreaterThanBecomesLessThanOrEquals() {
        assertEquals("//div[@value <= 5]", div.byAttribute(value).union(Or.not().greaterThan(5)).getXpath());
    }

    @Test
    void unionNotBetween() {
        assertEquals("//div[ not ( @value > 5 and @value < 10 ) ]",
                div.byAttribute(value).union(Or.not().between(5, 10)).getXpath());
    }

    @Test
    void unionNotIsEmpty() {
        assertEquals("//div[not(normalize-space(@id)='')]", div.byAttribute(id).union(Or.not().isEmpty()).getXpath());
    }

    @Test
    void unionNotIsNumeric() {
        assertEquals("//div[not(not(number(@value) != number(@value)))]",
                div.byAttribute(value).union(Or.not().isNumeric()).getXpath());
    }

    @Test
    void unionMixOfPlainAndNotConditions() {
        assertEquals("//div[(@class='active' or not(@class='disabled'))]",
                div.byAttribute(class_).union(
                        Or.equals("active"),
                        Or.not().equals("disabled")
                ).getXpath());
    }

    @Test
    void textIntersectNotContains() {
        assertEquals("//div[not(contains(text(), 'x'))]", div.byText().intersect(And.not().contains("x")).getXpath());
    }

    @Test
    void textUnionNotStartsWith() {
        assertEquals("//div[not(starts-with(text(), 'x'))]", div.byText().union(Or.not().startsWith("x")).getXpath());
    }
}
