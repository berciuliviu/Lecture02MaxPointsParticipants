package berciuboboc;

import domain.Student;
import org.junit.Test;
public class TestIntegration {
    validation.Validator<domain.Student> studentValidator = new validation.StudentValidator();
    validation.Validator<domain.Tema> temaValidator = new validation.TemaValidator();
    validation.Validator<domain.Nota> notaValidator = new validation.NotaValidator();

    repository.StudentXMLRepository fileRepository1 = new repository.StudentXMLRepository(studentValidator, "studenti.xml");
    repository.TemaXMLRepository fileRepository2 = new repository.TemaXMLRepository(temaValidator, "teme.xml");
    repository.NotaXMLRepository fileRepository3 = new repository.NotaXMLRepository(notaValidator, "note.xml");

    service.Service service = new service.Service(fileRepository1, fileRepository2, fileRepository3);

    @Test
    public void addAssignment_TC1() {
        try {
            service.saveTema("", "abcd", 3, 1);

            assert (false);
        } catch (Exception ex) {
            assert (true);
        } finally {
            // service.deleteTema("123");
        }
    }

    @Test
    public void addStudent_TC1() {
        try {
            service.saveStudent("20", "Emanuel", 221);

            assert (true);
        } catch (Exception ex) {
            assert (false);
        } finally {
            service.deleteStudent("20");
        }
    }

    @Test
    public void addGrade_TC1() {
        try {
            int res = service.saveNota("2","3",2.3,1,"NONE");

            assert (res == 0);
        } catch (Exception ex) {
            assert (false);
        } finally {
            service.deleteStudent("20");
        }
    }

    @Test
    public void integrationTest_TC1()
    {
        try {
            service.saveStudent("20", "Emanuel", 221);
            service.saveTema("20", "abcd", 3, 1);
            int res = service.saveNota("20","20",2.3,1,"NONE");

            assert (true);
        } catch (Exception ex) {
            assert (false);
        } finally {
             service.deleteTema("20");
             service.deleteStudent("20");
        }
    }
}
