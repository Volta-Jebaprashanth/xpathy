# Contributing to XPathy

Thanks for your interest in improving XPathy! This document covers how to set up the project, the conventions the codebase follows, and how to submit changes.

## Getting Started

XPathy is a Java library built with Maven. You'll need:

- JDK 11 or higher (CI builds against Java 17; JitPack builds against OpenJDK 11)
- Maven 3.6+

Clone the repo and build:

```bash
git clone https://github.com/Volta-Jebaprashanth/xpathy.git
cd xpathy
mvn clean install
```

Run the test suite:

```bash
mvn test
```

The project has no runtime dependencies beyond an *optional* Selenium API dependency (used only for `By` in `XPathy.getLocator()`) and JUnit 5 for tests.

## Project Structure

```
src/main/java/com/xpathy/   Public API and internal implementation
src/test/java/com/xpathy/unitTests/   JUnit 5 tests
```

XPathy is a fluent-API XPath builder. The public entry points are classes like `Attribute`, `Tag`, `Text`, `Style`, `And`, `Or`, and `XPathy` itself. Most classes prefixed with an underscore (e.g. `_Attribute_`, `_Condition_Text_`, `__Having_`) are internal builder-state classes that back the fluent chains — they are not meant to be used directly by consumers of the library and should stay package-private where possible.

When adding a new attribute or tag constant, follow the existing pattern in `Attribute.java` / `Tag.java` (a private constructor plus `public static final` instances), and add the reserved-word suffix convention (`class_`, `for_`) where the HTML name collides with a Java keyword.

## Making Changes

1. Fork the repo and create a branch off `main` (e.g. `feature/xyz`, `bugfix/xyz`).
2. Write or update unit tests under `src/test/java/com/xpathy/unitTests/` for any behavior change. XPathy is a pure string-building library, so nearly every feature is testable by asserting the generated XPath string.
3. Keep the fluent API's generated XPath output stable unless you're intentionally fixing a bug — downstream users depend on exact string output.
4. Run `mvn test` and make sure everything passes before opening a PR.
5. Follow the existing commit message style used in this repo's history: `feat: ...`, `fix: ...`, `docs: ...`, `refactor: ...`, `test: ...`, `chore: ...`, `ci: ...`.

## Pull Requests

- Keep PRs focused on a single change; unrelated cleanups should be separate PRs.
- Update `README.md` if you add or change public API behavior — it doubles as the user manual.
- Do not bump the version in `pom.xml` or the README badges yourself; maintainers handle releases.
- Describe the XPath output before/after in the PR description when the change affects generated expressions.

## Reporting Bugs / Requesting Features

Please use the GitHub issue templates. For anything that looks like a security issue, see [SECURITY.md](SECURITY.md) instead of opening a public issue.

## Code of Conduct

This project follows the [Code of Conduct](CODE_OF_CONDUCT.md). By participating, you agree to abide by it.
