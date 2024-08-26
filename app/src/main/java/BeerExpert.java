package com.example.tracker;

import java.util.ArrayList;
import java.util.List;

public class BeerExpert{
    public List<String> getBrands(String color) {
        List<String> brands = new ArrayList<>();

        switch (color) {
            case "Google":
                brands.add("Do the right thing!");
                break;
            case "Meta":
                brands.add("Move fast and build things!");
                break;
            case "Apple":
                brands.add("Think different!");
                break;
            case "Amazon":
                brands.add("Work hard, Have fun, Make history");
                break;
            case "Netflix":
                brands.add("To Entertain The World");
                break;
            default:
                brands.add("Remember there is dark inside!");
                break;

        }

        return brands;
    }
}
