/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.detail;

import java.util.Date;
import javax.ejb.Local;

/**
 *
 * @author Notebook
 */
@Local
public interface ImportSessionBeanLocal {

    void insertImport(Date date, double price, int quantity, String id);

    void deleteImport(String id);
    
}
