package com.example.Lab7.controller;


import com.example.Lab3.AnimalTree.*;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.util.ArrayList;
import java.util.Collection;


public class Lab3Controller {

    @FXML
    private TextArea output;

    public void segregate(Collection<? extends Chordates> scrCollection,
                                 Collection<? super HedgehogCommon> collection1,
                                 Collection<? super Manul> collection2,
                                 Collection<? super Lynx> collection3) {
        for (var temp : scrCollection)
        {
            if (temp instanceof HedgehogCommon)
            {
                collection1.add((HedgehogCommon) temp);
                output.appendText(temp.getType());
                output.appendText(" added in to collection1\n");
            }
            if (temp instanceof Manul)
            {
                collection2.add((Manul) temp);
                output.appendText(temp.getType());
                output.appendText(" added in to collection2\n");

            }
            if (temp instanceof Lynx)
            {
                collection3.add((Lynx) temp);
                output.appendText(temp.getType());
                output.appendText(" added in to collection3\n");
            }
        }
    }
    @FXML
    private void initialize() {
        ArrayList<Mammals> mammalsSRC = new ArrayList<>(); //млекопитающие
        mammalsSRC.add(new Lynx());                           //рысь
        mammalsSRC.add(new Lynx());
        mammalsSRC.add(new Manul());                          //Манул
        mammalsSRC.add(new HedgehogCommon());                  //еж обыкновенный
        ArrayList<Hedgehogs> hedgehogs = new ArrayList<>();    //ежовые
        ArrayList<Feline> feline = new ArrayList<>();           //Кошачьи
        ArrayList<Predatory> predatory = new ArrayList<>();     //Хищные
        output.appendText("Example 1:\nsegregate(Млекопитающие, Ежовые, Кошачьи, Хищные)\n");
        segregate(mammalsSRC, hedgehogs, feline, predatory);
        output.appendText("\n");



        ArrayList<Predatory> predatorySRC = new ArrayList<>();
        predatorySRC.add(new Lynx());
        predatorySRC.add(new Manul());
        predatorySRC.add(new Lynx());
        predatorySRC.add(new Lynx());
        ArrayList<Chordates> chordates1 = new ArrayList<>();
        ArrayList<Manul> manuls1 = new ArrayList<>();
        ArrayList<Feline> feline1 = new ArrayList<>();
        output.appendText("Example 2:\nsegregate(Хищные, Хордовые, Манулы, Кошачьи)\n");
        segregate(predatorySRC, chordates1, manuls1, feline1);
        output.appendText("\n");



        ArrayList<HedgehogCommon> hedgehogsSRC = new ArrayList<>();
        hedgehogsSRC.add(new HedgehogCommon());
        hedgehogsSRC.add(new HedgehogCommon());
        ArrayList<Insectivores> insectivores2 = new ArrayList<>();
        ArrayList<Predatory> predatory2 = new ArrayList<>();
        ArrayList<Predatory> predatory3 = new ArrayList<>();
        output.appendText("Example 3:\nsegregate(Ежовые, Насекомоядные, Хищные, Хищные)\n");
        segregate(hedgehogsSRC, insectivores2, predatory2, predatory3);
    }

}
