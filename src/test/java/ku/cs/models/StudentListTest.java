package ku.cs.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentListTest {
    StudentList testList;
    StudentList testList2;
    @BeforeEach
    void init(){
        testList = new StudentList();
    }

    @Test
    void testAddStudentWithoutScore(){
        testList.addNewStudent("6710405890", "Chawangkorn");
        testList.addNewStudent("6710457564", "Sombat");
        assertEquals(2, testList.getStudents().size());
        assertEquals("6710405890", testList.getStudents().get(0).getId());
        assertEquals("Chawangkorn", testList.getStudents().get(0).getName());
        assertEquals("6710457564", testList.getStudents().get(1).getId());
        assertEquals("Sombat", testList.getStudents().get(1).getName());
    }

    @Test
    void testAddStudentWithScore(){
        testList.addNewStudent("6710405890", "Chawangkorn", 80);
        testList.addNewStudent("6710457564", "Sombat", 76);
        assertEquals(2, testList.getStudents().size());
        assertEquals("6710405890", testList.getStudents().get(0).getId());
        assertEquals("Chawangkorn", testList.getStudents().get(0).getName());
        assertEquals(80, testList.getStudents().get(0).getScore());

        assertEquals("6710457564", testList.getStudents().get(1).getId());
        assertEquals("Sombat", testList.getStudents().get(1).getName());
        assertEquals(76, testList.getStudents().get(1).getScore());
    }


    @Test
    void testFindStudentById(){
        testList.addNewStudent("6710405943", "Somchai", 69);
        Student actual = testList.findStudentById("6710405943");

        assertEquals("6710405943", actual.getId());
        assertEquals("Somchai", actual.getName());

    }

    @Test
    void testFilterByName(){
        testList.addNewStudent("6710405943", "Somchai", 69);
        testList.addNewStudent("6710405943", "Athid", 65);
        StudentList filtered = testList.filterByName("Som");
        assertEquals(1, filtered.getStudents().size());
        assertTrue(filtered.getStudents().get(0).getName().contains("Som"));
    }

    @Test
    void testGiveScore(){
        testList.addNewStudent("6710405943", "Somchai", 69);
        testList.addNewStudent("6710458043", "Athid", 50);

        testList.giveScoreToId("6710405943",1);
        assertEquals(70, testList.getStudents().get(0).getScore());
    }

    @Test
    void testViewGradeOfId(){
        testList.addNewStudent("6710405943", "Somchai", 99);
        testList.addNewStudent("6710458043", "Athid", 50);
        testList.viewGradeOfId("6710458043");
        assertEquals("D", testList.getStudents().get(1).grade());

    }
}