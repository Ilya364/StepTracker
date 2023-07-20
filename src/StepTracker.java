import java.util.Scanner;

public class StepTracker {
    MonthData[] monthToData = new MonthData[12];
    Scanner scanner;
    int goalByStepsPerDay = 10000;
    Converter converter = new Converter();

    StepTracker(Scanner scanner) {
        this.scanner = scanner;

        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    void addNewNumbersStepsPerDay() {
        System.out.println("Пожалуйста, введите номер месяца");
        int monthNumber = scanner.nextInt();
        if (monthNumber <= 0 || monthNumber > 12) {
            System.out.println("Номер месяца должен быть в пределах от 1 до 12!");
            return;
        }

        System.out.println("Пожалуйста, введите номер дня");
        int dayNumber = scanner.nextInt();
        if (dayNumber <= 0 || dayNumber > 30) {
            System.out.println("Номер дня должен быть в пределах от 1 до 30!");
            return;
        }

        System.out.println("Пожалуйста, введите количество шагов");
        int stepsNumber = scanner.nextInt();
        if (stepsNumber < 1) {
            System.out.println("Количество шагов должно быть положительным числом!");
            return;
        }

        monthToData[monthNumber - 1].days[dayNumber - 1] = stepsNumber;
    }

    void changeStepGoal() {
        System.out.println("Введите желаемую цель по шагам:");
        int steps = scanner.nextInt();
        if (steps <= 0) {
            System.out.println("Количество шагов должно быть положительным числом!");
            return;
        }

        goalByStepsPerDay = steps;
    }

    void printStatistic() {
        System.out.println("Введите номер месяца:");
        int month = scanner.nextInt();
        if (month < 1 || month > 12) {
            System.out.println("Номер месяца должен быть в пределах от 1 до 12!");
            return;
        }

        monthToData[month - 1].printDaysAndStepsFromMonth();
        monthToData[month - 1].sumStepsFromMonth();
        monthToData[month - 1].maxSteps();
        System.out.println("Среднее кол-во шагов: " + monthToData[month - 1].maxSteps() / 30);
        System.out.println("Пройденная дистанция в км: " + converter.convertStepsToKm(monthToData[month - 1].sumStepsFromMonth()));
        System.out.println("Кол-во сожённых калорий: " + converter.convertStepsToKilocalories(monthToData[month - 1].sumStepsFromMonth()));
        System.out.println("Лучшая серия (кол-во дн: " + monthToData[month - 1].bestSeries(goalByStepsPerDay));
        System.out.println();
    }
}
