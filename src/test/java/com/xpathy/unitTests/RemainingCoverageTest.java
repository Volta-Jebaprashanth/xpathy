package com.xpathy.unitTests;

import static com.xpathy.Attribute.class_;
import static com.xpathy.Attribute.id;
import static com.xpathy.Attribute.value;
import static com.xpathy.Case.IGNORED;
import static com.xpathy.Only.NUMBERS;
import static com.xpathy.Style.backgroundColor;
import static com.xpathy.Tag.div;
import static com.xpathy.Tag.input;
import static com.xpathy.Tag.label;
import static com.xpathy.Tag.li;
import static com.xpathy.Tag.option;
import static com.xpathy.Tag.p;
import static com.xpathy.Tag.section;
import static com.xpathy.Tag.span;
import static com.xpathy.Tag.td;
import static com.xpathy.Tag.ul;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.xpathy.And;
import com.xpathy.Attribute;
import com.xpathy.Or;
import com.xpathy.Style;
import com.xpathy.Tag;
import org.junit.jupiter.api.Test;

// Direct Attribute/Number shortcuts vs. their tag.byAttribute(...)/byNumber(...) builder-chain equivalents, Tag/Style factories, and bare-tag DOM navigation.
class RemainingCoverageTest {

    // ===== Attribute direct shortcuts =====

    @Test
    void attributeEqualsNumberDirect() {
        assertEquals("//*[@value = 5]", value.equals(5).getXpath());
    }

    @Test
    void attributeOfFactory() {
        assertEquals("//*[contains(@data-qa, 'x')]", Attribute.of("data-qa").contains("x").getXpath());
    }

    @Test
    void attributeCreateFactory() {
        assertEquals("//*[contains(@data-qa, 'x')]", Attribute.create("data-qa").contains("x").getXpath());
    }

    @Test
    void attributeWithNormalizeSpaceDirect() {
        assertEquals("//*[normalize-space(@class)='a']", class_.withNormalizeSpace().equals("a").getXpath());
    }

    @Test
    void attributeWithCaseDirect() {
        assertEquals("//*[translate(@class, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz')='a']",
                class_.withCase(IGNORED).equals("a").getXpath());
    }

    @Test
    void attributeWithRemoveOnlyDirect() {
        assertEquals("//*[contains(translate(@class, '0123456789', ''), 'a')]", class_.withRemoveOnly(NUMBERS).contains("a").getXpath());
    }

    @Test
    void attributeWithKeepOnlyDirectFiltersValueToo() {
        assertEquals("//*[contains(translate(@class, translate(@class, '0123456789', ''), ''), '')]",
                class_.withKeepOnly(NUMBERS).contains("a").getXpath());
    }

    @Test
    void attributeWithTranslateDirect() {
        assertEquals("//*[contains(translate(@class, 'a', 'b'), 'b')]", class_.withTranslate("a", "b").contains("a").getXpath());
    }

    // ===== _Attribute_ builder-chain instance methods (tag.byAttribute(x).Y()) =====

    @Test
    void attributeBuilderByLength() {
        assertEquals("//div[@id and string-length(@id) = 5]", div.byAttribute(id).byLength().equals(5).getXpath());
    }

    @Test
    void attributeBuilderWithTrim() {
        assertEquals("//div[normalize-space(translate(@id, ' ', ' '))='x']", div.byAttribute(id).withTrim().equals("x").getXpath());
    }

    @Test
    void attributeBuilderWithNormalizeSpace() {
        assertEquals("//div[normalize-space(@id)='x']", div.byAttribute(id).withNormalizeSpace().equals("x").getXpath());
    }

    @Test
    void attributeBuilderWithRemoveOnly() {
        assertEquals("//div[contains(translate(@id, '0123456789', ''), 'x')]", div.byAttribute(id).withRemoveOnly(NUMBERS).contains("x").getXpath());
    }

    @Test
    void attributeBuilderWithKeepOnly() {
        assertEquals("//div[contains(translate(@id, translate(@id, '0123456789', ''), ''), '')]",
                div.byAttribute(id).withKeepOnly(NUMBERS).contains("x").getXpath());
    }

    @Test
    void attributeBuilderWithTranslate() {
        assertEquals("//div[contains(translate(@id, 'a', 'b'), 'x')]", div.byAttribute(id).withTranslate("a", "b").contains("x").getXpath());
    }

    // ===== _Number_ builder-chain instance methods (tag.byNumber().Y()) =====

