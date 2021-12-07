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
import model.ClassTime;

/**
 *
 * @author pluso
 */
public class ClassTimeDBContext extends DBContext{
    public ArrayList<ClassTime> getAllTime()
    {
        ArrayList<ClassTime> cts = new ArrayList<>();
        try {
            String sql = "select slotID,startTime from SlotTime";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while(rs.next())
            {
                ClassTime ct=new ClassTime();
                ct.setTime(rs.getTime("startTime"));
                ct.setSlotID(rs.getInt("slotID"));
                cts.add(ct);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ClassTimeDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cts;
    }
}
