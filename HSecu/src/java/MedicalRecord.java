/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author HP
 */
public class MedicalRecord {
        private long id_dm;
        private String patientName;
        private String patientFirstname;
       
    

    public MedicalRecord(long id_dm, String patientName,String patientFirstname) {
        this.id_dm = id_dm;
        this.patientName = patientName;
        this.patientFirstname = patientFirstname;
      
    }

    public MedicalRecord() {
    }

    public String show() {
        return "MedicalRecordImpl{" + "id_dm=" + id_dm + ", patientname=" + patientName + ", patientFirstname=" + patientFirstname;
    }

    public long getId_dm() {
        return id_dm;
    }

    public void setId_dm(long id_dm) {
        this.id_dm = id_dm;
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

   

  
}
