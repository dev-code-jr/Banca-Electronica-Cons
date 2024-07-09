package org.chamale.chanquin.model;
/**
 *
 * @author Edwar René Chamalé González - 2022222
 * @author Jose Rodrigo Chanquín Mac - 2022240
 * 
 */
public class EmpresaTelefonicas {
    private int idEmpresaTelefonica;
    private String nombreEmpresaTelefonica;
    private int idEmpresa;
    private String nombreEmpresa;
    private String notFound;
    
    public EmpresaTelefonicas(){
    }
    
    public EmpresaTelefonicas(int idEmpresaTelefonica, String nombreEmpresaTelefonica) {
        this.idEmpresaTelefonica = idEmpresaTelefonica;
        this.nombreEmpresaTelefonica = nombreEmpresaTelefonica;
    }
    
    public int getIdEmpresaTelefonica() {
        return idEmpresaTelefonica;
    }

    public void setIdEmpresaTelefonica(int idEmpresaTelefonica) {
        this.idEmpresaTelefonica = idEmpresaTelefonica;
    }

    public String getNombreEmpresaTelefonica() {
        return nombreEmpresaTelefonica;
    }

    public void setNombreEmpresaTelefonica(String nombreEmpresaTelefonica) {
        this.nombreEmpresaTelefonica = nombreEmpresaTelefonica;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }
    
    public String getNotFound() {
        return notFound;
    }

    public void setNotFound(String notFound) {
        this.notFound = notFound;
    }
    
    public String vistaCompañias(){
        return "Id empresa telefonica: " + idEmpresa + " " +
               "Nombre de la empresa: " + nombreEmpresa;
    }

    public String notFound(){
    return "Id empresa telefonica: " + null + " " +
           "Nombre de la empresa: " + notFound;
    }
}
