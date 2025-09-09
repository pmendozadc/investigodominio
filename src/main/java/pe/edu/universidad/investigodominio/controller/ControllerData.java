package pe.edu.universidad.investigodominio.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.universidad.investigodominio.service.ServiceGenerico;

@RestController
public class ControllerData {

	
	@Autowired
	private ServiceGenerico serviceGenerico;
	
	@GetMapping("/r/{entidad}/{id}")
	public ResponseEntity getEntidad(@PathVariable("entidad") String entidadNombre, @PathVariable("id") int id) {
	    Optional entidadOpt = serviceGenerico.read(entidadNombre, id);
	    return ResponseEntity.ok(entidadOpt.get());
	}
	
	@PostMapping("/c/{entidad}")
	public ResponseEntity postEntidad(@PathVariable("entidad") String entidadNombre, @RequestBody Map<String, Object> map) {
	    
		System.out.println("map: " + map);
	    return ResponseEntity.ok(map);
	}
}
