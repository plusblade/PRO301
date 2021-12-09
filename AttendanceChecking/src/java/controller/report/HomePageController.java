/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.report;

import dal.AttendanceDBContext;
import dal.ClassDBContext;
import dal.ClassTimeDBContext;
import dal.StudentDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Account;
import model.Attendance;
import model.ClassGroup;
import model.ClassTime;
import model.Student;

/**
 *
 * @author pluso
 */
public class HomePageController extends HttpServlet {

    ClassDBContext cdb = new ClassDBContext();
    ClassTimeDBContext ctdb = new ClassTimeDBContext();
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
        Account account = (Account) request.getSession().getAttribute("account");
        if (account != null) {
            if (account.getRole() == 0) {
                List<ClassGroup> classes = cdb.getAllClassByLecturerID(account.getUsername());
                List<ClassTime> times = ctdb.getAllTime();
                request.setAttribute("classes", classes);
                request.setAttribute("times", times);
                request.getRequestDispatcher("view/home/homepage.jsp").forward(request, response);
            } else {
                String studentID = account.getUsername();
                ArrayList<Attendance> ats = adb.getAllAttendanceRecordByUsername(studentID);
                request.setAttribute("attendances", ats);
                request.getRequestDispatcher("view/students/viewAttendance.jsp").forward(request, response);
            }
        } else {
            response.getWriter().println("Access denied");
            response.sendRedirect("login");
        }
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
        int classID = Integer.parseInt(request.getParameter("class"));
        Date studyDate = Date.valueOf(request.getParameter("date"));
        int slotID = Integer.parseInt(request.getParameter("slotID"));
        response.sendRedirect("checking/attendance?classID=" + classID + "&date=" + studyDate + "&slot=" + slotID);
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
