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
    private User friend;
    private String chatHistory;

    /**
     * Constructor for objects of class Chat
     */
    public Chat(User friend, String chatHistory){
        // initialise instance variables
        this.friend = friend;
        this.chatHistory = chatHistory;
    }

    public Chat() {}

    public User getFriend() {
        return friend;
    }

    public void setFriend(User friend) {
        this.friend = friend;
    }

    public String getChatHistory() {
        return chatHistory;
    }

    public void setChatHistory(String chatHistory) {
        this.chatHistory = chatHistory;
    }
}
