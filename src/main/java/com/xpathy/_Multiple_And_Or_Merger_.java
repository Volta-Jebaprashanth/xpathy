package com.xpathy;

import java.util.LinkedHashSet;
import java.util.Set;

public class _Multiple_And_Or_Merger_ {

    protected static XPathy merge(XPathy original, XPathy conditionXpathy) {
        if (conditionXpathy == null) {
            conditionXpathy = new XPathy();
        }

        XPathy tempXpathy = original.copy();

        tempXpathy.is_trim |= conditionXpathy.is_trim;
        tempXpathy.is_normalize_space |= conditionXpathy.is_normalize_space;

        if (conditionXpathy.thisCase != null) {
            tempXpathy.thisCase = conditionXpathy.thisCase;
        }

        tempXpathy.removeChars = mergeStrings(tempXpathy.removeChars, conditionXpathy.removeChars);
        tempXpathy.keepOnlyChars = mergeStrings(tempXpathy.keepOnlyChars, conditionXpathy.keepOnlyChars);
        tempXpathy.translate_charactersToReplace = mergeStrings(tempXpathy.translate_charactersToReplace, conditionXpathy.translate_charactersToReplace);
        tempXpathy.translate_replacementCharacters = mergeStrings(tempXpathy.translate_replacementCharacters, conditionXpathy.translate_replacementCharacters);

        return tempXpathy;
    }

    private static String mergeStrings(String original, String addition) {
        if (original == null) return addition;
        if (addition == null) return original;

        Set<Character> merged = new LinkedHashSet<>();
        for (char c : original.toCharArray()) {
            merged.add(c);
        }
        for (char c : addition.toCharArray()) {
            merged.add(c);
        }

        StringBuilder sb = new StringBuilder();
        for (char c : merged) {
            sb.append(c);
        }

        return sb.toString();
    }
}
