package org.chamale.chanquin.controller;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import org.chamale.chanquin.dao.Conexion;
import org.chamale.chanquin.model.Transacciones;
/**
 *
 * @author Edwar René Chamalé González - 2022222
 * @author Jose Rodrigo Chanquín Mac - 2022240
 * 
 */
public class TransaccionesController {
    Scanner sc= new Scanner(System.in);
    public void listarTransacciones(){
        try{
            PreparedStatement ps = Conexion.getInstance().getConexion()
                    .prepareCall("SELECT * FROM vw_transacciones");
            ResultSet resultado = ps.executeQuery();
                while(resultado.next()){
                    Transacciones transaccion = new Transacciones();
                    transaccion.setIdTransaccion(resultado.getInt(1));
                    transaccion.setNombreCompleto(resultado.getString(2));
                    transaccion.setNoCuenta_(resultado.getLong(3));
                    transaccion.setTipoCuenta(resultado.getString(4));
                    transaccion.setNameServicio(resultado.getString(5));
                    transaccion.setIdentificadorPago(resultado.getString(6));
                    transaccion.setDescripcion_(resultado.getString(7));
                    transaccion.setMontoPagar(resultado.getDouble(8));
                    transaccion.setFechaPago(resultado.getString(9));
                    System.out.println(transaccion.vistaTransacciones());
                }
            resultado.close();
        } catch(SQLException e){
            e.getMessage();
        }
    }
    public void buscarTransacciones(){
        Transacciones transaccion= new Transacciones ();
        System.out.println("Ingrese el id de Transación");
        int  IdTransaccion= sc.nextInt();
        try{
           PreparedStatement ps = Conexion.getInstance().getConexion()
                   .prepareCall("CALL sp_buscarTransacciones(?)");
           ps.setInt(1, IdTransaccion);
           ps.execute();
           ResultSet resultado  = ps.executeQuery();
            if(!resultado.isBeforeFirst()){
                while(!resultado.next()){
                    transaccion.setNotFound(resultado.getString(2));
                    System.out.println(transaccion.notFound());
                }
            }else{
                while(resultado.next()){
                    transaccion.setIdTransaccion(resultado.getInt(1));
                    transaccion.setNombreCompleto(resultado.getString(2));
                    transaccion.setNoCuenta_(resultado.getLong(3));
                    transaccion.setTipoCuenta(resultado.getString(4));
                    transaccion.setNameServicio(resultado.getString(5));
                    transaccion.setIdentificadorPago(resultado.getString(6));
                    transaccion.setDescripcion_(resultado.getString(7));
                    transaccion.setMontoPagar(resultado.getDouble(8));
                    transaccion.setFechaPago(resultado.getString(9));
                    System.out.println(transaccion.vistaTransacciones());
                }
                resultado.close();
            }
        }catch(SQLException e){
            e.getMessage();
        }
    }
    public void reporteMayores1000(){
        try{
            PreparedStatement ps = Conexion.getInstance().getConexion()
                    .prepareCall("SELECT * FROM vw_PagosMayoresA_1000");
            ResultSet resultado = ps.executeQuery();
                while(resultado.next()){
                    Transacciones transaccion = new Transacciones();
                    transaccion.setIdTransaccion(resultado.getInt(1));
                    transaccion.setNombreCompleto(resultado.getString(2));
                    transaccion.setNoCuenta_(resultado.getLong(3));
                    transaccion.setTipoCuenta(resultado.getString(4));
                    transaccion.setNameServicio(resultado.getString(5));
                    transaccion.setIdentificadorPago(resultado.getString(6));
                    transaccion.setDescripcion_(resultado.getString(7));
                    transaccion.setMontoPagar(resultado.getDouble(8));
                    transaccion.setFechaPago(resultado.getString(9));
                    System.out.println(transaccion.vistaTransacciones());
                }
                resultado.close();
        } catch(SQLException e){
            e.getMessage();
        } 
    }
    public void septiembreADiciembre(){
        try{
            PreparedStatement ps = Conexion.getInstance().getConexion()
                    .prepareCall("SELECT * FROM vw_fechasSepADic");
            ResultSet resultado = ps.executeQuery();
                while(resultado.next()){
                    Transacciones transacciones = new Transacciones();
                    transacciones.setFechaPago(resultado.getString(1));
                    transacciones.setNombreCompleto(resultado.getString(2));
                    transacciones.setDescripcion_(resultado.getString(3));
                    System.out.println(transacciones.fechas());
                }
                resultado.close();
        } catch(SQLException e){
            e.getMessage();
        }
    }
    public void insertarTransacciones(){
        BuffReader bf = new BuffReader();
        LocalDateTime horaFechaLocal = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ISO_DATE_TIME;
        System.out.println("Ingrese el id del cliente");
        int idCliente = sc.nextInt();
        System.out.println("Ingrese numero de cuenta");
        int idCuenta = sc.nextInt();
        System.out.println("Ingrese el id del servicio");
        int idServicio = sc.nextInt();
        System.out.println("Ingrese el identificador de pago");
        String identificador = bf.identificador();
        System.out.println("Ingrese descripción de la transacción");
        String descripcionT = bf.descripcionT();
        System.out.println("Ingrese el monto de la transacción");
        double monto = sc.nextDouble();
        String fecha = horaFechaLocal.format(formato);
            try{
                PreparedStatement ps = Conexion.getInstance().getConexion()
                       .prepareCall("CALL sp_insertarTransacciones(?,?,?,?,?,?,?)");
                ps.setInt(1, idCliente);
                ps.setInt(2, idCuenta);
                ps.setInt(3, idServicio);
                ps.setString(4, identificador);
                ps.setString(5, descripcionT);
                ps.setDouble(6, monto);
                ps.setString(7, fecha);
                ps.execute();
                System.out.println("Transacción agregada exitosamente");
            } catch(SQLException e){
                e.getMessage();
            }
    }
    public void actualizarTransacciones(){
        BuffReader bf = new BuffReader();
        LocalDateTime horaFechaLocal = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ISO_DATE_TIME;
        System.out.println("Ingresar id de Transacción a actualizar");
        int idTransaccion = sc.nextInt();
        System.out.println("Ingrese el nuevo id del cliente a actualizar");
        int idClienteNuevo = sc.nextInt();
        System.out.println("Ingrese el nuevo numero de cuenta a actualizar");
        int idCuentaNueva = sc.nextInt();
        System.out.println("Ingrese el nuevo id del servicio");
        int idServicioNuevo = sc.nextInt();
        System.out.println("Ingrese el nuevo identificador de pago a actualizar");
        String identificador = bf.identificador();
        System.out.println("Ingrese la nueva descripción de la transacción a actualizar");
        String descripcionT = bf.descripcionT();
        System.out.println("Ingrese el monto de la transacción a actualizar");
        double monto = sc.nextDouble();
        String fechaNueva = horaFechaLocal.format(formato);
            try{
                PreparedStatement ps = Conexion.getInstance().getConexion()
                        .prepareCall("CALL sp_actualizarTransacciones(?,?,?,?,?,?,?,?)");
                ps.setInt(1, idTransaccion);
                ps.setInt(2, idClienteNuevo);
                ps.setInt(3, idCuentaNueva);
                ps.setInt(4, idServicioNuevo);
                ps.setString(5, identificador);
                ps.setString(6, descripcionT);
                ps.setDouble(7, monto);
                ps.setString(8, fechaNueva);
                ps.execute();
                System.out.println("Transaccion actualizada exitosamente");
            } catch(SQLException e){
                e.getMessage();
            }
    }
    public void eliminarTransacciones(){
        System.out.println("Ingrese el id de la Transacción a eliminar");
        int idTransaccion = sc.nextInt();
            try{
                PreparedStatement ps = Conexion.getInstance().getConexion()
                     .prepareCall("CALL sp_eliminarTransacciones(?)");
                ps.setInt(1, idTransaccion);
                ps.execute();
                System.out.println("Transaccion eliminada exitosamente");
            } catch(SQLException e){
                e.getMessage();
            }
    }
}
