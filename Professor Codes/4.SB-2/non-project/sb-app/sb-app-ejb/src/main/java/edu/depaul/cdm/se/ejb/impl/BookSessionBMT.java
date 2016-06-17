package edu.depaul.cdm.se.ejb.impl;

import edu.depaul.cdm.se.jpa.Book;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.*;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

@Stateless
@LocalBean
@TransactionManagement(TransactionManagementType.BEAN)
public class BookSessionBMT {
    @PersistenceContext(unitName="sb-demoPU")
    private EntityManager em;
    
    @Resource
    private UserTransaction ut;
    
    public List<Book> getAllBooks() {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("sb-demoPU");
//        EntityManager em = emf.createEntityManager();
        return em.createNamedQuery("Book.findAll").getResultList();
    }

    public Book findBook(Long bookId) {
        return em.createNamedQuery("Book.findById", Book.class).
                    setParameter("id", bookId).getSingleResult();
    }
    
    public Book createBook(Book book) {
        try {
            ut.begin();
            em.persist(book);
            ut.commit();
        } catch (Exception e) {
            try {
                ut.rollback();
            } catch (IllegalStateException ex) {
                Logger.getLogger(BookSessionBMT.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SecurityException ex) {
                Logger.getLogger(BookSessionBMT.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SystemException ex) {
                Logger.getLogger(BookSessionBMT.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return book;
    }
}
