package ru.lazarev.lesson3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


/**
 * Homework for lesson #ru.lazarev.lesson2
 *
 * @author Valeriy Lazarev
 *
 * @since 03.04.2022
 */


@SuppressWarnings({"NewClassNamingConvention", "SpellCheckingInspection"})
public class MissingNumber {

  /*
  1. Дан массив из n элементов, начиная с 1. Каждый следующий элемент равен (предыдущий + 1).
  Но в массиве гарантированно 1 число пропущено. Необходимо вывести на экран пропущенное число.
  Примеры:
  [1, 2 ,3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14, 15, 16] => 11
  [1, 2, 4, 5, 6] => 3
  [2, 3, 4, 5, 6, 7, 8] => 1
  [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14] => 15
  [] => 1
   */

  private static Stream<Arguments> getArgs() {
    return Stream.of(
        Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14, 15, 16, 17}, 11),
        Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 14, 15, 16, 17}, 13),
        Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 17}, 16),
        Arguments.of(new int[]{1, 2, 3, 4, 5, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17}, 6),
        Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20}, 10),
        Arguments.of(new int[]{2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20}, 1),
        Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 21, 22, 23, 24, 25}, 20),
        Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25}, 7),
        Arguments.of(new int[]{1, 2, 4, 5, 6}, 3),
        Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14}, 15),
        Arguments.of(new int[]{}, 1));
  }

  @SuppressWarnings({"ConstantConditions"})
  public int search(int[] arr) {
    int result = 0;
    boolean flag = false;
    int base = 0;
    int i = 0;

    if (arr.length == 0) {
      result = 0;
    } else if (arr[arr.length - 1] == arr.length) {
      result = arr.length;
    } else {
      int start = 0;
      int end = arr.length - 1;
      while (end >= start) {
        i++;
        base = start + (end - start) / 2;

        final int indexValue = base + 1;
        final int value = arr[base];

        if (value != indexValue) {
          end = base - 1;
          flag = false;
        } else if (value == indexValue) {
          start = base + 1;
          flag = true;
        }

      }
    }
    result += flag ? base + 2 : base + 1;
    System.out.printf("Длинна маcсива: %d, число шагов поиска: %d, найденное число: %d\n", arr.length, i, result);
    return result;
  }

  @ParameterizedTest
  @MethodSource("getArgs")
  public void test(int[] ints, int expected) {
    assertEquals(expected, search(ints));
  }
}
