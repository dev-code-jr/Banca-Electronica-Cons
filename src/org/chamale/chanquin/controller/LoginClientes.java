package org.chamale.chanquin.controller;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.chamale.chanquin.dao.Conexion;
import org.chamale.chanquin.view.MenuPrincipal;
/**
 *
 * @author Edwar René Chamalé González - 2022222
 * @author Jose Rodrigo Chanquín Mac - 2022240
 * 
 */
public class LoginClientes {
    public void logearNombreCompleto(){
        int resultadoLogin = 0;
        BuffReader bf = new BuffReader();
        MenuPrincipal mPrincipal = new MenuPrincipal();
        System.out.println("Ingrese su nombre completo");
        String nombreCompleto = bf.nombreCliente();
            try{
                PreparedStatement ps = Conexion.getInstance().getConexion()
                        .prepareCall("CALL sp_loginNombre(?)");
                ps.setString(1, nombreCompleto);
                ResultSet resultado = ps.executeQuery();
                    if(resultado.next()){
                        resultadoLogin = 1;
                        if(resultadoLogin == 1){
                            System.out.println("\nConectando con la base de datos......");
                            System.out.println("verificando......");
                            System.out.println("...verificando");
                            System.out.println("verificando....");
                            System.out.println("......verificando");
                            System.out.println("Verificación exitosa");
                            System.out.println("\nBienvenido a nuestro sistema");
                            System.out.println("");
                            mPrincipal.menuPrincipal();
                        }
                    } else{
                        System.out.println("\nConectando con la base de datos......");
                        System.out.println("verificando......");
                        System.out.println("...verificando");
                        System.out.println("verificando....");
                        System.out.println("......verificando");
                        System.out.println("\nError de credenciales");
                        System.exit(0);
                    }
            } catch(SQLException e){
            }
    }
    public void logearUsuarioPassword(){
        BuffReader bf = new BuffReader();
        MenuPrincipal mPrincipal = new MenuPrincipal();
        int result = 0;
        System.out.println("Ingrese su correo electronico");
        String usuario = bf.usuario();
        System.out.println("Ingrese su contraseña");
        String clave = bf.clave();
            try{
                PreparedStatement ps = Conexion.getInstance().getConexion()
                        .prepareCall("CALL sp_comprobarUsuario(?, ?)");
                ps.setString(1, usuario);
                ps.setString(2, clave);
                ResultSet resultado = ps.executeQuery();
                    if(resultado.next()){
                        result = 1;
                        if(result == 1){
                            System.out.println("\nConectando con la base de datos......");
                            System.out.println("verificando......");
                            System.out.println("...verificando");
                            System.out.println("verificando....");
                            System.out.println("......verificando");
                            System.out.println("Verificación exitosa");
                            System.out.println("\nBienvenido a nuestro sistema");
                            System.out.println("");
                            mPrincipal.menuPrincipal();
                        }
                    } else{
                        System.out.println("\nConectando con la base de datos......");
                        System.out.println("verificando......");
                        System.out.println("...verificando");
                        System.out.println("verificando....");
                        System.out.println("......verificando");
                        System.out.println("\nError de credenciales");
                    }
            } catch (SQLException e){
                e.getMessage();
            }
    }
}
