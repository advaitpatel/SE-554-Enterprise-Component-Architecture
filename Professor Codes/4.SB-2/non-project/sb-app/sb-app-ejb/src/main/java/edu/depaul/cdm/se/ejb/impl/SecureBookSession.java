package edu.depaul.cdm.se.ejb.impl;

import edu.depaul.cdm.se.jpa.Book;
import java.util.List;
import javax.annotation.Resource;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.ejb.SessionContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@LocalBean
@PermitAll
public class SecureBookSession {
    

    @PersistenceContext(unitName = "sb-demoPU")
    private EntityManager em;
    
    @Resource
    private SessionContext sc;

    public List<Book> getAllBooks() {
        return em.createNamedQuery("Book.findAll").getResultList();
    }

    public Book findBook(Long bookId) {
        return em.createNamedQuery("Book.findById", Book.class).
                setParameter("id", bookId).getSingleResult();
    }

    @RolesAllowed({"admin"})
    public Book createBook(Book book) {
        em.persist(book);
        return book;
    }
    
    public void deleteBook(Book book) {
        if (sc.isCallerInRole("admin")){
            em.remove(book);    
        } else {
            throw new SecurityException("you must be an admin to delete a book");
        }
    }
}
