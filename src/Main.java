public class Main {
    private static final Employee[] employeeBase = new Employee[10];
    public static void main(String[] args) {
        employeeBase[0] = new Employee("Адаменко", "Татьяна", "Владимировна", 1, 10000);
        employeeBase[1] = new Employee("Андреева", "Рената", "Сергеевна", 1, 20000);
        employeeBase[2] = new Employee("Баринова", "Наталья", "Евгеньевна", 2, 25000);
        employeeBase[3] = new Employee("Васильева", "Надежда", "Алексеевна", 2, 30000);
        employeeBase[4] = new Employee("Грачева", "Мария", "Александровна", 3, 35000);
        employeeBase[5] = new Employee("Денисова", "Елена", "Владимировна", 3, 40000);
        employeeBase[6] = new Employee("Ермакова", "Екатерина", "Олеговна", 4, 45000);
        employeeBase[7] = new Employee("Зайцева", "Марина", "Игоревна", 4, 50000);

        System.out.println(dataOfEmployees());
        System.out.println("Сумма затрат на зарплаты в месяц составила -- " + sumSalary());
        System.out.println("Сотрудник с минимальной зарплатой -- " + findEmployeesMinSalary());
        System.out.println("Сотрудник с максимальной зарплатой -- " + findEmployeesMaxSalary());
        System.out.println("Среднеее значение зарплат -- " + averageSalary());
        System.out.println("Ф.И.О. всех сотрудников: " + listOfEmployees());
    }
    private static String dataOfEmployees() {
        int firstEnterInBase = firstEnterInBase(employeeBase);
        if (firstEnterInBase == -1) {
            return "None";
        }

        String dataOfEmployees = "";

        for (int i = firstEnterInBase; i < employeeBase.length; i++) {
            if (employeeBase[i] != null) {
                dataOfEmployees += employeeBase[i] + "\n";
            }
        }
        return dataOfEmployees;
    }
    private static String listOfEmployees() {
        int firstEnterInBase = firstEnterInBase(employeeBase);
        if (firstEnterInBase == -1) {
            return "None";
        }
        String listOfEmployees = "";
        for (int i = firstEnterInBase; i < employeeBase.length; i++) {
            if (employeeBase[i] != null) {
                listOfEmployees += employeeBase[i].getFullName() + "\n";
            }
        }
        return listOfEmployees;
    }
    public static double sumSalary() {
        double sumSalary = 0;
        for (int i = 0; i < employeeBase.length; i++) {
            if (employeeBase[i] != null) {
                sumSalary += employeeBase[i].getSalary();
            }
        }
        return sumSalary;
    }
    private static String findEmployeesMinSalary() {
        int firstEnterInBase = firstEnterInBase(employeeBase);
        if (firstEnterInBase == -1) {
            return "None";
        }
        int minSalary = employeeBase[firstEnterInBase].getSalary();
        int indexEmployeesMinSalary = firstEnterInBase;
        for (int i = firstEnterInBase; i < employeeBase.length; i++) {
            if (employeeBase[i] != null && employeeBase[i].getSalary() < minSalary) {
                minSalary = employeeBase[i].getSalary();
                indexEmployeesMinSalary = i;
            }
        }
        return employeeBase[indexEmployeesMinSalary].getFullName();
    }
    private static String findEmployeesMaxSalary() {
        int firstEnterInBase = firstEnterInBase(employeeBase);
        if (firstEnterInBase == -1) {
            return "None";
        }
        int maxSalary = employeeBase[firstEnterInBase].getSalary();
        int indexEmployeesMaxSalary = firstEnterInBase;
        for (int i = firstEnterInBase; i < employeeBase.length; i++) {
            if (employeeBase[i] != null && employeeBase[i].getSalary() > maxSalary) {
                maxSalary = employeeBase[i].getSalary();
                indexEmployeesMaxSalary = i;
            }
        }
        return employeeBase[indexEmployeesMaxSalary].getFullName();
    }
    public static double averageSalary() {
        double averageSalary;
        int salaryCount = 0;
        for (int i = 0; i < employeeBase.length; i++) {
            if (employeeBase[i] != null) {
                salaryCount++;
            }
        }
        averageSalary = sumSalary() / salaryCount;
        return averageSalary;
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