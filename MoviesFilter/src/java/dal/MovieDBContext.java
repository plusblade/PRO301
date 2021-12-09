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
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Actor;
import model.Category;
import model.Movie;

/**
 *
 * @author pluso
 */
public class MovieDBContext extends DBContext {

    public ArrayList<Movie> getMovieByActorsAndCategories(ArrayList<Actor> actors, ArrayList<Category> categories) {
        try {
            ArrayList<Movie> movies=new ArrayList<>();
            int index=0;
            HashMap<Integer,Integer> map=new HashMap<>();
            String sql = " Select DISTINCT m.mid,m.title from Movie m inner join Movie_Actor ma on m.mid=ma.mid inner join Movie_Category mc on m.mid=mc.mid where (1!=1)   ";
            for (Actor ac : actors) {
                  sql+=" or ma.aid=?";
                  index+=1;
                  map.put(index,ac.getAid());                  
            }
            for (Category cat : categories) {
                  sql+=" or mc.cid =?";
                  index+=1;
                  map.put(index,cat.getCid());        
            }
            PreparedStatement stm = connection.prepareStatement(sql);
            for ( Map.Entry<Integer, Integer> entry : map.entrySet()) {
                Integer key=entry.getKey();
                Integer value=entry.getValue();
                stm.setInt(key,value);               
            }
            
            ResultSet rs=stm.executeQuery();
            while(rs.next()){
                Movie m =new Movie();
                m.setMid(rs.getInt("mid"));
                m.setTittle(rs.getString("title"));
                movies.add(m);
            }
            return movies;
        } catch (SQLException ex) {
            Logger.getLogger(MovieDBContext.class.getName()).log(Level.SEVERE, null, ex);         
        }

    return null;
}
}
