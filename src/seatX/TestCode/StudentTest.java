package seatX.TestCode;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import seatX.Model.Student;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    public Student st;

    @Before
    public void setUp() {
        st = new Student("a","Route 1","2:00 pm","a1");
    }

    @Test
    void getId() {
        assertEquals("a",st.getId());
    }

    @Test
    void setId() {
        st.setId("b");
        assertEquals("b",st.getId());
    }

    @Test
    void getRoute() {
        assertEquals("Route 1", st.getRoute());
    }

    @Test
    void setRoute() {
        st.setRoute("Route 2");
        assertEquals("Route 2", st.getRoute());
    }

    @Test
    void getTime() {
    }

    @Test
    void setTime() {
    }

    @Test
    void getSeat() {
    }

    @Test
    void setSeat() {
    }
}