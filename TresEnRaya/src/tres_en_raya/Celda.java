package tres_en_raya;

/**
 * Descripción de la clase Celda
 * 
 * @author Míriam Camarero Sierra
 * @version 1.0
 * 
 * Creación de la clase Celda que representa una celda en un tablero
 * Cada celda contiene un símbolo, una fila, una columna y un estado (si está ocupada o no)
 * 
 * @param simbolo char del símbolo que se usará dentro de la Celda
 * @param ocupado booleano que comprobará si la celda está o no está ocupada
 *
 */

public class Celda {
	
	//ATRIBUTOS
	/**Símbolo de la celda*/
	private char simbolo;
	
	/**Fila de la celda*/
	private int fila;
	
	/**Columna de la celda*/
	private int columna;
	
	/**Si está ocupada o no la celda*/
	private boolean ocupado;
	
	//CONSTRUCTORES
	/**
	 * Constructor con 4 parámetros
	 * @param simbolo el simbolo de la celda
	 * @param fila la fila de la celda
	 * @param columna la columna de la celda
	 * @param ocupado el estado de la celda
	 */
	public Celda(char simbolo, int fila, int columna, boolean ocupado) {
		this.simbolo=simbolo;
		this.fila=fila;
		this.columna=columna;
		this.ocupado=false;
	}

	//GETTERS Y SETTERS
	public char getSimbolo() {
		return simbolo;
	}

	public void setSimbolo(char simbolo) {
		this.simbolo = simbolo;
	}

	public int getFila() {
		return fila;
	}

	public void setFila(int fila) {
		this.fila = fila;
	}

	public int getColumna() {
		return columna;
	}

	public void setColumna(int columna) {
		this.columna = columna;
	}

	public boolean isOcupado() {
		return ocupado;
	}

	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}
	
	//MÉTODO TOSTRING
	/**
	 * Devuelve una representación en forma de cadena de la celda
	 * @return la representación de la celda como cadena
	 */
	public String toString() {
		return String.valueOf(simbolo);
	}
} //CIERRE DE LA CLASE CELDA