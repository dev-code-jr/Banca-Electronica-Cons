package org.chamale.chanquin.controller;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import org.chamale.chanquin.dao.Conexion;
import org.chamale.chanquin.model.Usuarios;
/**
 *
 * @author Edwar René Chamalé González - 2022222
 * @author Jose Rodrigo Chanquín Mac - 2022240
 * 
 */
public class UsuariosController {
    Scanner sc = new Scanner (System.in);
    public void listarUsuarios(){
        try{
            PreparedStatement ps = Conexion.getInstance().getConexion()
            .prepareCall("SELECT * FROM vw_usuarios");
            ResultSet resultado = ps.executeQuery();
                while(resultado.next ()){
                    Usuarios user = new Usuarios();
                    user.setIdUsuario(resultado.getInt(1));
                    user.setNombreCompleto(resultado.getString(2));
                    user.setUser(resultado.getString(3));
                    user.setPassword(resultado.getString(4));
                    System.out.println(user.vistaUsuarios());
                }
                resultado.close();
        }catch(SQLException e){
            e.getMessage();
            System.exit(0);
        }
    }
    public void buscarUsuarios(){
        Usuarios user= new Usuarios ();
        System.out.println("Ingrese el id de usuario a buscar");
        int idUsuario = sc.nextInt();
        try{
           PreparedStatement ps = Conexion.getInstance().getConexion()
                   .prepareCall("CALL sp_buscarUsuarios(?)");
           ps.setInt(1, idUsuario);
           ps.execute();
           ResultSet resultado  = ps.executeQuery();
            if(!resultado.isBeforeFirst()){
                while(!resultado.next()){
                    user.setNotFound(resultado.getString(2));
                    System.out.println(user.notFound());
                }
            }else{
                while(resultado.next()){
                    user.setIdUsuario(resultado.getInt(1));
                    user.setNombreCompleto(resultado.getString(2));
                    user.setUser(resultado.getString(3));
                    user.setPassword(resultado.getString(4));
                    System.out.println(user.vistaUsuarios());
                }
                resultado.close();
            }
        }catch(SQLException e){
            e.getMessage();
        }
    }
    public void insertarUsuarios(){
        BuffReader bf = new BuffReader();
        int res = 0;
        System.out.println("Ingrese su codigo de cliente");
        int idCliente = sc.nextInt();
        System.out.println("Ingrese Correo Eletronico");
        System.out.println("* NO MAYOR A 25 CARACTERES *");
        String usuario = bf.usuario();
            try{
                PreparedStatement ps = Conexion.getInstance().getConexion()
                        .prepareCall("CALL sp_comprobarCorreo(?)");
                ps.setString(1, usuario);
                ResultSet resultado = ps.executeQuery();
                    if(!resultado.next()){
                        res = 1;
                        if(res == 1){
                        System.out.println("Ingrese Contraseña");
                        System.out.println("* NO MAYOR A 10 CARACTERES *");
                        String clave = bf.clave();
                            try{
                                PreparedStatement sp = Conexion.getInstance().getConexion()
                                       .prepareCall("CALL sp_insertarUsuarios(?, ?, ?)");
                                sp.setInt(1, idCliente);
                                sp.setString(2, usuario);
                                sp.setString(3, clave);
                                sp.execute();
                                System.out.println("Usuario agregado exitosamente");
                            } catch(SQLException e){
                                e.getMessage();
                                System.exit(0);
                            } 
                        }
                    } else{
                        System.out.println("Correo electronico no valido");
                    }
            } catch(SQLException e){
                e.getMessage();
            }
              
    }
    public void actualizarUsuario(){
        BuffReader bf = new BuffReader();
        System.out.println("Ingrese id de esuario a actualizar");
        int idUsuario = sc.nextInt();
        System.out.println("Ingrese el nuevo codigo del cliente");
        int idCliente = sc.nextInt();
        System.out.println("Ingrese el nuevo Correo electronico");
        String usuario = bf.usuario();
        System.out.println("Ingrese la nueva contraseña");
        String clave = bf.clave();
            try{
                PreparedStatement ps = Conexion.getInstance().getConexion()
                        .prepareCall("CALL sp_actualizarUsuarios(?, ?, ?, ?)");
                ps.setInt(1, idUsuario);
                ps.setInt(2, idCliente);
                ps.setString(3, usuario);
                ps.setString(4, clave);
                ps.execute();
                System.out.println("Usuario actualizado exitosamente");
            } catch(SQLException e){
                e.getMessage();
                System.exit(0);
            }
    }
    public void eliminarUsuario(){
        System.out.println("Ingrese el id del usuario a eliminar");
        int idUsuario = sc.nextInt();
            try{
                PreparedStatement ps = Conexion.getInstance().getConexion()
                        .prepareCall("CALL sp_eliminarUsuarios(?)");
                ps.setInt(1, idUsuario);
                ps.execute();
                System.out.println("Usuario eliminado exitosamente");
            } catch(SQLException e){
                e.getMessage();
                System.exit(0);
            }
    }
}
