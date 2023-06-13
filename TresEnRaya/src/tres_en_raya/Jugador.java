package tres_en_raya;

/**
 * Descripción de la clase Juego
 * 
 * @author Míriam Camarero Sierra
 * @version 1.0
 * 
 * Creación de la clase Jugador que representa a un jugador del juego
 * 
 * @param nombre el nombre asociado al jugador
 * @param marca el símbolo o marca que asocia la casilla al jugador
 */

public class Jugador {
	
	//ATRIBUTOS
	/**El nombre del jugador*/
	private String nombre;
	
	/**El símbolo del jugador*/
	private char marca;
	
	//CONSTRUCTORES
	/**
	 * Crea un Jugador con el símbolo especificado
	 * El nombre del jugador se establece como vacío
	 * @param marca el símbolo del Jugador
	 */
	public Jugador(char marca) {
		this.setNombre("");
		this.marca=marca;
	}
	
	/**
	 * Crea un Jugador con el nombre y el símbolo especificados
	 * @param nombre el nombre del Jugador
	 * @param marca el símbolo del Jugador
	 */
	public Jugador(String nombre, char marca) {
		this.setNombre(nombre);
		this.marca = marca;
	}
	
	//GETTERS Y SETTERS
	public char getMarca() {
		return marca;
	}

	/**
	 * Asocia el símbolo del Jugador basándose en el símbolo anterior
	 * @param jugador el jugador cuyo símbolo se utilizará para establecer el símbolo
	 * @return true si el símbolo del jugador anterior es 'X'. Si es al contrario devuelve false
	 */
	public boolean setMarca(Jugador jugador) {
		boolean correcto;
		if(jugador.getMarca() == 'X') {
			marca = 'O';
			correcto = true;
		} else {
			this.marca = 'X';
			correcto = false;
		}
		return correcto;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
} //CIERRE DE LA CLASE JUGADOR