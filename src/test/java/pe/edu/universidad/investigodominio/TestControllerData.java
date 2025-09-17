package pe.edu.universidad.investigodominio;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestControllerData {

	@Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testGetUsuario() {
        ResponseEntity<Map> response = restTemplate.getForEntity("/usuarios/1", Map.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        //Map<String, Object> map = response.getBody();
        
    }
}
