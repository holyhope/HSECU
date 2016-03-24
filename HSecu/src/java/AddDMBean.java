
import Entity.Hospital;
import Entity.Pole;
import Entity.Service;
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
    private String email;

    /* Medecin */
    private String nomMed;
    private String prenomMed;

    /* Update in DB */
    private int idService;
    private int idPatient;
    private int idMedecin;
    private int idDossier;
    
    /* Service */
    private HashMap<Integer,Hospital> mapHospital = new HashMap<>();
    private HashMap<Integer,Pole> mapPole = new HashMap<>();
    private HashMap<Integer,Service> mapService = new HashMap<>();

    public HashMap<Integer,Hospital> getMapHospital(){
        return mapHospital;
    }
    public HashMap<Integer,Pole> getMapPole(){
        return mapPole;
    }
    public HashMap<Integer,Service> getMapService(){
        return mapService;
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
     * @return the emailPatient
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param emailPatient 
     */
    public void setEmail(String emailPatient) {
        this.email = emailPatient;
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
     * @return the idService
     */
    public int getIdService() {
        return idService;
    }

    /**
     * @param idService the idService to set
     */
    public void setIdService(int idService) {
        this.idService = idService;
    }
    
    /**
     * @return the idPatient
     */
    public int getIdPatient() {
        return idPatient;
    }

    /**
     * @param idPatient the idPatient to set
     */
    public void setIdPatient(int idPatient) {
        this.idPatient = idPatient;
    }
    
    
    /**
     * @return the idMedecin
     */
    public int getIdMedecin() {
        return idMedecin;
    }

    /**
     * @param idMedecin the idMedecin to set
     */
    public void setIdMedecin(int idMedecin) {
        this.idMedecin = idMedecin;
    }
    
    /**
     * @return the idDossier
     */
    public int getIdDossier() {
        return idDossier;
    }

    /**
     * @param idDossier the idDossier to set
     */
    public void setIdDossier(int idDossier) {
        this.idDossier = idDossier;
    }
    
    public void initHopital(){
        //String request = "SELECT O.id_org,O.nom,O.description FROM organisation as O,hopital as H WHERE O.id_org=H.id_org";
        String request = "SELECT * from hopital";
        try {
            connexion = DBConnect.getConnection();
            statement = connexion.createStatement();
            resultSet = statement.executeQuery(request);
                       
            while (resultSet.next()) {
                if(!mapHospital.containsKey(resultSet.getInt(1)))
                {
                    mapHospital.put(resultSet.getInt(1), new Hospital(resultSet.getInt(1),resultSet.getString(2)));
                }
            }

        } catch (Exception e) {
            System.err.println("Error getAllHopital " + request);
            throw new FacesException(e);
        }
    }
    public void initPole(){
        String request = "SELECT * from pole";
        try {
            connexion = DBConnect.getConnection();
            statement = connexion.createStatement();
            resultSet = statement.executeQuery(request);
                       
            while (resultSet.next()) {
                if((!mapPole.containsKey(resultSet.getInt(1)))&&(mapHospital.containsKey(resultSet.getInt(3))))
                {
                    Pole poleee = new Pole(resultSet.getInt(1),resultSet.getString(2),resultSet.getInt(3));
                    mapPole.put(resultSet.getInt(1),poleee);
                    Hospital hosppp = mapHospital.get(resultSet.getInt(3));
                    hosppp.getListPole().add(poleee);
                }
            }

        } catch (Exception e) {
            System.err.println("Error getAllHopital " + request);
            throw new FacesException(e); 
       }
    }
    public void initService(){
        String request = "SELECT * from service";
        try {
            connexion = DBConnect.getConnection();
            statement = connexion.createStatement();
            resultSet = statement.executeQuery(request);
                       
            while (resultSet.next()) {
                if  ((!mapService.containsKey(resultSet.getInt(1))) && (mapPole.containsKey(resultSet.getInt(3))))
                {
                    Pole polee = mapPole.get(resultSet.getInt(3));
                    Service serviceee = new Service(resultSet.getInt(1),resultSet.getString(2),resultSet.getInt(3));
                    polee.getListService().add(serviceee);
                    mapService.put(resultSet.getInt(1),serviceee);
                }
            }

        } catch (Exception e) {
            System.err.println("Error getAllHopital " + request);
            throw new FacesException(e);
        }
    }
    
    public void insertDM()
    {
         insertpatient();
         //insertdossier();
         //insertmedecin();
    }
       
    public void insertpatient()
    {
        String request = "INSERT INTO 'patient' ('id_patient', 'nom_patient', 'prenom_patient', 'sexe_patient', 'adresse_patient', 'telephone', 'date_naissance', 'email') VALUES (NULL,'"+
                nom+"','"+prenom+"','"+sexe+"','"+adresse+"',"+telephone+",'"+dateBorn+"','"+email+"')";

        System.out.println(request);
        try 
        {
            connexion = DBConnect.getConnection();
            statement = connexion.createStatement();
            statement.executeUpdate(request, Statement.RETURN_GENERATED_KEYS);
            resultSet = statement.getGeneratedKeys();
                       
            if (resultSet.next()) 
            {
                idPatient = resultSet.getInt(1);
            }
        } 
        catch (Exception e) 
        {
            System.err.println("Error getPatient " + request);
        }
        System.out.println(idPatient);
    }
    public void insertdossier()
    {
        String request = "INSERT INTO 'dossiermedicale' ('id_dm', 'lastUpdate', 'lastRead', 'idService', 'id_patient') VALUES (NULL,NULL,NULL,"+
                idService+","+idPatient+")";

        System.out.println(request);
        try 
        {
            connexion = DBConnect.getConnection();
            statement = connexion.createStatement();
            statement.executeUpdate(request, Statement.RETURN_GENERATED_KEYS);
            resultSet = statement.getGeneratedKeys();
                       
            if (resultSet.next()) 
            {
                idDossier = resultSet.getInt(1);
            }
        } 
        catch (Exception e) 
        {
            System.err.println("Error getDossier " + request);
        }
        System.out.println(idDossier);
    }
    public void insertmedecin()
    {
        String request = "INSERT INTO 'medecin' ('id_medecin', 'nom', 'prenom') VALUES (NULL,'"+
                nomMed+"','"+prenomMed+"')";

        System.out.println(request);
        try 
        {
            connexion = DBConnect.getConnection();
            statement = connexion.createStatement();
            statement.executeUpdate(request, Statement.RETURN_GENERATED_KEYS);
            resultSet = statement.getGeneratedKeys();
                       
            if (resultSet.next()) 
            {
                idMedecin = resultSet.getInt(1);
            }
        } 
        catch (Exception e) 
        {
            System.err.println("Error getMedecin " + request);
        }
        System.out.println(idMedecin);
    }
}
