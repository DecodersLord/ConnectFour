/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectfour;

/**
 *
 * @author Priyank Sevak
 */
public class Player {
    private String name;
    private State choice;

    public String getName() {
        return name;
    }

    public State getChoice() {
        return choice;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setChoice(State choice) {
        this.choice = choice;
    }
    
}
