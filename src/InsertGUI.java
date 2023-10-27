import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertGUI {
    private JTextField tableNameField;
    private JTextField inputDataField;

    public InsertGUI(JTextField tableNameField, JTextField inputDataField) {
        this.tableNameField = tableNameField;
        this.inputDataField = inputDataField;
    }

    public void execute() {
        String jdbcUrl = "jdbc:mysql://localhost:3306/company?company=UTC";
        String username = "root";
        String password = "1112";

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            String tableName = JOptionPane.showInputDialog("테이블 이름을 입력해주세요");
            tableNameField.setText(tableName);
            String inputData = JOptionPane.showInputDialog("데이터 입력 (column1,column2, ...) : ");
            inputDataField.setText(inputData);

            // 사용자로부터 입력을 받아서 데이터 삽입 쿼리 생성
            String insertQuery = "INSERT INTO " + tableName + " VALUES (" + inputData + ")";

            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

            int rowsInserted = preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}