import java.util.Scanner;

public class Main {
	
	public static Scanner teclado = new Scanner (System.in);
	public static void main(String[] args) throws PersonaException {
		// TODO Auto-generated method stub

		String nombre,DNI;
		char sexo;
		int longitud,edad;
		double peso,altura;
		

		
		peso=leerDouble("Introduce tu peso: ");
		
		altura=leerDouble("Introduce tu altura: ");	
		
		DNI=leerString("Introduce tu DNI: ");
	
		sexo=leerChar("Introduce tu sexo (H/M): ");
		while (sexo!='H' && sexo!='M') {
			sexo=leerChar("Valor no v�lido.Introduce tu sexo (H/M)");
		}
		
		nombre=leerString("Introduce tu nombre: ");
		
		edad=leerInt("Introduce tu edad: ");
		
		longitud=leerInt("Introduce la longitud para tu contrase�a: ");
		
		Password p1;
		p1= new Password(longitud);
		
		
		
		System.out.println(p1);
		
		Password p3;
		p3= new Password();
		
		System.out.println(p3);
		System.out.println("¿Es mi contraseña fuerte? "+ p3.esFuerte());
		
		Persona p2;
		p2 = new Persona(nombre, edad,DNI, sexo,peso,altura,longitud);
		
		try {
			p2.setEdad(50);
		} catch (PersonaException e) {
			// TODO Auto-generated catch block
			System.out.println("Intentando asignar una edad no admitida");
			e.printStackTrace();
		}
		
		System.out.println(p2);
		
		System.out.println("Tu IMC es : " + p2.IMC());
		
		if (p2.comprobarSexo(sexo))  System.out.println("El sexo introducido es correcto.");
		else System.out.println("El sexo introducido es incorrecto.");
		
		if (p2.mayorDeEdad()) System.out.println("Eres mayor de edad");
		else System.out.println("Eres menor de edad");
		
//		if (p3.esFuerte(p2.getPassword())) System.out.println("Contrase�a es fuerte.");
//		else System.out.println("Contrase�a es d�bil.");
		
//		No s� como ver si la contrase�a creada en persona es fuerte o no, ya que este m�todo se encuentra en password
		
		
		
		Persona p4;
		p4 = new Persona();		
		System.out.println("Los valores creados por defecto son " + p4);
		
		Persona p5;
		p5 = new Persona(nombre,edad,sexo);	
		
		try {
			p5 = new Persona(nombre,edad,sexo);	
		} catch (PersonaException e) {
			// TODO: handle exception
		}
		System.out.println("Los valores creados con algunos valores " + p5);	
		
	}
	
	public static char leerChar(String texto) {
		System.out.println(texto);
		return teclado.nextLine().charAt(0);
	}
	public static String leerString(String texto) {
		System.out.println(texto);
		return teclado.nextLine();
	}
	public static double leerDouble(String texto) {
		System.out.println(texto);
		return Double.parseDouble(teclado.nextLine());
	}
	public static int leerInt(String texto) {
		System.out.println(texto);
		return Integer.parseInt(teclado.nextLine());
	}

}
