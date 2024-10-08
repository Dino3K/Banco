import java.util.Scanner;

public class Cuenta {
    // Atributos de la clase CuentaB
    String nombreU;
    String numeroC;
    String banco;
    int dinero;



    // Constructor de la clase Cuenta
    public Cuenta(String nombreU, String numeroC, String banco, int dinero) {
        this.nombreU = nombreU;
        this.numeroC = numeroC;
        this.banco = banco;
        this.dinero = dinero;
    }

    // Método para obtener la información de la cuenta
    public void mostrarInfo() {
        System.out.println("Nombre: " + nombreU);
        System.out.println("Numero de cuenta: " + numeroC);
        System.out.println("Banco: " + banco);
        System.out.println("Dinero: " + dinero);
    }

    // Métodos getters y setters
    public String getnombreU() {
        return nombreU;
    }
    public void setnombreU(String nombreU) {
        this.nombreU = nombreU;
    }
    public String getnumeroC() {
        return numeroC;
    }
    public void setnumeroC(String numeroC) {
        this.numeroC = numeroC;
    }
    public String getbanco() {
        return banco;
    }
    public void setbanco(String banco) {
        this.banco = banco;
    }


    // Método para crear una cuenta solicitando datos al usuario
    public static Cuenta crearCuenta() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese su Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese su numero telefonico: ");
        String numcuenta = scanner.nextLine();
        System.out.print("Ingrese el banco: ");
        String banco = scanner.nextLine();
        System.out.print("Ingrese el dinero: ");
        int dinero = 0;
        return new Cuenta(nombre, numcuenta, banco, dinero);
    }
    public int getDinero() {
        return dinero;
    }
    public void setDinero(int dinero) {
        this.dinero = dinero;
    }
    public void ingresarD(Double C) {
        dinero += C;
    }
    public void retirarD(Double C) {
        if (dinero >= C) {
            dinero -= C;
        }else {
            System.out.println("Fondos Insuficientes");
        }
    }
}