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
import javax.swing.JOptionPane;
import pos.Model.InventoryProduct;

/**
 *
 * @author Md Mamin
 */
public class DBManager extends DBconn{

    //DBconn conn = new DBconn();

    public boolean saveBrand(String BarndName) {
        getConnection();
        String sa = "INSERT INTO`brand` (`id`, `brand_Name`) VALUES (NULL, '" + BarndName + "')";
        boolean rs = insertData(sa);
        closeConnection();
        return rs;
    }

    public void getAllCatagory() {
        getConnection();
        ResultSet rs = getResultSet("SELECT * FROM category");

        try {
            while (rs.next()) {

            }
        } catch (SQLException ex) {

        }
       closeConnection();
    }

//    public User getUser(String name, String password) {
//        conn.getConnection();
//        ResultSet rs = conn.getResultSet("SELECT * FROM user WHARE user_name=" + name + " AND password =" + password);
//
//        User anUser = null;
//        try {
//            while (rs.next()) {
//                ComboBoxLoader anCatagory = new ComboBoxLoader();
//                anCatagory.setCategory_id(rs.getInt("id"));
//                anCatagory.setCategory_name(rs.getString("name"));
//                anCatagory.setParent_id(rs.getInt("parent_id"));
//
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(MainSale.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        conn.closeConnection();
//        return anUser;
//    }
    public InventoryProduct getProduct(String qr) {
        getConnection();
        ResultSet rs = getResultSet(qr);

        InventoryProduct anProduct = null;
        try {
            while (rs.next()) {
                anProduct = new InventoryProduct();
                anProduct.setProductId(rs.getInt("Product_id"));
                anProduct.setProductName(rs.getString("product_name"));
                anProduct.setQuantity(rs.getInt("quantity"));
                anProduct.setPrice(rs.getInt("minimum_sale_price"));

            }
        } catch (SQLException ex) {

        }
        closeConnection();
        return anProduct;
    }

    void saveCategory(String qr) {
        getConnection();
        boolean rs = insertData(qr);
        closeConnection();
        System.out.println(qr);
        if (rs) {
            JOptionPane.showMessageDialog(null, "Saved");
        } else {
            JOptionPane.showMessageDialog(null, "Save Fail");
        }
    }

    public boolean inserOrDelete(String qr) {
        getConnection();
        boolean rs = insertData(qr);
        closeConnection();
        return rs;
    }

    public void getAllCategoryes() {
        getConnection();

        String qr = "SELECT * FROM `category`";
        ResultSet rs = getResultSet(qr);

        int i = 0;
        try {
            while (rs.next()) {

                rs.getInt("id");
                rs.getString("name");
                rs.getInt("parent_id");
            }
        } catch (SQLException ex) {

        }
        closeConnection();

    }

    boolean getUserName(String id, String ps) {
        String qr = "SELECT * FROM `user` WHERE user_name=\"" + id + "\"";
        getConnection();
        ResultSet rs = getResultSet(qr);
        boolean result = false;
        try {
            while (rs.next()) {
                if (ps.equals(rs.getString("password"))) {
                    System.out.println(rs.getString("password"));
                    result = true;
                }
            }
        } catch (SQLException ex) {

        }
        closeConnection();
        return result;
    }
}
