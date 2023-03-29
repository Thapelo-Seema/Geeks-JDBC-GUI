import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.protocol.Resultset;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionClass {
    public String username;
    public String password;
    public String url = "jdbc:mysql://localhost:3306/geeksdb";
    public String query;
    public ConnectionClass(String username, String password, String query){
        this.username = username;
        this.password = password;
       // this.url = url;
        this.query = query;
    }

    public static void isDriverWorking() throws SQLException{
        try{
          Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public void runQuery()throws SQLException{
        //use a try-with-resources to ensure the resources are released
        try(Connection conn = DriverManager.getConnection(this.url, this.username, this.password);
            Statement statement = conn.createStatement();
            ResultSet results  = statement.executeQuery(this.query)){

            while(results.next()){
                int geekId = results.getInt("geek_id");
                String firstName = results.getString("first_name");
                String lastName = results.getString("last_name");
                String geekRole = results.getString("geek_role");
                System.out.println(firstName + ", " + lastName + ", " + geekRole);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }


}
