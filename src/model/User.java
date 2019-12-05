package model;

public class User extends Person {
    private String accountName;
    private String password;
    private Role userRole;

    public void setEmail(String email){
        this.accountName = email;
    }

    public String getAccountName(){
        return accountName;
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

    public User(String firstName,String lastName,String mobileNo,String email,String accountName, String password,Role role){
        super.setFirstName(firstName);
        super.setLastName(lastName);
        super.setMobileNo(mobileNo);
        super.setEmail(email);
        this.password = password;
        this.accountName = accountName;
        this.userRole = role;
    }

}
