import java.util.Objects;

public class Persona {
	private String nombre;
	private int edad;
	private String DNI;
	private Password password;
	private char sexo;
	private double peso;
	private double altura;
	
	
	public Persona() {
		super();
		this.nombre = "";
		this.edad = 0;
		this.DNI = generarDni();
		this.password = new Password();
		this.sexo = 'M';
		this.peso = 0;
		this.altura = 0;
	}
	
	public Persona(String nombre, int edad, char sexo) throws PersonaException {
		super();
		this.nombre = nombre;
		this.setEdad(edad);
		this.DNI = generarDni();
		this.password = new Password();
		this.setSexo(sexo);
		this.peso = 0;
		this.altura = 0;
	}

	public Persona(String nombre, int edad, String DNI, char sexo, double peso, double altura, int longitud) throws PersonaException {
		super();
		this.nombre = nombre;
		this.setEdad(edad);
		this.DNI = DNI;
		this.password = new Password(longitud);
		this.setSexo(sexo);
		this.setPeso(peso);
		this.setAltura(altura);
	}
	

	public String getNombre() {
		return nombre;
	}

	public int getEdad() {
		return edad;
	}

	public String getDNI() {
		return DNI;
	}

	public String getPassword() {
		return password.getContrasenna();
	} //ESTO ESTARÍA MAL pq puse PASSWORD, y tiene que ser string

	public char getSexo() {
		return sexo;
	}

	public double getPeso() {
		return peso;
	}

	public double getAltura() {
		return altura;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setEdad(int edad) throws PersonaException {
		if (edad < 0 || edad >120) {
		throw new PersonaException("0000:edad incorrecta");
		}
		this.edad = edad;
	}
	

	public void setPassword(Password password) {
		this.password = password;
	}

	public void setSexo(char sexo) throws PersonaException {
		if (sexo != 'H' && sexo != 'M') {
			throw new PersonaException("0001:sexo incorrecta");
			}
		this.sexo = sexo;
	}

	public void setPeso(double peso) throws PersonaException {
		if (peso < 0 || peso >200) {
		throw new PersonaException("0002:peso incorrecta");
		}
		this.peso = peso;
	}

	public void setAltura(double altura) throws PersonaException {
		if (altura < 0 || altura > 3.0) {
			throw new PersonaException("0003:altura incorrecta");
			}
		this.altura = altura;
	}

	@Override
	public int hashCode() {
		return Objects.hash(DNI);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(DNI, other.DNI);
	}
	

	@Override
	public String toString() {
		return "nombre=" + nombre + ", edad= " + edad +"a�os" + ", DNI=" + DNI + ", password=" + password + ", sexo="
				+ sexo + ", peso=" + peso +"kg" + ", altura=" + altura + "m";
	}

	public int IMC() {
		int IMC=(int) (this.peso/(Math.pow(this.altura,2)));
		//Aunque se recomienda hacer con constantes, no entiendo que valor hay que atribuirle a estas
		int resultado=-2;
		if (IMC<20) {
			resultado=-1;
		}
		else if (IMC<=25) {
			resultado=0;
		}
		else {
			resultado=1;
		}return resultado;
	}
	
	public boolean mayorDeEdad() {
		boolean resultado=false;
		if (this.edad>17) {
			resultado=true;
		}return resultado;	
	}
	
	public boolean comprobarSexo(char sexo) {
		boolean resultado=false;
		if (this.sexo==sexo) {
			resultado=true;
		}return resultado;	
	}
	
	private String generarDni() {
		int ascii,longitud=8;
		String resultado="";
		for (int i = 0; i < longitud; i++) {
			ascii=(int) (Math.random()*58);
			while (ascii<48) {
				ascii=(int) (Math.random()*58);
			}resultado+=(char)ascii;
		}
			ascii=(int) (Math.random()*91);
			while (ascii<65) {
				ascii=(int) (Math.random()*91);
			}resultado+=(char)ascii;
			return resultado;
		}
		
	
	
}
