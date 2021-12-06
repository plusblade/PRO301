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
import model.Account;
import model.Request;

/**
 *
 * @author pluso
 */
public class RequestDBContext extends DBContext {

    public ArrayList<Request> getAllRequests(String username) {
        {
            try {
                String sql = "Select rid,tittle,username  from Request\n"
                        + "where username=?";
                PreparedStatement stm = connection.prepareStatement(sql);
                stm.setString(1, username);
                ResultSet rs = stm.executeQuery();
                ArrayList<Request>requests=new ArrayList<>();
                while (rs.next()) {
                    Request r=new Request();
                    r.setId(rs.getInt("rid"));
                    r.setUsername(rs.getString("username"));
                    r.setTittle(rs.getString("tittle"));
                    requests.add(r);
                }
                return requests;
            } catch (SQLException ex) {
                Logger.getLogger(RequestDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
        }
    }
}
