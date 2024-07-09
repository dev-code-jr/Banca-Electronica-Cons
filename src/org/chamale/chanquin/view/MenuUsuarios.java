package org.chamale.chanquin.view;
import org.chamale.chanquin.controller.UsuariosController;
import java.util.Scanner;
/**
 *
 * @author Edwar René Chamalé González - 2022222
 * @author Jose Rodrigo Chanquín Mac - 2022240
 * 
 */
public class MenuUsuarios {
    Scanner sc = new Scanner(System.in);
    public void menuUsuarios(){
        UsuariosController uController = new UsuariosController();
        MenuPrincipal mPrincipal = new MenuPrincipal();
        System.out.println("************");
        System.out.println("* USUARIOS *");
        System.out.println("************");
        System.out.println("1. Ingresar usuario");
        System.out.println("2. Mostrar usuarios");
        System.out.println("3. Actualizar usuarios");
        System.out.println("4. Eliminar usuarios");
        System.out.println("5. Regresar al menú principal");
        System.out.println("Ingrese una opción");
        int opcion = sc.nextInt();
        switch(opcion){
            case 1:// create users
                uController.insertarUsuarios();
                this.menuUsuarios();
                break;
            case 2:// reports users
                System.out.println("1. Reporte Individual");
                System.out.println("2. Reporte General");
                int subopcion = sc.nextInt();
                switch(subopcion){
                    case 1:// reporte individual de usuarios
                        uController.buscarUsuarios();
                        this.menuUsuarios();
                        break;
                    case 2:// reporte general de usuarios
                        uController.listarUsuarios();
                        this.menuUsuarios();
                        break;
                    default:
                        System.out.println("No es ninguna opción");
                }
                break;
            case 3://update users
                uController.actualizarUsuario();
                this.menuUsuarios();
                break;
            case 4:// delete users
                uController.eliminarUsuario();
                this.menuUsuarios();
                break;
            case 5:// regresar al menu principal
                mPrincipal.menuPrincipal();
                break;
            default:
                System.out.println("No es ninguna opción");
        }
    }
}
