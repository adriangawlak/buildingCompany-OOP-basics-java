package org.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
public abstract class Pracownik implements Comparable<Pracownik> {
    public static List<Pracownik> listaPracownikow = new ArrayList();

    protected String imie;
    protected String nazwisko;
    protected LocalDate dataUrodzenia;
    private DzialPracownikow dzialPracownikow;

    public Pracownik (String imie, String nazwisko, String dataUrodzenia, DzialPracownikow dzialPracownikow) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.dataUrodzenia = LocalDate.parse(dataUrodzenia, DateTimeFormatter.ISO_LOCAL_DATE);
        // Data urodzenia w formacie YYYY-MM-DD
        this.dzialPracownikow = dzialPracownikow;

        listaPracownikow.add(this);
        dzialPracownikow.pracownicyDzialu.add(this);
    }

    @Override
    public int compareTo(Pracownik o) {
        int nazwiskoResult = this.nazwisko.toLowerCase().compareTo(o.nazwisko.toLowerCase());
        int imieResult = this.imie.toLowerCase().compareTo(o.imie.toLowerCase());
        int dataResult = this.dataUrodzenia.compareTo(o.dataUrodzenia);
        return imieResult != 0 ? imieResult :
                nazwiskoResult != 0 ? nazwiskoResult : dataResult;
    }

    @Override
    public String toString() {
        return "\nPracownik: " + imie + " " + nazwisko + " ur. " + dataUrodzenia;
    }
}


