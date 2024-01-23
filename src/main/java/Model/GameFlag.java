package Model;

import java.util.ArrayList;
import java.util.Random;

public class GameFlag extends Game{
    //1.mainīgie
    private ArrayList<Country> country = new ArrayList<Country>();

    //2.get
    public ArrayList<Country> getCountry(){
        return country;
    }

    //3.set - nevajag, jo neko neievadīs neviens

    //4.Konstruktori
    public GameFlag(){
        super();
        //izveidosim visu karogu kopumu
        createAllCountries();
        //samaisīsim karogus, lai katrā nākamajā spēlē tie nebūtu vienādi
        shuffleCountries();

    }

    //5.toString
    public String toString(){
        String result = country.toString();
        return  result;
    }

    //6.papildus funkcijas
    public void createAllCountries(){
        Country[] allCountries = Country.values();//nolasu visas valstis

        for(Country tempValue: allCountries){
            country.add(tempValue);
        }
    }

    public void shuffleCountries(){
        //Izveido Random objektu
        Random myRandom = new Random();

        //Izveido ciklu, kas strādā 1000 reizes
        for(int i = 0; i < 1000; i++){
            //uzģenerē random int vērtību no 0 līdz valstu daudzumu skaitlim
            int flagNo = myRandom.nextInt(country.size());
            //izņem kārti, kuras atrašanās vieta ir uzbūvēta
            Country removedCountry = country.get(flagNo);
            country.remove(flagNo);
            country.add(removedCountry);
        }
    }

    public Country giveOneCountry(){
        Country tempCountry = country.get(0);
        country.remove(0);
        return tempCountry;
    }

    public Country giveOneRandomCountry(){
        Random myRandom = new Random();
        Country tempCountry = country.get(myRandom.nextInt(country.size()));
        return tempCountry;
    }

}
