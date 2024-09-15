package hospital;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.bson.Document;

public class PatientMejia extends PersonMejia implements InterfaceMejia {

  private String diagnosisMejia;
  private Scanner scannerMejia;
  private Document documentMejia;
  private final ConnectionDBMejia connectionDBMejia = new ConnectionDBMejia();
  private List<Document> ListPatientsMejia;

  public PatientMejia(String diagnosisMejia, String nameMejia, String lastnameMejia, String dniMejia, int ageMejia) {
    super(nameMejia, lastnameMejia, dniMejia, ageMejia);
    this.diagnosisMejia = diagnosisMejia;
  }

  @Override
  public void getDataPersonMejia() {
    scannerMejia = new Scanner(System.in);

    do {
      System.out.print("Ingresa cedula (10 digitos): ");
      dniMejia = scannerMejia.next();
    } while (dniMejia.length() != 10);

    System.out.print("Ingresa nombres: ");
    nameMejia = scannerMejia.next();

    System.out.print("Ingresa apellidos: ");
    lastnameMejia = scannerMejia.next();

    do {
      System.out.print("Ingresa edad (1-99): ");
      ageMejia = scannerMejia.nextInt();
    } while (ageMejia < 1 || ageMejia > 99);

    System.out.print("Ingresa diagnostico: ");
    diagnosisMejia = scannerMejia.next();

  }

  //CREA PACIENTE: CREATE - CRUD
  public void savePatientMejia() {
    documentMejia = new Document();
    documentMejia.append("dni", dniMejia);
    documentMejia.append("name", nameMejia);
    documentMejia.append("lastname", lastnameMejia);
    documentMejia.append("age", String.valueOf(ageMejia));
    documentMejia.append("diagnosis", diagnosisMejia);
    connectionDBMejia.createDocument(documentMejia, "patients");
    System.out.println("Paciente guardado con exito");
  }

  //READ: LEE PACIENTE - CRUD
  public void readPatientMejia() {
    ListPatientsMejia = new ArrayList<>();
    documentMejia = new Document();
    ListPatientsMejia = connectionDBMejia.readDocument(documentMejia, "patients");

    System.out.println("--------------------------------------------------");
    System.out.println("LECTURA PACIENTES");
    for (Document patientReadMejia : ListPatientsMejia) {
      System.out.println("--------------------------------------------------");
      System.out.println("Cedula: " + patientReadMejia.getString("dni"));
      System.out.println("Nombres: " + patientReadMejia.getString("name"));
      System.out.println("Apellidos: " + patientReadMejia.getString("lastname"));
      System.out.println("Edad: " + patientReadMejia.getString("age"));
      System.out.println("diagnosis: " + patientReadMejia.getString("diagnosis"));
    }
  }
}
