public class Converter {
   static double stepLength = 0.00075;
   static double kiloCaloriesFormula = 0.05;

    //считаем пройденное количетво километров.
    static double kilometerCounter(int sum) {
        double countDistance = sum * stepLength;
        return countDistance;
    }

    // считаем количество сожженных ККАЛ.
    static double kiloCaloriesCounter(int sum) {
        double countKCal = sum * kiloCaloriesFormula;
        return countKCal;
    }
}