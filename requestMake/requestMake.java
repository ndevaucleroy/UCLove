public String makeRequest(boolean[] hair, boolean[] eyes, boolean samePlace, int ageMin, int ageMax, User login) {
        String request = "";
        // Test de la couleur des cheveux.
        if(hair[0]) {
            request += "hair = 'black' and "; 
        }
        if(hair[1]) {
            request += "hair = 'blond' and "; 
        } 
        if(hair[2]) {
            request += "hair = 'brown' and ";
        }
        if(hair[3]) {
            request += "hair = 'other' and ";
        }
        if(hair[4]) {
            request += "hair = 'red' and ";
        }
        // Test de la couleur des yeux.
        if(eyes[0]) {
            request += "eyes = 'black' and "; 
        }
        if(eyes[1]) {
            request += "eyes = 'blue' and "; 
        } 
        if(eyes[2]) {
            request += "eyes = 'brown' and ";
        }
        if(eyes[3]) {
            request += "eyes = 'green' and ";
        }
        // Test de la même localite
        if(samePlace) {
           request = request + "place = " + login.getPlaceStr() + " and ";
        }
        // Test de l'age
        request = request + "" + ageMin + " < (JulianDay('now')) - (julianday(birthday)) < " + ageMax;
        // Test du genre et de la sexualite
        char sexe = (login.getGendersStr()).charAt(0);
        char pref = (login.getOrientationStr()).charAt(0);
        if(pref != 'B') {
            request += "gender = '" + pref + "' and ";
        }
        request += "(orientation = 'B' or orientation = '" + sexe + "')";
        
        return request;
    }
