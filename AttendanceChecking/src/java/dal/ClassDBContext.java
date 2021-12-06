/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ClassGroup;

/**
 *
 * @author pluso
 */
public class ClassDBContext extends DBContext{
    public ArrayList<ClassGroup> getAll()
    {
        ArrayList<ClassGroup> cgs = new ArrayList<>();
        try {
            String sql = "select classID,className from Class";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while(rs.next())
            {
                ClassGroup cg = new ClassGroup();
                cg.setId(rs.getInt("classID"));
                cg.setName(rs.getString("className"));
                cgs.add(cg);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ClassDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cgs;
    }
}
