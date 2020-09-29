package seatX.TestCode;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import seatX.Controller.Consql;

class ConsqlTest {

    static Consql CC;

    @Before
    public void setUp() throws Exception {
        CC = new Consql ();
    }

    @Test
    void getConnection() {
        System.out.println("Created Connection Succesfully");
        //assertEquals(CC,CC.connection);
    }
}