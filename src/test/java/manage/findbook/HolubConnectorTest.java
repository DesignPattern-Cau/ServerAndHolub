package manage.findbook;

import holub.database.jdbc.DataMapper;
import holub.database.jdbc.GenericMapperFactory;
import holub.database.jdbc.HolubConnection;
import holub.database.jdbc.HolubRepository;
import manage.findbook.domain.Author;
import manage.findbook.domain.Book;
import manage.findbook.domain.BookMapper;
import manage.findbook.domain.Category;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

public class HolubConnectorTest {
    @Test
    public void testIfConnectorConnects(){
        HolubConnection connection = HolubConnection.getInstance();
        Assertions.assertDoesNotThrow(()-> {
            connection.openDatabase();
        });
        //연결되지 않는다면 exception을 던질것!
    }

    @Test
    public void reflectionMapperTest(){
        final GenericMapperFactory genericMapperFactory = new GenericMapperFactory();
        Object mapper = genericMapperFactory.createMapper("Book");
        Assertions.assertTrue(mapper instanceof BookMapper<?>);
    }
    
    @Test
    public void test(){
        HolubRepository<Author> repository = new HolubRepository<>();
        List<Author> book = repository.processSelect("author", "select * from author where name ='Herman Melville'");
    }

    @Test
    public void testForHolubRepository(){
        HolubRepository<Book> repository = new HolubRepository<>();
        List<Book> books = repository.processSelect("book","select * from book");
        for (Book book : books) {
            Assertions.assertInstanceOf(Book.class,book);
        }
    }

    @Test
    public void testIfInsertionApplied(){
        HolubRepository< Category> repository = new HolubRepository<>();
        List<Category> a = repository.processSelect("category", "select * from category");
        repository.processUpdate("category","insert into category values(4,'limenseop',10)");
        repository.disconnect();
        repository.reconnect();
        List<Category> b = repository.processSelect("category", "select * from category");
        Assertions.assertNotEquals(a,b);
    }
}
