package com.xpathy.userTest;
import com.xpathy.XPathy;
import com.xpathy.Attribute;
import com.xpathy.Or;
import com.xpathy.Tag;

public class Test {

    static XPathy xpathy = Attribute.id.contains("a")
            .and()
            .byText().not()
            .union(Or.equals("1"), Or.contains("2"));

    
    static XPathy xpathy2 = Tag.div.byText().contains("test");
    
    public static void main(String[] args) {
        System.out.println(xpathy.getXpath());
    }

}
