/**
 * Created by konrad on 25.11.15.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client  {
    /**
     * Wtyczka, ktora sluzy do laczenia sie z serwerem. Zawiera takie dane jak
     * nazwa hosta i port serwera
     */
    static Socket socket;
    static PrintWriter out;
    static BufferedReader in;


    /**
     * Metoda ktora przechwytuje podany host i port, a nastepnie probuje
     * ustanowic polaczenie z serwerem, w razie niepowodzenia zaznacza
     * odpowiednie pole na rozowo i wyswietla odpowiedni komunikat.
     */
    public static boolean Client() {


        try {

            socket = new Socket(InetAddress.getLocalHost(), 44444);
            listenSocket();

        } catch (UnknownHostException e) {
            System.out.print("Nieznany host");
        } catch (IOException e) {
            System.out.print("Brak polaczenia, sprawdz serwer");
        }
        return false;
    }
    public String Player1;
    /**
     * Metoda ktora sluzy do wymiany strumieni danych pomiedzy serwerem a
     * klientem
     */
    Player w;
    public static boolean listenSocket() {
        TableGUI startTable = new TableGUI();
        while(true) {
            try {

                out = new PrintWriter(socket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                String input = in.readLine();
                //System.out.print(input);//br.readLine();
                //if(input=="Player1"){
                out.println("bet");
                out.flush();
                //}


            } catch (UnknownHostException e) {
                System.out.print("Nieznany host");
            } catch (IOException e) {
                System.out.print("Brak polaczenia, sprawdz serwer");
            }
            return false;
        }
    }
    public void sendAction(String action){

    }
   /* public static void main(String[] args) {
        //StartGUI startGUI= new StartGUI();
        //Client();
        ChoosenWindow choose= new ChoosenWindow();*/
    // }
}
