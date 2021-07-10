package Classes;

public class User {

    private String username,password;
    private int phoneNumber;

    public void setUsername(String name){
        this.username=name;
    }

    public String getUsername(){
        return username;
    }

    public void setPassword(String pass){
        this.password=pass;
    }

    public String getPassword(){
        return password;
    }

    public  void setPhoneNumber(int pNo){
        this.phoneNumber=pNo;
    }

    public int getPhoneNumber(){
        return phoneNumber;
    }



}
