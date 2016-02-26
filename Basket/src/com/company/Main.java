package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main implements Basket{
    ArrayList<String> basket = new ArrayList<String>();

    @Override
    public void addProduct(String product, int quantity) {
        basket.add(product);
        basket.add(String.valueOf(quantity));
    }

    @Override
    public void removeProduct(String product) {
        for (int i = 0; i < basket.size(); i++) {
            if (product.equals(String.valueOf(basket.get(i)))) {
                basket.remove(i + 1);
                basket.remove(i);
            }
        }
    }

    @Override
    public void updateProductQuantity(String product, int quantity) {
        for (int i = 0; i < basket.size(); i++) {
            if (product.equals(String.valueOf(basket.get(i)))) {
                basket.set(i + 1, String.valueOf(quantity));
            }
        }
    }

    @Override
    public void clear() {
        basket.clear();
    }

    @Override
    public List<String> getProducts() {
        for (int i = 0; i < basket.size(); i = i + 2) {
            System.out.println(basket.get(i));
        }
        return null;
    }

    @Override
    public int getProductQuantity(String product) {
        for (int i = 0; i < basket.size(); i++) {
            if (product.equals(String.valueOf(basket.get(i)))) {
                System.out.println(basket.get(i + 1));
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int flag = 1, main = 1;
        Main basket = new Main();
	   while (flag == 1) {
           System.out.println("Выберите один из вариантов:");
           System.out.println("1 - добавить продукт");
           System.out.println("2 - удалить продукт");
           System.out.println("3 - изменить количество продукта");
           System.out.println("4 - очистить корзину");
           System.out.println("5 - вывести список продуктов в корзине");
           System.out.println("6 - получить количество продуктов");
           System.out.println("7 - выход");

           int i = 0;
           while (main == 1) {
               Scanner scanner = new Scanner(System.in);
               if (scanner.hasNextInt()) {
                   i = scanner.nextInt();
                   if (i == 1 || i == 2 || i == 3
                           || i == 4 || i == 5
                           || i == 6 || i == 7) {
                       main = 0;
                   } else {
                       System.out.println("Вы ошиблись в написание числа");
                   }
               } else {
                   System.out.println("Вы ввели не целое число, постарайтесь больше не ошибаться");
               }
           }

           if (i == 1) {
               System.out.println("Введите название продукта:");
               Scanner scanner = new Scanner(System.in);
               String product = scanner.nextLine();
               if (product.equals("")) {
                   System.out.println("Ошибка в название продукта");
                   main = 1;
               }
               else {
                   System.out.println("Введите количество:");
                   scanner = new Scanner(System.in);
                   if (scanner.hasNextInt()) {
                       int kol = scanner.nextInt();
                       basket.addProduct(product, kol);
                       main = 1;
                       System.out.println("Продукт успешно добавлен");
                   }
                   else {
                       System.out.println("Нужно было ввести число");
                       System.out.println("Возвращаем в главное меню");
                       main = 1;
                   }
               }
           }
           if (i == 2) {
               System.out.println("Введите название продукта:");
               Scanner scanner = new Scanner(System.in);
               String product = scanner.nextLine();
               basket.removeProduct(product);
               main = 1;
           }
           if (i == 3) {
               System.out.println("Введите название продукта:");
               Scanner scanner = new Scanner(System.in);
               String product = scanner.nextLine();
               System.out.println("Введите новое количество:");
               scanner = new Scanner(System.in);
               if (scanner.hasNextInt()) {
                   int kol = scanner.nextInt();
                   basket.updateProductQuantity(product, kol);
                   main = 1;
                   System.out.println("Продукт успешно изменен");
               }
               else {
                   System.out.println("Нужно было ввести число");
                   System.out.println("Возвращаем в главное меню");
                   main = 1;
               }
           }
           if (i == 4) {
               basket.clear();
               main = 1;
           }
           if (i == 5) {
               basket.getProducts();
               main = 1;
           }
           if (i == 6) {
               System.out.println("Введите название продукта:");
               Scanner scanner = new Scanner(System.in);
               String product = scanner.nextLine();
               basket.getProductQuantity(product);
               main = 1;
           }
           if (i == 7) {
               flag = 0;
           }
       }
    }
}
