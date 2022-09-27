package LAB_5_Another_Classes;
public class Paralelogram extends Quadrangle{

	public Paralelogram(int x1, int x2, int x3, int x4, int y1, int y2, int y3, int y4) {
		super(x1 , x2 , x3 , x4 , y1 , y2 , y3 , y4);
	}

	
	public static boolean CheckCorrectCoordinate(int x1, int x2, int x3, int x4, int y1, int y2, int y3, int y4) {
		if( (Math.toDegrees(Math.acos((((x2 - x1)*(x3-x2))+((y2-y1)*(y3-y2)))/(getLength(x1 , x2 , y1 , y2)*getLength(x2 , x3 , y2 , y3))))) + (Math.toDegrees(Math.acos((((x3 - x2)*(x4-x3))+((y3-y2)*(y4-y3)))/(getLength(x2 , x3 , y2 , y3)*getLength(x3 , x4 , y3 , y4))))) +  (Math.toDegrees(Math.acos((((x4 - x3)*(x1-x4))+((y4-y3)*(y1-y4)))/(getLength(x3 , x4 ,y3 , y4)*getLength(x4 , x1 , y4 , y1))))) + (Math.toDegrees(Math.acos((((x1 - x4)*(x2-x1))+((y1-y4)*(y2-y1)))/(getLength(x4 , x1 , y4 , y1)*getLength(x1 , x2 , y1 , y2))))) == 360 && getLength(x1 , x2 , y1 , y2) == getLength(x3 , x4 ,y3 , y4) && getLength(x2 , x3 , y2 , y3) == getLength(x4 , x1 , y4 , y1) && getLength(x1 , x3 , y1 , y3) == getLength(x2 , x4 , y2 , y4)) {
			return true ;
		}else {
			return false;
		}	
	}
	

	
	@Override
	public String toString() {
		return  "\n Paralelogram : x1 = " + x1 + " , x2 = " + x2 + " , x3 = " + x3 + " , x4 = " + x4 + " , y1 = " + y1 + " , y2 = " + y2 + " , y3 = " + y3 + " , y4 = " + y4 +
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
