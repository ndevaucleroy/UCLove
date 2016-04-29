package lsinf1225.uclove;

/**
 * Created by Guillaume on 29/04/16.
 */
public class Score {

    private User loginGive;
    private User loginGet;
    private int quotation;

    // Constructeur
    public Score(User loginGive, User loginGet, int quotation) {
        this.loginGive=loginGive;
        this.loginGet=loginGet;
        this.quotation=quotation;
    }

    public User getLoginGive() {
        return loginGive;
    }

    public void setLoginGive(User loginGive) {
        this.loginGive = loginGive;
    }

    public User getLoginGet() {
        return loginGet;
    }

    public void setLoginGet(User loginGet) {
        this.loginGet = loginGet;
    }

    public int getQuotation(int quotation) {
        return quotation;
    }

    public void setQuotation(int quotation) {
        this.quotation = quotation;
    }
} // class Score
