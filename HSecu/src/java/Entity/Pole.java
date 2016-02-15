/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jpertus
 */
public class Pole {
    private int id;
    private String name;
    private int id_hosto;
    private List<Service> listService = new ArrayList<>();

    public Pole(int id, String name, int id_hosto) {
        this.id = id;
        this.name = name;
        this.id_hosto = id_hosto;
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
     * @return the id_hosto
     */
    public int getId_hosto() {
        return id_hosto;
    }

    /**
     * @param id_hosto the id_hosto to set
     */
    public void setId_hosto(int id_hosto) {
        this.id_hosto = id_hosto;
    }

    /**
     * @return the listService
     */
    public List<Service> getListService() {
        return listService;
    }

    /**
     * @param listService the listService to set
     */
    public void setListService(List<Service> listService) {
        this.listService = listService;
    }
  
    
    
}
