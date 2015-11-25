import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.List;
/**
 * Created by konrad on 25.11.15.
 */

/** Klasa obslugujaca watki */
class Watki extends Thread {
    /** Adres servera na ktorym bedzie dzialal program */
    ServerSocket server = null;
    /** Client ktory jest polaczony w danym watku */
    Socket client = null;
    /** Buffer sluzacy do odczytu danych wejsciowych-wysylanych od klienta */
    BufferedReader in = null;
    /** Object wysylajacy dane wyjsciowe do klienta */
    PrintWriter out = null;

    public Watki(ServerSocket server, Socket client) {
        this.server = server;
        this.client = client;
        try {
            /** in-bedzie przechwytywalo strumien wyslany od klienta */
            in = new BufferedReader(new InputStreamReader(this.client.getInputStream()));
            /** out bedzie sluzylo jako wysylanie strumienia danych do klienta */
            out = new PrintWriter(client.getOutputStream(), true);
        } catch (IOException e) {
            System.out.println(this.getName() + ": brak dostepu do portu: " + server.getLocalPort());
            this.finalize();
        }
    }
    /** zmienne do wywoływania klasy z kartami
     * poki co, jest tak troche do dupy i server nie zwraca kart do klienta,
     * ale trzeba dorobic chyba najpierw stol, zeby cos z tym dalej robic*/
    private static CreateCards cards= new CreateCards();
    private static GiveCards howMany= new GiveCards();
    List<String> shuffleit;
    List<String> karty;

    /** Metoda uruchamiana przez polecenie start(); przy Watku */
    public void run() {
        System.out.println(this.getName() + ": polaczono z serwerem");
        try{
            shuffleit=cards.initialize();
            Collections.shuffle(shuffleit);
            karty= howMany.giveCard(shuffleit,20);
            /**poki co tak zbieranie wartości kart
             * 0 i 1 dla 1 gracza,... , 19 i 20 dla 10, 21,22,23,24,25 to karty na serverze
             * i chyba  taki sposób będzie najlatwiej je trzymac*/
            System.out.print(karty.get(1)+ karty.get(0));
        }catch (NullPointerException ex){
            System.err.print("nullpointexception");
        }
    }
    /**
     * Metoda ktora finalizuje dany watek, in-zamyka strumien wejscia,
     * out-zamyka strumien wyjscia, client-rozlacza klienta
     */
    protected void finalize() {
        try {
            in.close();
            out.close();
            client.close();

        } catch (IOException e) {
            System.out.println(this.getName() + ": nie udalo sie rozlaczyc");
            System.exit(-1);
        }
    }
}

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
    Watki w;

    /**
     * Metoda ktora bedzie probowala stworzyc nowy Watek i polaczyc klienta z
     * serwerem
     */
    public void Odbierz_polaczenie() {
        try {
            client = server.accept();
            w = new Watki(server, client);
            w.start();
            client = null;
        } catch (IOException e) {
            System.out.println("Accept failed: 44444");
            System.exit(-1);
        }

    }
    /** start servera mainem*/
    public static void main(String[] args) {
        Server serwer = new Server();
        while (client == null)
            serwer.Odbierz_polaczenie();
    }
}
