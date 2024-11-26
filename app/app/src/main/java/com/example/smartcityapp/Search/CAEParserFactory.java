package com.example.smartcityapp.Search;

/**
 * The factory method is used to replace if-else to achieve the extensibility of CaeEXP.
 * if new classes are added in the future,
 * only new classes need to be added without modifying the past code.
 *
 * author: Zhizhao Sun  (u7799455)
 */
public class CAEParserFactory {
    public static EXP getParser(String value) {
        switch (value.toLowerCase()) {
            case "type":
                return new TypeEXP();
            case "participants":
                return new ParticipantsEXP();
            case "date":
                return new DateEXP();
            default:
                throw new Token.IllegalTokenException("invalid category");
        }
    }
}
