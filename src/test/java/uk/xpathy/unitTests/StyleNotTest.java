package uk.xpathy.unitTests;

import static uk.xpathy.Style.backgroundColor;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class StyleNotTest {

    @Test
    void notHaveIt() {
        assertEquals("//*[@style and not(contains(translate(@style, ' ', ''), 'background-color:'))]",
                backgroundColor.not().haveIt().getXpath());
    }

    @Test
    void notEquals() {
        assertEquals("//*[contains(translate(@style, ' ', ''), 'background-color:') and not(contains(translate(@style, ' ', ''), 'background-color:#000000;'))]",
                backgroundColor.not().equals("#000000").getXpath());
    }
}
