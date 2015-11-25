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
       /* if(chosencards<2 || players<2){
            System.out.print("Zbyt mala liczba kart lub graczy\n");
        }
        else if(chosencards>52 || players>10){
            System.out.print("Wybrano zbyt duza ilosc kart lub graczy\n");
        }
        else {
            if (chosencards % players != 0) {
                int chosencardscorrected = chosencards - chosencards % players;
                System.out.print("Nie mozna rozdac " + chosencards + " kart dla " + players + " graczy. Rozdano " + chosencardscorrected + " kart." + "\n");
                rozdajo= rozdajo(list,chosencardscorrected);
            }
            else{
                System.out.print("Rozdano "+chosencards+" kart "+players+" graczom.\n");*/
                rozdajo= rozdajo(list, chosencards);//tylko to zostaje w wersji do pokera, chociaz i to można uproscic
         //   }
       // }

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

        /*switch (playersondeck){
            case 2:
                for(int count=0; count<cardsinstock; count=count+2){
                    one.add(stringList.get(count));
                    two.add(stringList.get(count + 1));
                }
                System.out.print("Gracz 1: "+one+"\n"+"Gracz 2: "+two+"\n");
                return one;
            case 3:
                for(int count=0; count<cardsinstock; count=count+3){
                    one.add(stringList.get(count));
                    two.add(stringList.get(count+1));
                    three.add(stringList.get(count + 2));
                }
                System.out.print("Gracz 1: "+one+"\n"+"Gracz 2: "+two+"\n"+"Gracz 3: "+three+"\n");
                return one;
            case 4:
                for(int count=0; count<cardsinstock; count=count+4){
                    one.add(stringList.get(count));
                    two.add(stringList.get(count+1));
                    three.add(stringList.get(count+2));
                    four.add(stringList.get(count+3));
                }
                System.out.print("Gracz 1: "+one+"\n"+"Gracz 2: "+two+"\n"+"Gracz 3: "+three+"\n"
                        +"Gracz 4: "+four+"\n");
                return one;
            case 5:
                for(int count=0; count<cardsinstock; count=count+5){
                    one.add(stringList.get(count));
                    two.add(stringList.get(count+1));
                    three.add(stringList.get(count+2));
                    four.add(stringList.get(count+3));
                    five.add(stringList.get(count+4));
                }
                System.out.print("Gracz 1: "+one+"\n"+"Gracz 2: "+two+"\n"+"Gracz 3: "+three+"\n"
                        +"Gracz 4: "+four+"\n"+"Gracz 5: "+five+"\n");
                return one;
            case 6:
                for(int count=0; count<cardsinstock; count=count+6){
                    one.add(stringList.get(count));
                    two.add(stringList.get(count+1));
                    three.add(stringList.get(count+2));
                    four.add(stringList.get(count+3));
                    five.add(stringList.get(count+4));
                    six.add(stringList.get(count+5));
                }
                System.out.print("Gracz 1: "+one+"\n"+"Gracz 2: "+two+"\n"+"Gracz 3: "+three+"\n"
                        +"Gracz 4: "+four+"\n"+"Gracz 5: "+five+"\n"+"Gracz 6: "+six+"\n");
                return one;
            case 7:
                for(int count=0; count<cardsinstock; count=count+7){
                    one.add(stringList.get(count));
                    two.add(stringList.get(count+1));
                    three.add(stringList.get(count+2));
                    four.add(stringList.get(count+3));
                    five.add(stringList.get(count+4));
                    six.add(stringList.get(count+5));
                    seven.add(stringList.get(count+6));
                }
                System.out.print("Gracz 1: "+one+"\n"+"Gracz 2: "+two+"\n"+"Gracz 3: "+three+"\n"
                        +"Gracz 4: "+four+"\n"+"Gracz 5: "+five+"\n"+"Gracz 6: "+six+"\n"
                        +"Gracz 7: "+seven+"\n");
                return one;
            case 8:
                for(int count=0; count<cardsinstock; count=count+8){
                    one.add(stringList.get(count));
                    two.add(stringList.get(count+1));
                    three.add(stringList.get(count+2));
                    four.add(stringList.get(count+3));
                    five.add(stringList.get(count+4));
                    six.add(stringList.get(count+5));
                    seven.add(stringList.get(count+6));
                    eight.add(stringList.get(count+7));
                }
                System.out.print("Gracz 1: "+one+"\n"+"Gracz 2: "+two+"\n"+"Gracz 3: "+three+"\n"
                        +"Gracz 4: "+four+"\n"+"Gracz 5: "+five+"\n"+"Gracz 6: "+six+"\n"
                        +"Gracz 7: "+seven+"\n"+"Gracz 8: "+eight+"\n");
                return one;
            case 9:
                for(int count=0; count<cardsinstock; count=count+9){
                    one.add(stringList.get(count));
                    two.add(stringList.get(count+1));
                    three.add(stringList.get(count+2));
                    four.add(stringList.get(count+3));
                    five.add(stringList.get(count+4));
                    six.add(stringList.get(count+5));
                    seven.add(stringList.get(count+6));
                    eight.add(stringList.get(count+7));
                    nine.add(stringList.get(count+8));
                }
                System.out.print("Gracz 1: "+one+"\n"+"Gracz 2: "+two+"\n"+"Gracz 3: "+three+"\n"
                        +"Gracz 4: "+four+"\n"+"Gracz 5: "+five+"\n"+"Gracz 6: "+six+"\n"
                        +"Gracz 7: "+seven+"\n"+"Gracz 8: "+eight+"\n"+"Gracz 9: "+nine+"\n");
                return one;
            case 10:*/
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
                /*System.out.print("Gracz 1: "+one+"\n"+"Gracz 2: "+two+"\n"+"Gracz 3: "+three+"\n"
                        +"Gracz 4: "+four+"\n"+"Gracz 5: "+five+"\n"+"Gracz 6: "+six+"\n"
                        +"Gracz 7: "+seven+"\n"+"Gracz 8: "+eight+"\n"+"Gracz 9: "+nine+"\n"
                        +"Gracz 10: "+ten+"\n");*/
                //return result;
        //}

        return result;
    }
}

