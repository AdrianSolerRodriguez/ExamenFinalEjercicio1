package Ejercicio;

import java.io.IOException;

public class MatrizCalculator {
    public static void main(String[] args) {
        Matriz matrizA = new Matriz(3, 3);
        Matriz matrizC = new Matriz(3, 3);

        try {
            matrizA.cargarDesdeArchivo("matrizA.txt");
            matrizC.cargarDesdeArchivo("matrizC.txt");

            Matriz matrizB = matrizC.restar(matrizA);

            matrizB.guardarEnArchivo("matrizB.txt");
            matrizB.imprimir();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
