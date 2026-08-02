package com.xpathy.unitTests;

import static com.xpathy.Attribute.id;
import static com.xpathy.Tag.div;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.xpathy.And;
import com.xpathy.Or;
import org.junit.jupiter.api.Test;

class UnionIntersectCoverageTest {

    // ===== _Attribute_Not_.union() / .intersect() =====

    @Test
    void attributeNotUnionBasic() {
        assertEquals("//*[(not(@id='a') or @id='b')]",
                id.not().union(Or.equals("a"), Or.equals("b")).getXpath());
    }

    @Test
    void attributeNotIntersectBasic() {
        assertEquals("//*[(not(contains(@id, 'a')) and contains(@id, 'b'))]",
                id.not().intersect(And.contains("a"), And.contains("b")).getXpath());
    }

    @Test
    void attributeNotUnionWithNegatedOrDoubleNegatesToPlain() {
        assertEquals("//*[@id='a']", id.not().union(Or.not().equals("a")).getXpath());
    }

    @Test
    void attributeNotIntersectWithNegatedAndDoubleNegatesToPlain() {
        assertEquals("//*[contains(@id, 'a')]", id.not().intersect(And.not().contains("a")).getXpath());
    }

    // ===== _Text_Not_.union() / .intersect() =====

    @Test
    void textNotUnionBasic() {
        assertEquals("//div[(not(text()='a') or text() = 'b')]",
                div.byText().not().union(Or.equals("a"), Or.equals("b")).getXpath());
    }

    @Test
    void textNotIntersectBasic() {
        assertEquals("//div[(not(contains(text(), 'a')) and contains(text(), 'b'))]",
                div.byText().not().intersect(And.contains("a"), And.contains("b")).getXpath());
    }

    // ===== _Attribute_.union/intersect: extra expression-type and position branches =====

    @Test
    void unionHaveItFirstBetweenSecond() {
        assertEquals("//*[(@id or  ( @id > 1 and @id < 2 ) )]",
                id.union(Or.haveIt(), Or.between(1, 2)).getXpath());
    }

    @Test
    void unionNegatedFirstPlainSecond() {
        assertEquals("//*[(not(@id='a') or @id='b')]",
                id.union(Or.not().equals("a"), Or.equals("b")).getXpath());
    }

    @Test
    void intersectHaveItFirstBetweenSecond() {
        assertEquals("//*[(@id and  ( @id > 1 and @id < 2 ) )]",
                id.intersect(And.haveIt(), And.between(1, 2)).getXpath());
    }

    @Test
    void intersectNegatedFirstPlainSecond() {
        assertEquals("//*[(not(@id='a') and @id='b')]",
                id.intersect(And.not().equals("a"), And.equals("b")).getXpath());
    }
}
