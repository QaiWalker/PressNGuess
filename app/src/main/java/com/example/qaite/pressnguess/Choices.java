package com.example.qaite.pressnguess;

public class Choices {

    private String questions [] = {
      "1. Can you guess what Instrument is this?",
      "2. What do you think it sounds like?",
      "3. Sounds familiar?",
      "4. Try guessing the sound!"
    };

    private String instruments [][] = {
            {"Tuba", "Trombone", "CLARINET", "Piccolo"},
            {"Euphonium", "FLUTE", "Trumpet", "Drums"},
            {"Xylophone", "SAXOPHONE", "Oboe", "Bassoon"},
            {"FRENCH HORN", "Tuba", "Bongo", "Timpani"}
    };
    private String answers [] = {"CLARINET", "FLUTE", "SAXOPHONE", "FRENCH HORN"};

    private int music [] = {R.raw.clarinet, R.raw.flute, R.raw.frenchhorn, R.raw.saxophone};

    public int getMusic(int a){
        int music1 = music[a];
        return music1;
    }

    public String getQuestion(int a){
        String question = questions[a];
        return question;
    }

    public String getChoice (int index, int num){
        String choice0 = instruments[index][num-1];
        return choice0;
    }

    public String getCorrectAnswer(int a){
        String answer =  answers[a];
        return answer;
    }
    public int getLength() { return questions.length; }
}
