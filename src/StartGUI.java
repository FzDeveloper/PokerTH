import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StartGUI extends JFrame implements KeyListener,ComponentListener, ActionListener {

	public JTextField numberOfPlayers;
	public JTextField money;
    String cash;
    String participants;
	public StartGUI(){
		/**
		 * okienko do wprowadzenia parametr�w wej�ciowych tzn liczby graczy
		 *  i ilo�ci hajsu przypadaj�cego na ka�dego gracza
		 */
		super("Texas Hold'em");
		setVisible(true);
		setSize(240, 270);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setVisible(true);
		panel.setLayout(new GridLayout(2,1));
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
		
		JButton ok = new JButton("Utworz");
		
		add(ok);
		ok.addActionListener(this);
		ok.setBounds(95, 160, 50, 50);
	}
	public static void main(String[] args) {
		StartGUI startGUI= new StartGUI();

	}
	@Override
	public void actionPerformed(ActionEvent actionEvent) {
        Player requestHandler= null;
		if(actionEvent.getActionCommand().equals("Utworz")){
			//Server serwer = null;
			//Server serwer = new Server();
			Server server = new Server(44444);

            cash= money.getText();
            participants= numberOfPlayers.getText();

            server.startServer(Integer.parseInt(participants),Integer.parseInt(cash));

            try {
				Thread.sleep(60000);
			} catch( Exception e ) {
				e.printStackTrace();
			}

			server.stopServer();
		}

	}

	@Override
	public void componentResized(ComponentEvent componentEvent) {

	}

	@Override
	public void componentMoved(ComponentEvent componentEvent) {

	}

	@Override
	public void componentShown(ComponentEvent componentEvent) {

	}

	@Override
	public void componentHidden(ComponentEvent componentEvent) {

	}

	@Override
	public void keyTyped(KeyEvent keyEvent) {

	}

	@Override
	public void keyPressed(KeyEvent keyEvent) {

	}

	@Override
	public void keyReleased(KeyEvent keyEvent) {
	}
}
