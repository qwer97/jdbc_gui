import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int choice;
        Scanner s = new Scanner(System.in);

        System.out.println("1. Delete");
        System.out.println("2. Insert");
        System.out.println("3. Select");
        System.out.print("선택하세요: ");
        choice = s.nextInt();

        switch (choice) {
            case 1:
                Delete delete = new Delete();
                delete.execute();
                break;
            case 2:
                Insert insert = new Insert();
                insert.execute();
                break;
            case 3:
                Select select = new Select();
                select.execute();
                break;
            default:
                System.out.println("잘못된 선택입니다.");
                break;
        }
    }
}
