package LAB_5_Another_Classes;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

// Этот класс нужен для создания резервной копии .
public class Utility {
	
//	Cериализация  имен файлов , хранящих в себе резервные копии .
	public static void Save(String filename , String file) {
		 try {
	         FileOutputStream fileOut = new FileOutputStream(filename);
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);

	         out.writeObject(file);
	         out.close();
	         fileOut.close();
	         System.out.print("Serialized data is saved in file: " + filename);
	      } catch (IOException ex) {
	         ex.printStackTrace();
	      } 
	  }
	
//	Десериализация  имен файлов , хранящих в себе резервные копии (Пришлось сделать не методом , а функцией ). 
	 public static String Load(String filename) {
	      try {
	         FileInputStream fileIn = new FileInputStream(filename);
	         ObjectInputStream in = new ObjectInputStream(fileIn);

	        String a = (String) in.readObject();

	         in.close();
	         fileIn.close();
	         return a ; 
	      } catch (IOException ex) {
	         ex.printStackTrace();
	      } catch (ClassNotFoundException c) {
	         System.out.println("Paralelogram class not found");
	         c.printStackTrace();
	      }
	      
		return "" ;
	   }
}
