package org.chamale.chanquin.view;
import java.util.Scanner;
import org.chamale.chanquin.controller.TipoMonedasController;
/**
 *
 * @author Edwar René Chamalé González - 2022222
 * @author Jose Rodrigo Chanquín Mac - 2022240
 * 
 */
public class MenuTipoMonedas {
    Scanner sc = new Scanner(System.in);
    public void menuTipoMonedas(){
        TipoMonedasController tmController = new TipoMonedasController();
        MenuPrincipal mPrincipal = new MenuPrincipal();
        System.out.println("****************");
        System.out.println("* TIPO MONEDAS *");
        System.out.println("****************");
        System.out.println("1. Ingresar tipos de monedas");
        System.out.println("2. Mostrar tipos monedas");
        System.out.println("3. Actualizar tipos monedas");
        System.out.println("4. Eliminar tipos monedas");
        System.out.println("5. Regresar al menú principal");
        System.out.println("Ingrese una opción");
        int opcion = sc.nextInt();
        switch(opcion){
            case 1:// create tipos de monedas
                tmController.insertarTipoMonedas();
                this.menuTipoMonedas();
                break;
            case 2:// report de tipos de monedas
                System.out.println("1. Reporte Individual");
                System.out.println("2. Reporte General");
                int subopcion = sc.nextInt();
                switch(subopcion){
                    case 1:// reporte individual de tipos de monedas
                        tmController.buscarTipoMonedas();
                        this.menuTipoMonedas();
                        break;
                    case 2:// reporte general de tipos de monedas
                        tmController.listarTipoMonedas();
                        this.menuTipoMonedas();
                        break;
                    default:
                        System.out.println("No es ninguna opción");
                }
                break;
            case 3:// update de tipos de monedas
                tmController.actualizarTipoMoneda();
                this.menuTipoMonedas();
                break;
            case 4:// delete de tipos de cuentas
                tmController.eliminarTipoMoneda();
                this.menuTipoMonedas();
                break;
            case 5:// regresar al menu principal
                mPrincipal.menuPrincipal();
                break;
            default:
                System.out.println("No es ninguna opción");
        }
    }
}
