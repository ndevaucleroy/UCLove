package lsinf1225.uclove;

/**
 * Created by eizanprime on 29.04.16.
 */
public static class Research {


    public String makePersonalRequest(User user) {
        String request = "";
        // Test de la couleur des cheveux.
        if(user.getHair()[0]) {
            request += "hair = 'black' and ";
        }
        if(user.getHair()[1]) {
            request += "hair = 'blond' and ";
        }
        if(user.getHair()[2]) {
            request += "hair = 'brown' and ";
        }
        if(user.getHair()[3]) {
            request += "hair = 'other' and ";
        }
        if(user.getHair()[4]) {
            request += "hair = 'red' and ";
        }
        // Test de la couleur des yeux.
        if(user.getEyes()[0]) {
            request += "eyes = 'black' and ";
        }
        if(user.getEyes()[1]) {
            request += "eyes = 'blue' and ";
        }
        if(user.getEyes()[2]) {
            request += "eyes = 'brown' and ";
        }
        if(user.getEyes()[3]) {
            request += "eyes = 'green' and ";
        }
        // Test de la même localite
        if(user.getSamePlace()) {
            request = request + "place = " + login.getPlaceStr() + " and ";
        }
        // Test de l'age
        request = request + "" + user.getAgeMin() + " < (JulianDay('now')) - (julianday(birthday)) < " + ageMax;
        // Test du genre et de la sexualite
        char sexe = (user.getGenderStr()).charAt(0);
        char pref = (user.getOrientationStr()).charAt(0);
        if(pref != 'B') {
            request += "gender = '" + pref + "' and ";
        }
        request += "(orientation = 'B' or orientation = '" + sexe + "')";

        return request;
    }
}
