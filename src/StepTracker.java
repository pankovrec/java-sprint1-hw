import java.util.HashMap;

public class StepTracker {

    int day = 0;
    int destination = 10000;
    HashMap<Integer, int[]> MonthSteps = new HashMap<>();

    // записываем(изменяем) количество шагов для цели.
    public void changeDestStepInDay(int quantitySteps) {
        destination = quantitySteps;
    }

    // добавляем шаги за нужный день в нужном месяце.
    public void addStepsInDay(int month, int day, int steps) {
        int[] stepsPerMonth = MonthSteps.get(month);
        if (stepsPerMonth == null) {
            stepsPerMonth = new int[30];
            MonthSteps.put(month, stepsPerMonth);
        }
        stepsPerMonth[day - 1] = steps;
    }

    // выводим статистику по дням за нужный месяц.
    public void countAndPrintStatistic(int month) {
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

    // считаем сумму шагов за нужный месяц
    public int countSumSteps(int month) {
        int sum = 0;
        for (int mo : MonthSteps.get(month)) {
            sum += mo;
        }
        return sum;
    }

    // считаем максимальное количество шагов за нужный месяц.
    public int countMaxSteps(int month) {
        int maxSteps = 0;
        for (int mo : MonthSteps.get(month)) {
            if (mo > maxSteps)
                maxSteps = mo;
        }
        return maxSteps;
    }

    // считаем среднее количество шагов за нужный месяц.
    public int countAverageSteps(int month) {
        int averageSteps = countSumSteps(month) / (MonthSteps.get(month)).length;
        return averageSteps;
    }

    // считаем серию.
    public int countSeria(int month) {
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