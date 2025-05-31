package com.xpathy;

public class _TranslateBuilder_ {

    protected XPathy xPathy;

    protected _TranslateBuilder_(XPathy xPathy){
        this.xPathy = xPathy;
    }

    protected XPathy setCase(Case thisCase){
        XPathy copy = this.xPathy.copy();

        copy.thisCase = thisCase;

        return copy;
    }


    protected XPathy setRemoveChars(Only... onlyItems) {
        XPathy copy = this.xPathy.copy();

        StringBuilder sb = new StringBuilder(copy.removeChars != null ? copy.removeChars : "");
        for (Only only : onlyItems) {
            sb.append(only.getChars());
        }
        copy.removeChars = sb.toString();

        return copy;
    }

    protected XPathy setKeepOnlyChars(Only... onlyItems) {
        XPathy copy = this.xPathy.copy();

        StringBuilder sb = new StringBuilder(copy.keepOnlyChars != null ? copy.keepOnlyChars : "");
        for (Only only : onlyItems) {
            sb.append(only.getChars());
        }
        copy.keepOnlyChars = sb.toString();

        return copy;
    }



    protected XPathy setTranslate(String charactersToReplace, String replacementCharacters){
        XPathy copy = this.xPathy.copy();

        copy.translate_charactersToReplace = charactersToReplace;
        copy.translate_replacementCharacters = replacementCharacters;

        return copy;
    }



}
