package lsinf1225.uclove;


/**
 * Write a description of class Chat here.
 *
 * @author Groupe P
 * @version 25.04.2016
 */
public class Chat
{
    // instance variables - replace the example below with your own
    private String friend1;
    private String friend2;
    private String chatHistory;

    /**
     * Constructor for objects of class Chat
     */
    public Chat(String friend1, String friend2, String chatHistory){
        // initialise instance variables
        this.friend1 = friend1;
        this.friend2 = friend2;
        this.chatHistory = chatHistory;
    }

    public Chat(String friend1, String friend2) {
        this.friend1 = friend1;
        this.friend2 = friend2;
    }

    public String getFriend1() {
        return friend1;
    }
    public String getFriend2() {
        return friend2;
    }


    public String getChatHistory() {
        return chatHistory;
    }

    public void setChatHistory(String chatHistory) {
        this.chatHistory = chatHistory;
    }
    public void sendMessage(String message, String friend){
        //TODO fucking date !
        this.chatHistory += "b;" + friend + "c;" + message.replaceAll(";", "/;")
                + "d;";
    }
}
