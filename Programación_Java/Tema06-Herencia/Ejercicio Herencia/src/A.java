
public class A {
	protected int x;
	
	public A() {
		x=5;
		System.out.println("Constructor A sin parámetros");
	}
	public A(int x) {
		
		this.x = x;
		System.out.println("Constructor A con parámetros");
	}
	public void mostrar() {
		System.out.println(x);
	}

}
