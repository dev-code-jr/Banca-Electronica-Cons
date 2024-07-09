package org.chamale.chanquin.model;
/**
 *
 * @author Edwar René Chamalé González - 2022222
 * @author Jose Rodrigo Chanquín Mac - 2022240
 * 
 */
public class Servicios {
    private int idServicio;
    private String nombreServicio;
    private String descripcionS;
    private String nameServicio;
    private String descripcionServicio;
    private String notFound;
    
    public Servicios (){
    }

    public Servicios(String nameServicio, String descripcionServicio) {
        this.nameServicio = nameServicio;
        this.descripcionServicio = descripcionServicio;
    }
    
    public Servicios(int idServicio, String nombreServicio, String descripcionS) {
        this.idServicio = idServicio;
        this.nombreServicio = nombreServicio;
        this.descripcionS = descripcionS;
    }
    
    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setNombreServicio(String nombreSerivicio) {
        this.nombreServicio = nombreSerivicio;
    }

    public String getDescripcionS() {
        return descripcionS;
    }

    public void setDescripcionS(String descripcionS) {
        this.descripcionS = descripcionS;
    }

    public String getNameServicio() {
        return nameServicio;
    }

    public void setNameServicio(String nameServicio) {
        this.nameServicio = nameServicio;
    }

    public String getDescripcionServicio() {
        return descripcionServicio;
    }

    public void setDescripcionServicio(String descripcionServicio) {
        this.descripcionServicio = descripcionServicio;
    }

    public String getNotFound() {
        return notFound;
    }

    public void setNotFound(String notFound) {
        this.notFound = notFound;
    }
    
    public String vistaServicios(){
        return "Id servicio: "+ idServicio + 
               "Nombre del servicio: "+ nombreServicio +
               "Descripción de servicio: "+ descripcionS;
    }
    
    public String notFound(){
        return "Id servicio: " + null + " " +
               "Nombre del servicio: "+ notFound + " " +
               "Descripción de servicio: "+ null;
    }
}
