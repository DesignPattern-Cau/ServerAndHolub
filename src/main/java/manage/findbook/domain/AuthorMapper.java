package manage.findbook.domain;

import holub.database.jdbc.DataMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AuthorMapper<T> implements DataMapper<T> {

    private static AuthorMapper INSTANCE = new AuthorMapper();

    private AuthorMapper(){}

    public static AuthorMapper getInstance(){
        return INSTANCE;
    }

    @Override
    public List<T> mapResultSetToObject(ResultSet resultSet) throws SQLException {
        List<T> resultList = new ArrayList<>();
        while(resultSet.next()){
            Author author = new Author();
            author.setAuthor_id(resultSet.getLong("author_id"));
            author.setDescription(resultSet.getString("description"));
            author.setName(resultSet.getString("name"));
            resultList.add((T)author);
        }
        return resultList;
    }
}
