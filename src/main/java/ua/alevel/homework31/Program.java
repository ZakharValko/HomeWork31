package ua.alevel.homework31;

import java.util.ArrayDeque;
import java.util.Queue;

public class Program {
    public static void main(String[] args) {

        Store store = new Store();
        Producer producer = new Producer(store);
        Consumer consumer = new Consumer(store);

        Product product1 = new Product(1, "Title");
        Queue<Product> productsInStock = new ArrayDeque<>();
        productsInStock.offer(product1);
        store.setProduct(productsInStock);

        new Thread(producer).start();
        new Thread(consumer).start();
    }
}
