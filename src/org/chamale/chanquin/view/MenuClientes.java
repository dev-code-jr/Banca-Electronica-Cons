package org.chamale.chanquin.view;
import java.util.Scanner;
import org.chamale.chanquin.controller.ClientesController;
/**
 *
 * @author Edwar René Chamalé González - 2022222
 * @author Jose Rodrigo Chanquín Mac - 2022240
 * 
 */
public class MenuClientes {
    Scanner sc = new Scanner(System.in);
    public void menuClientes(){
        ClientesController cController = new ClientesController();
        MenuPrincipal mPrincipal = new MenuPrincipal();
        System.out.println("************");
        System.out.println("* CLIENTES *");
        System.out.println("************");
        System.out.println("1. Ingresar clientes");
        System.out.println("2. Mostrar clientes");
        System.out.println("3. Actualizar clientes");
        System.out.println("4. Eliminar clientes");
        System.out.println("5. Regresar al menú principal");
        System.out.println("Ingrese una opción");
        int opcion = sc.nextInt();
        switch(opcion){
            case 1:// create customers
                cController.insertarClientes();
                this.menuClientes();
                break;
            case 2:// report customers
                System.out.println("1. Reporte Individual");
                System.out.println("2. Reporte General");
                int subopcion = sc.nextInt();
                switch(subopcion){
                    case 1:// reporte individual de clientes
                        cController.buscarCliente();
                        this.menuClientes();
                        break;
                    case 2:// reporte general de clientes
                        cController.listarClientes();
                        this.menuClientes();
                        break;
                    default:
                        System.out.println("No es ninguna opción");
                }
                break;
            case 3:// update customers
                cController.actualizarClientes();
                this.menuClientes();
                break;
            case 4:// delete customers
                cController.eliminarClientes();
                this.menuClientes();
                break;
            case 5:// regresar al menu principal
                mPrincipal.menuPrincipal();
                break;
            default:
                System.out.println("No es ninguna opción");
        }
    }
}
