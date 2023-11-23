package manage.findbook.Repository;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import manage.findbook.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Member;
import java.util.List;

@Repository
public class BookReposit  {

    @PersistenceContext
    private EntityManager em;

    public void save(Book book) {
        em.persist(book);
    }

    public Book findOne(Long id){
        return em.find(Book.class, id);
    }

    public List<Book> findAll() {
        return em.createQuery("select m from Book m", Book.class)
                .getResultList();
    }

    public List<Book> findByTitle(String keyword) {
        return em.createQuery("Select m from Book m where m.title = :keyword", Book.class)
                .setParameter("keyword", keyword)
                .getResultList();
    }
}

