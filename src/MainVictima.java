import java.util.Scanner;

/**
 * Created by porfirio on 3/23/17.
 */
public class MainVictima {
    public static void main(String[] args) {
        Victima victima = new Victima();
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Víctima> Ingresa el nombre del archivo que " +
                    "deseas enviar: ");
            victima.sendFile(scanner.nextLine());
        } catch (Exception e) {
            System.err.println("ERROR: " + e);
        }
    }
}
