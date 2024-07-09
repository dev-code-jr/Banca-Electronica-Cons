package org.chamale.chanquin.controller;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import org.chamale.chanquin.model.EmpresaTelefonicas;
import org.chamale.chanquin.dao.Conexion;
/**
 *
 * @author Edwar René Chamalé González - 2022222
 * @author Jose Rodrigo Chanquín Mac - 2022240
 * 
 */
public class EmpresaTelefonicasController {
    Scanner sc = new Scanner(System.in);
    public void listarEmpresasTelefonicas(){
        try{
            PreparedStatement ps = Conexion.getInstance().getConexion()
                    .prepareCall("SELECT * FROM vw_empresasTelefonicas");
            ResultSet resultado = ps.executeQuery();
                while(resultado.next()){
                    EmpresaTelefonicas empresaTelefonicas = new EmpresaTelefonicas();
                    empresaTelefonicas.setIdEmpresa(resultado.getInt(1));
                    empresaTelefonicas.setNombreEmpresa(resultado.getString(2));
                    System.out.println(empresaTelefonicas.vistaCompañias());
                }
                resultado.close();
        } catch(SQLException e){
            e.getMessage();
            System.exit(0);
        }
    }
    public void buscarEmpresasTelefonicas(){
        EmpresaTelefonicas empresaTelefonicas = new EmpresaTelefonicas();
        System.out.println("Ingrese el id de la compañia telefonica");
        int idCompañia = sc.nextInt();
        try{
            PreparedStatement ps = Conexion.getInstance().getConexion()
                    .prepareCall("CALL sp_buscarEmpresaTelefonica(?)");
            ps.setInt(1, idCompañia);
            ps.execute();
            ResultSet resultado = ps.executeQuery();
                if(!resultado.isBeforeFirst() ){
                    while(!resultado.next()){
                        empresaTelefonicas.setNotFound(resultado.getString(2));
                        System.out.println(empresaTelefonicas.notFound());
                    }
                } else{
                    while(resultado.next()){
                        empresaTelefonicas.setIdEmpresa(resultado.getInt(1));
                        empresaTelefonicas.setNombreEmpresa(resultado.getString(2));
                        System.out.println(empresaTelefonicas.vistaCompañias());
                    }
                    resultado.close();
                }
        } catch(SQLException e){
            e.getMessage();
        }
    }
    public void insertarEmpresasTelefonicas(){
        BuffReader bf = new BuffReader();
        System.out.println("Ingrese el nombre de la compañia telefonica");
        String nombreEmpresaTelefonica = bf.nombreEmpresaTelefonica();
            try{
                PreparedStatement ps = Conexion.getInstance().getConexion()
                        .prepareCall("CALL sp_insertarEmpresasTelefonicas(?)");
                ps.setString(1, nombreEmpresaTelefonica);
                ps.execute();
                System.out.println("Compañia telefonica agregrada exitosamente");
            } catch(SQLException e){
                e.getMessage();
                System.exit(0);
            }
    }
    public void actualizarEmpresasTelefonicas(){
        BuffReader bf = new BuffReader();
        System.out.println("Ingrese el id de la compañia telefonica a actualizar");
        int idEmpresaTelefonica = sc.nextInt();
        System.out.println("Ingrese el nuevo nombre de la compañia de telefonica");
        String nombreEmpresaTelefonica = bf.nombreEmpresaTelefonica();
            try{
                PreparedStatement ps = Conexion.getInstance().getConexion()
                        .prepareCall("CALL sp_actualizarEmpresasTelefonicas(?,?)");
                ps.setInt(1, idEmpresaTelefonica);
                ps.setString(2, nombreEmpresaTelefonica);
                ps.execute();
                System.out.println("Compañia telefonica actualizada exitosamente");
            } catch(SQLException e){
                e.getMessage();
                System.exit(0);
            }
    }
    public void eliminarEmpresasTelefonicas(){
        System.out.println("Ingrese el id de la compañia a eliminar");
        int idEmpresaTelefonica = sc.nextInt();
            try{
                PreparedStatement ps = Conexion.getInstance().getConexion()
                        .prepareCall("CALL sp_eliminarEmpresasTelefonicas(?)");
                ps.setInt(1, idEmpresaTelefonica);
                ps.execute();
                System.out.println("Compañia telefonica eliminada exitosamente");
            } catch(SQLException e){
                e.getMessage();
                System.exit(0);
            }
    }
}
