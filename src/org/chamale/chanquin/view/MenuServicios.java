package org.chamale.chanquin.view;
import org.chamale.chanquin.controller.ServiciosController;
import java.util.Scanner;
/**
 *
 * @author Edwar René Chamalé González - 2022222
 * @author Jose Rodrigo Chanquín Mac - 2022240
 * 
 */
public class MenuServicios {
    Scanner sc = new Scanner(System.in);
    public void menuServicios() {
        ServiciosController sController = new ServiciosController();
        MenuPrincipal mPrincipal = new MenuPrincipal();
        System.out.println("*************");
        System.out.println("* SERVICIOS *");
        System.out.println("*************");
        System.out.println("1. Ingresar Servicios");
        System.out.println("2. Mostrar servicios");
        System.out.println("3. Actualizar servicios");
        System.out.println("4. Eliminar servicios");
        System.out.println("5. Regresar al menu principal");
        System.out.println("Ingrese una opción");
        int opcion = sc.nextInt();
        switch(opcion){
            case 1:// create services
                sController.insertarServicios();
                this.menuServicios();
                break;
            case 2:// report services
                System.out.println("1. Reporte Individual");
                System.out.println("2. Reporte General");
                int subopcion = sc.nextInt();
                switch(subopcion){
                    case 1:// reporte individual de servicios
                        sController.buscarServicios();
                        this.menuServicios();
                        break;
                    case 2:// reporte general de servicios
                        sController.listarServicios();
                        this.menuServicios();
                        break;
                    default:
                        System.out.println("No es ninguna opción");
                }
                break;
            case 3:// update services
                sController.actualizarServicios();
                this.menuServicios();
                break;
            case 4:// delete services
                sController.eliminarServicios();
                this.menuServicios();
                break;
            case 5:// regresar al menu principal
                mPrincipal.menuPrincipal();
                break;
            default:
                System.out.println("No es ninguna opción");
        }
    }

}
