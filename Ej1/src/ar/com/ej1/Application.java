package ar.com.ej1;

import java.util.Scanner;

import ar.com.ej1.dto.Curso;
import ar.com.ej1.dto.FormaDePago;
import ar.com.ej1.dto.Inscripcion;
import ar.com.ej1.fecade.Fecade;

public class Application {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Fecade f = new Fecade();
		Inscripcion insc = null;
		
		do{
			insc = new Inscripcion();
			System.out.print("Ingrese su nombre: ");
			insc.setNombre(scan.next());
			System.out.print("Ingrese su telefono: ");
			insc.setTelefono(scan.next());
			System.out.println("Ingrese numero de un curso: ");
			
			for(Curso curso : f.getCursos()){
				System.out.printf("%ld-%s    Precio:%0.2f\n",curso.getId(),curso.getDescripcion(),curso.getPrecio());
			}
			
			insc.setIdCurso(scan.nextLong());
			
			System.out.println("Ingrese numero de forma de pago: ");
			for(FormaDePago fp : f.getFormasDePago()){
				System.out.printf("%ld-%s    Recargo:%0.2f\n",fp.getId(),fp.getDescripcion(),fp.getRecargo());
			}
			
			insc.setIdFormaDePago(scan.nextLong());
			
			System.out.println("Verifique los siguientes datos:");
			System.out.println(insc.toString());
			System.out.println("");
			System.out.println("Confirmar <Y/N>: ");
			
		}while(!(scan.next().toLowerCase().equals("y")));
		
		Long iDinsc = f.inscribir(insc);
		System.out.printf("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.printf("Inscripcion confirmada. El ID de incripcion es %ld\n",iDinsc);
	}

}
