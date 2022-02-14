import java.util.Objects;

public class Complejo {

	private double real;
	private double imaginario;
		
		


public Complejo(double real, double imaginario) {
		super();
		this.real = real;
		this.imaginario = imaginario;
	}

//Por si queremos que si no indroducimos nada valgan 0, pero no lo pido
public Complejo() {
	super();
	this.real = 0;
	this.imaginario = 0;
}


public double getReal() {
	return real;
}




public void setReal(double real) {
	this.real = real;
}




public double getImaginario() {
	return imaginario;
}




public void setImaginario(double imaginario) {
	this.imaginario = imaginario;
}

@Override
public int hashCode() {
	return Objects.hash(imaginario, real);
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Complejo other = (Complejo) obj;
	return Double.doubleToLongBits(imaginario) == Double.doubleToLongBits(other.imaginario)
			&& Double.doubleToLongBits(real) == Double.doubleToLongBits(other.real);
}

@Override
public String toString() {
	String resultado;
	if (imaginario>0) 
		resultado= real +" + "+ imaginario + " i";
	else if (real==0)
		resultado=  imaginario + " i";
	else resultado= real +" - "+ imaginario + " i";
	
	return resultado;
}

public Complejo sumar(0.0) {
	
}





}
