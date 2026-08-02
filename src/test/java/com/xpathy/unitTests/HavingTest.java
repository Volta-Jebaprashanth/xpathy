package com.xpathy.unitTests;

import static com.xpathy.Attribute.class_;
import static com.xpathy.Attribute.id;
import static com.xpathy.Attribute.role;
import static com.xpathy.Tag.button;
import static com.xpathy.Tag.div;
import static com.xpathy.Tag.h2;
import static com.xpathy.Tag.li;
import static com.xpathy.Tag.nav;
import static com.xpathy.Tag.section;
import static com.xpathy.Tag.span;
import static com.xpathy.Tag.table;
import static com.xpathy.Tag.td;
import static com.xpathy.Tag.tr;
import static com.xpathy.Tag.ul;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class HavingTest {

    @Test
    void basicHavingWithDirectCondition() {
        assertEquals("//div[@class='product-card' and ( span[contains(text(), 'In Stock')] )]",
                div.byAttribute(class_).equals("product-card").and()
                        .byHaving(span.byText().contains("In Stock"))
                        .getXpath());
    }

    @Test
    void havingChild() {
        assertEquals("//table[( ./tr[@class='total-row'] )]",
                table.byHaving().child(
                        tr.byAttribute(class_).equals("total-row")
                ).getXpath());
    }

    @Test
    void havingDescendant() {
        assertEquals("//section[@id='checkout' and ( .//button[contains(text(), 'Place Order')] )]",
                section.byAttribute(id).equals("checkout").and()
                        .byHaving().descendant(
                                button.byText().contains("Place Order")
                        ).getXpath());
    }

    @Test
    void havingAncestor() {
        assertEquals("//div[@class='price-tag' and ( ancestor::section[@id='product-details'] )]",
                div.byAttribute(class_).equals("price-tag").and()
                        .byHaving().ancestor(
                                section.byAttribute(id).equals("product-details")
                        ).getXpath());
    }

    @Test
    void havingParent() {
        assertEquals("//ul[@class='menu-items' and ( parent::nav[@role='navigation'] )]",
                ul.byAttribute(class_).equals("menu-items").and()
                        .byHaving().parent(
                                nav.byAttribute(role).equals("navigation")
                        ).getXpath());
    }

    @Test
    void havingFollowingSibling() {
        assertEquals("//h2[text() = 'Features' and ( following-sibling::div[@class='description'] )]",
                h2.byText().equals("Features").and()
                        .byHaving().followingSibling(
                                div.byAttribute(class_).equals("description")
                        ).getXpath());
    }

    @Test
    void havingPrecedingSibling() {
        assertEquals("//li[text() = 'Contact' and ( preceding-sibling::li[text() = 'About'] )]",
                li.byText().equals("Contact").and()
                        .byHaving().precedingSibling(
                                li.byText().equals("About")
                        ).getXpath());
    }

    @Test
    void havingSimplifiedWorkflow() {
        assertEquals("//table[@id='invoice' and ./td[contains(text(), 'Subtotal')]]",
                table.byAttribute(id).equals("invoice").and()
                        .byHaving().child(td).byText().contains("Subtotal")
                        .getXpath());
    }
}
