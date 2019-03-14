package berciuboboc;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        validation.Validator<domain.Student> studentValidator = new validation.StudentValidator();
        validation.Validator<domain.Tema> temaValidator = new validation.TemaValidator();
        validation.Validator<domain.Nota> notaValidator = new validation.NotaValidator();

        repository.StudentXMLRepository fileRepository1 = new repository.StudentXMLRepository(studentValidator, "studenti.xml");
        repository.TemaXMLRepository fileRepository2 = new repository.TemaXMLRepository(temaValidator, "teme.xml");
        repository.NotaXMLRepository fileRepository3 = new repository.NotaXMLRepository(notaValidator, "note.xml");

        service.Service service = new service.Service(fileRepository1, fileRepository2, fileRepository3);
        console.UI consola = new console.UI(service);
        consola.run();

        //PENTRU GUI
        // de avut un check: daca profesorul introduce sau nu saptamana la timp
        // daca se introduce nota la timp, se preia saptamana din sistem
        // altfel, se introduce de la tastatura
    }
}
