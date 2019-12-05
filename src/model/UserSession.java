package model;

public final class UserSession {
    private static UserSession userSession;
    private static String email;
    private static Role role;

    public UserSession(String email, Role role) {
        this.email = email;
        this.role = role;
    }

    public static String getEmail() {
        return email;
    }

    public static Role getRole() {
        return role;
    }

    public static void setUserSession(String email, Role role) {
        userSession = new UserSession(email,role);
    }

    public static UserSession getUserSession() {
        return userSession;
    }

    public void clearSession(){
        email=null;
        role=null;
        userSession=null;
    }
}
