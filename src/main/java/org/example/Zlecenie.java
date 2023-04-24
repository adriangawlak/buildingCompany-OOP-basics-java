package org.example;

import java.time.LocalDateTime;
import java.util.*;

public class Zlecenie {
    static int numerZlecenia = 0;
    protected int aktualnyNumerZlecenia;
    private List<Praca> listaPrac = new ArrayList<>();
    private Brygada brygada;
    StanZlecenia stanZlecenia;
    // stan zlecenia - enum(Planowane, Nieplanowane, Realizowane, Zakonczone)
    private LocalDateTime dataUtworzenia;
    private LocalDateTime dataRealizacji;
    private LocalDateTime dataZakonczenia;
    static Map<Integer, Zlecenie> mapZlecenia = new HashMap<>();

    public Zlecenie(boolean czyPlanowane){
        if (czyPlanowane)
            this.stanZlecenia = StanZlecenia.PLANOWANE;
        else
            this.stanZlecenia = StanZlecenia.NIEPLANOWANE;

        this.dataUtworzenia = LocalDateTime.now();
        this.aktualnyNumerZlecenia = ++numerZlecenia;
        this.dataRealizacji = null;
        this.dataZakonczenia = null;
        this.brygada = null;
        mapZlecenia.put(aktualnyNumerZlecenia, this);
    }

    public Zlecenie(boolean czyPlanowane, Brygada brygada){
        this(czyPlanowane);
        this.brygada = brygada;
        brygada.brygadzista.listaZlecen.add(this);
        // dane o zleceniach brygadzisty
    }

    public Zlecenie(boolean czyPlanowane, List<Praca> listaPrac){
        this(czyPlanowane);
        this.listaPrac = listaPrac;
    }

    public Zlecenie(boolean czyPlanowane, List<Praca> listaPrac, Brygada brygada){
        this(czyPlanowane, brygada);
        this.listaPrac = listaPrac;
    }

    public void addPraca(Praca ekstraPraca){
        this.listaPrac.add(ekstraPraca);
    }

    public boolean addBrygada(Brygada brygada){
        if (this.brygada == null){
            this.brygada = brygada;
            brygada.brygadzista.listaZlecen.add(this);
            return true;
        } else
            return false;
    }

    public void rozpocznijZlecenie() throws InterruptedException {
        if(this.brygada != null && !(this.listaPrac.isEmpty())){
            this.stanZlecenia = StanZlecenia.REALIZOWANE;
            this.dataRealizacji = LocalDateTime.now();
            System.out.println("\nZlecenie " + aktualnyNumerZlecenia + " rozpoczęte. Czas rozpoczęcia " + dataRealizacji);
            for (Praca praca : this.listaPrac){
                praca.start();
                praca.join();
            }
            this.stanZlecenia = StanZlecenia.ZAKONCZONE;
            this.dataZakonczenia = LocalDateTime.now();
            System.out.println("Stan zlecenia: " + stanZlecenia + ", Data zakończenia zlecenia: " + dataZakonczenia);
        }
        else
            System.out.println("To zlecenie jest niekompletne");
    }

    @Override
    public String toString() {
        return "\nZlecenie nr: " + aktualnyNumerZlecenia + ", stan zlecenia: " + stanZlecenia +
                "\nZlecenie ma przypisaną brygadę: " + ((this.brygada != null) ? "Tak" : "Nie") +
                "\nNa liście prac znajdują się przypisane prace: " + ((!(this.listaPrac.isEmpty())) ? "Tak" : "Nie");
    }

    public static Zlecenie getZlecenie(int nrZlecenia){
        return mapZlecenia.get(nrZlecenia);

    }
}
