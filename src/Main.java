

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Поехали!
        printMenu();

    }

    static void printMenu() {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();
        label:
        while (true) {
            System.out.println("Введите команду: ");
            System.out.println("1 - Ввести количество шагов за определённый день.");
            System.out.println("2 - Напечатать статистику за определённый месяц.");
            System.out.println("3 - Изменить цель по количеству шагов в день.");
            System.out.println("4 - Выход.");
            final String command = scanner.nextLine();
            switch (command) {
                case "1": {

                    System.out.println("Вводим количество шагов за определённый день.");

                    System.out.println("Введите месяц (1-12):");

                    String line = scanner.nextLine();

                    int checkMonth = Integer.parseInt(line);
                    if (checkMonth < 1 || (checkMonth > 12)) {
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
                            if (check < 0) {
                                System.out.println("Скручивать пробег плохо! Нельзя вводить отрицательные значения шагов :)");
                            } else {
                                final int steps = Integer.parseInt(line);
                                stepTracker.addStepsInDay(month, day, steps);
                                System.out.println("Вы добавили: " + steps + "  пройденных шагов за " + day + " день " + month + " месяца");
                            }
                        }
                    }
                    break;
                }
                case "2": {
                    System.out.println("Выводим статистику за определенный месяц:");
                    System.out.println("Введите месяц (1-12):");
                    String line = scanner.nextLine();

                    final int month = Integer.parseInt(line);
                    if (month < 1 || month > 12) {
                        System.out.println("Диапазон 1-12. Январь = 1 ... декабрь = 12");
                    } else {
                        //Напечатать статистику за определённый месяц.
                        System.out.println("Выводим статистику за " + month + " месяц:");

                        stepTracker.countAndPrintStatistic(month);
                        System.out.println("\nОбщее количество шагов за " + month + " месяц: " + stepTracker.countSumSteps(month) + " шагов.");
                        System.out.println("Максимальное пройденное количество шагов в месяце: " + stepTracker.countMaxSteps(month));
                        System.out.println("Среднее количество шагов: " + stepTracker.countAverageSteps(month));
                        System.out.println("Пройденная дистанция (в км): " + Converter.km(stepTracker.countSumSteps(month)));
                        System.out.println("Количество сожжённых килокалорий: " + Converter.kk(stepTracker.countSumSteps(month)));
                        System.out.println("Лучшая серия (максимальное количество подряд идущих дней, в течение которых количество шагов за день было равно или выше целевого): " + stepTracker.countSeria(month));
                    }
                    break;
                }
                case "3": {
                    System.out.println("Изменяем цель по количеству шагов в день... (сейчас это " + stepTracker.destination + " шагов)");
                    System.out.println("Введите нужное количество шагов для новой цели:");
                    final String line = scanner.nextLine();
                    final int qty = Integer.parseInt(line);
                    if (qty < 0) {
                        System.out.println("Нельзя вводить отрицательные значения шагов :)");
                    } else {
                        //Изменить цель по количеству шагов в день.
                        System.out.println("Установили новую цель! Теперь вам нужно прошагать: " + qty + " шагов в день, вместо " + stepTracker.destination + " шагов!");
                        stepTracker.changeDestStepInDay(qty);


                    }
                    break;
                }
                case "4":
                    System.out.println("Программа завершена");
                    break label;

                default:
                    System.out.println("Извините, такой команды пока нет.");
                    break;
            }
        }

    }
}

