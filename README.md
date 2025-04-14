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
    <version>1.0.3</version>
  </dependency>
</dependencies>
```

---

## 🗂 Project Structure
The following are the core components of the `XPathy` utility:

### ✅ XPathy.java
- The main class that provides a fluent API to build XPath expressions dynamically.
- Converts various Selenium `By` locators to XPath.
- Supports chaining filters, logic operators, traversals, and more.

### 🏷 Attribute.java
- class representing attribute names (e.g., `id`, `class`, `name`, `data-*` attributes).
- Used for type-safe attribute access in methods like `.equals(Attribute.id, "product")`.
- You can define custom attributes too using:
  ```java
  Attribute customAttr = Attribute.CUSTOM("data-custom");
  ```

### 🔖 Tag.java
- class representing HTML tag names (e.g., `div`, `span`, `a`, `input`).
- Also includes shortcut methods to start building XPathy expressions directly from a tag.
  ```java
  Tag.span.equals(Attribute.id, "value");
  Tag.button.textContains("Click");
  ```
- You can define custom tags too using:
  ```java
  Tag customTag = Tag.CUSTOM("my-tag");
  ```

---


## 🏁 Initialization
You can initialize `XPathy` in multiple ways:

```java
new XPathy();                           // default: //* (matches any element)
new XPathy("//div[@class='example']");  //from existing xpath String
new XPathy(Tag.div);                    // if Tag is an enum with tag names
new XPathy(By.id("username"));          // existing By object
new XPathy(existingXPathyInstance);
```

Use static `from(...)` or `of(...)` methods for convenience:
```java
XPathy.from(By.id("username"));
XPathy.from("//div[@class='example']");
XPathy.from(Tag.div);
XPathy.from(existingXPathyInstance);
XPathy.of(Tag.span);                   // alias for XPathy.from(Tag.span)
```
XPathy can also be initialized directly from a `Tag` using extended methods on the `Tag` enum:
```java
Tag.span.equals(Attribute.id, "value");
Tag.button.textContains("Click me");
Tag.input.startsWith(Attribute.name, "prefix");
Tag.h2.textStartsWith("Title");
```

---

## 🔍 Locators
The `.getLocator()` or `.toBy()` method returns a Selenium `By` object that can be used directly with WebDriver operations like `findElement()`.

```java
By by = xpathyInstance.toBy();
By locator = xpathyInstance.getLocator();
```

---

## 🧱 XPath Construction Methods

### 🔸 Basic Filters
```java
xpathy.equals(Attribute.id, "value")
XPathy.textEquals("Exact Text")
xpathy.contains(Attribute.title, "partial")
xpathy.textContains("partial")
xpathy.startsWith(Attribute.name, "start")
xpathy.textStartsWith("start")
```

### 🔸 Logical AND
```java
xpathy.andEquals(Attribute.attr, "value")
xpathy.andTextEquals("Exact Text")
xpathy.andContains(Attribute.attr, "value")
xpathy.andTextContains("value")
```

### 🔸 Logical OR
```java
xpathy.or(Tag.div)
xpathy.or(By.id("other"))
xpathy.or(XPathyInstance)
xpathy.or(XPathyInstance1, XPathyInstance2, ...)
xpathy.orEquals(Attribute.attr, "value")
xpathy.orTextEquals("value")
xpathy.orContains(Attribute.attr, "value")
xpathy.orTextContains("value")
```

---

## 🌲 DOM Navigation

### 🔼 Upward Traversal
```java
xpathy.parent()                  // move to parent
xpathy.parent(Tag.div)           // parent with specific tag
xpathy.up(2)                     // move n levels up
xpathy.ancestors()               // all ancestors
xpathy.ancestors(Tag.span)       // specific ancestor
```

### 🔽 Downward Traversal
```java
xpathy.children()                // all children
xpathy.children(Tag.div)         // specific child tag
xpathy.descendants()             // all descendants
xpathy.descendants(Tag.a)        // specific descendant
```

### 🔁 Siblings
```java
xpathy.following_siblings()
xpathy.following_siblings(Tag.div)
xpathy.preceding_siblings()
xpathy.preceding_siblings(Tag.div)  
```

---

## 🔢 Indexing
```java
xpathy.nth(2)      // (xpath)[2]
xpathy.last()      // (xpath)[last()]
```

---

## 📊 Comparisons

### With Node Text
```java
xpathy.greaterThan(10)
xpathy.greaterOrEquals(10)
xpathy.lessThan(10)
xpathy.lessOrEquals(10)
```

### With Attribute
```java
xpathy.attributeGreaterThan(Attribute.attr, 10)
xpathy.attributeGreaterOrEquals(Attribute.attr, 10)
xpathy.attributeLessThan(Attribute.attr, 10)
xpathy.attributeLessOrEquals(Attribute.attr, 10)
```

---

## 🚫 Negation
```java
XPathy.notEquals(Attribute.attr, "value")
XPathy.textNotEquals("Text")
```

---

## 🔁 Utility
```java
XPathy.getXpath();   // returns the XPath string
XPathy.copy();       // clones the instance
```

---

## 🧪 Example

### 🔹 Basic Example
```java
By locator = new XPathy(Tag.div)
    .equals(Attribute.id, "container")
    .getLocator();

