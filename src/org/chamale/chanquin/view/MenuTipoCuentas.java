package org.chamale.chanquin.view;
import org.chamale.chanquin.controller.TipoCuentasController;
import java.util.Scanner;
/**
 *
 * @author Edwar René Chamalé González - 2022222
 * @author Jose Rodrigo Chanquín Mac - 2022240
 * 
 */
public class MenuTipoCuentas {
    Scanner sc = new Scanner(System.in);
    public void menuTipoCuentas(){
        TipoCuentasController tcController = new TipoCuentasController();
        MenuPrincipal mPrincipal = new MenuPrincipal();
        System.out.println("****************");
        System.out.println("* TIPO CUENTAS *");
        System.out.println("****************");
        System.out.println("1. Ingresar tipos de cuentas");
        System.out.println("2. Mostrar tipos de cuentas");
        System.out.println("3. Actualizar tipos de cuentas");
        System.out.println("4. Eliminar tipos de cuentas");
        System.out.println("5. Regresar al menú principal");
        System.out.println("Ingrese una opción");
        int opcion = sc.nextInt();
        switch(opcion){
            case 1:// create tipos de cuentas
                tcController.insertarTipoCuentas();
                this.menuTipoCuentas();
                break;
            case 2:// report tipos de cuentas
                System.out.println("1. Reporte Individual");
                System.out.println("2. Reporte General");
                int subopcion = sc.nextInt();
                switch(subopcion){
                    case 1:// reporte individual de tipos de cuentas
                        tcController.buscarTipoCuenta();
                        this.menuTipoCuentas();
                        break;
                    case 2:// reporte general de tipos de cuentas
                        tcController.listarTipoCuentas();
                        this.menuTipoCuentas();
                        break;
                    default:
                        System.out.println("No es ninguna opción");
                }
                break;
            case 3:// update tipos de cuentas
                tcController.actualizarTipoCuentas();
                this.menuTipoCuentas();
                break;
            case 4:// delete tipos de cuentas
                tcController.eliminarTipoCuentas();
                this.menuTipoCuentas();
                break;
            case 5:// regresar al menu principal
                mPrincipal.menuPrincipal();
                break;
            default:
                System.out.println("No es ninguna opción");
        }
    }
}
