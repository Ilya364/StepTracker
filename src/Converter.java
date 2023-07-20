public class Converter {
    int convertStepsToKm(int steps) {
        return steps * 75 / 100000;
    }

    int convertStepsToKilocalories(int steps) {
        return steps * 50 / 1000;
    }
}
