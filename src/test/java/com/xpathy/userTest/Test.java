package com.xpathy.userTest;
import com.xpathy.XPathy;
import com.xpathy.Attribute;
import com.xpathy.Tag;

public class Test {

    static XPathy xpathy = Attribute.id.contains("a")
            .$child().$ancestor().byText().contains("test");

    static XPathy xpathy2 = Tag.div.$child().byText().contains("test");

    public static void main(String[] args) {
        System.out.println(xpathy.getXpath());
        System.out.println(xpathy2.getXpath());
    }

}
