/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mourougan
 */


import Entity.Hospital;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.faces.FacesException;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="consultBean")
@RequestScoped
public class ConsultBean {
    
    /* Data Base */
    Connection connexion;
    Statement statement;
    ResultSet resultSet;
    
    @ManagedProperty(value="#{param.id}")
    private String id;
    private String lastUpdate;
    private String lastRead;
    
    private String patientName;
    private String patientFirstname;
    private String patientSexe;
    private String patientService;
    private String patientAdress;
    private String patientTelephone;
    private String patientBirthdate;
    private String patientEmail;
    
    private String doctorName;
    private String doctorFirstname;
    
    private String serviceHospital;
    private String servicePole;
    private String serviceService;
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getLastRead() {
        return lastRead;
    }

    public void setLastRead(String lastRead) {
        this.lastRead = lastRead;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientFirstname() {
        return patientFirstname;
    }

    public void setPatientFirstname(String patientFirstname) {
        this.patientFirstname = patientFirstname;
    }

    public String getPatientService() {
        return patientService;
    }

    public void setPatientService(String patientService) {
        this.patientService = patientService;
    }

    public String getPatientAdress() {
        return patientAdress;
    }

    public void setPatientAdress(String patientAdress) {
        this.patientAdress = patientAdress;
    }

    public String getPatientTelephone() {
        return patientTelephone;
    }

    public void setPatientTelephone(String patientTelephone) {
        this.patientTelephone = patientTelephone;
    }

    public String getPatientBirthdate() {
        return patientBirthdate;
    }

    public void setPatientBirthdate(String patientBirthdate) {
        this.patientBirthdate = patientBirthdate;
    }

    public String getPatientEmail() {
        return patientEmail;
    }

    public void setPatientEmail(String patientEmail) {
        this.patientEmail = patientEmail;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorFirstname() {
        return doctorFirstname;
    }

    public void setDoctorFirstname(String doctorFirstname) {
        this.doctorFirstname = doctorFirstname;
    }

    public String getServiceHospital() {
        return serviceHospital;
    }

    public void setServiceHospital(String serviceHospital) {
        this.serviceHospital = serviceHospital;
    }

    public String getServicePole() {
        return servicePole;
    }

    public void setServicePole(String servicePole) {
        this.servicePole = servicePole;
    }

    public String getServiceService() {
        return serviceService;
    }

    public void setServiceService(String serviceService) {
        this.serviceService = serviceService;
    }

    public String getPatientSexe() {
        return patientSexe;
    }

    public void setPatientSexe(String patientSexe) {
        this.patientSexe = patientSexe;
    }
    
    public void initConsult() throws SQLException{
        String request = "";
        try {
            connexion = DBConnect.getConnection();
            statement = connexion.createStatement();
            request = "SELECT * FROM dossierMedicale WHERE id_dm = "+ id;
            resultSet = statement.executeQuery(request);
            String idService =""  ,idPatient ="";        
            while (resultSet.next()) {
                lastUpdate = resultSet.getTimestamp(2).toString();
                lastRead = resultSet.getTimestamp(3).toString();
                
                idService = Integer.toString(resultSet.getInt(4));
                idPatient = Integer.toString(resultSet.getInt(5));
                
            }
            if(idService.equals("")|| idPatient.equals("")) {
                return;
            }
            
            request = "SELECT * FROM patient WHERE id_patient = "+ idPatient;
            resultSet = statement.executeQuery(request);
                 
            while (resultSet.next()) {
                patientName = resultSet.getString(2);
                patientFirstname = resultSet.getString(3);
                patientSexe = resultSet.getString(4);
                patientAdress = resultSet.getString(5);
                patientTelephone = Integer.toString(resultSet.getInt(6));
                patientBirthdate = resultSet.getDate(7).toString();
                patientEmail = resultSet.getString(8);
                
            }
            
            request = "SELECT nomHopital,nomPole,nomService FROM hopital h,pole p,service s WHERE s.idPole = p.idPole AND p.id_hopital = h.id_hopital AND s.idService = "+idService;
            resultSet = statement.executeQuery(request);
                 
            while (resultSet.next()) {
                patientService = resultSet.getString(3);
                serviceService = resultSet.getString(3);
                serviceHospital = resultSet.getString(1);
                servicePole = resultSet.getString(2);
            }
            
            request = "SELECT * FROM medecin m,medecinTraitant mT WHERE m.id_medecin = mT.id_medecin AND mT.id_dm = "+id;
            resultSet = statement.executeQuery(request);
                 
            while (resultSet.next()) {
                doctorName = resultSet.getString(2);
                doctorFirstname = resultSet.getString(3);
               
            }
            
        } catch (Exception e) {
            System.err.println("Error getAllHopital " + request);
            throw new FacesException(e);
        }
    }
}