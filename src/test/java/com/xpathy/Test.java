package com.xpathy;

import static com.xpathy.Attribute.*;

public class Test {

    static XPathy xpathy = id.contains("a")
            .and()
            .byText()
            .union(Or.equals("1"), Or.contains("2"));

    public static void main(String[] args) {
        System.out.println(xpathy.getXpath());
    }

}
