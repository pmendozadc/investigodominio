package pe.edu.universidad.investigodominio;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import pe.edu.universidad.investigodominio.dominio.Proyecto;
import pe.edu.universidad.investigodominio.util.UtilClases;

public class TestUtilClases {

	private static final String strClaseDominio = "pe.edu.universidad.investigodominio.dominio.";
	
	private static final String strClaseProyecto = "pe.edu.universidad.investigodominio.dominio.Proyecto";

	@Test
	public void testClaseInexistente() {
		try {
			Class aclass = UtilClases.obtenerClase(strClaseDominio+"Inexistente");
		} catch (Exception e) {
			assertEquals(ClassNotFoundException.class, e.getCause().getClass());
		}
	}
	
	@Test
	public void testObjetoClaseInexistente() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", "1");
		map.put("nombre", "Proyecto de ejemplo");
		try {
			Object obj = UtilClases.obtenerObjeto(strClaseDominio+"Inexistente", map );
		} catch (Exception e) {
			assertEquals(ClassNotFoundException.class, e.getCause().getClass());
		}
	}
	
	@Test
	public void testCrearProyectoMinimo() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", 2);
		map.put("nombre", "Proyecto de ejemplo");
		Object obj = UtilClases.obtenerObjeto(strClaseProyecto, map );
		assertEquals(Proyecto.class, obj.getClass());
		Proyecto p = (Proyecto) obj;
		assertEquals(2, p.getId());
		assertEquals("Proyecto de ejemplo", p.getNombre());
	}
	
	@Test
	public void testCrearProyectoIdEnCadena() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", "hola");
		map.put("nombre", "Proyecto de ejemplo");
		try {
			Object obj = UtilClases.obtenerObjeto(strClaseProyecto, map );
		} catch (Exception e) {
			assertEquals(IllegalArgumentException.class, e.getCause().getClass());
		}
	}
	
	@Test
	public void testCrearProyectoCampoInexistente() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("campoNoExistente", "hola");
		map.put("nombre", "Proyecto de ejemplo");
		try {
			Object obj = UtilClases.obtenerObjeto(strClaseProyecto, map );
		} catch (Exception e) {
			assertEquals(NoSuchFieldException.class, e.getCause().getClass());
		}
	}
}
