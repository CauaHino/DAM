
abstract public class D implements A,B, C {
	int atr1;
	double atr2;
	
	public D(int atr1, double atr2) {
		this.atr1 = atr1;
		this.atr2 = atr2;
	}
	@Override
	public void metodo2() {
		System.out.println("Metodo 2 - D");
		
	}
	@Override
	public void metodo1() {
		System.out.println("Metodo 1 - D");
		
	}
	@Override
	public void metodo4() {
		System.out.println("Metodo 4 - D");
		
	}
	
	public void metodo5() {
		System.out.println("Metodo 5 - D");
	}

}
