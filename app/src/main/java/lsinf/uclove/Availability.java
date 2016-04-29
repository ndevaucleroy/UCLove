package lsinf1225.uclove;

/**
 * Class Availability
 * Created by Guillaume on 29/04/16.
 */
public class Availability {
    private String login;
    private String date;

    // Constructeur
    public Availability(String login, String date) {
        this.login = login;
        this.date = date;
    }

    public Availability(){

    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getDate(){
        return date;
    }

    public void setDate() {
        this.date = date;
    }
}
