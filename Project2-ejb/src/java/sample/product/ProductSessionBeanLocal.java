/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.product;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Notebook
 */
@Local
public interface ProductSessionBeanLocal {

    List getProducts();

    boolean insertProduct(String id, String name, String unit);

    boolean updateProduct(String id, double price, String unit);

    boolean deleteProduct(String id);

    Object getProduct(String id);

    boolean updateAfterImport(String id, double price, int quantity);
    
}
