import java.util.Objects;
import java.util.Scanner;

public abstract class Hos {
    private int tamadas;
    private int vedekezes;
    private int varazsero;
    private int tudas;
    private int moral;
    private int szerencse;
    private int penz;
    private boolean tuzlabda;
    private boolean feltamasztas;
    private boolean villamcsapas;
    private boolean gyorsitas;
    private boolean lassitas;

    public boolean isGyorsitas() {
        return gyorsitas;
    }

    public void setGyorsitas(boolean gyorsitas) {
        this.gyorsitas = gyorsitas;
    }

    public boolean isLassitas() {
        return lassitas;
    }

    public void setLassitas(boolean lassitas) {
        this.lassitas = lassitas;
    }

    public int getTamadas() {
        return tamadas;
    }

    public void setTamadas(int tamadas) {
        this.tamadas = tamadas;
    }

    public int getVedekezes() {
        return vedekezes;
    }

    public void setVedekezes(int vedekezes) {
        this.vedekezes = vedekezes;
    }

    public int getVarazsero() {
        return varazsero;
    }

    public void setVarazsero(int varazsero) {
        this.varazsero = varazsero;
    }

    public int getTudas() {
        return tudas;
    }

    public void setTudas(int tudas) {
        this.tudas = tudas;
    }

    public int getMoral() {
        return moral;
    }

    public void setMoral(int moral) {
        this.moral = moral;
    }

    public int getSzerencse() {
        return szerencse;
    }

    public void setSzerencse(int szerencse) {
        this.szerencse = szerencse;
    }

    public int getPenz() {
        return penz;
    }

    public void setPenz(int penz) {
        this.penz = penz;
    }

    public boolean isTuzlabda() {
        return tuzlabda;
    }

    public void setTuzlabda(boolean tuzlabda) {
        this.tuzlabda = tuzlabda;
    }

    public boolean isVillamcsapas() {
        return villamcsapas;
    }

    public void setVillamcsapas(boolean villamcsapas) {
        this.villamcsapas = villamcsapas;
    }

    public boolean isFeltamasztas() {
        return feltamasztas;
    }

    public void setFeltamasztas(boolean feltamasztas) {
        this.feltamasztas = feltamasztas;
    }


    public Hos(int tamadas, int vedekezes, int varazsero, int tudas, int moral, int szerencse, int penz, boolean tuzlabda, boolean feltamasztas, boolean villamcsapas, boolean gyorsitas, boolean lassitas) {
        this.tamadas = tamadas;
        this.vedekezes = vedekezes;
        this.varazsero = varazsero;
        this.tudas = tudas;
        this.moral = moral;
        this.szerencse = szerencse;
        this.penz = penz;
        this.feltamasztas = feltamasztas;
        this.tuzlabda = tuzlabda;
        this.villamcsapas = villamcsapas;
        this.gyorsitas = gyorsitas;
        this.lassitas = lassitas;
    }

    static SajatHos sajat = new SajatHos(1, 1, 1, 1, 1, 1, 1000, false, false, false, false, false);
    static Ellenfel ellenfel = new Ellenfel(1, 1, 1, 1, 1, 1, 1000, false, false, true, false, false);

    public static void main(String[] args) {
    }

    static int levonas = 5;
    static int levonasEllenfel = 5;
    static int vegosszeg=0;