// output By XPath: //div[@id='container']
```

### 🔹 Adding Child and Text Condition
```java
By locator = new XPathy(Tag.div)
    .equals(Attribute.id, "main")
    .children(Tag.span)
    .textEquals("Click Me")
    .getLocator();

// Output By XPath: //div[@id='main']/child::span[text()='Click Me']
```

### 🔹 Using Descendant and Class Contains
```java
By locator = new XPathy(Tag.section)
    .contains(Attribute.class, "content")
    .descendants(Tag.button)
    .textContains("Submit")
    .getLocator();

// output By XPath: //section[contains(@class, 'content')]/descendant::button[contains(text(), 'Submit')]
```

### 🔹 Using AND for Multiple Conditions
```java
By locator = new XPathy(Tag.div)
    .equals(Attribute.id, "form")
    .andContains(Attribute.class, "validated")
    .andTextContains("Register")
    .getLocator();

// output By XPath: //div[@id='form' and contains(@class, 'validated') and contains(text(), 'Register')]
```

### 🔹 Using OR to Match Multiple Tags
```java
By locator = new XPathy(Tag.button)
    .textEquals("Save")
    .or(new XPathy(Tag.a).textEquals("Save"))
    .getLocator();

// output By XPath: //button[text()='Save'] | //a[text()='Save']
```

### 🔹 Combining Advanced Conditions
```java
By locator = new XPathy(Tag.div)
    .equals(Attribute.id, "profile")
    .descendants(Tag.span)
    .textEquals("Edit")
    .orTextEquals("Update")
    .andContains(Attribute.class, "btn")
    .getLocator();

// output By XPath: //div[@id='profile']/descendant::span[text()='Edit' or text()='Update' and contains(@class, 'btn')]
```

### 🔹 Complex Use Case: Ancestor Traversal with OR
```java
By locator = new XPathy(Tag.span)
    .textContains("Price")
    .ancestors(Tag.tr)
    .or(new XPathy(Tag.span).textContains("Amount").ancestors(Tag.tr))
    .getLocator();

// output By XPath: //span[contains(text(), 'Price')]/ancestor::tr | //span[contains(text(), 'Amount')]/ancestor::tr
```

### 🔹 Full Chain: Up, Siblings, and Attribute Comparison
```java
By locator = new XPathy(Tag.div)
    .equals(Attribute.class, "row")
    .up(1)
    .following_siblings(Tag.div)
    .attributeGreaterOrEquals(Attribute.dataIndex, 5)
    .getLocator();

// output By XPath: //div[@class='row']/../following-sibling::div[@dataIndex >= 5]
```

### 🔹 Get Final XPath 
```java
String xpathString = locator.getXpath();
```

### 🔹 Get Final By  
```java
By locator = xpathy.getLocator();
By locator = xpathy.getBy();
```

These examples cover a variety of realistic test automation needs using XPathy.
```java
XPathy locator = new XPathy(Tag.div)
    .equals(Attribute.id, "container")
    .andContains(Attribute.class, "section")
    .descendants(Tag.button)
    .textEquals("Submit");

WebElement button = driver.findElement(locator.toBy());
```
This builds:
```xpath
//div[@id='container' and contains(@class, 'section')]/descendant::button[text()='Submit']
```

---

## 📝 Notes
- XPathy is immutable: each operation returns a new instance.
- Ideal for test automation where dynamic and complex XPath expressions are common.
- Works best when paired with enums for `Tag` and `Attribute` for type safety and clarity.

---

## 🎯 Tips
- Avoid deeply chained logic unless necessary.
- Use `.getXpath()` for debugging/logging actual XPath strings.
- For fallback matching, use `or(...)` to combine multiple locators.

---

Happy Testing 🚀

