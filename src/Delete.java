import com.sun.tools.javac.Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Delete {
    public  void execute() {
        String jdbcUrl = "jdbc:mysql://localhost:3306/company?company=UTC";
        String username = "root";
        String password = "1112";
        Scanner s = new Scanner(System.in);

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println("테이블 이름을 입력해주세요");
            String my_table = s.next(); //table명
            System.out.println("attribute 명을 입력해주세요");
            String conditionColumn = s.next(); // attribute명
            System.out.println("대상의 값을 입력해주세요");
            String conditionValue = s.next(); //값

            // 쿼리 생성
            String deleteQuery = "DELETE FROM " + my_table + " WHERE " + conditionColumn + " = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);

            // 자세한 조건
            preparedStatement.setString(1, conditionValue);

            int rowsDeleted = preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
