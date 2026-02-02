
public class B extends A{
	protected int y;

	public B() {
		y = 5;
		System.out.println("Constructor B sin parámetros");
	}
	public B(int x, int y) {
		super (y);
		this.x = x;
		System.out.println("Constructor B con parámetros");
	}
}
