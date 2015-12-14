import static org.junit.Assert.*;

import java.util.List;
import java.util.ArrayList;

import org.junit.*;

public class CardsTest {
	
	CreateCards create;
	GiveCards give;
	
	List<String> deck;
	List<String> playerscards;
	List<String> hand;
	

	@Before
	public void setUp(){
		
		deck = new ArrayList<>();
		playerscards = new ArrayList<>();
		hand = new ArrayList<>();
		
		create = new CreateCards();
		give = new GiveCards();
		
		deck = create.initialize();
		playerscards = give.giveCard(deck, 20);
	}
	
	@Test
	public void testPlayersCards00() {

		hand = give.playerscards(10, playerscards);
		
		List<String> cards = new ArrayList<>();
		
		cards.add(playerscards.get(18));
		cards.add(playerscards.get(19));
				
		
		assertEquals(cards , hand);
		
	}
	
	@Test
	public void testPlayersCards01(){

		hand = give.playerscards(7, playerscards);
		
		List<String> cards = new ArrayList<>();
		
		cards.add(playerscards.get(12));
		cards.add(playerscards.get(13));
				
		
		assertEquals(cards , hand);
	}
	
	@Test
	public void testPlayersCards02(){

		hand = give.playerscards(2, playerscards);
		
		List<String> cards = new ArrayList<>();
		
		cards.add(playerscards.get(2));
		cards.add(playerscards.get(3));
				
		
		assertEquals(cards , hand);
	}
	
	@Test
	public void testTableCards(){
		List<String> table = new ArrayList<>();
		
		for(int count=20; count<25; ++count) {
            table.add(playerscards.get(count));
        }
		
		assertEquals(table, give.tableCards(playerscards));
	}
	
	

}
