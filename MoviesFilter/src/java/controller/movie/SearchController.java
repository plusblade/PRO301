/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.movie;

import dal.ActorDBContext;
import dal.CategoryDBContext;
import dal.MovieDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Actor;
import model.Category;
import model.Movie;

/**
 *
 * @author pluso
 */
public class SearchController extends HttpServlet {
    CategoryDBContext cdb=new CategoryDBContext();
    ActorDBContext adb=new ActorDBContext();
    MovieDBContext mdb=new MovieDBContext();

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
        ArrayList<Category> categories=cdb.getAllCategory();
        ArrayList<Actor> actors=adb.getAllActor();
        request.setAttribute("categories", categories);
        request.setAttribute("actors", actors);
        request.getRequestDispatcher("../view/search.jsp").forward(request, response);
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
        ArrayList<Category> categoriesList=cdb.getAllCategory();
        ArrayList<Actor> actorsList=adb.getAllActor();
        request.setAttribute("categories", categoriesList);
        request.setAttribute("actors", actorsList);
        String [] aid=request.getParameterValues("aid");
        String [] cid=request.getParameterValues("cid");
        ArrayList<Actor>actors =new ArrayList<>();
        ArrayList<Category>categories =new ArrayList<>();
        for(String a:aid){
           if(request.getParameter("actor"+a)!=null){
               Actor actor =new Actor();
               actor.setAid(Integer.parseInt(a));
               actors.add(actor);
           }
        }
        for(String c:cid){
           if(request.getParameter("category"+c)!=null){
               Category cate =new Category();
               cate.setCid(Integer.parseInt(c));
               categories.add(cate);
           }
        }
        ArrayList<Movie> movies=mdb.getMovieByActorsAndCategories(actors, categories);
        request.setAttribute("movies", movies);
        request.getRequestDispatcher("../view/search.jsp").forward(request, response);
        
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
