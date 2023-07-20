public class MonthData {
    int[] days = new int[30];

    void printDaysAndStepsFromMonth() {
        for (int i = 0; i < days.length; i++) {
            System.out.println((i + 1) + " день: " + days[i]);
        }
    }

    int sumStepsFromMonth() {
        int sumSteps = 0;
        for (int i = 0; i < days.length; i++) {
            sumSteps += days[i];
        }
        return sumSteps;
    }

    int maxSteps() {
         int maxSteps = days[0];
         for (int i = 1; i < days.length; i++) {
             if (days[i] > maxSteps) {
                 maxSteps = days[i];
             }
         }
         return maxSteps;
    }

    int bestSeries(int goalByStepsPerDay) {
        int bestSeries = 0;
        int seriesLength = 0;
        for (int i = 0; i < days.length; i++) {
            if (days[i] >= goalByStepsPerDay) {
                seriesLength++;
            } else {
                if (seriesLength > bestSeries) {
                    bestSeries = seriesLength;
                }
                seriesLength = 0;
            }
        }
        return bestSeries;
    }
}