    @Test
    void numberBuilderWithNormalizeSpace() {
        assertEquals("//span[number(normalize-space(text())) > 5]", span.byNumber().withNormalizeSpace().greaterThan(5).getXpath());
    }

    @Test
    void numberBuilderWithRemoveOnly() {
        assertEquals("//span[number(translate(text(), '0123456789', '')) > 5]", span.byNumber().withRemoveOnly(NUMBERS).greaterThan(5).getXpath());
    }

    @Test
    void numberBuilderWithKeepOnly() {
        assertEquals("//span[number(translate(text(), translate(text(), '0123456789', ''), '')) > 5]",
                span.byNumber().withKeepOnly(NUMBERS).greaterThan(5).getXpath());
    }

    @Test
    void numberBuilderWithTranslate() {
        assertEquals("//span[number(translate(text(), 'a', 'b')) > 5]", span.byNumber().withTranslate("a", "b").greaterThan(5).getXpath());
    }

    // ===== Tag factory methods =====

    @Test
    void tagCustomFactory() {
        assertEquals("//my-el[@id='x']", Tag.custom("my-el").byAttribute(id).equals("x").getXpath());
    }

    @Test
    void tagCreateFactory() {
        assertEquals("//my-el[@id='x']", Tag.create("my-el").byAttribute(id).equals("x").getXpath());
    }

    @Test
    void tagOfFactory() {
        assertEquals("//my-el[@id='x']", Tag.of("my-el").byAttribute(id).equals("x").getXpath());
    }

    // ===== Tag direct DOM navigation shortcuts (called on a bare tag, no preceding condition) =====

    @Test
    void tagByHavingDirect() {
        assertEquals("//div[( span[contains(text(), 'x')] )]", div.byHaving(span.byText().contains("x")).getXpath());
    }

    @Test
    void tagDollarTag() {
        assertEquals("//div//span", div.$tag(span).getXpath());
    }

    @Test
    void tagDollarParentWithTag() {
        assertEquals("//span/parent::div", span.$parent(div).getXpath());
    }

    @Test
    void tagDollarParentNoArg() {
        assertEquals("//span/..", span.$parent().getXpath());
    }

    @Test
    void tagDollarUpNoArg() {
        assertEquals("//span/..", span.$up().getXpath());
    }

    @Test
    void tagDollarUpWithCount() {
        assertEquals("//span/../..", span.$up(2).getXpath());
    }

    @Test
    void tagDollarAncestorWithTag() {
        assertEquals("//span/ancestor::div", span.$ancestor(div).getXpath());
    }

    @Test
    void tagDollarAncestorNoArg() {
        assertEquals("//span/ancestor::*", span.$ancestor().getXpath());
    }

    @Test
    void tagDollarChildWithTag() {
        assertEquals("//ul/child::li", ul.$child(li).getXpath());
    }

    @Test
    void tagDollarChildNoArg() {
        assertEquals("//ul/child::*", ul.$child().getXpath());
    }

    @Test
    void tagDollarDescendantWithTag() {
        assertEquals("//section/descendant::p", section.$descendant(p).getXpath());
    }

    @Test
    void tagDollarDescendantNoArg() {
        assertEquals("//section/descendant::*", section.$descendant().getXpath());
    }

    @Test
    void tagDollarFollowingSiblingWithTag() {
        assertEquals("//label/following-sibling::input", label.$followingSibling(input).getXpath());
    }

    @Test
    void tagDollarFollowingSiblingNoArg() {
        assertEquals("//label/following-sibling::*", label.$followingSibling().getXpath());
    }

    @Test
    void tagDollarPrecedingSiblingWithTag() {
        assertEquals("//option/preceding-sibling::option", option.$precedingSibling(option).getXpath());
    }

    @Test
    void tagDollarPrecedingSiblingNoArg() {
        assertEquals("//li/preceding-sibling::*", li.$precedingSibling().getXpath());
    }

    // ===== Style factory/accessor methods =====

    @Test
    void styleGetName() {
        assertEquals("background-color", backgroundColor.getName());
    }

    @Test
    void styleCustomFactory() {
        assertEquals("//*[contains(translate(@style, ' ', ''), '--my-var:1;')]", Style.custom("--my-var").equals("1").getXpath());
    }

    @Test
    void styleOfFactory() {
        assertEquals("//*[contains(translate(@style, ' ', ''), '--my-var:1;')]", Style.of("--my-var").equals("1").getXpath());
    }

    // ===== _XPathy_Or_ remaining members =====

