/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos.BLL;

import java.util.HashMap;
import pos.DAL.InventoryGateway;
import pos.Model.InventoryProduct;

/**
 *
 * @author Md Mamin
 */
public class InventoryManager {
    
    InventoryGateway invenoryGaeway = new InventoryGateway();
    
    public HashMap<Integer, InventoryProduct> getAllProduct() {
        return invenoryGaeway.getAllProduct();
    }
    
    public HashMap<Integer, InventoryProduct> getInventoryProductBySearch(String text) {
        return invenoryGaeway.getInventoryProductBySearch(text);
    }
    
    public InventoryProduct getProductById(int productId) {
        return invenoryGaeway.getProductById(productId);
    }
    
    public boolean addToAcrt(int productId, int qn, HashMap<Integer, InventoryProduct> cartList) {
        boolean result = false;
        InventoryProduct anInvenProduct = getProductById(productId);
        if (anInvenProduct != null) {
            anInvenProduct.setSaleQuantity(qn);
            cartList.put(anInvenProduct.getProductId(), anInvenProduct);
            result = true;
        }
        return result;
    }
}
