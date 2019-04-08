package berciuboboc;

import domain.Student;
import org.junit.Test;
public class TestTema {
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
    public void addAssignment_TC2() {
        try {
            int res = service.saveTema("1", "abcd", 1, 1);
            res = service.saveTema("1", "abcd", 1, 1);

            assert (res == 1);
        } catch (Exception ex) {
            assert (true);
        } finally{
            service.deleteTema("1");
        }
    }

    @Test
    public void addAssignment_TC3() {
        try {
            int res = service.saveTema("2", "abcd", 1, 1);

            assert (res == 1);
        } catch (Exception ex) {
            assert (false);
        } finally {
            service.deleteTema("2");
        }
    }
}
