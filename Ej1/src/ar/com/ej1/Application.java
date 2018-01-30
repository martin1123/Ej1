package ar.com.ej1;

import java.util.Scanner;

import ar.com.ej1.dto.Inscripcion;
import ar.com.ej1.fecade.Fecade;

public class Application {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Fecade f = new Fecade();
		Inscripcion insc = new Inscripcion();
		
		System.out.print("Ingrese su nombre: ");
		scan.next();
	}

}
