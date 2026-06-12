package Controlador;

public class ControladorValidacion{
	public ControladorValidacion() {
	}

	public boolean valEntero(String cadena){
		try {
			Integer.parseInt(cadena);
			return true;
		}catch(NumberFormatException e){
			return false;
		}
	}

	public boolean valFloat(String cadena){
		try {
			Float.parseFloat(cadena);
			return true;
		}catch(NumberFormatException e){
			return false;
		}
	}
	public boolean valDouble(String cadena){
		try {
			Double.parseDouble(cadena);
			return true;
		}catch(NumberFormatException e){
			return false;
		}
	}
}
