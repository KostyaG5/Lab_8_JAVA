package LAB_5_Another_Classes;

import java.util.ArrayList ;
import java.io.*;


public class Quadrangles  {
	

	private static ArrayList<Quadrangle> quadrangles ;
	
	
	
	public  Quadrangles() {
		Quadrangles.quadrangles = new ArrayList<Quadrangle>() ;
	}

	public ArrayList<Quadrangle> getQuadrangles() {
		return quadrangles;
	}

	public void setQuadrangles(ArrayList<Quadrangle> quadrangles) {
		Quadrangles.quadrangles = quadrangles;
	}

	
	public boolean AddQuadrangle(Quadrangle quadrangle) {
		boolean result = false ;
		if(Quadrangles.quadrangles.add(quadrangle)) 
			result = true ;	
		
		
		return result ;
	}


 
	 public static double getAverageSquare() {
	       double area = 0;
	       for (int i = 0; i < quadrangles.size(); i++) {
	           area+=quadrangles.get(i).getArea();
	       }
	       return area/quadrangles.size();
	    } 
	
	
//Cериализация	Quadrangles !		 
	 
	 public void Save(String filename) {
		 try {
	         FileOutputStream fileOut = new FileOutputStream(filename);
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);

	         out.writeObject(quadrangles);
	         out.close();
	         fileOut.close();
	         System.out.print("Serialized data is saved in file: " + filename);
	      } catch (IOException ex) {
	         ex.printStackTrace();
	      } 
	  }
	
	 
// Десериализация	Quadrangles !	 
	 
	 public void Load(String filename) {
	      try {
	         FileInputStream fileIn = new FileInputStream(filename);
	         ObjectInputStream in = new ObjectInputStream(fileIn);

	         Quadrangles.quadrangles = (ArrayList<Quadrangle>) in.readObject();

	         in.close();
	         fileIn.close();
	      } catch (IOException ex) {
	         ex.printStackTrace();
	      } catch (ClassNotFoundException c) {
	         System.out.println("Quadrangle class not found");
	         c.printStackTrace();
	      }
	   }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	@Override
	public String toString() {
		String result = "" ;
		
		for(Object quadrangle: Quadrangles.quadrangles) {
			result += quadrangle.toString() + '\n' ;
		}
		
		return result += " Average square of quadrangles is " + String.format("%.2f", Quadrangles.getAverageSquare()) + "\n" + " ------------------------------------------------------------------------\n" ;
	}
	

}

