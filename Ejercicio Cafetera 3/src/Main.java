import java.util.Scanner;

public class Main {
	public static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double monedero=leerDouble("Dame el dinero que tendr� la m�quina: ");
		while (monedero<0) {
			monedero=leerDouble("Valor no v�lido.Dame el dinero que tendr� la m�quina: ");
		}
		Maquina  m1;
		double dinero;
		m1= new Maquina(monedero);
		
		System.out.println(menu());
				
		
		int opcion=leerInt("Que desea: ");
		
		while (opcion !=5) {
		switch (opcion) {
		case 1: {
			dinero=leerDouble("Introduzca el importe: ");
			System.out.println(m1.servir(opcion, dinero));
			break;
			
		}case 2: {
			dinero=leerDouble("Introduzca el importe: ");
			System.out.println(m1.servir(opcion, dinero));
			break;
			
		}case 3: {
			dinero=leerDouble("Introduzca el importe: ");
			System.out.println(m1.servir(opcion, dinero));
			break;
		}case 4: {
			System.out.println(m1.toString());
			break;
			
		}
			
		}
		System.out.println(menu());
		opcion=leerInt("Que desea: ");
		
		}System.out.println("Gracias. Vuelva pronto.");
		
	
	}
	public static int leerInt(String texto) {
		System.out.println(texto);
		return Integer.parseInt(teclado.nextLine());	
	}
	public static double leerDouble(String texto) {
		System.out.println(texto);
		return Double.parseDouble(teclado.nextLine());	
	}	
	public static String menu() { 
		String menu="1. Servir caf� solo (1 euro)\r\n"
				+ "2. Servir leche (0,8 euros)\r\n"
				+ "3. Servir caf� con leche (1,5 euros)\r\n"
				+ "4. Consultar estado m�quina. Aparecen los datos de los dep�sitos y del monedero\r\n"
				+ "5. Apagar m�quina y salir\n";
		return menu;
		
	
	}
		
}

