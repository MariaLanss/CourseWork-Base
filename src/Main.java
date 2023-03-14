public class Main {
    public static void main(String[] args) {
        Employee[] employeeBase = new Employee[10];
        employeeBase[0] = new Employee("Адаменко", "Татьяна", "Владимировна", 1, 10000);
        employeeBase[1] = new Employee("Андреева", "Рената", "Сергеевна", 1, 20000);
        employeeBase[2] = new Employee("Баринова", "Наталья", "Евгеньевна", 2, 25000);
        employeeBase[3] = new Employee("Васильева", "Надежда", "Алексеевна", 2, 30000);
        employeeBase[4] = new Employee("Грачева", "Мария", "Александровна", 3, 35000);
        employeeBase[5] = new Employee("Денисова", "Елена", "Владимировна", 3, 40000);
        employeeBase[6] = new Employee("Ермакова", "Екатерина", "Олеговна", 4, 45000);
        employeeBase[7] = new Employee("Зайцева", "Марина", "Игоревна", 4, 50000);

        System.out.println(dataOfEmployees(employeeBase));
        System.out.println("Сумма затрат на зарплаты в месяц составила -- " + summSalary(employeeBase));
        System.out.println("Сотрудник с минимальной зарплатой -- " + findEmployeesMinSalary(employeeBase));
        System.out.println("Сотрудник с максимальной зарплатой -- " + findEmployeesMaxSalary(employeeBase));
        System.out.println("Среднеее значение зарплат -- " + avarageSalary(employeeBase));
        System.out.println("Ф.И.О. всех сотрудников: " + listOfEmployees(employeeBase));
    }
    private static String dataOfEmployees(Employee[] employees) {
        int firstEnterInBase = firstEnterInBase(employees);
        if (firstEnterInBase == -1) {
            return "None";
        }

        String dataOfEmployees = "";

        for (int i = firstEnterInBase; i < employees.length; i++) {
            if (employees[i] != null) {
                dataOfEmployees += employees[i] + "\n";
            }
        }
        return dataOfEmployees;
    }
    private static String listOfEmployees(Employee[] employees) {
        int firstEnterInBase = firstEnterInBase(employees);
        if (firstEnterInBase == -1) {
            return "None";
        }
        String listOfEmployees = "";
        for (int i = firstEnterInBase; i < employees.length; i++) {
            if (employees[i] != null) {
                listOfEmployees += employees[i].getFullName() + "\n";
            }
        }
        return listOfEmployees;
    }
    private static int summSalary(Employee[] employees) {
        int firstEnterInBase = firstEnterInBase(employees);
        if (firstEnterInBase == -1) {
            return 0;
        }
        int summSalary = 0;
        for (int i = firstEnterInBase; i < employees.length; i++) {
            if (employees[i] != null) {
                summSalary += employees[i].getSalary();
            }
        }
        return summSalary;
    }
    private static String findEmployeesMinSalary(Employee[] employees) {
        int firstEnterInBase = firstEnterInBase(employees);
        if (firstEnterInBase == -1) {
            return "None";
        }
        int minSalary = employees[firstEnterInBase].getSalary();
        int indexEmployeesMinSalary = firstEnterInBase;
        for (int i = firstEnterInBase; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() < minSalary) {
                minSalary = employees[i].getSalary();
                indexEmployeesMinSalary = i;
            }
        }
        return employees[indexEmployeesMinSalary].getFullName();
    }
    private static String findEmployeesMaxSalary(Employee[] employees) {
        int firstEnterInBase = firstEnterInBase(employees);
        if (firstEnterInBase == -1) {
            return "None";
        }
        int maxSalary = employees[firstEnterInBase].getSalary();
        int indexEmployeesMaxSalary = firstEnterInBase;
        for (int i = firstEnterInBase; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() > maxSalary) {
                maxSalary = employees[i].getSalary();
                indexEmployeesMaxSalary = i;
            }
        }
        return employees[indexEmployeesMaxSalary].getFullName();
    }
    private static int avarageSalary(Employee[] employees) {
        int firstEnterInBase = firstEnterInBase(employees);
        if (firstEnterInBase == -1) {
            return 0;
        }
        int countEmployees = 0;
        int summSalary = summSalary(employees);
        for (int i = firstEnterInBase; i < employees.length; i++) {
            if (employees[i] != null) {
                countEmployees++;
            }
        }
        return Math.round(summSalary / countEmployees);
    }
    private static int firstEnterInBase(Employee[] employees) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                return i;
            }
        }
        System.out.println("Запись в базе отсутствует.");
        return -1;
    }
}