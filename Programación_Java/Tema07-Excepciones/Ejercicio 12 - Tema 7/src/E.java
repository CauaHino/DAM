
public class E extends D {
	protected int atr3;
	
	public E(int atr1, double atr2, int atr3) {
		super(atr1, atr2);
		this.atr3 = atr3;
	}


	
	public void metodo2(){
		System.out.println("Metodo 2 - E");
	}

	@Override
	public void metodo3() {
		System.out.println("Metodo 3 - E");
		
	}

}
