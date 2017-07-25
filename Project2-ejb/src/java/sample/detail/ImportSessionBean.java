/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.detail;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Notebook
 */
@Stateless
public class ImportSessionBean implements ImportSessionBeanLocal, ImportSessionBeanRemote {

    @PersistenceContext(unitName = "Project2-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public void insertImport(Date date, double price, int quantity, String id) {
        TblImport imp = new TblImport();
        imp.setImportedDate(date);
        imp.setPrice(price);
        imp.setQuantity(quantity);
        imp.setProductID(id);

        persist(imp);

    }

    @Override
    public void deleteImport(String id) {
//        String jpql = "TblImport.deleteByProductID";
//
//        Query query = em.createNamedQuery(jpql);
//        query.setParameter("productID", id);
//        
//        query.executeUpdate();

        String jpql = "...";

        Query query = em.createNamedQuery(jpql);
        
        List list = query.getResultList();
        
        Iterator iterator = list.iterator();
        
        while(iterator.hasNext()){
            em.merge(iterator.next());
            em.remove(iterator.next());
        }
    }

}
