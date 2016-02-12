
import Entity.Hospital;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
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
public class AddDMBean {

    /* Data Base */
    Connection connexion;
    Statement statement;
    ResultSet resultSet;
    
    /* Infos */
    private String lastUpdate;
    private String lastRead;

    /* Patient */
    private String nom;
    private String prenom;
    private String sexe;
    private String adresse;
    private String telephone;
    private String dateBorn;

    /* Medecin */
    private String nomMed;
    private String prenomMed;

    /* Service */
    private String nomService;
    private String descriptionService;
    
    /* Hopital */
    private HashMap<Integer,Hospital> mapHospital = new HashMap<>();

    public HashMap<Integer,Hospital> getMapHospital(){
        return mapHospital;
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
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * @param prenom the prenom to set
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * @return the sexe
     */
    public String getSexe() {
        return sexe;
    }

    /**
     * @param sexe the sexe to set
     */
    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    /**
     * @return the adresse
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     * @param adresse the adresse to set
     */
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    /**
     * @return the telephone
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * @param telephone the telephone to set
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * @return the dateBorn
     */
    public String getDateBorn() {
        return dateBorn;
    }

    /**
     * @param dateBorn the dateBorn to set
     */
    public void setDateBorn(String dateBorn) {
        this.dateBorn = dateBorn;
    }

    /**
     * @return the nomMed
     */
    public String getNomMed() {
        return nomMed;
    }

    /**
     * @param nomMed the nomMed to set
     */
    public void setNomMed(String nomMed) {
        this.nomMed = nomMed;
    }

    /**
     * @return the prenomMed
     */
    public String getPrenomMed() {
        return prenomMed;
    }

    /**
     * @param prenomMed the prenomMed to set
     */
    public void setPrenomMed(String prenomMed) {
        this.prenomMed = prenomMed;
    }

    /**
     * @return the nomService
     */
    public String getNomService() {
        return nomService;
    }

    /**
     * @param nomService the nomService to set
     */
    public void setNomService(String nomService) {
        this.nomService = nomService;
    }

    /**
     * @return the descriptionService
     */
    public String getDescriptionService() {
        return descriptionService;
    }

    /**
     * @param descriptionService the descriptionService to set
     */
    public void setDescriptionService(String descriptionService) {
        this.descriptionService = descriptionService;
    }
    
    /**
     * 
     */
    public void initHopital(){
        String request = "SELECT O.id_org,O.nom,O.description FROM organisation as O,hopital as H WHERE O.id_org=H.id_org";

        try {
            connexion = DBConnect.getConnection();
            statement = connexion.createStatement();
            resultSet = statement.executeQuery(request);
                       
            while (resultSet.next()) {
                if(!mapHospital.containsKey(resultSet.getInt(1)))
                {
                    mapHospital.put(resultSet.getInt(1), new Hospital(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3)));
                }
            }

        } catch (Exception e) {
            System.err.println("Error getAllHopital " + request);
            throw new FacesException(e);
        }
    }
}
