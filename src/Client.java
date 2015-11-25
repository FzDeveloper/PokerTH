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
    /** Strumien wyjscia, bedzie sluzyl do wysylania strumienia danych na serwer */
    static PrintWriter out = null;
    /**
     * Strumien wejscia, bedzie sluzyl do odbierania strumienia danych wyslanego
     * z serwera
     */
    static BufferedReader in = null;

    /**
     * Metoda ktora przechwytuje podany host i port, a nastepnie probuje
     * ustanowic polaczenie z serwerem, w razie niepowodzenia zaznacza
     * odpowiednie pole na rozowo i wyswietla odpowiedni komunikat.
     */
    public static void Client() {


            try {

                socket = new Socket(InetAddress.getLocalHost(), 44444);
                listenSocket();

            } catch (UnknownHostException e) {
                System.out.print("Nieznany host");
            } catch (IOException e) {
                System.out.print("Brak polaczenia, sprawdz serwer");
            }
    }

    /**
     * Metoda ktora sluzy do wymiany strumieni danych pomiedzy serwerem a
     * klientem
     */
    public static void listenSocket() {
        try {
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (UnknownHostException e) {
            System.out.print("Nieznany host");
        } catch (IOException e) {
            System.out.print("Brak polaczenia, sprawdz serwer");
        }
    }
    public static void main(String[] args) {
        Client();

    }
}
