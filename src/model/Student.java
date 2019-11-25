/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 * Classe représentant un POJO étudiant.
 * @author Nathan Salez
 */
public class Student {
    
    private int id;
    
    private String name;
    
    private String firstName;

    public Student(int id, String name, String firstName) {
        this.id = id;
        this.name = name;
        this.firstName = firstName;
    }
    
    public Student(String name, String firstName) {
        this.name = name;
        this.firstName = firstName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
