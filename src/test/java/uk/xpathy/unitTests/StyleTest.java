package uk.xpathy.unitTests;

import static uk.xpathy.Style.backgroundColor;
import static uk.xpathy.Tag.div;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class StyleTest {

    @Test
    void equalsOnTag() {
        assertEquals("//div[contains(translate(@style, ' ', ''), 'background-color:#000000;')]",
                div.byStyle(backgroundColor).equals("#000000").getXpath());
    }

    @Test
    void globalEquals() {
        assertEquals("//*[contains(translate(@style, ' ', ''), 'background-color:#000000;')]",
                backgroundColor.equals("#000000").getXpath());
    }

    @Test
    void haveIt() {
        assertEquals("//*[contains(translate(@style, ' ', ''), 'background-color:')]",
                backgroundColor.haveIt().getXpath());
    }

    @Test
    void notEquals() {
        assertEquals("//*[contains(translate(@style, ' ', ''), 'background-color:') and not(contains(translate(@style, ' ', ''), 'background-color:#000000;'))]",
                backgroundColor.not().equals("#000000").getXpath());
    }
}
