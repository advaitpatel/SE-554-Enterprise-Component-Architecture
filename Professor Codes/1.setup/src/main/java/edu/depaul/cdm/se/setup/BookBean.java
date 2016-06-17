package edu.depaul.cdm.se.setup;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@SessionScoped
@Named
public class BookBean implements Serializable {
    private static final Logger logger = Logger.getLogger(BookBean.class.getName());
    
    @PersistenceContext(unitName = "bookPU")
    private EntityManager entityManager;
     
    public List<Book> getBookList() throws SQLException {
        logger.info("Before getting connection");
        
        List<Book> list = entityManager.createNamedQuery("findAllBooks").getResultList();
        
        logger.log(Level.INFO, "Before returning: {0}", list.size());
        
        return list;
    }
}