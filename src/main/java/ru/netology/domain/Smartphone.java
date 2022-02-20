package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Smartphone extends Product {
    private String nameSmartphone;
    private String manufacturer;

    public Smartphone(int id, String nameProduct, int price, String nameSmartphone, String manufacturer) {
        super(id, nameProduct, price);
        this.nameSmartphone = nameSmartphone;
        this.manufacturer = manufacturer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Smartphone that = (Smartphone) o;
        return Objects.equals(nameSmartphone, that.nameSmartphone) && Objects.equals(manufacturer, that.manufacturer);
    }

}
