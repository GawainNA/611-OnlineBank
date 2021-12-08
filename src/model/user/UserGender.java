package model.user;

public enum UserGender {
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

    public UserGender Str2UserGender(String gender) {
        if("male".equalsIgnoreCase(gender)) {
            return MALE;
        } else if("female".equalsIgnoreCase(gender)) {
            return FEMALE;
        } else {
            return UNDEFINE;
        }
    }
}
