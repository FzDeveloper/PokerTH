import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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
	static int[] myBet= new int[10];
	static int[] moneyTab= new int[10];
	static String[] gamers= {"Player1","Player2","Player3","Player4","Player5","Player6","Player7","Player8",
			"Player9","Player10",};
	static int[]folds= new int[10];
	private Socket socket;
	Socket client;
	static int countOfPlayers;
	static int pot=0;
	static int highestBet=0;
	static int sb;
	static int bb;
	static int what;
	PrintWriter out;
	BufferedReader in;

	public void howManyPlayers(int hmp){
		if(countOfPlayers==0) {
			countOfPlayers = hmp;
		}
	}

	public void raise(int rai){
		if((moneyTab[valueOfPlayer()]- rai)> 0) {
			pot += rai;
			myBet[valueOfPlayer()]+= myBet[valueOfPlayer()]+ rai;
			moneyTab[valueOfPlayer()]-= rai;
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
		int maxBet= myBet[0];
		for (int max= 0; max< countOfPlayers; ++max){
			if(myBet[max]>maxBet)
				maxBet=myBet[max];
		}
		highestBet= maxBet;
	}
	public void myBet(int bet){
	}
	public void call(){
		if(highestBet-moneyTab[valueOfPlayer()]> 0){
		pot+= highestBet- myBet[valueOfPlayer()];
		moneyTab[valueOfPlayer()]-= highestBet-myBet[valueOfPlayer()];
		}

	}
 	public void checkWinners(){

		clearFolds();
	}
	public void all_in(){
		pot+= moneyTab[valueOfPlayer()];
		moneyTab[valueOfPlayer()]= 0;
	}
	public void shuffleCards(){
		shuffleit = cards.initialize();
		Collections.shuffle(shuffleit);
		karty = howMany.giveCard(shuffleit, 20);
	}

	public void setMoney(int money){
		if((moneyTab[0] &moneyTab[1] &moneyTab[2] &moneyTab[3] &moneyTab[4] &moneyTab[5]
				&moneyTab[6] &moneyTab[7] & moneyTab[8] &moneyTab[9])== 0){
			for(int i= 0;i< 10; ++i){
				moneyTab[i]= money;
			}
		}
	}


	public int getMoney() throws IOException {
		//System.out.print(moneyTab[valueOfPlayer()]);
		//out.println(moneyTab[valueOfPlayer()]);
		//out.flush();
		//out.close();
		//socket.close();
		return moneyTab[valueOfPlayer()];
	}

	public void pot(){
		pot= 0;
	}
	public void check(){
		nextPlayer();
	}
	public void fold(){
		folds[valueOfPlayer()]= 1;
		nextPlayer();
	}
	public void clearFolds(){
		for (int food= 0; food< 10;++food){
			folds[food]= 0;
			myBet[food]= 0;
		}

	}
	public void setPlayer(){
		if(equils== null){
			equils= "Player1";
		}
	}
	public void nextPlayer(){
		int x=0;
		while(!(equils.equals(gamers[x]))){
			++x;
		}
		equils= gamers[(x+1)%10];
		//System.out.println(equils);
	}

	public void bet(int cash) throws IOException {
		PrintWriter out = new PrintWriter( socket.getOutputStream(), true );

		if((moneyTab[valueOfPlayer()]- cash)> 0) {
			pot += cash;
			moneyTab[valueOfPlayer()]-= cash;
			myBet[valueOfPlayer()]+= cash;
		}
		out.println(moneyTab[valueOfPlayer()]);
		out.flush();
		System.out.println(moneyTab[valueOfPlayer()]);


	}
	public void setSmallBlind(){
		if(what !=0){
			sb= 0;
			bb= 1;
			what= 0;

		}
		moneyTab[sb]= moneyTab[sb]- 10;
		pot= pot+ 10;
		sb= (++sb)% 10;
	}
	public void setBigBlind(){
		moneyTab[bb]= moneyTab[bb]- 20;
		pot= pot+ 20;
		bb= (++bb)% 10;

	}
	public void firstRound(){
		setSmallBlind();
		setBigBlind();

	}
	public void secondRound(){

	}
	public void thirdRound(){

	}
	public void fourthRound(){

	}

	public Player(Socket socket) {
		this.socket = socket;
		//String ipAddress = mark.getRemoteAddr();
	}


	/** Metoda uruchamiana przez polecenie start(); przy Watku */
	public void run() {

		try {
			in = new BufferedReader( new InputStreamReader( socket.getInputStream() ) );
			out = new PrintWriter( socket.getOutputStream(), true );
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
			if(equils== null) {
				equils = "Player1";
				guy = "Player1";
			}
			while((line = in.readLine()) != null ) {
				if(line.equals("bet")) {
					betcos();

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

	private void betcos() {
		out.println("Player1c.Ah.Jc");
		out.flush();
	}

}