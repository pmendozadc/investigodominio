package pe.edu.universidad.investigodominio.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	private final static String strErr = "err";
	private final static String strTrc = "trc";
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> manejarExceptionGeneral(Exception ex) {
		Map<String, Object> body = new HashMap<>();
		body.put(strErr, ex.getMessage());
		StringWriter stringWriter = new StringWriter();
		PrintWriter printWriter = new PrintWriter(stringWriter);
        ex.printStackTrace(printWriter); // Escribe el stacktrace en el PrintWriter
        body.put(strTrc, stringWriter.toString());
		return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
