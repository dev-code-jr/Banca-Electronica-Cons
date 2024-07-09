package org.chamale.chanquin.model;
/**
 *
 * @author Edwar René Chamalé González - 2022222
 * @author Jose Rodrigo Chanquín Mac - 2022240
 * 
 */
public class TipoMonedas {
    private int idTipoMoneda;
    private String nombreMoneda;
    private int idMoneda;
    private String nameMoneda;
    private String notFound;
    
    public TipoMonedas(){
    }
    
    public TipoMonedas(int idTipoMoneda, String nombreMoneda) {
        this.idTipoMoneda = idTipoMoneda;
        this.nombreMoneda = nombreMoneda;
    }

    public int getIdTipoMoneda() {
        return idTipoMoneda;
    }

    public void setIdTipoMoneda(int idTipoMoneda) {
        this.idTipoMoneda = idTipoMoneda;
    }

    public String getNombreMoneda() {
        return nombreMoneda;
    }

    public void setNombreMoneda(String nombreMoneda) {
        this.nombreMoneda = nombreMoneda;
    }

    public int getIdMoneda() {
        return idMoneda;
    }

    public void setIdMoneda(int idMoneda) {
        this.idMoneda = idMoneda;
    }

    public String getNameMoneda() {
        return nameMoneda;
    }

    public void setNameMoneda(String nameMoneda) {
        this.nameMoneda = nameMoneda;
    }
    
    public String getNotFound() {
        return notFound;
    }

    public void setNotFound(String notFound) {
        this.notFound = notFound;
    }
    
    public String vistaMonedas(){
        return "Id tipo moneda: " + idMoneda + " " +
               "Nombre de la moneda: " + nameMoneda;
    }

    public String notFound(){
        return "Id tipo moneda" + null + " " +
               "Nombre de la moneda" + notFound;
    }
}
