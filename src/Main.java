/*
Создайте класс Поезд с полями:

    Пункт назначения
    Номер поезда
    Время отправления (можно String, лучше LocalTime)

Создайте массив из пяти элементов типа Поезд и заполните его тестовыми данными.

Реализуйте методы:

* Сортировать массив поездов по номеру поезда по возрастанию и по убыванию +
* Печать информации о поезде, номер которого пришел как входной параметр в метод
*** Сортировать массив по пункту назначения, а поезда с одинаковым пунктом назначения сортируются
по времени отправления между собой
 */

import java.time.LocalTime;
import java.util.Scanner;

public class Main {

    private static void bubbleSort(Train[] trains) {
        boolean sorted = false;
        Train temp;
        // сортировка по возрастанию
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < trains.length - 1; i++) {
                if (trains[i].getNumber() > trains[i + 1].getNumber()) {
                    temp = trains[i];
                    trains[i] = trains[i + 1];
                    trains[i + 1] = temp;
                    sorted = false;
                }
            }
        }
        System.out.println("Номера поездов по возрастанию");
        for (int i = 0; i < trains.length; i++) {
            if (i < trains.length - 1) {
                System.out.print(trains[i].getNumber() + ", ");
            } else {
                System.out.print(trains[i].getNumber() + "\n");
            }
        }
        sorted = false;
        // сортировка по убыванию
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < trains.length - 1; i++) {
                if (trains[i].getNumber() < trains[i + 1].getNumber()) {
                    temp = trains[i + 1];
                    trains[i + 1] = trains[i];
                    trains[i] = temp;
                    sorted = false;
                }
            }
        }
        System.out.println("Номера поездов по убыванию");
        for (int i = 0; i < trains.length; i++) {
            if (i < trains.length - 1) {
                System.out.print(trains[i].getNumber() + ", ");
            } else {
                System.out.print(trains[i].getNumber() + "\n");
            }
        }
    }

    private static void infoAboutTrain(Train[] trains, int number) {
        boolean find = false;
        for (Train train : trains) {
            if (number == train.getNumber()) {
                System.out.println("Информация о поезде:\n" + "Поезд №" + train.getNumber() +
                        "\nКонечный пункт: " + train.getDestination() + "\nОтправление в " +
                        train.getDepartTime());
                find = true;
                break;
            }
        }
        if (!find) {
            System.out.println("В расписании не найден поезд с номером " + number);
        }
    }

    private static void sortTrains(Train[] trains) {
        boolean sorted = false;
        Train temp;
        // сортировка по пункту отправления
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < trains.length - 1; i++) {
                if (trains[i].getDestination().compareTo(trains[i + 1].getDestination()) < 1) {
                    temp = trains[i + 1];
                    trains[i + 1] = trains[i];
                    trains[i] = temp;
                    sorted = false;
                }
            }
        }
        System.out.println("Номера поездов по убыванию");
        for (int i = 0; i < trains.length; i++) {
            if (i < trains.length - 1) {
                System.out.print(trains[i].getDestination() + ", ");
            } else {
                System.out.print(trains[i].getDestination() + "\n");
            }
        }
    }

    public static void main(String[] args) {
        Train train1 = new Train("Москва", 775, LocalTime.of(17, 0));
        Train train2 = new Train("Новороссийск", 227, LocalTime.of(12, 22));
        Train train3 = new Train("Москва", 723, LocalTime.of(5, 35));
        Train train4 = new Train("Нижний Новгород", 59, LocalTime.of(18, 15));
        Train train5 = new Train("Уфа", 47, LocalTime.of(14, 30));

        Train[] trains = {train1, train2, train3, train4, train5};

        Scanner scan = new Scanner(System.in);
        System.out.println("Введите номер поезда: ");
        int number = scan.nextInt();
        scan.close();
        infoAboutTrain(trains, number);
        sortTrains(trains);
        System.out.println((trains[0].getDestination().compareTo(trains[1].getDestination())));

        Train[] trainsSort = {train1, train2, train3, train4, train5};
        bubbleSort(trainsSort);
    }
}
