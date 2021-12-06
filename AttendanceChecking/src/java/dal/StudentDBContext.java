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
import model.Student;

/**
 *
 * @author pluso
 */
public class StudentDBContext extends DBContext{
    public ArrayList<Student> getAllStudentsByClass()
    {
        ArrayList<Student> students = new ArrayList<>();
        try {
            String sql = "select c.classID,c.className,s.studentID,s.studentName from Student s inner join Class c on s.classID=c.classID";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while(rs.next())
            {
                Student s = new Student();
                s.setId(rs.getString("studentID"));
                s.setName(rs.getString("studentName"));
                ClassGroup cg=new ClassGroup();
                cg.setId(rs.getInt("classID"));
                cg.setName(rs.getString("className"));
                s.setCg(cg);
                students.add(s);
            }
            return students;
        } catch (SQLException ex) {
            Logger.getLogger(ClassDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
