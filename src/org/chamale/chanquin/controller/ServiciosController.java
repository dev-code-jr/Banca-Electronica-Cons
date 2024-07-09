package org.chamale.chanquin.controller;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import org.chamale.chanquin.dao.Conexion;
import org.chamale.chanquin.model.Servicios;
/**
 *
 * @author Edwar René Chamalé González - 2022222
 * @author Jose Rodrigo Chanquín Mac - 2022240
 * 
 */
public class ServiciosController {
    Scanner sc= new Scanner(System.in);
    public void listarServicios(){
        try{
            PreparedStatement ps = Conexion.getInstance().getConexion()
                    .prepareCall("SELECT * FROM vw_servicios");
            ResultSet resultado = ps.executeQuery();
                while(resultado.next()){
                    Servicios servicio = new Servicios();
                    servicio.setIdServicio(resultado.getInt(1));
                    servicio.setNombreServicio(resultado.getString(2));
                    servicio.setDescripcionS(resultado.getString(3));
                    System.out.println(servicio.vistaServicios());
                }
            resultado.close();
        } catch(SQLException e){
            e.getMessage();
            System.exit(0);
        }
    }
    public void buscarServicios(){
        Servicios serv= new Servicios ();
        System.out.println("Ingrese el id del servicio");
        int idServicio = sc.nextInt();
        try{
           PreparedStatement ps = Conexion.getInstance().getConexion()
                   .prepareCall("CALL sp_buscarServicios(?)");
           ps.setInt(1, idServicio);
           ps.execute();
           ResultSet resultado  = ps.executeQuery();
            if(!resultado.isBeforeFirst()){
                while(!resultado.next()){
                    serv.setNotFound(resultado.getString(2));
                    System.out.println(serv.notFound());
                }
            }else{
                while(resultado.next()){
                    serv.setIdServicio(resultado.getInt(1));
                    serv.setNombreServicio(resultado.getString(2));
                    serv.setDescripcionS(resultado.getString(3));
                    System.out.println(serv.vistaServicios());
                }
                resultado.close();
            }
        }catch(SQLException e){
            e.getMessage();
        }
    }
    public void insertarServicios(){
        BuffReader bf = new BuffReader();
        System.out.println("Ingrese el nombre del servicio");
        String servicio = bf.servicio();
        System.out.println("Ingrese la descripción del servicio");
        String descripcion = bf.descripcion();
            try{
                PreparedStatement ps = Conexion.getInstance().getConexion()
                       .prepareCall("CALL sp_insertarServicios(?,?)");
                ps.setString(1, servicio);
                ps.setString(2, descripcion);
                ps.execute();
                System.out.println("Servicio agregado exitosamente");
            } catch(SQLException e){
                e.getMessage();
                System.exit(0);
            }
    }
    public void actualizarServicios(){
        BuffReader bf = new BuffReader();
        System.out.println("Ingrese el id del servicio a actualizar");
        int idServicio = sc.nextInt();
        System.out.println("Ingrese el nuevo nombre del servicio");
        String servicio = bf.servicio();
        System.out.println("Ingrese la nueva descripcion del servicio");
        String descripcion = bf.descripcion();
            try{
                PreparedStatement ps = Conexion.getInstance().getConexion()
                        .prepareCall("CALL sp_actualizarServicios(?,?,?)");
                ps.setInt(1, idServicio);
                ps.setString(2, servicio);
                ps.setString(3, descripcion);
                ps.execute();
                System.out.println("Servicio actualizado exitosamente");
            } catch(SQLException e){
                e.getMessage();
                System.exit(0);
            }
    }
    public void eliminarServicios(){
        System.out.println("Ingrese el id del servicio a eliminar");
        int idServicio = sc.nextInt();
            try{
                PreparedStatement ps = Conexion.getInstance().getConexion()
                     .prepareCall("CALL sp_eliminarServicios(?)");
                ps.setInt(1, idServicio);
                ps.execute();
                System.out.println("Servicio eliminado exitosamente");
            } catch(SQLException e){
                e.getMessage();
                System.exit(0);
            }
    }
}
