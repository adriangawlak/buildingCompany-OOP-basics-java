package org.example;

public class Uzytkownik extends Pracownik {

    private String login;
    private String haslo;
    public String inicjal;

    public Uzytkownik(String imie, String nazwisko, String dataUrodzenia, DzialPracownikow dzialPracownikow,
                      String login, String haslo) {
        super(imie, nazwisko, dataUrodzenia, dzialPracownikow);
        this.login = login;
        this.haslo = haslo;
        this.inicjal = Character.toString(imie.charAt(0))+"."+Character.toString(nazwisko.charAt(0))+".";
    }

    public void updateName (String imie, String nazwisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.inicjal = Character.toString(imie.charAt(0))+"."+Character.toString(nazwisko.charAt(0))+".";
    }

    @Override
    public String toString() {
        return "\nUżytkownik: " + imie + " " + nazwisko + ", inicjały: " + inicjal + " ur. " + dataUrodzenia;
    }

}