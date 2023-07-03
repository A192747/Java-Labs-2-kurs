package org.example;
import org.example.AnimalTree.*;
import java.util.Collection;
import java.util.ArrayList;


public class Main {
    public static void segregate(Collection<? extends Chordates> scrCollection,
                                 Collection<? super HedgehogCommon> collection1,
                                 Collection<? super Manul> collection2,
                                 Collection<? super Lynx> collection3) {
        for (var temp : scrCollection)
        {
            if (temp instanceof HedgehogCommon)
            {
                collection1.add((HedgehogCommon) temp);
                (temp).getType();
                System.out.print(" added in to collection1\n");
            }
            if (temp instanceof Manul)
            {
                collection2.add((Manul) temp);
                (temp).getType();
                System.out.print(" added in to collection2\n");

            }
            if (temp instanceof Lynx)
            {
                collection3.add((Lynx) temp);
                (temp).getType();
                System.out.print(" added in to collection3\n");
            }
        }
    }

    public static void main(String[] args){

        ArrayList<Mammals> mammalsSRC = new ArrayList<>(); //млекопитающие
        mammalsSRC.add(new Lynx());                           //рысь
        mammalsSRC.add(new Lynx());
        mammalsSRC.add(new Manul());                          //Манул
        mammalsSRC.add(new HedgehogCommon());                  //еж обыкновенный
        ArrayList<Hedgehogs> hedgehogs = new ArrayList<>();    //ежовые
        ArrayList<Feline> feline = new ArrayList<>();           //Кошачьи
        ArrayList<Predatory> predatory = new ArrayList<>();     //Хищные
        System.out.println("Example 1:\nsegregate(Млекопитающие, Ежовые, Кошачьи, Хищные)");
        segregate(mammalsSRC, hedgehogs, feline, predatory);
        System.out.println();
        


        ArrayList<Predatory> predatorySRC = new ArrayList<>();
        predatorySRC.add(new Lynx());
        predatorySRC.add(new Manul());
        predatorySRC.add(new Lynx());
        predatorySRC.add(new Lynx());
        ArrayList<Chordates> chordates1 = new ArrayList<>();
        ArrayList<Manul> manuls1 = new ArrayList<>();
        ArrayList<Feline> feline1 = new ArrayList<>();
        System.out.println("Example 2:\nsegregate(Хищные, Хордовые, Манулы, Кошачьи)");
        segregate(predatorySRC, chordates1, manuls1, feline1);
        System.out.println();



        ArrayList<HedgehogCommon> hedgehogsSRC = new ArrayList<>();
        hedgehogsSRC.add(new HedgehogCommon());
        hedgehogsSRC.add(new HedgehogCommon());
        ArrayList<Insectivores> insectivores2 = new ArrayList<>();
        ArrayList<Predatory> predatory2 = new ArrayList<>();
        ArrayList<Predatory> predatory3 = new ArrayList<>();
        System.out.println("Example 3:\nsegregate(Ежовые, Насекомоядные, Хищные, Хищные)");
        segregate(hedgehogsSRC, insectivores2, predatory2, predatory3);
        System.out.println();
    }
}