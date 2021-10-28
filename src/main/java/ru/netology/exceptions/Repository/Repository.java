package ru.netology.exceptions.Repository;

import ru.netology.exceptions.exception.NotFoundException;
import ru.netology.exceptions.products.Product;
import ru.netology.exceptions.products.Book;
import ru.netology.exceptions.products.TShirt;


public class Repository {

    private Product[] products = new Product[0];

    public void add(Product product) {
        int length = products.length + 1;
        Product[] tmp = new Product[length];
        System.arraycopy(products, 0, tmp, 0, products.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = product;
        products = tmp;
    }

    public Product[] getAll() {
        return products;
    }

    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public void removeById(int id) {
        if (findById(id) == null) {
            throw new NotFoundException("Element with id" + " " + id + " " + "not found");
        } else {
            int length = products.length - 1;
            Product[] tmp = new Product[length];
            int index = 0;
            for (Product item : products) {
                if (item.getId() != id) {
                    tmp[index] = item;
                    index++;
                }

                products = tmp;
            }

        }

    }
}
