package org.example;

import java.util.ArrayList;
import java.util.List;
public class DzialPracownikow {
    private String nazwa;
    private static List<String> listaDzialow = new ArrayList<>();
    protected List<Pracownik> pracownicyDzialu = new ArrayList<>();

    private DzialPracownikow(String nazwaDzialu) throws NotUniqueNameException{
        if (listaDzialow.contains(nazwaDzialu))
            throw new NotUniqueNameException();
        else {
            this.nazwa = nazwaDzialu;
            listaDzialow.add(nazwaDzialu);
        }
    }

    public static DzialPracownikow createDzial(String nazwaDzialu){
        try {
            return new DzialPracownikow(nazwaDzialu);
        } catch (NotUniqueNameException e){
            e.printStackTrace();
            return null;
        }
    }

    public void printPracownicy(){
        if (pracownicyDzialu.isEmpty())
            System.out.println("Nie ma pracowników w tym dziale");
        else{
            System.out.print("W dziale " + this.nazwa + " pracują: ");
            for (Pracownik p : pracownicyDzialu)
                System.out.print(p + ", ");
            System.out.println();
        }
    }

    @Override
    public String toString() {
        return "Dział pracowników - " + nazwa;
    }
}
