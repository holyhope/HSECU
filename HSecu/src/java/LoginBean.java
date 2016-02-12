
import java.io.IOException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Peroumalle
 */
@ManagedBean(name = "loginBean")
@ApplicationScoped
public class LoginBean {
    private String login;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
    private String password;
    private String dbuserName;
    private Boolean connected = false;
  
    private String error;
    
    private String dbpassword;
    Connection connection;
    Statement statement;
    ResultSet resultSet;
    String SQL;
     
  
    public String getLogin() {
        return login;
    }
 
    public void setLogin(String login) {
        this.login = login;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
 
    public String getDbuserName() {
        return dbuserName;
    }
 
    public void setDbuserName(String dbuserName) {
        this.dbuserName = dbuserName;
    }
 
    public String getDbpassword() {
        return dbpassword;
    }
 
    public void setDbpassword(String dbpassword) {
        this.dbpassword = dbpassword;
    }
 
    public void dbData(String userName)
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            //connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/HSecu","root","root");
            connection = DriverManager.getConnection("jdbc:mysql://sqletud.univ-mlv.fr/jpertus_db","jpertus","blabla21");
            statement = connection.createStatement();
            SQL = "SELECT `login`,`motdepasse` from utilisateur";
            resultSet = statement.executeQuery(SQL);
            resultSet.next();
            dbuserName = resultSet.getString(1);
            dbpassword = resultSet.getString(2);
            System.out.println("------------"+dbuserName);
        }
        catch(Exception ex)
        {
            error ="Identifiant ou mot de passe éronné";
            ex.printStackTrace();
            System.out.println("Exception Occured in the process :" + ex);
        }
    }
     
    public String checkValidUser()
    {
        dbData(login);
  
        if(login.equalsIgnoreCase(dbuserName))
        {
            
            if(password.equals(dbpassword)){
                connected = true;
                return "success";
            }
            else
            {
                return "failure";
            }
        }
        else
        {
            
            return "failure";
        }
    }
    
    public String testUserConnected() throws IOException{
        if(!connected){
            return "failure";
        }
        return "success";
    }
}
