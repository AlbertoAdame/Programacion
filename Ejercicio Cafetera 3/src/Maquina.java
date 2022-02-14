import java.util.Objects;

public class Maquina {
	private int cafe;
	private int leche;
	private int vasos;
	private double monedero;
	private final int TOTALCAFE=4;
	private final int TOTALLECHE=4;
	private final int TOTALVASOS=4;
	private final double PRECIOCAFE=1.0;
	private final double PRECIOLECHE=0.80;
	private final double PRECIOCAFECONLECHE=1.50;

	
public Maquina(double monedero) {
		super();
		this.cafe = this.TOTALCAFE ;
		this.leche = this.TOTALLECHE;
		this.vasos = this.TOTALVASOS;
		this.monedero = monedero;
	}

public void llenarDeposito() {
	this.cafe = this.TOTALCAFE ;
	this.leche = this.TOTALLECHE;
	this.vasos = this.TOTALVASOS;
}

public void vaciarDepositos () {
	this.monedero=0;
}


@Override
public String toString() {
	return "Maquina \n[cafe=" + cafe + ", leche=" + leche + ", vasos=" + vasos + ", monedero=" + monedero + "]";
}

/**
 * 
 * @param tipo
 * Aqui diremos de que tipo queremos el café.
 * 1.Café solo
 * 2.Leche
 * 3.Café con leche
 * @param dinero
 * Será la cantidad que se introduzca a la máquina.
 * @return
 */

public String servir (int tipo,double dinero) {
	
	String resultado ="";
	double cambio=cambio(tipo, dinero);
	//COMPROBAR QUE HAYA INTRODUCIDO BIEN EL DINERO Y HAYA CAMBIO
	if (comprobarPago(tipo, dinero).length() != 0) {
		return comprobarPago(tipo, dinero);
	}
	else if (comprobarDeposito(tipo).length() != 0) {
		return comprobarDeposito(tipo);
	}
	else {
		if (cambio>0) {
			resultado= preparar(tipo, dinero)+"\nRecoge tu cambio de "+cambio+ " euros.\n";
		}else resultado = preparar(tipo, dinero);
			
	return resultado;		
		
	}
	}


private String comprobarPago (int tipo, double dinero) {
	
	String resultado ="";
	switch (tipo) {
	case 1: {
		if (dinero<this.PRECIOCAFE) {
			resultado="Fondos insuficientes."; 
		} else if((dinero-this.PRECIOCAFE)>this.monedero){
			resultado="Cambio insuficiente.";
		}break;
		
	}
	case 2 : {
		if (dinero<this.PRECIOLECHE) {
			resultado="Fondos insuficientes."; 
		} else if((dinero-this.PRECIOLECHE)>this.monedero){
			resultado="Cambio insuficiente.";
		}break;
	}
	case 3 : {
		if (dinero<this.PRECIOCAFECONLECHE) {
			resultado="Fondos insuficientes."; 
		} else if((dinero-this.PRECIOCAFECONLECHE)>this.monedero){
			resultado="Cambio insuficiente.";
		}break;	
	}
	}
	//if (resultado.length() != 0)
		return resultado;
}

private String comprobarDeposito (int tipo) {
	String resultado ="";
	if (this.vasos<1) 
		resultado="No quedan vasos.";
	else {
	
	switch (tipo) {
	case 1: {
		if (this.cafe<1) {
			resultado="No queda café."; }	
	}		break;
		
	case 2 : {
		if (this.leche<1) {
			resultado="No queda leche."; }			
	}	break;
	case 3 : {
		if (this.cafe<1) {
			resultado="No queda café."; }			
		else if (this.leche<1) {
			resultado="No queda leche."; 
		}	break;		
	}
	}
	}
	
	//if (resultado.length() != 0)
		return resultado;
	
}

private String preparar (int tipo, double dinero) {
	switch (tipo) {
	case 1: {
		this.cafe--;
		this.vasos--;
		this.monedero+=PRECIOCAFE;
		break;
	}
		
	case 2 : {
		this.leche--;
		this.vasos--;
		this.monedero+=PRECIOLECHE;
		break;
	}
	case 3 : {
		this.leche--;
		this.cafe--;
		this.vasos--;
		this.monedero+=PRECIOCAFECONLECHE;
		break;
		}			
	}
			return "Producto servido.\n";
		}
		


private double cambio (int tipo, double dinero) {
	double resultado=0;
	switch (tipo) {
	case 1: {
		resultado=dinero-this.PRECIOCAFE;
		break;
	}
	case 2 : {
		resultado=dinero-this.PRECIOLECHE;	
		break;
	}
	case 3 : {
		resultado=dinero-this.PRECIOCAFECONLECHE;
		break;
		}			
	}
			return resultado;
		}


public double getMonedero() {
	return monedero;
}

@Override
public int hashCode() {
	return Objects.hash(monedero);
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Maquina other = (Maquina) obj;
	return Double.doubleToLongBits(monedero) == Double.doubleToLongBits(other.monedero);
}
		
}




