import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Mysql {
    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();//加载驱动程序
            //MYSQL驱动
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Mysql", "root", "123"); //链接本地MYSQL
            System.out.print("yes");
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
        return con;
    }
    public static void insert(){
        Connection connection = getConnection();
        try {
            String sql = "INSERT INTO TABLENAME(COLUMN1, COLUMN2, COLUMN3)" +
                    "VALUES('TOM', '123456', '910499019@qq.com')";
            Statement statement = connection.createStatement();
            int cout = statement.executeUpdate(sql);
            System.out.println("向数据库插入了" + cout + "条信息");
            connection.close();
        }catch(Exception e){
            System.out.println(e.getStackTrace());
        }
    }
}
