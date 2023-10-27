import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class DeleteGUI {
    private JTextField tableNameField;
    private JTextField conditionColumnField;
    private JTextField conditionValueField;

    public DeleteGUI(JTextField tableNameField, JTextField conditionColumnField, JTextField conditionValueField) {
        this.tableNameField = tableNameField;
        this.conditionColumnField = conditionColumnField;
        this.conditionValueField = conditionValueField;
    }

    public void execute() {
        String jdbcUrl = "jdbc:mysql://localhost:3306/company?company=UTC";
        String username = "root";
        String password = "1112";

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            String my_table = JOptionPane.showInputDialog("테이블 이름을 입력해주세요");
            tableNameField.setText(my_table);
            String conditionColumn = JOptionPane.showInputDialog("attribute 명을 입력해주세요");
            conditionColumnField.setText(conditionColumn);
            String conditionValue = JOptionPane.showInputDialog("대상의 값을 입력해주세요");
            conditionValueField.setText(conditionValue);
            
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
