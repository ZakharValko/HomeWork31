package ua.alevel.homework31;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class Store {

    private Queue<Product> product = new ArrayDeque<>();

    public Queue<Product> getProduct() {
        return product;
    }

    public void setProduct(Queue<Product> product) {
        this.product = product;
    }

    public synchronized void get() {
        while (product.size()<1) {
            try {
                wait();
            }
            catch (InterruptedException e) {
            }
        }
        product.remove();
        System.out.println("Покупатель купил 1 товар");
        System.out.println("Товаров на складе: " + product.size());
        notify();
    }
    public synchronized void put() {
        while (product.size()>=3) {
            try {
                wait();
            }
            catch (InterruptedException e) {
            }
        }
        product.offer(new Product(1, "Title of product"));
        System.out.println("Производитель добавил 1 товар");
        System.out.println("Товаров на складе: " + product.size());
        notify();
    }
}
