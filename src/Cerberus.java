import java.util.Random;

public class Cerberus extends Egysegek{

    public Cerberus(String neve, int tamadoereje, int eletero, int sebesseg, int kezdemenyezes, int ar, int mennyi, int sor, int oszlop) {
        super("Cerberus", 5, 0, 4, 20, 20, 0,0,0, false,0 );
    }

    public static int tamadas() {
        Random random = new Random();
        int rand = 0;
        while (true){
            rand = random.nextInt(6);
            if(rand>=3)
            {break;}
        }
        return rand;
    }
}
