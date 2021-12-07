/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.report;

import dal.AttendanceDBContext;
import dal.StudentDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Attendance;
import model.ClassTime;
import model.Student;

/**
 *
 * @author pluso
 */
public class AttendanceCheckingController extends HttpServlet {

    StudentDBContext sdb = new StudentDBContext();
    AttendanceDBContext adb = new AttendanceDBContext();

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int classID = Integer.parseInt(request.getParameter("classID"));
        Date studyDate = Date.valueOf(request.getParameter("date"));
        int slotID = Integer.parseInt(request.getParameter("slot"));
        ArrayList<Student> students = (ArrayList<Student>) sdb.getAllStudentsByClass(classID);
        ArrayList<Attendance> ats = (ArrayList<Attendance>) adb.getAllAttendanceRecordByClassDate(studyDate, slotID, classID);
        request.setAttribute("students", students);
        request.setAttribute("date", studyDate);
        request.setAttribute("slotID", slotID);
        request.setAttribute("attendances", ats);
        request.getRequestDispatcher("../view/students/viewClass.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        boolean isExisted = Boolean.valueOf(request.getParameter("exists"));
        String[] ids = request.getParameterValues("id");
        if (!isExisted) {          
            ArrayList<Attendance> atts = new ArrayList<>();
            for (String id : ids) {
                Attendance at = new Attendance();
                Student s = new Student();
                s.setId(id);
                at.setStudent(s);
                at.setDate(Date.valueOf(request.getParameter("date")));
                at.setSlotID(Integer.parseInt(request.getParameter("slotID")));
                at.setPresent(request.getParameter("present" + id) != null);
                atts.add(at);
            }
            adb.insert(atts);
        }else{
            ArrayList<Attendance> atts = new ArrayList<>();
            for (String id : ids) {
                Attendance at = new Attendance();
                Student s = new Student();
                at.setId(Integer.parseInt(id));
                at.setPresent(request.getParameter("present" + id) != null);
                atts.add(at);
            }
            adb.update(atts);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
