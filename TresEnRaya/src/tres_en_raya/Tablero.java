package tres_en_raya;

/**
 * Descripción de la clase Tablero
 * 
 * @author Míriam Camarero Sierra
 * @version 1.0
 * 
 * Creación de la clase Tablero que representa un tablero del juego "Tres en Raya"
 * 
 * @param Celda[][] es un array bidimensional de la clase Celda
 */

public class Tablero {

	//ATRIBUTOS
	/**Array bidimensional de la clase Celda*/
	private Celda[][] tablero;
	
	//CONSTRUCTOR
	/**
	 * Constructor de la clase Tablero
	 * Inicializa el tablero como una matriz de la clase Celda de tamaño 3x3
	 */
	public Tablero() {
		this.tablero = new Celda[3][3];
		for(int i=0; i < tablero.length;i++) { /*i=fila*/
			for(int j=0; j<tablero[i].length; j++) { /*j=columna*/
				this.tablero[i][j] = new Celda('-', i, j, false);
			}
		}
	}
	
	//GETTERS Y SETTERS
	/**
	 * Obtiene la celda del tablero en la posición especificada
	 * @param fila la fila de la celda
	 * @param columna la columna de la celda
	 * @return la celda en la posición indicada
	 */
	public Celda getCelda(int fila, int columna) {
		return tablero[fila][columna];
	}
	
	/**
	 * Establece el símbolo y el estado de la celda en la posición indicada
	 * @param fila la fila de la celda
	 * @param columna la columna de la celda
	 * @param simbolo el símbolo a establecer en la celda
	 */
	public void setCelda(int fila, int columna, char simbolo) {
		this.tablero[fila][columna].setSimbolo(simbolo);
		this.tablero[fila][columna].setOcupado(true);
	}
	
	//MÉTODO TOSTRING
	/**
	 * Devuelve una representación en forma de cadena del tablero de juego
	 * @param DeployedBoard String que se inicializa vacío
	 * @return Imprimirá el tablero vacío del "Tres en Raya"
	 */
	@Override
	public String toString() {
		String DeployedBoard = "";
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				DeployedBoard += "[" + this.tablero[i][j] + "]";
			}
			DeployedBoard += "\n";
		}
		return DeployedBoard;
	}
} //CIERRE DE LA CLASE TABLERO