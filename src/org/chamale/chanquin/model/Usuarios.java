package org.chamale.chanquin.model;
/**
 *
 * @author Edwar René Chamalé González - 2022222
 * @author Jose Rodrigo Chanquín Mac - 2022240
 * 
 */
public class Usuarios {
    private int codCliente;
    private int idCliente;
    private String nombreCompleto;
    private String correoEletronico;
    private String clave;
    private int idUsuario;
    private String user;
    private String password;
    private String notFound;
    
    public Usuarios (){
    }

    public Usuarios(int codCliente, String correoEletronico, String clave) {
        this.codCliente = codCliente;
        this.correoEletronico = correoEletronico;
        this.clave = clave;
    }
    
    public Usuarios(int idUsuario, int idCliente, String user, String password) {
        this.idUsuario = idUsuario;
        this.idCliente = idCliente;
        this.user = user;
        this.password = password;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getCorreoEletronico() {
        return correoEletronico;
    }

    public void setCorreoEletronico(String correoEletronico) {
        this.correoEletronico = correoEletronico;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getNotFound() {
        return notFound;
    }

    public void setNotFound(String notFound) {
        this.notFound = notFound;
    }
    
    public int getConCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }
    
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
    
    public String vistaUsuarios(){
        return  "Id del usuario: " + idUsuario + " " +
                "Nombre completo: "+ nombreCompleto + " " +
                "Correo electronico: "+ user + " " +
                "Contraseña: "+ password;
    }
    
    public String notFound(){
        return " Id del usuario: "+ null + " " +
               " Correo electronico: "+ notFound + " " +
               " Contraseña: "+ null;
    }

}
