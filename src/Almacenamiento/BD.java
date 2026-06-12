package Almacenamiento;

import Modelo.*;

import java.util.ArrayList;

public class BD {

	// Constructor por defecto

	public BD() {

	}

	// Arreglos para almacenar objetos

	private static ArrayList<Perro> stockPerros = new ArrayList<>();
	private static ArrayList<Gato> stockGatos = new ArrayList<>();
	private static ArrayList<Serpiente> stockSerp = new ArrayList<>();
	private static ArrayList<Pez> stockPez = new ArrayList<>();
	private static ArrayList<Arania> stockAranias = new ArrayList<>();

	// Ventas

	private static ArrayList<Perro> ventaPerros = new ArrayList<>();
	private static ArrayList<Gato> ventaGatos = new ArrayList<>();
	private static ArrayList<Serpiente> ventaSerp = new ArrayList<>();
	private static ArrayList<Pez> ventaPez = new ArrayList<>();
	private static ArrayList<Arania> ventaAranias = new ArrayList<>();

	// Getters y Setters

	public static ArrayList<Perro> getStockPerros() {
		return stockPerros;
	}

	public static void setStockPerros(ArrayList<Perro> stockPerros) {
		BD.stockPerros = stockPerros;
	}

	public static ArrayList<Gato> getStockGatos() {
		return stockGatos;
	}

	public static void setStockGatos(ArrayList<Gato> stockGatos) {
		BD.stockGatos = stockGatos;
	}

	public static ArrayList<Serpiente> getStockSerp() {
		return stockSerp;
	}

	public static void setStockSerp(ArrayList<Serpiente> stockSerp) {
		BD.stockSerp = stockSerp;
	}

	public static ArrayList<Pez> getStockPez() {
		return stockPez;
	}

	public static void setStockPez(ArrayList<Pez> stockPez) {
		BD.stockPez = stockPez;
	}

	public static ArrayList<Arania> getStockAranias() {
		return stockAranias;
	}

	public static void setStockAranias(ArrayList<Arania> stockAranias) {
		BD.stockAranias = stockAranias;
	}

	public static ArrayList<Perro> getVentaPerros() {
		return ventaPerros;
	}

	public static void setVentaPerros(ArrayList<Perro> ventaPerros) {
		BD.ventaPerros = ventaPerros;
	}

	public static ArrayList<Gato> getVentaGatos() {
		return ventaGatos;
	}

	public static void setVentaGatos(ArrayList<Gato> ventaGatos) {
		BD.ventaGatos = ventaGatos;
	}

	public static ArrayList<Serpiente> getVentaSerp() {
		return ventaSerp;
	}

	public static void setVentaSerp(ArrayList<Serpiente> ventaSerp) {
		BD.ventaSerp = ventaSerp;
	}

	public static ArrayList<Pez> getVentaPez() {
		return ventaPez;
	}

	public static void setVentaPez(ArrayList<Pez> ventaPez) {
		BD.ventaPez = ventaPez;
	}

	public static ArrayList<Arania> getVentaAranias() {
		return ventaAranias;
	}

	public static void setVentaAranias(ArrayList<Arania> ventaAranias) {
		BD.ventaAranias = ventaAranias;
	}


}
