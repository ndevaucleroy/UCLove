package lsinf1225.uclove;


/**
 * Write a description of class Friends here.
 *
 * @author Groupe P
 * @version 25.04.2016
 */
public class Friends
{
    // instance variables
    private User friend;
    private User sendFriendRequest;
    private User receivedFriendRequest;
    /*private Chat friendChat;*/

    /**
     * Constructor for objects of class Friends
     */
    public Friends(User friend, User sendFriendRequest, User receivedFriendRequest /*,Chat friendChat*/)
    {
        this.friend = friend;
        this.sendFriendRequest = sendFriendRequest;
        this.receivedFriendRequest = receivedFriendRequest;
    }

    public Friends(){}

}
