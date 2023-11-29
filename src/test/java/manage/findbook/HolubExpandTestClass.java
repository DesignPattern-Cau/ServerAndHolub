package manage.findbook;


import holub.database.jdbc.Console;
import org.junit.jupiter.api.Test;

public class HolubExpandTestClass {

    @Test
    public void testIfHolubHandleJoinAstroid(){
        String query = "select * from address, people where address.addrId = people.addrId";
    }
}
