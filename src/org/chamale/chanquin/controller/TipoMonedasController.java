package org.chamale.chanquin.controller;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import org.chamale.chanquin.model.TipoMonedas;
import org.chamale.chanquin.dao.Conexion;
/**
 *
 * @author Edwar René Chamalé González - 2022222
 * @author Jose Rodrigo Chanquín Mac - 2022240
 * 
 */
public class TipoMonedasController {
    Scanner sc = new Scanner(System.in);
    public void listarTipoMonedas(){
        try{
            PreparedStatement ps = Conexion.getInstance().getConexion()
                    .prepareCall("SELECT * FROM vw_tipoMoneda");
            ResultSet resultado = ps.executeQuery();
                while(resultado.next()){
                    TipoMonedas tipoMonedas = new TipoMonedas();
                    tipoMonedas.setIdMoneda(resultado.getInt(1));
                    tipoMonedas.setNameMoneda(resultado.getString(2));
                    System.out.println(tipoMonedas.vistaMonedas());
                }
            resultado.close();
        } catch(SQLException e){
            e.getMessage();
            System.exit(0);
        }
    }
    public void buscarTipoMonedas(){
        TipoMonedas tipoMonedas = new TipoMonedas();
        System.out.println("Ingrese el id del tipo de moneda a buscar");
        int idTipoMoneda = sc.nextInt();
            try{
                PreparedStatement ps = Conexion.getInstance().getConexion()
                        .prepareCall("CALL sp_buscarTipoMonedas(?)");
                ps.setInt(1, idTipoMoneda);
                ps.execute();
                ResultSet resultado = ps.executeQuery();
                    if(!resultado.isBeforeFirst()){
                        while(!resultado.next()){
                            tipoMonedas.setNotFound(resultado.getString(2));
                            System.out.println(tipoMonedas.notFound());
                        }
                    } else{
                        while(resultado.next()){
                            tipoMonedas.setIdMoneda(resultado.getInt(1));
                            tipoMonedas.setNameMoneda(resultado.getString(2));
                            System.out.println(tipoMonedas.vistaMonedas());
                        resultado.close();
                        }
                    }
            } catch(SQLException e){
                e.getMessage();
            }
    }
    public void insertarTipoMonedas(){
        BuffReader bf = new BuffReader();
        System.out.println("Ingrese el nombre de moneda");
        String tipoMoneda = bf.tipoMoneda();
            try{
                PreparedStatement ps = Conexion.getInstance().getConexion()
                       .prepareCall("CALL sp_insertarTipoMonedas(?)");
                ps.setString(1, tipoMoneda);
                ps.execute();
                System.out.println("Nombre de la moneda agregada exitosamente");
            } catch(SQLException e){
                e.getMessage();
                System.exit(0);
            }
    }
    public void actualizarTipoMoneda(){
        BuffReader bf = new BuffReader();
        System.out.println("Ingrese el id del tipo de moneda a actualizar");
        int idTipoMoneda = sc.nextInt();
        System.out.println("Ingrese el nuevo nombre de la moneda");
        String tipoMoneda = bf.tipoMoneda();
            try{
                PreparedStatement ps = Conexion.getInstance().getConexion()
                        .prepareCall("CALL sp_actualizarTipoMonedas(?,?)");
                ps.setInt(1, idTipoMoneda);
                ps.setString(2, tipoMoneda);
                ps.execute();
                System.out.println("Nombre de la moneda actualizada exitosamente");
            } catch(SQLException e){
                e.getMessage();
                System.exit(0);
            }
    }
    public void eliminarTipoMoneda(){
        System.out.println("Ingrese el id del tipo moneda a eliminar");
        int idTipoMateria = sc.nextInt();
            try{
                PreparedStatement ps = Conexion.getInstance().getConexion()
                        .prepareCall("CALL sp_eliminarTipoMonedas(?)");
                ps.setInt(1, idTipoMateria);
                ps.execute();
                System.out.println("Moneda eliminada exitosamente");
            } catch(SQLException e){
                e.getMessage();
                System.exit(0);
            }
    }
}
