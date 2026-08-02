package com.xpathy.unitTests;

import static com.xpathy.Attribute.class_;
import static com.xpathy.Attribute.id;
import static com.xpathy.Case.IGNORED;
import static com.xpathy.Case.LOWER;
import static com.xpathy.Only.SPECIAL_CHARACTERS;
import static com.xpathy.Tag.button;
import static com.xpathy.Tag.div;
import static com.xpathy.Tag.li;
import static com.xpathy.Tag.span;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.xpathy.And;
import com.xpathy.Or;
import org.junit.jupiter.api.Test;

class UnionIntersectTest {

    @Test
    void unionOfMultipleOrConditions() {
        assertEquals("//button[(@id='login-btn' or @id='signin-btn' or contains(@id, 'auth'))]",
                button.byAttribute(id).union(
                        Or.equals("login-btn"),
                        Or.equals("signin-btn"),
                        Or.contains("auth")
                ).getXpath());
    }

    @Test
    void intersectOfMultipleAndConditions() {
        assertEquals("//div[(starts-with(text(), 'Order #') and contains(text(), 'Confirmed') and not(contains(text(), 'Cancelled')))]",
                div.byText().intersect(
                        And.startsWith("Order #"),
                        And.contains("Confirmed"),
                        And.not().contains("Cancelled")
                ).getXpath());
    }

    @Test
    void unionWithTransformations() {
        assertEquals("//li[(contains(translate(@class, concat('!@#$%^&*()_+-=[]{}|;:,./<>?`~\\' , '\"',\"'\"), ''), 'active') or translate(@class, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz')='selected')]",
                li.byAttribute(class_).union(
                        Or.withRemoveOnly(SPECIAL_CHARACTERS).contains("active"),
                        Or.withCase(IGNORED).equals("selected")
                ).getXpath());
    }

    @Test
    void intersectWithTransformations() {
        assertEquals("//span[(contains(normalize-space(text()), 'Premium') and contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'subscription'))]",
                span.byText().intersect(
                        And.withNormalizeSpace().contains("Premium"),
                        And.withCase(LOWER).contains("subscription")
                ).getXpath());
    }
}
