package com.xpathy;

import java.util.regex.Pattern;

public class _XPathValueTransformer_ {

    private final XPathy xPathy;

    protected _XPathValueTransformer_(XPathy xPathy) {
        this.xPathy = xPathy;
    }


    private String buildConcat(String charString) {

        if (!charString.contains("'") && !charString.contains("\"")) {
            return "'" + charString + "'";
        } else if (charString.contains("'") && !charString.contains("\"")) {
            return "\"" + charString + "\"";
        } else if (!charString.contains("'") && charString.contains("\"")) {
            return "'" + charString + "'";
        } else {
            String withoutQuotation = charString.replace("'", "").replace("\"", "");
            return "concat('" + withoutQuotation + "'" + " , " + "'\"'" + "," +  "\"'\"" + ")";
        }


    }

    /**
     * Builds a modified XPath function expression (e.g., text() or @attr)
     * with all applied flags in correct order.
     *
     * @param baseFunction "text()" for text nodes, or "@attrName" for attributes
     * @return transformed XPath function string
     */
    protected String buildFunctionExpression(String baseFunction) {
        String function = baseFunction;

        //---------- Trim

        if (xPathy.is_normalize_space) {
            function = "translate(" + function + ", '\u00A0', ' ')";
            function = "normalize-space(" + function + ")";
        } else if (xPathy.is_trim) {
            function = "normalize-space(" + function + ")";
        }

        //---------- Translate
        if (xPathy.translate_charactersToReplace != null && !xPathy.translate_charactersToReplace.isEmpty()) {
            String toReplace = buildConcat(xPathy.translate_charactersToReplace);
            String replacement = buildConcat(xPathy.translate_replacementCharacters);

            function = "translate(" + function + ", " + toReplace + ", " + replacement + ")";
        }

        //---------- Remove Characters
        if (xPathy.removeChars != null && !xPathy.removeChars.isEmpty()) {

            String remove = buildConcat(xPathy.removeChars);
            function = "translate(" + function + ", " + remove + ", '')";
        }

        //---------- Keep Only Characters (using double translate)
        if (xPathy.keepOnlyChars != null && !xPathy.keepOnlyChars.isEmpty()) {

            String keep = buildConcat(xPathy.keepOnlyChars);
            function = "translate(" + function + ", translate(" + function + ", " + keep + ", ''), '')";
        }

        //---------- Case

        if (xPathy.thisCase != null) {
            switch (xPathy.thisCase) {
                case LOWER:
                    function = "translate(" + function + ", 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz')";
                    break;
                case UPPER:
                    function = "translate(" + function + ", 'abcdefghijklmnopqrstuvwxyz', 'ABCDEFGHIJKLMNOPQRSTUVWXYZ')";
                    break;
                case IGNORED:
                    function = "translate(" + function + ", 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz')";
                    break;
            }
        }

        return function;
    }

    /**
     * Applies the same modifiers to a string value for comparison purposes.
     *
     * @param value the value to transform
     * @return transformed value
     */
    protected String applyModifiersToValue(String value) {

        //---------- Trim

        if (xPathy.is_normalize_space) {
            value = value.replace('\u00A0', ' ');
            value = value.trim().replaceAll("\\s{2,}", " ");
        } else if (xPathy.is_trim) {
            value = value.trim();
        }

        //---------- Translate (like XPath)

        if (xPathy.translate_charactersToReplace != null && !xPathy.translate_charactersToReplace.isEmpty()) {
            String source = xPathy.translate_charactersToReplace;
            String target = xPathy.translate_replacementCharacters != null ? xPathy.translate_replacementCharacters : "";
            StringBuilder translated = new StringBuilder();

            for (char c : value.toCharArray()) {
                int index = source.indexOf(c);
                if (index != -1) {
                    // Replace if a corresponding character exists
                    translated.append(index < target.length() ? target.charAt(index) : "");
                } else {
                    translated.append(c);
                }
            }

            value = translated.toString();
        }


        //---------- Remove Characters

        if (xPathy.removeChars != null && !xPathy.removeChars.isEmpty()) {
            for (char c : xPathy.removeChars.toCharArray()) {
                value = value.replace(String.valueOf(c), "");
            }
        }

        //---------- Keep Only Characters

        if (xPathy.keepOnlyChars != null && !xPathy.keepOnlyChars.isEmpty()) {
            value = value.replaceAll("[^" + Pattern.quote(xPathy.keepOnlyChars) + "]", "");
        }

        //---------- Case

        if (xPathy.thisCase != null) {
            switch (xPathy.thisCase) {
                case LOWER:
                    value = value.toLowerCase();
                    break;
                case UPPER:
                    value = value.toUpperCase();
                    break;
                case IGNORED:
                    value = value.toLowerCase();
                    break;
            }
        }


        return value;
    }
}
