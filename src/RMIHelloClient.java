import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

/**
 * Created by dremo on 22/02/2016.
 */
public class RMIHelloClient {

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        RMIServerInterficie calcular;

        boolean continuar = true;

        while (continuar) {

            try{

                System.out.println("Localitzant registre d'objectes remots ...");
                Registry registry = LocateRegistry.getRegistry("localhost",5555);

                calcular = (RMIServerInterficie) registry.lookup("interface");

                System.out.println("Tria una opció-\n 1.Sumar\n 2.Restar\n 3.Dividir\n 4.Multiplicar\n 5.Sortir");
                String respuesta = in.next();

                System.out.println("Obtenint l'objecte remot...");

                if (calcular != null) {

                    System.out.println("Introdueix la operacio a realitzar ");
                    String input = in.next();

                    System.out.println("Realitzant operacions...");
                    System.out.println("El resultat és:");

                    switch (respuesta) {
                        case "1":
                            System.out.println(calcular.suma(input));
                            break;
                        case "2":
                            System.out.println(calcular.resta(input));
                            break;
                        case "3":
                            System.out.println(calcular.divisio(input));
                            break;
                        case "4":
                            System.out.println(calcular.multiplicacio(input));
                            break;
                        case "5":
                            continuar = false;
                            break;
                    }
                }

            } catch (RemoteException | NotBoundException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Fi del programa");
    }
}