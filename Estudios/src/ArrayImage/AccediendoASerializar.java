package ArrayImage;

import java.io.*;

public class AccediendoASerializar {	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ArrayBytes = null;
		try {			
			ObjectInputStream inputObject = new ObjectInputStream(new FileInputStream("C:/Users/anests1a/Desktop/data.txt")); 
			ArrayBytes =(int[])inputObject.readObject();
			inputObject.close();
		}catch(Exception e) {
			
		}
		
		try {
			FileOutputStream arrayDeserializado = new FileOutputStream("C:/Users/anests1a/Desktop/imag.jpg");
			for(int i = 0; i < ArrayBytes.length; i++) {
				arrayDeserializado.write(ArrayBytes[i]);
				}
			arrayDeserializado.close();
		}catch(IOException e) {
				
		}
	}
}


