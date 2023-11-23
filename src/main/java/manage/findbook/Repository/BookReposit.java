package manage.findbook.Repository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import manage.findbook.domain.Book;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@RequiredArgsConstructor
public class BookReposit {

    private final EntityManager em;

    public void save(Book book) {
        em.persist(book);
    }

    public Book findone(int id) {
        return em.find(Book.class, id);

    }

    public List<Book> findAll() {
        return em.createQuery("select i from Book i", Book.class)
                .getResultList();
    }
}
