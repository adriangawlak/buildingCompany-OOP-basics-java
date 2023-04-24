package org.example;
import java.util.ArrayList;
import java.util.List;
public class Brygadzista extends Uzytkownik{

    protected List<Brygada> listaBrygad = new ArrayList<>();
    protected List<Zlecenie> listaZlecen = new ArrayList<>();

    public Brygadzista(String imie, String nazwisko, String dataUrodzenia, DzialPracownikow dzialPracownikow,
                       String login, String haslo) {
        super(imie, nazwisko, dataUrodzenia, dzialPracownikow, login, haslo);
    }

    @Override
    public String toString() {
        return "\nBrygadzista: " + imie + " " + nazwisko + ", inicjały: " + inicjal + " ur. " + dataUrodzenia;
    }
}

