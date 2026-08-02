package com.xpathy.unitTests;

import static com.xpathy.Attribute.class_;
import static com.xpathy.Attribute.data_testid;
import static com.xpathy.Attribute.id;
import static com.xpathy.Case.IGNORED;
import static com.xpathy.Condition.and;
import static com.xpathy.Condition.attribute;
import static com.xpathy.Condition.not;
import static com.xpathy.Condition.number;
import static com.xpathy.Condition.or;
import static com.xpathy.Condition.style;
import static com.xpathy.Condition.text;
import static com.xpathy.Style.backgroundColor;
import static com.xpathy.Tag.div;
import static com.xpathy.Tag.span;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class NestedConditionTest {

    @Test
    void nestedLoginValidation() {
        assertEquals(
                "//div[( starts-with(text(), 'Login') and ( contains(text(), 'Button') or contains(@id, 'auth-btn') ) and not (contains(translate(@class, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'disabled')) )]",
                div.byCondition(
                        and(
                                text().startsWith("Login"),
                                or(
                                        text().contains("Button"),
                                        attribute(id).contains("auth-btn")
                                ),
                                not(attribute(class_).withCase(IGNORED).contains("disabled"))
                        )
                ).getXpath());
    }

    @Test
    void nestedProductLabel() {
        assertEquals(
                "//span[( contains(text(), 'Premium') or ( @class='highlight' and contains(@data-testid, 'featured') and not (contains(text(), 'Expired')) ) )]",
                span.byCondition(
                        or(
                                text().contains("Premium"),
                                and(
                                        attribute(class_).equals("highlight"),
                                        attribute(data_testid).contains("featured"),
                                        not(text().contains("Expired"))
                                )
                        )
                ).getXpath());
    }

    @Test
    void notWrappingAnd() {
        assertEquals("//div[not (( @id='a' and contains(text(), 'b') ))]",
                div.byCondition(
                        not(
                                and(
                                        attribute(id).equals("a"),
                                        text().contains("b")
                                )
                        )
                ).getXpath());
    }

    @Test
    void notWrappingOr() {
        assertEquals("//div[not (( @id='a' or contains(text(), 'b') ))]",
                div.byCondition(
                        not(
                                or(
                                        attribute(id).equals("a"),
                                        text().contains("b")
                                )
                        )
                ).getXpath());
    }

    @Test
    void andOfTwoNots() {
        assertEquals("//div[( not (@id='a') and not (contains(text(), 'b')) )]",
                div.byCondition(
                        and(
                                not(attribute(id).equals("a")),
                                not(text().contains("b"))
                        )
                ).getXpath());
    }

    @Test
    void orOfTwoNots() {
        assertEquals("//div[( not (@id='a') or not (contains(text(), 'b')) )]",
                div.byCondition(
                        or(
                                not(attribute(id).equals("a")),
                                not(text().contains("b"))
                        )
                ).getXpath());
    }

    @Test
    void doubleNot() {
        assertEquals("//div[not (not (@id='a'))]",
                div.byCondition(
                        not(not(attribute(id).equals("a")))
                ).getXpath());
    }

    @Test
    void andOfOrOfNotsAndNot() {
        assertEquals("//div[( ( not (@id='a') or contains(text(), 'b') ) and not (number(text()) > 5) )]",
                div.byCondition(
                        and(
                                or(
                                        not(attribute(id).equals("a")),
                                        text().contains("b")
                                ),
                                not(number().greaterThan(5))
                        )
                ).getXpath());
    }

    @Test
    void notWrappingStyleCondition() {
        assertEquals("//div[not (contains(translate(@style, ' ', ''), 'background-color:red;'))]",
                div.byCondition(
                        not(style(backgroundColor).equals("red"))
                ).getXpath());
    }

    @Test
    void andSkipSlotLastIsOmittedEntirely() {
        assertEquals("//div[( @id='a' )]",
                div.byCondition(
                        and(
                                attribute(id).equals("a"),
                                and()
                        )
                ).getXpath());
    }

    @Test
    void orSkipSlotLastIsOmittedEntirely() {
        assertEquals("//div[( @id='a' )]",
                div.byCondition(
                        or(
                                attribute(id).equals("a"),
                                or()
                        )
                ).getXpath());
    }

    @Test
    void andSkipSlotFirstIsOmittedEntirely() {
        assertEquals("//div[( @id='a' )]",
                div.byCondition(
                        and(
                                and(),
                                attribute(id).equals("a")
                        )
                ).getXpath());
    }
}
