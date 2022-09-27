package LAB_6;


import LAB_5_Another_Classes.Utility ;
import java.io.IOException;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.*;
import LAB_5_Another_Classes.Paralelogram;
import LAB_5_Another_Classes.Paralelograms;
import LAB_5_Another_Classes.Quadrangle ;
import LAB_5_Another_Classes.Quadrangles ;

public class Main {
	public static void main(String[] args) throws IOException {
	    Scanner sc = new Scanner(System.in);		
	    String  answer = " " ;
//Востанавливаем данные из резервной копии или создаем с нуля .	   
	    do {
	    	
	    	System.out.println("\tUse backup data ?(Yes or No)\n") ;
	    	answer = sc.nextLine();
	    	if(answer.equals("Yes")) {
	    		
	    		Quadrangles quadrangles = new Quadrangles() ;
	    		Paralelograms paralelograms = new Paralelograms() ;
//Достаем из файла имена файлов с резервными копиями  . 	    		
	    		Utility.Load("./CoppyQuadrangle.txt");
	    		Utility.Load("./CoppyParalelogram.txt");
	    		
	    		String formatDateTimeP = Utility.Load("./CoppyParalelogram.txt");
	    		String formatDateTimeQ = Utility.Load("./CoppyQuadrangle.txt");
	    		
	    		quadrangles.Load(formatDateTimeQ);
	    		paralelograms.Load(formatDateTimeP);
	    		
	    		System.out.print(quadrangles);
	    		System.out.print(paralelograms);
	    		
	    	}else if(answer.equals("No")) {
	    		
	    		System.out.println("\n\tEnter number of Quadrangles \n") ;
	    		final int  currentNumberQuadrangles = sc.nextInt();
	    		System.out.println("\tEnter number of Paralelograms \n") ;
	    		final int  currentNumberParalelograms = sc.nextInt();
	    		
	    	
	    		Quadrangles quadrangles = new Quadrangles() ;
	    		for(int i = 0 ; i < currentNumberQuadrangles ; i++) {
	    			boolean correct = false ; 
	    			while(correct == false) {
	    				int x1 = (int)((Math.random()*40)-20) , x2 = (int)((Math.random()*40)-20) , x3 = (int)((Math.random()*40)-20) , x4 = (int)((Math.random()*40)-20)  , y1 = (int)((Math.random()*40)-20) , y2 = (int)((Math.random()*40)-20) , y3 = (int)((Math.random()*40)-20) , y4 = (int)((Math.random()*40)-20) ;
	    				boolean tempCorrect = Quadrangle.CheckCorrectCoordinate( x1,  x2,  x3,  x4,  y1,  y2,  y3, y4) ;
	    				if( tempCorrect == false) {
	    					correct = false ;
	    				} else {
	    					correct = true ; 
	    					Quadrangle quadrangel = new Quadrangle(x1 , x2 , x3 , x4 , y1 , y2 , y3 , y4);
	    					quadrangles.AddQuadrangle(quadrangel); 
	    					
	    				}
	    			 }
	    		 }
// Сериализация	Quadrangles !      
	    		quadrangles.Save("./Quadrangle.txt");
	    		
	    		
// Десериализация	Quadrangles !		
	    		
	    		quadrangles.Load("./Quadrangle.txt");
	    		System.out.println("\n\nDeserialized quadrangles: ");
	    	    System.out.println(quadrangles);
	    	
	    	
	    		
	    	
	    		Paralelograms paralelograms = new Paralelograms() ;
	    		for(int i = 0 ; i < currentNumberParalelograms ; i++) {
	    			boolean correct = false ; 
	    			while(correct == false) {
	    				int x1 = (int)((Math.random()*40)-20) , x2 = (int)((Math.random()*40)-20) , x3 = (int)((Math.random()*40)-20) , x4 = (int)((Math.random()*40)-20)  , y1 = (int)((Math.random()*40)-20) , y2 = (int)((Math.random()*40)-20) , y3 = (int)((Math.random()*40)-20) , y4 = (int)((Math.random()*40)-20) ;
	    				boolean tempCorrect = Paralelogram.CheckCorrectCoordinate( x1,  x2,  x3,  x4,  y1,  y2,  y3, y4) ;
	    				if( tempCorrect == false) {
	    					correct = false ;
	    				} else {
	    					correct = true ; 
	    					Paralelogram paralelogram = new Paralelogram(x1 , x2 , x3 , x4 , y1 , y2 , y3 , y4);
	    					paralelograms.AddParalelogram(paralelogram); 
	    					
	    				}
	    			 }
	    		 }
	    		
	    		
// Cериализация	Paralelograms !		
	    		paralelograms.Save("./Paralelogram.txt");
	    		

// Десериализация	Paralelograms !		
	    		
	    		paralelograms.Load("./Paralelogram.txt");
	    		System.out.println("\n\nDeserialized Paralelogram: ");
	    		System.out.println(paralelograms);
	    		
	    		
// Резервное копирование
	    		
	    		LocalDate now = LocalDate.now();  
	    		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy"); 
	    		String formatDateTimeP = "./"+now.format(format)+".par";
	    		String formatDateTimeQ = "./"+now.format(format)+".quar";
	    		paralelograms.Save(formatDateTimeP);
	    		System.out.print('\n');
	    		quadrangles.Save(formatDateTimeQ);
	    		System.out.print('\n');
	    		Utility.Save("./CoppyParalelogram.txt" , formatDateTimeP);
	    		System.out.print('\n');
	    		Utility.Save("./CoppyQuadrangle.txt" , formatDateTimeQ);
	    	}
	    }while(!answer.equals("Yes") && !answer.equals("No") );
	

	}
}

