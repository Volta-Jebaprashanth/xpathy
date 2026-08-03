package uk.xpathy.unitTests;
import uk.xpathy.XPathy;
import uk.xpathy.Attribute;
import uk.xpathy.Tag;

public class Test {

    static XPathy xpathy = Attribute.id.contains("a")
            .$child().$ancestor().byText().contains("test");

    static XPathy xpathy2 = Tag.div.$child().byText().contains("test");

    public static void main(String[] args) {
        System.out.println(xpathy.getXpath());
        System.out.println(xpathy2.getXpath());
    }

}
