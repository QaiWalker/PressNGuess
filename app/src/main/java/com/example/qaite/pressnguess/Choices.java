package com.example.qaite.pressnguess;

public class Choices {
    private String instruments [][] = {
            {"Tuba", "Trombone", "Clarinet", "Piccolo"},
            {"Euphonium", "Flute", "Trumpet", "Drums"},
            {"Xylophone", "Saxophone", "Oboe", "Bassoon"},
            {"French Horn", "Tuba", "Clarinet", "Timpani"}
    };
    private String answers [] = {"Clarinet", "Flute", "Saxophone", "French Horn"};

    public String getChoice (int index, int num){
        String choice0 = instruments[index][num-1];
        return choice0;
    }

    public String getCorrectAnswer(int a){
        String answer =  answers[a];
        return answer;
    }
}
