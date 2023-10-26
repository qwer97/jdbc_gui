import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Insert {
    public void execute() {
        String jdbcUrl = "jdbc:mysql://localhost:3306/company?company=UTC";
        String username = "root";
        String password = "1112";
        Scanner s = new Scanner(System.in);

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            System.out.print("테이블 이름을 입력하세요: ");
            String tableName = s.next();

            // 사용자로부터 입력을 받아서 데이터 삽입 쿼리 생성
            String insertQuery = "INSERT INTO " + tableName + " VALUES (";
            System.out.print("데이터 입력 (column1,column2, ...) : ");
            String inputData = s.next();
            insertQuery += inputData + ")";

            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

            int rowsInserted = preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
