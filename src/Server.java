import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * Created by konrad on 25.11.15.
 */
/**
 * Klasa Serwera w ktorej serwer jest uruchamiany na podanym porcie
 */
public class Server extends Thread implements Runnable{
    ServerSocket server = null;
    Socket client = null;
    BufferedReader in;
    PrintWriter out;
    private boolean running = false;
    private int port;
    private int money;
    private int players;
    Player w;

    public Server(int port) {
        this.port = port;
    }

    public void startServer(int players, int money) {
        try {
            /** Probujemy utworzyc nowy serwer na danym porcie */
            server = new ServerSocket(44444);
            this.start();
            this.money= money;
            this.players= players;

            System.out.println("Uruchomiono serwer na porcie: " + 44444);
        } catch (IOException e) {
            System.out.println("Blad polaczenia na porcie " + 44444);
            System.exit(-1);
        }

    }

    public void stopServer() {
        running = false;
        this.interrupt();
    }

    public void run() {
        running = true;
        while (true) {
            try {
                Socket socket = server.accept();

                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream());
                Player requestHandler = new Player(socket, client);
                requestHandler.start();
                requestHandler.setMoney(money);
                requestHandler.howManyPlayers(players);
                
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    /** start servera mainem*/
    /*public static void main() throws IOException {

        Server server = new Server(44444);
        server.startServer();
        try {
            Thread.sleep( 60000 );
        } catch( Exception e ) {
            e.printStackTrace();
        }

        server.stopServer();
    }*/
}