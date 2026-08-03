package uk.xpathy.unitTests;

import static uk.xpathy.Attribute.class_;
import static uk.xpathy.Attribute.id;
import static uk.xpathy.Case.IGNORED;
import static uk.xpathy.Case.LOWER;
import static uk.xpathy.Case.UPPER;
import static uk.xpathy.Only.ENGLISH_ALPHABETS;
import static uk.xpathy.Only.NUMBERS;
import static uk.xpathy.Only.SPECIAL_CHARACTERS;
import static uk.xpathy.Tag.button;
import static uk.xpathy.Tag.div;
import static uk.xpathy.Tag.h1;
import static uk.xpathy.Tag.label;
import static uk.xpathy.Tag.span;
import static uk.xpathy.Tag.td;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TransformationsTest {

    @Test
    void withCaseIgnoredOnAttribute() {
        assertEquals("//button[contains(translate(@id, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'login-button')]",
                button.byAttribute(id).withCase(IGNORED).contains("login-button").getXpath());
    }

    @Test
    void withCaseUpperOnText() {
        assertEquals("//label[translate(text(), 'abcdefghijklmnopqrstuvwxyz', 'ABCDEFGHIJKLMNOPQRSTUVWXYZ') = 'USERNAME']",
                label.byText().withCase(UPPER).equals("USERNAME").getXpath());
    }

    @Test
    void withCaseLowerOnAttribute() {
        assertEquals("//div[translate(@class, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz')='active']",
                div.byAttribute(class_).withCase(LOWER).equals("active").getXpath());
    }

    @Test
    void withNormalizeSpaceOnText() {
        assertEquals("//div[normalize-space(text()) = 'Invalid password']",
                div.byText().withNormalizeSpace().equals("Invalid password").getXpath());
    }

    @Test
    void withKeepOnlySingleGroup() {
        assertEquals("//span[contains(translate(text(), translate(text(), 'abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ', ''), ''), 'ProductABC')]",
                span.byText().withKeepOnly(ENGLISH_ALPHABETS).contains("ProductABC").getXpath());
    }

    @Test
    void withKeepOnlyMultipleGroups() {
        assertEquals("//td[translate(text(), translate(text(), 'abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789', ''), '') = 'ORD1234']",
                td.byText().withKeepOnly(ENGLISH_ALPHABETS, NUMBERS).equals("ORD1234").getXpath());
    }

    @Test
    void withRemoveOnly() {
        assertEquals("//span[contains(translate(text(), concat('!@#$%^&*()_+-=[]{}|;:,./<>?`~\\' , '\"',\"'\"), ''), '1999')]",
                span.byText().withRemoveOnly(SPECIAL_CHARACTERS).contains("1999").getXpath());
    }

    @Test
    void withTranslate() {
        assertEquals("//h1[contains(translate(text(), 'éàè', 'eae'), 'Cafe')]",
                h1.byText().withTranslate("éàè", "eae").contains("Cafe").getXpath());
    }

    @Test
    void combinedTransformationsAreAppliedInOrder() {
        assertEquals("//div[contains(translate(translate(translate(normalize-space(text()), 'éàè', 'eae'), '0123456789', ''), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'premium cafe')]",
                div.byText()
                        .withNormalizeSpace()
                        .withRemoveOnly(NUMBERS)
                        .withTranslate("éàè", "eae")
                        .withCase(IGNORED)
                        .contains("premium cafe")
                        .getXpath());
    }

    @Test
    void withTrimOnAttribute() {
        assertEquals("//*[normalize-space(translate(@id, '\u00A0', ' '))='x']",
                id.withTrim().equals("x").getXpath());
    }

    @Test
    void withTrimOnText() {
        assertEquals("//div[normalize-space(translate(text(), '\u00A0', ' ')) = 'x']",
                div.byText().withTrim().equals("x").getXpath());
    }

    @Test
    void withTrimOnNumber() {
        assertEquals("//span[number(normalize-space(translate(text(), '\u00A0', ' '))) > 5]",
                span.byNumber().withTrim().greaterThan(5).getXpath());
    }

    @Test
    void repeatedWithRemoveOnlyAccumulatesCharacterSet() {
        assertEquals("//div[contains(translate(text(), concat('0123456789!@#$%^&*()_+-=[]{}|;:,./<>?`~\\' , '\"',\"'\"), ''), 'x')]",
                div.byText().withRemoveOnly(NUMBERS).withRemoveOnly(SPECIAL_CHARACTERS).contains("x").getXpath());
    }

    @Test
    void repeatedWithKeepOnlyAccumulatesCharacterSet() {
        assertEquals("//div[contains(translate(text(), translate(text(), '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ', ''), ''), 'x')]",
                div.byText().withKeepOnly(NUMBERS).withKeepOnly(ENGLISH_ALPHABETS).contains("x").getXpath());
    }
}
