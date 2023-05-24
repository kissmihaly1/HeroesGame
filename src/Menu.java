import java.util.Objects;
import java.util.Scanner;

public class Menu {

    public static void nehezseg(){

        Scanner ip2= new Scanner(System.in);
        String input2="Jozsi2";
        System.out.println("--------------------------------------------");
        System.out.println("Légy üdvözölve játékos!\nElső körben válassz nehézséget: 'konnyu', 'kozepes', 'nehez' " +
                "közül választhatsz.(('' jelek nélkül))");

        while(!input2.equals("konnyu")&&!input2.equals("kozepes")&&!input2.equals("nehez")) {
            input2=ip2.nextLine();
            if (input2.equals("konnyu")) {
                SajatHos.sajat.setPenz(1300);
            } else if (input2.equals("kozepes")) {
                SajatHos.sajat.setPenz(1000);
            } else if (input2.equals("nehez")) {
                SajatHos.sajat.setPenz(700);
            } else {
                System.err.println("Nem jó inputot adtál meg!!");
            }
        }
    }

    public static void main() {

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
        System.out.println();
        String input="Jozsi";

        while(!Objects.equals(input, "4")){
            Scanner ip= new Scanner(System.in);
            input=ip.nextLine();
            if (input.equals("kilepek")){
                System.out.println("A főmenübe léptél.");
                main();
            }
            else if(input.equals("1")){
                System.out.println("""
                        -----------------------------------------------------
                        Tulajdonságok menübe léptél.
                           Tamadas novelesehez ird be: tamadas
                           Vedekezes novelesehez ird be: vedekezes
                           Varazsero novelesehez ird be: varazsero
                           Tudas novelesehez ird be: tudas
                           Moral novelesehez ird be: moral
                           Szerencse novelesehez ird be: szerencse
                        Fomenube lepeshez ird be: kilepek
                        -----------------------------------------------------""");
                Hos.tulajdonsagNoveles();
                }
            else if(input.equals("2")){
                System.out.println("""
                 -----------------------------------------------------
                 Egységek menübe léptél.
                 foldmuves: Földműves vásárlása
                 ijasz: Íjász vásárlása
                 griff: Griff vásárlása
                 cerberus: Cerberus vásárlása
                 torpe: Törpe vásárlása
                 Fomenube lepeshez ird be: kilepek
                 -----------------------------------------------------""");
                Egysegek.vasarlas();

            }
            else if(input.equals("3")){
                System.out.println("""
                        -----------------------------------------------------
                        Varázslatok menübe léptél.
                        tuzlabda: Tűzlabda vétele
                        villamcsapas: Villámcsapás vétele
                        feltamasztas: Feltámasztás vétele
                        gyorsitas: Gyorsítás vétele
                        lassitas: Lassítás vétele
                        Fomenube lepeshez ird be: kilepek
                        -----------------------------------------------------
                        """);
                Varazslatok.varazslatok();

            }
            else if(input.equals("5")){

            Helyzet.helyzet();
            }
            else {
                if (input.equals("4")&&(Egysegek.egysegeim[0]!=null||Egysegek.egysegeim[1]!=null||Egysegek.egysegeim[2]!=null||Egysegek.egysegeim[3]!=null||Egysegek.egysegeim[4]!=null)){
                    break;
                }
                else {
                    System.err.println("Nem jó inputot adtál meg, vagy nem vettél egységet.");
                    input="ASD";
                }


            }
            }
        }






    }






