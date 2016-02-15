
import java.io.IOException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
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
@SessionScoped
public class LoginBean {
    private String login;
    private int idUser;
    private String password;
    private String dbuserName;
    private Boolean connected = false;
  
    private String error;
    
    private String dbpassword;
    Connection connection;
    Statement statement;
    ResultSet resultSet;
    String SQL;

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    
    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
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
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/HSecu","root","root");
            statement = connection.createStatement();
            SQL = "SELECT `id_user`,`login`,`motdepasse` from utilisateur WHERE login = '"+userName+"'";
            System.out.println(SQL);
            resultSet = statement.executeQuery(SQL);
            resultSet.next();
            idUser = resultSet.getInt(1);
            dbuserName = resultSet.getString(2);
            dbpassword = resultSet.getString(3);
            System.out.println("------------"+dbuserName);
            System.out.println(idUser + " " + dbuserName +" "+dbpassword);
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
