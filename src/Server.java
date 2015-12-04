import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * Created by konrad on 25.11.15.
 */
/**
 * Klasa Serwera w ktorej serwer jest uruchamiany na podanym porcie
 */
public class Server {
    /** Tworzymy wtyczke servera ktora chwilowo jest pusta */
    ServerSocket server = null;
    /** Tworzymy wtyczke client ktory takze jest chwilowo pusty */
    static Socket client = null;

    public Server() {
        try {
            /** Probujemy utworzyc nowy serwer na danym porcie */
            server = new ServerSocket(44444);
            System.out.println("Uruchomiono serwer na porcie: " + 44444);
        } catch (IOException e) {
            System.out.println("Blad polaczenia na porcie " + 44444);
            System.exit(-1);
        }

    }

    /** Deklarujemy klase watki */
    Player w;

    /**
     * Metoda ktora bedzie probowala stworzyc nowy Watek i polaczyc klienta z
     * serwerem
     */
    public void Odbierz_polaczenie() {
        while (true) {
            try {
                client = server.accept();
                w = new Player(server, client);
                w.start();
                client = null;
            } catch (IOException e) {
                System.out.println("Accept failed: 44444");
                System.exit(-1);
            }
        }
    }
    /** start servera mainem*/
    public static void main(String[] args) {
        //StartGUI startGUI= new StartGUI();
        //TableGUI startTable= new TableGUI();
       // Server serwer = new Server();


        //while (client == null)
          //  serwer.Odbierz_polaczenie();

    }
}
