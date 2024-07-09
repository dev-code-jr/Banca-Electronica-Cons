package org.chamale.chanquin.controller;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import org.chamale.chanquin.dao.Conexion;
import org.chamale.chanquin.model.TipoCuentas;
/**
 *
 * @author Edwar René Chamalé González - 2022222
 * @author Jose Rodrigo Chanquín Mac - 2022240
 * 
 */
public class TipoCuentasController {
    Scanner sc = new Scanner(System.in);
    public void listarTipoCuentas(){
        try{
            PreparedStatement ps = Conexion.getInstance().getConexion()
                    .prepareCall("SELECT * FROM vw_tipoCuenta");
            ResultSet resultado = ps.executeQuery();
                while(resultado.next()){
                    TipoCuentas tipoCuenta = new TipoCuentas();
                    tipoCuenta.setIdTCuenta(resultado.getInt(1));
                    tipoCuenta.setNameCuenta(resultado.getString(2));
                    System.out.println(tipoCuenta.vistaTipoCuentas());
                }
            resultado.close();
        } catch(SQLException e){
            e.getMessage();
            System.exit(0);
        }
    }
     public void buscarTipoCuenta(){
        TipoCuentas tCuentas= new TipoCuentas ();
        System.out.println("Ingrese el id de el Tipo de cuenta");
        int idTCuenta = sc.nextInt();
        try{
           PreparedStatement ps = Conexion.getInstance().getConexion()
                   .prepareCall("CALL sp_buscarTipoCuentas(?)");
           ps.setInt(1, idTCuenta);
           ps.execute();
           ResultSet resultado  = ps.executeQuery();
            if(!resultado.isBeforeFirst()){
                while(!resultado.next()){
                    tCuentas.setNotFound(resultado.getString(2));
                    System.out.println(tCuentas.notFound());
                }
            }else{
                while(resultado.next()){
                    tCuentas.setIdTCuenta(resultado.getInt(1));
                    tCuentas.setNameCuenta(resultado.getString(2));
                    System.out.println(tCuentas.vistaTipoCuentas());
                }
                resultado.close();
            }
        }catch(SQLException e){
            e.getMessage();
        }
             
    }
    public void insertarTipoCuentas(){
        BuffReader bf = new BuffReader();
        System.out.println("Ingrese el nombre del tipo de cuenta");
        String tipoCuenta = bf.tipoCuenta();
            try{
                PreparedStatement ps = Conexion.getInstance().getConexion()
                       .prepareCall("CALL sp_insertarTiposCuentas(?)");
                ps.setString(1, tipoCuenta);
                ps.execute();
                System.out.println("Tipo de cuenta agregada exitosamente");
            } catch(SQLException e){
                e.getMessage();
                System.exit(0);
            }
    }
    public void actualizarTipoCuentas(){
        BuffReader bf = new BuffReader();
        System.out.println("Ingrese el id del tipo de cuenta a actualizar");
        int idTipoCuenta = sc.nextInt();
        System.out.println("Ingrese el nuevo nombre del tipo de Cuenta");
        String tipoCuenta = bf.tipoMoneda();
            try{
                PreparedStatement ps = Conexion.getInstance().getConexion()
                        .prepareCall("CALL sp_actualizarTipoCuentas(?,?)");
                ps.setInt(1, idTipoCuenta);
                ps.setString(2, tipoCuenta);
                ps.execute();
                System.out.println("Tipo de cuenta actualizada exitosamente");
            } catch(SQLException e){
                e.getMessage();
                System.exit(0);
            }
    }
    public void eliminarTipoCuentas(){
        System.out.println("Ingrese el id del tipo de cuenta a eliminar");
        int idTipoCuenta = sc.nextInt();
            try{
                PreparedStatement ps = Conexion.getInstance().getConexion()
                        .prepareCall("CALL sp_eliminarTipoCuentas(?)");
                ps.setInt(1, idTipoCuenta);
                ps.execute();
                System.out.println("Tipo de cuenta eliminado exitosamente");
            } catch(SQLException e){
                e.getMessage();
                System.exit(0);
            }
    }
}
