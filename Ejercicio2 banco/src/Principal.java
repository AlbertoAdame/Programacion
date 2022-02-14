import java.util.Scanner;


public class Principal {

	public static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	
		
		int ncc=leerInt("Dame el número de cuenta.");
		while (ncc<=0) {
			ncc=leerInt("NCC no válido. Dame el n�mero de cuenta.");
		}
		
		double saldo=leerDouble("Dame el saldo de la cuenta.");
		while (saldo<=0.0) {
			saldo=leerDouble("Saldo no válido. Dame el saldo de la cuenta.");
		}
		
		Cuenta c1;
		c1 = new Cuenta(ncc,saldo);
		
		System.out.println(menu());
		String salir="no";
			
		int caso= leerInt("\nElige programa: ");
		if (caso==4) {
			salir=leerString("¿Realmente quieres salir?(SI/NO)");
		}
		
		double cont;
			
		while (salir.equalsIgnoreCase("no")) {
		switch (caso) {
		
		case 1: 
			cont=leerDouble("¿Cuanto quieres sacar?");
			if (c1.reintegro(cont)) {
				System.out.println("Saldo actual: "+ c1.getSaldo());
				c1.getnReintegros();
			}
			else {
				System.out.println("Fondos no disponibles.");
			}
			
			break;

		case 2: 
			cont=leerDouble("¿Cuanto quieres ingresar?");
			if(c1.ingresar(cont)) {
				System.out.println("Saldo actual: "+ c1.getSaldo());
				c1.getnIngresos();
			}
			else {
				System.out.println("No se ha podigo ingresar el dinero.");
			}
			break;
		
		
		case 3:
			
			System.out.println(c1.toString());
			break;
			
		}
		System.out.println(menu());
		caso= leerInt("\nElige programa: ");
		if (caso==4) {
			salir=leerString("¿Realmente quieres salir?(SI/NO)");
			
		}
		}
		
		System.out.println("Vuelva pronto.");
	}
	
	public static String menu() {
		String menu="\n1.Sacar dinero.\n"
			+ "2.Ingresar dinero.\n"
			+ "3.Consultar saldo.\n"
			+ "4.Finalizar Operaciones.\n";
		return menu;	
	}	
	
	public static int leerInt(String texto) {
	System.out.println(texto);
	return Integer.parseInt(teclado.nextLine());
	}
	public static double leerDouble(String texto) {
	System.out.println(texto);
	return Double.parseDouble(teclado.nextLine());		
	}
	public static String leerString(String texto) {
	System.out.println(texto);
	return teclado.nextLine();
	}

}
