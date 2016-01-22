import java.util.TimerTask;

/**
 * Created by konrad on 16.12.15.
 */
public class Table  extends TimerTask{
    Player nextPlayer;

    @Override
    public void run() {
        nextPlayer.nextPlayer();
    }
}
