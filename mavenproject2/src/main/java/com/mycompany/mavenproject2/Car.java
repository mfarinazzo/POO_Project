package com.mycompany.mavenproject2;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;



public class Car {
    private String marca;
    private String modelo;
    private int ano;

    public Car() {
        List<String> marcas = new ArrayList<>();
        marcas.add("Ford");
        marcas.add("Chevrolet");
        marcas.add("Toyota");
        marcas.add("Honda");
        marcas.add("Volkswagen");

        List<String> modelos = new ArrayList<>();
        modelos.add("Fiesta");
        modelos.add("Cruze");
        modelos.add("Corolla");
        modelos.add("Civic");
        modelos.add("Golf");

        List<Integer> anos = new ArrayList<>();
        anos.add(2015);
        anos.add(2016);
        anos.add(2017);
        anos.add(2018);
        anos.add(2019);

        Random random = new Random();
        this.marca = marcas.get(random.nextInt(marcas.size()));
        this.modelo = modelos.get(random.nextInt(modelos.size()));
        this.ano = anos.get(random.nextInt(anos.size()));
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAno() {
        return ano;
    }
}
