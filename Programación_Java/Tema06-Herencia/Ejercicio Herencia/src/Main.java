
public class Main {

	public static void main(String[] args) {
		A a = new A(4);
		B b = new B(8,5);
		C c = new C(1, 2, 7);
		
		a.mostrar();
		b.mostrar();
		c.mostrar();
		
		A a2 = new A();
		B b2 = new B();
		C c2 = new C(1, 2, 7);
		
		a2.mostrar();
		b2.mostrar();
		c2.mostrar();


	}

}
