
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by konrad on 21.10.15.
 */
public class GiveCards{
    List<String> rozdajo;
    /** tutaj powinienem coÅ› zmienic, ale poki co zostawie, zebys mogla sie polapac o co chodzi
     *
     * metoda do ustawienia ilosci kart i ilosci graczy*/
    public List<String> giveCard(List<String> list, int chosencards){

        rozdajo= rozdajo(list, chosencards);//tylko to zostaje w wersji do pokera, chociaz i to moÅ¼na uproscic
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
                /** DodajÄ™ wszystkie listy z kartami do jednej
                 *  Da to tyle, Å¼e funkcja zwrÃ³ci wszystkie karty wydane graczom*/
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
     * @return listê z kartami w rêce gracza o zadanym numerze playersnumber
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
    	CreateCards create = new CreateCards();
    	
    	final String[] rank = create.getRankArray();
    	final String[] suite = create.getSuiteArray();
    	
    	String temp;
    	
    	for(int i=sortcards.size()-1; i<0; i--){
    		if(Arrays.asList(rank).indexOf(this.getSuite(sortcards, i))==Arrays.asList(rank).indexOf(this.getSuite(sortcards, i-1))){
    			temp = sortcards.get(i);
    			sortcards.add(i-1, sortcards.get(i));
    			sortcards.add(i, temp);
    		}
    	}
    }
    
    public String getSuite(List<String> deck, int card){
    	String suite = deck.get(card);
    	int index = suite.indexOf(" ");
    	suite = suite.substring(0, index);
    	return suite;
    }
    
    public String getRank(List<String> deck, int card){
    	String rank = deck.get(card);
    	int index = rank.indexOf(" ");
    	rank = rank.substring(index, rank.length()-1);
    	return rank;
    }
    
    /**
     * 
     * @param table lista z kartami na stole
     * @param uklad lista z kartami w rêku gracza
     * @param player numer gracza
     * @return
     */
    //metoda zwraca listê z kartami gracza i kartami na stole,
    //przyda siê przy sortowaniu i wy³anianiu zwyciêzcy
    public List<String> karty(List<String> table, List<String> hand, int player){

    	List<String> cards = new ArrayList<>();
    	CreateCards card = new CreateCards();
    	cards.addAll(this.playerscards(player, hand));
    	cards.addAll(this.tableCards(table));
    	return cards;
    	
    }
    
    
    public int uklady(List<String> table, List<String> uklad, int player){
    
    	List<String> cards = new ArrayList<>();
    	CreateCards card = new CreateCards();
    	
    	int counter = 0;
    	int ukladzik = 0;
    	
    	
    	cards.addAll(this.playerscards(player, uklad));
    	cards.addAll(this.tableCards(table));
    	

    	for(int a=0; a<7; a++){
    		for(int b=6; b<=0; b--){
    			if(this.getRank(cards, a).equals(this.getRank(cards, b))){
    				ukladzik = 13; //para
    			}
    		}
    	}
    	
    	for(int p=0; p<7; p++){
    		for(int q=6; q<=0; q--){
    			if(this.getRank(cards, p).equals(this.getRank(cards, q))){
    				counter++;
    			}
    		}
    		if(counter==2){
    			ukladzik = 14; //dwie pary
    		}
    	}
    	
    	for(int m=0; m<7; m++){
    		if(this.getRank(cards, m).equals(this.getRank(cards, m+1))){
    			counter++; //trojka 
    		}
    		if(counter==3){
    			ukladzik = 15;
    		}
    	}
    	
    	for(int l=0; l<7; l++){
    		if(Arrays.asList(cards).indexOf(this.getRank(cards, l))-Arrays.asList(cards).indexOf(this.getRank(cards,  l+1))==1){
    			ukladzik =  16; //strit
    		}
    	}
    	
    	for(int k=0; k<7; k++){
    		for(int y=6; y<=0; y--){
    			if(this.getSuite(cards, k).equals(this.getSuite(cards, k+1))){
    				ukladzik = 17; //kolor
    			}
    		}
    	}
    	
    	for(int j=0; j<7; j++){
    		for(int x=6; x<=0; x--){
    			if(this.getRank(cards, j).equals(this.getRank(cards, j+1))){
    				ukladzik =  18; //czworka
    			}
    		}
    	}
    	
    	for(int i=0; i<7; i++){
    		if(this.getSuite(cards, i).equals(this.getSuite(cards, i+1)) && 
    				Arrays.asList(cards).indexOf(this.getSuite(cards, i))-Arrays.asList(cards).indexOf(this.getSuite(cards, i+1))==1){
    			ukladzik =  19; //poker
    		}
    	}
    	return ukladzik;
    }
    
    public int highCard(List<String> table, List<String> hand, int player){
    	return Arrays.asList(hand).indexOf(this.getRank(hand, hand.size()-1));
    }
    
    public int andTheWinnerIs(List<String> table, List<String> hand, int player){
    	if(uklady(table, hand, player)==0){
    		return highCard(table, hand, player);
    	}
    	else{
    		return uklady(table, hand, player);
    	}
    }
}

