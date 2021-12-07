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
import model.Attendance;
import model.Student;

/**
 *
 * @author pluso
 */
public class AttendanceDBContext extends DBContext{
        public ArrayList<Attendance> getAllAttendances()
    {    
        try {
            ArrayList<Attendance> ats= new ArrayList<>();
            String sql = "select s.sid,s.sname,a.date from Student s inner join Attendance a on s.sid=a.sid  ";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while(rs.next())
            {
                Attendance a =new Attendance();
                a.setAid(rs.getInt("aid"));
                a.setAtd(rs.getDate("date"));
                Student s=new Student();
                s.setId(rs.getInt("sid"));
                s.setName(rs.getString("name"));
                a.setS(s);
                ats.add(a);
                
            }
            return ats;
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
        
        public void update(Attendance a)
    {
        try {
            String sql = "UPDATE [Attendance]\n" +
                        "   SET [present] = ?\n" +
                        " WHERE [aid] = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setBoolean(1, a.isPresent());
            stm.setInt(2, a.getAid());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
