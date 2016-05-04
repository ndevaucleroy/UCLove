package lsinf1225.uclove;

/** 
 * Created by Guillaume on 29/04/16.
 */
public class Score {

    private String loginGive;
    private String loginGet;
    private int quotation;

    // Constructeur
    public Score(String loginGive, String loginGet, int quotation) {
        this.loginGive=loginGive;
        this.loginGet=loginGet;
        this.quotation=quotation;
    }

    public Score() {
    }

    public String getLoginGive() {
        return loginGive;
    }

    public void setLoginGive(String loginGive) {
        this.loginGive = loginGive;
    }

    public String getLoginGet() {
        return loginGet;
    }

    public void setLoginGet(String loginGet) {
        this.loginGet = loginGet;
    }

    public int getQuotation() {
        return quotation;
    }

    public void setQuotation(int quotation) {
        this.quotation = quotation;
    }
} // class Score
