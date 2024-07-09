package org.chamale.chanquin.controller;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.chamale.chanquin.model.Clientes;
import org.chamale.chanquin.dao.Conexion;
import java.util.Scanner;
/**
 *
 * @author Edwar René Chamalé González - 2022222
 * @author Jose Rodrigo Chanquín Mac - 2022240
 * 
 */
public class ClientesController {
    Scanner sc = new Scanner(System.in);
    public void listarClientes(){
        try{
            PreparedStatement ps = Conexion.getInstance().getConexion()
                    .prepareCall("SELECT * FROM vw_clientes");
            ResultSet resultado = ps.executeQuery();
                while(resultado.next()){
                    Clientes clientes = new Clientes();
                    clientes.setCodCliente(resultado.getInt(1));
                    clientes.setNombreCompleto(resultado.getString(2));
                    clientes.setDireccionVista(resultado.getString(3));
                    clientes.setTelefonoVista(resultado.getLong(4));
                    clientes.setNameCompañia(resultado.getString(5));
                    clientes.setGenero(resultado.getString(6));
                    clientes.setNacionalidadVista(resultado.getString(7));
                    clientes.setNoDPIVista(resultado.getLong(8));
                    clientes.setNoPasaporteVista(resultado.getLong(9));
                    System.out.println(clientes.vistaClientes());
                }
                resultado.close();
        } catch(SQLException e){
            e.getMessage();
        }
    }
    public void buscarCliente(){
        Clientes clientes = new Clientes();
        System.out.println("Ingrese el codigo del cliente a buscar");
        int codCliente = sc.nextInt();
            try{
                PreparedStatement ps = Conexion.getInstance().getConexion()
                        .prepareCall("CALL sp_buscarCliente(?)");
                ps.setInt(1, codCliente);
                ps.execute();
                ResultSet resultado = ps.executeQuery();
                    if(!resultado.isBeforeFirst()){
                        while(!resultado.next()){
                            clientes.setNotFound(resultado.getString(2));
                            System.out.println(clientes.notFound());
                        }
                    } else{
                        while(resultado.next()){
                            clientes.setCodCliente(resultado.getInt(1));
                            clientes.setNombreCompleto(resultado.getString(2));
                            clientes.setDireccionVista(resultado.getString(3));
                            clientes.setTelefonoVista(resultado.getLong(4));
                            clientes.setNameCompañia(resultado.getString(5));
                            clientes.setGenero(resultado.getString(6));
                            clientes.setNacionalidadVista(resultado.getString(7));
                            clientes.setNoDPIVista(resultado.getLong(8));
                            clientes.setNoPasaporteVista(resultado.getLong(9));
                            System.out.println(clientes.vistaClientes());
                        }
                        resultado.close();
                    }
            } catch(SQLException e){
                e.getMessage();
            }
    }
    public void insertarClientes(){
        BuffReader bf = new BuffReader();
        System.out.println("Ingrese su nombre");
        String nombreCliente = bf.nombreCliente();
        System.out.println("Ingrese su apellido");
        String apellidoCliente = bf.apellidoCliente();
        System.out.println("Ingrese su direccicon");
        String direccion = bf.direccion();
        System.out.println("Ingrese su numero de telefono");
        long telefono = sc.nextLong();
        System.out.println("Ingrese su genero");
        String genero = bf.sexualidad();
        System.out.println("Ingrese su nacionalidad");
        String nacionalidad = bf.nacionalidad();
        System.out.println("Ingrese su No. DPI (solo valido para personas nacionales)");
        System.out.println("Ingrese '0' si no es una persona nacional");
        long noDPI = sc.nextLong();
        System.out.println("Ingrese su No. Pasaporte (solo valido para personas no nacionales)");
        System.out.println("Ingrese '0' si es una persona nacional");
        long noPasaporte = sc.nextLong();
        System.out.println("Ingrese el id de la compañia telefonica de su telefono");
        int compañiaTelefonica = sc.nextInt();
            try{
                PreparedStatement ps = Conexion.getInstance().getConexion()
                        .prepareCall("CALL sp_insertarClientes(?, ?, ?, ?, ?, ?, ?, ?, ?)");
                ps.setString(1, nombreCliente);
                ps.setString(2, apellidoCliente);
                ps.setString(3, direccion);
                ps.setLong(4, telefono);
                ps.setString(5, genero);
                ps.setString(6, nacionalidad);
                ps.setLong(7, noDPI);
                ps.setLong(8, noPasaporte);
                ps.setInt(9, compañiaTelefonica);
                ps.execute();
                System.out.println("Cliente agregado exitosamente");
            } catch(SQLException e){
                e.getMessage();
                System.exit(0);
            }
    }
    public void insertarClientesYUser(){
        BuffReader bf = new BuffReader();
        System.out.println("Ingrese su nombre");
        String nombreCliente = bf.nombreCliente();
        System.out.println("Ingrese su apellido");
        String apellidoCliente = bf.apellidoCliente();
        System.out.println("Ingrese su direccicon");
        String direccion = bf.direccion();
        System.out.println("Ingrese su numero de telefono");
        long telefono = sc.nextLong();
        System.out.println("Ingrese su genero");
        String genero = bf.sexualidad();
        System.out.println("Ingrese su nacionalidad");
        String nacionalidad = bf.nacionalidad();
        System.out.println("Ingrese su No. DPI (solo valido para personas nacionales)");
        System.out.println("Ingrese '0' si no es una persona nacional");
        long noDPI = sc.nextLong();
        System.out.println("Ingrese su No. Pasaporte (solo valido para personas no nacionales)");
        System.out.println("Ingrese '0' si es una persona nacional");
        long noPasaporte = sc.nextLong();
        System.out.println("Ingrese el id de la compañia telefonica de su telefono");
        int compañiaTelefonica = sc.nextInt();
            try{
                PreparedStatement ps = Conexion.getInstance().getConexion()
                        .prepareCall("CALL sp_insertarClientes(?, ?, ?, ?, ?, ?, ?, ?, ?)");
                ps.setString(1, nombreCliente);
                ps.setString(2, apellidoCliente);
                ps.setString(3, direccion);
                ps.setLong(4, telefono);
                ps.setString(5, genero);
                ps.setString(6, nacionalidad);
                ps.setLong(7, noDPI);
                ps.setLong(8, noPasaporte);
                ps.setInt(9, compañiaTelefonica);
                ps.execute();
                this.usuarios();
            } catch(SQLException e){
                e.getMessage();
            }
            
    }
    public void usuarios(){
        try{
            PreparedStatement sp = Conexion.getInstance().getConexion()
                .prepareCall("call sp_mostrarUltimoCod();");
            ResultSet result = sp.executeQuery();
                while(result.next()){
                    Clientes cli = new Clientes();
                    cli.setCodCliente(result.getInt(1));
                    System.out.println(cli.ultimoDato());
                }
            
        } catch(SQLException e){
            e.getMessage();
        }
        UsuariosController uController = new UsuariosController();
        uController.insertarUsuarios();
    }
    public void actualizarClientes(){
        BuffReader bf = new BuffReader();
        System.out.println("Ingrese su codigo de cliente a actualizar");
        int idCliente = sc.nextInt();
        System.out.println("Ingrese su nuevo nombre");
        String nombreNuevo = bf.nombreCliente();
        System.out.println("Ingrese su nuevo apellido");
        String apellidoNuevo = bf.apellidoCliente();
        System.out.println("Ingrese su nueva direccion");
        String direccionNueva = bf.direccion();
        System.out.println("Ingrese su nuevo numero de telefono");
        long telefonoNuevo = sc.nextLong();
        System.out.println("Ingrese su nuevo genero");
        String generoNuevo = bf.sexualidad();
        System.out.println("Ingrese su nueva nacionalidad");
        String nuevaNacionalidad = bf.nacionalidad();
        System.out.println("Ingrese su nuevo No. DPI (solo valido para personas nacionales)");
        System.out.println("Ingrese '0' si no es una persona nacional");
        long noDPINuevo = sc.nextLong();
        System.out.println("Ingrese su nuevo No. Pasaporte (solo valido para personas no nacionales)");
        System.out.println("Ingrese '0' si es una persona nacional");
        long noPasaporteNuevo = sc.nextLong();
        System.out.println("Ingrese el id de la nueva compañia telefonica de su telefono");
        int idCompañiaNueva = sc.nextInt();
            try{
                PreparedStatement ps = Conexion.getInstance().getConexion()
                        .prepareCall("CALL sp_actualizarClientes(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
                ps.setInt(1, idCliente);
                ps.setString(2, nombreNuevo);
                ps.setString(3, apellidoNuevo);
                ps.setString(4, direccionNueva);
                ps.setLong(5, telefonoNuevo);
                ps.setString(6, generoNuevo);
                ps.setString(7, nuevaNacionalidad);
                ps.setLong(8, noDPINuevo);
                ps.setLong(9, noPasaporteNuevo);
                ps.setInt(10, idCompañiaNueva);
                ps.execute();
            } catch(SQLException e){
                e.getMessage();
                System.exit(0);
            }
    }
    public void eliminarClientes(){
        System.out.println("Ingrese el codigo de cliente a eliminar");
        int codigoEliminar = sc.nextInt();
            try{
                PreparedStatement ps = Conexion.getInstance().getConexion()
                        .prepareCall("CALL sp_eliminarClientes(?)");
                ps.setInt(1, codigoEliminar);
                ps.execute();
            } catch(SQLException e){
            e.getMessage();
            System.exit(0);
            }
    }
}
