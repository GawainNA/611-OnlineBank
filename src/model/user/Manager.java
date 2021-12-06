package model.user;

/** 
 * Singleton (only one manager)
 */
public class Manager extends User{
    private static Manager manager;

    private Manager(String username, UserGender gender, String passwd, String address, String phoneNum) {
        super(username, gender, passwd, address, phoneNum);
        //TODO Auto-generated constructor stub
    }

    public static Manager getInstance() {
        // TODO:

        return null;
    }

}