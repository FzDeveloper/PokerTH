import java.io.IOException;

/**
 * Created by konrad on 20.01.16.
 */
public interface Strategies {

    public void bet() throws IOException;
    public void check();
    public void raise();
    public void allIn();
    public void fold();
}
class easy implements Strategies {
    Player player = null;

    @Override
    public void bet() throws IOException {
        player.bet(20);
    }

    @Override
    public void check() {
        player.check();
    }

    @Override
    public void raise() {
        player.raise(30);
    }

    @Override
    public void allIn() {
        player.all_in();
    }

    @Override
    public void fold() {
        player.fold();
    }


    public void bot(int pot, int startMoney, int check, int players, int botmoney) throws IOException {
        if ((pot / players) > (botmoney/10)) {
            fold();
        }else if((pot / players) > (botmoney/20)){
            try {
                bet();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if((pot / players) > (botmoney/30)){
            bet();
        }
        else if(check==1){
            check();
        }
        else if((startMoney- botmoney)< 40){
            allIn();
        }
    }
}