public class Converter {
    static final int centimetersInStep = 75;
    static final int centimetersInKm = 100000;
    static final int caloriesInStep = 50;
    static final int caloriesInKilo = 1000;
    int convertStepsToKm(int steps) {
        return steps * centimetersInStep / centimetersInKm;
    }

    int convertStepsToKilocalories(int steps) {
        return steps * caloriesInStep / caloriesInKilo;
    }
}
