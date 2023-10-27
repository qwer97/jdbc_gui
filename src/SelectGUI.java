import javax.swing.*;
import java.sql.*;

public class SelectGUI { //입력받기 -> JOPtion  , 보고서 출력 기능
    private JTextField tableNameField;
    private JTextArea resultArea;

    public SelectGUI(JTextField tableNameField, JTextArea resultArea) {
        this.tableNameField = tableNameField;
        this.resultArea = resultArea;
    }

    public void execute() {
        String jdbc_driver = "com.mysql.cj.jdbc.Driver";
        String jdbc_url = "jdbc:mysql://localhost:3306/company?company=UTC";

        try {
            Class.forName(jdbc_driver).newInstance();
            Connection connection = DriverManager.getConnection(jdbc_url, "root", "1112");

            String tableName = JOptionPane.showInputDialog("테이블의 이름을 입력해주세요");
            tableNameField.setText(tableName);

            String selectQuery = "SELECT * FROM " + tableName;

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectQuery);

            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            // resultArea를 담을 스크롤 팬을 생성
            JScrollPane scrollPane = new JScrollPane(resultArea);

            // 스크롤 팬을 프레임에 추가
            JFrame frame = new JFrame("Select GUI");
            frame.add(scrollPane);
            frame.setSize(500, 500);
            frame.setVisible(true);

            while (resultSet.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    String columnValue = resultSet.getString(i);
                    resultArea.append(columnValue + " ");
                }
                resultArea.append("\n"); // 튜플 구분
            }

            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
