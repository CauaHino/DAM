
public class C extends B{
	protected int z;
	
	public C() {
		System.out.println("Constructor C sin parámetros");
	}
	public C(int x, int y, int z) {
		super(y,x);
		this.z = z;
		System.out.println("Constructor C con parámetros");
	}
}

