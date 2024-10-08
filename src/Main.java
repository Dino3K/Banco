import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        // Lista para almacenar objetos de la clase cuentas
        ArrayList<Cuenta> cuentas = new ArrayList<>();
        Scanner objetoLector = new Scanner(System.in);
        int opcion;

        do {
            // Menú de opciones
            System.out.println("\n---- Menú ----");
            System.out.println("1. Crear nueva cuenta");
            System.out.println("2. Mostrar cuentas");
            System.out.println("3. Ingresar a la cuenta");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = objetoLector.nextInt();

            switch (opcion) {
                case 1: // Crear una nueva cuenta
                    Cuenta nuevaCuenta = Cuenta.crearCuenta();
                    cuentas.add(nuevaCuenta);
                    System.out.println("Cuenta creada con exito");
                    break;
                case 2: // Mostrar todas las cuentas
                    if (cuentas.isEmpty()) {
                        System.out.println("No hay cuentas registradas.");
                    } else {
                        System.out.println("\n---- Lista de cuentas ----");
                        for (int i = 0; i < cuentas.size(); i++) {
                            System.out.println("Cuenta #" + (i + 1) + ":");
                            cuentas.get(i).mostrarInfo();
                            System.out.println(); // Espacio entre cuentas
                        }
                    }
                    break;
                case 3:
                    boolean encontrado = false;
                    String numCuentaBuscar;

                    do {
                        System.out.print("Ingrese número de cuenta: ");
                        numCuentaBuscar = objetoLector.nextLine();

                        for (Cuenta cuenta : cuentas) {
                            if (Objects.equals(cuenta.getnumeroC(), numCuentaBuscar)) {
                                encontrado = true;
                                // Acciones
                                System.out.println("Cuenta encontrada. Bienvenido "+cuenta.getnombreU()+"!");
                                int opC;
                                do{
                                    System.out.println("1. Ingresar dinero");
                                    System.out.println("2. Retirar dinero");
                                    System.out.println("3. Ver saldo");
                                    System.out.println("4. Salir");
                                    System.out.println("");

                                    opC = objetoLector.nextInt();
                                    switch (opC) {
                                        case 1:
                                            System.out.println("Cantidad a ingresar: ");
                                            double cantidad = objetoLector.nextDouble();
                                            cuenta.ingresarD(cantidad);
                                            break;
                                        case 2:
                                            System.out.println("Cantidad a retirar: ");
                                            double cantidadR = objetoLector.nextDouble();
                                            cuenta.retirarD(cantidadR);
                                            break;
                                        case 3:
                                            System.out.println("Saldo acutal: "+cuenta.getDinero());
                                            break;
                                        case 4:
                                            System.out.println("Saliendo");
                                            System.out.println("");
                                            break;
                                        default:
                                            System.out.println("Opcion invalida");
                                    }
                                }while (opC != 4);
                                break; // Salir del bucle for
                            }
                        }

                        if (!encontrado) {
                            System.out.println("Número de cuenta no encontrado. Intente nuevamente.");
                        }
                    } while (!encontrado);



                case 4: // Salir del programa
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 4);

        objetoLector.close();
    }
}