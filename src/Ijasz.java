import java.util.Random;

public class Ijasz extends Egysegek{

    public static int tamadas() {
        Random random = new Random();
        int rand = 0;
        while (true){
            rand = random.nextInt(5);
            if(rand !=0&&rand!=1)
            {break;}
        }

        return rand;
    }

    public Ijasz(String nev,int tamadoereje,int eletero, int sebesseg, int kezdemenyezes, int ar,int mennyi, int sor, int oszlop) {
        super("Íjász", 0, 0, 4, 9, 6, 0,0,0, false,0 );
    }
}
