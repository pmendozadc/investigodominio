package pe.edu.universidad.investigodominio;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestControllerData {

	private final String baseUrl = "http://localhost:9090";
	private final String raizContexto = "/";
	private final String urlapp = baseUrl+raizContexto;
	
	private RestTemplate restTemplate = new RestTemplate();

	@Test
	@Order(1)
    void testPostQuerySimple() { 
		Map<String, Object> mapQuery = new HashMap<String, Object>();
		mapQuery.put("sql", "SELECT id, nombre FROM proyecto");
        ResponseEntity<List> response = restTemplate.postForEntity(urlapp+"/q", mapQuery, List.class);
        System.out.println("POST Response: "+response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
	
	@Test
	@Order(2)
    void testPostQueryMultiple() {
		List<String> lstQuery = new ArrayList<String>();
		lstQuery.add("SELECT MAX(id) FROM proyecto");
		lstQuery.add("SELECT id FROM proyecto WHERE id < 1015");
		lstQuery.add("SELECT id, nombre FROM proyecto");
		Map<String, Object> mapQuery = new HashMap<String, Object>();
		mapQuery.put("sql", lstQuery);
        ResponseEntity<List> response = restTemplate.postForEntity(urlapp+"/q", mapQuery, List.class);
        System.out.println("POST Response: "+response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

	@Test
	@Order(3)
	void testPostTx() {
		List<Map<String, Object>> listaOperaciones = new ArrayList<Map<String,Object>>();
		Map<String, Object> mapProyecto = null;
		Map<String, Object> mapOperacion = null;
		mapProyecto = new HashMap<>();
		mapProyecto.put("nombre", "Proyecto de ejemplo tx 511");
		mapProyecto.put("idCuentaLider", 1001);
		// operacion que inserta un proyecto
		mapOperacion = new HashMap<>();
		mapOperacion.put("op", "c");
		mapOperacion.put("entidad", "Proyecto");
		mapOperacion.put("obj", mapProyecto);
		mapOperacion.put("key", "idProyecto");
		mapOperacion.put("ret", true);
		listaOperaciones.add(mapOperacion);
		mapProyecto = new HashMap<>();
		mapProyecto.put("nombre", "Proyecto de ejemplo tx 512");
		mapProyecto.put("idCuentaLider", 1003);
		mapProyecto.put("datIdHojaSeguimiento", "#keyidProyecto");
		// operacion que inserta otro proyecto que tiene un valor que llena con el id generado del proyecto anterior
		mapOperacion = new HashMap<>();
		mapOperacion.put("op", "c");
		mapOperacion.put("entidad", "Proyecto");
		mapOperacion.put("obj", mapProyecto);
		mapOperacion.put("ret", true);
		listaOperaciones.add(mapOperacion);
		// operacion que elimina logicamente un proyecto
		mapOperacion = new HashMap<>();
		mapOperacion.put("op", "d");
		mapOperacion.put("entidad", "Proyecto");
		mapOperacion.put("id", 1002);
		mapOperacion.put("ret", true);
		listaOperaciones.add(mapOperacion);
		ResponseEntity<List> response = restTemplate.postForEntity(urlapp+"/tx", listaOperaciones, List.class);
        System.out.println("POST Response: "+response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
	
    @Test
	void testPostProyecto() {
		Map<String, Object> mapProyecto = new HashMap<>();
		mapProyecto.put("nombre", "Proyecto de ejemplo2");
		mapProyecto.put("idCuentaLider", 1002);
        ResponseEntity<Map> response = restTemplate.postForEntity(urlapp+"/c/Proyecto", mapProyecto, Map.class);
        System.out.println("POST Response: "+response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
	
//    @Test
    void testGetProyecto() {
        ResponseEntity<Map> response = restTemplate.getForEntity(urlapp+"/r/Proyecto/1001", Map.class);
        System.out.println("GET Response: "+response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
    
//    @Test
    void testPutProyecto() {
		Map<String, Object> mapProyecto = new HashMap<>();
		mapProyecto.put("id", 1002);
		mapProyecto.put("nombre", "Proyecto de ejemplo de prueba actualizado");
		mapProyecto.put("emailLider", "lider@gmail.com");
        ResponseEntity<Map> response = restTemplate.exchange(
        		urlapp+"/u/Proyecto",
                HttpMethod.PUT,
                new HttpEntity<>(mapProyecto), 
                Map.class
            );
        System.out.println("PUT Response: "+response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
    
//    @Test
    void testDeleteProyecto() {
		int id = 1006;
        ResponseEntity<Map> response = restTemplate.exchange(
        		urlapp+"/d/Proyecto/"+id,
                HttpMethod.DELETE,
                null, 
                Map.class
            );
        System.out.println("DELETE Response: "+response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
    
//    @Test
    void testDeleteHardProyecto() {
		int id = 1013;
        ResponseEntity<Map> response = restTemplate.exchange(
        		urlapp+"/dh/Proyecto/"+id,
                HttpMethod.DELETE,
                null, 
                Map.class
            );
        System.out.println("DELETE HARD Response: "+response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
