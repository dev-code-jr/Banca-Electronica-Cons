package org.chamale.chanquin.model;
/**
 *
 * @author Edwar René Chamalé González - 2022222
 * @author Jose Rodrigo Chanquín Mac - 2022240
 * 
 */
public class TipoCuentas {
    private int idTipoCuenta;
    private String nombreCuenta;
    //
    private int idTCuenta;
    private String nameCuenta;
    private String notFound;
   
    public TipoCuentas() {
    }
    
    public TipoCuentas(int idTipoCuenta, String nombreCuenta) {
        this.idTipoCuenta = idTipoCuenta;
        this.nombreCuenta = nombreCuenta;
    }

    public int getIdTipoCuenta() {
        return idTipoCuenta;
    }

    public void setIdTipoCuenta(int idTipoCuenta) {
        this.idTipoCuenta = idTipoCuenta;
    }

    public String getNombreCuenta() {
        return nombreCuenta;
    }

    public void setNombreCuenta(String nombreCuenta) {
        this.nombreCuenta = nombreCuenta;
    }

    public int getIdTCuenta() {
        return idTCuenta;
    }

    public void setIdTCuenta(int idTCuenta) {
        this.idTCuenta = idTCuenta;
    }

    public String getNameCuenta() {
        return nameCuenta;
    }

    public void setNameCuenta(String nameCuenta) {
        this.nameCuenta = nameCuenta;
    }

    public String getNotFound() {
        return notFound;
    }

    public void setNotFound(String notFound) {
        this.notFound = notFound;
    }
    
    public String vistaTipoCuentas(){
        return " Id tipo cuenta: "+ idTCuenta +
                " Nombre del tipo de cuenta: "+ nameCuenta;
    }
    
    public String notFound(){
        return " Id tipo cuenta: "+ null + " " +
               " Nombre del tipo de cuenta: "+ notFound;
    }
}
