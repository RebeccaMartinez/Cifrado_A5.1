package logica;

import java.util.ArrayList;


public class Traductor {
	
	//Pasamos los Strings que nos introducen a numero
	public static ArrayList<Integer> aNumero(String cad){
		ArrayList<Integer> cadena = new ArrayList<Integer>();
		
		//Pasamos string a un array de ints
		for(char c: cad.toCharArray()){
			cadena.add(Character.getNumericValue(c));
		}
		return cadena;
	}
	
	public static String generarZ(String reg1, String reg2, String reg3, String tam){
		ArrayList<Integer> r1 = aNumero(reg1);
		ArrayList<Integer> r2 = aNumero(reg2);
		ArrayList<Integer> r3 = aNumero(reg3);
		int taman = Integer.parseInt(tam);
		
		ArrayList<Integer> z = new ArrayList<Integer>(); //donde almacenamos el resultado
				
		int f; //valor que toma la función mayoría, cambia en cada iteración
		
		for(int i = 0; i < taman; i++){
			
			f = (r1.get(8)*r2.get(10)) ^ (r1.get(8)*r3.get(10)) ^ (r2.get(10)* r3.get(10)); 
			
			//Hacemos el xor de los elementos correspondientes de cada registro (siempre son esas posiciones por definición del algoritmo)
			int xorR1 = r1.get(13) ^ r1.get(16) ^ r1.get(17) ^ r1.get(18);
			int xorR2 = r2.get(20) ^ r2.get(21);
			int xorR3 = r3.get(7) ^ r3.get(20) ^ r3.get(21) ^ r3.get(22);
			
			//sacamos z que es la xor del ultimo bit de cada registro
			int aux = r1.get(18) ^ r2.get(21) ^ r3.get(22);
			z.add(i, aux); 
			
			
			/*add ademas de añadir los elementos, también rueda el resto, por tanto eliminamos el ultimo elemeto 
			 * de cada registro y añadimos el correspondiente al principio, de forma que el resto queda en su posicion + 1.
			 * Los registros solo se ruedan si el bit correspondiente (siempre el mismo) es igual a la funcion mayoria (f)*/
			
			if(r1.get(8) == f){
				//desplazamiento del registro 1
				r1.remove(r1.size() -1);
				r1.add(0, xorR1);
			}
			
			if(r2.get(10) == f){
				//desplazamiento del registro 2
				r2.remove(r2.size() -1);
				r2.add(0, xorR2);
			}
			
			if(r3.get(10) == f){
				//desplazamiento del registro 3
				r3.remove(r3.size() -1);
				r3.add(0, xorR3);
			}
		}
		
		//Pasamos z a String
		String resultado = "";
		for(int s : z){
			resultado += s;
		}
		
		return resultado;
	}
}

