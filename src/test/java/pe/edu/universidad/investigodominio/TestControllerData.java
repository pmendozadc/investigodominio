package pe.edu.universidad.investigodominio;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestControllerData {

	@Autowired
    private TestRestTemplate restTemplate;

	@Test
	@Order(1)
    void testPostProyecto() {
		Map<String, String> mapProyecto = new HashMap<>();
		mapProyecto.put("nombre", "Proyecto de ejemplo");
		mapProyecto.put("emailLider", "lider@gmail.com");
        ResponseEntity<Map> response = restTemplate.postForEntity("/c/Proyecto", mapProyecto, Map.class);
        System.out.println(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        //Map<String, Object> map = response.getBody();
        
    }
	
    @Test
    @Order(2)
    void testGetProyecto() {
        ResponseEntity<Map> response = restTemplate.getForEntity("/r/Proyecto/1001", Map.class);
        System.out.println(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        //Map<String, Object> map = response.getBody();
        
    }
}
