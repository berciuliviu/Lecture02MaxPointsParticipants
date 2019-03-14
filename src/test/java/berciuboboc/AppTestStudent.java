package berciuboboc;

import static org.junit.Assert.assertTrue;

import domain.Student;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTestStudent
{
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
        validation.Validator<domain.Student> studentValidator = new validation.StudentValidator();
        validation.Validator<domain.Tema> temaValidator = new validation.TemaValidator();
        validation.Validator<domain.Nota> notaValidator = new validation.NotaValidator();

        repository.StudentXMLRepository fileRepository1 = new repository.StudentXMLRepository(studentValidator, "studenti.xml");
        repository.TemaXMLRepository fileRepository2 = new repository.TemaXMLRepository(temaValidator, "teme.xml");
        repository.NotaXMLRepository fileRepository3 = new repository.NotaXMLRepository(notaValidator, "note.xml");

        service.Service service = new service.Service(fileRepository1, fileRepository2, fileRepository3);

        service.saveStudent("20", "Emanuel", 221);

        assert(true);

        service.deleteStudent("20");
    }

    @Test
    public void addStudent_TC2() {

    }
}