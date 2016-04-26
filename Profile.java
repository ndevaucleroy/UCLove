package lsinf1225.uclove;


/**
 * Write a description of class Profil here.
 *
 * @author Groupe P
 * @version 25.04.2016
 */
public class Profile
{
    // instance variables - replace the example below with your own
    private String birthDate;
    private String description;
    private String address;
    private Album album;

    /**
     * Constructor for objects of class Profil
     */
    public Profile(String birthDate, String description, String address, Album album)
    {
        // initialise instance variables
        this.birthDate = birthDate;
        this.description = description;
        this.address = address;
        this.album = album;
    }

    public Profile(){}

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
}
