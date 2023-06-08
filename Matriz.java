package Ejercicio;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Matriz {
    private int[][] matriz;
    private int filas;
    private int columnas;

    public Matriz(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        this.matriz = new int[filas][columnas];
    }

    public void cargarDesdeArchivo(String archivo) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            int fila = 0;
            while ((linea = br.readLine()) != null) {
                String[] elementos = linea.split(" ");
                for (int i = 0; i < elementos.length; i++) {
                    matriz[fila][i] = Integer.parseInt(elementos[i]);
                }
                fila++;
            }
        }
    }

    public void guardarEnArchivo(String archivo) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    bw.write(String.valueOf(matriz[i][j]));
                    if (j < columnas - 1) {
                        bw.write(" ");
                    }
                }
                bw.newLine();
            }
        }
    }

    public Matriz sumar(Matriz otraMatriz) {
        Matriz resultado = new Matriz(filas, columnas);
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                resultado.matriz[i][j] = matriz[i][j] + otraMatriz.matriz[i][j];
            }
        }
        return resultado;
    }

    public Matriz restar(Matriz otraMatriz) {
        Matriz resultado = new Matriz(filas, columnas);
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                resultado.matriz[i][j] = matriz[i][j] - otraMatriz.matriz[i][j];
            }
        }
        return resultado;
    }

    public int getFilas() {
        return filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public void imprimir() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
}
