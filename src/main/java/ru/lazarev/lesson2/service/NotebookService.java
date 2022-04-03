package ru.lazarev.lesson2.service;

import java.util.Arrays;
import ru.lazarev.lesson2.model.Notebook;

public class NotebookService {

  public static Notebook[] sortNotebookArray(Notebook[] notebooks, boolean nameSort, boolean ramSort) {
    Notebook[] result  = Arrays.copyOf(notebooks, notebooks.length);

    for (int i = 0; i < result.length - 1; i++) {
      for (int j = 0; j < result.length - 1; j++) {
        if (result[j].getPrice() > result[j + 1].getPrice()) {
          swap(j, result);
        }
        if (result[j].getPrice() == result[j + 1].getPrice() && nameSort) {
          if (result[j].getRam() > result[j + 1].getRam()) {
            swap(j, result);
          }
          if (result[j].getRam() == result[j + 1].getRam() && ramSort) {
            if (result[j].getName().charAt(0) > result[j + 1].getName().charAt(0)) {
              swap(j, result);
            }
          }
        }
      }
    }
    return result;
  }

  private static void swap(int i, Notebook[] arr) {
    Notebook temp = arr[i];
    arr[i] = arr[i + 1];
    arr[i + 1] = temp;
  }
}
