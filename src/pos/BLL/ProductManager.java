/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos.BLL;

import java.util.HashMap;
import pos.DAL.ProductGateway;
import pos.Model.Brand;
import pos.Model.Catagory;
import pos.Model.Product;

/**
 *
 * @author Md Mamin
 */
public class ProductManager {

    ProductGateway anProductGateway = new ProductGateway();

    public HashMap<Integer, Catagory> getAllCatagory() {
        return anProductGateway.getAllCatagory();
    }

    public HashMap<Integer, Brand> getAllBrand() {
        return anProductGateway.getAllBrand();
    }

    public HashMap<Integer, Product> getAllProduct() {
        return anProductGateway.getAllProduct();
    }

    public boolean deleteProduct(int productId) {
        return anProductGateway.deleteProduct(productId);
    }

    public boolean saveOrUpdateProduct(String id, String Name, int category, int brand) {
        boolean result = false;
        if (!isNumeric(id)) {
            result = anProductGateway.saveProduct(Name, category, brand);
        } else {
            anProductGateway.updateProduct(id, Name, category, brand);
        }
        return result;
    }

    public boolean saveOrUpdateCategory(int id, String categoryName, int parentId) {
        boolean result = false;
        if (id!=0) {
            anProductGateway.updateCategory(id, categoryName, parentId);
        } else {
            result = anProductGateway.saveCategory(categoryName, parentId);
        }
        return result;
    }

    private static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }

    public boolean saveBrand(String ms) {
        return anProductGateway.saveBrand(ms);
    }

    public boolean deleteCategory(int categoryId) {
        return anProductGateway.deleteCategory(categoryId);
    }
}
