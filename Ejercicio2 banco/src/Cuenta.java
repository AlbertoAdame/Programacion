import java.util.Objects;

public class Cuenta {
	private double saldo;
	private int ncc;
	private int nIngresos=0;
	private int nReintegros=0;
	
	
public Cuenta(int ncc, double saldo) {
	super();
	this.ncc=ncc;
	this.saldo=saldo;
	
}
public boolean ingresar(double cont) {
	boolean resultado;
	if (cont>0) {
		saldo=saldo+cont;
		nIngresos++;
		resultado=true;
	}
	else
		resultado=false;
	return resultado;
}

public boolean reintegro(double cont) {
	boolean resultado;
	if (cont>0 && cont<saldo) {
		saldo=saldo-cont;
		nReintegros++;
		resultado=true;
	}
	else
		resultado=false;
	return resultado;
}



public double getSaldo() {
	return saldo;
}
public int getnIngresos() {
	
	return nIngresos;
}
public int getnReintegros() {
	return nReintegros;
}


@Override
public String toString() {
	return "Cuenta \nsaldo=" + saldo +" euros"+ "\nncc=" + ncc + "\nnIngresos=" + nIngresos + "\nnReintegros=" + nReintegros;
			
}

@Override
public int hashCode() {
	return Objects.hash(ncc);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Cuenta other = (Cuenta) obj;
	return ncc == other.ncc;
}




}

