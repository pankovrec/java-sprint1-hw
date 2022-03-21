import java.util.Scanner;

public class Main {
   static StepTracker stepTracker = new StepTracker();
   static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            printMenu();
            final String command = scanner.nextLine();

            switch (command) {
                case "1": {
                    addNewSteps();
                    break;
                }
                case "2": {
                    printFullMonthStatistic();
                    break;
                }
                case "3": {
                    inputGoalSteps();
                    break;
                }
                case "4": {
                    System.out.println("Программа завершена");
                    return;
                }
                    default:
                        System.out.println("Извините, такой команды пока нет.");
                        break;
            }
        }
    }

    // выводим меню.
    static void printMenu() {
            System.out.println("Введите команду: ");
            System.out.println("1 - Ввести количество шагов за определённый день.");
            System.out.println("2 - Напечатать статистику за определённый месяц.");
            System.out.println("3 - Изменить цель по количеству шагов в день.");
            System.out.println("4 - Выход.");
    }

    // выясняем количество нужных шагов для новой цели, проверяем корректность, передаем на запись.
    static void inputGoalSteps() {
        System.out.println("Изменяем цель по количеству шагов в день... (сейчас это " + stepTracker.destination + " шагов)");
        System.out.println("Введите нужное количество шагов для новой цели:");
        final String line = scanner.nextLine();
        final int quantitySteps = Integer.parseInt(line);
        if (checkNegativeSteps(quantitySteps)) {
            System.out.println("Нельзя вводить отрицательные значения шагов :)");
        } else {
            System.out.println("Установили новую цель! Теперь вам нужно прошагать: " + quantitySteps + " шагов в день, вместо " + stepTracker.destination + " шагов!");
            stepTracker.changeDestStepInDay(quantitySteps);
        }
    }

    // производим проверку на допустимый диапазон диапазон месяцев.
    static boolean checkMonth(int month) {
        return month < 1 || month > 12;
    }

    // производим проверку на ввод отрицательного значения шагов.
    static boolean checkNegativeSteps(int quantitySteps) {
        return quantitySteps < 0;
    }

    // добавляем количество шагов за день.
    static void addNewSteps(){
        System.out.println("Вводим количество шагов за определённый день.");
        System.out.println("Введите месяц (1-12):");
        String line = scanner.nextLine();
        int checkMonth = Integer.parseInt(line);
        if(checkMonth(checkMonth)) {
            System.out.println("Диапазон 1-12. Январь = 1 ... декабрь = 12");
        } else {
            final int month = Integer.parseInt(line);
            System.out.println("Введите день (1-30):");
            line = scanner.nextLine();
            int checkDay = Integer.parseInt(line);
            if (checkDay < 1 || (checkDay > 30)) {
                System.out.println("Диапазон 1-30");
            } else {
                final int day = Integer.parseInt(line);
                System.out.println("Введите количество шагов (не может быть отрицательным):");
                line = scanner.nextLine();
                int check = Integer.parseInt(line);
                if (checkNegativeSteps(check)) {
                    System.out.println("Скручивать пробег плохо! Нельзя вводить отрицательные значения шагов :)");
                } else {
                    final int steps = Integer.parseInt(line);
                    stepTracker.addStepsInDay(month, day, steps);
                    System.out.println("Вы добавили: " + steps + "  пройденных шагов за " + day + " день " + month + " месяца");
                }
            }
        }
    }

    //выводим полную статистику за определенный месяц
    static void printFullMonthStatistic(){
        System.out.println("Выводим статистику за определенный месяц:");
        System.out.println("Введите месяц (1-12):");
        String line = scanner.nextLine();
        final int month = Integer.parseInt(line);
        if (checkMonth(month)) {
            System.out.println("Диапазон 1-12. Январь = 1 ... декабрь = 12");
        } else {
            //Напечатать статистику за определённый месяц.
            System.out.println("Выводим статистику за " + month + " месяц:");
            stepTracker.countAndPrintStatistic(month);
            System.out.println("\nОбщее количество шагов за " + month + " месяц: " + stepTracker.countSumSteps(month) + " шагов.");
            System.out.println("Максимальное пройденное количество шагов в месяце: " + stepTracker.countMaxSteps(month));
            System.out.println("Среднее количество шагов: " + stepTracker.countAverageSteps(month));
            System.out.println("Пройденная дистанция (в км): " + Converter.kilometerCounter(stepTracker.countSumSteps(month)));
            System.out.println("Количество сожжённых килокалорий: " + Converter.kiloCaloriesCounter(stepTracker.countSumSteps(month)));
            System.out.println("Лучшая серия (максимальное количество подряд идущих дней, в течение которых количество шагов за день было равно или выше целевого): " + stepTracker.countSeria(month));
        }
    }
}