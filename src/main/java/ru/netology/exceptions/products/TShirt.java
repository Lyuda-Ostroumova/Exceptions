package ru.netology.exceptions.products;

import java.util.Objects;

public class TShirt extends Product {
    private String colour;
    private int size;

    public TShirt() {
        super();
    }

    public TShirt(int id, String name, int price, String colour, int size) {
        super(id, name, price);
        this.colour = colour;
        this.size = size;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TShirt tShirt = (TShirt) o;
        return size == tShirt.size && Objects.equals(colour, tShirt.colour);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), colour, size);
    }
}
