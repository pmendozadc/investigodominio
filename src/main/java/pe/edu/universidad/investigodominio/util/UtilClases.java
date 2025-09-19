package pe.edu.universidad.investigodominio.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Map;

public class UtilClases {

	private static final String strDosPunto = ":";
	private static final String strAmericaLima = "America/Lima";

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
				String nombreCampo = k;
				Object valor = map.get(k);
				if (nombreCampo.startsWith(strDosPunto)) {
					ZoneId zonaLima = ZoneId.of(strAmericaLima);
			        LocalDateTime fechaLocal = LocalDateTime.parse(valor.toString());
			        ZonedDateTime fechaZoned = fechaLocal.atZone(zonaLima);
			        OffsetDateTime fechaOffset = fechaZoned.toOffsetDateTime();
			        valor = fechaOffset;
			        nombreCampo = nombreCampo.substring(1);
				}
				Field campo = obj.getClass().getDeclaredField(nombreCampo);
				campo.setAccessible(true);  // permitir acceso si es privado
				campo.set(obj, valor);
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
	
	public static Object establecerDato(Object obj, String campo, Object valor) {
		try {
			Field field = obj.getClass().getDeclaredField(campo);
			field.setAccessible(true);  // permitir acceso si es privado
			field.set(obj, valor);
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
	
	public static Object obtenerDato(Object obj, String campo) {
		Object valor = null;
		try {
			Field field = obj.getClass().getDeclaredField(campo);
			field.setAccessible(true);  // permitir acceso si es privado
			valor = field.get(obj);
		} catch (SecurityException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		} catch (IllegalArgumentException e) {
			throw new RuntimeException(e);
		} catch (NoSuchFieldException e) {
			throw new RuntimeException(e);
		}
		return valor;
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
