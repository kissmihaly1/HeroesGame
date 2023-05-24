import java.util.Objects;
import java.util.Scanner;

public class Egysegek {
    private String neve;
    private int tamadoereje;
    private int eletero;
    private int sebesseg;
    private int kezdemenyezes;
    private int ar;
    private int mennyi;
    private int sor;
    private int oszlop;
    private boolean vissza;
    private int max;

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMennyi() {
        return mennyi;
    }

    public void setMennyi(int mennyi) {
        this.mennyi = mennyi;
    }

    public Egysegek(String neve, int tamadoereje, int eletero, int sebesseg, int kezdemenyezes, int ar, int mennyi, int sor, int oszlop, boolean vissza, int max) {
        this.neve = neve;
        this.tamadoereje = tamadoereje;
        this.eletero = eletero;
        this.sebesseg = sebesseg;
        this.kezdemenyezes = kezdemenyezes;
        this.ar = ar;
        this.mennyi=mennyi;
        this.oszlop= oszlop;
        this.sor=sor;
        this.vissza=vissza;
        this.max=max;
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

    static Egysegek[] egysegeim = new Egysegek[5];

    public boolean isVissza() {
        return vissza;
    }

    public void setVissza(boolean vissza) {
        this.vissza = vissza;
    }

    static Foldmuves foldmuves = new Foldmuves("F", 0, 0, 4, 8, 2, 0,0,0);
    static Ijasz ijasz = new Ijasz("I", 0, 0, 4, 9, 6,0,0,0);
    static Griff griff = new Griff("G", 0, 0, 7, 15, 15,0,0,0);
    static Cerberus cerberus= new Cerberus("C", 0, 0, 6, 20, 20,0,0,0);
    static Torpe torpe= new Torpe("T", 0, 0, 10, 10, 10,0,0,0);


    public int getSor() {
        return sor;
    }

    public void setSor(int sor) {
        this.sor = sor;
    }

    public int getOszlop() {
        return oszlop;
    }

    public void setOszlop(int oszlop) {
        this.oszlop = oszlop;
    }

    static Egysegek[] ellenfelEgysegei= new Egysegek[5];

    public static Egysegek[] getEllenfelEgysegei() {
        return ellenfelEgysegei;
    }

    public static void setEllenfelEgysegei(Egysegek[] ellenfelEgysegei) {
        Egysegek.ellenfelEgysegei = ellenfelEgysegei;
    }


    public static void vasarlas() {
        String nev = null;
        String szam = "0";

        while (!Objects.equals(nev, "kilepek")) {
            Scanner beolvas = new Scanner(System.in);
            nev = beolvas.nextLine();
            if (nev.equals("foldmuves")) {
                System.out.println("Mennyi földművest szeretnél?");
                Scanner beolvas2 = new Scanner(System.in);
                szam= beolvas2.nextLine();
                int mennyit=0;
                try{
                    mennyit+= Integer.parseInt(szam);
                }
                catch(Exception e) {
                    System.err.println("Baj van. Rossz az input....");
                }

                if (mennyit * 2 <= SajatHos.sajat.getPenz()&&mennyit>0) {
                    SajatHos.sajat.setPenz(SajatHos.sajat.getPenz() - (mennyit * 2));
                    egysegeim[0] = foldmuves;
                    egysegeim[0].tamadoereje += mennyit;
                    egysegeim[0].eletero += 3*mennyit;
                    egysegeim[0].mennyi=egysegeim[0].getMennyi()+mennyit;
                    egysegeim[0].setMax(mennyit*3);
                    System.out.println(mennyit + " földművest vettél!");
                }
                else if (mennyit==0){
                    System.err.println("ne vegyé má 0 egységet broszki");
                }
                else {
                    System.err.println("Nincs elég pénzed, hogy " + mennyit+ " földművest vegyél! Visszakerülsz a főmenübe!");
                    break;
                }
            }
            else if (nev.equals("ijasz")) {
                System.out.println("Mennyi íjászt szeretnél?");
                Scanner beolvas2 = new Scanner(System.in);
                szam= beolvas2.nextLine();
                int mennyit=0;
                try{
                    mennyit+= Integer.parseInt(szam);
                }
                catch(Exception e) {
                    System.err.println("Baj van. Rossz az input....");
                }
                if (mennyit * 6 <= SajatHos.sajat.getPenz()&&mennyit>0) {
                    SajatHos.sajat.setPenz(SajatHos.sajat.getPenz() - (mennyit * 6));
                    egysegeim[1] = ijasz;
                    egysegeim[1].tamadoereje += Ijasz.tamadas()*mennyit;
                    egysegeim[1].eletero += 7*mennyit;
                    egysegeim[1].mennyi+=egysegeim[1].getMennyi()+mennyit;
                    egysegeim[1].setMax(mennyit*7);

                    System.out.println(szam + " íjászt vettél!");
                }
                else if (mennyit==0){
                    System.err.println("ne vegyé má 0 egységet broszki");
                }
                else {
                    System.err.println("Nincs elég pénzed, hogy " + mennyit + " íjászt vegyél! Visszakerülsz a főmenübe!");
                    break;
                }
            }
            else if (nev.equals("griff")) {
                System.out.println("Mennyi griffet szeretnél?");
                Scanner beolvas2 = new Scanner(System.in);
                szam= beolvas2.nextLine();
                int mennyit=0;
                try{
                    mennyit+= Integer.parseInt(szam);
                }
                catch(Exception e) {
                    System.err.println("Baj van. Rossz az input....");
                }
                if (mennyit * 15 <= SajatHos.sajat.getPenz()&&mennyit>0) {
                    SajatHos.sajat.setPenz(SajatHos.sajat.getPenz() - (mennyit * 15));
                    egysegeim[2] = griff;
                    egysegeim[2].tamadoereje =1;
                    egysegeim[2].eletero += 30*mennyit;
                    egysegeim[2].mennyi=egysegeim[2].getMennyi()+mennyit;
                    egysegeim[2].setMax(mennyit*30);


                    System.out.println(mennyit + " griffet vettél!");
                }
                else if (mennyit==0){
                    System.err.println("ne vegyé má 0 egységet broszki");
                }
                else {
                    System.err.println("Nincs elég pénzed, hogy " + mennyit + " griffet vegyél! Visszakerülsz a főmenübe!");

                }
            }
            else if (nev.equals("cerberus")) {
                System.out.println("Mennyi cerberust szeretnél?");
                Scanner beolvas2 = new Scanner(System.in);
                szam= beolvas2.nextLine();
                int mennyit=0;
                try{
                    mennyit+= Integer.parseInt(szam);
                }
                catch(Exception e) {
                    System.err.println("Baj van. Rossz az input....");
                }
                if (mennyit * 20 <= SajatHos.sajat.getPenz()&&mennyit>0) {
                    SajatHos.sajat.setPenz(SajatHos.sajat.getPenz() - (mennyit * 20));
                    egysegeim[3] = cerberus;
                    egysegeim[3].tamadoereje +=5* mennyit;
                    egysegeim[3].eletero += 20*mennyit;
                    egysegeim[3].mennyi=egysegeim[3].getMennyi()+mennyit;
                    egysegeim[3].setMax(mennyit*20);

                    System.out.println(szam + " cerberust vettél!");
                }
                else if (mennyit==0){
                    System.err.println("ne vegyé má 0 egységet broszki");
                }
                else {
                    System.err.println("Nincs elég pénzed, hogy " + mennyit + " cerberust vegyél! Visszakerülsz a főmenübe!");
                    break;
                }
            }


            else if (nev.equals("torpe")) {
                System.out.println("Mennyi törpét szeretnél?");
                Scanner beolvas2 = new Scanner(System.in);
                szam= beolvas2.nextLine();
                int mennyit=0;
                try{
                    mennyit+= Integer.parseInt(szam);
                }
                catch(Exception e) {
                    System.err.println("Baj van. Rossz az input....");
                }
                if (mennyit * 10 <= SajatHos.sajat.getPenz()&&mennyit>0) {
                    SajatHos.sajat.setPenz(SajatHos.sajat.getPenz() - (mennyit * 10));
                    egysegeim[4] = torpe;
                    egysegeim[4].tamadoereje +=10* mennyit;
                    egysegeim[4].eletero +=10*mennyit;
                    egysegeim[4].mennyi=egysegeim[4].getMennyi()+mennyit;
                    egysegeim[4].setMax(mennyit*10);


                    System.out.println(mennyit + " törpét vettél!");

                }
                else if (mennyit==0){
                    System.err.println("ne vegyé má 0 egységet broszki");
                }
                else {
                    System.err.println("Nincs elég pénzed, hogy " + mennyit + " törpét vegyél! Visszakerülsz a főmenübe!");
                    break;
                }
            }
            else {
                if (nev.equals("kilepek")) {
                    System.out.println("""
                -----------------------------------------------------
                Ez a menü, választanod kell egy számot, vagy szót:\s
                1: Tulajdonságok
                2: Egységek
                3. Varázslatok vétele
                4: Csata indítása
                5: Jelenlegi helyzeted
                kilepek: Főmenübe lépés
                -----------------------------------------------------""");
                    break;
                }
                else {
                    System.err.println("Hibás input!!");
                }
            }

        }
    }
}
