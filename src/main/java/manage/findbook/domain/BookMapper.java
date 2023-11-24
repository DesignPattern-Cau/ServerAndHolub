package manage.findbook.domain;

import holub.database.jdbc.DataMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BookMapper<T> implements DataMapper<T> {

    private static final BookMapper INSTANCE =new BookMapper();

    private BookMapper(){}

    public static BookMapper getInstance(){
        return INSTANCE;
    }
    @Override
    public List<T> mapResultSetToObject(ResultSet resultSet) throws SQLException {
        List<T> result = new ArrayList<>();
        while(resultSet.next()){
            Book target = Book.builder()
                    .id(resultSet.getLong("book_idx"))
                    .title(resultSet.getString("title"))
                    .price(resultSet.getInt("price"))
                    .quantity(resultSet.getInt("quantity"))
                    .sales(resultSet.getInt("sales"))
                    .page(resultSet.getInt("size"))
                    .registered_at(LocalDateTime.parse(resultSet.getString("registered_at")))
                    .title(resultSet.getString("title"))
                    .description(resultSet.getString("description"))
                    .ISBN(resultSet.getString("ISBN")).build();
            result.add((T) target);
        }
        return result;
    }
}
