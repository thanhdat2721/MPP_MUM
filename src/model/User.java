package model;

public class User {
    private String email;
    private String password;
    private Role userRole;

    public void setEmail(String email){
        this.email = email;
    }

    public String getEmail(){
        return email;
    }
    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return password;
    }

    public void setRole(Role role){
        this.userRole = role;
    }

    public Role userRole(){
        return userRole;
    }

    public User(String email, String password,Role role){
        this.password = password;
        this.email = email;
        this.userRole = role;
    }

}
