package Classes;

import java.time.LocalDate;
import java.util.regex.Pattern;

public class Patient {
    private String name,nic,homeNo,streetName, City, sex, phoneNumber;
    private LocalDate dob;

    String textPattern="^[a-zA-Z]+$";
    String phoneNoPattern="^[0-9]{10}$";
    String nicPattern="^([0-9]{9}[x|X|v|V]|[0-9]{12})$";
    public void setName(String name){
        if(Pattern.matches(textPattern,name)){
            this.name= name;
        }

    }
    public String getName(){
        return name;
    }

    public void setNic(String nic){
        if(Pattern.matches(nicPattern,nic)) {
            this.nic = nic;
        }
    }
    public String getNic(){
        return nic;
    }

    public void setHomeNo(String homeNo){
        this.homeNo= homeNo;
    }
    public String getHomeNo(){
        return homeNo;
    }

    public void setStreetName(String streetName){
        if(Pattern.matches(textPattern,streetName)) {
            this.streetName = streetName;
        }
    }
    public String getStreetName(){
        return streetName;
    }

    public void setCity(String city){
        if(Pattern.matches(textPattern,city)) {
            this.City = city;
        }
    }
    public String getCity(){
        return City;
    }

    public void setPhoneNumber(String pNo){
        if(Pattern.matches(phoneNoPattern,pNo)) {
            this.phoneNumber = pNo;
        }
    }
    public String getPhoneNumber(){
        return phoneNumber;
    }

    public void setSex(String sex){
        this.sex=sex;
    }

    public String getSex(){
        return sex;
    }

    public void setDob(LocalDate dob){
        this.dob=dob;
    }

    public LocalDate getDob(){
        return dob;
    }
}
