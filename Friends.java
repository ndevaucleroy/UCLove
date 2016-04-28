package lsinf1225.uclove;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * Write a description of class Friends here.
 *
 * @author Groupe P
 * @version 25.04.2016
 */
public class Friends
{
    // instance variables
    private String listOwnerStr;
    private ArrayList<String> friendsListStr;
    private ArrayList<String> recFriendsRequestsStr;
    private ArrayList<String> sentFriendsRequestsStr;
    //private User[] friendsListUsr;  //on veut qu'il se delete des qu'on l'utilise plus, car des users ca prend de la mémoire
    /*private Chat friendChat;*/

    /**
     * Constructor for objects of class Friends
     */

    public Friends(String listOwnerStr, boolean alreadyCreated){
     if(alreadyCreated){
         this.listOwnerStr = listOwnerStr;
         this.friendsListStr = null;
         this.recFriendsRequestsStr = null;
         this.recFriendsRequestsStr = null;
     }
     else{
         this.listOwnerStr = listOwnerStr;
         this.friendsListStr= new ArrayList<String>(Arrays.asList(DatabaseHandler.getFriends(listOwnerStr)));
         this.recFriendsRequestsStr= new ArrayList<String>(Arrays.asList(DatabaseHandler.getRecFriendsRequests(listOwnerStr)));
         this.sentFriendsRequestsStr = new ArrayList<String>(Arrays.asList(DatabaseHandler.getRecFriendsRequests(listOwnerStr)));
     }

    }
    public Friends(){}

    public boolean sendFriendRequest(String target){ //sends true if worked, sends false if it was already a friend
        if(sentFriendsRequestsStr.contains(target)){
        return false;    
        }
        sentFriendsRequestsStr.add(target);
        DatabaseHandler.addFriendRequest(listOwnerStr, target);
        return true;
    }
    public void acceptFriendRequest(String target){
        recFriendsRequestsStr.remove(target);
        friendsListStr.add(target);
        DatabaseHandler.addFriend(listOwnerStr, target);
        
    }

    public String getListOwnerStr() {
        return listOwnerStr;
    }

    public String[] getFriendsListStr() {
        return friendsListStr.toArray();
    }

    public String[] getRecFriendsRequestsStr() {
        return recFriendsRequestsStr.toArray();
    }

    public String[] getSentFriendsRequestsStr() {
        return sentFriendsRequestsStr.toArray();
    }

    public User[] getFriendsListUsr() { //on load les users
        User []friendsListUsr = new User[friendsListStr.size()];
        for(int i = 0;i < friendsListStr.size();i++){
            friendsListUsr[i] = new User(friendsListStr.get(i));
        }
        return friendsListUsr;
    }


}
