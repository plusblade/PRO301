/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Attendance;
import model.ClassGroup;
import model.Student;

/**
 *
 * @author pluso
 */
public class AttendanceDBContext extends DBContext {

    public ArrayList<Attendance> getAllAttendanceRecordByClassDate(Date date,int slotID, int classID) {
        ArrayList<Attendance> ats = new ArrayList<>();
        try {
            String sql = "select a.attendanceID,a.present,s.studentID,s.studentName from Attendance a inner join Student s on a.studentID=s.studentID\n"
                    + "where s.classID=? and a.date=? and a.slotID=?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, classID);
            stm.setDate(2, date);
            stm.setInt(3, slotID);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
               Attendance at=new Attendance();
               at.setId(rs.getInt("attendanceID"));
               Student s=new Student();
               s.setId(rs.getString("studentID"));
               s.setName(rs.getString("studentName"));
               at.setStudent(s);
               at.setPresent(rs.getBoolean("present"));
               ats.add(at);
            }
            return ats;
        } catch (SQLException ex) {
            Logger.getLogger(ClassDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void insert(ArrayList<Attendance> atts) {
        try {
            connection.setAutoCommit(false);
            String sql = "INSERT INTO [Attendance]\n"
                    + "           ([studentID]\n"
                    + "           ,[date]\n"
                    + "           ,[slotID]\n"
                    + "           ,[present])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?)";
            for (Attendance att : atts) {
                PreparedStatement stm = connection.prepareStatement(sql);
                stm.setString(1, att.getStudent().getId());
                stm.setDate(2, att.getDate());
                stm.setInt(3,att.getSlotID());
                stm.setBoolean(4, att.isPresent());
                stm.executeUpdate();
            }
            connection.commit();
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceDBContext.class.getName()).log(Level.SEVERE, null, ex);
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(AttendanceDBContext.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        finally
        {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(AttendanceDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
    
    public void update(ArrayList<Attendance> atts) {
        try {
            connection.setAutoCommit(false);
            String sql = "UPDATE [Attendance]\n" +
                        "   SET [present] = ?\n" +
                        " WHERE [attendanceID] = ?";
            for (Attendance att : atts) {
                PreparedStatement stm = connection.prepareStatement(sql);
                stm.setInt(2,att.getId());
                stm.setBoolean(1, att.isPresent());
                stm.executeUpdate();
            }
            connection.commit();
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceDBContext.class.getName()).log(Level.SEVERE, null, ex);
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(AttendanceDBContext.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        finally
        {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(AttendanceDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
