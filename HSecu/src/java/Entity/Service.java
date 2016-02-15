/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author jpertus
 */
public class Service {
    private int id;
    private String name;
    private int id_pole;

    public Service(int id, String name, int id_pole) {
        this.id = id;
        this.name = name;
        this.id_pole = id_pole;
    }
    
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
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the id_pole
     */
    public int getId_pole() {
        return id_pole;
    }

    /**
     * @param id_pole the id_pole to set
     */
    public void setId_pole(int id_pole) {
        this.id_pole = id_pole;
    }
        
}
