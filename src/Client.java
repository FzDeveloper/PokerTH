/**
 * Created by konrad on 25.11.15.
 */

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client extends JFrame implements Runnable, ActionListener {
    Socket socket;
    PrintWriter out;
    BufferedReader in;
    static String player;
    static String pot;
    JButton check = new JButton("Check");
    JButton bet = new JButton("Bet");
    JButton raise = new JButton("Raise");
    JButton call = new JButton("Call");
    JButton fold = new JButton("Fold");
    JButton allin = new JButton("All-in");
    JButton join = new JButton("Join");
    JButton leave = new JButton("Log out");
    JLabel stake = new JLabel("W puli:");
    ChangeCard cardLay= new ChangeCard();
    public void TableGUI() throws IOException {


    }

    @Override
    public void run() {
        //super("Texas Hold'em");
        setSize(1320, 760);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        JLayeredPane layer = new JLayeredPane();

        add(layer);

        ImageIcon card = new ImageIcon("src/images/card.jpg");
        ImageIcon card2 = new ImageIcon("src/images/card_00.png");


        ImageIcon backgroundimage = new ImageIcon("src/images/background.jpg");
        JLabel background = new JLabel(backgroundimage);
        background.setBounds(0, 0, 1320, 760);

        layer.add(background, new Integer(0));

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


        layer.add(stake, new Integer(1));

        stake.setBounds(1060, 500, 100, 20);

        JTextArea stakes = new JTextArea();

        layer.add(stakes, new Integer(1));

        stakes.setBounds(1050, 530, 100, 40);

        stakes.setEditable(false);


        layer.add(check, new Integer(1));
        layer.add(bet, new Integer(1));
        layer.add(raise, new Integer(1));
        layer.add(call, new Integer(1));
        layer.add(fold, new Integer(1));
        layer.add(allin, new Integer(1));
        //layer.add(join, new Integer(1));
        //layer.add(leave, new Integer(1));

        check.setBounds(1050, 20, 100, 60);
        bet.setBounds(1050, 100, 100, 60);
        raise.setBounds(1050, 180, 100, 60);
        call.setBounds(1050, 260, 100, 60);
        fold.setBounds(1050, 340, 100, 60);
        allin.setBounds(1050, 420, 100, 60);
        join.setBounds(1050, 520, 100, 60);
        leave.setBounds(1050, 520, 100, 60);

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

        JLabel player01card01 = new JLabel(card);
        JLabel player01card02 = new JLabel(card);

        layer.add(player01card01, new Integer(1));
        layer.add(player01card02, new Integer(2));

        player01card01.setBounds(20, 166, 80, 115);
        player01card01.setOpaque(true);

        player01card02.setBounds(50, 121, 80, 115);
        player01card02.setOpaque(true);

        JLabel player02card01 = new JLabel(card);
        JLabel player02card02 = new JLabel(card);

        layer.add(player02card01, new Integer(1));
        layer.add(player02card02, new Integer(2));

        player02card01.setBounds(20, 466, 80, 115);
        player02card01.setOpaque(true);

        player02card02.setBounds(50, 421, 80, 115);
        player02card02.setOpaque(true);

        JLabel player03card01 = new JLabel(card);
        JLabel player03card02 = new JLabel(card);

        layer.add(player03card01, new Integer(1));
        layer.add(player03card02, new Integer(2));

        player03card01.setBounds(190, 566, 80, 115);
        player03card01.setOpaque(true);

        player03card02.setBounds(220, 521, 80, 115);
        player03card02.setOpaque(true);

        JLabel player04card01 = new JLabel(card);
        JLabel player04card02 = new JLabel(card);

        layer.add(player04card01, new Integer(1));
        layer.add(player04card02, new Integer(2));

        player04card01.setBounds(340, 566, 80, 115);
        player04card01.setOpaque(true);

        player04card02.setBounds(390, 521, 80, 115);
        player04card02.setOpaque(true);

        JLabel player05card01 = new JLabel(card);
        JLabel player05card02 = new JLabel(card);

        layer.add(player05card01, new Integer(1));
        layer.add(player05card02, new Integer(2));

        player05card01.setBounds(530, 566, 80, 115);
        player05card01.setOpaque(true);

        player05card02.setBounds(560, 521, 80, 115);
        player05card02.setOpaque(true);

        JLabel player06card01 = new JLabel(card);
        JLabel player06card02 = new JLabel(card);

        layer.add(player06card01, new Integer(1));
        layer.add(player06card02, new Integer(2));

        player06card01.setBounds(730, 466, 80, 115);
        player06card01.setOpaque(true);

        player06card02.setBounds(770, 421, 80, 115);
        player06card02.setOpaque(true);

        JLabel player07card01 = new JLabel(card);
        JLabel player07card02 = new JLabel(card);

        layer.add(player07card01, new Integer(1));
        layer.add(player07card02, new Integer(2));

        player07card01.setBounds(730, 166, 80, 115);
        player07card01.setOpaque(true);

        player07card02.setBounds(770, 121, 80, 115);
        player07card02.setOpaque(true);

        JLabel player08card01 = new JLabel(card);
        JLabel player08card02 = new JLabel(card);

        layer.add(player08card01, new Integer(1));
        layer.add(player08card02, new Integer(2));

        player08card01.setBounds(530, 106, 80, 115);
        player08card01.setOpaque(true);

        player08card02.setBounds(560, 61, 80, 115);
        player08card02.setOpaque(true);

        JLabel player09card01 = new JLabel(card);
        JLabel player09card02 = new JLabel(card);

        layer.add(player09card01, new Integer(1));
        layer.add(player09card02, new Integer(2));

        player09card01.setBounds(340, 106, 80, 115);
        player09card01.setOpaque(true);

        player09card02.setBounds(390, 61, 80, 115);
        player09card02.setOpaque(true);

        JLabel player10card01 = new JLabel(card);
        JLabel player10card02 = new JLabel(card);

        layer.add(player10card01, new Integer(1));
        layer.add(player10card02, new Integer(2));

        player10card01.setBounds(190, 106, 80, 115);
        player10card01.setOpaque(true);

        player10card02.setBounds(220, 61, 80, 115);
        player10card02.setOpaque(true);

        JLabel flopcard01 = new JLabel(card);
        JLabel flopcard02 = new JLabel(card);
        JLabel flopcard03 = new JLabel(card);
        JLabel flopcard04 = new JLabel(card);
        JLabel flopcard05 = new JLabel(card);

        layer.add(flopcard01, new Integer(1));
        layer.add(flopcard02, new Integer(1));
        layer.add(flopcard03, new Integer(1));
        layer.add(flopcard04, new Integer(1));
        layer.add(flopcard05, new Integer(1));

        flopcard01.setBounds(220, 305, 80, 115);
        flopcard02.setBounds(310, 305, 80, 115);
        flopcard03.setBounds(400, 305, 80, 115);
        flopcard04.setBounds(490, 305, 80, 115);
        flopcard05.setBounds(580, 305, 80, 115);

        flopcard01.setOpaque(true);
        flopcard02.setOpaque(true);
        flopcard03.setOpaque(true);
        flopcard04.setOpaque(true);
        flopcard05.setOpaque(true);

        setVisible(true);
        bet.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                out.println(player + ".bet");
                out.flush();
            }
        });
        call.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                out.println(player + ".call");
                out.flush();
            }
        });
        check.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                out.println(player + ".check");
                out.flush();
            }
        });
        fold.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                out.println(player + ".fold");
                out.flush();
            }
        });
        raise.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                out.println(player+".raise");
                out.flush();
            }
        });
        allin.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                out.println(player+".allin");
                out.flush();
            }
        });

        while (true){
            String line;
            try {
                /*Socket */
                socket = new Socket(InetAddress.getLocalHost(), 44444);
                out = new PrintWriter(socket.getOutputStream());
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                while ((line = in.readLine()) != null) {
                    String wejscie= in.readLine();
                    String[] data= wejscie.split("\\.");
                    System.out.println(wejscie+" "+data[0]+" "+data[1]+" "+data[2]);
                    if (line.equals("Player1")) {
                        player = "Player1";
                    }
                    if (line.equals("Player2")) {
                        player = "Player2";
                    }
                    if (line.equals("Player3")) {
                        player = "Player3";
                    }
                    if (line.equals("Player4")) {
                        player = "Player4";
                    }
                    if (line.equals("Player5")) {
                        player = "Player5";
                    }
                    if (line.equals("Player6")) {
                        player = "Player6";
                    }
                    if (line.equals("Player7")) {
                        player = "Player7";
                    }
                    if (line.equals("Player8")) {
                        player = "Player8";
                    }
                    if (line.equals("Player9")) {
                        player = "Player9";
                    }
                    if (line.equals("Player10")) {
                        player = "Player10";
                    }
                    if(data[0].equals("Player1") && player.equals("Player1")){
                        player01card01.setIcon(cardLay.cardLayout(data[1]));
                        player01card02.setIcon(cardLay.cardLayout(data[2]));
                        player01.setText("Player1 money");

                    }if(data[0].equals("Player2") && player.equals("Player2")){
                        player02card01.setIcon(cardLay.cardLayout(data[1]));
                        player02card02.setIcon(cardLay.cardLayout(data[2]));
                    }if(data[0].equals("Player3") && player.equals("Player3")){
                        player03card01.setIcon(cardLay.cardLayout(data[1]));
                        player03card02.setIcon(cardLay.cardLayout(data[2]));
                    }if(data[0].equals("Player4") && player.equals("Player4")){
                        player04card01.setIcon(cardLay.cardLayout(data[1]));
                        player04card02.setIcon(cardLay.cardLayout(data[2]));
                    }if(data[0].equals("Player5") && player.equals("Player5")){
                        player05card01.setIcon(cardLay.cardLayout(data[1]));
                        player05card02.setIcon(cardLay.cardLayout(data[2]));
                    }if(data[0].equals("Player6") && player.equals("Player6")){
                        player06card01.setIcon(cardLay.cardLayout(data[1]));
                        player06card02.setIcon(cardLay.cardLayout(data[2]));
                    }if(data[0].equals("Player7") && player.equals("Player7")){
                        player07card01.setIcon(cardLay.cardLayout(data[1]));
                        player07card02.setIcon(cardLay.cardLayout(data[2]));
                    }if(data[0].equals("Player8") && player.equals("Player8")){
                        player08card01.setIcon(cardLay.cardLayout(data[1]));
                        player08card02.setIcon(cardLay.cardLayout(data[2]));
                    }if(data[0].equals("Player9") && player.equals("Player9")){
                        player09card01.setIcon(cardLay.cardLayout(data[1]));
                        player09card02.setIcon(cardLay.cardLayout(data[2]));
                    }if(data[0].equals("Player10") && player.equals("Player10")){
                        player10card01.setIcon(cardLay.cardLayout(data[1]));
                        player10card02.setIcon(cardLay.cardLayout(data[2]));
                    }
                    if (line.equals("pot")) {
                        pot = line;
                    }

                }
                in.close();
                out.close();
                socket.close();

            } catch (UnknownHostException e) {
                System.out.print("Nieznany host");
            } catch (IOException e) {
                System.out.print("Brak polaczenia, sprawdz serwer");
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}