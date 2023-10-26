import java.sql.*;
import java.util.Scanner;

public class Select {

    public  void execute() {
        String jdbc_driver = "com.mysql.cj.jdbc.Driver";
        String jdbc_url = "jdbc:mysql://localhost:3306/company?company=UTC";

        Scanner s = new Scanner(System.in);

        try {
            Class.forName(jdbc_driver).newInstance();
            Connection connection = DriverManager.getConnection(jdbc_url, "root", "1112");
            System.out.println("테이블의 이름을 입력해주세요");

            String tableName = s.next(); // 테이블 이름을 입력받는다

            String selectQuery = "SELECT * FROM " + tableName;

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectQuery);

            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            while (resultSet.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    String columnValue = resultSet.getString(i);
                    System.out.print( columnValue+" ");
                }
                System.out.println(); // 튜플 구분
            }

            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
