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
import model.Category;

/**
 *
 * @author pluso
 */
public class CategoryDBContext extends DBContext{
    
    public ArrayList<Category> getAllCategory(){
        
        try {
            ArrayList<Category> categories=new ArrayList<>();
            String sql = "Select name,cid from Category";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while(rs.next())
            {
                Category c=new Category();
                c.setCid(rs.getInt("cid"));
                c.setName(rs.getString("name"));
                categories.add(c);
            }
            return categories;
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
        
    
    
}
