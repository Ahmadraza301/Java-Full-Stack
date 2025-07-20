import java.sql.*;

public class DemoJDBC {
    public static void main(String[] args) throws Exception {
        int sid = 101;
        String sname = "yasmin khan";
        int marks = 88;

        String url = "jdbc:postgresql://localhost:5432/students";
        String uname = "postgres";
        String pass = "421302";
        String sql = "insert into student values (?, ?, ?)";

        Connection con = DriverManager.getConnection(url, uname, pass);
        PreparedStatement st = con.prepareStatement(sql);

        st.setInt(1, sid);      // Set 1st parameter (sid)
        st.setString(2, sname); // Set 2nd parameter (sname)
        st.setInt(3, marks);    // Set 3rd parameter (marks)

        st.executeUpdate();

        st.close();
        con.close();
    }
}