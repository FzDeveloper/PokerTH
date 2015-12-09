
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

/**
 * Created by konrad on 02.12.15.
 */

public class ChoosenWindow extends JFrame implements KeyListener,ComponentListener, ActionListener {
    Client isOnline = new Client();


    private JFrame jFrame;
    private JButton join= new JButton("Join to exist table");
    private JButton create= new JButton("Create new table");
    private Font font=new Font("Helvetica",Font.BOLD,20);


    public ChoosenWindow(){
        super("Texas Hold'em");
        setLayout(new BorderLayout());
        setSize(240,270);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
        JPanel panel = new JPanel();
        add(panel);
        panel.setVisible(true);
        panel.setSize(240, 270);

        addComponentListener(this);
        panel.setLayout(new GridLayout(2,1));
        join.setFont(font);
        panel.add(join);
        join.addActionListener(this);
        create.setFont(font);
        panel.add(create);
        create.addActionListener(this);
    }

    public static void main(String[] args) {
        ChoosenWindow choose= new ChoosenWindow();
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

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        //startTable.main();
        if(actionEvent.getActionCommand().equals("Join to exist table")) {
            try {
                isOnline.main();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(actionEvent.getActionCommand().equals("Create new table")){
            StartGUI startGUI= new StartGUI();

        }
    }
}