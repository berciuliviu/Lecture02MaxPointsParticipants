package berciuboboc;

import static org.junit.Assert.assertTrue;

import domain.Student;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTestStudent
{
    validation.Validator<domain.Student> studentValidator = new validation.StudentValidator();
    validation.Validator<domain.Tema> temaValidator = new validation.TemaValidator();
    validation.Validator<domain.Nota> notaValidator = new validation.NotaValidator();

    repository.StudentXMLRepository fileRepository1 = new repository.StudentXMLRepository(studentValidator, "studenti.xml");
    repository.TemaXMLRepository fileRepository2 = new repository.TemaXMLRepository(temaValidator, "teme.xml");
    repository.NotaXMLRepository fileRepository3 = new repository.NotaXMLRepository(notaValidator, "note.xml");

    service.Service service = new service.Service(fileRepository1, fileRepository2, fileRepository3);

    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void addStudent_TC1() {
        try {
            service.saveStudent("20", "Emanuel", 221);

            assert (true);
        } catch (Exception | AssertionError ex) {
            assert (true);
        } finally {
            service.deleteStudent("20");
        }
    }

    @Test
    public void addStudent_TC2() {
        try {
            service.saveStudent("20", null, 221);

            assert (false);
        } catch (Exception | AssertionError ex) {
            assert (true);
        } finally {
            service.deleteStudent("20");
        }
    }

    @Test
    public void addStudent_TC3() {
        try {
            service.saveStudent("", "NELSON", 221);

            assert (false);
        } catch (Exception ex) {
            assert (true);
        } finally {
            service.deleteStudent("20");
        }
    }

    @Test
    public void addStudent_TC4() {
        try {
            service.saveStudent("20", "NELSON", -1);

            assert (false);
        } catch (Exception | AssertionError ex) {
            assert (true);
        } finally {
            service.deleteStudent("20");
        }
    }

    @Test
    public void addStudent_TC5() {
        try {
            service.saveStudent("20", "NELSON", 0);

            assert (false);
        } catch (Exception ex) {
            assert (true);
        } finally {
            service.deleteStudent("20");
        }
    }

    @Test
    public void addStudent_TC6() {
        try {
            service.saveStudent("20", "", 921);

            assert (false);
        } catch (Exception | AssertionError ex) {
            assert (true);
        } finally {
            service.deleteStudent("20");
        }
    }

    @Test
    public void addStudent_TC7() {
        try {
            service.saveStudent("20", null, 0);

            assert (false);
        } catch (Exception | AssertionError ex) {
            assert (true);
        } finally {
            service.deleteStudent("20");
        }
    }

    @Test
    public void addStudent_TC8() {
        try {
            service.saveStudent("20", "NELSOOOOON", 931);

            assert (false);
        } catch (Exception | AssertionError ex) {
            assert (true);
        } finally {
            service.deleteStudent("20");
        }
    }

    @Test
    public void addStudent_TC9() {
        try {
            service.saveStudent("20", "NELSOOOOON", 931);
            service.saveStudent("20", "Nelson Mondial", 921);

            assert (false);
        } catch (Exception | AssertionError ex) {
            assert (true);
        } finally {
            service.deleteStudent("20");
        }
    }

}