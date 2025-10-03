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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestRepartoAbel {

    private final String baseUrl = "http://localhost:9090";
    private final String raizContexto = "/";
    private final String urlapp = baseUrl + raizContexto;

    private RestTemplate restTemplate = new RestTemplate();

    @Test
    @Order(1)
    void testGuardarReparto() {
        // Crear la transacción con múltiples operaciones
        List<Map<String, Object>> listaOperaciones = new ArrayList<>();

        // 1. Crear el Reparto
        Map<String, Object> mapReparto = new HashMap<>();
        mapReparto.put("idPlantilla", 1001); // Asume que existe una plantilla con id=1
        mapReparto.put("idGrupo", 1002); // Asume que existe un grupo con id=1
        mapReparto.put("datIdCarpetaReparto", "17_R6Ha0xMPECY9CufVD3LVvHeklUM7ZNuhTovgGfSEw");

        Map<String, Object> operacionReparto = new HashMap<>();
        operacionReparto.put("op", "c");
        operacionReparto.put("entidad", "Reparto");
        operacionReparto.put("obj", mapReparto);
        operacionReparto.put("key", "idReparto"); // Guardar el ID generado con esta clave
        operacionReparto.put("ret", true);
        listaOperaciones.add(operacionReparto);

        // 2. Crear primera EtiquetaReparto
        Map<String, Object> mapEtiquetaReparto1 = new HashMap<>();
        mapEtiquetaReparto1.put("idEtiqueta", 1001); // Asume que existe una etiqueta con id=1
        mapEtiquetaReparto1.put("idReparto", "#keyidReparto"); // Referencia al ID del reparto creado

        Map<String, Object> operacionEtiqueta1 = new HashMap<>();
        operacionEtiqueta1.put("op", "c");
        operacionEtiqueta1.put("entidad", "EtiquetaReparto");
        operacionEtiqueta1.put("obj", mapEtiquetaReparto1);
        operacionEtiqueta1.put("ret", true);
        listaOperaciones.add(operacionEtiqueta1);

        // 3. Crear segunda EtiquetaReparto
        Map<String, Object> mapEtiquetaReparto2 = new HashMap<>();
        mapEtiquetaReparto2.put("idEtiqueta", 1002); // Asume que existe una etiqueta con id=2
        mapEtiquetaReparto2.put("idReparto", "#keyidReparto"); // Referencia al ID del reparto creado

        Map<String, Object> operacionEtiqueta2 = new HashMap<>();
        operacionEtiqueta2.put("op", "c");
        operacionEtiqueta2.put("entidad", "EtiquetaReparto");
        operacionEtiqueta2.put("obj", mapEtiquetaReparto2);
        operacionEtiqueta2.put("ret", true);
        listaOperaciones.add(operacionEtiqueta2);
        listaOperaciones.add(operacionEtiqueta2);

        // 4. Crear tercera EtiquetaReparto
        Map<String, Object> mapEtiquetaReparto3 = new HashMap<>();
        mapEtiquetaReparto3.put("idEtiqueta", 1003); // Asume que existe una etiqueta con id=3
        mapEtiquetaReparto3.put("idReparto", "#keyidReparto"); // Referencia al ID del reparto creado

        Map<String, Object> operacionEtiqueta3 = new HashMap<>();
        operacionEtiqueta3.put("op", "c");
        operacionEtiqueta3.put("entidad", "EtiquetaReparto");
        operacionEtiqueta3.put("obj", mapEtiquetaReparto3);
        operacionEtiqueta3.put("ret", true);
        listaOperaciones.add(operacionEtiqueta3);

        // Ejecutar la transacción
        ResponseEntity<List> response = restTemplate.postForEntity(
                urlapp + "/tx",
                listaOperaciones,
                List.class
        );

        System.out.println("POST GuardarReparto Response: " + response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
    @Test
    @Order(2)
    void testObtenerRepartosDePlantilla() {
        // Usar múltiples queries SQL para obtener la información completa
        List<String> lstQuery = new ArrayList<>();

        // Query 1: Obtener repartos de la plantilla con información del grupo
        lstQuery.add(
                "SELECT r.id as idReparto, r.id_grupo as id_grupo, g.nombre as nombre_grupo, " +
                        "r.created_date as createDate, r.estado " +
                        "FROM reparto r " +
                        "INNER JOIN grupo g ON r.id_grupo = g.id " +
                        "WHERE r.id_plantilla = 1001 AND r.estado = true"
        );

        // Query 2: Obtener etiquetas de los repartos
        lstQuery.add(
                "SELECT er.id_reparto, e.id, e.nombre, e.color " +
                        "FROM etiqueta_reparto er " +
                        "INNER JOIN etiqueta e ON er.id_etiqueta = e.id " +
                        "INNER JOIN reparto r ON er.id_reparto = r.id " +
                        "WHERE r.id_plantilla = 1001 AND er.estado = true AND e.estado = true"
        );

        Map<String, Object> mapQuery = new HashMap<>();
        mapQuery.put("sql", lstQuery);

        ResponseEntity<List> response = restTemplate.postForEntity(
                urlapp + "/q",
                mapQuery,
                List.class
        );

        System.out.println("POST ObtenerRepartosDePlantilla Response: " + response);
        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    @Order(3)
    void testObtenerDetalleRepartoPorID() {
        // Usar múltiples queries SQL para obtener toda la información
        List<String> lstQuery = new ArrayList<>();

        // Query 1: Obtener información básica del reparto
        lstQuery.add(
                "SELECT r.id as idReparto, r.id_plantilla as idPlantilla, " +
                        "r.dat_id_carpeta_reparto as datIdCarpeta, r.created_date as createDate " +
                        "FROM reparto r WHERE r.id = 1001 AND r.estado = true"
        );

        // Query 2: Obtener cuentas del grupo asociado al reparto
        lstQuery.add(
                "SELECT c.id, c.nombre_completo as nombre, c.email " +
                        "FROM reparto r " +
                        "INNER JOIN relacion_cuenta_grupo rcg ON r.id_grupo = rcg.id_grupo " +
                        "INNER JOIN cuenta c ON rcg.id_cuenta = c.id " +
                        "WHERE r.id = 1001 AND rcg.estado = true AND c.estado = true"
        );

        // Query 3: Obtener copias con datIdDocumento
        lstQuery.add(
                "SELECT c.id, c.nombre, c.dat_id_documento as datIdDocumento " +
                        "FROM copia c WHERE c.id_reparto = 1001 AND c.estado = true"
        );

        Map<String, Object> mapQuery = new HashMap<>();
        mapQuery.put("sql", lstQuery);

        ResponseEntity<List> response = restTemplate.postForEntity(
                urlapp + "/q",
                mapQuery,
                List.class
        );

        System.out.println("POST ObtenerDetalleRepartoPorID Response: " + response);
        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}