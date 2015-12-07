import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Player extends Thread {


	String nick;
	int money;

	//public Player(int number){
	//	this.nick = nick;
	//	this.money = money;
	//}

	public void setNick(String nick){
		this.nick = nick;
	}

	public String getNick(){
		return this.nick;
	}

	public void setMoney(int money){
		this.money = money;
	}

	public int getMoney(){
		return this.money;
	}

	public int bet(int cash){
		money= money- cash;
		return this.money;
	}

	ServerSocket server = null;
	Socket client = null;
	String action=" ";
	BufferedReader in = null;
	PrintWriter out = null  ;
	int i= 0;
	String gamer;
	int players[]= new int[10];
	List<String> player= new ArrayList<>();
	public Player(ServerSocket server, Socket client) {
		try {
			in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			out = new PrintWriter(client.getOutputStream(), true);

			this.server = server;
			this.client = client;
		} catch (IOException e) {
			System.out.println(this.getName() + ": brak dostepu do portu: " + server.getLocalPort());
			this.finalize();
		}
	}
	private static CreateCards cards= new CreateCards();
	private static GiveCards howMany= new GiveCards();
	List<String> shuffleit;
	List<String> karty;

	/** Metoda uruchamiana przez polecenie start(); przy Watku */
	public void run() {
		//System.out.println(this.getName() + ": polaczono z serwerem");
		shuffleit = cards.initialize();
		Collections.shuffle(shuffleit);
		karty = howMany.giveCard(shuffleit, 20);
		 while(true) {
		try {
			if(Objects.equals(this.getName(), "Thread-0")){
				this.setName("Player1");
				out.println(this.getName());
				//System.out.print(money+"\n");

			}
			if(Objects.equals(this.getName(), "Thread-1")){
				this.setName("Player2");
				out.println(this.getName());
			}
			if(Objects.equals(this.getName(), "Thread-2")){
				this.setName("Player3");
				out.println(this.getName());
			}
			if(Objects.equals(this.getName(), "Thread-3")){
				this.setName("Player4");
				out.println(this.getName());
			}
			if(Objects.equals(this.getName(), "Thread-4")){
				this.setName("Player5");
				out.println(this.getName());
			}
			if(Objects.equals(this.getName(), "Thread-5")){
				this.setName("Player6");
				out.println(this.getName());
			}
			if(Objects.equals(this.getName(), "Thread-6")){
				this.setName("Player7");
				out.println(this.getName());
			}
			if(Objects.equals(this.getName(), "Thread-7")){
				this.setName("Player8");
				out.println(this.getName());
			}
			if(Objects.equals(this.getName(), "Thread-8")){
				this.setName("Player9");
				out.println(this.getName());
			}
			if(Objects.equals(this.getName(), "Thread-9")){
				this.setName("Player10");
				out.println(this.getName());
			}
		}
		catch (NullPointerException e) {
			System.err.print("nullpointexception");
		}
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