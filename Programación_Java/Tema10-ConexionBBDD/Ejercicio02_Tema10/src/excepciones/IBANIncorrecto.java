package excepciones;

public class IBANIncorrecto extends Exception{
		
	public String toString() {
		return "El IBAN no tiene el formato correcto";
	}
}
