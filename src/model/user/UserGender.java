package model.user;

import model.Persistable;

public enum UserGender implements Persistable {
    MALE("male"),
    FEMALE("female"),
    UNDEFINE("");

    private String gender;

    private UserGender(String gender) {
        this.gender = gender;
    }

    public String UserGender2Str() {
        return this.gender;
    }

    public static UserGender Str2UserGender(String gender) {
        if("male".equalsIgnoreCase(gender)) {
            return MALE;
        } else if("female".equalsIgnoreCase(gender)) {
            return FEMALE;
        } else {
            return UNDEFINE;
        }
    }
}
