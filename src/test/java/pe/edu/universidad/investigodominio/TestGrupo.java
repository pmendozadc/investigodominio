package pe.edu.universidad.investigodominio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
public class TestGrupo {

    private final String baseUrl = "http://localhost:9090";
    private final String raizContexto = "/";
    private final String urlapp = baseUrl+raizContexto;

    private RestTemplate restTemplate = new RestTemplate();

    // CREAR UNA NUEVA CUENTA
    @Test
    @Order(1)
    void testCrearGrupo() {
        Map<String, Object> mapRelacion = new HashMap<>();
        mapRelacion.put("nombre", "Test grupo nuevo");


        ResponseEntity<Map> response = restTemplate.postForEntity(
                urlapp + "/c/Grupo",
                mapRelacion,
                Map.class
        );

        System.out.println("POST Response (Crear Grupo): " + response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    //ACTUALIZAR GRUPO
    @Test
    @Order(1)
    void testActualizarNombreGrupo() {
        Map<String, Object> mapGrupo = new HashMap<>();
        mapGrupo.put("id", 1011);
        mapGrupo.put("nombre", "Grupo de ejemplo de prueba actualizado");
        ResponseEntity<Map> response = restTemplate.exchange(
                urlapp+"/u/Grupo",
                HttpMethod.PUT,
                new HttpEntity<>(mapGrupo),
                Map.class
        );
        System.out.println("PUT Response: "+response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }


    //CAMBIAR EL ESTADO DE UN GRUPO
    @Test
    @Order(2)
    void testCambiarEstadoGrupo() {
        Map<String, Object> mapGrupo = new HashMap<>();
        mapGrupo.put("id", 1001);
        mapGrupo.put("estado", false);  // Cambiar estado a false (inactivo)

        ResponseEntity<Map> response = restTemplate.exchange(
                urlapp + "/u/Grupo",
                HttpMethod.PUT,
                new HttpEntity<>(mapGrupo),
                Map.class
        );

        System.out.println("PUT Response (Cambiar Estado): " + response);
        assertEquals(HttpStatus.OK, response.getStatusCode());

        // Verificar que el estado se cambió correctamente
        Map<String, Object> responseBody = response.getBody();
        assertNotNull(responseBody);
        assertEquals(false, responseBody.get("estado"));
    }

    // AGREGAR INTEGRANTE A UN GRUPO
    @Test
    @Order(3)
    void testAgregarIntegranteGrupo() {
        Map<String, Object> mapRelacion = new HashMap<>();
        mapRelacion.put("idGrupo", 1001);
        mapRelacion.put("idCuenta", 1001);

        ResponseEntity<Map> response = restTemplate.postForEntity(
                urlapp + "/c/RelacionCuentaGrupo",
                mapRelacion,
                Map.class
        );

        System.out.println("POST Response (Agregar Integrante): " + response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    //TRANSACCION CREAR GRUPO Y AGREGAR INTEGRANTE
    @Test
    @Order(4)
    void testPostTxCrearGrupoYAgregarIntegrante() {
        List<Map<String, Object>> listaOperaciones = new ArrayList<>();

        // Operación 1: Crear un grupo
        Map<String, Object> mapGrupo = new HashMap<>();
        mapGrupo.put("nombre", "Grupo de Investigación 2025");
        mapGrupo.put("datIdCarpeta", "gpr-sIgma-2024-009");

        Map<String, Object> operacion1 = new HashMap<>();
        operacion1.put("op", "c");
        operacion1.put("entidad", "Grupo");
        operacion1.put("obj", mapGrupo);
        operacion1.put("key", "idGrupo");  // Guardar el ID generado
        operacion1.put("ret", true);
        listaOperaciones.add(operacion1);

        // Operación 2: Agregar integrante al grupo recién creado
        Map<String, Object> mapRelacion = new HashMap<>();
        mapRelacion.put("idGrupo", "#keyidGrupo");  // Usar el ID del grupo creado
        mapRelacion.put("idCuenta", 1001);

        Map<String, Object> operacion2 = new HashMap<>();
        operacion2.put("op", "c");
        operacion2.put("entidad", "RelacionCuentaGrupo");
        operacion2.put("obj", mapRelacion);
        operacion2.put("ret", true);
        listaOperaciones.add(operacion2);

        ResponseEntity<List> response = restTemplate.postForEntity(
                urlapp + "/tx",
                listaOperaciones,
                List.class
        );

        System.out.println("POST TX Response (Crear Grupo + Integrante): " + response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    //TRANSACCION CREAR GRUPO Y AGREGAR INTEGRANTE MULTIPLES
    @Test
    @Order(5)
    void testPostTxAgregarMultiplesIntegrantesGrupo() {
        List<Map<String, Object>> listaOperaciones = new ArrayList<>();

        int idGrupo = 1012;  // Grupo existente
        int[] idsCuentas = {1001, 1002, 1003, 1004};  // Múltiples cuentas

        for (int idCuenta : idsCuentas) {
            Map<String, Object> mapRelacion = new HashMap<>();
            mapRelacion.put("idGrupo", idGrupo);
            mapRelacion.put("idCuenta", idCuenta);

            Map<String, Object> operacion = new HashMap<>();
            operacion.put("op", "c");
            operacion.put("entidad", "RelacionCuentaGrupo");
            operacion.put("obj", mapRelacion);
            operacion.put("ret", true);
            listaOperaciones.add(operacion);
        }

        ResponseEntity<List> response = restTemplate.postForEntity(
                urlapp + "/tx",
                listaOperaciones,
                List.class
        );

        System.out.println("POST TX Response (Múltiples Integrantes): " + response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }


    // TRANSACCION PARA DUPLICAR GRUPO
    @Test
    @Order(8)
    void testPostTxDuplicarGrupoCompleto() {
        int idGrupoOriginal = 1001;

        // Paso 1: Obtener los datos del grupo original
        ResponseEntity<Map> responseGrupoOriginal = restTemplate.getForEntity(
                urlapp + "/r/Grupo/" + idGrupoOriginal,
                Map.class
        );
        Map<String, Object> grupoOriginal = responseGrupoOriginal.getBody();
        System.out.println("Grupo Original: " + grupoOriginal);

        // Paso 2: Consultar los integrantes del grupo original
        Map<String, Object> mapQuery = new HashMap<>();
        mapQuery.put("sql", "SELECT id, id_grupo, id_cuenta FROM relacion_cuenta_grupo WHERE id_grupo = " + idGrupoOriginal + " AND estado = true");

        ResponseEntity<List> responseIntegrantes = restTemplate.postForEntity(
                urlapp + "/q",
                mapQuery,
                List.class
        );
        List<Map<String, Object>> integrantes = responseIntegrantes.getBody();
        System.out.println("Integrantes encontrados: " + integrantes.size());
        System.out.println("Integrantes: " + integrantes);

        // Paso 3: Construir la transacción de duplicación
        List<Map<String, Object>> listaOperaciones = new ArrayList<>();

        // Operación 1: Crear el nuevo grupo (copia del original)
        Map<String, Object> mapGrupoNuevo = new HashMap<>();
        mapGrupoNuevo.put("nombre", grupoOriginal.get("nombre") + " - COPIA");
        mapGrupoNuevo.put("estado", true);  // El nuevo grupo estará activo

        // Copiar idCarpeta si existe (con sufijo para diferenciarlo)
        if (grupoOriginal.get("idCarpeta") != null) {
            String idCarpetaOriginal = grupoOriginal.get("idCarpeta").toString();
            mapGrupoNuevo.put("idCarpeta", idCarpetaOriginal + "-COPY");
        }

        Map<String, Object> operacion1 = new HashMap<>();
        operacion1.put("op", "c");
        operacion1.put("entidad", "Grupo");
        operacion1.put("obj", mapGrupoNuevo);
        operacion1.put("key", "idGrupoNuevo");
        operacion1.put("ret", true);
        listaOperaciones.add(operacion1);

        // Operaciones 2-N: Copiar cada integrante activo al nuevo grupo
        for (Map<String, Object> integrante : integrantes) {
            Map<String, Object> mapRelacion = new HashMap<>();
            mapRelacion.put("idGrupo", "#keyidGrupoNuevo");  // Referencia al nuevo grupo
            mapRelacion.put("idCuenta", integrante.get("id_cuenta"));

            Map<String, Object> operacion = new HashMap<>();
            operacion.put("op", "c");
            operacion.put("entidad", "RelacionCuentaGrupo");
            operacion.put("obj", mapRelacion);
            operacion.put("ret", true);
            listaOperaciones.add(operacion);
        }

        System.out.println("Total de operaciones en transacción: " + listaOperaciones.size());

        // Paso 4: Ejecutar la transacción
        ResponseEntity<List> response = restTemplate.postForEntity(
                urlapp + "/tx",
                listaOperaciones,
                List.class
        );

        System.out.println("POST TX Response (Duplicar Grupo): " + response);
        List<?> resultados = response.getBody();
        System.out.println("Operaciones exitosas: " + resultados.size());

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(listaOperaciones.size(), resultados.size());
    }
}


