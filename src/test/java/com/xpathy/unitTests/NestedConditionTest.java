package com.xpathy.unitTests;

import static com.xpathy.Attribute.class_;
import static com.xpathy.Attribute.data_testid;
import static com.xpathy.Attribute.id;
import static com.xpathy.Case.IGNORED;
import static com.xpathy.Condition.and;
import static com.xpathy.Condition.attribute;
import static com.xpathy.Condition.not;
import static com.xpathy.Condition.or;
import static com.xpathy.Condition.text;
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
}
