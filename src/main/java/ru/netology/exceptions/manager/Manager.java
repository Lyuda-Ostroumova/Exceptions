package ru.netology.exceptions.manager;

import ru.netology.exceptions.products.Product;
import ru.netology.exceptions.products.Book;
import ru.netology.exceptions.products.TShirt;
import ru.netology.exceptions.Repository;

public class Manager {

    private Repository repository;

    public Manager(Repository repository) {
        this.repository = repository;
    }

    public void add(Product product) {
        repository.add(product);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repository.getAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

    public boolean matches(Product product, String search) {
        if (product instanceof Book) { // если в параметре product лежит объект класса Book
            Book book = (Book) product; // положем его в переменную типа Book чтобы пользоваться методами класса Book
            if (book.getAuthor().contains(search)) { // проверим есть ли поисковое слово в данных об авторе
                return true;
            }
            if (book.getName().contains(search)) {
                return true;
            }
            return false;
        }
        if (product instanceof TShirt) { // если в параметре product лежит объект класса Book
            TShirt shirt = (TShirt) product; // положем его в переменную типа Book чтобы пользоваться методами класса Book
            if (shirt.getName().contains(search)) { // проверим есть ли поисковое слово в данных об авторе
                return true;
            }
            if (shirt.getColour().contains(search)) {
                return true;
            }
            return false;
        }

        return false;

    }

}

