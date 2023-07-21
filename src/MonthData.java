public class MonthData {
    static final int daysInMonth = 30;
    int[] days = new int[daysInMonth];

    void printDaysAndStepsFromMonth() {
        for (int day = 0; day < days.length; day++) {
            System.out.println((day + 1) + " день: " + days[day]);
        }
    }

    int sumStepsFromMonth() {
        int sumSteps = 0;
        for (int day = 0; day < days.length; day++) {
            sumSteps += days[day];
        }
        return sumSteps;
    }

    int maxSteps() {
         int maxSteps = days[0];
         for (int day = 1; day < days.length; day++) {
             maxSteps = defineLargerNumber(maxSteps, days[day]);
         }
         return maxSteps;
    }

    int bestSeries(int goalByStepsPerDay) {
        int bestSeries = 0;
        int seriesLength = 0;
        for (int day = 0; day < days.length; day++) {
            if (days[day] >= goalByStepsPerDay) {
                seriesLength++;
                if (day == 29)
                    bestSeries = defineLargerNumber(seriesLength, bestSeries);
            } else {
                bestSeries = defineLargerNumber(seriesLength, bestSeries);
                seriesLength = 0;
            }
        }
        return bestSeries;
    }

    int defineLargerNumber(int num1, int num2) {
        if (num1 >= num2)
            return num1;
        return num2;
    }
}
