import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String un = "root";
        String pw = "#Nuclear@73";
        String query = "select * from Geeks";
       ConnectionClass cc = new ConnectionClass(un, pw, query);
       try{
           cc.runQuery();
       }catch(SQLException e){
           e.printStackTrace();
       }

    }
}