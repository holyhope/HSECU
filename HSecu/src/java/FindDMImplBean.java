/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.FacesException;
import java.sql.Date;
import java.util.Map;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;


/**
 *
 * @author HP
 */

@ManagedBean(name = "findDMImplBean")
@ApplicationScoped
public class FindDMImplBean implements FindDM {

    private int idUser;
    Connection connexion;
    Statement statement;
    ResultSet resultSet;
    String SQL;
    ArrayList<MedicalRecord> medicalRecords = new ArrayList<>();

    public ArrayList<MedicalRecord> getMedicalRecords() {
        return medicalRecords;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
    
    @Override
    public MedicalRecord findDMById(long id) {
        MedicalRecord DM = new MedicalRecord();
        
       

        String request = "SELECT d.id_dm, p.nom,p.prenom FROM dossierMedicale d,patient p WHERE p.id_patient = d.id_patient and d.id_dm=" + id;

        try {
            connexion = DBConnect.getConnection();
            statement = connexion.createStatement();

            System.out.println("connected!!!!");
            resultSet = statement.executeQuery(request);

            while (resultSet.next()) {
                DM = new MedicalRecord(
                        resultSet.getInt("id_dm"),
                        resultSet.getString("nom_patient"),
                        resultSet.getString("prenom_patient")
                );
            }

        } catch (Exception e) {
            System.err.println("Error getAllDossier " + request);
            throw new FacesException(e);
        }
        return DM;
    }

  

    public void setUserId(String id) {
        this.idUser = Integer.parseInt(id);
    }
    @Override
    public void findDMAll(String idU) {
        
        try {
            connexion = DBConnect.getConnection();
            
            System.out.println("******");
            System.out.println(idU);
            System.out.println("******");
            System.out.println("connected!!!!");
            String request = "SELECT d.id_dm, p.nom_patient,p.prenom_patient FROM dossierMedicale d,roleUtilisateur r,patient p WHERE p.id_patient = d.id_patient and r.IdService = d.idService and r.id_user = "+idU.substring(idU.indexOf("[") + 1, idU.indexOf("]"));
            System.out.println("1111");
            System.out.println(request);
            
            statement = connexion.createStatement();
            System.out.println("22112211");
            resultSet = statement.executeQuery(request);
            System.out.println("2222");
            medicalRecords.clear();
            while (resultSet.next()) {
                int id = resultSet.getInt("id_dm");
                String patientName = resultSet.getString("nom_patient");
                String patientFirstname = resultSet.getString("prenom_patient");
               
                MedicalRecord MD = new MedicalRecord(id,patientName,patientFirstname);
                medicalRecords.add(MD);
                System.out.println("3333" + medicalRecords);
            }
        } catch (SQLException ex) {
            System.err.println("Error in findDMAll " + ex.getMessage());
        }
     
    }

}
