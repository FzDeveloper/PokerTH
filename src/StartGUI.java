import javax.print.attribute.standard.NumberOfDocuments;
import javax.swing.*;
import java.awt.*;

public class StartGUI extends JFrame {

	public JTextField numberOfPlayers;
	public JTextField money;
	
	public StartGUI(){
		/**
		 * okienko do wprowadzenia parametrów wejœciowych tzn liczby graczy
		 *  i iloœci hajsu przypadaj¹cego na ka¿dego gracza
		 */
		super("Texas Hold'em");
		setVisible(true);
		setSize(240, 270);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JLabel noOfPlayers = new JLabel("Number of players:");
		numberOfPlayers = new JTextField();
		
		add(noOfPlayers);
		add(numberOfPlayers);
		
		noOfPlayers.setBounds(10, 10, 200, 20);
		numberOfPlayers.setBounds(10, 40, 200, 20);
		
		JLabel moneyForAPlayer = new JLabel("Money for each player:");
		money = new JTextField();
		
		add(moneyForAPlayer);
		add(money);
		
		moneyForAPlayer.setBounds(10, 80, 200, 20);
		money.setBounds(10, 120, 200, 20);
		
		JButton ok = new JButton("Ok");
		
		add(ok);
		ok.setBounds(95, 160, 50, 50);
	}


}
