package org.chamale.chanquin.model;
/**
 *
 * @author Edwar René Chamalé González - 2022222
 * @author Jose Rodrigo Chanquín Mac - 2022240
 * 
 */
public class Cuentas {
    private int tipoCuenta;
    private int tipoMoneda;
    private int codigoCliente;
    private double decimal;
    private long idCuenta;
    private String idTipoCuenta;
    private String nombreCuenta;
    private String nombreCompleto;
    private long noDPI;
    private long noPasaporte;
    private String moneda;
    private String estadoCuenta;
    private double saldo;
    private String notFound;

    public Cuentas() {
    }

    public Cuentas(int tipoCuenta, int tipoMoneda, int codigoCliente, double decimal) {
        this.tipoCuenta = tipoCuenta;
        this.tipoMoneda = tipoMoneda;
        this.codigoCliente = codigoCliente;
        this.decimal = decimal;
    }

    public Cuentas(long idCuenta, String idTipoCuenta, String nombreCuenta, String nombreCompleto,
    long noDPI, long noPasaporte, String moneda, double saldo) {
    this.idCuenta = idCuenta;
    this.idTipoCuenta = idTipoCuenta;
    this.nombreCuenta = nombreCuenta;
    this.nombreCompleto = nombreCompleto;
    this.noDPI = noDPI;
    this.noPasaporte = noPasaporte;
    }
    
    public int getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(int tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public int getTipoMoneda() {
        return tipoMoneda;
    }

    public void setTipoMoneda(int tipoMoneda) {
        this.tipoMoneda = tipoMoneda;
    }

    public int getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(int codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public double getDecimal() {
        return decimal;
    }

    public void setDecimal(double decimal) {
        this.decimal = decimal;
    }

    public long getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(long idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getIdTipoCuenta() {
        return idTipoCuenta;
    }

    public void setIdTipoCuenta(String idTipoCuenta) {
        this.idTipoCuenta = idTipoCuenta;
    }

    public String getNombreCuenta() {
        return nombreCuenta;
    }

    public void setNombreCuenta(String nombreCuenta) {
        this.nombreCuenta = nombreCuenta;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
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

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getEstadoCuenta() {
        return estadoCuenta;
    }

    public void setEstadoCuenta(String estadoCuenta) {
        this.estadoCuenta = estadoCuenta;
    }
    
    
    
    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    public String getNotFound() {
        return notFound;
    }

    public void setNotFound(String notFound) {
        this.notFound = notFound;
    }
    
    public String vistaCuentas(){
    return  "No. cuenta: " + idCuenta + " " +
            "Tipo de cuenta: " + idTipoCuenta + " " +
            "Nombre completo: " + nombreCompleto + " " +
            "Numero de DPI: " + noDPI + " " +
            "Numero de pasaporte: " + noPasaporte + " " +
            "Nombre de la moneda: " + moneda + " " +
            "Estado de Cuenta: "+ estadoCuenta + " " +
            "Saldo de la cuenta: " + saldo;
    }
    
    public String notFound(){
    return  "No. cuenta: " + null + " " +
            "Tipo de cuenta: " + notFound + " " +
            "Nombre completo: " + null + " " +
            "Numero de DPI: " + null + " " +
            "Numero de pasaporte: " + null + " " +
            "Nombre de la moneda: " + null + " " +
            "Estado de Cuenta: " + null + " " +
            "Saldo de la cuenta: " + null;
    }
}
