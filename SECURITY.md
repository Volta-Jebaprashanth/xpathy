# Security Policy

## Supported Versions

XPathy follows semantic-ish versioning on the `3.x` line. Only the latest published release on [JitPack](https://jitpack.io/#Volta-Jebaprashanth/xpathy) receives security fixes.

| Version | Supported          |
| ------- | ------------------ |
| 3.0.x   | :white_check_mark: |
| < 3.0   | :x:                |

## Reporting a Vulnerability

XPathy is a compile-time XPath string builder with no network, filesystem, or reflection-based execution, so its attack surface is small. That said, if you believe you've found a security issue (for example, a way crafted input could lead to XPath/expression injection when building locators from untrusted strings), please report it privately rather than opening a public issue:

- Email: **voltajeba@gmail.com**

Please include:

- A description of the issue and its potential impact
- Steps to reproduce, ideally a minimal code snippet using the XPathy API
- The XPathy version and Java version you're using

You can expect an initial response within a few days. Once a fix is available, it will be released and credited in the release notes unless you request otherwise.

Please do not disclose the issue publicly until a fix has been released.

