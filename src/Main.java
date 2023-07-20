import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker(scanner);

        while (true) {
            printMenu();

            int command = scanner.nextInt();
            if (command == 1) {
                stepTracker.addNewNumbersStepsPerDay();
            } else if (command == 2) {
                stepTracker.changeStepGoal();
            } else if (command == 3) {
                stepTracker.printStatistic();
            } else if (command == 0) {
                System.out.println("Работа завершена.");
                break;
            } else {
                System.out.println("Такой команды нет.");
            }
        }
    }

    static void printMenu() {
        System.out.println("Введите номер необходимой комманды:");
        System.out.println("1.Ввести количество шагов за определённый день");
        System.out.println("2.Изменить цель по количеству шагов за день");
        System.out.println("3.Напечатать статистику за определнный месяц");
        System.out.println("0.Выйти из приложения");
    }
}
