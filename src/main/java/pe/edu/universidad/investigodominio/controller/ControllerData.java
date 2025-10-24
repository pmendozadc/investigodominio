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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import pe.edu.universidad.investigodominio.service.ServiceGenerico;

/**
 * Incluye documentacion OpenAPI para su generacion en la ruta /swagger-ui/index.html
 */
@RestController
public class ControllerData {

	
	private static final String strSql = "sql";
	@Autowired
	private ServiceGenerico serviceGenerico;
	
	@Operation(
	    summary = "Ejecutar una transaccion, la cual contiene multiples operaciones",
	    requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
	        content = @Content(
	            mediaType = "application/json",
	            schema = @Schema(type = "object", description = "Lista de objetos Operacion (c/r/u/d/dh/i/a)"),
	            examples = { 
            	@ExampleObject(
	                name = "Ejemplo con insert(c) y update(u)",
	                value = """
                    [
                    {"op":"c","entidad":"Proyecto","obj":{"nombre":"Proyecto tx 11"},"ret":true},
                	{"op":"u","entidad":"Proyecto","obj":{"id":1001,"nombre":"Proyecto tx actualizado","datIdHojaSeguimiento":"askldklasjd87cxzc8as8das"},"ret":true}
                	]
                    """
	            ),
	            @ExampleObject(
	                name = "Ejemplo con insert(c) y update(u) que usa el id generado",
	                value = """
                    [
                    {"op":"c","entidad":"Proyecto","obj":{"nombre":"Proyecto tx 11"},"ret":true,"key":"idProyecto"},
                	{"op":"u","entidad":"Proyecto","obj":{"id":1001,"nombre":"Proyecto tx actualizado","datIdHojaSeguimiento":"#keyidProyecto"},"ret":true}
                	]
                    """
	            ),
	            @ExampleObject(
	                name = "Ejemplo con select(q), e insert(c)",
	                value = """
                    [{"op":"q","sql":"SELECT id, nombre FROM proyecto","ret":true},
                    {"op":"c","entidad":"Proyecto","obj":{"nombre":"Proyecto tx 11"},"ret":true}
                	]
                    """
	            ),
	            @ExampleObject(
	                name = "Ejemplo con select(q) que retorna una sola columna, e insert(c) que se ejecuta iterativamente de acuerdo a los resultados del select",
	                value = """
	                [{"op":"q","sql":"SELECT nombre FROM proyecto ORDER BY nombre","ret":true,"var":"nombreProyecto"},
	                {"op":"c","entidad":"Proyecto","for":"nombreProyecto", "obj":{"nombre":"Proyecto tx","datIdHojaSeguimiento":"#var"},"ret":true}
	                ]
                    """
	            ),
	            @ExampleObject(
	                name = "Ejemplo con select(q) que retorna mas de una columna, e insert(c) que se ejecuta iterativamente de acuerdo a los resultados del select",
	                value = """
	                [{"op":"q","sql":"SELECT id,nombre FROM proyecto ORDER BY nombre","ret":true,"var":"nombreProyecto"},
	                {"op":"c","entidad":"Proyecto","for":"nombreProyecto", "obj":{"nombre":"Proyecto tx","datIdHojaSeguimiento":"#var[1]"},"ret":true}
	                ]
                    """
	            )
	            }
	        )
	    )
	)
	@PostMapping("/tx")
	public ResponseEntity postTransaccion(@RequestBody List<Map<String, Object>> lst) {
	    List<Object> lstRetorno = serviceGenerico.ejecutarTx(lst);
	    return ResponseEntity.ok(lstRetorno);
	}
	
	@Operation(
	    summary = "Insertar un objeto entidad en la tabla correspondiente",
	    requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
	        content = @Content(
	            mediaType = "application/json",
	            schema = @Schema(type = "object", description = "Objeto que contiene datos de acuerdo a la tabla de la entidad"),
	            examples = @ExampleObject(
	                name = "Ejemplo para entidad Proyecto que tiene la columna nombre",
	                value = """
                    {"nombre":"Proyecto tx 11"}
                    """
	            )
	        )
	    )
	)
	@PostMapping("/c/{entidad}")
	public ResponseEntity postEntidad(
			@Parameter(description = "Nombre de la tabla en estilo CamelCase",example = "CuentaGrupo",required = true,schema = @Schema(type = "String"))
			@PathVariable("entidad") String entidadNombre, @RequestBody Map<String, Object> map) {
	    Object obj = serviceGenerico.create(entidadNombre, map);
	    return ResponseEntity.ok(obj);
	}
	
	@Operation(summary = "Consultar un objeto entidad por su id en la tabla correspondiente")
	@GetMapping("/r/{entidad}/{id}")
	public ResponseEntity getEntidad(
			@Parameter(description = "Nombre de la tabla en estilo CamelCase",example = "CuentaGrupo",required = true,schema = @Schema(type = "String"))
			@PathVariable("entidad") String entidadNombre, 
			@Parameter(description = "Id del objeto a consultar",example = "1001",required = true,schema = @Schema(type = "int"))
			@PathVariable("id") int id) {
	    Optional entidadOpt = serviceGenerico.read(entidadNombre, id);
	    if (entidadOpt.isEmpty()) {
	        Map<String, String> response = new HashMap<>();
	        response.put("mensaje", "La entidad " + entidadNombre + " con ID " + id + " no fue encontrada.");
	        return ResponseEntity.badRequest().body(response);
	    }
	    return ResponseEntity.ok(entidadOpt.get());
	}
	
	@Operation(
	    summary = "Actualizar un objeto entidad en la tabla correspondiente",
	    requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
	        content = @Content(
	            mediaType = "application/json",
	            schema = @Schema(type = "object", description = "Objeto que contiene el campo id y los datos de acuerdo a la tabla de la entidad"),
	            examples = @ExampleObject(
	                name = "Ejemplo para entidad Proyecto que tiene la columna nombre",
	                value = """
                    {"id":1001,"nombre":"Proyecto actualizado"}
                    """
	            )
	        )
	    )
	)
	@PutMapping("/u/{entidad}")
	public ResponseEntity putEntidad(
			@Parameter(description = "Nombre de la tabla en estilo CamelCase",example = "CuentaGrupo",required = true,schema = @Schema(type = "String"))
			@PathVariable("entidad") String entidadNombre, @RequestBody Map<String, Object> map) {
		Optional entidadOpt = serviceGenerico.update(entidadNombre, map);
		if (entidadOpt.isEmpty()) {
	        Map<String, String> response = new HashMap<>();
	        response.put("mensaje", "La entidad " + entidadNombre + " con ID " + map.get("id") + " no fue encontrada.");
	        return ResponseEntity.badRequest().body(response);
	    }
	    return ResponseEntity.ok(entidadOpt.get());
	}
	
	@Operation(summary = "Eliminar logicamente un objeto entidad por id")
	@DeleteMapping("/d/{entidad}/{id}")
	public ResponseEntity deleteEntidad(
			@Parameter(description = "Nombre de la tabla en estilo CamelCase",example = "CuentaGrupo",required = true,schema = @Schema(type = "String"))
			@PathVariable("entidad") String entidadNombre, 
			@Parameter(description = "Id del objeto a eliminar",example = "1001",required = true,schema = @Schema(type = "int"))
			@PathVariable("id") int id) {
		Optional entidadOpt = serviceGenerico.delete(entidadNombre, id);
		if (entidadOpt.isEmpty()) {
	        Map<String, String> response = new HashMap<>();
	        response.put("mensaje", "La entidad " + entidadNombre + " con ID " + id + " no fue encontrada.");
	        return ResponseEntity.badRequest().body(response);
	    }
	    return ResponseEntity.ok(entidadOpt.get());
	}
	
	@Operation(summary = "Eliminar fisicamente un objeto entidad por id")
	@DeleteMapping("/dh/{entidad}/{id}")
	public ResponseEntity deleteHardEntidad(
			@Parameter(description = "Nombre de la tabla en estilo CamelCase",example = "CuentaGrupo",required = true,schema = @Schema(type = "String"))
			@PathVariable("entidad") String entidadNombre, 
			@Parameter(description = "Id del objeto a eliminar",example = "1001",required = true,schema = @Schema(type = "int"))
			@PathVariable("id") int id) {
		Optional entidadOpt = serviceGenerico.deleteHard(entidadNombre, id);
		if (entidadOpt.isEmpty()) {
	        Map<String, String> response = new HashMap<>();
	        response.put("mensaje", "La entidad " + entidadNombre + " con ID " + id + " no fue encontrada.");
	        return ResponseEntity.badRequest().body(response);
	    }
	    return ResponseEntity.ok(entidadOpt.get());
	}
	
	@Operation(summary = "Activar un objeto entidad por id. Actualiza la columna activo de la tabla correspondiente.")
	@PutMapping("/a/{entidad}/{id}")
	public ResponseEntity activarEntidad(
			@Parameter(description = "Nombre de la tabla en estilo CamelCase",example = "CuentaGrupo",required = true,schema = @Schema(type = "String"))
			@PathVariable("entidad") String entidadNombre, 
			@Parameter(description = "Id del objeto a activar",example = "1001",required = true,schema = @Schema(type = "int"))
			@PathVariable("id") int id) {
		Optional entidadOpt = serviceGenerico.activar(entidadNombre, id);
		if (entidadOpt.isEmpty()) {
	        Map<String, String> response = new HashMap<>();
	        response.put("mensaje", "La entidad " + entidadNombre + " con ID " + id + " no fue encontrada.");
	        return ResponseEntity.badRequest().body(response);
	    }
	    return ResponseEntity.ok(entidadOpt.get());
	}
	
	@Operation(summary = "Inactivar un objeto entidad por id. Actualiza la columna activo de la tabla correspondiente.")
	@PutMapping("/i/{entidad}/{id}")
	public ResponseEntity inactivarEntidad(
			@Parameter(description = "Nombre de la tabla en estilo CamelCase",example = "CuentaGrupo",required = true,schema = @Schema(type = "String"))
			@PathVariable("entidad") String entidadNombre, 
			@Parameter(description = "Id del objeto a inactivar",example = "1001",required = true,schema = @Schema(type = "int"))
			@PathVariable("id") int id) {
		Optional entidadOpt = serviceGenerico.inactivar(entidadNombre, id);
		if (entidadOpt.isEmpty()) {
	        Map<String, String> response = new HashMap<>();
	        response.put("mensaje", "La entidad " + entidadNombre + " con ID " + id + " no fue encontrada.");
	        return ResponseEntity.badRequest().body(response);
	    }
	    return ResponseEntity.ok(entidadOpt.get());
	}
	
	@Operation(
	    summary = "Ejecutar una consulta SQL",
	    requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
	        content = @Content(
	            mediaType = "application/json",
	            schema = @Schema(type = "object", description = "Objeto que contiene el campo sql, el cual contiene el SELECT a ejecutar."
	            		+ " El campo sql tambien puede ser un arreglo de cadenas con los SELECT."),
	            examples = {@ExampleObject(
	                name = "Ejemplo con un solo SELECT",
	                value = """
                    {"sql":"SELECT id, nombre FROM proyecto"}
                    """
	            ),
        		@ExampleObject(
	                name = "Ejemplo con multiples SELECT",
	                value = """
                    {"sql":["SELECT id, nombre FROM proyecto","SELECT MAX(nombre) FROM proyecto"]}
                    """
	            )}
	        )
	    )
	)
	@PostMapping("/q")
	public ResponseEntity consultarSQLNativo(@RequestBody Map<String, Object> map) {
		Object obj = map.get(strSql);
		if (obj == null) {
	        Map<String, String> response = new HashMap<>();
	        response.put("mensaje", "No fue encontrado el campo sql");
	        return ResponseEntity.badRequest().body(response);
	    }
		Object resultados = null;
		if (obj instanceof String) {
			String sql = (String) obj;
			try {
				resultados = serviceGenerico.consultarNativa(sql).get();
			} catch (Exception e) {
				Map<String, String> response = new HashMap<>();
		        response.put("mensaje", e.getMessage());
		        return ResponseEntity.badRequest().body(response);
			}
		} else if (obj instanceof List) {
			List<String> lst = (List<String>) obj;
			Object[] array = new Object[lst.size()];
			Optional opt = null;
			for (int i = 0; i < array.length; i++) {
				try {
					opt = serviceGenerico.consultarNativa(lst.get(i));
				} catch (Exception e) {
					Map<String, String> response = new HashMap<>();
			        response.put("mensaje", e.getMessage());
			        return ResponseEntity.badRequest().body(response);
				}
				array[i] = opt.get(); 
			}
			resultados = array;
		} else {
			Map<String, String> response = new HashMap<>();
	        response.put("mensaje", "El valor del campo sql debe ser una cadena o un arreglo de cadenas de consultas SQL");
	        return ResponseEntity.badRequest().body(response);
		}
	    
		return ResponseEntity.ok(resultados);
	}
}
