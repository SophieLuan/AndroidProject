package com.example.smartcityapp.Search;



import com.example.smartcityapp.loadData.DataActivity;

/** Grammars:
 *  <exp> : : = <term> | <term> AND <exp> | <term> OR <exp>
 *  <term> : : = <category> "=" <str>
 *  <category> : : = "type" | "participants"  | "date"
 *  <str> : : = string | integer
 *
 * author: Zhizhao Sun (u7799455)
 */

public class Parser {

    Tokenizer tokenizer;
    public Parser(Tokenizer tokenizer) {
        this.tokenizer = tokenizer;
    }
    public boolean parse(DataActivity activity){
        try{
            return parseExp().evaluate(activity);
        }catch (Exception e){
            return false;
        }

    }

    /**
     * <exp> : : = <term> | <term> AND <exp> | <term> OR <exp>
     * @return Parser   */
    public EXP parseExp(){
        try {
            EXP term = parseTerm();
            if (tokenizer.hasNext()) {
                if (tokenizer.current().getType() == Token.Type.AND) {
                    tokenizer.next();
                    EXP exp = parseExp();
                    return new AndEXP(term, exp);
                } else if (tokenizer.current().getType() == Token.Type.OR) {
                    tokenizer.next();
                    EXP exp = parseExp();
                    return new OrEXP(term, exp);
                }
            }
            return term;
        }catch (Exception e){
            tokenizer.next();
            if (tokenizer.hasNext()) {
                return parseExp();
            } else {
                return new NullEXP();
            }
        }
    }

    /**
     * <term> : : = <category> "=" <str>
     * @return Parser   */
    public EXP parseTerm(){
        try{
            if (!tokenizer.hasNext()) {
                throw new IllegalArgumentException("null");
            }
            EXP categoryExp = parseCategory();
            if (tokenizer.current().getType() == Token.Type.EQUAL) {
                tokenizer.next();
            } else {
                throw new Token.IllegalTokenException("missing =");
            }
            EXP strExp = parseStr();
            return new EqualEXP((CaeEXP)categoryExp, (StrEXP)strExp);
        }catch (Exception e){
            tokenizer.next();
            if (tokenizer.hasNext()) {
                return parseTerm();
            } else {
                return new NullEXP();
            }
        }
    }

    /**
     * <category> : : = "type" | "participants"  | "date"
     * @return Parser   */
    public EXP parseCategory(){
        try{
            if (!tokenizer.hasNext()) {
                throw new IllegalArgumentException("null");
            }
            Token token = tokenizer.current();
            if (token.getType() == Token.Type.CAE) {
                String value = token.getToken();
                tokenizer.next();
                return CAEParserFactory.getParser(value);
            } else {
                throw new Token.IllegalTokenException("illegal word");
            }
        }catch (Exception e){
            tokenizer.next();
            if (tokenizer.hasNext()) {
                return parseCategory();
            } else {
                return new NullEXP();
            }
        }
    }

    /**
     * <str> : : = string | integer
     * @return Parser   */
    public EXP parseStr(){
        try{
            if (!tokenizer.hasNext()) {
                throw new IllegalArgumentException("null");
            }
            Token token = tokenizer.current();
            if (token.getType() == Token.Type.STR) {
                tokenizer.next();
                return new StrEXP(token.getToken());
            } else {
                throw new Token.IllegalTokenException("illegal word");
            }
        }catch (Exception e){
            tokenizer.next();
            if (tokenizer.hasNext()) {
                return parseStr();
            } else {
                return new NullEXP();
            }
        }
    }
}
