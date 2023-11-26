package holub.database.jdbc;

import manage.findbook.domain.Author;
import manage.findbook.domain.Book;
import manage.findbook.domain.Category;

import java.time.LocalDateTime;
import java.util.List;

public class ConnectorTest {

    public static void main(String[] args) {
        HolubRepository<Book> repository = new HolubRepository<>();
        HolubRepository<Author> repository2 = new HolubRepository<>();
        HolubRepository<Category> repository3 = new HolubRepository<>();
//        int status1 = repository.processUpdate("book","insert into book values (1,\'mobydick\', 100000, 20, 1, 10, 1,32, \'testing\',\'"+ LocalDateTime.now()+"\' , \'123123\', 528) ");
 //       int status2 = repository2.processUpdate("author","insert into author values (1,\'Herman Melville\','british') ");
  //      int status3 = repository3.processUpdate("category","insert into book category (1,\'Narrative\', 10) ");
//        List<Author> result2 = repository2.processSelect("author","select * from author");
//        List<Book> result = repository.processSelect("book","select * from book");
//        for (Book book : result) {
//            System.out.println("book = " + book);
//        }
        List<Book> books = repository.processSelect("book","SELECT  book_idx, title, price, quantity, author_id,  sales, category_id, likes, description,registered_at, ISBN, page  FROM Book, Category, Author  WHERE Book.author_id = Author.author_id and Book.category_id = Category.category_id  and Author.name like '%man%'  order by Book.book_id limit 10 offset 0");
        List<Author> authors = repository2.processSelect("author","select * from book, author where book.author_id = author.author_id");
        List<Category> categories = repository3.processSelect("category","select * from category");
        repository.disconnect();
        repository2.disconnect();
        repository3.disconnect();
        }
}