    public static void ellenfelTulajdonsag() {
        int min = 1;
        int max = 3;
        int b = (int) (Math.random() * (max - min + 1) + min);
        Hos.ellenfel.setPenz(Hos.ellenfel.getPenz() - levonasEllenfel * b);
        levonasEllenfel = (int) Math.ceil(levonasEllenfel * 1.1);
        Ellenfel.ellenfel.setTamadas(b);
        b = (int) (Math.random() * (max - min + 1) + min);

        Hos.ellenfel.setPenz(Hos.ellenfel.getPenz() - levonasEllenfel * b);
        levonasEllenfel = (int) Math.ceil(levonasEllenfel * 1.1);
        Ellenfel.ellenfel.setVedekezes(b);
        b = (int) (Math.random() * (max - min + 1) + min);

        Hos.ellenfel.setPenz(Hos.ellenfel.getPenz() - levonasEllenfel * b);
        levonasEllenfel = (int) Math.ceil(levonasEllenfel * 1.1);
        Ellenfel.ellenfel.setVarazsero(b);
        b = (int) (Math.random() * (max - min + 1) + min);

        Hos.ellenfel.setPenz(Hos.ellenfel.getPenz() - levonasEllenfel * b);
        levonasEllenfel = (int) Math.ceil(levonasEllenfel * 1.1);
        Ellenfel.ellenfel.setMoral(b);
        b = (int) (Math.random() * (max - min + 1) + min);

        Hos.ellenfel.setPenz(Hos.ellenfel.getPenz() - levonasEllenfel * b);
        levonasEllenfel = (int) Math.ceil(levonasEllenfel * 1.1);
        Ellenfel.ellenfel.setTudas(b);
        b = (int) (Math.random() * (max - min + 1) + min);

        Hos.ellenfel.setPenz(Hos.ellenfel.getPenz() - levonasEllenfel * b);
        levonasEllenfel = (int) Math.ceil(levonasEllenfel * 1.1);
        Ellenfel.ellenfel.setSzerencse(b);

        int min2 = 0;
        int max2 = 10;
        int b2 = (int) (Math.random() * (max - min + 1) + min);
        if (b2 > 5 && Ellenfel.ellenfel.getPenz() - 60 >= 0) {
            Ellenfel.ellenfel.setVillamcsapas(true);
            Ellenfel.ellenfel.setPenz(Ellenfel.ellenfel.getPenz() - 60);
        }
        b2 = (int) (Math.random() * (max - min + 1) + min);
        if (b2 > 100 && Ellenfel.ellenfel.getPenz() - 150 >= 0) {
            Ellenfel.ellenfel.setGyorsitas(true);
            Ellenfel.ellenfel.setPenz(Ellenfel.ellenfel.getPenz() - 150);

        }
        b2 = (int) (Math.random() * (max - min + 1) + min);
        if (b2 > 5 && Ellenfel.ellenfel.getPenz() - 120 >= 0) {
            Ellenfel.ellenfel.setTuzlabda(true);
            Ellenfel.ellenfel.setPenz(Ellenfel.ellenfel.getPenz() - 120);

        }
        b2 = (int) (Math.random() * (max - min + 1) + min);
        if (b2 > 100 && Ellenfel.ellenfel.getPenz() - 120 >= 0) {
            Ellenfel.ellenfel.setFeltamasztas(true);
            Ellenfel.ellenfel.setPenz(Ellenfel.ellenfel.getPenz() - 120);

        }
    }

    public static int randomNumber(int a, int b) {
        int min = 10;
        int max = 15;
        int c = (int) (Math.random() * (max - min + 1) + min);
        return c;
    }


