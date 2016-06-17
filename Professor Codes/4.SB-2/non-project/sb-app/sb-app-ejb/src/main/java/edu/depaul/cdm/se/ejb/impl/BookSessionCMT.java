package edu.depaul.cdm.se.ejb.impl;

import edu.depaul.cdm.se.jpa.Book;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.*;

@Stateless
@LocalBean
public class BookSessionCMT {

    @PersistenceContext(unitName="sb-demoPU")
    private EntityManager em;
    
    public List<Book> getAllBooks() {
        return em.createNamedQuery("Book.findAll").getResultList();
    }
    
    public Book findBook(Long bookId) {
        return em.createNamedQuery("Book.findById", Book.class).
                    setParameter("id", bookId).getSingleResult();
    }
    
    public Book createBook(Book book) {
        em.persist(book);
        return book;
    }
    
}
