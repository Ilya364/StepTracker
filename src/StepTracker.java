import java.util.Scanner;

public class StepTracker {
    static final int monthsInYear = 12;
    MonthData[] monthToData = new MonthData[monthsInYear];
    Scanner scanner;
    int goalByStepsPerDay = 10000;
    Converter converter = new Converter();

    StepTracker(Scanner scanner) {
        this.scanner = scanner;

        for (int month = 0; month < monthToData.length; month++) {
            monthToData[month] = new MonthData();
        }
    }

    void addNewNumbersStepsPerDay() {
        System.out.println("Пожалуйста, введите номер месяца");
        int monthNumber = scanner.nextInt();
        if(!checkCorrectnessOfMonth(monthNumber)) {
            System.out.println("Номер месяца должен быть в пределах от 1 до 12!");
            return;
        }

        System.out.println("Пожалуйста, введите номер дня");
        int dayNumber = scanner.nextInt();
        if (!checkCorrectnessOfDay(dayNumber)) {
            System.out.println("Номер дня должен быть в пределах от 1 до 30!");
            return;
        }

        System.out.println("Пожалуйста, введите количество шагов");
        int stepsNumber = scanner.nextInt();
        if (!checkCorrectnessOfSteps(stepsNumber)) {
            System.out.println("Количество шагов должно быть положительным числом!");
            return;
        }

        monthToData[monthNumber - 1].days[dayNumber - 1] = stepsNumber;
    }

    void changeStepGoal() {
        System.out.println("Введите желаемую цель по шагам:");
        int steps = scanner.nextInt();
        if (!checkCorrectnessOfSteps(steps)) {
            System.out.println("Количество шагов должно быть положительным числом!");
            return;
        }

        goalByStepsPerDay = steps;
    }

    void printStatistic() {
        System.out.println("Введите номер месяца:");
        int month = scanner.nextInt();
        if (!checkCorrectnessOfMonth(month)) {
            System.out.println("Номер месяца должен быть в пределах от 1 до 12!");
            return;
        }

        monthToData[month - 1].printDaysAndStepsFromMonth();
        System.out.println("Общее кол-во шагов за месяц: " + monthToData[month - 1].sumStepsFromMonth() +
                "\nМаксимальное количество шагов: " + monthToData[month - 1].maxSteps() +
                "\nСреднее кол-во шагов: " + monthToData[month - 1].sumStepsFromMonth() / 30 +
                "\nПройденная дистанция в км: " + converter.convertStepsToKm(monthToData[month - 1].sumStepsFromMonth()) +
                "\nКол-во сожённых калорий: " + converter.convertStepsToKilocalories(monthToData[month - 1].sumStepsFromMonth()) +
                "\nЛучшая серия (кол-во дней): " + monthToData[month - 1].bestSeries(goalByStepsPerDay) + "\n");
    }

    boolean checkCorrectnessOfMonth(int monthNumber) {
        if (monthNumber <= 0 || monthNumber > 12)
            return false;
        return true;
    }

    boolean checkCorrectnessOfDay(int dayNumber) {
        if (dayNumber <= 0 || dayNumber > 30)
            return false;
        return true;
    }

    boolean checkCorrectnessOfSteps(int stepsNumber) {
        if (stepsNumber < 1)
            return false;
        return true;
    }
}
