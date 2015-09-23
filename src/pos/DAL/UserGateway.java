/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos.DAL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import pointofsale.MainSale;

/**
 *
 * @author Md Mamin
 */
public class UserGateway extends DBconn{
    
       public boolean getUserName(String userName, String ps) {
        String qr = "SELECT * FROM `user` WHERE user_name=\"" + userName + "\"";
        getConnection();
        ResultSet rs = getResultSet(qr);
        boolean result = false;
        try {
            while (rs.next()) {
                if (ps.equals(rs.getString("password"))) {
                  //  System.out.println(rs.getString("password"));
                    result = true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainSale.class.getName()).log(Level.SEVERE, null, ex);
        }
        closeConnection();
        return result;
    }
}
