/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author pluso
 */
public class Attendance {
    private int aid;
    private Date atd;
    private boolean present;
    private Student s;

    public Attendance() {
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public Date getAtd() {
        return atd;
    }

    public void setAtd(Date atd) {
        this.atd = atd;
    }

    public boolean isPresent() {
        return present;
    }

    public void setPresent(boolean present) {
        this.present = present;
    }

    public Student getS() {
        return s;
    }

    public void setS(Student s) {
        this.s = s;
    }
    
}
