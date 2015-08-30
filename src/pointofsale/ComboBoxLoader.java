/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointofsale;

/**
 *
 * @author Md Mamin
 */
public class ComboBoxLoader {
 
    private int category_id;
    private int parent_id;
     private String category_name;

//         public ComboBoxLoader(int id, int value,String name)
//    {
//        this.category_id = id;
//        this.parent_id = value;
//        this.category_name=name;
//    }
    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public int getParent_id() {
        return parent_id;
    }

    public void setParent_id(int parent_id) {
        this.parent_id = parent_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }



    @Override
    public String toString()
    {
        return category_name;
    }

    

}
