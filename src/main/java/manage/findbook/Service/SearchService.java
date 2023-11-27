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
    private final HolubRepository<Book> bookHolubRepository =new HolubRepository<>();
    private final HolubRepository<Author> authorHolubRepository = new HolubRepository<>();
    private final HolubRepository<Category> categoryHolubRepository = new HolubRepository<>();


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
            queryBuilder.append("Author.name like \'%").append(keyword).append("%\' ");
        }
        else{
            queryBuilder.append("Book.title like \'%").append(keyword).append("%\' ");
        }
        int offset = page * size;
        queryBuilder.append(" order by Book.book_id limit ").append(size).append(" offset ").append(offset);

        List<Book> book = bookHolubRepository.processSelect("book", queryBuilder.toString());


        return book.stream()
                .map(target -> BookDO.builder().book_idx(target.getId())
                        .title(target.getTitle())
                        .price(target.getPrice())
                        .quantity(target.getQuantity())
                        .author_name(authorHolubRepository.processSelect("author","select * from author where author_id = "+target.getAuthorId() ).get(0).getName())
                        .sales(target.getSales())
                        .category(categoryHolubRepository.processSelect("Category","select * from category where category_id = " + target.getCategoryId()).get(0).getName())
                        .description(target.getDescription())
                        .registered_at(target.getRegistered_at())
                        .ISBN(target.getISBN())
                        .likes(target.getLikes())
                        .page(target.getPage())
                        .canBorrow(target.isCanBorrow())
                        .imgURL(target.getImgURL())
                        .build()
                ).toList();
    }

}
