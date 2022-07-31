package helper;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBUtils {
    public static List<String> getDataFromDB(String query) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","admin");
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
       List<String> namelist = new ArrayList<>();

        while(rs.next()){
            namelist.add(rs.getString("Name"));
        }
        return namelist;
    }
}
