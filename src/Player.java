
public class Player {


	String nick;
	int money;
	
	public Player(String nick, int money){
		this.nick = nick;
		this.money = money;
	}
	
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
	

}


