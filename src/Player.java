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
	private Socket socket;
	String action=" ";
	BufferedReader in = null;
	PrintWriter out = null  ;
	int i= 0;
	String gamer;
	int players[]= new int[10];
	List<String> player= new ArrayList<>();
	public Player(Socket socket) {


		this.server = server;
		this.socket = socket;
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

		try {
			BufferedReader in = new BufferedReader( new InputStreamReader( socket.getInputStream() ) );
			PrintWriter out = new PrintWriter( socket.getOutputStream(), true );


			if(Objects.equals(this.getName(), "Thread-1")){
				this.setName("Player1");
				out.println(getMoney());//juak dawalem tutaj out.print(message), to wywalalo :c
				out.println(this.getName());
				//System.out.print(line+ this.getName());
					//out.flush();
			}
			if(Objects.equals(this.getName(), "Thread-2")){
				this.setName("Player2");
				out.println(this.getName());
				out.println(getMoney());
			}
			if(Objects.equals(this.getName(), "Thread-3")){
				this.setName("Player3");
				out.println(this.getName());
			}
			if(Objects.equals(this.getName(), "Thread-4")){
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
			String line;
			int zaklad;
			while((line = in.readLine()) != null ) {
				System.out.println("Echo: " + line);
				if(line =="bet"){
					zaklad= bet(30);
					out.println(zaklad);
				}

				//out.flush();
				//line = in.readLine();
			}
			in.close();
			out.close();
			socket.close();

		} catch (NullPointerException e) {
			System.err.print("nullpointexception");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}