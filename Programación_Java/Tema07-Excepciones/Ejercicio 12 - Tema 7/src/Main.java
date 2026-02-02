public class Main { 
 
 public static void main(String[] args) { 
  D variable1 = new E(2, 3, 4); 
  variable1.metodo1(); 
  variable1.metodo2(); 
  variable1.metodo3(); 
  variable1.metodo4(); 
  System.out.println("----------------"); 
   
  C varC = new E(2,2,2); 
  varC.metodo3();  
  System.out.println("----------------"); 
   
  F variable2 = new G(5,"G"); 
  variable2.metodo3(); 
  variable2.metodo4(); 
  System.out.println("----------------"); 
   
  varC = variable2; 
  varC.metodo3(); 
  varC.metodo4(); 
  System.out.println("----------------"); 
   
  variable2 = new H(4,"H"); 
  variable2.metodo3(); 
  variable2.metodo4(); 
  System.out.println("----------------"); 
   
  varC = variable2; 
  varC.metodo3(); 
  varC.metodo4(); 
  ((G)varC).metodo3(); 
 } 
 
}