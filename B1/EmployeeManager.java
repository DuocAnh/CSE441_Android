import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeManager {
    private List<Employee> employees;

    public EmployeeManager() {
        employees = new ArrayList<>();
        initializeEmployees();  // Khởi tạo danh sách 10 nhân viên
    }

    // Khởi tạo danh sách 10 nhân viên
    private void initializeEmployees() {
        employees.add(new Employee(1, "John Doe", 30, "HR", "HR001", 2.5));
        employees.add(new Employee(2, "Jane Smith", 25, "IT", "IT001", 3.0));
        employees.add(new Employee(3, "Michael Johnson", 35, "Sales", "SA001", 2.8));
        employees.add(new Employee(4, "Emily Davis", 28, "Marketing", "MK001", 3.2));
        employees.add(new Employee(5, "James Brown", 40, "Finance", "FI001", 2.7));
        employees.add(new Employee(6, "Sarah Wilson", 26, "HR", "HR002", 2.9));
        employees.add(new Employee(7, "Christopher Lee", 32, "IT", "IT002", 3.1));
        employees.add(new Employee(8, "Jessica White", 29, "Sales", "SA002", 2.6));
        employees.add(new Employee(9, "Matthew Harris", 34, "Marketing", "MK002", 3.3));
        employees.add(new Employee(10, "Sophia Clark", 27, "Finance", "FI002", 2.4));
    }

    // Hiển thị danh sách nhân viên
    public void displayEmployees() {
        for (Employee employee : employees) {
            employee.displayEmployeeInfo();
        }
    }

    // Thêm một nhân viên mới vào danh sách
    public void addEmployee(Employee employee) {
        employees.add(employee);
        System.out.println("Nhân viên đã được thêm thành công.");
    }

    // Xóa một nhân viên từ danh sách theo ID
    public void removeEmployee(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                employees.remove(employee);
                System.out.println("Nhân viên đã được xóa thành công.");
                return;
            }
        }
        System.out.println("Không tìm thấy nhân viên có ID: " + id);
    }

    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nChọn một tùy chọn:");
            System.out.println("1. Hiển thị danh sách nhân viên");
            System.out.println("2. Thêm một nhân viên mới");
            System.out.println("3. Xóa một nhân viên");
            System.out.println("4. Thoát");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    manager.displayEmployees();
                    break;
                case 2:
                    System.out.println("Nhập ID của nhân viên:");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Nhập tên của nhân viên:");
                    String name = scanner.nextLine();

                    System.out.println("Nhập tuổi của nhân viên:");
                    int age = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Nhập phòng ban của nhân viên:");
                    String department = scanner.nextLine();

                    System.out.println("Nhập mã của nhân viên:");
                    String code = scanner.nextLine();

                    System.out.println("Nhập mức lương của nhân viên:");
                    double salaryRate = scanner.nextDouble();

                    Employee newEmployee = new Employee(id, name, age, department, code, salaryRate);
                    manager.addEmployee(newEmployee);
                    break;
                case 3:
                    System.out.println("Nhập ID của nhân viên cần xóa:");
                    int removeId = scanner.nextInt();
                    manager.removeEmployee(removeId);
                    break;
                case 4:
                    System.out.println("Thoát chương trình.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            }
        }
    }
}
