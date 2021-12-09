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
import model.Actor;
import model.Category;

/**
 *
 * @author pluso
 */
public class ActorDBContext extends DBContext{
    public ArrayList<Actor> getAllActor(){       
        try {
            ArrayList<Actor> actors=new ArrayList<>();
            String sql = "Select name,aid from Actor";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while(rs.next())
            {
                Actor a=new Actor();
                a.setAid(rs.getInt("aid"));
                a.setName(rs.getString("name"));
                actors.add(a);
                
            }
            return actors;
        } catch (SQLException ex) {
            Logger.getLogger(ActorDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
