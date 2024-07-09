package org.chamale.chanquin.view;
import java.util.Scanner;
import org.chamale.chanquin.controller.LoginClientes;
import org.chamale.chanquin.controller.ClientesController;
/**
 *
 * @author Edwar René Chamalé González - 2022222
 * @author Jose Rodrigo Chanquín Mac - 2022240
 * 
 */
public class MenuLogin {
    Scanner sc= new Scanner (System.in);
    public void menuLogin(){
        LoginClientes lClientes = new LoginClientes();
        ClientesController cController =new ClientesController();
        System.out.println("1. Crear cuenta");
        System.out.println("2. Iniciar sesión");
        System.out.println("3. Salir");
        System.out.println("Ingrese una opción");
        int opcion = sc.nextInt();
        switch(opcion){
            case 1:// crear cuentas
                System.out.println("1. Crear cuenta sin usuario de inicio de sesion");
                System.out.println("2. Crear cuenta con usuario de inicio de sesion");
                System.out.println("Ingrese una opción");
                int subopcion = sc.nextInt();
                switch(subopcion){
                    case 1:// crear cuenta sin usuario y contraseña
                        cController.insertarClientes();
                        this.menuLogin();
                        break;
                    case 2:// crear cuenta y usuario y contraseña
                        cController.insertarClientesYUser();
                        this.menuLogin();
                        break;
                }//llave switch 2
                break;
            case 2:// iniciar sesion
                System.out.println("1. Iniciar sesión solo con nombre"); 
                System.out.println("2. Iniciar sesión con usuario y contraseña");
                System.out.println("Ingrese una opción");
                int subopccion2 = sc.nextInt();
                switch(subopccion2){
                    case 1:// logear al cliente con nombreCompleto
                        lClientes.logearNombreCompleto();
                        break;
                    case 2:// logear al cliente con usuario y contraseña
                        lClientes.logearUsuarioPassword();
                        break;
                }
                break;
            case 3:// salir del sistema 
                System.out.println("\nGracias por usar nuestro sistema");
                System.exit(0);
                break;
        }//llave switch 1
    }
}
