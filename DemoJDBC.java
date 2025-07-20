import java.sql.*;

public class DemoJDBC {
    public static void main(String[] args) throws Exception{
        /*
        import the packages
        load and register
        create connection
        create statement
        execute statement
        process the result
        close
        */
        String url = "jdbc:postgresql://localhost:5432/students";
        String uname = "postgres";
        String pass = "421302";
        String sql = "select * from student";

//        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection(url, uname, pass);
        System.out.println("connection established");
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
//        rs.next();

//       String name =rs.getString("sname");
//       System.out.println("Name of the Student " +name);
        while(rs.next()){
            System.out.println(rs.getInt(1) + " - ");
            System.out.println(rs.getString(2) + " - ");
            System.out.println(rs.getInt(3));


        }

        con.close();
        System.out.println("Connection closed");




    }
}
