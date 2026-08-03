package uk.xpathy.unitTests;

import static uk.xpathy.Tag.div;
import static uk.xpathy.Tag.h2;
import static org.junit.jupiter.api.Assertions.assertEquals;

import uk.xpathy.Text;
import org.junit.jupiter.api.Test;

class TextTest {

    @Test
    void containsOnTag() {
        assertEquals("//div[contains(text(), 'Welcome')]", div.byText().contains("Welcome").getXpath());
    }

    @Test
    void startsWithOnTag() {
        assertEquals("//h2[starts-with(text(), 'Chapter')]", h2.byText().startsWith("Chapter").getXpath());
    }

    @Test
    void globalContains() {
        assertEquals("//*[contains(text(), 'Error')]", Text.contains("Error").getXpath());
    }

    @Test
    void globalStartsWith() {
        assertEquals("//*[starts-with(text(), 'Success')]", Text.startsWith("Success").getXpath());
    }

    @Test
    void equals() {
        assertEquals("//div[text() = 'Exact']", div.byText().equals("Exact").getXpath());
    }

    @Test
    void isEmpty() {
        assertEquals("//div[normalize-space(text())='']", div.byText().isEmpty().getXpath());
    }

    @Test
    void isNumeric() {
        assertEquals("//div[not(number(text()) != number(text()))]", div.byText().isNumeric().getXpath());
    }

    @Test
    void notContains() {
        assertEquals("//div[not(contains(text(), 'X'))]", div.byText().not().contains("X").getXpath());
    }

    @Test
    void byLengthEquals() {
        assertEquals("//div[string-length(text()) = 10]", div.byText().byLength().equals(10).getXpath());
    }
}