    @Test
    void orByStyle() {
        assertEquals("//div[@id='a' or contains(translate(@style, ' ', ''), 'background-color:red;')]",
                div.byAttribute(id).equals("a").or().byStyle(backgroundColor).equals("red").getXpath());
    }

    @Test
    void orByHavingInit() {
        assertEquals("//div[@id='a' or ./td[contains(text(), 'x')]]",
                div.byAttribute(id).equals("a").or().byHaving().child(td).byText().contains("x").getXpath());
    }

    @Test
    void orByHavingDirect() {
        assertEquals("//div[@id='a' or ( span[contains(text(), 'x')] )]",
                div.byAttribute(id).equals("a").or().byHaving(span.byText().contains("x")).getXpath());
    }

    @Test
    void orTag() {
        assertEquals("//div[@id='a'] | //span", div.byAttribute(id).equals("a").or().tag(span).getXpath());
    }

    // ===== _And_Manipulation_/_Or_Manipulation_ chained (instance-level) modifiers =====

    @Test
    void andManipulationChainedModifier() {
        assertEquals("//div[translate(normalize-space(translate(@id, ' ', ' ')), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz')='a']",
                div.byAttribute(id).intersect(And.withCase(IGNORED).withTrim().equals("a")).getXpath());
    }

    @Test
    void orManipulationChainedModifier() {
        assertEquals("//div[translate(normalize-space(translate(@id, ' ', ' ')), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz')='a']",
                div.byAttribute(id).union(Or.withCase(IGNORED).withTrim().equals("a")).getXpath());
    }

    @Test
    void andManipulationChainedWithNormalizeSpace() {
        assertEquals("//div[translate(normalize-space(@id), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz')='a']",
                div.byAttribute(id).intersect(And.withCase(IGNORED).withNormalizeSpace().equals("a")).getXpath());
    }

    @Test
    void andManipulationChainedWithCase() {
        assertEquals("//div[translate(normalize-space(translate(@id, ' ', ' ')), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz')='a']",
                div.byAttribute(id).intersect(And.withTrim().withCase(IGNORED).equals("a")).getXpath());
    }

    @Test
    void andManipulationChainedWithRemoveOnly() {
        assertEquals("//div[contains(translate(translate(@id, '0123456789', ''), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'a')]",
                div.byAttribute(id).intersect(And.withCase(IGNORED).withRemoveOnly(NUMBERS).contains("a")).getXpath());
    }

    @Test
    void andManipulationChainedWithKeepOnly() {
        assertEquals("//div[contains(translate(translate(@id, translate(@id, '0123456789', ''), ''), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '')]",
                div.byAttribute(id).intersect(And.withCase(IGNORED).withKeepOnly(NUMBERS).contains("a")).getXpath());
    }

    @Test
    void andManipulationChainedWithTranslate() {
        assertEquals("//div[contains(translate(translate(@id, 'a', 'b'), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'b')]",
                div.byAttribute(id).intersect(And.withCase(IGNORED).withTranslate("a", "b").contains("a")).getXpath());
    }

    @Test
    void orManipulationChainedWithNormalizeSpace() {
        assertEquals("//div[translate(normalize-space(@id), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz')='a']",
                div.byAttribute(id).union(Or.withCase(IGNORED).withNormalizeSpace().equals("a")).getXpath());
    }

    @Test
    void orManipulationChainedWithCase() {
        assertEquals("//div[translate(normalize-space(translate(@id, ' ', ' ')), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz')='a']",
                div.byAttribute(id).union(Or.withTrim().withCase(IGNORED).equals("a")).getXpath());
    }

    @Test
    void orManipulationChainedWithRemoveOnly() {
        assertEquals("//div[contains(translate(translate(@id, '0123456789', ''), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'a')]",
                div.byAttribute(id).union(Or.withCase(IGNORED).withRemoveOnly(NUMBERS).contains("a")).getXpath());
    }

    @Test
    void orManipulationChainedWithKeepOnly() {
        assertEquals("//div[contains(translate(translate(@id, translate(@id, '0123456789', ''), ''), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '')]",
                div.byAttribute(id).union(Or.withCase(IGNORED).withKeepOnly(NUMBERS).contains("a")).getXpath());
    }

    @Test
    void orManipulationChainedWithTranslate() {
        assertEquals("//div[contains(translate(translate(@id, 'a', 'b'), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'b')]",
                div.byAttribute(id).union(Or.withCase(IGNORED).withTranslate("a", "b").contains("a")).getXpath());
    }
}
