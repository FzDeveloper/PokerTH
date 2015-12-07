import java.util.ArrayList;
import java.util.List;

/**
 * Created by konrad on 21.10.15.
 */
public class GiveCards {
    List<String> rozdajo;
    /** tutaj powinienem coś zmienic, ale poki co zostawie, zebys mogla sie polapac o co chodzi
     *
     * metoda do ustawienia ilosci kart i ilosci graczy*/
    public List<String> giveCard(List<String> list, int chosencards){

        rozdajo= rozdajo(list, chosencards);//tylko to zostaje w wersji do pokera, chociaz i to można uproscic
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
                /** Dodaję wszystkie listy z kartami do jednej
                 *  Da to tyle, że funkcja zwróci wszystkie karty wydane graczom*/
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
}

