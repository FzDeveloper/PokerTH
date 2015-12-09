
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TableGUI extends JFrame implements KeyListener,ComponentListener, ActionListener {

	public TableGUI(){
		//super("Texas Hold'em");
		/**
		 * gui sto�u, karty s� jlabelami, z boku przyciski do licytacji i jtextarea, w kt�rym b�dzie wy�wietlana
		 * ilo� hajsu w puli podczas licytacji, na razie nie powala pi�kno�ci� dlatego, �e w tle 
		 * i na miejscu kart powinny byc jpgi
		 * ale o to zadbam �eby by�y
		 */
		
		setSize(1320, 760);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//ImageIcon background = new ImageIcon("C:\\Users\\Ja\\workspace\\PokerTH\\trunk\\src\\images\background.jpg");
		//setLayout(new GridLayout(2,1));

		JLayeredPane layer = new JLayeredPane();
		
		add(layer);
		
		JLabel player01 = new JLabel("Nick Player01");
		JLabel player02 = new JLabel("Nick Player02");
		JLabel player03 = new JLabel("Nick Player03");
		JLabel player04 = new JLabel("Nick Player04");
		JLabel player05 = new JLabel("Nick Player05");
		JLabel player06 = new JLabel("Nick Player06");
		JLabel player07 = new JLabel("Nick Player07");
		JLabel player08 = new JLabel("Nick Player08");
		JLabel player09 = new JLabel("Nick Player09");
		JLabel player10 = new JLabel("Nick Player10");
		
		JButton check = new JButton("Check");
		JButton bet = new JButton("Bet");
		JButton raise = new JButton("Raise");
		JButton call = new JButton("Call");
		JButton fold = new JButton("Fold");
		JButton allin = new JButton("All-in");
		JButton join = new JButton("Join");
		JButton leave = new JButton("Log out");
		
		JLabel stake = new JLabel("W puli:");
		
		layer.add(stake, new Integer(1));
		
		stake.setBounds(1200, 500, 100, 20);
		
		JTextArea stakes = new JTextArea();
		
		layer.add(stakes, new Integer(1));
		
		stakes.setBounds(1200, 530, 100, 40);
		
		stakes.setEditable(false);
		
		layer.add(check, new Integer(1));
		layer.add(bet, new Integer(1));
		layer.add(raise, new Integer(1));
		layer.add(call, new Integer(1));
		layer.add(fold, new Integer(1));
		layer.add(allin, new Integer(1));
		//layer.add(join, new Integer(1));
		//layer.add(leave, new Integer(1));
		
		check.setBounds(1200, 20, 100, 60);
		bet.setBounds(1200, 100, 100, 60);
		raise.setBounds(1200, 180, 100, 60);
		call.setBounds(1200, 260, 100, 60);
		fold.setBounds(1200, 340, 100, 60);
		allin.setBounds(1200, 420, 100, 60);
		join.setBounds(1200, 520, 100, 60);
		leave.setBounds(1200, 520, 100, 60);
		
		layer.add(player01, new Integer(1));
		layer.add(player02, new Integer(1));
		layer.add(player03, new Integer(1));
		layer.add(player04, new Integer(1));
		layer.add(player05, new Integer(1));
		layer.add(player06, new Integer(1));
		layer.add(player07, new Integer(1));
		layer.add(player08, new Integer(1));
		layer.add(player09, new Integer(1));
		layer.add(player10, new Integer(1));
		
		player01.setBounds(20, 300, 100, 20);
		player02.setBounds(20, 600, 100, 20);
		player03.setBounds(275, 700, 100, 20);
		player04.setBounds(405, 700, 100, 20);
		player05.setBounds(540, 700, 100, 20);
		player06.setBounds(770, 600, 100, 20);
		player07.setBounds(760, 300, 100, 20);
		player08.setBounds(540, 15, 100, 20);
		player09.setBounds(405, 15, 100, 20);
		player10.setBounds(275, 15, 100, 20);
		
		JLabel player01card01 = new JLabel("karta");
		JLabel player01card02 = new JLabel();
		
		layer.add(player01card01, new Integer(1));
		layer.add(player01card02, new Integer(2));
		
		player01card01.setBounds(20, 166, 80, 130);
		player01card01.setOpaque(true);
		player01card01.setBackground(Color.RED);
		
		player01card02.setBounds(50, 121, 80, 130);
		player01card02.setOpaque(true);
		player01card02.setBackground(Color.RED);
		
		JLabel player02card01 = new JLabel("karta");
		JLabel player02card02 = new JLabel();
		
		layer.add(player02card01, new Integer(1));
		layer.add(player02card02, new Integer(2));
		
		player02card01.setBounds(20, 466, 80, 130);
		player02card01.setOpaque(true);
		player02card01.setBackground(Color.RED);
		
		player02card02.setBounds(50, 421, 80, 130);
		player02card02.setOpaque(true);
		player02card02.setBackground(Color.RED);
		
		JLabel player03card01 = new JLabel("karta");
		JLabel player03card02 = new JLabel();
		
		layer.add(player03card01, new Integer(1));
		layer.add(player03card02, new Integer(2));
		
		player03card01.setBounds(190, 566, 80, 130);
		player03card01.setOpaque(true);
		player03card01.setBackground(Color.RED);
		
		player03card02.setBounds(220, 521, 80, 130);
		player03card02.setOpaque(true);
		player03card02.setBackground(Color.RED);
		
		JLabel player04card01 = new JLabel("karta");
		JLabel player04card02 = new JLabel();
		
		layer.add(player04card01, new Integer(1));
		layer.add(player04card02, new Integer(2));
		
		player04card01.setBounds(340, 566, 80, 130);
		player04card01.setOpaque(true);
		player04card01.setBackground(Color.RED);
		
		player04card02.setBounds(390, 521, 80, 130);
		player04card02.setOpaque(true);
		player04card02.setBackground(Color.RED);
		
		JLabel player05card01 = new JLabel("karta");
		JLabel player05card02 = new JLabel();
		
		layer.add(player05card01, new Integer(1));
		layer.add(player05card02, new Integer(2));
		
		player05card01.setBounds(530, 566, 80, 130);
		player05card01.setOpaque(true);
		player05card01.setBackground(Color.RED);
		
		player05card02.setBounds(560, 521, 80, 130);
		player05card02.setOpaque(true);
		player05card02.setBackground(Color.RED);
		
		JLabel player06card01 = new JLabel("karta");
		JLabel player06card02 = new JLabel();
		
		layer.add(player06card01, new Integer(1));
		layer.add(player06card02, new Integer(2));
		
		player06card01.setBounds(730, 466, 80, 130);
		player06card01.setOpaque(true);
		player06card01.setBackground(Color.RED);
		
		player06card02.setBounds(770, 421, 80, 130);
		player06card02.setOpaque(true);
		player06card02.setBackground(Color.RED);
		
		JLabel player07card01 = new JLabel("karta");
		JLabel player07card02 = new JLabel();
		
		layer.add(player07card01, new Integer(1));
		layer.add(player07card02, new Integer(2));
		
		player07card01.setBounds(730, 166, 80, 130);
		player07card01.setOpaque(true);
		player07card01.setBackground(Color.RED);
		
		player07card02.setBounds(770, 121, 80, 130);
		player07card02.setOpaque(true);
		player07card02.setBackground(Color.RED);
		
		JLabel player08card01 = new JLabel("karta");
		JLabel player08card02 = new JLabel();
		
		layer.add(player08card01, new Integer(1));
		layer.add(player08card02, new Integer(2));
		
		player08card01.setBounds(530, 106, 80, 130);
		player08card01.setOpaque(true);
		player08card01.setBackground(Color.RED);
		
		player08card02.setBounds(560, 61, 80, 130);
		player08card02.setOpaque(true);
		player08card02.setBackground(Color.RED);
		
		JLabel player09card01 = new JLabel("karta");
		JLabel player09card02 = new JLabel();
		
		layer.add(player09card01, new Integer(1));
		layer.add(player09card02, new Integer(2));
		
		player09card01.setBounds(340, 106, 80, 130);
		player09card01.setOpaque(true);
		player09card01.setBackground(Color.RED);
		
		player09card02.setBounds(390, 61, 80, 130);
		player09card02.setOpaque(true);
		player09card02.setBackground(Color.RED);
		
		JLabel player10card01 = new JLabel("karta");
		JLabel player10card02 = new JLabel();
		
		layer.add(player10card01, new Integer(1));
		layer.add(player10card02, new Integer(2));
		
		player10card01.setBounds(190, 106, 80, 130);
		player10card01.setOpaque(true);
		player10card01.setBackground(Color.RED);
		
		player10card02.setBounds(220, 61, 80, 130);
		player10card02.setOpaque(true);
		player10card02.setBackground(Color.RED);
		
		JLabel flopcard01 = new JLabel();
		JLabel flopcard02 = new JLabel();
		JLabel flopcard03 = new JLabel();
		JLabel flopcard04 = new JLabel();
		JLabel flopcard05 = new JLabel();
		
		layer.add(flopcard01, new Integer(1));
		layer.add(flopcard02, new Integer(1));
		layer.add(flopcard03, new Integer(1));
		layer.add(flopcard04, new Integer(1));
		layer.add(flopcard05, new Integer(1));
		
		flopcard01.setBounds(300, 305, 80, 130);
		flopcard02.setBounds(390, 305, 80, 130);
		flopcard03.setBounds(480, 305, 80, 130);
		flopcard04.setBounds(570, 305, 80, 130);
		flopcard05.setBounds(660, 305, 80, 130);
		
		flopcard01.setOpaque(true);
		flopcard02.setOpaque(true);
		flopcard03.setOpaque(true);
		flopcard04.setOpaque(true);
		flopcard05.setOpaque(true);
		
		flopcard01.setBackground(Color.BLUE);
		flopcard02.setBackground(Color.BLUE);
		flopcard03.setBackground(Color.BLUE);
		flopcard04.setBackground(Color.BLUE);
		//flopcard05.setBackground(Color.BLUE);
		setVisible(true);


	}
	public void main(){
		TableGUI startTable = new TableGUI();

	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {

		if(actionEvent.getActionCommand().equals("Bet")){
			System.out.print("cokolwiek");
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
