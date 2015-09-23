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
import pos.Model.Brand;
import pos.Model.Catagory;
import pos.Model.Product;

/**
 *
 * @author Md Mamin
 */
public class ProductGateway extends DBconn {

    public boolean deleteProduct(int productId) {
        String query = "DELETE FROM `product` WHERE `product_id` = " + productId;
        getConnection();
        boolean rs = insertData(query);
        closeConnection();
        return rs;
    }

    public boolean saveProduct(String Name, int category, int brand) {
        getConnection();
        String qr = "INSERT INTO `product` (`product_id`, `product_name`, `category_id`, `brand_id`) VALUES (NULL, '" + Name + "', '" + category + "', '" + brand + "')";
        boolean rs = insertData(qr);
        closeConnection();
        return rs;
    }

    public boolean updateProduct(String id, String Name, int category, int brand) {
        getConnection();
        String qr = "UPDATE `product` SET `product_name`='" + Name + "',`category_id` = '" + category + "', `brand_id` = '" + brand + "' WHERE `product_id` =" + id;
        boolean rs = insertData(qr);
        closeConnection();
        return rs;
    }

    public HashMap<Integer, Catagory> getAllCatagory() {
        getConnection();
        ResultSet rs = getResultSet("SELECT * FROM category");
        HashMap<Integer, Catagory> catagoryList = new HashMap<Integer, Catagory>();
        try {
            while (rs.next()) {
                Catagory anCatagory = new Catagory();
                anCatagory.setCategory_id(rs.getInt("id"));
                anCatagory.setCategory_name(rs.getString("name"));
                anCatagory.setParent_id(rs.getInt("parent_id"));
                catagoryList.put(anCatagory.getCategory_id(), anCatagory);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductGateway.class.getName()).log(Level.SEVERE, null, ex);
        }
        closeConnection();
        return catagoryList;
    }

    public HashMap<Integer, Brand> getAllBrand() {
        HashMap<Integer, Brand> brandList = new HashMap<Integer, Brand>();
        getConnection();
        ResultSet rs = getResultSet("SELECT * FROM brand");
        try {
            while (rs.next()) {
                Brand anBrand = new Brand();
                anBrand.setId(rs.getInt("id"));
                anBrand.setName(rs.getString("brand_Name"));
                brandList.put(anBrand.getId(), anBrand);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductGateway.class.getName()).log(Level.SEVERE, null, ex);
        }
        closeConnection();
        return brandList;
    }

    public HashMap<Integer, Product> getAllProduct() {
        HashMap<Integer, Product> productList = new HashMap<Integer, Product>();
        getConnection();
        ResultSet rs = getResultSet("SELECT * FROM productview");
        Product anProduct = null;
        try {
            while (rs.next()) {
                anProduct = new Product();
                anProduct.setProductId(rs.getInt("product_id"));
                anProduct.setProductName(rs.getString("product_name"));
                anProduct.setCategoryId(rs.getInt("category_id"));;
                anProduct.setCategoryName(rs.getString("name"));
                anProduct.setParent_id(rs.getInt("parent_id"));
                anProduct.setBrandId(rs.getInt("brand_id"));
                anProduct.setBrandName(rs.getString("brand_name"));
                productList.put(anProduct.getProductId(), anProduct);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductGateway.class.getName()).log(Level.SEVERE, null, ex);
        }
        closeConnection();
        return productList;
    }

    public boolean saveBrand(String ms) {
        getConnection();
        String sa = "INSERT INTO`brand` (`id`, `brand_Name`) VALUES (NULL, '" + ms + "')";
        boolean rs = insertData(sa);
        closeConnection();
        return rs;
    }

    public boolean saveCategory(String categoryName, int parentId) {
        String qr = "INSERT INTO `pointofsale`.`category` (`id`, `name`, `parent_id`) VALUES (NULL, '" + categoryName + "', '" + parentId + "')";
        getConnection();
        boolean rs = insertData(qr);
        closeConnection();
        return rs;
    }

    public boolean updateCategory(int categoryId, String categoryName, int parentId) {
        String qr = "UPDATE `pointofsale`.`category` SET `name` = '" + categoryName + "', `parent_id` = '" + parentId + "' WHERE `category`.`id` =" + categoryId;
        getConnection();
        boolean rs = insertData(qr);
        closeConnection();
        return rs;
    }
     public boolean deleteCategory(int categoryId) {
       String qr = "DELETE FROM `category` WHERE `id` =" +categoryId;
        getConnection();
        boolean rs = insertData(qr);
        closeConnection();
        return rs;
    }

}
