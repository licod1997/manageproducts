/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.product;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Notebook
 */
@Stateless
public class ProductSessionBean implements ProductSessionBeanLocal, ProductSessionBeanRemote {

    @PersistenceContext(unitName = "Project2-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public List getProducts() {
        String jpql = "TblProduct.findAll";

        Query query = em.createNamedQuery(jpql);

        List result = query.getResultList();

        return result;
    }

    @Override
    public boolean insertProduct(String id, String name, String unit) {
        TblProduct product = em.find(TblProduct.class, id);

        if (product == null) {
            product = new TblProduct();
            product.setProductID(id);
            product.setProductName(name);
            product.setUnit(unit);

            persist(product);

            return true;
        }
        return false;
    }

    @Override
    public boolean updateProduct(String id, double price, String unit) {
        TblProduct product = em.find(TblProduct.class, id);

        if (product != null) {
            product.setPrice(price);
            product.setUnit(unit);

            em.merge(product);
            return true;
        }

        return false;
    }

    @Override
    public boolean deleteProduct(String id) {
        TblProduct product = em.find(TblProduct.class, id);

        if (product != null) {
            em.merge(product);
            em.remove(product);
            return true;
        }

        return false;
    }

    @Override
    public Object getProduct(String id) {
        String jpql = "TblProduct.findByProductID";
        
        Query query = em.createNamedQuery(jpql);
        query.setParameter("productID", id);
        
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
        return null;
        }
    }

    @Override
    public boolean updateAfterImport(String id, double price, int quantity) {
        TblProduct product = em.find(TblProduct.class, id);

        if (product != null) {
            product.setPrice(price);
            product.setQuantity(quantity);

            em.merge(product);
            return true;
        }

        return false;
    }
    
    

}
