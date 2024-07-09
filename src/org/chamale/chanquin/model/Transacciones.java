package org.chamale.chanquin.model;
/**
 *
 * @author Edwar René Chamalé González - 2022222
 * @author Jose Rodrigo Chanquín Mac - 2022240
 * 
 */
public class Transacciones {
    private int codCliente;
    private long noCuenta;
    private int idServicio;
    private String identificador;
    private String descripcion;
    private double monto;
    private String fecha;
    //
    private long idTransaccion;
    private String nombreCompleto;
    private long noCuenta_;
    private String tipoCuenta;
    private String nameServicio;
    private String identificadorPago;
    private String descripcion_;
    private double montoPagar;
    private String fechaPago;
    private String notFound;

    public Transacciones() {
    }

    public Transacciones(int codCliente, long noCuenta, int idServicio, String identificador, String descripcion, double monto, String fecha) {
        this.codCliente = codCliente;
        this.noCuenta = noCuenta;
        this.idServicio = idServicio;
        this.identificador = identificador;
        this.descripcion = descripcion;
        this.monto = monto;
        this.fecha = fecha;
    }

    public Transacciones(long idTransaccion, String nombreCompleto, long noCuenta_, String tipoCuenta, String nameServicio, String identificadorPago, String descripcion_, double montoPagar, String fechaPago) {
        this.idTransaccion = idTransaccion;
        this.nombreCompleto = nombreCompleto;
        this.noCuenta_ = noCuenta_;
        this.tipoCuenta = tipoCuenta;
        this.nameServicio = nameServicio;
        this.identificadorPago = identificadorPago;
        this.descripcion_ = descripcion_;
        this.montoPagar = montoPagar;
        this.fechaPago = fechaPago;
    }

    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }

    public long getNoCuenta() {
        return noCuenta;
    }

    public void setNoCuenta(long noCuenta) {
        this.noCuenta = noCuenta;
    }

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public long getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(long idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public long getNoCuenta_() {
        return noCuenta_;
    }

    public void setNoCuenta_(long noCuenta_) {
        this.noCuenta_ = noCuenta_;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public String getNameServicio() {
        return nameServicio;
    }

    public void setNameServicio(String nameServicio) {
        this.nameServicio = nameServicio;
    }

    public String getIdentificadorPago() {
        return identificadorPago;
    }

    public void setIdentificadorPago(String identificadorPago) {
        this.identificadorPago = identificadorPago;
    }

    public String getDescripcion_() {
        return descripcion_;
    }

    public void setDescripcion_(String descripcion_) {
        this.descripcion_ = descripcion_;
    }

    public double getMontoPagar() {
        return montoPagar;
    }

    public void setMontoPagar(double montoPagar) {
        this.montoPagar = montoPagar;
    }

    public String getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
    }

    public String getNotFound() {
        return notFound;
    }

    public void setNotFound(String notFound) {
        this.notFound = notFound;
    }
    
    public String vistaTransacciones(){
        return "Id transaccion: " + idTransaccion + " " +
            "Nombre completo: " + nombreCompleto + " " +
            "No cuenta: " + noCuenta_ + " " +
            "Tipo de cuenta: " + tipoCuenta + " " +
            "Nombre del servicio: " + nameServicio + " " +
            "Identificador de pago: " + identificadorPago + " " +
            "Descripcion de la transaccion: " + descripcion_ + " " +
            "Monto: " + montoPagar + " " +
            "Fecha y hora del pago: " + fechaPago;
    }
    
    public String notFound(){
        return "Id transaccion: " + null + " " +
            "Nombre completo: " + notFound + " " +
            "No cuenta: " + null + " " +
            "Tipo de cuenta: " + null + " " +
            "Nombre del servicio: " + null + " " +
            "Identificador de pago: " + null + " " +
            "Descripcion de la transaccion: " + null + " " +
            "Monto: " + null + " " +
            "Fecha y hora del pago: " + null;
    }
    
    public String fechas(){
        return "Fecha de Transacciones de Sep a Dic: " + fechaPago + " " +
                "Nombre completo: " + nombreCompleto + " " +
                "Descripciòn: " + descripcion_;
    }
}
