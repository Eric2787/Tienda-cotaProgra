package Modelo;

import java.io.Serializable;

/**
 * Clase base que representa a un animal general.
 * Implementa Serializable para permitir su almacenamiento en archivos.
 */
public class Animal implements Serializable{
	// Atributos de la clase Animal
	private String nombre;
	private String raza;
	private String color;
	private int edad;
	private float tamanio;
	private float peso;
	private float precio;
	private boolean sexo;
	private String alimentacion;
	private String modoReproduccion;

	// Getters y Setters

	/**
	 * Obtiene el nombre del animal.
	 *
	 * @return El nombre del animal.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece el nombre del animal.
	 *
	 * @param nombre El nombre a establecer.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene la raza del animal.
	 *
	 * @return La raza del animal.
	 */
	public String getRaza() {
		return raza;
	}

	/**
	 * Establece la raza del animal.
	 *
	 * @param raza La raza a establecer.
	 */
	public void setRaza(String raza) {
		this.raza = raza;
	}

	/**
	 * Obtiene el color del animal.
	 *
	 * @return El color del animal.
	 */
	public String getColor() {
		return color;
	}

	/**
	 * Establece el color del animal.
	 *
	 * @param color El color a establecer.
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * Obtiene la edad del animal en años.
	 *
	 * @return La edad del animal.
	 */
	public int getEdad() {
		return edad;
	}

	/**
	 * Establece la edad del animal en años.
	 *
	 * @param edad La edad a establecer.
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}

	/**
	 * Obtiene el tamaño del animal.
	 *
	 * @return El tamaño del animal.
	 */
	public float getTamanio() {
		return tamanio;
	}

	/**
	 * Establece el tamaño del animal.
	 *
	 * @param tamanio El tamaño a establecer.
	 */
	public void setTamanio(float tamanio) {
		this.tamanio = tamanio;
	}

	/**
	 * Obtiene el peso del animal.
	 *
	 * @return El peso del animal.
	 */
	public float getPeso() {
		return peso;
	}

	/**
	 * Establece el peso del animal.
	 *
	 * @param peso El peso a establecer.
	 */
	public void setPeso(float peso) {
		this.peso = peso;
	}

	/**
	 * Obtiene el precio del animal.
	 *
	 * @return El precio del animal.
	 */
	public float getPrecio() {
		return precio;
	}

	/**
	 * Establece el precio del animal.
	 *
	 * @param precio El precio a establecer.
	 */
	public void setPrecio(float precio) {
		this.precio = precio;
	}

	/**
	 * Obtiene el sexo del animal (verdadero para un sexo, falso para otro).
	 *
	 * @return El sexo del animal.
	 */
	public boolean getSexo() {
		return sexo;
	}

	/**
	 * Establece el sexo del animal.
	 *
	 * @param sexo El sexo a establecer.
	 */
	public void setSexo(boolean sexo) {
		this.sexo = sexo;
	}

	/**
	 * Obtiene el tipo de alimentación del animal.
	 *
	 * @return El tipo de alimentación.
	 */
	public String getAlimentacion() {
		return alimentacion;
	}

	/**
	 * Establece el tipo de alimentación del animal.
	 *
	 * @param alimentacion El tipo de alimentación a establecer.
	 */
	public void setAlimentacion(String alimentacion) {
		this.alimentacion = alimentacion;
	}

	/**
	 * Obtiene el modo de reproducción del animal.
	 *
	 * @return El modo de reproducción.
	 */
	public String getModoReproduccion() {
		return modoReproduccion;
	}

	/**
	 * Establece el modo de reproducción del animal.
	 *
	 * @param modoReproduccion El modo de reproducción a establecer.
	 */
	public void setModoReproduccion(String modoReproduccion) {
		this.modoReproduccion = modoReproduccion;
	}

}
