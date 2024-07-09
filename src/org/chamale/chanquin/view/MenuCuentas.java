package org.chamale.chanquin.view;
import java.util.Scanner;
import org.chamale.chanquin.controller.CuentasController;
/**
 *
 * @author Edwar René Chamalé González - 2022222
 * @author Jose Rodrigo Chanquín Mac - 2022240
 * 
 */
public class MenuCuentas {
    Scanner sc = new Scanner(System.in);
    public void menuCuentas(){
        CuentasController cueController = new CuentasController();
        MenuPrincipal mPrincipal = new MenuPrincipal();
        System.out.println("************");
        System.out.println("* CUENTAS *");
        System.out.println("************");
        System.out.println("1. Ingresar cuentas");
        System.out.println("2. Mostrar cuentas");
        System.out.println("3. Actualizar cuentas");
        System.out.println("4. Eliminar cuentas");
        System.out.println("5. Regresar al menú principal");
        System.out.println("Ingrese una opción");
        int opcion = sc.nextInt();
        switch(opcion){
            case 1:// create cuentas
                cueController.insertarCuentas();
                this.menuCuentas();
                break;
            case 2:// report cuentas
                System.out.println("1. Reporte Individual");
                System.out.println("2. Reporte General");
                int subopcion = sc.nextInt();
                switch(subopcion){
                    case 1:// reporte individual de cuentas
                        cueController.buscarCuenta();
                        this.menuCuentas();
                        break;
                    case 2:// reporte general de cuentas
                        cueController.mostrarCuentas();
                        this.menuCuentas();
                        break;
                    default:
                        System.out.println("No es ninguna opción");
                }
                break;
            case 3:// update cuentas
                cueController.actualizarCuentas();
                this.menuCuentas();
                break;
            case 4:// delete cuentas
                cueController.eliminarCuentas();
                this.menuCuentas();
                break;
            case 5:// regresar al menu principal
                mPrincipal.menuPrincipal();
                break;
            default:
                System.out.println("No es ninguna opción");
        }
    }
}
