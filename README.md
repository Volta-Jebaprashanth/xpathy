# XPathy User Manual
[![](https://jitpack.io/v/Volta-Jebaprashanth/xpathy.svg)](https://jitpack.io/#Volta-Jebaprashanth/xpathy)

`XPathy` is a fluent API in Java for dynamically building XPath locators, primarily intended for use with Selenium WebDriver. It improves readability, reduces human error in string manipulation, and enables chaining of operations for complex XPath expressions.

---

## 👨‍💻 Author

Created by **Volta Jebaprashanth**  
📧 [voltajeba@gmail.com](mailto:voltajeba@gmail.com)  
📞 +94 77 463 7185  
🔗 [LinkedIn](https://www.linkedin.com/in/voltajeba)

---

## 📦 Package
```java
package com.xpathy;
```
---

## 📦 Installation (via JitPack)
📎 [View on JitPack](https://jitpack.io/#Volta-Jebaprashanth/xpathy/2.0.1)
for other installation modules.

To use this library in your **Maven** project (pom.xml):

### Add the JitPack repository:

```xml
<repositories>
  <repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
  </repository>
</repositories>
```

### Add the XPathy dependency:

```xml
<dependencies>
  <dependency>
    <groupId>com.github.Volta-Jebaprashanth</groupId>
    <artifactId>xpathy</artifactId>
    <version>2.0.1</version>
  </dependency>
</dependencies>
```

---

## ⚙️ Initialization

### 🔹 Using Constructor

```java
new XPathy();                            // Selects all elements (*).
new XPathy("//div[@class='example']");   // Initialize from raw XPath string
new XPathy(Tag.div);                      // From a predefined tag
new XPathy(By.id("username"));           // From Selenium By object
new XPathy(existingXPathyInstance);      // Clone existing XPathy
```

### 🔹 Using Static Factory Methods

```java
XPathy.from(By.id("username"));
XPathy.from("//div[@class='example']");
XPathy.from(Tag.span);
XPathy.of(Tag.div);                      // Alias for from(...)
```

---

## 🏷 Starting from Tags, Attributes, Text, and Style

### 🔸 From Tag

```java
Tag.span.ATTRIBUTE(Attribute.id).equals("value");
Tag.button.TEXT().contains("Click me");
```

### 🔸 From Attribute

```java
Attribute.id.contains("username");
Attribute.class_.equals("form-control");
```

### 🔸 From Text

```java
Text.contains("welcome");
Text.startsWith("Hello");
```

### 🔸 From Style

```java
Style.backgroundColor.equals("red");
```

---

## 🧱 Core XPathy Methods

### 🔸 Attribute and Text Filters

```java
xpathy.ATTRIBUTE(Attribute.id).equals("value");
xpathy.TEXT().contains("partial");
xpathy.NUMBER().greaterThan(10);
```

### 🔸 Style Filters

```java
xpathy.STYLE(Style.marginTop).equals("12px");
```

### 🔸 Indexing

```java
xpathy.index(2);         // (xpath)[2]
xpathy.last();         // (xpath)[last()]
```

---

## 🔠 Value Transformation Flags

XPathy supports a variety of transformation flags that modify the way attribute or text values are matched. These are extremely useful for sanitizing or normalizing the content before comparison. All of these methods can be chained with `.TEXT()` or `.ATTRIBUTE(...)` selectors.

### 🔸 KEEP / REMOVE

These are used to keep or remove specific character groups from the target string before applying the condition.

```java
.KEEP(Only.SPACES)
```

```java
new XPathy(Tag.div)
  .TEXT().KEEP(Only.ENGLISH_ALPHABETS).equals("hello world");
```

**What it does:** Keeps only spaces in the original text and removes all other characters before comparison. In this case, only spaces in the string "hello world" are preserved for the equality check.

```java
.REMOVE(Only.SPACES, Only.NUMBERS)
```
```java
new XPathy(Tag.input)
  .ATTRIBUTE(Attribute.name).REMOVE(Only.SPACES, Only.NUMBERS).equals("test-user");
```

**What it does:** Removes all spaces and digits from the "name" attribute's value before applying the equals("test-user") condition.

### 🔸 TRANSLATE
```java
.TRANSLATE("éàè", "eae")
```
```java
new XPathy(Tag.label)
  .TEXT().TRANSLATE("éàè", "eae").equals("Cafe");
```

**What it does:** Translates all occurrences of 'é', 'à', and 'è' into 'e', 'a', and 'e' respectively before comparison. Useful for internationalized strings.

### 🔸 CASE and Normalization
```java
.CASE(Case.LOWER)
```
```java
new XPathy(Tag.div)
  .TEXT().CASE(Case.LOWER).equals("status");
```

**What it does:** Converts the text to lowercase before checking if it equals "status".

```java
.TRIM()
```
```java
new XPathy(Tag.span)
  .TEXT().TRIM().equals("Submit");
```

**What it does:** Removes any leading/trailing whitespace from the text before checking if it equals "Submit".
```java
.NORMALIZE_SPACE()
```
```java
new XPathy(Tag.span)
  .TEXT().NORMALIZE_SPACE().contains("welcome back");
```

**What it does:** Normalizes spacing by replacing multiple spaces with a single space and trimming whitespace.

These transformations help ensure that your XPath filters remain resilient across inconsistent formatting or user-entered text.

XPathy supports a variety of transformation flags that modify the way attribute or text values are matched. These are extremely useful for sanitizing or normalizing the content before comparison. All of these methods can be chained with `.TEXT()` or `.ATTRIBUTE(...)` selectors.



---

## 🔗 Logical Combinations

### 🔸 AND / OR / NOT

```java
.AND()
.OR()
.NOT()
```

Used between filters to logically combine multiple conditions:

```java
new XPathy(Tag.input)
  .ATTRIBUTE(Attribute.name).equals("username")
  .AND().ATTRIBUTE(Attribute.type).equals("text")
  .AND().TEXT().NOT().equals("Guest");
```

---

## 🌲 DOM Navigation

XPathy provides convenient methods to traverse the DOM tree in any direction. These methods are written in **lowercase** and return a new XPathy object pointing to the selected parent, child, sibling, or relative position.

### 🔼 Upward

```java
.parent();              // Move one level up in the DOM
.parent(Tag.div);       // Move to the parent if it's a <div>
.up(2);                 // Move two levels up from the current element
```

**What it does:** Enables you to go from a deeply nested element to its parent(s), commonly used for relative matching.

### 🔽 Downward

```java
.children();            // Get all direct children
.children(Tag.div);     // Get only direct children with a specific tag
.descendants();         // Get all descendant nodes
.descendants(Tag.span); // Get all descendants matching a specific tag
```

**What it does:** Select elements nested within the current node, either directly or at any depth.

### 🔁 Siblings

```java
.following_siblings();             // All following siblings
.following_siblings(Tag.div);     // Following siblings that are <div>
.preceding_siblings();            // All preceding siblings
.preceding_siblings(Tag.div);     // Preceding siblings that are <div>
```

**What it does:** Navigates horizontally in the DOM, useful when elements are on the same level and have similar structure (like rows or columns).

###

---

## 📊 Comparisons

### 🔸 With Text

```java
.TEXT().greaterThan(10);
.NUMBER().lessThanOrEquals(50);
```

### 🔸 With Attributes

```java
.ATTRIBUTE(Attribute.dataIndex).greaterOrEquals(5);
```

---

## 📌 HAVING Clause

The `HAVING()` clause in XPathy is used to apply conditions on sub-elements or attributes that belong to the current node. After `.HAVING()`, you can specify the target using directional methods like `.ANY_CHILD()`, `.ANY_DESCENDANT()`, etc., followed by filters.

### 🔸 Examples

```java
new XPathy().HAVING().ANY_CHILD().TEXT().contains("value");
```

**What it does:** Selects the current element only if it has at least one child whose text contains "value".

```java
new XPathy(Tag.div)
  .HAVING().ANY_DESCENDANT().ATTRIBUTE(Attribute.class_).equals("highlight");
```

**What it does:** Selects  elements that contain any descendant with a class attribute of "highlight".

```java
new XPathy(Tag.section)
  .HAVING().ANY_CHILD(Tag.p).TEXT().startsWith("Note");
```

**What it does:** Selects  nodes that have a direct  child whose text starts with "Note".

These methods enable complex filtering inside nested structures without manually building the full XPath hierarchy.

Apply conditions to sub-elements or node content.


---

## 🔁 Utility Methods

```java
.getXpath();    // Returns String representation
.getLocator();  // Returns By object
.toBy();        // Same as getLocator()
```

---

## 🧪 Full Examples

### 1. Attribute, Text, and AND Logic

```java
new XPathy(Tag.div)
  .ATTRIBUTE(Attribute.id).equals("container")
  .AND().TEXT().contains("Welcome")
  .getLocator();
```

### 2. Parent and Sibling Traversal

```java
new XPathy(Tag.div).ATTRIBUTE(Attribute.class_).contains("products")
  .PARENT(Tag.tr)
  .FOLLOWING_SIBLING(Tag.tr)
  .ATTRIBUTE(Attribute.dataIndex).greaterThan(5);
```

### 3. Transform, Normalize, Translate

```java
new XPathy(Tag.label)
  .TEXT().TRIM().CASE(Case.UPPER).TRANSLATE("Ä", "A").startsWith("ABCD");
```

### 4. Using HAVING with Length Check

```java
new XPathy(Tag.button).TEXT().contains("Submit")
  .AND()
  .HAVING().ANY_CHILD().TEXT().LENGTH().greaterThan(6);
```

### 5. OR Condition

```java
new XPathy(Tag.a).TEXT().equals("Details")
  .OR().TEXT().equals("Other Details");
```




---



## 📝 Notes
- XPathy is immutable: each operation returns a new instance.
- Ideal for test automation where dynamic and complex XPath expressions are common.
- Works best when paired with enums for `Tag` and `Attribute` for type safety and clarity.

---

## 💡 Tips

* Use enums like `Tag`, `Attribute`, `Only`, `Style`, and `Case` for type-safety.
* Avoid raw XPath strings.
* Use `.getXpath()` for debug output.

---


## 📬 Support & Contact

Created by **Volta Jebaprashanth**
📧 [voltajeba@gmail.com](mailto:voltajeba@gmail.com)
🔗 [LinkedIn](https://www.linkedin.com/in/voltajeba)

---

Happy Testing with XPathy! 🚀


