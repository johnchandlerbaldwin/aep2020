package edu.berkeley.aep;

public class Reverser{

    private String term;

    public Reverser(String args){
        this.term = args;
    }

    public String reverse(){
        String reversed_string = "";

        for(int i = this.term.length() - 1; i >= 0; i--){
            reversed_string = reversed_string + this.term.charAt(i);
        }

        return(reversed_string);
    }

}
