# AGENTS.md

Guidance for AI coding agents (Claude Code, Copilot, Cursor, etc.) working in this repository.

## Project Overview

XPathy is a Java library that builds XPath expressions via a fluent API, primarily for use as Selenium `By` locators. It has no runtime framework dependencies — Selenium is an *optional* Maven dependency used only so `XPathy.getLocator()` can return a `By`. The core value of the library is the exact string it produces, so treat generated XPath output as a public contract.

## Build & Test

```bash
mvn clean install     # full build
mvn test               # run the JUnit 5 suite
mvn -q -DforceStdout help:evaluate -Dexpression=project.version   # current version
```

There is no linter or formatter config in this repo — match the existing style of the file you're editing.

## Architecture

- `src/main/java/com/xpathy/` — all production code, single package.
- `src/test/java/com/xpathy/unitTests/` — JUnit 5 tests, one class per feature area (e.g. `AttributeTest`, `OrTest`, `HavingTextTest`).
- Public entry points: `Attribute`, `Tag`, `Text`, `Style`, `And`, `Or`, `Expressions`, `XPathy`.
- Classes prefixed with `_` or `__` (e.g. `_Attribute_`, `_Condition_Text_`, `__Having_Number_`) are **internal builder-state implementation classes** backing the fluent chains. They are not part of the public API — do not add new public methods there without checking whether the change belongs on a public-facing class instead.
- The fluent chains work by each step returning a new builder type that narrows what can be called next (e.g. `Attribute.id` → `.contains(...)` → an `_Attribute_` instance → `.and()`/`.or()` → next condition). When adding a new operation, follow the existing narrowing pattern rather than adding a catch-all method to a broad type.

## Conventions

- HTML attribute/tag names that collide with Java keywords get a trailing underscore (`class_`, `for_`).
- Don't change existing generated XPath strings for existing public methods except to fix a genuine bug — downstream consumers rely on exact output. If you must change output, call it out explicitly and add/update tests asserting the new string.
- Every behavior change needs a corresponding test asserting the exact XPath string produced.
- Follow the commit style already used in this repo's history: `feat:`, `fix:`, `docs:`, `refactor:`, `test:`, `chore:`, `ci:`.
- `pom.xml` version, JitPack badge/links, and README installation snippet must stay in sync — but version bumps are a maintainer/release action, not something to do incidentally while fixing a bug.

## What Not to Touch

- `target/` is build output — never hand-edit or commit anything there.
- Don't add new required (non-optional) runtime dependencies; XPathy is meant to stay lightweight and Selenium-version-agnostic (compatible with Selenium 3.0+).
- Don't remove or repurpose the `optional` flag on the Selenium dependency in `pom.xml`.

## Related Projects

XPathy is part of a small ecosystem (see README): a browser Chrome Extension and a local `xpathy-server` (Spring Boot) that both consume this library's output. Changes to public XPath generation behavior can have downstream effects on those projects even though they live in separate repos.