    public static void tulajdonsagNoveles() {



         /*   if (sajat.getPenz() - levonas >= 0) {

                if (nev.equals("tamadas")) {
                    System.out.println("Mennyit szeretnél venni? (1-9)");
                    nev = beolvas.nextLine();
                    try {
                        mennyit += Integer.parseInt(nev);
                    } catch (Exception e) {
                        System.err.println("Baj van. Rossz az input....");
                    }
                    int levonasutan = valozo;
                    int valozoutan = levonas;
                    for (int i = 0; i < mennyit - 1; i++) {
                        valozo += (int) Math.ceil(levonas * 1.1);
                        levonas = (int) Math.ceil(levonas * 1.1);

                    }
                    if (Hos.sajat.getPenz() - valozo >= 0) {
                        valozo=levonasutan;
                        levonas=valozoutan;
                        if (sajat.getTamadas() < 10 && (mennyit > 0 && mennyit < 10)) {
                            sajat.setTamadas(sajat.getTamadas() + mennyit);
                            System.out.println("Tamadas megnovelve, jelenleg: " + sajat.getTamadas());
                            for (int i = 0; i < mennyit; i++) {
                                valozo += (int) Math.ceil(levonas * 1.1);

                                sajat.setPenz(sajat.getPenz() - levonas);
                                levonas = (int) Math.ceil(levonas * 1.1);
                            }

                            System.out.println("Ennyi pénzedbe került: " + valozo);
                        } else {
                            System.err.println("Támadásod elérte a maximumot!");
                        }
                    } else {
                        valozo = levonasutan;
                        levonas = valozoutan;
                        System.err.println("Nincs elég pénzed hogy ennyit vegyél. Így visszajutsz a főmenübe.");
                        System.out.println();
                        System.out.println("""
                                -----------------------------------------------------
                                Ez a menü, választanod kell egy számot, vagy szót:\s
                                1: Tulajdonságok
                                2: Egységek
                                3. Varázslatok vétele
                                4: Csata indítása
                                kilepek: Főmenübe lépés
                                -----------------------------------------------------""");
                        break;
                    }
                } else if (nev.equals("vedekezes")) {
                    System.out.println("Mennyit szeretnél venni? (1-9)");
                    nev = beolvas.nextLine();
                    try {
                        mennyit += Integer.parseInt(nev);
                    } catch (Exception e) {
                        System.err.println("Baj van. Rossz az input....");
                    }
                    int levonasutan = valozo;
                    int valozoutan = levonas;
                    for (int i = 0; i < mennyit - 1; i++) {
                        valozo += (int) Math.ceil(levonas * 1.1);
                        levonas = (int) Math.ceil(levonas * 1.1);
                    }
                    if (Hos.sajat.getPenz() - valozo >= 0) {
                        valozo=levonasutan;
                        levonas=valozoutan;
                        if (sajat.getVedekezes() < 10 && (mennyit > 0 && mennyit < 10)) {
                            sajat.setVedekezes(sajat.getVedekezes() + mennyit);
                            System.out.println("Vedekezes megnovelve, jelenleg: " + sajat.getVedekezes());
                            for (int i = 0; i < mennyit - 1; i++) {
                                valozo += (int) Math.ceil(levonas * 1.1);

                                sajat.setPenz(sajat.getPenz() - levonas);
                                levonas = (int) Math.ceil(levonas * 1.1);

                            }

                            System.out.println("Ennyi pénzedbe került: " + valozo);
                        } else {
                            System.err.println("Vedekezes elérte a maximumot! ((Vagy nagy a szám, amit adtál..))");
                        }
                    } else {
                        valozo = levonasutan;
                        levonas = valozoutan;
                        System.err.println("Nincs elég pénzed hogy ennyit vegyél. Így visszajutsz a főmenübe.");
                        System.out.println();
                        System.out.println("""
                                -----------------------------------------------------
                                Ez a menü, választanod kell egy számot, vagy szót:\s
                                1: Tulajdonságok
                                2: Egységek
                                3. Varázslatok vétele
                                4: Csata indítása
                                kilepek: Főmenübe lépés
                                -----------------------------------------------------""");
                        break;
                    }


                }
                else if (nev.equals("varazsero")) {
                    System.out.println("Mennyit szeretnél venni? (1-9)");
                    nev = beolvas.nextLine();
                    try {
                        mennyit += Integer.parseInt(nev);
                    } catch (Exception e) {
                        System.err.println("Baj van. Rossz az input....");
                    }
                    int levonasutan = valozo;
                    int valozoutan = levonas;
                    for (int i = 0; i < mennyit - 1; i++) {
                        valozo += (int) Math.ceil(levonas * 1.1);
                        levonas = (int) Math.ceil(levonas * 1.1);
                    }
                    if (Hos.sajat.getPenz() - valozo >= 0) {
                        valozo=levonasutan;
                        levonas=valozoutan;
                        if (sajat.getVarazsero() < 10 && (mennyit > 0 && mennyit < 10)) {
                            sajat.setVarazsero(sajat.getVarazsero() + mennyit);
                            System.out.println("Tudas megnovelve, jelenleg: " + sajat.getVarazsero());
                            for (int i = 0; i < mennyit - 1; i++) {
                                valozo += (int) Math.ceil(levonas * 1.1);

                                sajat.setPenz(sajat.getPenz() - levonas);
                                levonas = (int) Math.ceil(levonas * 1.1);

                            }

                            System.out.println("Ennyi pénzedbe került: " + valozo);
                        } else {
                            System.err.println("Tudas elérte a maximumot! ((Vagy nagy a szám, amit adtál..))");
                        }
                    } else {
                        valozo = levonasutan;
                        levonas = valozoutan;
                        System.err.println("Nincs elég pénzed hogy ennyit vegyél. Így visszajutsz a főmenübe.");
                        System.out.println();
                        System.out.println("""
                                -----------------------------------------------------
                                Ez a menü, választanod kell egy számot, vagy szót:\s
                                1: Tulajdonságok
                                2: Egységek
                                3. Varázslatok vétele
                                4: Csata indítása
                                kilepek: Főmenübe lépés
                                -----------------------------------------------------""");
                        break;
                    }

                }


                else if (nev.equals("tudas")) {
                    System.out.println("Mennyit szeretnél venni? (1-9)");
                    nev = beolvas.nextLine();
                    try {
                        mennyit += Integer.parseInt(nev);
                    } catch (Exception e) {
                        System.err.println("Baj van. Rossz az input....");
                    }
                    int levonasutan = valozo;
                    int valozoutan = levonas;
                    for (int i = 0; i < mennyit - 1; i++) {
                        valozo += (int) Math.ceil(levonas * 1.1);
                        levonas = (int) Math.ceil(levonas * 1.1);
                    }
                    if (Hos.sajat.getPenz() - valozo >= 0) {
                        valozo=levonasutan;
                        levonas=valozoutan;
                        if (sajat.getTudas() < 10 && (mennyit > 0 && mennyit < 10)) {
                            sajat.setTudas(sajat.getTudas() + mennyit);
                            System.out.println("Tudas megnovelve, jelenleg: " + sajat.getTudas());
                            for (int i = 0; i < mennyit - 1; i++) {
                                valozo += (int) Math.ceil(levonas * 1.1);

                                sajat.setPenz(sajat.getPenz() - levonas);
                                levonas = (int) Math.ceil(levonas * 1.1);

                            }

                            System.out.println("Ennyi pénzedbe került: " + valozo);
                        } else {
                            System.err.println("Tudas elérte a maximumot! ((Vagy nagy a szám, amit adtál..))");
                        }
                    } else {
                        valozo = levonasutan;
                        levonas = valozoutan;
                        System.err.println("Nincs elég pénzed hogy ennyit vegyél. Így visszajutsz a főmenübe.");
                        System.out.println();
                        System.out.println("""
                                -----------------------------------------------------
                                Ez a menü, választanod kell egy számot, vagy szót:\s
                                1: Tulajdonságok
                                2: Egységek
                                3. Varázslatok vétele
                                4: Csata indítása
                                kilepek: Főmenübe lépés
                                -----------------------------------------------------""");
                            break;
                    }

                } else if (nev.equals("moral")) {
                    System.out.println("Mennyit szeretnél venni? (1-9)");
                    nev = beolvas.nextLine();
                    try {
                        mennyit += Integer.parseInt(nev);
                    } catch (Exception e) {
                        System.err.println("Baj van. Rossz az input....");
                    }
                    int levonasutan = valozo;
                    int valozoutan = levonas;
                    for (int i = 0; i < mennyit - 1; i++) {
                        valozo += (int) Math.ceil(levonas * 1.1);
                        levonas = (int) Math.ceil(levonas * 1.1);
                    }
                    valozo=levonasutan;
                    levonas=valozoutan;
                    if (Hos.sajat.getPenz() - valozo >= 0) {
                        if (sajat.getMoral() < 10 && (mennyit > 0 && mennyit < 10)) {
                            sajat.setMoral(sajat.getMoral() + mennyit);
                            System.out.println("Vedekezes megnovelve, jelenleg: " + sajat.getMoral());
                            for (int i = 0; i < mennyit - 1; i++) {
                                valozo += (int) Math.ceil(levonas * 1.1);

                                sajat.setPenz(sajat.getPenz() - levonas);
                                levonas = (int) Math.ceil(levonas * 1.1);

                            }

                            System.out.println("Ennyi pénzedbe került: " + valozo);
                        } else {
                            System.err.println("Moralod elérte a maximumot! ((Vagy nagy a szám, amit adtál..))");
                        }
                    } else {
                        valozo = levonasutan;
                        levonas = valozoutan;
                        System.err.println("Nincs elég pénzed hogy ennyit vegyél. Így visszajutsz a főmenübe.");
                        System.out.println();
                        System.out.println("""
                                -----------------------------------------------------
                                Ez a menü, választanod kell egy számot, vagy szót:\s
                                1: Tulajdonságok
                                2: Egységek
                                3. Varázslatok vétele
                                4: Csata indítása
                                kilepek: Főmenübe lépés
                                -----------------------------------------------------""");
                        break;
                    }


                } else if (nev.equals("szerencse")) {
                    System.out.println("Mennyit szeretnél venni? (1-9)");
                    nev = beolvas.nextLine();
                    try {
                        mennyit += Integer.parseInt(nev);
                    } catch (Exception e) {
                        System.err.println("Baj van. Rossz az input....");
                    }
                    int levonasutan = valozo;
                    int valozoutan = levonas;
                    for (int i = 0; i < mennyit - 1; i++) {
                        valozo += (int) Math.ceil(levonas * 1.1);
                        levonas = (int) Math.ceil(levonas * 1.1);
                    }
                    if (Hos.sajat.getPenz() - valozo >= 0) {
                        System.out.println(valozo);
                        valozo = levonasutan;
                        levonas = valozoutan;
                        if (sajat.getSzerencse() < 10 && (mennyit > 0 && mennyit < 10)) {
                            sajat.setSzerencse(sajat.getSzerencse() + mennyit);
                            System.out.println("Szerencsed megnovelve, jelenleg: " + sajat.getVedekezes());
                            for (int i = 0; i < mennyit - 1; i++) {
                                valozo += (int) Math.ceil(levonas * 1.1);

                                sajat.setPenz(sajat.getPenz() - levonas);
                                levonas = (int) Math.ceil(levonas * 1.1);

                            }

                            System.out.println("Ennyi pénzedbe került: " + valozo);
                        } else {
                            System.err.println("Szerencsed elérte a maximumot! ((Vagy nagy a szám, amit adtál..))");
                        }
                    } else {
                        valozo = levonasutan;
                        levonas = valozoutan;
                        System.err.println("Nincs elég pénzed hogy ennyit vegyél. Így visszajutsz a főmenübe.");
                        System.out.println();
                        System.out.println("""
                                -----------------------------------------------------
                                Ez a menü, választanod kell egy számot, vagy szót:\s
                                1: Tulajdonságok
                                2: Egységek
                                3. Varázslatok vétele
                                4: Csata indítása
                                kilepek: Főmenübe lépés
                                -----------------------------------------------------""");
                        break;
                    }


                }
                else {
                    if (nev.equals("kilepek")) {
                        System.out.println("A főmenübe léptél!");
                        System.out.println("""
                                -----------------------------------------------------
                                Ez a menü, választanod kell egy számot, vagy szót:\s
                                1: Tulajdonságok
                                2: Egységek
                                3. Varázslatok vétele
                                4: Csata indítása
                                kilepek: Főmenübe lépés
                                -----------------------------------------------------""");
                        break;
                    } else {
                        System.err.println("Nem jo inputot adtal meg!!!!!");
                    }
                }
            }
            if (nev.equals("kilepek")){
                System.out.println("A főmenübe léptél!");
                System.out.println("""
                                -----------------------------------------------------
                                Ez a menü, választanod kell egy számot, vagy szót:\s
                                1: Tulajdonságok
                                2: Egységek
                                3. Varázslatok vétele
                                4: Csata indítása
                                kilepek: Főmenübe lépés
                                -----------------------------------------------------""");
            }
        }

          */

        String nev = null;
        int valtozo = 5;

        String amount=null;
        while (!Objects.equals(nev, "kilepek")) {

            Scanner beolvas = new Scanner(System.in);
            nev = beolvas.nextLine();

            int mennyit = 0;
            if (nev.equals("tamadas")){
                System.out.println("Mennyi támadást szeretnél venni? (1-9)");
                amount=beolvas.nextLine();
                try {
                    mennyit += Integer.parseInt(amount);
                } catch (Exception e) {
                    System.err.println("Baj van. Rossz az input....");
                }
                int elment = levonas;
                int elment2=vegosszeg;
                for (int i = 0; i < mennyit-1; i++) {
                    levonas= (int) Math.ceil(levonas*1.1);
                    vegosszeg+=levonas;
                }

                if (Hos.sajat.getPenz()-vegosszeg>=0) {
                    levonas=elment;
                    vegosszeg=elment2;
                    if (Hos.sajat.getTamadas()<=10&&mennyit>0&&mennyit<10){

                        for (int i = 0; i < mennyit; i++) {
                            vegosszeg+=levonas;
                            levonas= (int) Math.ceil(levonas*1.1);

                        }
                        Hos.sajat.setTamadas(Hos.sajat.getTamadas()+mennyit);
                        System.out.println(mennyit+" támadást vettél! Jelenleg van: "+Hos.sajat.getTamadas()+". Ennyi pénzedbe került: "+vegosszeg+".");
                    }
                    else{
                        System.err.println("Nem jó a mennyiség... Újra írd be a tulajdonság nevét, pl: tamadas");
                    }
                }
                else{
                    levonas=elment;
                    System.err.println("Nincs elég pénzed ennyit venni.");
                }

            }
            else if (nev.equals("vedekezes")){
                System.out.println("Mennyi védekezést szeretnél venni? (1-9)");
                amount=beolvas.nextLine();
                try {
                    mennyit += Integer.parseInt(amount);
                } catch (Exception e) {
                    System.err.println("Baj van. Rossz az input....");
                }
                int elment = levonas;
                int elment2=vegosszeg;
                for (int i = 0; i < mennyit-1; i++) {
                    levonas= (int) Math.ceil(levonas*1.1);
                    vegosszeg+=levonas;
                }

                if (Hos.sajat.getPenz()-vegosszeg>=0) {
                    levonas=elment;
                    vegosszeg=elment2;
                    if (Hos.sajat.getVedekezes()<=10&&mennyit>0&&mennyit<10){

                        for (int i = 0; i < mennyit; i++) {
                            vegosszeg+=levonas;
                            levonas= (int) Math.ceil(levonas*1.1);

                        }
                        Hos.sajat.setVedekezes(Hos.sajat.getVedekezes()+mennyit);
                        System.out.println(mennyit+" védekezést vettél! Jelenleg van: "+Hos.sajat.getVedekezes()+". Ennyi pénzedbe került: "+vegosszeg+".");
                    }
                    else{
                        System.err.println("Nem jó a mennyiség... Újra írd be a tulajdonság nevét, pl: tamadas");
                    }
                }
                else{
                    levonas=elment;
                    System.err.println("Nincs elég pénzed ennyit venni.");
                }

            }
            else if (nev.equals("varazsero")){
                System.out.println("Mennyi varázserőt szeretnél venni? (1-9)");
                amount=beolvas.nextLine();
                try {
                    mennyit += Integer.parseInt(amount);
                } catch (Exception e) {
                    System.err.println("Baj van. Rossz az input....");
                }
                int elment = levonas;
                int elment2=vegosszeg;
                for (int i = 0; i < mennyit-1; i++) {
                    levonas= (int) Math.ceil(levonas*1.1);
                    vegosszeg+=levonas;
                }

                if (Hos.sajat.getPenz()-vegosszeg>=0) {
                    levonas=elment;
                    vegosszeg=elment2;
                    if (Hos.sajat.getVarazsero()<=10&&mennyit>0&&mennyit<10){

                        for (int i = 0; i < mennyit; i++) {
                            vegosszeg+=levonas;
                            levonas= (int) Math.ceil(levonas*1.1);

                        }
                        Hos.sajat.setVarazsero(Hos.sajat.getVarazsero()+mennyit);
                        System.out.println(mennyit+" varázserőt vettél! Jelenleg van: "+Hos.sajat.getVarazsero()+". Ennyi pénzedbe került: "+vegosszeg+".");
                    }
                    else{
                        System.err.println("Nem jó a mennyiség... Újra írd be a tulajdonság nevét, pl: tamadas");
                    }
                }
                else{
                    levonas=elment;
                    System.err.println("Nincs elég pénzed ennyit venni.");
                }

            }
            else if (nev.equals("tudas")){
                System.out.println("Mennyi tudást szeretnél venni? (1-9)");
                amount=beolvas.nextLine();
                try {
                    mennyit += Integer.parseInt(amount);
                } catch (Exception e) {
                    System.err.println("Baj van. Rossz az input....");
                }
                int elment = levonas;
                int elment2=vegosszeg;
                for (int i = 0; i < mennyit-1; i++) {
                    levonas= (int) Math.ceil(levonas*1.1);
                    vegosszeg+=levonas;
                }

                if (Hos.sajat.getPenz()-vegosszeg>=0) {
                    levonas=elment;
                    vegosszeg=elment2;
                    if (Hos.sajat.getTudas()<=10&&mennyit>0&&mennyit<10){

                        for (int i = 0; i < mennyit; i++) {
                            vegosszeg+=levonas;
                            levonas= (int) Math.ceil(levonas*1.1);

                        }
                        Hos.sajat.setTudas(Hos.sajat.getTudas()+mennyit);
                        System.out.println(mennyit+" tudást vettél! Jelenleg van: "+Hos.sajat.getTudas()+". Ennyi pénzedbe került: "+vegosszeg+".");
                    }
                    else{
                        System.err.println("Nem jó a mennyiség... Újra írd be a tulajdonság nevét, pl: tamadas");
                    }
                }
                else{
                    levonas=elment;
                    System.err.println("Nincs elég pénzed ennyit venni.");
                }

            }
            else if (nev.equals("moral")){
                System.out.println("Mennyi morál szeretnél venni? (1-9)");
                amount=beolvas.nextLine();
                try {
                    mennyit += Integer.parseInt(amount);
                } catch (Exception e) {
                    System.err.println("Baj van. Rossz az input....");
                }
                int elment = levonas;
                int elment2=vegosszeg;
                for (int i = 0; i < mennyit-1; i++) {
                    levonas= (int) Math.ceil(levonas*1.1);
                    vegosszeg+=levonas;
                }

                if (Hos.sajat.getPenz()-vegosszeg>=0) {
                    levonas=elment;
                    vegosszeg=elment2;
                    if (Hos.sajat.getMoral()<=10&&mennyit>0&&mennyit<10){

                        for (int i = 0; i < mennyit; i++) {
                            vegosszeg+=levonas;
                            levonas= (int) Math.ceil(levonas*1.1);

                        }
                        Hos.sajat.setMoral(Hos.sajat.getMoral()+mennyit);
                        System.out.println(mennyit+" morált vettél! Jelenleg van: "+Hos.sajat.getMoral()+". Ennyi pénzedbe került: "+vegosszeg+".");
                    }
                    else{
                        System.err.println("Nem jó a mennyiség... Újra írd be a tulajdonság nevét, pl: tamadas");
                    }
                }
                else{
                    levonas=elment;
                    System.err.println("Nincs elég pénzed ennyit venni.");
                }

            }
            else if (nev.equals("szerencse")){
                System.out.println("Mennyi szerencsét szeretnél venni? (1-9)");
                amount=beolvas.nextLine();
                try {
                    mennyit += Integer.parseInt(amount);
                } catch (Exception e) {
                    System.err.println("Baj van. Rossz az input....");
                }
                int elment = levonas;
                int elment2=vegosszeg;
                for (int i = 0; i < mennyit-1; i++) {
                    levonas= (int) Math.ceil(levonas*1.1);
                    vegosszeg+=levonas;
                }

                if (Hos.sajat.getPenz()-vegosszeg>=0) {
                    levonas=elment;
                    vegosszeg=elment2;
                    if (Hos.sajat.getSzerencse()<=10&&mennyit>0&&mennyit<10){

                        for (int i = 0; i < mennyit; i++) {
                            vegosszeg+=levonas;
                            levonas= (int) Math.ceil(levonas*1.1);

                        }
                        Hos.sajat.setSzerencse(Hos.sajat.getSzerencse()+mennyit);
                        System.out.println(mennyit+" szerencsét vettél! Jelenleg van: "+Hos.sajat.getSzerencse()+". Ennyi pénzedbe került: "+vegosszeg+".");
                    }
                    else{
                        System.err.println("Nem jó a mennyiség... Újra írd be a tulajdonság nevét, pl: tamadas");
                    }
                }
                else{
                    levonas=elment;
                    System.err.println("Nincs elég pénzed ennyit venni.");
                }

            }
            else{
                if (nev.equals("kilepek")){


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
                }
                else {
                    System.err.println("Nem jó input!! Tulajdonságot írj be. pl: tamadas");
                }
            }



        }
    }
}










