package db;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public  Connection con;

    protected String DBNAME="clinic";
    protected String DBUSER="root";
    protected String DBPASSWORD="";
    protected String DBSERVER="jdbc:mysql://localhost/" + DBNAME;

    public Connection getConnection(){

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con= DriverManager.getConnection(DBSERVER,DBUSER,DBPASSWORD);
//            System.out.println("success");
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return con;
    }

}
