package ku.cs.models;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    Student s;
    @BeforeEach
    void init(){
        s = new Student("6710405273", "Test", 0.0);
    }

    @Test
    void testChangeName() {
        s.changeName("TestMe");
        assertEquals("TestMe", s.getName());

    }

    @Test
    @DisplayName("ทดสอบการเพิ่มคะแนน")
    void testAddScore() {
        s.addScore(58.5);
        assertEquals(58.5, s.getScore());
    }
    @Test
    void testCalculateGrade() {
        s.addScore(20);
        assertEquals("F", s.grade());
    }

    @Test
    void testIsID(){
        assertTrue(s.isId("6710405273"));
    }

    @Test
    void testIsNameContains(){
        assertTrue(s.isNameContains("est"));
    }

    @Test
    void testToString() {
        String expected = "{id: '6710405273', name: 'Test', score: 0.0}";
        String actual = s.toString();

        assertEquals(expected, actual);
    }
}