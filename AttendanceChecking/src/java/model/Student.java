/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


/**
 *
 * @author pluso
 */
public class Student {
    private String id;
    private String name;
    private ClassGroup cg;

    public Student() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ClassGroup getCg() {
        return cg;
    }

    public void setCg(ClassGroup cg) {
        this.cg = cg;
    }
    
    
}
