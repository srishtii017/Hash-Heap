import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class sort_game {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt(); // Minimum salary
        int N = sc.nextInt(); // Number of employees

        List<Employee> employees = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String name = sc.next();
            int salary = sc.nextInt();
            if (salary >= x) {
                employees.add(new Employee(name, salary));
            }
        }

        // Sorting the employees list based on salary (descending) and name (lexicographical)
        Collections.sort(employees, (e1, e2) -> {
            if (e2.salary != e1.salary) {
                return e2.salary - e1.salary;
            } else {
                return e1.name.compareTo(e2.name);
            }
        });

        // Printing the sorted list
        for (Employee e : employees) {
            System.out.println(e.name + " " + e.salary);
        }
    }
}

class Employee {
    String name;
    int salary;

    Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    } 
}
