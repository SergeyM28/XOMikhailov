package org.example;

/*
    2. Предположить, что числа в исходном массиве из 9 элементов имеют диапазон[0, 3], и представляют собой,
    например, состояния ячеек поля для игры в крестикинолики, где 0 – это пустое поле, 1 – это поле с крестиком,
    2 – это поле с ноликом, 3 – резервное значение. Такое предположение позволит хранить в одном числе
    типа int всё поле 3х3. Реализовать функционал с записью в файл и обратно игрового поля. Выводить в
    консоль игровое поле после импорта, заменяя числа символами X, O, •(пусто)
*/

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Field field = new Field();
        try {
            FieldSaver fieldSaver = new FieldSaver();

            // Придумаем состояние поля в виде числового кода
            // Вместо массива я храню состояние поля в строке длинной в 9 символов
            String code1 = "012012000";
            // Преобразуем код в поле
            String state1 = field.transferCodeToVoew(code1);
            // Выведем в консоль код и вид поля
            System.out.println(state1);
            System.out.println(code1 + "\n");
            // Сохраним ход в файл. Для это преобразуем вид поля обратно в числовой код. Сохраним код в файл
            fieldSaver.saveFieldState(field.transferViewToCode(state1));
            // Прочтем код из файла
            String code2 = fieldSaver.readFieldState();
            System.out.println(code2 + "\n");
            // Преобразуем код снова в игровое поле
            System.out.println(field.transferCodeToVoew(code2));
        } catch (IOException e) {
            throw new RuntimeException(String.valueOf(e.getStackTrace()));
        }
    }
}
