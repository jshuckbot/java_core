package ru.gb;

import java.util.Random;
import java.util.Scanner;

public class App {
    private static final char DOT_HUMAN = 'X';
    private static final char DOT_AI = '0';
    private static final char DOT_EMPTY = '*';
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();
    private static char[][] field;
    private static int fieldSizeX;
    private static int fieldSizeY;

    private static final int WIN_COUNT = 4; // Выигрышная комбинация


    public static void main(String[] args) {
        while (true) {
            initialize();
            printField();
            while (true) {
                humanTurn();
                printField();
                if (checkState(DOT_HUMAN, "Вы победили!"))
                    break;
                aiTurn();
                printField();
                if (checkState(DOT_AI, "Победил компьютер!"))
                    break;
            }
            System.out.print("Желаете сыграть еще раз? (Y - да): ");
            if (!scanner.next().equalsIgnoreCase("Y"))
                break;
        }
    }

    /**
     * Инициализация объектов игры
     */
    static void initialize() {
        fieldSizeX = 5;
        fieldSizeY = 5;

        field = new char[fieldSizeX][fieldSizeY];

        for (int x = 0; x < fieldSizeX; x++) {
            for (int y = 0; y < fieldSizeY; y++) {
                field[x][y] = DOT_EMPTY;
            }
        }
    }

    /**
     * Печать текущего состояния игрового поля
     */
    static void printField() {
        System.out.print("+");
        for (int i = 0; i < fieldSizeX; i++) {
            System.out.print("-" + (i + 1));
        }
        System.out.println("-");


        for (int x = 0; x < fieldSizeX; x++) {
            System.out.print(x + 1 + "|");
            for (int y = 0; y < fieldSizeY; y++) {
                System.out.print(field[x][y] + "|");
            }
            System.out.println();
        }

        for (int i = 0; i < fieldSizeX * 2 + 2; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    /**
     * Ход игрока (человека)
     */
    static void humanTurn() {
        int x;
        int y;
        do {
            System.out.print("Введите координаты хода X и Y\n(от 1 до 3) через пробел: ");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        }
        while (!isCellValid(x, y) || !isCellEmpty(x, y));
        field[x][y] = DOT_HUMAN;
    }

    /**
     * Ход игрока (компьютера)
     */
    static void aiTurn() {
        int x;
        int y;
        do {
            x = random.nextInt(fieldSizeX);
            y = random.nextInt(fieldSizeY);
        }
        while (!isCellEmpty(x, y));
        field[x][y] = DOT_AI;
    }

    /**
     * Проверка, является ли ячейка игрового поля пустой
     *
     * @param x координата
     * @param y координата
     * @return результат проверки
     */
    static boolean isCellEmpty(int x, int y) {
        return field[x][y] == DOT_EMPTY;
    }

    /**
     * Проверка валидности координат хода
     *
     * @param x координата
     * @param y координата
     * @return результат проверки
     */
    static boolean isCellValid(int x, int y) {
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    /**
     * Поверка на ничью (все ячейки игрового поля заполнены фишками человека или компьютера)
     *
     * @return
     */
    static boolean checkDraw() {
        for (int x = 0; x < fieldSizeX; x++) {
            for (int y = 0; y < fieldSizeY; y++) {
                if (isCellEmpty(x, y)) return false;
            }
        }

        return true;
    }

    /**
     * TODO: Переработать в рамках домашней работы
     * Метод проверки победы
     *
     * @param dot фишка игрока
     * @return результат проверки победы
     */
    static boolean checkWin(char dot) {
        for (int x = 0; x < fieldSizeX; x++) {
            for (int y = 0; y < fieldSizeY; y++) {
                if (checkRow(x, y, dot, WIN_COUNT) ||
                        checkColumn(x, y, dot, WIN_COUNT) ||
                        checkDiagonalDown(x, y, dot, WIN_COUNT) ||
                        checkDiagonalUp(x, y, dot, WIN_COUNT)
                )
                    return true;
            }
        }

        return false;
    }

    static boolean checkRow(int x, int y, char dot, int win) {
        int count = 0;
        for (int i = y; i < fieldSizeY; i++) {
            if (field[x][i] == dot)
                count++;
        }

        return count >= win;
    }

    static boolean checkColumn(int x, int y, char dot, int win) {
        int count = 0;
        for (int i = x; i < fieldSizeX; i++) {
            if (field[i][y] == dot)
                count++;
        }

        return count >= win;
    }

    static boolean checkDiagonalDown(int x, int y, char dot, int win) {
        int count = 0;
        int repeat = Math.max(x, y);
        for (int i = 0; i < fieldSizeY - repeat; i++) {
            if (field[x + i][y + i] == dot) {
                count++;
            }
        }
        return count >= win;
    }

    static boolean checkDiagonalUp(int x, int y, char dot, int win) {
        int count = 0;
        for (int i = 0; i < fieldSizeY - y ; i++) {
                try {
                    if (field[x-i][y+i] == dot) {
                        count++;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    break;
                }
            }
        return count >= win;
    }

    /**
     * Проверка состояния игры
     *
     * @param dot фишка игрока
     * @param s   победный слоган
     * @return состояние игры
     */
    static boolean checkState(char dot, String s) {
        if (checkWin(dot)) {
            System.out.println(s);
            return true;
        } else if (checkDraw()) {
            System.out.println("Ничья!");
            return true;
        }
        // Игра продолжается
        return false;
    }

}