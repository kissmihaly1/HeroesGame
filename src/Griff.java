import java.util.Random;

public class Griff extends Egysegek{

    public static int tamadas() {
        Random random = new Random();
        int rand = 0;
        while (true){
            rand = random.nextInt(11);
            if(rand>=5)
            {break;}
        }
        return rand;
    }
    public Griff(String neve, int tamadoereje, int eletero, int sebesseg, int kezdemenyezes, int ar, int mennyi, int sor, int oszlop) {
        super("Griff", 0,0,7, 15, 15, 0,0,0, false, 0);
    }
}
