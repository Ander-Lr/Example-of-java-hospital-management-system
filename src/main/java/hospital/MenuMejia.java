package hospital;

import java.util.ArrayList;//PARA CREAR LISTAS
import java.util.Scanner;//PEDIDO DATOS POR TECLADO

public class MenuMejia {

  //GUARDA 1 PACIENTE
  private PatientMejia patientMejia;
  //GUARDA CADA PACIENTE EN UNA LISTA
  private final ArrayList<PatientMejia> patientsMejia = new ArrayList<>();

  //GUARDA 1 DOCTOR
  private DoctorMejia doctorMejia;
  //GUARDA CADA DOCTOR EN UNA LISTA
  private final ArrayList<DoctorMejia> doctorsMejia = new ArrayList<>();

  //PEDIDO DE DATOS POR TECLADO
  private final Scanner scanner = new Scanner(System.in);

  //CANT. PACIENTES, DOCTORES Y OPCIÓN DE MENÚ
  private int nPatientsMejia = 0, nDoctorsMejia = 0, optionMenuMejia = 0;

  //INICIA MENÚ
  public void startMenuMejia() {
    do {
      System.out.println("--------------------------------------------------");
      System.out.println("MENU DE OPCIONES");
      System.out.println("1. Ingreso pacientes");
      System.out.println("2. Ingreso doctores");
      System.out.println("3. Salir");
      System.out.print("Ingresa una opcion (1-3): ");
      optionMenuMejia = scanner.nextInt();
      switch (optionMenuMejia) {
        case 1: {
          handlePatientsMejia();
          break;
        }
        case 2: {
          handleDoctorsMejia();
          break;
        }
        case 3: {
          System.exit(0);//CIERRA EL PROGRAMA
          break;
        }
        default: {
          System.out.println("Opcion invalida");
          break;
        }
      }
    } while (optionMenuMejia != 3);
  }

  //GESTIÓN PACIENTES
  public void handlePatientsMejia() {
    do {
      System.out.println("--------------------------------------------------");
      System.out.println("INGRESO PACIENTES");
      System.out.print("Ingresa cant. pacientes (1-3): ");
      nPatientsMejia = scanner.nextInt();
    } while (nPatientsMejia < 1 || nPatientsMejia > 3);
    for (int i = 0; i < nPatientsMejia; i++) {
      patientMejia = new PatientMejia("", "", "", "", 0);
      System.out.println("Paciente#" + (i + 1));
      patientMejia.getDataPersonMejia();
      patientsMejia.add(patientMejia);
      patientMejia.savePatientMejia();
    }
    //LEE PACIENTES EN LA DB
    patientMejia = new PatientMejia("", "", "", "", 0);
    patientMejia.readPatientMejia();
  }

  //GESTIÓN DOCTORES
  public void handleDoctorsMejia() {
    do {
      System.out.println("--------------------------------------------------");
      System.out.println("INGRESO DOCTORES");
      System.out.print("Ingresa cant. doctores (1-3): ");
      nDoctorsMejia = scanner.nextInt();
    } while (nDoctorsMejia < 1 || nDoctorsMejia > 3);
    for (int i = 0; i < nDoctorsMejia; i++) {
      doctorMejia = new DoctorMejia(0, "", "", "", 0);
      System.out.println("Doctor#" + (i + 1));
      doctorMejia.getDataPersonMejia();
      doctorsMejia.add(doctorMejia);
      doctorMejia.saveDoctorMejia();
    }
    //LEE DOCTORES EN LA DB
    doctorMejia = new DoctorMejia(0, "", "", "", 0);
    doctorMejia.readDoctorMejia();

  }
}
