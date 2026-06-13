package Almacenamiento;

import Modelo.*;

import java.util.ArrayList;

/**
 * Clase que simula una base de datos en memoria almacenando las listas de animales
 * en stock y los animales que han sido vendidos.
 */
public class BD {

	/**
	 * Constructor por defecto de la clase BD.
	 */
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

	/**
	 * Obtiene la lista de perros en stock.
	 *
	 * @return Lista de perros disponibles.
	 */
	public static ArrayList<Perro> getStockPerros() {
		return stockPerros;
	}

	/**
	 * Establece la lista de perros en stock.
	 *
	 * @param stockPerros Lista de perros a establecer como stock.
	 */
	public static void setStockPerros(ArrayList<Perro> stockPerros) {
		BD.stockPerros = stockPerros;
	}

	/**
	 * Obtiene la lista de gatos en stock.
	 *
	 * @return Lista de gatos disponibles.
	 */
	public static ArrayList<Gato> getStockGatos() {
		return stockGatos;
	}

	/**
	 * Establece la lista de gatos en stock.
	 *
	 * @param stockGatos Lista de gatos a establecer como stock.
	 */
	public static void setStockGatos(ArrayList<Gato> stockGatos) {
		BD.stockGatos = stockGatos;
	}

	/**
	 * Obtiene la lista de serpientes en stock.
	 *
	 * @return Lista de serpientes disponibles.
	 */
	public static ArrayList<Serpiente> getStockSerp() {
		return stockSerp;
	}

	/**
	 * Establece la lista de serpientes en stock.
	 *
	 * @param stockSerp Lista de serpientes a establecer como stock.
	 */
	public static void setStockSerp(ArrayList<Serpiente> stockSerp) {
		BD.stockSerp = stockSerp;
	}

	/**
	 * Obtiene la lista de peces en stock.
	 *
	 * @return Lista de peces disponibles.
	 */
	public static ArrayList<Pez> getStockPez() {
		return stockPez;
	}

	/**
	 * Establece la lista de peces en stock.
	 *
	 * @param stockPez Lista de peces a establecer como stock.
	 */
	public static void setStockPez(ArrayList<Pez> stockPez) {
		BD.stockPez = stockPez;
	}

	/**
	 * Obtiene la lista de arañas en stock.
	 *
	 * @return Lista de arañas disponibles.
	 */
	public static ArrayList<Arania> getStockAranias() {
		return stockAranias;
	}

	/**
	 * Establece la lista de arañas en stock.
	 *
	 * @param stockAranias Lista de arañas a establecer como stock.
	 */
	public static void setStockAranias(ArrayList<Arania> stockAranias) {
		BD.stockAranias = stockAranias;
	}

	/**
	 * Obtiene la lista de perros vendidos.
	 *
	 * @return Lista de perros vendidos.
	 */
	public static ArrayList<Perro> getVentaPerros() {
		return ventaPerros;
	}

	/**
	 * Establece la lista de perros vendidos.
	 *
	 * @param ventaPerros Lista de perros a establecer como vendidos.
	 */
	public static void setVentaPerros(ArrayList<Perro> ventaPerros) {
		BD.ventaPerros = ventaPerros;
	}

	/**
	 * Obtiene la lista de gatos vendidos.
	 *
	 * @return Lista de gatos vendidos.
	 */
	public static ArrayList<Gato> getVentaGatos() {
		return ventaGatos;
	}

	/**
	 * Establece la lista de gatos vendidos.
	 *
	 * @param ventaGatos Lista de gatos a establecer como vendidos.
	 */
	public static void setVentaGatos(ArrayList<Gato> ventaGatos) {
		BD.ventaGatos = ventaGatos;
	}

	/**
	 * Obtiene la lista de serpientes vendidas.
	 *
	 * @return Lista de serpientes vendidas.
	 */
	public static ArrayList<Serpiente> getVentaSerp() {
		return ventaSerp;
	}

	/**
	 * Establece la lista de serpientes vendidas.
	 *
	 * @param ventaSerp Lista de serpientes a establecer como vendidas.
	 */
	public static void setVentaSerp(ArrayList<Serpiente> ventaSerp) {
		BD.ventaSerp = ventaSerp;
	}

	/**
	 * Obtiene la lista de peces vendidos.
	 *
	 * @return Lista de peces vendidos.
	 */
	public static ArrayList<Pez> getVentaPez() {
		return ventaPez;
	}

	/**
	 * Establece la lista de peces vendidos.
	 *
	 * @param ventaPez Lista de peces a establecer como vendidos.
	 */
	public static void setVentaPez(ArrayList<Pez> ventaPez) {
		BD.ventaPez = ventaPez;
	}

	/**
	 * Obtiene la lista de arañas vendidas.
	 *
	 * @return Lista de arañas vendidas.
	 */
	public static ArrayList<Arania> getVentaAranias() {
		return ventaAranias;
	}

	/**
	 * Establece la lista de arañas vendidas.
	 *
	 * @param ventaAranias Lista de arañas a establecer como vendidas.
	 */
	public static void setVentaAranias(ArrayList<Arania> ventaAranias) {
		BD.ventaAranias = ventaAranias;
	}

}
