package holub.database.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HolubRepository<T> {

    private HolubConnection holubConnection;
    private final MapperFactory genericMapperFactory = new GenericMapperFactory();

    public HolubRepository() {
        this.holubConnection = HolubConnection.getInstance();
        holubConnection.openDatabase();
    }

    public void disconnect(){
        holubConnection.closeDatabase();
    }

    public void reconnect(){
        holubConnection.openDatabase();
    }

    public List<T> processSelect(String className, String query){
        className = Character.toUpperCase(className.trim().charAt(0)) + className.trim().substring(1);
        DataMapper<T> mapper = genericMapperFactory.createMapper(className);

        if(mapper == null) return new ArrayList<>();

        try{

            ResultSet resultSet = holubConnection.processSQL(query);
            return mapper.mapResultSetToObject(resultSet);
        }catch (Exception e){
            return new ArrayList<>();
        }
    }

    public int processUpdate(String className, String query){
        try{
            holubConnection.processUpdate(query);
            return 1;
        }catch (Exception e){
            return 0;
        }
    }

}
