package ArrayImage;

import java.io.*;



public class StreamByteImage {
	
	int[] BytesArrayImage; 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int CountBytesOfImage = 0;
		int[] BytesArrayImage = new int[702941];
		int valueByte = 0;
		try {
			FileInputStream imageTransformByte = new FileInputStream("C:/Users/anests1a/Desktop/itali.jpg");
			boolean finalImageSize = false;
			
			while(!finalImageSize) {
				valueByte = imageTransformByte.read();				
				if(valueByte != -1)					
					BytesArrayImage[CountBytesOfImage] = valueByte; 
				else
					finalImageSize = true;
				CountBytesOfImage++;
					
			}
			imageTransformByte.close();
		}catch(IOException e) {
			
		}		
		System.out.print(CountBytesOfImage); 
		//PasteCopyImage(BytesArrayImage);
		//SerializarObjeto(BytesArrayImage);
		//try {
			//FileOutputStream prueba = new FileOutputStream("C:/Users/anests1a/Desktop/archivo.dir");
			//prueba.close();
		//}catch(IOException e) {
			
		//}
		File directorio = new File("");
		System.out.println(directorio.mkdir());
		
	}
	
	static public void PasteCopyImage(int[] BytesArrayImage) {
		String path ="C:/Users/anests1a/Desktop/";
		String NameNewFile = "imagen";
		String Extension = ".jpg";		
		try {			
			for(int g = 0; g < 20; g++) {
				String PathCompleto = path+NameNewFile+Extension;
				FileOutputStream copyOfImage = new FileOutputStream(PathCompleto);
				for(int i = 0; i < BytesArrayImage.length; i++) {
					copyOfImage.write(BytesArrayImage[i]);
				}
				copyOfImage.close();
				NameNewFile += "s";
			}				
		}catch(IOException e) {
			
		}
	}
	
	static public void SerializarObjeto(int[] imageArrayBytes) {
		try {
		ObjectOutputStream objectoSerializado = new ObjectOutputStream(new FileOutputStream("C:/Users/anests1a/Desktop/data.txt"));
		objectoSerializado.writeObject(imageArrayBytes);
		objectoSerializado.close();
		}catch(IOException e) {}
	}	
	
}
