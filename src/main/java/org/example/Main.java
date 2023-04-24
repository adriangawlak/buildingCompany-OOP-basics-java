package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        DzialPracownikow rzemieslnicy = DzialPracownikow.createDzial("Rzemieslnicy");
        DzialPracownikow hr = DzialPracownikow.createDzial("HR");
        DzialPracownikow management = DzialPracownikow.createDzial("Management");
        // Powielona nazwa działu -> Exception
        DzialPracownikow hr2 = DzialPracownikow.createDzial("HR");

        // Tworzymy obiekty klas Kopacz, Brygadzista, Specjalista, Uzytkownik oraz wywołujemy ich metody
        Kopacz kopacz1 = new Kopacz("Zenon", "Nowak", "1970-01-01", rzemieslnicy, "kilof");
        Kopacz kopacz2 = new Kopacz("Marian", "Kwiatkowski", "1978-02-02", rzemieslnicy, "koparka");
        Kopacz kopacz3 = new Kopacz("Krzysztof", "Ibisz", "1940-12-12", rzemieslnicy, "wywrotka");
        Kopacz kopacz4 = new Kopacz("Katarzyna", "Cichopek", "1920-04-01", rzemieslnicy, "walec");

        Brygadzista brygadzista1 = new Brygadzista("Adam", "Czajkowki", "1965-03-03", rzemieslnicy, "adam123","mojehaslo123");
        Brygadzista brygadzista2 = new Brygadzista("Paweł", "Cichy", "1960-04-04", rzemieslnicy, "pawel123", "mojehaslo123");

        Specjalista specjalista1 = new Specjalista("Zofia", "Olkiewicz", "1980-05-05", management, "finanse");
        Specjalista specjalista2 = new Specjalista("Ewa", "Zielinska", "1990-06-06", hr, "rekrutacja");

        Uzytkownik uzytkownik1 = new Uzytkownik("Marta", "Bartkowiak", "1995-07-07", management, "marta1", "tajnehaslo123");
        Uzytkownik uzytkownik2 = new Uzytkownik("Bartosz", "Antkowiak", "1988-08-08", management, "bartek1", "tajnehaslo123");
        uzytkownik2.updateName("Tadeusz", "Kowalski");

        // Tworzymy obiekty klasy Brygada oraz wywołujemy metody
        Brygada brygada1 = new Brygada("Drużyna A", brygadzista1);
        ArrayList<Pracownik> obsada1 = new ArrayList<>(Arrays.asList(kopacz1, kopacz2, specjalista1));
        Brygada brygada2 = new Brygada("Grupa Mozarta", brygadzista2, obsada1);

        ArrayList<Pracownik> obsada2 = new ArrayList<>(Arrays.asList(kopacz3, kopacz4));
        Brygada brygada3 = new Brygada("Paranienormalni", brygadzista1, obsada2);

        brygada2.addToBrygada(kopacz3);
        brygada2.addToBrygada(obsada2);
        brygada2.addToBrygada(obsada2); // Podwójne elementy z listy nie są dodawane
        System.out.println("\nUaktualniona Brygada 2" + brygada2);

        System.out.println("\nBrygada 3:" + brygada3);


        // Obiekty klasy Praca, Zlecenie oraz ich metody
        Praca praca1 = new Praca(RodzajPracy.MONTAZ,  0.05, "Montaz umywalki");
        Praca praca2 = new Praca(RodzajPracy.MONTAZ, 0.05, "Montaż drzwi");
        Praca praca3 = new Praca(RodzajPracy.WYMIANA, 0.1, "Wymiana parkietu");
        Praca praca4 = new Praca(RodzajPracy.WYMIANA, 0.08, "Wymiana okna");
        Praca praca5 = new Praca(RodzajPracy.DEMONTAZ, 0.02, "Wyburzanie ściany");
        Praca praca6 = new Praca(RodzajPracy.DEMONTAZ, 0.02, "Demontaż wanny");
        Praca praca7 = new Praca(RodzajPracy.OGOLNA, 0.15, "Sprzątanie końcowe");
        Praca praca8 = new Praca(RodzajPracy.OGOLNA, 0.1, "Malowanie");
        // Przykład zwrotu Pracy z mapy
        System.out.println(Praca.getPraca(3));


        Zlecenie zlecenie1 = new Zlecenie(true);
        zlecenie1.addBrygada(brygada3);

        Zlecenie zlecenie2 = new Zlecenie(false, brygada1);

        ArrayList<Praca> listaPrac1 = new ArrayList<>(Arrays.asList(praca1, praca2));
        Zlecenie zlecenie3 = new Zlecenie(false, listaPrac1);

        ArrayList<Praca> listaPrac2 = new ArrayList<>(Arrays.asList(praca3, praca4, praca7));

        ArrayList<Praca> listaPrac3 = new ArrayList<>(Arrays.asList(praca5, praca6, praca8));
        Zlecenie zlecenie4 = new Zlecenie(true, listaPrac3, brygada2);
        zlecenie4.addPraca(praca7);
        // Zwrot Zlecenia z mapy
        System.out.println(Zlecenie.getZlecenie(2));

        // Wydruk listy brygad i zleceń konkretnego brygadzisty
        System.out.println("\nLista brygad brygadzisty: \n" + brygadzista1.listaBrygad);

        System.out.println("\nLista zleceń brygadzisty: " + brygadzista1 + " " + brygadzista1.listaZlecen + "\n");

        // Drukowanie wszystkich pracownikow danego dzialu
        rzemieslnicy.printPracownicy();

        // Realizacja zlecenia nr 4 - gdzie prace wykonywane są po kolei z listy prac przydzielonej do zlecenia.
        // Czas wykonania każdej pracy w ramach listy jest równy czasowi pracy wprowadzonemu podczas tworzenia obiektu Praca.
        System.out.println("\nPrzykład realizacji zlecenia - użycie wątków");
        zlecenie4.rozpocznijZlecenie();

    }
}

