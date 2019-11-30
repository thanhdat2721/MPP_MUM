package model;

public class User {
    private String email;
    private String password;
    private int role;

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

    public void setRole(int role){
        this.role = role;
    }

    public int getRole(){
        return role;
    }

    public User(String email, String password,int role){
        this.password = password;
        this.email = email;
        this.role = role;
    }

}
