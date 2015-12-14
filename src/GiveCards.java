import java.util.ArrayList;
import java.util.List;

/**
 * Created by konrad on 21.10.15.
 */
public class GiveCards{
    List<String> rozdajo;
    /** tutaj powinienem co≈õ zmienic, ale poki co zostawie, zebys mogla sie polapac o co chodzi
     *
     * metoda do ustawienia ilosci kart i ilosci graczy*/
    public List<String> giveCard(List<String> list, int chosencards){

        rozdajo= rozdajo(list, chosencards);//tylko to zostaje w wersji do pokera, chociaz i to mo≈ºna uproscic
        return rozdajo;
    }
    //przypisanie kard do graczy, wg ilosci kart oraz graczy
    public List<String> rozdajo(List<String> stringList, int cardsinstock){
        List<String> one= new ArrayList<>();
        List<String> two= new ArrayList<>();
        List<String> three= new ArrayList<>();
        List<String> four= new ArrayList<>();
        List<String> five= new ArrayList<>();
        List<String> six= new ArrayList<>();
        List<String> seven= new ArrayList<>();
        List<String> eight= new ArrayList<>();
        List<String> nine= new ArrayList<>();
        List<String> ten= new ArrayList<>();
        List<String> table= new ArrayList<>();
        List<String> result= new ArrayList<>();

            for(int count=0; count<cardsinstock; count=count+10){
                    one.add(stringList.get(count));
                    two.add(stringList.get(count + 1));
                    three.add(stringList.get(count + 2));
                    four.add(stringList.get(count + 3));
                    five.add(stringList.get(count + 4));
                    six.add(stringList.get(count + 5));
                    seven.add(stringList.get(count + 6));
                    eight.add(stringList.get(count + 7));
                    nine.add(stringList.get(count + 8));
                    ten.add(stringList.get(count+9));

                }
                for(int count=21; count<=25; ++count) {
                    table.add(stringList.get(count));
                }
                /** Dodajƒô wszystkie listy z kartami do jednej
                 *  Da to tyle, ≈ºe funkcja zwr√≥ci wszystkie karty wydane graczom*/
                result.addAll(one);
                result.addAll(two);
                result.addAll(three);
                result.addAll(four);
                result.addAll(five);
                result.addAll(six);
                result.addAll(seven);
                result.addAll(eight);
                result.addAll(nine);
                result.addAll(ten);
                result.addAll(table);
        return result;
    }
    /**
     * 
     * @param playersnumber numer gracza
     * @param cards lista z kartami wszystkich graczy i kartami na stole
     * @return listÍ z kartami w rÍce gracza o zadanym numerze playersnumber
     */
    public List<String> playerscards(int playersnumber, List<String> cards){
    	List<String> cardsOfPlayer = new ArrayList<>();

    	int cardIndex = 0;
    	//int counter = 0;
    	
    	for(int i=1; i<playersnumber; i++){
    			//counter++;
    			cardIndex++;
    	}
    	
    	cardsOfPlayer.add(cards.get(cardIndex*2));
    	cardsOfPlayer.add(cards.get(2*cardIndex+1));
    	
    	
    	return cardsOfPlayer;
    	
    	
    }
    
    public List<String> tableCards(List<String> cards){
    	List<String> table = new ArrayList<>();
    	for(int count=20; count<25; ++count) {
            table.add(cards.get(count));
        }
    	return table;
    }
    
    public void sort(List<String> sortcards){
    	for(int i=0; i<sortcards.size(); i++){
    		//tubedziesortowanie
    	}
    }
    
    /**
     * 
     * @param table lista z kartami na stole
     * @param uklad lista z kartami w rÍku gracza
     * @param player numer gracza
     * @return
     */
   /* public int uklady(List<String> table, List<String> uklad, int player){
    
    	List<String> cards = new ArrayList<>();
    	CreateCards card = new CreateCards();
    	
    	int ukladzik;
    	
    	cards.addAll(this.playerscards(player, uklad));
    	cards.addAll(this.tableCards(table));
    	//po posortowaniu kart wg koloru i figury patrzymy tylko na pierwsze 5
    	for(int i=0; i<5; i++){
    		if(cards.indexOf(card.getSuite(cards, i))==cards.indexOf(card.getSuite(cards, i+1)) && 
    		   cards.indexOf(card.getRank(cards, i))-cards.indexOf(card.getRank(cards, i+1))==1){
    				ukladzik = -8;
    		}
    		else{
    			ukladzik = cards.indexOf(card.getRank(cards, 0));
    		}
    		
    		
    	}
 	return ukladzik;
    }*/

	
}

