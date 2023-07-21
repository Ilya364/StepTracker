import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker(scanner);

        while (true) {
            printMenu();

            int command = scanner.nextInt();
            switch (command) {
                case 1: stepTracker.addNewNumbersStepsPerDay();
                        break;
                case 2: stepTracker.changeStepGoal();
                        break;
                case 3: stepTracker.printStatistic();
                        break;
                case 0: System.out.println("Работа завершена.");
                        return;
                default:System.out.println("Такой команды нет.");
                        break;

            }
        }
    }

    static void printMenu() {
        System.out.println("Введите номер необходимой комманды:\n1.Ввести количество шагов за определённый день\n" +
                "2.Изменить цель по количеству шагов за день\n3.Напечатать статистику за определнный месяц\n" +
                "0.Выйти из приложения");
    }
}
