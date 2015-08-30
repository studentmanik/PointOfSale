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

    public void saveBrand(String BarndName) {
        conn.getConnection();
        String sa = "INSERT INTO`brand` (`brand_id`, `brand_Name`) VALUES (NULL, '" + BarndName + "')";
        boolean rs = conn.insertData(sa);
        if (rs) {
            System.out.println(sa);
        } else {
            System.out.println(sa);
        }
        conn.closeConnection();
    }

    public void getAllCatagory(JComboBox cbCategory) {
        conn.getConnection();
        ResultSet rs = conn.getResultSet("SELECT * FROM category");
        try {
            while (rs.next()) {
                ComboBoxLoader anCatagory = new ComboBoxLoader();
                anCatagory.setCategory_id(rs.getInt("category_id"));
                anCatagory.setCategory_name(rs.getString("category_name"));
                anCatagory.setParent_id(rs.getInt("parent_id"));
                cbCategory.addItem(anCatagory);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainSale.class.getName()).log(Level.SEVERE, null, ex);
        }
        conn.closeConnection();
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
                    rs.getInt("category_id"),
                    rs.getString("category_name"),
                    rs.getInt("parent_id")});
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainSale.class.getName()).log(Level.SEVERE, null, ex);
        }
        conn.closeConnection();

    }
}
