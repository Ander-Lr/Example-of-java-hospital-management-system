package hospital;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.bson.Document;

public class DoctorMejia extends PersonMejia implements InterfaceMejia {

  private double salaryMejia;
  private Scanner scannerMejia;
  private Document documentMejia;
  private final ConnectionDBMejia connectionDBMejia = new ConnectionDBMejia();
  private List<Document> ListDoctorsMejia;

  public DoctorMejia(double salaryMejia, String nameMejia, String lastnameMejia, String dniMejia, int ageMejia) {
    super(nameMejia, lastnameMejia, dniMejia, ageMejia);
    this.salaryMejia = salaryMejia;
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

    do {
      System.out.print("Ingresa salario (400-5000): ");
      salaryMejia = scannerMejia.nextDouble();
    } while (salaryMejia < 400 || salaryMejia > 5000);

  }

  //CREA DOCTOR: CREATE - CRUD
  public void saveDoctorMejia() {
    documentMejia = new Document();
    documentMejia.append("dni", dniMejia);
    documentMejia.append("name", nameMejia);
    documentMejia.append("lastname", lastnameMejia);
    documentMejia.append("age", String.valueOf(ageMejia));
    documentMejia.append("salary", String.valueOf(salaryMejia));
    connectionDBMejia.createDocument(documentMejia, "doctors");
    System.out.println("Doctor guardado con exito");
  }

  //READ: LEE DOCTOR - CRUD
  public void readDoctorMejia() {
    ListDoctorsMejia = new ArrayList<>();
    documentMejia = new Document();
    ListDoctorsMejia = connectionDBMejia.readDocument(documentMejia, "patients");

    System.out.println("--------------------------------------------------");
    System.out.println("LECTURA DOCTORES");
    for (Document patientReadMejia : ListDoctorsMejia) {
      System.out.println("--------------------------------------------------");
      System.out.println("Cedula: " + patientReadMejia.getString("dni"));
      System.out.println("Nombres: " + patientReadMejia.getString("name"));
      System.out.println("Apellidos: " + patientReadMejia.getString("lastname"));
      System.out.println("Edad: " + patientReadMejia.getString("age"));
      System.out.println("salary: " + patientReadMejia.getString("salary"));
    }
  }
}
