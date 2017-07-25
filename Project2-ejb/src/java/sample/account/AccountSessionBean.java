/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.account;

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
public class AccountSessionBean implements AccountSessionBeanLocal, AccountSessionBeanRemote {

    @PersistenceContext(unitName = "Project2-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public Object checkLogin(String username, String password) {
        String jpql = "TblAccount.findByAccount";

        Query query = em.createNamedQuery(jpql);
        query.setParameter("accountID", username);
        query.setParameter("password", password);

        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

}
