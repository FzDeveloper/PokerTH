import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Player extends Thread {

	private static CreateCards cards= new CreateCards();
	private static GiveCards howMany= new GiveCards();
	List<String> shuffleit;
	List<String> karty;
	static String guy;
	static String equils;
	static int myBet;
	static int[] moneyTab= new int[10];
	static String[] gamers= {"Player1","Player2","Player3","Player4","Player5","Player6","Player7","Player8",
			"Player9","Player10",};
	private Socket socket;
	Socket client;
	static int countOfPlayers;
	static int pot=0;
	static int highestBet=0;
	public void howManyPlayers(int hmp){
		if(countOfPlayers==0) {
			countOfPlayers = hmp;
		}
	}

	public void raise(int rai){
		if((moneyTab[valueOfPlayer()]- rai)> 0) {
			pot += rai;
			moneyTab[valueOfPlayer()] -= rai;
		}

	}
	public int valueOfPlayer(){
		int vop=0;
		if(guy.equals("Player1")){
			vop= 0;
		}if(guy.equals("Player2")){
			vop= 1;
		}if(guy.equals("Player3")){
			vop= 2;
		}if(guy.equals("Player4")){
			vop= 3;
		}if(guy.equals("Player5")){
			vop= 4;
		}if(guy.equals("Player6")){
			vop= 5;
		}if(guy.equals("Player7")){
			vop= 6;
		}if(guy.equals("Player8")){
			vop= 7;
		}if(guy.equals("Player9")){
			vop= 8;
		}if(guy.equals("Player10")){
			vop= 9;
		}
		return vop;
	}
	public void maxBet(){
		int maxBet= moneyTab[0];
		for (int max= 0; max< countOfPlayers; ++max){
			if(moneyTab[max]>maxBet)
				maxBet=moneyTab[max];
		}
		highestBet= maxBet;
	}
	public void myBet(int bet){
		 myBet= bet;
	}
	public void call(){
		if(highestBet-myBet> 0){
		pot+= highestBet- myBet;
		moneyTab[valueOfPlayer()]-= highestBet-myBet;
		myBet=highestBet;
		}

	}
 	public void checkWinners(){

	}
	public void all_in(){
		pot+= moneyTab[valueOfPlayer()];
		moneyTab[valueOfPlayer()]= 0;
	}
	public void shuffleCards(){
		shuffleit = cards.initialize();
		Collections.shuffle(shuffleit);
		this.karty = howMany.giveCard(shuffleit, 20);
	}

	public void setMoney(int money){
		if((moneyTab[0] &moneyTab[1] &moneyTab[2] &moneyTab[3] &moneyTab[4] &moneyTab[5]
				&moneyTab[6] &moneyTab[7] & moneyTab[8] &moneyTab[9])== 0){
			for(int i= 0;i< 10; ++i){
				moneyTab[i]= money;
			}
		}
	}


	public int getMoney(){
		return moneyTab[valueOfPlayer()];
	}

	public void pot(){
		pot= 0;
	}
	public void check(){

	}
	public void fold(){

	}
	public void setPlayer(){
		if(equils== null){
			equils= "Player1";
		}
	}
	public void nextPlayer(){
		int x=0;

		//for( int x= 0; x< 10; ++x){
			while(!(equils.equals(gamers[x]))){
				++x;
			}
		equils= gamers[(x+1)%10];

		System.out.print(equils);
	}

	public void bet(int cash){
		if((moneyTab[valueOfPlayer()]- cash)> 0) {
			pot += cash;
			moneyTab[valueOfPlayer()] -= cash;
		}
	}

	public Player(Socket socket, Socket mark) {
		this.client = mark;
		this.socket = socket;
		//String ipAddress = mark.getRemoteAddr();
	}


	/** Metoda uruchamiana przez polecenie start(); przy Watku */
	public void run() {

		try {
			BufferedReader in = new BufferedReader( new InputStreamReader( socket.getInputStream() ) );
			PrintWriter out = new PrintWriter( socket.getOutputStream(), true );
			InetAddress thisIp = InetAddress.getLocalHost();

			if(Objects.equals(this.getName(), "Thread-1")){
				this.setName("Player1");
				out.println(this.getName());

			}
			if(Objects.equals(this.getName(), "Thread-2")){
				this.setName("Player2");
				out.println(this.getName());
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
			setPlayer();
			while((line = in.readLine()) != null ) {

				if(line.equals("Player1")){
					guy= "Player1";
				}if(line.equals("Player2")){
					guy= "Player2";
				}if(line.equals("Player3")){
					guy= "Player3";
				}if(line.equals("Player4")){
					guy= "Player4";
				}if(line.equals("Player5")){
					guy= "Player5";
				}if(line.equals("Player6")){
					guy= "Player6";
				}if(line.equals("Player7")){
					guy= "Player7";
				}if(line.equals("Player8")){
					guy= "Player8";
				}if(line.equals("Player9")){
					guy= "Player9";
				}if(line.equals("Player10")){
					guy= "Player10";
				}
				if(line.equals("check")& (guy.equals(equils))) {
					check();
					nextPlayer();
				}
				if(line.equals("bet")& (guy.equals(equils))){
					bet(20);
					zaklad = getMoney();
					System.out.println(zaklad);
					nextPlayer();
				}
				if(line.equals("all_in")& (guy.equals(equils))) {
					all_in();
					nextPlayer();
				}
				if(line.equals("fold")& (guy.equals(equils))) {
					fold();
					nextPlayer();
				}
				if(line.equals("raise")& (guy.equals(equils))) {
					raise(30);
					zaklad = getMoney();
					System.out.println(zaklad);
					System.out.println(moneyTab[0]);
					nextPlayer();
				}
				if(line.equals("call")& (guy.equals(equils))) {
					call();
					nextPlayer();
				}
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