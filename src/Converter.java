public class Converter {

    static double km(int sum) { // считаем пройденное количество километров.
        double countDistance = (sum * 0.75) / 1000;
        return countDistance;
    }

    // 1 шаг = 50 калорий, 1 килокалория = 1 000 калорий.
    static int kk(int sum) { // считаем количество сожженных ККАЛ.
        int countKCal = ((sum * 50) / 1000);
        return countKCal;
    }

}
