package org.chamale.chanquin.view;
import org.chamale.chanquin.controller.EmpresaTelefonicasController;
import java.util.Scanner;
/**
 *
 * @author Edwar René Chamalé González - 2022222
 * @author Jose Rodrigo Chanquín Mac - 2022240
 * 
 */
public class MenuEmpresaTelefonica {
     Scanner sc = new Scanner(System.in);
    
    public void menuEmpresaTelefonicas(){
        EmpresaTelefonicasController etController = new EmpresaTelefonicasController();
        MenuPrincipal mPrincipal = new MenuPrincipal();
        System.out.println("************************");
        System.out.println("* EMPRESAS TELEFÓNICAS *");
        System.out.println("************************");
        System.out.println("1. Ingresar empresas telefónicas");
        System.out.println("2. Mostrar empresas telefonicas");
        System.out.println("3. Actualizar empresas telefónicas");
        System.out.println("4. Eliminar empresas telefónicas");
        System.out.println("5. Regresar al menú principal");
        System.out.println("Ingrese una opción");
        int opcion = sc.nextInt();
        switch(opcion){
            case 1:// create empresas telefonicas
                etController.insertarEmpresasTelefonicas();
                this.menuEmpresaTelefonicas();
                break;
            case 2:// report empresas telefonicas
                System.out.println("1. Reporte Individual");
                System.out.println("2. Reporte General");
                int subopcion = sc.nextInt();
                switch(subopcion){
                    case 1:// reporte individual de empresas telefonicas
                        etController.buscarEmpresasTelefonicas();
                        this.menuEmpresaTelefonicas();
                        break;
                    case 2:// reporte general de empresas telefonicas
                        etController.listarEmpresasTelefonicas();
                        this.menuEmpresaTelefonicas();
                        break;
                    default:
                        System.out.println("No es ninguna opción");
                }
                break;
            case 3:// update empresas telefonicas
                etController.actualizarEmpresasTelefonicas();
                this.menuEmpresaTelefonicas();
                break;
            case 4:// delete empresas telefonicas
                etController.eliminarEmpresasTelefonicas();
                this.menuEmpresaTelefonicas();
                break;
            case 5:// regresar al menu principal
                mPrincipal.menuPrincipal();
                break;
            default:
                System.out.println("No es ninguna opción");
        }
    }
}
