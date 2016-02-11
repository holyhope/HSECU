
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.faces.FacesException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vatsana
 */
public class FindDMBean {
    
    Connection connexion;
    Statement statement;
    ResultSet resultSet;
    
    private int id;
    private String lastUpdate;
    private String lastRead;
    private int id_org;
    private int id_patient;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the lastUpdate
     */
    public String getLastUpdate() {
        return lastUpdate;
    }

    /**
     * @param lastUpdate the lastUpdate to set
     */
    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    /**
     * @return the lastRead
     */
    public String getLastRead() {
        return lastRead;
    }

    /**
     * @param lastRead the lastRead to set
     */
    public void setLastRead(String lastRead) {
        this.lastRead = lastRead;
    }

    /**
     * @return the id_org
     */
    public int getId_org() {
        return id_org;
    }

    /**
     * @param id_org the id_org to set
     */
    public void setId_org(int id_org) {
        this.id_org = id_org;
    }

    /**
     * @return the id_patient
     */
    public int getId_patient() {
        return id_patient;
    }

    /**
     * @param id_patient the id_patient to set
     */
    public void setId_patient(int id_patient) {
        this.id_patient = id_patient;
    }
    
    public void getAllDossier(){
         String request = "SELECT * FROM dossierMedicale";

        try {
            connexion = DBConnect.getConnection();
            statement = connexion.createStatement();
            resultSet = statement.executeQuery(request);
                       
            while (resultSet.next()) {
                //TODO Recuperer les informations
            }

        } catch (Exception e) {
            System.err.println("Error getAllDossier " + request);
            throw new FacesException(e);
        }
    }
}
