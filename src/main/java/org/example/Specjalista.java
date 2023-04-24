package org.example;

public class Specjalista extends Pracownik {

    private String specjalizacja;

    public Specjalista(String imie, String nazwisko, String dataUrodzenia, DzialPracownikow dzialPracownikow, String specjalizacja) {
        super(imie, nazwisko, dataUrodzenia, dzialPracownikow);
        this.specjalizacja = specjalizacja;
    }

    @Override
    public String toString() {
        return "\nSpecjalista: " + imie + " " + nazwisko + " ur. " + dataUrodzenia + ", specjalizacja: " + specjalizacja;
    }
}
