package manage.findbook.Service;

import holub.database.jdbc.HolubRepository;
import jakarta.annotation.PreDestroy;
import manage.findbook.domain.Author;
import manage.findbook.domain.Book;
import manage.findbook.domain.BookDO;
import manage.findbook.domain.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {
    private HolubRepository<Book> bookHolubRepository =new HolubRepository<>();
    private HolubRepository<Author> authorHolubRepository = new HolubRepository<>();
    private HolubRepository<Category> categoryHolubRepository = new HolubRepository<>();


    @PreDestroy
    public void cleanUp(){
        bookHolubRepository.disconnect();
        authorHolubRepository.disconnect();
        categoryHolubRepository.disconnect();
    }

    public List<BookDO> getBookListPage(String type, String keyword, int page, int size){
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

        List<Book> book = bookHolubRepository.processSelect("book", queryBuilder.toString());
        for (Book book1 : book) {
            System.out.println("book1 = " + book1);
        }


        return book.stream()
                .map(target -> BookDO.builder()
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
                        .canBorrow(target.isCanBorrow())
                        .imgURL(target.getImgURL())
                        .build()
                ).toList();
    }

}
