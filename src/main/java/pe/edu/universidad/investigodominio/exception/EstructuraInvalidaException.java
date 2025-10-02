package pe.edu.universidad.investigodominio.exception;

public class EstructuraInvalidaException extends RuntimeException {

	public EstructuraInvalidaException() {
		
	}
	
	public EstructuraInvalidaException(String mensaje) {
		super(mensaje);
	}
}
