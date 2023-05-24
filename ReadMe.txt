Üdvözletem!


A játékot érdemes IDEA-ban futtatni. 
	Ha terminállal futtatnád (de inkább idea pls): Belépsz a kicsomagolt mappába a terminállal, (cd a parancs mappába való lépéshez, pl: cd src) ott az src mappába, majd írd be, hogy: javac *.java . Utána pedig hogy Jatek.java
	És fut is!


A plussz egységek amiket kitaláltam, az a cerberus, és a törpe.
Vagyis a cerberus alap játékbeli elem az eredetiben is.
	Cerberus:  
		támadóerő: 3-6
		életerő: 20
		sebesség: 4
		kezdeményezés: 20
		ár: 20
		képesség: Kétszer tud támadni. Ha már több feje van, ugye. 

	Törpe:  
		támadóerő: 10
		életerő: 10
		sebesség: 10
		kezdeményezés: 10
		ár: 10
		képesség: Sokan vannak, és gyorsak, erősek, ám könnyen sebződnek. Minden kör végén hívja a haverját, és +1 egység érkezik a csapathoz


A plussz képességek:
	Gyorsítás: Véglegesen növeli a kiválasztott saját egység sebességét 1 ponttal. Mana: 8 ár: 60
	Lassítás: Véglegesen csökkenti az ellenfél egységének sebességét 1 ponttal. Mana: 7 ár: 60


Fontos: Ha véletlen valamire nem reagál (ritkán, de előfordul), akkor üss egy entert, vagy próbáld meg a kilepek inputot.

Játék menete:

	1. Választanod kell egy nehézségi szintet. kulcsszavak: konnyu, kozepes, nehez
	2. A főmenü. Itt navigálni számokkal, tudsz javarészt. (1- tulajdonságok , 2- egységek, stb..). A játék is ír részletesen mindent, hogy mit tudsz csinálni. Ha belépsz egy menüpontba, a kilepek kulcsszó 	segítségével tudsz kilépni. (pl.: beírod azt, hogy: “1” . Ez a tulajdonságok menübe visz. Kilépni onnan a kilepek inputtal tudsz.)
	Ha belépsz egy menüpontba, ott tudsz vásárolni. Elsőnek meg kell adni hogy mit. (pl: tamadas ((tulajdonságoknál van)), vagy griff ((egységeknél van)). Másodiknak hogy 	mennyit.
		
		1. menüpont: tulajdonságok	[a tulajdonság nevét kell beírni kisbetűvel, ékezet nélkül]
		2. menüpont: egységek	[az egység nevét kell beírni kisbetűvel, ékezet nélkül]
		3. menüpont: varázslatok [a varázslatok nevét kell beírni kisbetűvel, ékezet nélkül]
		4. menüpont: a csata indítása. Érdemes az előkészületek után megtenni.
		5. menüpont: Áttekintés. Érdemes lehet megnézni a csata előtt, hogy mennyi pénzed maradt, hátha tudsz még venni valamit.

	Ha beállítottál mindent, csak akkor menj rá a 4-es menüpontra. Ezt a “4” inputtal tudod megtenni. Egység nélkül nem indul el.
	Ha megtetted, helyet kell választani az egységeidnek. Itt is ír mindent, 0 vagy 1-es oszlop, itt a számot várja inputnak, sor ugyanez, csak ott 0-tól 9-ig.
	Utána megkérdezi, hogy megnézed-e az ellenfeled. (igen/nem) inputot vár.
	Elkezdődik a csata.
		!!!!Az egységek átkonvertálódnak csata előtt, a láthatóság reményében.
			Kettő karakteres lesz a nevük. Értsd: ST, EC, ET, stb.

			ezek jelentése: 
				első betű:
							 S - saját
							 E - ellenfél/ellenséges.
			      második betű:
			 				  F - földműves
							  I - íjász
							  G - griff
							  C - cerberus
							  T - törpe	

	Sorrendben érkeznek az egységek morál alapján. Minden akciót kiír a konzol.
	Az ellenfél lépéseit lepörgeti gyorsan, de ugye írja, és látszik hogy mit csináltak. Az ellenfél egységek egész okosak, első körben a map közepe felé mennek, utána a te 	egységeidet figyeli bizonyos távon belül, és az alapján lép, támad. Ellenfél hős minden körben varázsol vagy támad, akkor, amikor az első egysége következik.
	A te lépésed:
		((Általános szabály: ha rossz inputot adsz meg, akkor újra az az egységed következik, és semmi sem történik a mapon, csak újra kiírja. Ne ijedj meg.))
		4 dolog (input) közül választhatsz: 

		lepes:
			-“2,4,6,8, ennyi” inputot vár.
			Képzeld magad elé a numpadot. Az alapján lépkedsz. 2-le, 4-balra, 6-jobbra, 8-fel. ((Gercsó azt mondta nincs akadálya az egyesével lépkedésnek, bocsi :()
			
			-“ennyi” : (lepesen belüli input) Ha maradt még lépésed, de nem szeretnél többet lépni, ekkor a következő egység jön.
		
		tamadas: Szimpla támadás, közeledben levők közül választhatsz, rövidített nevet vár inputként,. pl: ET.
					Ugyanaz az egységed jön, ha nem tudsz támadni, vagy rossz az input, arra, akit támadni akarsz.
			Ha az SI (Saját íjász) egység következik, akkor bárhonnan tudsz támadni. Viszont ehhez előbb be kell írnod hogy: lepes. Utána, hogy: tamadas. Ha nincs körülötte 					  			senki, akkor tudsz távolra támadni, bárkit, aki nem saját egység. Szintén rövidített nevet kell beírnod.

		varakozas:
		Az egységed várakozik, nem csinál semmit.

		hos:
			A hősöd jön. Ez körönként egyszer teheted meg, bármelyik egységed előtt.
			Ekkora kettő dolgot választhatsz, varázslás vagy támadás. (varazslas, tamadas)
			Varázsolni csak akkor tudsz, ha megvetted a varázslatot. A varázslat nevét fogja kérni, kisbetűvel, ékezet nélkül (villamcsapas, tuzlabda, feltamasztas, gyorsitas, 			lassitas). Általában az ellenfél nevét kéri rövidítve, viszont gyorsításnál a saját egységed nevét.
			Támadni pedig tudsz a hősöddel, nem korlátozza semmi.

		allas:
			Megmutatja az egységeket, támadóerejüket, és életerejüket. Újra a te egységed jön, csak újra kiírja a mapot. A felett lesz az állás.
			

		Jó játékot!

((Ha véletlen valami nem működik, keress meg: Kiss Mihály))




