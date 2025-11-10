# XPathy User Manual
[![](https://jitpack.io/v/Volta-Jebaprashanth/xpathy.svg)](https://jitpack.io/#Volta-Jebaprashanth/xpathy)

XPathy is a lightweight Java library that simplifies the creation of **XPath expressions** to be used in Selenium. Instead of manually writing long, error‑prone strings, XPathy allows you to build expressions using a **fluent API**. This makes your locators more **readable**, **maintainable**, and **scalable**. XPathy takes away the frustration of balancing brackets, quotes, and functions, letting developers focus on expressing intent clearly.

When you create an XPathy object, you can call **`.getLocator()`** to return a Selenium **`By`**  object, or call **`.toString()`** to get the XPath, making it directly usable in your automation scripts. XPathy is compatible with any Selenium version **3.0 or higher** with any `Java` or `Kotlin` versions.

----------
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
📎 [View on JitPack](https://jitpack.io/#Volta-Jebaprashanth/xpathy/3.0.0)
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
    <version>3.0.1</version>
  </dependency>
</dependencies>
```

---

# A - Basic Operations

This section introduces the basic operations of XPathy with corresponding XPath outputs. By the end of this manual, you will understand how to:

-   Use attributes (`id`, `class`, `data-*`, etc.)

-   Work with HTML tags and combine them with attributes

-   Target text content inside elements

-   Handle numeric comparisons for attributes and inner text

-   Query inline style attributes


----------

## 1. Working with Attributes

Attributes are the most common entry point for XPath locators. XPathy exposes all HTML attributes as objects, each with chainable methods.

**Import all attributes:**

```java
import static com.xpathy.Attribute.*;
```

Examples:

-   **Contains on `id`**


```java
XPathy locator = id.contains("login-button");
// Result: //*[contains(@id, 'login-button')]
```

-   **Equals on `class`**


```java
XPathy locator = class_.equals("active");
// Result: //*[@class='active']
```

-   **StartsWith on `data-testid`**


```java
XPathy locator = data_testid.startsWith("menu-");
// Result: //*[starts-with(@data-testid, 'menu-')]
```

-   **Numeric comparisons on `value`**


```java
XPathy locator = value.greaterThan(100);
// Result: //*[@value > 100]

XPathy locator = value.lessThan(50);
// Result: //*[@value < 50]
```

Additional methods include:

-   `haveIt()` → checks whether an attribute exists

-   `isEmpty()` → confirms an attribute is present but empty

-   `isNumeric()` → ensures an attribute’s value is numeric


----------

## 2. Attributes within Specific Tags

XPathy allows scoping attributes inside specific HTML tags, making locators more precise.

**Import all tags:**

```java
import static com.xpathy.Tag.*;
```

Examples:

-   **Find a `<div>` by `id`**


```java
XPathy locator = div.byAttribute(id).equals("main-container");
// Result: //div[@id='main-container']
```

-   **Find a `<h2>` by `class`**


```java
XPathy locator = h2.byAttribute(class_).equals("section-title");
// Result: //h2[@class='section-title']
```

-   **Find a `<p>` by `data-testid` starting with text**


```java
XPathy locator = p.byAttribute(data_testid).startsWith("paragraph-");
// Result: //p[starts-with(@data-testid, 'paragraph-')]
```

> **Note:** Every attribute method (`equals`, `contains`, `startsWith`, `greaterThan`, etc.) works with every supported tag.
----------

## 3. Working with Text Content

XPathy provides intuitive methods for targeting visible text inside elements.

-   **Text contains**


```java
XPathy locator = div.byText().contains("Welcome");
// Result: //div[contains(text(), 'Welcome')]
```

-   **Text starts with**


```java
XPathy locator = h2.byText().startsWith("Chapter");
// Result: //h2[starts-with(text(), 'Chapter')]
```

-   **Global Text usage**


```java
XPathy locator = Text.contains("Error");
// Result: //*[contains(text(), 'Error')]

XPathy locator = Text.startsWith("Success");
// Result: //*[starts-with(text(), 'Success')]
```

This is useful when attributes are dynamic but the element text is stable.

----------

## 4. Numeric Values Inside Elements

Some elements display numbers, such as counters or prices. XPathy lets you build conditions around them.

-   **Greater than numeric content**


```java
XPathy locator = td.byNumber().greaterThan(10);
// Result: //td[number(text()) > 10]
```

-   **Between numeric values**


```java
XPathy locator = span.byNumber().between(5, 15);
// Result: //span[number(text()) >= 5 and number(text()) <= 15]
```

This is especially handy for table cells or statistic widgets.

----------

## 5. Working with Styles

Inline styles can be targeted when attributes or text are insufficient.

-   **Check inline style for background colour within a tag**


```java
XPathy locator = div.byStyle(backgroundColor).equals("#000000");
// Result: //div[contains(translate(@style, ' ', ''), 'background-color:#000000;')]
```

-   **Check inline style directly**


```java
import static com.xpathy.Style.*;
```
```java
XPathy locator = backgroundColor.equals("#000000");
// Result: //*[contains(translate(@style, ' ', ''), 'background-color:#000000;')]
```

----------

# B - Understanding the Architecture Flow

XPathy follows a layered architecture for building locators. Each starting point such as `.byText()`, `.byAttribute()`, `.byNumber()`, or `.byStyle()` returns a **builder object** that knows how to handle that context:

-   `.byText()` → switches context to element text, allowing operations like `.equals()`, `.contains()`, `.startsWith()`.

-   `.byAttribute(attribute)` → switches context to a specific attribute, enabling methods such as `.equals()`, `.contains()`, `.startsWith()`, `.greaterThan()`, `.lessThan()`.

-   `.byNumber()` → converts inner text into a number, making numeric methods like `.greaterThan()`, `.lessThan()`, `.between()` available.

-   `.byStyle(styleAttribute)` → inspects inline CSS properties inside the `style` attribute, and supports `.equals()`, `.haveIt()`.


### How methods are chained

When you call `.equals()`, `.contains()`, `.startsWith()`, etc., you are finalizing the condition on the selected context. For example:

```java
XPathy locator = div.byAttribute(id).equals("header");
```

Flow:

1.  `div` sets the base tag.

2.  `.byAttribute(id)` selects the `id` attribute.

3.  `.equals("header")` finalizes the expression as `//div[@id='header']`.


Similarly:

```java
XPathy locator = h2.byText().startsWith("Title");
```

Flow:

1.  `h2` sets the base tag.

2.  `.byText()` switches to the text node.

3.  `.startsWith("Title")` produces `//h2[starts-with(text(),'Title')]`.


This consistent flow applies to **all contexts**. You always begin with a tag or attribute, select the context with `.byText()`, `.byAttribute()`, `.byNumber()`, or `.byStyle()`, then finalize with methods like `.equals()`, `.contains()`, `.startsWith()`, `.greaterThan()`, or `.between()`. The resulting `XPathy` object can then be converted to a Selenium `By` object with `.getLocator()`.

----------
# C - Basic Logical Operations

XPathy also supports combining multiple conditions with logical operators. These map directly to **XPath `and()`, `or()`, and `not()` constructs**, but with a fluent, chainable API that preserves readability.

Logical operations can be applied between **different contexts** (attributes, text, numbers, styles), making it possible to express powerful compound locators without juggling parentheses and syntax manually.

----------

## 1. `and()`

The `.and()` operator joins two conditions that must **both be true**.

```java
XPathy locator = div.byAttribute(id).equals("main-container")
                    .and()
                    .byText().contains("Hello World");

// Result: //div[@id='main-container' and contains(text(), 'Hello World')]
```

**Explanation:**

1.  `div.byAttribute(id).equals("main-container")` → `//div[@id='main-container']`

2.  `.and().byText().contains("Hello World")` → adds an additional condition on the same `div` node.

3.  Final → `//div[@id='main-container' and contains(text(), 'Hello World')]`


----------

## 2. `or()`

The `.or()` operator joins two conditions where **either one may be true**.

```java
XPathy locator = div.byAttribute(id).equals("main-container")
                    .or()
                    .byText().contains("Hello World");

// Result: //div[@id='main-container' or contains(text(), 'Hello World')]
```

**Explanation:**

-   Matches any `<div>` with `id="main-container"` **OR** text containing `"Hello World"`.


----------

## 3. `not()`

The `.not()` operator negates the following condition. This allows you to exclude elements matching a certain attribute, text, or style.

```java
XPathy locator = div.byText().contains("Hello World")
                    .and()
                    .byAttribute(id).not().equals("main-container");

// Result: //div[contains(text(), 'Hello World') and not(@id='main-container')]
```

**Explanation:**

1.  First condition: `contains(text(), 'Hello World')`

2.  Second condition: `not(@id='main-container')`

3.  Combined with `.and()` → `//div[contains(text(), 'Hello World') and not(@id='main-container')]`


----------

## 4. Chaining Multiple Logical Operations

XPathy allows chaining `and()`, `or()`, and `not()` in sequence to build more complex predicates.

```java
XPathy locator = span.byText().contains("Discount")
                     .and()
                     .byAttribute(class_).not().equals("expired")
                     .or()
                     .byNumber().greaterThan(50);
// Result:
//span[contains(text(), 'Discount') and not(@class='expired') or number(text()) > 50]
```

**Usage Tips:**

-   Parentheses are automatically handled to preserve correct evaluation order.

-   You can mix attribute, text, number, and style conditions freely.

-   Use `.not()` immediately before `.equals()`, `.contains()`, `.startsWith()`, etc.




✅ With logical operators, XPathy expressions scale from simple attribute checks to full-fledged business rules written in a clear, fluent style.


# D - DOM Navigation

XPathy provides intuitive methods for navigating the DOM tree. These methods allow you to traverse relationships between elements—moving up, down, or sideways—while still chaining into text, attributes, numbers, or styles.

All navigation methods starts with `$` made you easy to extend it with a traversal operator such as `$child()`, `$parent()`, `$ancestor()`, `$descendant()`, `$followingSibling()`, or `$precedingSibling()`.


----------

## 1. `$tag(tag)`

Targets a nested tag under the current element.

```java
XPathy locator = div.byAttribute(class_).equals("container")
                .$tag(button)
                .byText().equals("Submit");

//Result:
//div[@class='container']//button[text()='Submit']
```

----------

## 2. `$child()`

Restricts traversal to **immediate child elements**.

```java
XPathy locator = ul.byAttribute(id).equals("menu")
                .$child()
                .byText().contains("Home");
//Result:
//ul[@id='menu']/child::*[contains(text(), 'Home')]


// Specific child tag
XPathy locator = ul.byAttribute(id).equals("menu")
                .$child(li)
                .byText().contains("Contact");

//Result:
//ul[@id='menu']/child::li[contains(text(), 'Contact')]
```

----------

## 3. `$ancestor()`

Moves upward in the DOM to match **ancestor elements**.

```java
XPathy locator = a.byAttribute(href).contains("profile")
                .$ancestor()
                .byAttribute(id).equals("navbar");
//Result:
//a[contains(@href, 'profile')]/ancestor::*[@id='navbar']


// Specific ancestor tag
XPathy locator = span.byText().equals("Settings")
                .$ancestor(div)
                .byAttribute(class_).equals("dropdown");

//Result:
//span[text()='Settings']/ancestor::div[@class='dropdown']
```

----------

## 4. `$descendant()`

Matches **descendant elements** nested anywhere below the current node.

```java
XPathy locator = section.byAttribute(id).equals("content")
                .$descendant(p)
                .byText().contains("Welcome");

//Result:
//section[@id='content']/descendant::p[contains(text(), 'Welcome')]


// Any descendant
XPathy locator = div.byAttribute(class_).equals("card")
                .$descendant()
                .byAttribute(class_).equals("price");

//Result:
//div[@class='card']/descendant::*[@class='price']
```

----------

## 5. `$parent()` and `$up()`

Navigate **one or more levels up** the DOM.

```java
XPathy locator = span.byText().equals("$19.99")
                .$parent(div)
                .byAttribute(class_).equals("product");

//Result:
//span[text()='$19.99']/parent::div[@class='product']


// Move up multiple levels
XPathy locator = input.byAttribute(name).equals("email")
                .$up(2)
                .byAttribute(id).equals("form-container");

//Result:
//input[@name='email']/../..[@id='form-container']
```

----------

## 6. `$followingSibling()`

Matches siblings that appear **after** the current element.

```java
XPathy locator = label.byText().equals("Username")
                .$followingSibling(input)
                .byAttribute(type).equals("text");

//Result:
//label[text()='Username']/following-sibling::input[@type='text']


// Any following sibling
XPathy locator = h2.byText().equals("Features")
                .$followingSibling()
                .byAttribute(class_).equals("description");

//Result:
//h2[text()='Features']/following-sibling::*[@class='description']
```

----------

## 7. `$precedingSibling()`

Matches siblings that appear **before** the current element.

```java
XPathy locator = li.byText().equals("Contact")
                .$precedingSibling()
                .byText().equals("About");

//Result:
//li[text()='Contact']/preceding-sibling::*[text()='About']


// Specific preceding sibling
XPathy locator = option.byText().equals("Canada")
                .$precedingSibling(option)
                .byText().equals("USA");

//Result:
//option[text()='Canada']/preceding-sibling::option[text()='USA']
```

----------

## 8. Multiple Navigations

XPathy also supports **chaining multiple navigation steps** in sequence to express complex DOM relationships.

```java
XPathy locator = div.byAttribute(id).contains("main-container")
                .$parent()
                .$followingSibling(div)
                .$descendant()
                .byText().contains("Hello World");

//Result:
//div[contains(@id, 'main-container')]/../following-sibling::div/descendant::*[contains(text(), 'Hello World')]

```

----------

✅ With DOM navigation, XPathy makes parent-child, ancestor-descendant, and sibling relationships **explicit, realistic, and chainable** using examples drawn from real-world UIs.


# E - Value Transformations

One of the most powerful features of XPathy is the ability to **transform values** before applying conditions. Transformations make locators more **robust** against variations in casing, whitespace, special characters, numbers, or accented characters.

Transformations are chainable and can be combined in sequence. They apply to the current context (attribute, text, number, or style) before the final predicate (`equals`, `contains`, `startsWith`, etc.) is applied.

----------

## 1. Case Transformations

Import cases:

```java
import static com.xpathy.Case.*;

```

### Ignore Case

```java
XPathy locator = button.byAttribute(id)
                .withCase(IGNORED)
                .contains("login-button");

//Result:
//button[contains(translate(@id, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'login-button')]
```

**Description:** Useful when the `id` attribute can appear in different cases (`Login-Button`, `LOGIN-BUTTON`, etc.). Without this, you’d have to write multiple OR conditions. This makes the locator simpler and case-proof.

**Sample Situation:** A login button has dynamic casing depending on the build pipeline. Instead of maintaining different XPaths, this ensures one locator works for all.

----------

### Force Uppercase

```java
XPathy locator = label.byText()
                .withCase(UPPER)
                .equals("USERNAME");

//Result:
//label[translate(text(), 'abcdefghijklmnopqrstuvwxyz', 'ABCDEFGHIJKLMNOPQRSTUVWXYZ')='USERNAME']
```

**Description:** Normalizes all text to uppercase before comparing. Makes it easy when UI labels are expected to be uppercase, but sometimes come mixed-case.

**Sample Situation:** A form label might appear as `Username`, `USERNAME`, or `UserName`. With transformation, all variations still match.

----------

### Force Lowercase

```java
XPathy locator = div.byAttribute(class_)
                .withCase(LOWER)
                .equals("active");

//Result:
//div[translate(@class, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz')='active']
```

**Description:** Ensures attribute comparison works even when class values vary by case. CSS classes are often lowercase, but some dev teams mix formats.

**Sample Situation:** You’re matching `<div class="Active">` vs `<div class="active">`. This keeps the locator consistent.



## 2. Whitespace Handling

### Normalize Space in Text

```java
XPathy locator = div.byText()
                .withNormalizeSpace()
                .equals("Invalid password");

//Result:
//div[normalize-space(text())='Invalid password']
```

**Description:** Cleans up inconsistent spacing inside text content.

**Sample Situation:** Error messages sometimes appear with odd padding: `"Invalid password"`. This matches regardless of spacing.

----------

## 3. Character Filtering (Keep or Remove)

Import filters:

```java
import static com.xpathy.Only.*;
```

### Keep Only

You can use one / many Only enums listed in the `Only` class inside these transformations.
```java
XPathy locator = span.byText()
                .withKeepOnly(ENGLISH_ALPHABETS)
                .contains("ProductABC");

//Result:
//span[contains(translate(text(), translate(text(), 'abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ', ''), ''), 'ProductABC')]
```

**Description:** Strips everything except letters, ignoring numbers or symbols.

**Sample Situation:** Product titles like `Product-ABC` should still match when you only care about the alphabetic part.

----------

### Keep Only with Multiple `Only` enums

```java
XPathy locator = td.byText()
                .withKeepOnly(ENGLISH_ALPHABETS, NUMBERS)
                .equals("ORD1234");

//Result:
//td[translate(text(), translate(text(), 'abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789', ''), '')='ORD1234']
```

**Description:** Preserves letters and digits, removing symbols or spaces.

**Sample Situation:** Order IDs sometimes render as `ORD-1234` or `ORD 1234`. This transformation makes them match as `ORD1234`.

----------

### Remove Only
Same as `keepOnly()` You can use one / many Only enums listed in the `Only` class inside these transformations.
```java
XPathy locator = span.byText()
                .withRemoveOnly(SPECIAL_CHARACTERS)
                .contains("1999");

//Result:
//span[contains(translate(text(), concat('!@#$%^&*()_+-=[]{}|;:,./<>?`~' , "'", '"'), ''), '1999')]
```

**Description:** Eliminates all the symbols

**Sample Situation:** Prices appear as `$1,999` or `€1.999`. After removing special characters, you can reliably match `1999`.



## 4. Character Translation

```java
XPathy locator = h1.byText()
                .withTranslate("éàè", "eae")
                .contains("Cafe");

//Result:
//h1[contains(translate(text(), 'éàè', 'eae'), 'Cafe')]
```

**Description:** Replaces accented letters with plain equivalents.

**Sample Situation:** The UI shows `Café`, `Cafè`, or `Càfe`. Translating accents ensures all match `Cafe`.

----------

## 5. Combining Multiple Transformations

Transformations can be **stacked** in sequence, and be applied in the order.

```java
XPathy locator = div.byText()
                .withNormalizeSpace()
                .withRemoveOnly(NUMBERS)
                .withTranslate("éàè", "eae")
                .withCase(IGNORED)
                .contains("premium cafe");

//Result:
//div[contains(translate(translate(translate(normalize-space(text()), 'éàè', 'eae'), '0123456789', ''), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'premium cafe')]
```

**Description:** Cleans text thoroughly by trimming, removing numbers, translating accents, and ignoring case.

**Sample Situation:** Product title in UI appears as `" Prémium Café 2024 "` or `"PREMIUM CAFE"`. This locator still matches it reliably.

----------

✅ Transformations are the **critical differentiator** in XPathy. They eliminate brittle locators by normalizing casing, whitespace, characters, and formatting differences automatically, letting you focus on intent rather than string quirks.


# F - Union and Intersect Logical Operations

XPathy goes beyond simple `and()`, `or()`, and `not()` chaining by introducing **union** and **intersect** operations. These allow you to group multiple conditions into clean, reusable blocks, improving readability and reducing parenthesis juggling in complex locators.

----------

## 1. Union (`union(Or...)`)

The `union()` method combines multiple **OR conditions** into a single predicate. Instead of chaining multiple `.or()` calls, you can list them together for clarity.

### Example: Multiple Login Button IDs

```java
XPathy locator = button.byAttribute(id)
                    .union(Or.equals("login-btn"),
                           Or.equals("signin-btn"),
                           Or.contains("auth"));

// Result:
//button[@id='login-btn' or @id='signin-btn' or contains(@id, 'auth')]
```

**Description:** Matches any `<button>` used for logging in, regardless of whether the app calls it `login-btn`, `signin-btn`, or something dynamic like `auth-123`.

**Sample Situation:** Different environments (dev, QA, prod) may use slightly different IDs for the login button. Instead of writing separate locators for each, the union ensures one robust locator works everywhere.

----------

## 2. Intersect (`intersect(And...)`)

The `intersect()` method combines multiple **AND conditions** into one predicate. This is especially useful when you want a field or text to satisfy multiple patterns simultaneously.

### Example: Order Confirmation Messages

```java
XPathy locator = div.byText()
                    .intersect(And.startsWith("Order #"),
                              And.contains("Confirmed"),
                              And.not().contains("Cancelled"));

// Result:
//div[starts-with(text(), 'Order #') and contains(text(), 'Confirmed') and not(contains(text(), 'Cancelled'))]
```

**Description:** Matches any `<div>` showing an order confirmation such as `Order #1234 Confirmed`, but excludes cancelled orders like `Order #1234 Cancelled`.

**Sample Situation:** After placing an order, the app shows confirmation text in different formats. Intersect ensures your test only picks valid confirmed orders.

----------

## 3. Using Transformations with Union and Intersect

Just like with single conditions, you can apply **transformations** inside `union()` and `intersect()`. This makes locators more resilient to variations in casing, spacing, or special characters.

### Example: Union with Transformation for Navigation Tabs

```java
XPathy locator = li.byAttribute(class_)
                    .union(Or.withRemoveOnly(SPECIAL_CHARACTERS).contains("active"),
                           Or.withCase(IGNORED).equals("selected"));

// Result:
//li[contains(translate(@class, concat('!@#$%^&*()_+-=[]{}|;:,./<>?`~\' , '"',"'"), ''), 'active') or translate(@class, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz')='selected']
```

**Sample Situation:** A navigation tab might render with classes like `active!`, `selected`, or `SELECTED`. With transformations, the locator still works consistently.

----------

### Example: Intersect with Transformation for Product Labels

```java
XPathy locator = span.byText()
                    .intersect(And.withNormalizeSpace().contains("Premium"),
                              And.withCase(LOWER).contains("subscription"));

// Result:
//span[contains(normalize-space(text()), 'Premium') and contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'subscription')]
```

**Sample Situation:** Product labels may appear as `Premium SUBSCRIPTION`, `premium subscription`, or `PREMIUM Subscription`. Normalization and case-insensitive comparison ensure all variants match.




----------

✅ With **union** and **intersect**, XPathy makes real-world locators—like login buttons, order confirmations, and product labels—**clean, robust, and transformation-friendly**, while still compiling to pure XPath under the hood.


# G - Nested Logical Conditions

XPathy also supports **nested logical conditions**, allowing you to build deeply structured expressions with combinations of `and()`, `or()`, and `not()`. This makes it possible to represent complex business rules in a way that is both **clear and maintainable**.

----------

## 1. How It Works

Instead of chaining `and()`, `or()`, and `not()` inline, you can use the **`Condition`** helper methods to group multiple conditions explicitly. This helps when certain expressions need parentheses for precedence.

**Import static methods:**

```java
import static com.xpathy.Condition.*;
```

----------

## 2. Example: Nested Login Validation

```java
XPathy locator = div.byCondition(
                and(
                        text().startsWith("Login"),

                        or(
                                text().contains("Button"),
                                attribute(id).contains("auth-btn")
                        ),

                        not(attribute(class_).withCase(IGNORED).contains("disabled"))
                )
        );

// Result:
//div[(starts-with(text(), 'Login')
//      and (contains(text(), 'Button') or contains(@id, 'auth-btn'))
//      and not(contains(translate(@class, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'), 'disabled')))]
```

**Description:**

-   Must start with the word `Login`

-   Must either contain the text `Button` **or** have an ID containing `auth-btn`

-   Must **not** contain the class `disabled` (case-insensitive)


**Sample Situation:** On a login form, the submit button may appear as `Login Button`, `Login`, or even dynamically generated with ID `auth-btn-123`. Sometimes the button is disabled with `disabled` class. This nested locator ensures you only match the correct, enabled login button.



## 3. Example: Product Label with Nested Rules

```java
// Nested Logical Conditions
import static com.xpathy.Condition.*;
XPathy locator = span.byCondition(
                or(
                        text().contains("Premium"),

                        and(
                                attribute(class_).equals("highlight"),
                                attribute(data_testid).contains("featured"),
                                not(text().contains("Expired"))
                        )
                )
        );

// Result:
//span[
//   contains(text(), 'Premium')
//   or (
//       @class='highlight'
//       and contains(@data-testid, 'featured')
//       and not(contains(text(), 'Expired'))
//   )
//]

```

**Description:**

-   Matches `<span>` elements that either contain the word `Premium` **OR**

-   Have class equal to `highlight`, a `data-testid` containing `featured`, and text that does not contain `Expired`.


**Sample Situation:** In an e-commerce site, premium products may be labeled with the word `Premium` in the text, or tagged structurally with a `highlight` class and `data-testid` attribute like `featured-product`. Expired promotions should be excluded. This nested locator ensures your tests target only valid premium or featured product labels.---


## 4. Benefits of Nested Conditions

-   **Clarity**: Explicit parentheses in code mirror how the XPath will evaluate.

-   **Maintainability**: Easy to add or remove conditions without breaking the structure.

-   **Flexibility**: Supports mixing attributes, text, styles, and transformations.

-   **Accuracy**: Guarantees correct precedence when combining multiple conditions.


----------

✅ With nested logical conditions, XPathy can model **real-world business rules** like enabled login buttons or valid product labels in a fluent, readable style while generating precise XPath expressions.

# H - Having Operations

XPathy introduces **Having operations**, which allow you to define conditions on **related elements** (child, parent, ancestor, sibling, etc.) inside the same expression. This eliminates the need to manually switch context, while keeping locators expressive and precise.

The `byHaving()` method acts as a **predicate builder**, where you can inject another XPathy object or specify traversal operators like `child`, `descendant`, `ancestor`, etc.

----------

## 1. Basic Having with Direct Condition

```java
XPathy locator = div.byAttribute(class_).equals("product-card").and()
                .byHaving(
                         span.byText().contains("In Stock")
                         );

// Result:
//div[@class='product-card' and ( span[contains(text(), 'In Stock')] )]
```

**Description:** Selects `<div class="product-card">` elements **only if they contain a `<span>` with text containing "In Stock"**.

**Sample Situation:** Useful when filtering product cards that explicitly show availability labels.

----------

## 2. Having with Child

```java
XPathy locator = table.byHaving().child(
                  tr.byAttribute(class_).equals("total-row")
                  );

// Result:
//table[( ./tr[@class='total-row'] )]
```

**Description:** Matches an `<table>` if it has a **direct child row** with the class `total-row`.

**Sample Situation:** Ensures the order summary table contains a row summarizing the total.

----------

## 3. Having with Descendant

```java
XPathy locator = section.byAttribute(id).equals("checkout").and()
                .byHaving().descendant(
                      button.byText().contains("Place Order")
                      );

// Result:
//section[@id='checkout' and ( .//button[contains(text(), 'Place Order')] )]

```

**Description:** Matches a `<section id="checkout">` if **any nested descendant button** contains the text "Place Order".

**Sample Situation:** Ensures the checkout section contains the final purchase button.

----------

## 4. Having with Ancestor

```java
XPathy locator = div.byAttribute(class_).equals("price-tag").and()
                .byHaving().ancestor(
                       section.byAttribute(id).equals("product-details")
                       );

// Result:
//div[@class='price-tag' and ( ancestor::section[@id='product-details'] )]

```

**Description:** Matches `<div class="price-tag">` only if it has a **`<section>` ancestor** with `id="product-details"`.

**Sample Situation:** Useful when price elements appear in multiple contexts, but you only want those tied to the product details section.

----------

## 5. Having with Parent

```java
XPathy locator = ul.byAttribute(class_).equals("menu-items").and()
                .byHaving().parent(
                      nav.byAttribute(role).equals("navigation")
                      );

// Result:
//ul[@class='menu-items' and ( parent::nav[@role='navigation'] )]

```

**Description:** Matches `<ul class="menu-items">` only if its **immediate parent `<nav>`** has the role `navigation`.

**Sample Situation:** Ensures you are selecting menu items that belong to the main navigation bar.

----------

## 6. Having with Following Sibling

```java
XPathy locator = h2.byText().equals("Features").and()
                .byHaving().followingSibling(
                       div.byAttribute(class_).equals("description")
                       );

// Result:
//h2[text()='Features' and ( following-sibling::div[@class='description'] )]

```

**Description:** Matches `<h2>` with text "Features" only if a **following sibling div** has class `description`.

**Sample Situation:** Useful when feature headers are always followed by a descriptive block.

----------

## 7. Having with Preceding Sibling

```java
XPathy locator = li.byText().equals("Contact").and()
                .byHaving().precedingSibling(
                     li.byText().equals("About")
                     );

// Result:
//li[text()='Contact' and ( preceding-sibling::li[text()='About'] )]

```

**Description:** Matches `<li>` with text "Contact" only if a **preceding sibling li** contains "About".

**Sample Situation:** Ensures the navigation order is About → Contact.

----------

## 8. Having with Simplified workflow

```java
XPathy locator = table.byAttribute(id).equals("invoice").and()
                .byHaving().child(td).byText().contains("Subtotal");

// Result:
//table[@id='invoice' and ./td[contains(text(), 'Subtotal')]]

```

**Description:** Matches `<table id="invoice">` if it contains a **direct `<td>` child** with text "Subtotal".

**Sample Situation:** Ensures invoices include a subtotal cell before calculating totals.

----------

## 9. General Benefits

-   **Readability:** Express complex DOM relationships inline without writing full XPath manually.

-   **Flexibility:** Mix with transformations (`withCase`, `withRemoveOnly`, etc.) for resilient conditions.

-   **Reusability:** You can insert any XPathy expression into `byHaving()`.


----------

✅ With **Having operations**, XPathy allows conditions to be written on related elements — child, parent, ancestor, descendant, or siblings — while keeping expressions structured and business-readable.

# 🎯 Conclusion

XPathy turns brittle, hand-written XPath into a fluent, readable DSL that scales with your UI and your team. From attribute/text/number/style contexts to robust value transformations, DOM navigation, logical composition (and/or/not, union/intersect), nested conditions, and **Having** operations—everything is designed to express *intent* clearly while compiling to pure XPath under the hood. The result is faster authoring, easier reviews, fewer flaky locators, and a test suite you can actually trust.



### 🤝 Contributing

Issues, ideas, and PRs are welcome! Share real-world cases where XPathy simplified your locators, or propose new operators/transformations you’d love to see. Clear repros and before/after snippets help a ton.

### 💬 Support & Feedback

If something feels clunky or you’ve got a “there must be a nicer way” moment—open an issue. XPathy grows best with practical feedback from active test suites.

### 🙌 Thanks

Thanks to everyone building reliable UI tests and pushing for clearer, more maintainable code. Your feedback shapes XPathy’s roadmap.



### Made with ❤️ by  **Volta Jebaprashanth**
📧 [voltajeba@gmail.com](mailto:voltajeba@gmail.com)
🔗 [LinkedIn](https://www.linkedin.com/in/voltajeba)

---

Happy Testing with XPathy! 🚀



