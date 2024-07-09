package org.chamale.chanquin.view;
import java.util.Scanner;
import org.chamale.chanquin.controller.TransaccionesController;
/**
 *
 * @author Edwar René Chamalé González - 2022222
 * @author Jose Rodrigo Chanquín Mac - 2022240
 * 
 */
public class MenuTransacciones {
    Scanner sc = new Scanner(System.in);
    public void menuTransacciones(){
        TransaccionesController tController= new TransaccionesController();
        MenuPrincipal mPrincipal = new MenuPrincipal();
        System.out.println("*****************");
        System.out.println("* TRANSACCIONES *");
        System.out.println("*****************");
        System.out.println("1. Ingresar transacciones");
        System.out.println("2. Mostrar transacciones");
        System.out.println("3. Actualizar transacciones");
        System.out.println("4. Eliminar transacciones ");
        System.out.println("5. Regresar a menú principal");
        System.out.println("Ingrese una opción");
        int opcion = sc.nextInt();
        switch(opcion){
            case 1:// create transacciones
                tController.insertarTransacciones();
                this.menuTransacciones();
                break;
            case 2:// report transacciones
                System.out.println("1. Reporte Individual");
                System.out.println("2. Reporte General");
                System.out.println("3. Reporte mayor a 1,000");
                System.out.println("4. Reporte de transacciones del mes "
                        + "de septiembre a diciembre");
                int subopcion = sc.nextInt();
                switch(subopcion){
                    case 1:// reporte individual de transacciones
                        tController.buscarTransacciones();
                        this.menuTransacciones();
                        break;
                    case 2:// reporte general de transacciones
                        tController.listarTransacciones();
                        this.menuTransacciones();
                        break;
                    case 3:// reporte de transacciones mayores a 1000
                        tController.reporteMayores1000();
                        this.menuTransacciones();
                        break;
                    case 4:// reporte de transacciones del mes de septiembre a diciembre
                        tController.septiembreADiciembre();
                        this.menuTransacciones();
                    default:
                        System.out.println("No es ninguna opción");
                }
                break;
            case 3:// update transacciones
                tController.actualizarTransacciones();
                this.menuTransacciones();
                break;
            case 4:// delete transacciones
                tController.eliminarTransacciones();
                this.menuTransacciones();
                break;
            case 5:// regresar al menu principal
                mPrincipal.menuPrincipal();
                break;
            default:
                System.out.println("No es ninguna opción");
        }
    }
}
