package ru.lazarev.lesson2;

import java.util.stream.Stream;
import ru.lazarev.lesson2.model.Notebook;
import ru.lazarev.lesson2.service.NotebookService;


/**
 * Homework for lesson #ru.lazarev.lesson2
 *
 * @author Valeriy Lazarev
 *
 * @since 03.04.2022
 */

@SuppressWarnings("ALL")
public class App {

  /*
   * 1. Отсортировать массив, состоящий из экземпляров класса Notebook в количестве 10000 штук.
   * Условия для сортировки:
   * 1) по цене. От 500 до 2000 долларов с шагом в 50
   * если цена равная, то
   * 2) по кол-ву оперативной памяти (от 4 до 24 с шагом 4)
   * если памяти тоже равное количество, то 3) по производителю:
   * Lenuvo > Asos > MacNote > Eser > Xamiou
   */


  private static final String[] names = {"Lenuvo", "Asos", "MacNote", "Eser", "Xamiou"};
  private static final int[] prices = new int[31];
  private static final int[] rams = new int[6];
  private static final int arrayCapacity = 10_000;
  private static final Notebook[] notebooks = new Notebook[arrayCapacity];


  public static void main(String[] args) {
    initPricesArray();
    initRamsArray();
    initNotebooksArray();

    final Notebook[] sortedNotebooks = NotebookService.sortNotebookArray(App.notebooks, true, true);

    arraysPrint(sortedNotebooks);
  }

  private static void arraysPrint(Notebook[] notebookArr) {
    for (Notebook notebook : notebookArr) {
      System.out.println(notebook);
    }
  }

  private static void initNotebooksArray() {
    Stream.iterate(0, n -> n += 1)
        .limit(App.arrayCapacity)
        .forEach(n -> App.notebooks[n] = new Notebook(randomPrice(), randomName(), randomRam()));
  }

  private static void initPricesArray() {
    Stream.iterate(0, n -> n += 1).limit(6).forEach(n -> rams[n] = Math.abs(n * 4 - 24));
  }

  private static void initRamsArray() {
    Stream.iterate(0, n -> n += 1).limit(31).forEach(n -> prices[n] = n * 50 + 500);
  }

  private static int randomRam() {
    return rams[(int) (Math.random() * 6)];
  }

  private static String randomName() {
    return names[(int) (Math.random() * 5)];
  }

  private static int randomPrice() {
    return prices[(int) (Math.random() * 31)];
  }
}
