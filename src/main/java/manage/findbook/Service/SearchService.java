package manage.findbook.Service;

import holub.database.jdbc.HolubRepository;
import manage.findbook.domain.Author;
import manage.findbook.domain.Book;
import manage.findbook.domain.BookListDO;
import manage.findbook.domain.Category;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchService {
    private HolubRepository<Book> bookHolubRepository =new HolubRepository<>();
    private HolubRepository<Author> authorHolubRepository = new HolubRepository<>();
    private HolubRepository<Category> categoryHolubRepository = new HolubRepository<>();

    public List<BookListDO> getBookListPage(String type, String keyword, int page, int size){
        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("SELECT " +
                " * " +
                " FROM Book, Category, Author " +
                " WHERE Book.author_id = Author.author_id and Book.category_id = Category.category_id " +
                " and ");
        if(type.equals("author")){
            queryBuilder.append("Author.name like \'%"+keyword+"%\' " );
        }
        else{
            queryBuilder.append("Book.title like \'%"+keyword+"%\' ");
        }
        int offset = page * size;
        queryBuilder.append(" order by Book.book_id limit "+size+" offset "+ offset);
        System.out.println("queryBuilder.toString() = " + queryBuilder.toString());
        List<Book> book = bookHolubRepository.processSelect("book", queryBuilder.toString());
        for (Book book1 : book) {
            System.out.println("book1 = " + book1);
        }

        List<BookListDO> resultList = book.stream()
                .map(target -> BookListDO.builder()
                        .bookIdx(target.getId())
                        .title(target.getTitle())
                        .price(target.getPrice())
                        .quantity(target.getQuantity())
                        .authorName(authorHolubRepository.processSelect("author","select * from author where author_id = "+target.getAuthorId() ).get(0).getName())
                        .sales(target.getSales())
                        .category(categoryHolubRepository.processSelect("Category","select * from category where category_id = " + target.getCategoryId()).get(0).getName())
                        .description(target.getDescription())
                        .registeredAt(target.getRegistered_at())
                        .ISBN(target.getISBN())
                        .page(target.getPage())
                        .build()
                ).toList();



        return resultList;
    }

}
