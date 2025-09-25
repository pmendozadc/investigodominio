package pe.edu.universidad.investigodominio.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.universidad.investigodominio.dominio.Proyecto;
import pe.edu.universidad.investigodominio.service.ServiceGenerico;

@RestController
public class ControllerData {

	
	private static final String strSql = "sql";
	@Autowired
	private ServiceGenerico serviceGenerico;
	
	@PostMapping("/tx")
	public ResponseEntity postTransaccion(@RequestBody List<Map<String, Object>> lst) {
	    Map<String, Object> mapOps = lst.get(0);
	    Object obj = null;
	    //serviceGenerico.create(entidadNombre, map);
	    return ResponseEntity.ok(obj);
	}
	
	@PostMapping("/c/{entidad}")
	public ResponseEntity postEntidad(@PathVariable("entidad") String entidadNombre, @RequestBody Map<String, Object> map) {
	    Object obj = serviceGenerico.create(entidadNombre, map);
	    return ResponseEntity.ok(obj);
	}
	
	@GetMapping("/r/{entidad}/{id}")
	public ResponseEntity getEntidad(@PathVariable("entidad") String entidadNombre, @PathVariable("id") int id) {
	    Optional entidadOpt = serviceGenerico.read(entidadNombre, id);
	    if (entidadOpt.isEmpty()) {
	        Map<String, String> response = new HashMap<>();
	        response.put("mensaje", "La entidad " + entidadNombre + " con ID " + id + " no fue encontrada.");
	        return ResponseEntity.badRequest().body(response);
	    }
	    return ResponseEntity.ok(entidadOpt.get());
	}
	
	@PutMapping("/u/{entidad}")
	public ResponseEntity putEntidad(@PathVariable("entidad") String entidadNombre, @RequestBody Map<String, Object> map) {
		Optional entidadOpt = serviceGenerico.update(entidadNombre, map);
		if (entidadOpt.isEmpty()) {
	        Map<String, String> response = new HashMap<>();
	        response.put("mensaje", "La entidad " + entidadNombre + " con ID " + map.get("id") + " no fue encontrada.");
	        return ResponseEntity.badRequest().body(response);
	    }
	    return ResponseEntity.ok(entidadOpt.get());
	}
	
	@DeleteMapping("/d/{entidad}/{id}")
	public ResponseEntity deleteEntidad(@PathVariable("entidad") String entidadNombre, @PathVariable("id") int id) {
		Optional entidadOpt = serviceGenerico.delete(entidadNombre, id);
		if (entidadOpt.isEmpty()) {
	        Map<String, String> response = new HashMap<>();
	        response.put("mensaje", "La entidad " + entidadNombre + " con ID " + id + " no fue encontrada.");
	        return ResponseEntity.badRequest().body(response);
	    }
	    return ResponseEntity.ok(entidadOpt.get());
	}
	
	@DeleteMapping("/dh/{entidad}/{id}")
	public ResponseEntity deleteHardEntidad(@PathVariable("entidad") String entidadNombre, @PathVariable("id") int id) {
		Optional entidadOpt = serviceGenerico.deleteHard(entidadNombre, id);
		if (entidadOpt.isEmpty()) {
	        Map<String, String> response = new HashMap<>();
	        response.put("mensaje", "La entidad " + entidadNombre + " con ID " + id + " no fue encontrada.");
	        return ResponseEntity.badRequest().body(response);
	    }
	    return ResponseEntity.ok(entidadOpt.get());
	}
	
	@PutMapping("/a/{entidad}/{id}")
	public ResponseEntity activarEntidad(@PathVariable("entidad") String entidadNombre, @PathVariable("id") int id) {
		Optional entidadOpt = serviceGenerico.activar(entidadNombre, id);
		if (entidadOpt.isEmpty()) {
	        Map<String, String> response = new HashMap<>();
	        response.put("mensaje", "La entidad " + entidadNombre + " con ID " + id + " no fue encontrada.");
	        return ResponseEntity.badRequest().body(response);
	    }
	    return ResponseEntity.ok(entidadOpt.get());
	}
	
	@PutMapping("/i/{entidad}/{id}")
	public ResponseEntity inactivarEntidad(@PathVariable("entidad") String entidadNombre, @PathVariable("id") int id) {
		Optional entidadOpt = serviceGenerico.inactivar(entidadNombre, id);
		if (entidadOpt.isEmpty()) {
	        Map<String, String> response = new HashMap<>();
	        response.put("mensaje", "La entidad " + entidadNombre + " con ID " + id + " no fue encontrada.");
	        return ResponseEntity.badRequest().body(response);
	    }
	    return ResponseEntity.ok(entidadOpt.get());
	}
	@PostMapping("/n")
	public ResponseEntity consultarSQLNativo(@RequestBody Map<String, Object> map) {
		String sql = (String) map.get(strSql);
		if (sql == null) {
	        Map<String, String> response = new HashMap<>();
	        response.put("mensaje", "No fue encontrado el campo sql");
	        return ResponseEntity.badRequest().body(response);
	    }
	    Optional resultados = serviceGenerico.consultarNativa(sql);
		return ResponseEntity.ok(resultados.get());
	}
}
