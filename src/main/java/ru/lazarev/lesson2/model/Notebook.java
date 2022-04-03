package ru.lazarev.lesson2.model;

import java.util.Objects;

@SuppressWarnings("ALL")
public class Notebook {

  private static Long id = 1L;
  private int price;
  private String name;
  private int ram;

  public Notebook(int price, String name, int ramAmount) {
    this.price = price;
    this.name = name;
    this.ram = ramAmount;
    id = id + 1;
  }

  public static Long getId() {
    return id;
  }

  public int getPrice() {
    return price;
  }


  public String getName() {
    return name;
  }


  public int getRam() {
    return ram;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Notebook notebook = (Notebook) o;
    return price == notebook.price && ram == notebook.ram && Objects.equals(
        name, notebook.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(price, name, ram);
  }

  @Override
  public String toString() {
    return "Notebook{" +
        "price=" + price +
        ", ramAmount=" + ram +
        ", name='" + name + '\'' +
        '}';
  }
}
