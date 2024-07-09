package org.chamale.chanquin.controller;
import org.chamale.chanquin.model.Cuentas;
import org.chamale.chanquin.dao.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
/**
 *
 * @author Edwar René Chamalé González - 2022222
 * @author Jose Rodrigo Chanquín Mac - 2022240
 * 
 */
public class CuentasController {
    Scanner sc = new Scanner(System.in);
    public void mostrarCuentas(){
        try{
            PreparedStatement ps = Conexion.getInstance().getConexion()
                    .prepareCall("SELECT * FROM vw_cuentas");
            ResultSet resultado = ps.executeQuery();
            while(resultado.next()){
                Cuentas cuentas = new Cuentas();
                cuentas.setIdCuenta(resultado.getLong(1));
                cuentas.setIdTipoCuenta(resultado.getString(2));
                cuentas.setNombreCompleto(resultado.getString(3));
                cuentas.setNoDPI(resultado.getLong(4));
                cuentas.setNoPasaporte(resultado.getLong(5));
                cuentas.setMoneda(resultado.getString(6));
                cuentas.setEstadoCuenta(resultado.getString(7));
                cuentas.setSaldo(resultado.getDouble(8));
                System.out.println(cuentas.vistaCuentas());
            }
            resultado.close();
        } catch(SQLException e){
            e.getMessage();
            System.exit(0);
        }
    }
    public void buscarCuenta(){
        Cuentas cuentas = new Cuentas();
        System.out.println("Ingrese el no. cuenta a buscar");
        long idCuenta = sc.nextLong();
            try{
                PreparedStatement ps = Conexion.getInstance().getConexion()
                        .prepareCall("CALL sp_buscarCuenta(?)");
                ps.setLong(1, idCuenta);
                ps.execute();
                ResultSet resultado = ps.executeQuery();
                    if(!resultado.isBeforeFirst()){
                        while(!resultado.next()){
                            cuentas.setNotFound(resultado.getString(2));
                            System.out.println(cuentas.notFound());
                        }
                    } else{
                        while(resultado.next()){
                            cuentas.setIdCuenta(resultado.getLong(1));
                            cuentas.setIdTipoCuenta(resultado.getString(2));
                            cuentas.setNombreCompleto(resultado.getString(3));
                            cuentas.setNoDPI(resultado.getLong(4));
                            cuentas.setNoPasaporte(resultado.getLong(5));
                            cuentas.setMoneda(resultado.getString(6));
                            cuentas.setEstadoCuenta(resultado.getString(7));
                            cuentas.setSaldo(resultado.getDouble(8));
                            System.out.println(cuentas.vistaCuentas());
                        }
                        resultado.close();
                    }
            } catch(SQLException e){
                e.getMessage();
            }
    }
    public void insertarCuentas(){
        BuffReader bf = new BuffReader();
        System.out.println("Ingrese el id del tipo de cuenta");
        int idTipoCuenta = sc.nextInt();
        System.out.println("Ingrese el id del tipo moneda");
        int idTipoMoneda = sc.nextInt();
        System.out.println("Ingrese el id del cliente");
        int idCliente = sc.nextInt();
        System.out.println("Ingrese el Estado de la cuenta");
        String estadoCuenta = bf.estadoCuenta();
        System.out.println("Ingrese el saldo de la cuenta");
        double saldo = sc.nextDouble();
            try{
                PreparedStatement ps = Conexion.getInstance().getConexion()
                        .prepareCall("CALL sp_insertarCuentas(?, ?, ?, ?,?)");
                ps.setInt(1, idTipoCuenta);
                ps.setInt(2, idTipoMoneda);
                ps.setInt(3, idCliente);
                ps.setString(4, estadoCuenta);
                ps.setDouble(5, saldo);
                ps.execute();
                System.out.println("Cuenta agregada exitosamente");
            } catch(SQLException e){
                e.getMessage();
            }
    }
    public void actualizarCuentas(){
        BuffReader bf = new BuffReader();
        System.out.println("Ingrese el no. de cuenta a actualizar");
        long noCuenta = sc.nextInt();
        System.out.println("Ingrese el nuevo id del tipo de cuenta a actualizar");
        int idTipoCuenta = sc.nextInt();
        System.out.println("Ingrese el nuevo id del tipo moneda a actualizar");
        int idTipoMoneda = sc.nextInt();
        System.out.println("Ingrese el nuevo id del cliente a actualizar");
        int idCliente = sc.nextInt();
        System.out.println("Ingrese el nuevo estado de la cuenta");
        String estadoCuenta = bf.estadoCuenta();
        System.out.println("Ingrese el nuevo saldo de la cuenta a actualizar");
        double saldo = sc.nextDouble();
            try{
                PreparedStatement ps = Conexion.getInstance().getConexion()
                        .prepareCall("CALL sp_actualizarCuentas(?, ?, ?, ?, ?,?)");
                ps.setLong(1, noCuenta);
                ps.setInt(2, idTipoCuenta);
                ps.setInt(3, idTipoMoneda);
                ps.setInt(4, idCliente);
                ps.setString(5, estadoCuenta);
                ps.setDouble(6, saldo);
                ps.execute();
                System.out.println("Cuenta actualizada exitosamente");
            } catch(SQLException e){
                e.getMessage();
            }
    }
    public void eliminarCuentas(){
        System.out.println("Ingrese el no de cuenta a eliminar");
        long noCuenta = sc.nextLong();
            try{
                PreparedStatement ps = Conexion.getInstance().getConexion()
                        .prepareCall("CALL sp_eliminarCuentas(?)");
                ps.setLong(1, noCuenta);
                ps.execute();
                System.out.println("Cuenta eliminada exitosamente");
            } catch(SQLException e){
                e.getMessage();
            }
    }
}
