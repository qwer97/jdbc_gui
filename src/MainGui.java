import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainGui{
    public static void main(String[] args) {

        JFrame frame = new JFrame("Database Operations");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);

        placeComponents(panel);

        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);
        //초기화
        JTextField J1=new JTextField();
        J1.setText("");
        JTextField J2=new JTextField();
        J2.setText("");
        JTextField J3=new JTextField();
        J3.setText("");
        JTextArea JA=new JTextArea();
        JA.setText("");


        // 버튼 만들기
        JButton deleteButton = new JButton("Delete");
        deleteButton.setBounds(50, 50, 150, 60);
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DeleteGUI  delete = new DeleteGUI(J1,J2,J3);
                delete.execute();
            }
        });
        panel.add(deleteButton);

        JButton insertButton = new JButton("Insert");
        insertButton.setBounds(210, 50, 150, 60);
        insertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                InsertGUI insert = new InsertGUI(J1,J2);
                insert.execute();
            }
        });
        panel.add(insertButton);

        JButton selectButton = new JButton("Select"); //보고서 출력
        selectButton.setBounds(370, 50, 150, 60);
        selectButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SelectGUI  select  = new SelectGUI(J1,JA);
                select.execute();
            }
        });
        panel.add(selectButton);
    }
}
