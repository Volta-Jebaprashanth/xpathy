package com.xpathy;

public class _Validate {
    protected static boolean isXpathAppendableFor_And_and_Or(String xpath) {
        String trimmed = xpath.trim();
        return !trimmed.matches(".*\\[\\d+\\]$")
                && !trimmed.endsWith("[last()]")
                && (trimmed.endsWith("']") || trimmed.endsWith(")]"));
    }

}
