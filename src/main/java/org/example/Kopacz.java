package org.example;

public class Kopacz extends Pracownik {

    private String narzedziePracy;

    public Kopacz(String imie, String nazwisko, String dataUrodzenia, DzialPracownikow dzialPracownikow, String narzedziePracy) {
        super(imie, nazwisko, dataUrodzenia, dzialPracownikow);
        this.narzedziePracy = narzedziePracy;
    }

    @Override
    public String toString() {
        return "\nKopacz: " + imie + " " + nazwisko + " ur. " + dataUrodzenia;
    }
}
