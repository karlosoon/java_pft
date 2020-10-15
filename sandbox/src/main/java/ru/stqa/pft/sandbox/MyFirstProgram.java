package ru.stqa.pft.sandbox;

public class MyFirstProgram {

	public static void main (String[] args) {
		sayHello("world");
		sayHello("max");
		sayHello("blyat");

		Square s = new Square(10);
		System.out.println("Площадь квадрата со стороной " + s.l + " равна " + s.area());

		Rectangle r = new Rectangle(6,4);
		System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " равна " + r.area());
	}

	public static void sayHello(String somebody) {
		System.out.println("Hello " + somebody);
	}


}