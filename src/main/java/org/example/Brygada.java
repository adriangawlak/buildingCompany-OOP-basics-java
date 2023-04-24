package org.example;

import java.util.ArrayList;
import java.util.List;
public class Brygada {

    public String nazwa;
    protected Brygadzista brygadzista;
//    private List<Pracownik> listaPracownikow = new ArrayList<>();
    private List<Pracownik> listaPracownikow;

    public Brygada(String nazwa, Brygadzista brygadzista) {
        this(nazwa, brygadzista, new ArrayList<Pracownik>());
    }

    public Brygada(String nazwa, Brygadzista brygadzista, List<Pracownik> listaPracownikow) {
        this.nazwa = nazwa;
        this.brygadzista = brygadzista;
        this.listaPracownikow = new ArrayList<>();
        this.listaPracownikow.addAll(listaPracownikow);
        updateHistoriaBrygadzisty(brygadzista);
    }
    protected void updateHistoriaBrygadzisty(Brygadzista b){
        b.listaBrygad.add(this);
    }

    public void addToBrygada(Pracownik p){
        if (p.getClass() == Uzytkownik.class)
            System.out.println("Brygadzista nie może być użytkownikiem!");
        else if (listaPracownikow.contains(p))
            System.out.println("Ten pracownik jest już w brygadzie");
        else
            listaPracownikow.add(p);
    }

    public void addToBrygada(List<Pracownik> lista) {
        // Sprawdzamy czy nie ma juz danego pracownika w brygadzie, dlatego .add() zamiast .addAll()
        for (Pracownik p : lista){
            if (lista.contains(p))
                continue;
            else
                listaPracownikow.add(p);
        }
    }

    @Override
    public String toString() {
        return "\nBrygada: " + nazwa + brygadzista +
                "\nCzłonkowie brygady: " + listaPracownikow.toString();
    }

}
