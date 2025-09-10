package pe.edu.universidad.investigodominio.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class UtilClases {

	public static Object obtenerObjeto(String nombreCompleto, Map<String, Object> map) {
		Class aclass = obtenerClase(nombreCompleto);
		Object obj = null;
		try {
			Constructor cons = aclass.getDeclaredConstructor();
			obj = cons.newInstance();
			copiarData(obj, map);
		} catch (NoSuchMethodException e) {
			throw new RuntimeException(e);
		} catch (SecurityException e) {
			throw new RuntimeException(e);
		} catch (InstantiationException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		} catch (IllegalArgumentException e) {
			throw new RuntimeException(e);
		} catch (InvocationTargetException e) {
			throw new RuntimeException(e);
		}
		return obj;
	}
	
	public static Object copiarData(Object obj, Map<String, Object> map) {
		try {
			for (String k : map.keySet()) {
				Field campo = obj.getClass().getDeclaredField(k);
				campo.setAccessible(true);  // permitir acceso si es privado
				campo.set(obj, map.get(k));
			}
		} catch (SecurityException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		} catch (IllegalArgumentException e) {
			throw new RuntimeException(e);
		} catch (NoSuchFieldException e) {
			throw new RuntimeException(e);
		}
		return obj;
	}
	
	public static Class obtenerClase(String nombreCompleto) {
		Class aclass = null;
		try {
			aclass = Class.forName(nombreCompleto);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		return aclass;
	}
}
