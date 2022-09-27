package LAB_5_Another_Classes;
import java.util.ArrayList ;
import java.io.*;

public class Paralelograms {
	
	private static ArrayList<Paralelogram> paralelograms ;
	
	public  Paralelograms() {
		Paralelograms.paralelograms = new ArrayList<Paralelogram>() ;
	}

	public ArrayList<Paralelogram> getParalelograms() {
		return paralelograms;
	}

	public void setParalelograms(ArrayList<Paralelogram> paralelograms) {
		Paralelograms.paralelograms = paralelograms;
	}

	public boolean AddParalelogram(Paralelogram paralelogram) {
		boolean result = false ;
		if(Paralelograms.paralelograms.add(paralelogram)) 
			result = true ;	
		
		
		return result ;
	}
	
	
	
	public static Paralelogram findParalelogramMaxSquare() {
		Paralelogram maxParalelogramArea = paralelograms.get(0);
        for (int i = 1; i < paralelograms.size(); i++) {
            if (paralelograms.get(i).getArea() > maxParalelogramArea.getArea()) {
                maxParalelogramArea = paralelograms.get(i);
            }
        }
        return maxParalelogramArea;
    }
    public static Paralelogram findParalelogramMinSquare() {
    	Paralelogram minParalelogramArea = paralelograms.get(0);
        for (int i = 1; i < paralelograms.size(); i++) {
            if (paralelograms.get(i).getArea() < minParalelogramArea.getArea()) {
                minParalelogramArea = paralelograms.get(i);
            }
        }
        return minParalelogramArea;
    }
	
    
 //Cериализация	Paralelograms !		 
	 
 	 public void Save(String filename) {
 		 try {
 	         FileOutputStream fileOut = new FileOutputStream(filename);
 	         ObjectOutputStream out = new ObjectOutputStream(fileOut);

 	         out.writeObject(paralelograms);
 	         out.close();
 	         fileOut.close();
 	         System.out.print("Serialized data is saved in file: " + filename);
 	      } catch (IOException ex) {
 	         ex.printStackTrace();
 	      } 
 	  }
 	
 	 
 // Десериализация	Paralelograms !	 
 	 
 	 public void Load(String filename) {
 	      try {
 	         FileInputStream fileIn = new FileInputStream(filename);
 	         ObjectInputStream in = new ObjectInputStream(fileIn);

 	        Paralelograms.paralelograms = (ArrayList<Paralelogram>) in.readObject();

 	         in.close();
 	         fileIn.close();
 	      } catch (IOException ex) {
 	         ex.printStackTrace();
 	      } catch (ClassNotFoundException c) {
 	         System.out.println("Paralelogram class not found");
 	         c.printStackTrace();
 	      }
 	   }
    
    
    

    @Override
	public String toString() {
		String result = "" ;
		
		for(Object paralelogram: Paralelograms.paralelograms) {
			result += paralelogram.toString() + '\n' ;
		}
		
		return result += " Min square of paralelograms  is " + Paralelograms.findParalelogramMinSquare() + "\n" + " Max square of paralelograms  is " + Paralelograms.findParalelogramMaxSquare() + "\n\n" ;
	}
    
    
	
}