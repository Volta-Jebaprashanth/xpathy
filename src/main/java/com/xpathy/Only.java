package com.xpathy;

public enum Only {

    // Alphabets
    ENGLISH_ALPHABETS("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"),
    LOWERCASE_ALPHABETS("abcdefghijklmnopqrstuvwxyz"),
    UPPERCASE_ALPHABETS("ABCDEFGHIJKLMNOPQRSTUVWXYZ"),

    // Numbers
    NUMBERS("0123456789"),
    NUMBERS_AND_DECIMALS("0123456789."),

    // Whitespace
    SPACES(" "),
    TABS("\t"),
    NEWLINES("\n\r"),

    // Common punctuation and symbols
    BASIC_PUNCTUATION(".,:;!?"),
    QUOTES("'\""),
    BRACKETS("()[]{}<>"),
    MATH_SYMBOLS("+-*/=<>"),
    CURRENCY_SYMBOLS("$€£¥₹"),
    OPERATORS("&|^%~"),
    SLASHES("/\\"),
    UNDERSCORE("_"),

    // Special characters (including others)
    SPECIAL_CHARACTERS("!@#$%^&*()_+-=[]{}|;':\",./<>?`~\\"),
    NON_ASCII_PRINTABLE("¡¢£¤¥¦§¨©ª«¬­®¯°±²³´µ¶·¸¹º»¼½¾¿"),

    // Unicode and extended groups (if needed)
    NON_ENGLISH_ALPHABETS("àáâäæãåāčćĉďèéêëēėęîïíīįìłñńôöòóœøōõßśšûüùúūÿýžźż"),
    INVISIBLE_CHARACTERS("\u200B\u200C\u200D\uFEFF"),

    // XML/HTML unsafe characters
    XML_RESERVED("<>&\"'"),

    // Custom control characters
    CONTROL_CHARACTERS(buildControlChars());

    private static String buildControlChars() {
        StringBuilder sb = new StringBuilder();
        for (char c = 0x00; c <= 0x1F; c++) {
            sb.append(c);
        }
        sb.append((char) 0x7F);
        return sb.toString();
    }

    private final String chars;

    Only(String chars) {
        this.chars = chars;
    }

    public String getChars() {
        return chars;
    }

}
