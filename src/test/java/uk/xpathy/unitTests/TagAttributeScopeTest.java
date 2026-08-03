package uk.xpathy.unitTests;

import static uk.xpathy.Attribute.class_;
import static uk.xpathy.Attribute.data_testid;
import static uk.xpathy.Attribute.id;
import static uk.xpathy.Tag.div;
import static uk.xpathy.Tag.h2;
import static uk.xpathy.Tag.p;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TagAttributeScopeTest {

    @Test
    void divById() {
        assertEquals("//div[@id='main-container']", div.byAttribute(id).equals("main-container").getXpath());
    }

    @Test
    void h2ByClass() {
        assertEquals("//h2[@class='section-title']", h2.byAttribute(class_).equals("section-title").getXpath());
    }

    @Test
    void pByDataTestIdStartsWith() {
        assertEquals("//p[starts-with(@data-testid, 'paragraph-')]", p.byAttribute(data_testid).startsWith("paragraph-").getXpath());
    }
}
