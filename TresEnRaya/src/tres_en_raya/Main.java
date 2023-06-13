package tres_en_raya;

import java.util.Scanner;

/**
 * Descripción del Método Principal (Main)
 * 
 * @author Míriam Camarero Sierra
 * @version 1.0
 *
 * Clase Main del programa
 * 
 * @param juego
 * @param jugadorActual
 * @param fila
 * @param columna
 */

public class Main {
	/**
	 * Método principal (Main) que inicia la ejecución del programa
	 * @param args
	 */
	public static void main(String[] args) {
		/**Definición de constantes de color*/
		final String ANSI_RESET = "\u001B[0m";
		final String ANSI_RED = "\u001B[31m";
		final String ANSI_GREEN = "\u001B[32m";
		final String ANSI_YELLOW = "\u001B[33m";
		final String ANSI_BLUE = "\u001B[34m";
		final String ANSI_PURPLE = "\u001B[35m";
		final String ANSI_CYAN = "\u001B[36m";
		final String ANSI_WHITE = "\u001B[37m";
		
		Scanner sc = new Scanner(System.in);
		
		/**Creación de un juego*/
		Juego juego = new Juego();
		
		/**Pedir y establecer el nombre del Jugador 1*/
		System.out.println("Introduzca su nombre (PJ1, marca 'X'): ");
		juego.getJugador1().setNombre(ANSI_GREEN + sc.next() + ANSI_RESET);
		
		/**Pedir y establecer el nombre del Jugador 2*/
		System.out.println("Introduzca su nombre (PJ2, marca '0'): ");
		juego.getJugador2().setNombre(ANSI_CYAN + sc.next() + ANSI_RESET);
		
		System.out.println(juego.getTablero());
		
		Jugador jugadorActual = juego.getJugador1();
		
		/**Bucle principal del juego*/
		while (!juego.isFinPartida()) {
			int fila = juego.pedirCoordenada(ANSI_BLUE + "fila" + ANSI_RESET);
			int columna = juego.pedirCoordenada(ANSI_PURPLE + "columna" + ANSI_RESET);
			if (!juego.getTablero().getCelda(fila, columna).isOcupado()) {
				juego.getTablero().setCelda(fila, columna, jugadorActual.getMarca());
				System.out.println(juego.getTablero());
				
				/**Comprobar si el jugador actual ha ganado*/
				if (juego.comprobarVictoria(jugadorActual)) {
					juego.setFinPartida(true);
					juego.setGanador(jugadorActual);
				} else {
					/**Cambiar al siguiente jugador*/
					jugadorActual = juego.cambiarJugador(jugadorActual);
				}
			} else {
				System.out.println(ANSI_RED + "Esta celda ya esta ocupada. Introduce otra coordenada." + ANSI_RESET);
			}
		}
		
		/**Mostrar el resultado del juego*/
		if (juego.comprobarEmpate()) {
			System.out.println("Empate de" + juego.getJugador1().getNombre() + " y " + juego.getJugador2().getNombre() + ".");
		} else if (juego.getGanador() != null) {
			System.out.println(ANSI_WHITE + "FELICIDADES, " + ANSI_RESET + juego.getGanador().getNombre() + ANSI_YELLOW
					+ " con la marca (" + ANSI_RESET + juego.getGanador().getMarca() + ANSI_YELLOW + ") has ganado la partida."
					+ ANSI_RESET);
		}
	}
}