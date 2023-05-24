import java.util.Random;

public class EllenfelEgyseg {

    private String neve;
    private int tamadoereje;
    private int eletero;
    private int sebesseg;
    private int kezdemenyezes;
    private int ar;
    private int mennyi;
    private int oszlop;
    private int sor;
    public int getMennyi() {
        return mennyi;
    }

    public void setMennyi(int mennyi) {
        this.mennyi = mennyi;
    }

    public EllenfelEgyseg(String neve, int tamadoereje, int eletero, int sebesseg, int kezdemenyezes, int ar, int mennyi, int oszlop, int sor) {
        this.neve = neve;
        this.tamadoereje = tamadoereje;
        this.eletero = eletero;
        this.sebesseg = sebesseg;
        this.kezdemenyezes = kezdemenyezes;
        this.ar = ar;
        this.mennyi=mennyi;
        this.oszlop=oszlop;
        this.sor=sor;
    }

    public String getNeve() {
        return neve;
    }

    public void setNeve(String neve) {
        this.neve = neve;
    }

    public int getTamadoereje() {
        return tamadoereje;
    }

    public void setTamadoereje(int tamadoereje) {
        this.tamadoereje = tamadoereje;
    }

    public int getEletero() {
        return eletero;
    }

    public void setEletero(int eletero) {
        this.eletero = eletero;
    }

    public int getSebesseg() {
        return sebesseg;
    }

    public void setSebesseg(int sebesseg) {
        this.sebesseg = sebesseg;
    }

    public int getKezdemenyezes() {
        return kezdemenyezes;
    }

    public void setKezdemenyezes(int kezdemenyezes) {
        this.kezdemenyezes = kezdemenyezes;
    }

    public int getAr() {
        return ar;
    }

    public void setAr(int ar) {
        this.ar = ar;
    }

    static Foldmuves foldmuves = new Foldmuves("F", 0, 0, 4, 8, 2, 0,0,0);
    static Ijasz ijasz = new Ijasz("I", 0, 0, 4, 9, 6,0,0,0);
    static Griff griff = new Griff("G", 0, 0, 7, 15, 15,0,0,0);
    static Cerberus cerberus= new Cerberus("C", 5, 0, 6, 20, 20,0,0,0);
    static Torpe torpe= new Torpe("T", 0, 0, 10, 10, 10,0,0,0);
    static Egysegek[] ellenfelEgysegei= new Egysegek[5];




    public static Egysegek[] getEllenfelEgysegei() {
        return ellenfelEgysegei;
    }

    public static void setEllenfelEgysegei(Egysegek[] ellenfelEgysegei) {
        Egysegek.ellenfelEgysegei = ellenfelEgysegei;
    }

    public static void ellenfelEgyseg() {

            Random random = new Random();
            int rand = 0;
            while (true){
                rand = random.nextInt(20);
                if(rand>=10)
                {break;}
            }


        ellenfelEgysegei[0] = foldmuves;
        ellenfelEgysegei[0].setTamadoereje(rand);
        ellenfelEgysegei[0].setEletero(rand*3);
        ellenfelEgysegei[0].setMennyi(rand);
        ellenfelEgysegei[0].setMax(rand*3);
        Hos.ellenfel.setPenz(Hos.ellenfel.getPenz()-rand*2);

        while (true){
            rand = random.nextInt(20);
            if(rand>=10)
            {break;}
        }

        ellenfelEgysegei[1] = ijasz;
        ellenfelEgysegei[1].setTamadoereje(Ijasz.tamadas()* rand);
        ellenfelEgysegei[1].setEletero(7*rand);
        ellenfelEgysegei[1].setMennyi(rand);
        ellenfelEgysegei[1].setMax(rand*7);
        Hos.ellenfel.setPenz(Hos.ellenfel.getPenz()-rand*6);
        while (true){
            rand = random.nextInt(10);
            if(rand>=9)
            {break;}
        }

        ellenfelEgysegei[2] = griff;
        ellenfelEgysegei[2].setTamadoereje(Griff.tamadas()* rand);
        ellenfelEgysegei[2].setEletero (30*rand);
        ellenfelEgysegei[2].setMennyi(rand);
        ellenfelEgysegei[2].setMax(rand*30);
        Hos.ellenfel.setPenz(Hos.ellenfel.getPenz()-rand*15);
        while (true){
            rand = random.nextInt(10);
            if(rand>=9)
            {break;}
        }

        ellenfelEgysegei[3] = cerberus;
        ellenfelEgysegei[3].setTamadoereje(Cerberus.tamadas()* rand); //5 tamado
        ellenfelEgysegei[3].setEletero(20*rand);       //20 hp
        ellenfelEgysegei[3].setMennyi(rand);
        ellenfelEgysegei[3].setMax(rand*20);
        Hos.ellenfel.setPenz(Hos.ellenfel.getPenz()-rand*20);
        while (true){
            rand = random.nextInt(20);
            if(rand>=10)
            {break;}
        }
        ellenfelEgysegei[4] = torpe;
        ellenfelEgysegei[4].setTamadoereje(10*rand);  //10 attk
        ellenfelEgysegei[4].setEletero(10*rand);      //10 hp
        ellenfelEgysegei[4].setMennyi(rand);
        ellenfelEgysegei[4].setMax(rand*10);
        Hos.ellenfel.setPenz(Hos.ellenfel.getPenz()-rand*10);


    }
}
