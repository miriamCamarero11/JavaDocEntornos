package tres_en_raya;

import java.util.Scanner;

/**
 * Descripción de la clase Juego
 * 
 * @author Míriam Camarero Sierra
 * @version 1.0
 * 
 * Creación de la clase Juego que representa el juego del "Tres en Raya"
 *
 */

public class Juego {
	
	//ATRIBUTOS
	/**Tablero del juego*/
	private Tablero tablero;
	
	/**Jugador 1*/
	private Jugador jugador1;
	
	/**Jugador 2*/
	private Jugador jugador2;
	
	/**Jugador ganador del juego*/
	private Jugador ganador;
	
	/**Indica el estado de la partida (si ha finalizado)*/
	private boolean finPartida;
	
	
	//CONSTRUCTOR
	/**
	 * Crea una nueva instancia de la clase Juego
	 * Inicializa el tablero, los dos jugadores y las variables de control
	 */
	public Juego() {
		this.tablero = new Tablero();
		this.jugador1 = new Jugador('X');
	    this.jugador2 = new Jugador('O');
	    this.finPartida = false;
	    this.ganador = null;
	}
	
	
	//GETTERS Y SETTERS
	/**
	 * Obtiene el tablero del juego
	 * @return el tablero del juego
	 */
	public Tablero getTablero() {
		return tablero;
	}
	
	/**
	 * Establece el tablero del juego
	 * @param tablero el tablero a establecer
	 */
	public void setTablero(Tablero tablero) {
		this.tablero = tablero;
	}
	
	/**
	 * Obtiene el jugador1 del juego
	 * @return el jugador 1 del juego
	 */
	public Jugador getJugador1() {
		return jugador1;
	}

	/**
	 * Establece el jugador1 del juego
	 * @param jugador1 el jugador 1 a establecer
	 */
	public void setJugador1(Jugador jugador1) {
		this.jugador1 = jugador1;
	}

	/**
	 * Obtiene el jugador2 del juego
	 * @return el jugador 2 del juego
	 */
	public Jugador getJugador2() {
		return jugador2;
	}

	/**
	 * Establece el jugador2 del juego
	 * @param jugador2 el jugador 2 a establecer
	 */
	public void setJugador2(Jugador jugador2) {
		this.jugador2 = jugador2;
	}

	/**
	 * Indica si la partida ha terminado
	 * @return true en caso de que la partida haya terminado, false en caso contrario
	 */
	public boolean isFinPartida() {
		return finPartida;
	}
	
	/**
	 * Establece si la partida ha terminado
	 * @param finPartida true si la partida ha terminado, false en caso contrario
	 */
	public void setFinPartida(boolean finPartida) {
		this.finPartida = finPartida;
	}
	
	/**
	 * Obtiene el jugador ganador del juego
	 * @return el jugador ganador del juego
	 */
	public Jugador getGanador() {
		return ganador;
	}

	/**
	 * Establece el jugador ganador del juego
	 * @param ganador el jugador ganador del juego
	 */
	public void setGanador(Jugador ganador) {
		this.ganador = ganador;
	}
	
	
	//MÉTODOS
	
	/**
	 * Método que pide al usuario una coordenada en el rango 0-2
	 * @param tipo el tipo de coordenada a pedir ("fila" o "columna")
	 * @return la coordenada introducida por el usuario
	 */
	public int pedirCoordenada(String tipo) {
		System.out.println("Introduce la " + tipo + " (0-2): ");
		Scanner sc = new Scanner(System.in);
		int coordenada = sc.nextInt();
		while (coordenada < 0 || coordenada > 2) {
			System.out.println("Coordenada no valida. Introduce la " + tipo + " (0-2): ");
			coordenada = sc.nextInt();
		}
		return coordenada;
	}
	
	/**
	 * Método que cambia el jugador actual al siguiente jugador
	 * @param jugadorActual
	 * @return Jugador1 o Jugador2 dependiendo de cual tenga asignado previamente
	 */
	public Jugador cambiarJugador(Jugador jugadorActual) {
		if (jugadorActual == this.jugador1) {
			return this.jugador2;
		} else {
			return this.jugador1;
		}
	}
	
	/**
	 * Método que comprueba si el Jugador dado ha ganado la partida
	 * 
	 * @param jugador el jugador a comprobar
	 * @return true si el jugador ha ganado, false en caso contrario
	 */
	public boolean comprobarVictoria(Jugador jugador) {
		//COMPROBAR FILAS
		for (int fila = 0; fila < 3; fila++) {
			if (tablero.getCelda(fila, 0).getSimbolo() == jugador.getMarca()
					&& tablero.getCelda(fila, 1).getSimbolo() == jugador.getMarca()
					&& tablero.getCelda(fila, 2).getSimbolo() == jugador.getMarca()) {
				setFinPartida(true);
			}
		}
		
		//COMPROBAR COLUMNAS
		for (int columna = 0; columna < 3; columna++) {
			if (tablero.getCelda(0, columna).getSimbolo() == jugador.getMarca()
					&& tablero.getCelda(1, columna).getSimbolo() == jugador.getMarca()
					&& tablero.getCelda(2, columna).getSimbolo() == jugador.getMarca()) {
				setFinPartida(true);
			}
		}
		
		//COMPROBAR DIAGONALES
		if (tablero.getCelda(0, 0).getSimbolo() == jugador.getMarca()
				&& tablero.getCelda(1, 1).getSimbolo() == jugador.getMarca()
				&& tablero.getCelda(2, 2).getSimbolo() == jugador.getMarca()) {
			setFinPartida(true);
		}
		if (tablero.getCelda(2, 0).getSimbolo() == jugador.getMarca()
				&& tablero.getCelda(1, 1).getSimbolo() == jugador.getMarca()
				&& tablero.getCelda(0, 2).getSimbolo() == jugador.getMarca()) {
			setFinPartida(true);
		}
		return isFinPartida();
	}
	
	/**
	 * Método que comprueba si la partida ha acabado en empate
	 * 
	 * @return true si la partida ha terminado en empate, false en caso contrario
	 */
	public boolean comprobarEmpate() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (!this.tablero.getCelda(i, j).isOcupado()) {
					setFinPartida(false);
				} else {
					setFinPartida(true);
				}
			}
		}
		return isFinPartida();
	}
} //CIERRE DE LA CLASE JUEGO