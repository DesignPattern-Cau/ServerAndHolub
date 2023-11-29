package manage.findbook;

import holub.database.jdbc.HolubRepository;
import holub.database.jdbc.People;

import java.util.List;

public class HolubTestRaw {

    public static void main(String[] args) {
        HolubRepository<People> repository = new HolubRepository<>();
        repository.processUpdate("people","insert into people values (\'lim\',\'en\" seop\',2)");
        List<People> people = repository.processSelect("people", "select * from people");
        for (People person : people)
            System.out.println("person = " + person);
        repository.disconnect();
        }
    }

