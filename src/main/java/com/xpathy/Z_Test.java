package com.xpathy;

public class Z_Test {

    /*

    new added

    ----> REMOVE_SPACE, REMOVE_SPECIAL_CHAR, REMOVE_NUMBER

    ------- Singuler ---------

    01. new XPathy().AND.contains();
    02. new XPathy().OR.contains();
    03. new XPathy().NOT.contains();
    04. new XPathy().TEXT.contains()
    05. new XPathy().NUMBER.greaterThan()
    06. new XPathy().ATTRIBUTE.contains()
    07. new XPathy().STYLE.equals()


    ------ Double --------------


    07. new XPathy().AND.TEXT.contains();
    08. new XPathy().AND.NUMBER.contains();
    09. new XPathy().AND.NOT.contains();



    11. new XPathy().OR.TEXT.contains();
    12. new XPathy().OR.NUMBER.contains();
    13. new XPathy().OR.NOT.contains();


    15. new XPathy().TEXT.NOT.contains();


    17. new XPathy().NUMBER.NOT.contains();



    //--------- Triple ---------

    19. new XPathy().AND.TEXT.NOT.contains();



    21. new XPathy().AND.NUMBER.NOT.contains();


    23. new XPathy().OR.TEXT.NOT.contains();



    25. new XPathy().OR.NUMBER.NOT.contains();

    //----------- four -----------



    ////=================== WHERE ================

    new XPathy().HAVING.ANY_CHILD.contains()
    new XPathy().HAVING.ANY_SIBLINGS.Contains()

     */


    public static void main(String[] args) {

        XPathy pathy = new XPathy(Tag.span)
                .TEXT()
                .KEEP(Only.BRACKETS, Only.ENGLISH_ALPHABETS)
                .equals("billa")
                .AND()
                .OR()
                .TEXT()
                .LENGTH()
                .NOT()
                .equals(10);
        System.out.println(pathy.getXpath());

    }
}
