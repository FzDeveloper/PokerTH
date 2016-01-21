/**
 * Created by konrad on 16.12.15.
 */
import java.util.Random;

public class Table {

	Player player = new Player();
	
	int dealer; //nr gracza, ktory jest dealerem
	int big; //bigblindem
	int small; //smallblindem
	
	int bigVal = 40;
	int smallVal = 20; //kwoty bigblinda i smallblinda, to powinny byc parametry wejsciowe gry ale za pozno na takie ekscesy

	Random rndm = new Random();
	dealer = rndm.nextInt(10);
	big = dealer + 1;
	small = big + 1;
	
	//player.setMoney(); nie za bardzo ogarniam to przydzielanie hajsu jeszcze bo tu trzeba wprowadzic parametr podany przed rozpoczeciem gry
	player.moneyTab[big] -= bigVal;
	player.moneyTab[small] -= smallVal;
		
	String flgs[] = new String[10]; //czy gracz zfoldowal czy zallinowal
	
	public void wyczyscflagi(){
		for(int i=0; i<10; i++){
			flgs[i] = ""; 
		}
	}
	
	int wpuli[] = new int[10]; //kazdy gracz musi wlozyc do puli tyle samo (o ile nie zallinowal ani nie zfoldowal) zeby licytacja sie skonczyla
	
	
	/*public void licytuj(){
		for(int j=0; j<10; j++){
			if(!flgs[j].equals("F") && !flgs[j].equals("A")){
			
			}
		}
	}*/
	
	//teraz odkrywamy trzy karty na stole
	
	
}
