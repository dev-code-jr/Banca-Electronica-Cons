package org.chamale.chanquin.controller;
import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
 *
 * @author Edwar René Chamalé González - 2022222
 * @author Jose Rodrigo Chanquín Mac - 2022240
 * 
 */
public class BuffReader {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    public String tipoMoneda(){
        String tipoMoneda = null;
            try{
                tipoMoneda = bf.readLine();
            } catch(Exception ioe){
                System.out.println("¡Error! de IOE");
                System.exit(0);
            }
            return tipoMoneda;
    }
    public String nombreEmpresaTelefonica(){
        String nombreEmpresaTelefonica = null;
            try{
                nombreEmpresaTelefonica = bf.readLine();
            } catch(Exception ioe){
                System.out.println("¡Error! de IOE");
                System.exit(0);
            }
            return nombreEmpresaTelefonica;
    }
        public String usuario(){
       String usuario = null;
       try{
           usuario = bf.readLine();
       }catch(Exception ioe){
           System.out.println("¡Error! de IOE");
           System.exit(0);
       }
       return usuario;
    }
    
    public String clave(){
       String clave = null;
       try{
           clave = bf.readLine();
       }catch(Exception ioe){
           System.out.println("¡Error! de IOE");
           System.exit(0);
       }
       return clave;
    }
    
    public String tipoCuenta (){
        String tipoCuenta = null;
       try{
           tipoCuenta = bf.readLine();
       }catch(Exception ioe){
           System.out.println("¡Error! de IOE");
           System.exit(0);
       }
       return tipoCuenta;
    }
    
    public String servicio(){
        String servicio = null;
        try{
            servicio = bf.readLine();
        }catch(Exception ioe){
            System.out.println("¡Error! de IOE");
            System.exit(0);
        }
        return servicio;
    }
    
    public String descripcion(){
        String descripcion = null;
        try{
            descripcion = bf.readLine();
        }catch(Exception ioe){
            System.out.println("¡Error! de IOE");
            System.exit(0);
        }
        return descripcion;
    }
    
    public String identificador(){
        String identificador = null;
        try{
            identificador = bf.readLine();
        }catch(Exception ioe){
            System.out.println("¡Error! de IOE");
            System.exit(0);
        }
        return identificador;
    }
    
    public String descripcionT(){
        String descripcionT = null;
        try{
            descripcionT = bf.readLine();
        }catch(Exception ioe){
            System.out.println("¡Error! de IOE");
            System.exit(0);
        }
        return descripcionT;
    }
    
    public String nombreCliente(){
        String nombreCliente = null;
            try{
                nombreCliente = bf.readLine();
            } catch(Exception IOE){
                System.out.println("¡Error! de IOE");
                System.exit(0);
            }
            return nombreCliente;
    }
    
    public String apellidoCliente(){
        String apellidoCliente = null;
            try{
                apellidoCliente = bf.readLine();
            } catch(Exception IOE){
                System.out.println("¡Error! de IOE"); 
                System.exit(0);
            }
            return apellidoCliente;
    }
    
    public String direccion(){
        String direccion = null;
            try{
                direccion = bf.readLine();
            } catch(Exception IOE){
                System.out.println("¡Error de IOE!");
                System.exit(0);
            }
            return direccion;
    }
    
    public String sexualidad(){
        String sexualidad = null;
            try{
                sexualidad = bf.readLine();
            } catch(Exception IOE){
                System.out.println("¡Error! de IOE");
                System.exit(0);
            }
            return sexualidad;
    }
    
    public String nacionalidad(){
        String nacionalidad = null;
            try{
                nacionalidad = bf.readLine();
            } catch(Exception IOE){
                System.out.println("¡Error! de IOE");
                System.exit(0);
            }
            return nacionalidad;
    }
    
    public String estadoCuenta(){
        String estadoCuenta = null;
        try{
            estadoCuenta = bf.readLine();
        }catch(Exception IOE){
            System.out.println("¡Error! de IOE");
            System.exit(0);
        }
        return estadoCuenta;
    }
}
