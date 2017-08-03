import java.util.ArrayList;

public class Main {
	
	
	interface AreaMeasurable{
		public double getArea();
	}
	
	
	
	static class Rectangle implements AreaMeasurable {
			private double _Length = 0;
		
			private double _Width = 0;
			
			public Rectangle(double Length, double Width){
				_Length = Length;
				_Width = Width; 
				
			}
			
			public double getArea() { return (_Length*_Width);}
	}
	
	
	
	
	static class Circle implements AreaMeasurable {	
			private double _Radius = 0;
		
			public Circle(double Radius){
				_Radius = Radius; 
			}
			
			public double getArea() { return ((_Radius*_Radius)*Math.PI);}
	}

	
	
	
	
	static class Box implements AreaMeasurable {
			private double _Length = 0;
	
			private double _Width = 0;
			
			private double _Height = 0;
	
			public Box(double Length, double Width, double Height){
				_Length = Length;
				_Width = Width; 
				_Height = Height;
		
			}
			//2(LW + WH + HL)
			public double getArea() { return (2*((_Length*_Width) + (_Width*_Height) + (_Height*_Length)));}
	}
	
	
	
	
	
	static class Sphere implements AreaMeasurable {	
			private double _Radius = 0;

			public Sphere(double Radius){
				_Radius = Radius; 
	
			}
		
			public double getArea() { return (4*Math.PI*(_Radius*_Radius));}	
	}
			
	
	
	
	
	public static void main(String[] args){
		double Length = 0;
		double Height = 0;
		double Width = 0;
		double Radius = 0;
		double Shape_Type = 0;
		int _Rectangle = 0;
		int _Circle = 0;
		int _Box = 0;
		int _Sphere = 0;
		double TotalCount = 0;
			
		ArrayList Random_Object = new ArrayList();
		
		for(int i = 0; i < 100; ++i){
			Length = Math.random() + (0.000001);
			Width = Math.random()+ (0.000001);
			Height = Math.random()+ (0.000001);
			Radius = Math.random()+ (0.000001);
			Shape_Type = Math.random();
			
			if(Shape_Type < 0.25){	
				Rectangle RandomShape = new Rectangle(Length, Width);
				++_Rectangle;
				Random_Object.add(RandomShape.getArea());
	
			}
			
			if((Shape_Type >= 0.25) & (Shape_Type < 0.5)){
				Circle RandomShape = new Circle(Radius);
				++_Circle;
				Random_Object.add(RandomShape.getArea());
			
			}
			
			if((Shape_Type >= 0.5) & (Shape_Type < 0.75)){
				Box RandomShape = new Box(Length, Width, Height);
				++_Box;
				Random_Object.add(RandomShape.getArea());
			}
			
			if(Shape_Type >= 0.75){
				Sphere RandomShape = new Sphere(Radius);
				++_Sphere;
				Random_Object.add(RandomShape.getArea());
			}
			System.out.println(Random_Object.get(i));
			
		}
		
		
		System.out.println(_Rectangle + " " + _Circle  +" "+  _Box + " " + _Sphere);
		
		
	}
}



