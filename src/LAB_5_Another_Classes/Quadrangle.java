package LAB_5_Another_Classes;
import java.io.Serializable;

public class Quadrangle implements java.io.Serializable {

	protected int x1;
	protected int x2;
	protected int x3;
	protected int x4;
	protected int y1;
	protected int y2;
	protected int y3;
	protected int y4;
   
    
	
	
		
	public  Quadrangle(int x1, int x2, int x3, int x4, int y1, int y2, int y3, int y4) {
		
		this.setX1(x1);
		this.setX2(x2);
		this.setX3(x3);
		this.setX4(x4);
		this.setY1(y1);
		this.setY2(y2);
		this.setY3(y3);
		this.setY4(y4);
		
			
	}




	public static boolean CheckCorrectCoordinate(int x1, int x2, int x3, int x4, int y1, int y2, int y3, int y4) {
		if( (Math.toDegrees(Math.acos((((x2 - x1)*(x3-x2))+((y2-y1)*(y3-y2)))/(getLength(x1 , x2 , y1 , y2)*getLength(x2 , x3 , y2 , y3))))) + (Math.toDegrees(Math.acos((((x3 - x2)*(x4-x3))+((y3-y2)*(y4-y3)))/(getLength(x2 , x3 , y2 , y3)*getLength(x3 , x4 , y3 , y4))))) + + (Math.toDegrees(Math.acos((((x4 - x3)*(x1-x4))+((y4-y3)*(y1-y4)))/(getLength(x3 , x4 ,y3 , y4)*getLength(x4 , x1 , y4 , y1))))) + (Math.toDegrees(Math.acos((((x1 - x4)*(x2-x1))+((y1-y4)*(y2-y1)))/(getLength(x4 , x1 , y4 , y1)*getLength(x1 , x2 , y1 , y2))))) == 360) {
			return true ;
		}else {
			return false;
		}	
	}
	
	
	public static double getLength(int a1 , int a2  , int b1 , int b2) {

        return Math.sqrt(Math.pow((a2 - a1), 2) + Math.pow((b2 - b1), 2));
    }
	
	
	public  double getPerimetr() {

        return (getLength(x1 , x2 , y1 , y2)+getLength(x2 , x3 , y2 , y3 )+getLength(x3 , x4 , y3 , y4)+getLength(x4 , x1 , y4 , y1));
    }
	
	 
	
	 public double getArea() {
		 double sin = Math.sin(Math.acos((((x3 - x1)*(x4-x2))+((y3-y1)*(y4-y2)))/(getLength(x1 , x3 , y1 , y3)*getLength(x2 , x4 , y2 , y4)))) ;
		 
		 
		 return 0.5*getLength(x1 , x3 , y1 , y3)*getLength(x2 , x4 , y2 , y4)*sin ;
	 }
	
	
	public int getX1() {
		return x1;
	}
	public void setX1(int x1) {
		this.x1 = x1;
	}
	public int getX2() {
		return x2;
	}
	public void setX2(int x2) {
		this.x2 = x2;
	}
	public int getX3() {
		return x3;
	}
	public void setX3(int x3) {
		this.x3 = x3;
	}
	public int getX4() {
		return x4;
	}
	public void setX4(int x4) {
		this.x4 = x4;
	}
	public int getY1() {
		return y1;
	}
	public void setY1(int y1) {
		this.y1 = y1;
	}
	public int getY2() {
		return y2;
	}
	public void setY2(int y2) {
		this.y2 = y2;
	}
	public int getY3() {
		return y3;
	}
	public void setY3(int y3) {
		this.y3 = y3;
	}
	public int getY4() {
		return y4;
	}
	public void setY4(int y4) {
		this.y4 = y4;
	}



	
	

	@Override
	public String toString() {
		return  "\n Quadrangle : x1 = " + x1 + " , x2 = " + x2 + " , x3 = " + x3 + " , x4 = " + x4 + " , y1 = " + y1 + " , y2 = " + y2 + " , y3 = " + y3 + " , y4 = " + y4 + " ! "+
				"\n Side A = " +  String.format("%.2f" ,getLength(x1 , x2 , y1 , y2)) +
				"\n Side B = " +  String.format("%.2f" ,getLength(x2 , x3 , y2 , y3 ))+
				"\n Side C = " +  String.format("%.2f" ,getLength(x3 , x4 , y3 , y4)) +
				"\n Side D = " +  String.format("%.2f" ,getLength(x4 , x1 , y4 , y1)) +
				"\n Diagonal1 = " + String.format("%.2f" ,getLength(x1 , x3 , y1 , y3)) +
				"\n Diagonal2 = " + String.format("%.2f" ,getLength(x2 , x4 , y2 , y4)) +
				"\n Perimetr = " + String.format("%.2f" ,getPerimetr()) +
		        "\n Area = " + String.format("%.2f" ,getArea()) + "\n\n" ;
	}	
	
}