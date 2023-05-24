import java.util.Objects;
import java.util.Scanner;

public class Varazslatok {
    int ar;
    private int manna;

    static Tuzlabda tuzlabda = new Tuzlabda(120, 9);
    static Feltamasztas feltamasztas= new Feltamasztas(120, 6);
    static Villamcsapas villamcsapas= new Villamcsapas(60,5);
    static Lassitas lassitas=new Lassitas(50, 8);
    static Gyorsitas gyorsitas=new Gyorsitas(50, 7);

    public Varazslatok(int ar, int manna) {

    }

    public static void varazslatok() {

        String nev = null;
        int szam = 0;
        villamcsapas.ar=60;
        lassitas.ar=50;
        gyorsitas.ar=50;
        feltamasztas.ar=120;
        tuzlabda.ar=120;
        while (!Objects.equals(nev, "kilepek")) {
            Scanner beolvas = new Scanner(System.in);
            nev = beolvas.nextLine();
            if (nev.equals("tuzlabda")) {
                if (!SajatHos.sajat.isTuzlabda()) {
                    if (tuzlabda.ar <= SajatHos.sajat.getPenz()) {
                        SajatHos.sajat.setPenz(SajatHos.sajat.getPenz() - (tuzlabda.ar));
                        Hos.sajat.setTuzlabda(true);
                        System.out.println("Tűzlabda varázslatot vettél!");

                    } else {
                        System.err.println("Nincs elég pénzed, hogy tűzlabdát vegyél! Visszakerülsz a főmenübe!");
                        break;
                    }
                }
                else {
                    System.out.println("Már vettél tűzlabdát!");
                }
            }
            else if (nev.equals("feltamasztas")) {
                if (!SajatHos.sajat.isFeltamasztas()) {

                    if (feltamasztas.ar <= SajatHos.sajat.getPenz()) {
                        SajatHos.sajat.setPenz(SajatHos.sajat.getPenz() - (feltamasztas.ar));
                        Hos.sajat.setFeltamasztas(true);
                        System.out.println("Feltámasztás varázslatot vettél!");

                    } else {
                        System.err.println("Nincs elég pénzed, hogy feltámasztást vegyél! Visszakerülsz a főmenübe!");
                        break;
                    }
                }
                else {
                    System.out.println("Már vettél feltámasztást!");
                }
            }
            else if (nev.equals("gyorsitas")) {
                if (!SajatHos.sajat.isGyorsitas()) {

                    if (gyorsitas.ar <= SajatHos.sajat.getPenz()) {
                        SajatHos.sajat.setPenz(SajatHos.sajat.getPenz() - (gyorsitas.ar));
                        Hos.sajat.setGyorsitas(true);
                        System.out.println("Gyorsítás varázslatot vettél!");

                    } else {
                        System.err.println("Nincs elég pénzed, hogy gyorsítást vegyél! Visszakerülsz a főmenübe!");
                        break;
                    }
                }
                else {
                    System.out.println("Már vettél gyorsítást!");
                }
            }

            else if (nev.equals("villamcsapas")) {
                if (!SajatHos.sajat.isVillamcsapas()) {

                    if (villamcsapas.ar <= SajatHos.sajat.getPenz()) {
                        SajatHos.sajat.setPenz(SajatHos.sajat.getPenz() - (villamcsapas.ar));
                        Hos.sajat.setVillamcsapas(true);
                        System.out.println("Villamcsapás varázslatot vettél!");

                    } else {
                        System.err.println("Nincs elég pénzed, hogy villámcsapást vegyél! Visszakerülsz a főmenübe!");
                        break;
                    }
                }
                else {
                    System.out.println("Már vettél villámcsapást!");
                }
            }
            else if (nev.equals("lassitas")) {
                if (!SajatHos.sajat.isLassitas()) {

                    if (lassitas.ar <= SajatHos.sajat.getPenz()) {
                        SajatHos.sajat.setPenz(SajatHos.sajat.getPenz() - (lassitas.ar));
                        Hos.sajat.setLassitas(true);
                        System.out.println("Lassítás varázslatot vettél!");

                    } else {
                        System.err.println("Nincs elég pénzed, hogy lassítást vegyél! Visszakerülsz a főmenübe!");
                        break;
                    }
                }
                else {
                    System.out.println("Már vettél lassítást!");
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
