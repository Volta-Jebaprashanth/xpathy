package com.xpathy;


public class Test {

    public static void main(String[] args) {


        XPathy path1 = new XPathy(Tag.table).contains(Attribute.id, "dd");
        XPathy path2 = new XPathy(Tag.h3).textContains("billa");

        print(new XPathy(Tag.input).textEquals("ddd").nth(8).or(path1,path2).getLocator().toString());

        XPathy locator = new XPathy(Tag.div)
                .equals(Attribute.id, "main")
                .andContains(Attribute.class_, "container")
                .descendants(Tag.span)
                .textEquals("Submit");

        print(locator.getLocator().toString());
            }

    private static void print(Object obj) {
        System.out.println(obj.toString());
    }

}
