
import java.util.HashMap;

public class StepTracker {

    int day = 0;
    int destination = 10000;
    HashMap<Integer, int[]> MonthSteps = new HashMap<>();

    public void changeDestStepInDay(int qty) { // меняем целевое количество шагов.
        destination = qty;
    }

    public void addStepsInDay(int month, int day, int steps) { // добавляем шаги за нужный день в нужном месяце.

        int[] stepsPerMonth = MonthSteps.get(month);
        if (stepsPerMonth == null) {
            stepsPerMonth = new int[30];
            MonthSteps.put(month, stepsPerMonth);
        }
        stepsPerMonth[day - 1] = steps;
    }

    public void countAndPrintStatistic(int month) { // выводим статистику по дням за нужный месяц.
        int[] stepsPerMonth = MonthSteps.get(month);
        if (stepsPerMonth == null) {
            stepsPerMonth = new int[30];
            MonthSteps.put(month, stepsPerMonth);
        }
        for (int mo : MonthSteps.get(month)) {
            day = day + 1;
            if (day == 31) {
                day = 1;
            }
            System.out.print(day + " день: " + mo + ", ");
        }
    }

    public int countSumSteps(int month) { // считаем сумму шагов за нужный месяц
        int sum = 0;
        for (int mo : MonthSteps.get(month)) {

            sum += mo;
        }
        return sum;
    }

    public int countMaxSteps(int month) { // считаем максимальное количество шагов за нужный месяц.
        int maxSteps = 0;
        for (int mo : MonthSteps.get(month)) {
            if (mo > maxSteps)
                maxSteps = mo;
        }
        return maxSteps;
    }

    public int countAverageSteps(int month) { // считаем среднее количество шагов за нужный месяц.

        int averageSteps = countSumSteps(month) / (MonthSteps.get(month)).length;


        return averageSteps;
    }

    public int countSeria(int month) { // считаем серию.
        int[] monthValues = MonthSteps.get(month);
        int seria = 0;
        int seriaTemp = 0;
        int seriaMax = 0;
        for (int i = 0; i < monthValues.length; i++) {
            if (monthValues[i] >= destination) {
                seria += 1;
                seriaTemp = seria;
                if (seriaTemp > seriaMax) {
                    seriaMax = seriaTemp;
                }
            } else {
                seria = 0;
            }
        }

        return seriaMax;
    }
}



