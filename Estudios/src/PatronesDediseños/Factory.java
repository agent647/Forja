package PatronesDediseños;

import java.util.*;

//SINGLETON : Un objeto para usarlo globlalmente en toda la aplicacion.
//            Esto soluciona si tenemos que usar un objeto en varias clases, no tengamos que instanciarlo n veces en todas,
//            Sino que llamamos a un metodo que nos da la refencia del objeto con el cual queremos trabajar.


//            Paso 1: Crear un atributo private  static que tenga como tipo la misma clase.	(Se puede inicializar o no)
//            Paso 2: Poner el constructor privado asi nadie mas puede hacer otro objeto de esta clase.
//            Paso 3: Crear un metodo static que devuelva el tipo de la clase y retornamos el atributo que creamos en el paso 1.


//Ahora esta clase se puede usar en todo el programa LLamando a Factory.getFactory();

public final class Factory {
	 	
	 	private static Factory factory;
	 	
	 	private Map<String, Integer> references;

	    private int reference;
	    
	    private Factory() {
	        this.references = new HashMap<>();
	        this.reference = 0;
	    }

	    public int getReference(String key) {
	        return references.computeIfAbsent(key, k -> reference++);
	    }

	    public void removeReference(String key) {
	        this.references.remove(key);
	    }
	    
	    public static Factory getFactory() {
	    	
	    	if(Factory.factory == null) {
	    		Factory.factory = new Factory();
	    	}
	    	
	    	return Factory.factory;
	    }

}
