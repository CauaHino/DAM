package main;

import java.io.*;
import java.util.ArrayList;
import electrodomestico.*;

public class Main {

    public static void main(String[] args) {
        ArrayList<Electrodomestico> electrodomesticos = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("electrodomesticos.txt"))) {
            String linea;
            
            while ((linea = br.readLine()) != null) {
                if ("lavadora".equalsIgnoreCase(linea)) {
                    double precio = Double.parseDouble(br.readLine());
                    double peso = Double.parseDouble(br.readLine());
                    char consumo = br.readLine().charAt(0);
                    String color = br.readLine();
                    double carga = Double.parseDouble(br.readLine());

                    Lavadora la = new Lavadora(precio, peso, consumo, color, carga);
                    electrodomesticos.add(la);

                } else if ("lavadora2".equalsIgnoreCase(linea)) {
                    double precio = Double.parseDouble(br.readLine());
                    double peso = Double.parseDouble(br.readLine());
                    
                    electrodomesticos.add(new Lavadora(precio, peso));

                } else if ("television".equalsIgnoreCase(linea)) {
                    double precio = Double.parseDouble(br.readLine());
                    double peso = Double.parseDouble(br.readLine());
                    char consumo = br.readLine().charAt(0);
                    String color = br.readLine();
                    int pulgadas = Integer.parseInt(br.readLine());
                    boolean smartTv = Boolean.parseBoolean(br.readLine());

                    electrodomesticos.add(new Television(precio, peso, consumo, color, pulgadas, smartTv));

                } else if ("television2".equalsIgnoreCase(linea)) {
                    double precio = Double.parseDouble(br.readLine());
                    double peso = Double.parseDouble(br.readLine());

                    electrodomesticos.add(new Television(precio, peso));
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("No se encontró el archivo: " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("--- Listado de Electrodomésticos ---");
        for (Electrodomestico e : electrodomesticos) {
            System.out.println(e.toString());
        }
    }
}