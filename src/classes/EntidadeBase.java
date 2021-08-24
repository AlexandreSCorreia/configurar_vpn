/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author AlexandreSCorreia
 */
public abstract class EntidadeBase {
    
    private int Id;

    public int getId() {
        return Id;
    }

    protected void setId(int id) {
        this.Id = id;
    }
    
    
}
