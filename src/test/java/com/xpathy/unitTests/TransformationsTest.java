package com.xpathy.unitTests;

import static com.xpathy.Attribute.class_;
import static com.xpathy.Attribute.id;
import static com.xpathy.Case.IGNORED;
import static com.xpathy.Case.LOWER;
import static com.xpathy.Case.UPPER;
import static com.xpathy.Only.ENGLISH_ALPHABETS;
import static com.xpathy.Only.NUMBERS;
import static com.xpathy.Only.SPECIAL_CHARACTERS;
import static com.xpathy.Tag.button;
import static com.xpathy.Tag.div;
import static com.xpathy.Tag.h1;
import static com.xpathy.Tag.label;
import static com.xpathy.Tag.span;
import static com.xpathy.Tag.td;
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
}
