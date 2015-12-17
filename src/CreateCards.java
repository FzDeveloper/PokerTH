/**
 * Created by konrad on 25.11.15.
 */
import java.util.ArrayList;
import java.util.List;

/**
 * Created by konrad on 21.10.15.
 */
public class CreateCards {
    private final String[] suite = {"HEART", "DIAMOND", "CLUB", "SPADE"};
    private final String[] rank = {"TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE",
            "TEN", "JACK", "QUEEN", "KING", "ACE"};
    List<String> listOfCards = new ArrayList<>();
    /** tworzenie wszystkich kart i wrzucenie ich do listy */
    public List<String> initialize() {
        for (int countofsuites = 0; countofsuites < suite.length; countofsuites++) {
            for (int countofranks = 0; countofranks < rank.length; countofranks++) {
                listOfCards.add(suite[countofsuites] + " " + rank[countofranks]);
            }
        }
        return listOfCards;
    }

    
    public String[] getSuiteArray(){
    	return this.suite;
    }
    
    public String[] getRankArray(){
    	return this.rank;
    }
    

    
  
}
