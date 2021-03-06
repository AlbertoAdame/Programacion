import java.util.Objects;

public class Password {
	//pondremos "static final"es accesible para todos los objetos, pero no se almacena, por lo que es más óptimo, ya que es una constante
	//en este caso usaremos static final para pr�cticar, aunque podr�amos hacerlo solo un la variable longitud.
	private int longitud;
	private String contrasenna;
	private static final int LONGITUDPORDEFECTO=8;
	public Password() {
		super();
		this.longitud=LONGITUDPORDEFECTO;
		generarContrasenna();

	}
	
	public Password(int longitud) {
		super();
		this.longitud = longitud;
		generarContrasenna();
	}

	public int getLongitud() {
		return longitud;
	}

	public String getContrasenna() {
		return contrasenna;
	}

	public void generarContrasenna() {
		int ascii;
		String resultado="";
		for (int i = 0; i < this.longitud; i++) {
			ascii=(int) (Math.random()*123);
			while (ascii<48) {
				ascii=(int) (Math.random()*123);
			}resultado+=(char)ascii;
		}this.contrasenna=resultado;
		
	}
		
	public boolean esFuerte() {
		int valor,mayuscula=0,minuscula=0, numeros=0;
		for (int i = 0; i < this.contrasenna.length(); i++) {
			valor=this.contrasenna.charAt(i);
				if(valor>64 && valor<90) {
					mayuscula++;
				}
				else if(valor>96 && valor<123) {
					minuscula++;
				}
				else if(valor>47 && valor<58) {
					numeros++;
				}if(mayuscula>=2 || minuscula>=1 || numeros>=5) {
					return true;		
			}
		}return false;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(contrasenna);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Password other = (Password) obj;
		return Objects.equals(contrasenna, other.contrasenna);
	}

	@Override
	public String toString() {
		return contrasenna;
	}
	
	
}

