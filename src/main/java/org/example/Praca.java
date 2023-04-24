package org.example;
import java.util.HashMap;
import java.util.Map;
public class Praca extends Thread{

    static int numerPracy = 0;
    public int aktualnyNumerPracy;
    private RodzajPracy rodzajPracy;
    protected double czasPracy;  // podawany w minutach
    private boolean czyZrealizowane;
    private String opis;
    static Map<Integer, Praca> mapPrace = new HashMap<>();

    public Praca (RodzajPracy rodzajPracy, double czasPracy, String opis){
        this.rodzajPracy = rodzajPracy;
        this.czasPracy = czasPracy;
        this.opis = opis;
        this.czyZrealizowane = false;
        this.aktualnyNumerPracy = ++numerPracy;
        mapPrace.put(aktualnyNumerPracy, this);
    }

    public static Praca getPraca(int nrPracy){
        return mapPrace.get(nrPracy);
    }

    @Override
    public String toString() {
        return "\nPraca nr: " + aktualnyNumerPracy + ", rodzaj: " + rodzajPracy + ", czas trwania: " + czasPracy +
                "\nopis: " + opis + ", praca zrealizowana: " + (czyZrealizowane ? "Tak" : "Nie");
    }

    @Override
    public void run(){
        try{
            System.out.println("Aktualnie wykonuję:" + this);
            sleep((long) (this.czasPracy*60*1000));
            czyZrealizowane = true;
            System.out.println("Praca wykonana");
        } catch(InterruptedException e){
            e.printStackTrace();
        }
    }

}
