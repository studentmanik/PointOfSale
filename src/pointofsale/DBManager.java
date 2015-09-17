/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointofsale;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Md Mamin
 */
public class DBManager {

    DBconn conn = new DBconn();

    public boolean saveBrand(String BarndName) {
        conn.getConnection();
        String sa = "INSERT INTO`brand` (`id`, `brand_Name`) VALUES (NULL, '" + BarndName + "')";
        boolean rs = conn.insertData(sa);
        conn.closeConnection();
        return rs;
    }

    public void getAllCatagory(JComboBox cbCategory) {
        conn.getConnection();
        ResultSet rs = conn.getResultSet("SELECT * FROM category");
        cbCategory.removeAllItems();
        cbCategory.addItem("Select one category");
        try {
            while (rs.next()) {
                ComboBoxLoader anCatagory = new ComboBoxLoader();
                anCatagory.setCategory_id(rs.getInt("id"));
                anCatagory.setCategory_name(rs.getString("name"));
                anCatagory.setParent_id(rs.getInt("parent_id"));
                cbCategory.addItem(anCatagory);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainSale.class.getName()).log(Level.SEVERE, null, ex);
        }
        conn.closeConnection();
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
    public Product getProduct(String qr) {
        conn.getConnection();
        ResultSet rs = conn.getResultSet(qr);

        Product anProduct = null;
        try {
            while (rs.next()) {
                anProduct = new Product();
                anProduct.setProductId(rs.getInt("Product_id"));
                anProduct.setProductName(rs.getString("product_name"));
                anProduct.setQuantity(rs.getInt("quantity"));
                anProduct.setPrice(rs.getInt("minimum_sale_price"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(MainSale.class.getName()).log(Level.SEVERE, null, ex);
        }
        conn.closeConnection();
        return anProduct;
    }

    void saveCategory(String qr) {
        conn.getConnection();
        boolean rs = conn.insertData(qr);
        conn.closeConnection();
        System.out.println(qr);
        if (rs) {
            JOptionPane.showMessageDialog(null, "Saved");
        } else {
            JOptionPane.showMessageDialog(null, "Save Fail");
        }
    }

    public boolean inserOrDelete(String qr) {
        conn.getConnection();
        boolean rs = conn.insertData(qr);
        conn.closeConnection();
        return rs;
    }

    public void getAllCategoryes(JTable tblCategoryView) {
        conn.getConnection();

        String qr = "SELECT * FROM `category`";
        ResultSet rs = conn.getResultSet(qr);

        DefaultTableModel tblCategory = (DefaultTableModel) tblCategoryView.getModel();
        tblCategory.setNumRows(0);

        int i = 0;
        try {
            while (rs.next()) {
                tblCategory.addRow(new Object[]{
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("parent_id")});
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainSale.class.getName()).log(Level.SEVERE, null, ex);
        }
        conn.closeConnection();

    }

    boolean getUserName(String id, String ps) {
        String qr = "SELECT * FROM `user` WHERE user_name=\"" + id + "\"";
        conn.getConnection();
        ResultSet rs = conn.getResultSet(qr);
        boolean result = false;
        try {
            while (rs.next()) {
                if (ps.equals(rs.getString("password"))) {
                    System.out.println(rs.getString("password"));
                    result = true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainSale.class.getName()).log(Level.SEVERE, null, ex);
        }
        conn.closeConnection();
        return result;
    }
}
