package org.chamale.chanquin.view;
import java.util.Scanner;
/**
 *
 * @author Edwar René Chamalé González - 2022222
 * @author Jose Rodrigo Chanquín Mac - 2022240
 * 
 */
public class MenuPrincipal {
    Scanner sc = new Scanner (System.in);
    public void menuPrincipal(){
        MenuUsuarios mUsuarios = new MenuUsuarios();
        MenuClientes mClientes = new MenuClientes();
        MenuServicios mServicios = new MenuServicios();
        MenuEmpresaTelefonica mEmpresaT = new MenuEmpresaTelefonica();
        MenuTipoCuentas mTipoC = new MenuTipoCuentas();
        MenuTipoMonedas mTipoM = new MenuTipoMonedas();
        MenuCuentas mCuentas = new MenuCuentas();
        MenuTransacciones mTransaccion = new MenuTransacciones();
        MenuLogin mLogin = new MenuLogin();
        
        System.out.println("**********************************");
        System.out.println("* BANCA ELECTRONICA 'EL PELUCHE' *");
        System.out.println("**********************************");
        System.out.println("1.  Menu usuarios");
        System.out.println("2.  Menu clientes");
        System.out.println("3.  Menu servicios");
        System.out.println("4.  Menu empresas Telefónicas");
        System.out.println("5.  Menu tipo Cuentas");
        System.out.println("6.  Menu tipo Monedas");
        System.out.println("7.  Menu cuentas");
        System.out.println("8.  Menu transacciones");
        System.out.println("9.  Cerrar sesion");
        System.out.println("10. Salir del programa");
        System.out.println("Ingrese una opción");
        int opcion = sc.nextInt();
        switch(opcion){
            case 1:// menu de los usuarios
                mUsuarios.menuUsuarios();
                break;
            case 2:// menu de los clientes
                mClientes.menuClientes();
                break;
            case 3:// menu de los servicios
                mServicios.menuServicios();
                break;
            case 4:// menu de las empresas telefonicas
                mEmpresaT.menuEmpresaTelefonicas();
                break;
            case 5:// menu de los tipos de cuentas
                mTipoC.menuTipoCuentas();
                break;
            case 6:// menu de los tipos de monedas
                mTipoM.menuTipoMonedas();
                break;
            case 7:// menu de las cuentas
                mCuentas.menuCuentas();
                break;
            case 8:// menu de las transacciones
                mTransaccion.menuTransacciones();
                break;
            case 9:// cerrar sesion
                mLogin.menuLogin();
                break;
            case 10:// salir del sistema
                System.out.println("\nGracias por usar el mejor sistema :)");
                System.exit(0);
                break;
            default:// si el usuario no ingresa una opcion que esta en el rango de 1-8
                System.out.println("No es ninguna opción");
        }
    }
}
