import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int earnings = 0;    // Доходы
        int spendings = 0;   // Расходы

        while (true) {
            System.out.println("Выберите операцию и введите её номер: ");
            System.out.println("1. Добавить новый доход");
            System.out.println("2. Добавить новый расход");
            System.out.println("3. Выбрать систему налогообложения");
            System.out.println("Для завершения программы введите end");

            String input = scanner.nextLine();
            if ("end".equals(input)) {
                break;
            }

            int operation = Integer.parseInt(input);
            switch (operation) {
                case 1:
                    System.out.println("Введите сумму дохода:");
                    int income = scanner.nextInt();
                    if (income < 0) {
                        System.out.println("Доход не может быть отрицательным.");
                    } else {
                        earnings += income;
                    }
                    scanner.nextLine();
                    break;
                case 2:
                    System.out.println("Введите сумму расходов:");
                    int expense = scanner.nextInt();
                    if (expense < 0) {
                        System.out.println("Расход не может быть отрицательным.");
                    } else {
                        spendings += expense;
                    }
                    scanner.nextLine();
                    break;
                case 3:
                    chooseBestTaxSystem(earnings, spendings);
                    break;
                default:
                    System.out.println("Такой операции нет");
            }
        }
        System.out.println("Программа завершена!");
        scanner.close();
    }

    public static int taxEarningsMinusSpendings(int earnings, int spendings) {
        if (earnings <= spendings) {
            return 0;
        }
        return (earnings - spendings) * 15 / 100;
    }

    public static int sixPercentTax(int earnings) {
        return Math.max(earnings * 6 / 100, 0);
    }

    private static void chooseBestTaxSystem(int earnings, int spendings) {
        int taxA = taxEarningsMinusSpendings(earnings, spendings);
        int taxB = sixPercentTax(earnings);

        System.out.println("Налоги по разным системам:");
        System.out.println("УСН доходы: " + taxB + " рублей");
        System.out.println("УСН доходы минус расходы: " + taxA + " рублей");

        if (taxA < taxB) {
            System.out.println("Мы советуем вам УСН доходы минус расходы.");
            System.out.println("Экономия: " + (taxB - taxA) + " рублей");
        } else if (taxB < taxA) {
            System.out.println("Мы советуем вам УСН доходы.");
            System.out.println("Экономия: " + (taxA - taxB) + " рублей");
        } else {
            System.out.println("Можете выбрать любую систему налогообложения. Разница отсутствует.");
        }
    }
}
