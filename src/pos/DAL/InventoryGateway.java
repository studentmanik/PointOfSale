/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos.DAL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import pos.Model.InventoryProduct;
import pos.Model.Supplier;

/**
 *
 * @author Md Mamin
 */
public class InventoryGateway extends DBconn {

    public HashMap<Integer, InventoryProduct> getAllProduct() {
        HashMap<Integer, InventoryProduct> inventoryProducts = new HashMap<Integer, InventoryProduct>();

        getConnection();
        ResultSet rs = getResultSet("SELECT * FROM mainproduct");
        InventoryProduct anInvProduct;
        try {
            while (rs.next()) {
                anInvProduct = new InventoryProduct();
                anInvProduct.setProductId(rs.getInt("product_id"));
                anInvProduct.setProductName(rs.getString("product_name"));
                anInvProduct.setPurchasePrice(Integer.parseInt(rs.getString("purchase_price")));
                anInvProduct.setQuantity(Integer.parseInt(rs.getString("quantity")));
                anInvProduct.setPrice(Integer.parseInt(rs.getString("minimum_sale_price")));
                inventoryProducts.put(anInvProduct.getProductId(), anInvProduct);
            }
        } catch (SQLException ex) {
            Logger.getLogger(InventoryGateway.class.getName()).log(Level.SEVERE, null, ex);
        }
        closeConnection();
        return inventoryProducts;
    }

    public HashMap<Integer, InventoryProduct> getInventoryProductBySearch(String text) {

        String qr = "SELECT * FROM mainproduct WHERE product_name LIKE \"%" + text + "%\"";
        HashMap<Integer, InventoryProduct> inventoryProducts = new HashMap<Integer, InventoryProduct>();

        getConnection();
        ResultSet rs = getResultSet(qr);
        InventoryProduct anInvProduct;
        try {
            while (rs.next()) {
                anInvProduct = new InventoryProduct();
                anInvProduct.setProductId(rs.getInt("product_id"));
                anInvProduct.setProductName(rs.getString("product_name"));
                anInvProduct.setPurchasePrice(Integer.parseInt(rs.getString("purchase_price")));
                anInvProduct.setQuantity(Integer.parseInt(rs.getString("quantity")));
                anInvProduct.setPrice(Integer.parseInt(rs.getString("minimum_sale_price")));
                inventoryProducts.put(anInvProduct.getProductId(), anInvProduct);
            }
        } catch (SQLException ex) {
            Logger.getLogger(InventoryGateway.class.getName()).log(Level.SEVERE, null, ex);
        }
        closeConnection();
        return inventoryProducts;

    }

    public InventoryProduct getProductById(int id) {
        String qr = "SELECT * FROM `mainproduct` WHERE id=" + id;
        getConnection();
        ResultSet rs = getResultSet(qr);
        InventoryProduct anInvProduct = null;
        try {
            while (rs.next()) {
                anInvProduct = new InventoryProduct();
                anInvProduct.setProductId(rs.getInt("product_id"));
                anInvProduct.setProductName(rs.getString("product_name"));
                anInvProduct.setPurchasePrice(Integer.parseInt(rs.getString("purchase_price")));
                anInvProduct.setQuantity(Integer.parseInt(rs.getString("quantity")));
                anInvProduct.setPrice(Integer.parseInt(rs.getString("minimum_sale_price")));

            }
        } catch (SQLException ex) {
            Logger.getLogger(InventoryGateway.class.getName()).log(Level.SEVERE, null, ex);
        }
        closeConnection();

        return anInvProduct;
    }

    public HashMap<Integer, Supplier> getAllSupplier() {
        HashMap<Integer, Supplier> SupplierList = new HashMap<Integer, Supplier>();

        getConnection();
        ResultSet rs = getResultSet("SELECT * FROM supplier");
        Supplier anSupplier;
        try {
            while (rs.next()) {
                anSupplier = new Supplier();
                anSupplier.setId(rs.getInt("id"));
                anSupplier.setName(rs.getString("name"));
                anSupplier.setCompanyLocation(rs.getString("company_location"));
                anSupplier.setPhone(rs.getString("phone"));
                SupplierList.put(anSupplier.getId(), anSupplier);
            }
        } catch (SQLException ex) {
            Logger.getLogger(InventoryGateway.class.getName()).log(Level.SEVERE, null, ex);
        }
        closeConnection();
        return SupplierList;

    }

}
