package pe.edu.universidad.investigodominio.cu.proyecto;

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
public class TestCUProyecto {

    private final String baseUrl = "http://localhost:9090";
    private final String raizContexto = "/";
    private final String urlapp = baseUrl+raizContexto;

    private RestTemplate restTemplate = new RestTemplate();

    @Test
    @Order(1)
    /**
     * @Test Test usando endpoint /tx
     */
    void testAgregarEstadoProyectoDB() {

        List<Map<String, Object>> listaOperaciones = new ArrayList<Map<String,Object>>();
        Map<String, Object> mapEstadoProyecto = null;
        Map<String, Object> mapOperacion = null;

        // operacion que inserta un estado_proyecto
        mapEstadoProyecto = new HashMap<>();
        mapEstadoProyecto.put("nombre", "Estado proyecto test " +
                 java.time.OffsetDateTime.now().toString() );

        mapOperacion = new HashMap<>();
        mapOperacion.put("op", "c");
        mapOperacion.put("entidad", "EstadoProyecto");
        mapOperacion.put("obj", mapEstadoProyecto);
        mapOperacion.put("ret", true);
        listaOperaciones.add(mapOperacion);

        ResponseEntity<List> response = restTemplate.postForEntity(urlapp+"/tx", listaOperaciones, List.class);
        System.out.println("POST Response: "+response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    @Order(2)
    void testActivarEstadoProyectoDB() {
        Map<String, Object> mapEstadoProyecto = new HashMap<>();
        mapEstadoProyecto.put("id", 1007);
        mapEstadoProyecto.put("estado", true);
        ResponseEntity<Map> response = restTemplate.exchange(
                urlapp+"/u/EstadoProyecto",
                HttpMethod.PUT,
                new HttpEntity<>(mapEstadoProyecto),
                Map.class
        );
        System.out.println("PUT Response: "+response);
        assertEquals(HttpStatus.OK, response.getStatusCode());

    }

    @Test
    @Order(3)
    void testDesactivarEstadoProyectoDB() {
        List<Map<String, Object>> listaOperaciones = new ArrayList<Map<String,Object>>();
        Map<String, Object> mapEstadoProyecto = null;
        Map<String, Object> mapOperacion = null;

        // operacion que activa el estado de un registro estado_proyecto
        mapOperacion = new HashMap<>();
        mapOperacion.put("op", "d");
        mapOperacion.put("entidad", "EstadoProyecto");
        mapOperacion.put("id", 1007);
        mapOperacion.put("ret", true);

        listaOperaciones.add(mapOperacion);

        ResponseEntity<List> response = restTemplate.postForEntity(urlapp+"/tx", listaOperaciones, List.class);
        System.out.println("POST Response: "+response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
