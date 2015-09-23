/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman;

/**
 * GameCounter.java - it is an instantiable class which counts the matches and 
 * games won and games lost.
 * @author Talita Silva Lima
 * @studentID x14127733
 * @date 15.04.2015
 */
public class GameCounter {
    //declare the instance variables
	private int gamesPlayed;
	private int gamesWon;
	private int gamesLost;
	
    //declaring constructor
    public GameCounter(){
		gamesPlayed = 0;
		gamesWon = 0;
		gamesLost = 0;
    }
	
    //declaring a process which count the number of matches 
	public void incrementPlayed(){
		gamesPlayed = gamesPlayed + 1;		
	}
	
    //declaring a process which count the number of won matches
	public void incrementWon(){
		gamesWon = gamesWon + 1;
	}
	
    //declaring a process which count the number of lost matches
	public void incrementLost(){
		gamesLost = gamesLost + 1;
	}
	
    //declaring getter methods 	
	public int getGamesPlayed(){
		return gamesPlayed;
	}

	public int getGamesWon(){
		return gamesWon;
	}

	public int getGamesLost(){
		return gamesLost;
	}
}