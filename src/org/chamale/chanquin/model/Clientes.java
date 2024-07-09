package org.chamale.chanquin.model;
/**
 *
 * @author Edwar René Chamalé González - 2022222
 * @author Jose Rodrigo Chanquín Mac - 2022240
 * 
 */
public class Clientes {
    private String nombreCliente;
    private String apellidoCliente;
    private String direccion;
    private long telefono;
    private String sexualidad;
    private String nacionalidad;
    private long noDPI;
    private long noPasaporte;
    private int empresaTelefonica;
    private int idUsuario;
    private int codCliente;
    private String nombreCompleto;
    private String direccionVista;
    private long telefonoVista;
    private String nameCompañia;
    private String genero;
    private String nacionalidadVista;
    private long noDPIVista;
    private long noPasaporteVista;
    private String usuario;
    private String clave;
    private String notFound;
    
    public Clientes() {
    }

    public Clientes(String nombreCliente, String apellidoCliente, String direccion, long telefono, String sexualidad,
            String nacionalidad, long noDPI, long noPasaporte, int empresaTelefonica, int idUsuario) {
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.direccion = direccion;
        this.telefono = telefono;
        this.sexualidad = sexualidad;
        this.nacionalidad = nacionalidad;
        this.noDPI = noDPI;
        this.noPasaporte = noPasaporte;
        this.empresaTelefonica = empresaTelefonica;
        this.idUsuario = idUsuario;
    }

    public Clientes(int codCliente, String nombreCompleto, String direccionVista, long telefonoVista, String nameCompañia, String genero,
            String nacionalidadVista, long noDPIVista, long noPasaporteVista) {
        this.codCliente = codCliente;
        this.nombreCompleto = nombreCompleto;
        this.direccionVista = direccionVista;
        this.telefonoVista = telefonoVista;
        this.nameCompañia = nameCompañia;
        this.genero = genero;
        this.nacionalidadVista = nacionalidadVista;
        this.noDPIVista = noDPIVista;
        this.noPasaporteVista = noPasaporteVista;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public String getSexualidad() {
        return sexualidad;
    }

    public void setSexualidad(String sexualidad) {
        this.sexualidad = sexualidad;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public long getNoDPI() {
        return noDPI;
    }

    public void setNoDPI(long noDPI) {
        this.noDPI = noDPI;
    }

    public long getNoPasaporte() {
        return noPasaporte;
    }

    public void setNoPasaporte(long noPasaporte) {
        this.noPasaporte = noPasaporte;
    }

    public int getEmpresaTelefonica() {
        return empresaTelefonica;
    }

    public void setEmpresaTelefonica(int empresaTelefonica) {
        this.empresaTelefonica = empresaTelefonica;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getDireccionVista() {
        return direccionVista;
    }

    public void setDireccionVista(String direccionVista) {
        this.direccionVista = direccionVista;
    }

    public long getTelefonoVista() {
        return telefonoVista;
    }

    public void setTelefonoVista(long telefonoVista) {
        this.telefonoVista = telefonoVista;
    }

    public String getNameCompañia() {
        return nameCompañia;
    }

    public void setNameCompañia(String nameCompañia) {
        this.nameCompañia = nameCompañia;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNacionalidadVista() {
        return nacionalidadVista;
    }

    public void setNacionalidadVista(String nacionalidadVista) {
        this.nacionalidadVista = nacionalidadVista;
    }

    public long getNoDPIVista() {
        return noDPIVista;
    }

    public void setNoDPIVista(long noDPIVista) {
        this.noDPIVista = noDPIVista;
    }

    public long getNoPasaporteVista() {
        return noPasaporteVista;
    }

    public void setNoPasaporteVista(long noPasaporteVista) {
        this.noPasaporteVista = noPasaporteVista;
    }

    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }
    
    public String getNotFound() {
        return notFound;
    }

    public void setNotFound(String notFound) {
        this.notFound = notFound;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
    public String vistaClientes(){
    return "Codigo cliente: " + codCliente + " " +
           "Nombre completo: " + nombreCompleto + " " +
           "Direccion: " + direccionVista + " " +
           "No telefono: " + telefonoVista + " " +
           "Nombre de la compañia telefonica: " + nameCompañia + " " +
           "Genero: " + genero + " " +
           "Nacionalidad: " + nacionalidadVista + " " +
           "No DPI: " + noDPIVista + " " +
           "No pasaporte: " + noPasaporteVista;
            }
    public String notFound(){
        return  "Codigo cliente: " + null + " " +
                "Nombre completo: " + notFound + " " +
                "Direccion: " + null + " " +
                "No telefono: " + null + " " +
                "Nombre de la compañia telefonica: " + null + " " +
                "Genero: " + null + " " +
                "Nacionalidad: " + null + " " +
                "No DPI: " + null + " " +
                "No pasaporte: " + null;
    }
    
    public String ultimoDato(){
        return "Su codigo de cliente es:  " + codCliente;
    }
}
