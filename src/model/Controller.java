package model;

import java.util.Random;

public class Controller {
	//Attributes
	private int numberEnemiesAvailable;
	private int numberTreasuresAvailable;
	private final int[] resolutionHD;
	private final String[] treasureName;
	private final int[] treasureNumber;

	//Relationship
	private final Random rd;
	private final Player[] players;
	private final Level[] levels;

	//Builder
	public Controller() {
		numberEnemiesAvailable = 25;
		numberTreasuresAvailable = 50;
		rd = new Random();
		resolutionHD = new int[] {1280, 720};
		treasureName = new String[50];
		treasureNumber = new int[50];
		players = new Player[20];
		levels = new Level[10];
		registerLevel();
	}

	/**
	 * <b>Name:registerPlayer</b><br>
	 * This method registers a player
	 * <b>Pre:</b> The parameters must be different from null <br>
	 * <b>Pos:</b> It registers a new player into the array <br>
	 * @param nickname String. Variable that saves the nickname of the user. nickname != ""
	 * @param name String. Variable that saves the name of the user. name != ""
	 * @return It shows if the player has been created or not
	 */
	public boolean registerPlayer(String nickname, String name) {
		for (int i = 0; i < players.length; i++){
			if (players[i] == null){
				players[i] = new Player(nickname, name,10, 5, levels[i]);
				return true;
			}
		}
		return false;
	}

	/**
	 * <b>Name:registerPlayer</b><br>
	 * This method verifies if nickname is repeated
	 * <b>Pre:</b> the parameters must be different from null <br>
	 * <b>Pos:</b> It registers a new player into the array <br>
	 * @param nickname String. Variable that saves the nickname of the user. nickname != ""
	 * @return It shows if a nickname has been repeated or not
	 */
	public boolean verifyNickname(String nickname) {
		for (int i = 0; i < players.length; i++){
			if (players[i] != null){
				if (players[i].getNickname().equals(nickname)) return true;
			}
		}
		return false;
	}
	/**
	 * <b>Name:registerLevel</b><br>
	 * This method registers a level
	 * <b>Pre:</b> The levels must be created automatically <br>
	 * <b>Pos:</b> It registers a new level into the array <br>
	 */
	public void registerLevel() {
		for (int i = 0; i < levels.length; i++) {
			levels[i] = new Level(i+1,(i+1)*1000,0);
		}
	}

	/**
	 * <b>Name:registerTreasureToLevel</b><br>
	 * This method registers a treasure to a level
	 * <b>Pre:</b> The parameters must be different from null <br>
	 * <b>Pos:</b> It registers a treasure into the array of levels <br>
	 * @param name String. Variable that saves the name of the treasure. name != ""
	 * @param imageUrl String. Variable that saves the url of the image of the treasure. imageUrl != ""
	 * @param gainScore int. Variable that saves the score that gives the treasure to the player. gainScore != null
	 * @param quantity int. Variable that saves the amount of the same treasure. quantity != null
	 * @param idLevel int. Variable that saves the index of the level. idLevel != null
	 */
	public void registerTreasureToLevel(String name, String imageUrl, int gainScore, int quantity, int idLevel) {
		for (int i = 0; i < quantity; i++){
			int[] position = new int[] {rd.nextInt(0,resolutionHD[0]), rd.nextInt(0, resolutionHD[1])};
			levels[idLevel].addTreasure(new Treasure(name, imageUrl, gainScore, position));
		}
		treasureTypeNumber(name, quantity);
	}

	/**
	 * <b>Name:treasureTypeNumber</b><br>
	 * This method updates the space that is available to add treasures
	 * <b>Pre:</b> The parameters must be different from null <br>
	 * <b>Pre:</b> It adds a treasure or it does not add anything <br>
	 * @param name String. Variable that saves the name of the treasure. name != ""
	 * @param quantity int. Variable that saves the amount of the same treasure. quantity != null
	 */
	private void treasureTypeNumber(String name, int quantity) {
		int index = 0;
		boolean loop = true;
		do {
			if (treasureName[index] != null){
				if (treasureName[index].equals(name)){
					treasureNumber[index] += quantity;
					loop = false;
				}
			} else {
				treasureName[index] = name;
				treasureNumber[index] = quantity;
				loop = false;
			}
			index++;
		}while (loop);
	}

	/**
	 * <b>Name:registerEnemyToLevel</b><br>
	 * This method registers a enemy to level
	 * <b>Pre:</b> The parameters must be different from null <br>
	 * <b>Pos:</b> The enemy had been registered <br>
	 * @param idName String. The variable saves the name of the enemy. idName != ""
	 * @param enemyType int. The variable saves the type of enemy. enemyType != null
	 * @param defeatScore int. The variable saves the points that reduce the score of the player. defeatScore != null
	 * @param victoryScore int. The variable that saves the score that increase the score of the player. victoryScore != null
	 * @return It shows if a nickname has been repeated or not
	 */
	public boolean registerEnemyToLevel(String idName, int enemyType, int defeatScore, int victoryScore, int idLevel) {
		int[] position = new int[] {rd.nextInt(0,resolutionHD[0]), rd.nextInt(0, resolutionHD[1])};
		return levels[idLevel].addEnemy(new Enemy(idName, enemyType, defeatScore, victoryScore, position, false));
	}

	/**
	 * <b>Name:defaultDifficultyLevel</b><br>
	 * This method allow to update the level difficulty.
	 * <b>Pre:</b> The parameters must be different from null <br>
	 * <b>Pos:</b> The difficulty of the level has been updated. <br>
	 * @param idLevel int. Variable that saves the index of the level. idLevel != null
	 */
	public void defaultDifficultyLevel(int idLevel) {
		levels[idLevel].defaultDifficulty();
	}

	/**
	 * <b>Name:modifyScorePlayer</b><br>
	 * This method allows to modify the score of the player
	 * <b>Pre:</b> The parameters must be different from null <br>
	 * <b>Pos:</b> The score of the player had been modified <br>
	 * @param nicknamePlayer String. Variable that saves the nickname of the user. nickname != ""
	 * @param newScorePlayer int. The variable that saves the new score that will be given to the player. newScorePlayer != null
	 * @return a boolean that indicates if it was possible to modify the score of the player.
	 */
	public boolean modifyScorePlayer(String nicknamePlayer, int newScorePlayer) {
		for (int i = 0; i < players.length; i++) {
			if (players[i] != null) {
				if (players[i].getNickname().equals(nicknamePlayer)){
					players[i].setScore(newScorePlayer);
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * <b>Name:increasePlayerLevel</b><br>
	 * This method allows to increase the level of the player
	 * <b>Pre:</b> The parameters must be different from null <br>
	 * <b>Pos:</b> The score of the player has increased <br>
	 * @param nickNamePlayer String. Variable that saves the nickname of the user. nickname != ""
	 * @param addScore int. The variable that saves the player's score that will increment
	 * @return a String with the score increment information
	 */
	public String increasePlayerLevel(String nickNamePlayer, int addScore) {
		for (int i = 0; i < players.length; i++) {
			if (players[i] != null) {
				if (players[i].getNickname().equals(nickNamePlayer)) {
					players[i].setScore(players[i].getScore() + addScore);
					defaultPlayerLevel(nickNamePlayer);
					return verifyLevel(i);
				}
			}
		}
		return "Player not found";
	}

	/**
	 * <b>Name:verifyLevel</b><br>
	 * This method check the player level and inform about next level
	 * <b>Pre:</b> The parameters must be different from null <br>
	 * <b>Pos:</b> The level has been verified. <br>
	 * @param indexPlayer int. Variable that contains the index where the player is located in the array
	 * @return a String that inform about the verification of the level
	 */
	private String verifyLevel(int indexPlayer) {
		for (int i = 0; i < levels.length; i++) {
			if (levels[i].getScoreNextLevel()>players[indexPlayer].getScore()){
				players[indexPlayer].setLevel(levels[i]);
				return  "you need "+(levels[i].getScoreNextLevel()-players[indexPlayer].getScore())+" points to level up";
			}
		}
		return "You are in the last level";
	}

	/**
	 * <b>Name:defaultPlayerLevel</b><br>
	 * This method determine the level of the player
	 * <b>Pre:</b> The parameters must be different from null <br>
	 * <b>Pos:</b> The level has been set up for the player <br>
	 * @param nickNamePlayer String. Variable that saves the nickname of the user. nickname != ""
	 */
	public void defaultPlayerLevel(String nickNamePlayer) {
		for (int i = 0; i < players.length; i++) {
			if (players[i].getNickname().equals(nickNamePlayer)){
				for (int j = 0; j < levels.length; j++){
					if(levels[j].getScoreNextLevel() != 0){
						if (players[i].getScore() < levels[j].getScoreNextLevel()){
							players[i].setLevel(levels[j]);
						}
					}
				}
			}
		}
	}

	/**
	 * <b>Name:showTreasureAndEnemies</b><br>
	 * This method show treasure and enemies name of a level
	 * <b>Pre:</b> The parameters must be different from null <br>
	 * <b>Pos:</b> The level has been setup for the player <br>
	 * @param idLevel int. The variable that saves the index of the level.
	 * @return a String that shows the treasures and enemies
	 */
	public String showTreasureAndEnemies(int idLevel) {
		return "Treasure:\n  "+levels[idLevel].showTreasure()+"Enemies:\n  "+levels[idLevel].showEnemy();
	}

	/**
	 * <b>Name:numberTreasures</b><br>
	 * This method counts the treasures that have the same name
	 * <b>Pre:</b> The parameters must be different from null <br>
	 * <b>Pos:</b> The treasures have been counted <br>
	 * @param nameTreasure String. Variable that saves the name of the treasure. name != ""
	 * @return an int that contains the number of treasures with the same name.
	 */
	public int numberTreasures(String nameTreasure) {
		int counter = 0;
		for (int i = 0; i < levels.length; i++){
			counter += levels[i].numberTreasures(nameTreasure);
		}
		return counter;
	}

	/**
	 * <b>Name:numberEnemies</b><br>
	 * This method counts the enemies that have the same type
	 * <b>Pre:</b> The parameters must be different from null <br>
	 * <b>Pos:</b> The enemies have been counted <br>
	 * @param enemyType int. The variable saves the type of enemy. enemyType != null
	 * @return am int that contains the number of enemies
	 */
	public int numberEnemies(int enemyType) {
		int counter = 0;
		for (int i = 0; i < levels.length; i++) {
			counter += levels[i].numberEnemies(enemyType);
		}
		return counter;
	}

	/**
	 * <b>Name:mostRepeatedTreasure</b><br>
	 * TThis method looks for the most repeated treasure.
	 * <b>Pre:</b> The parameters must be different from null <br>
	 * <b>Pos:</b> The most repeated treasure has been found <br>
	 * @return a String that contains the name of the most repeated treasure.
	 */
	public String mostRepeatedTreasure() {
		int max = 0;
		if (treasureName[max].equals("")) return "No treasures registered yet";
		else {
			for (int i = 0; i < treasureName.length-1; i++){
				if( treasureNumber[max] < treasureNumber[i]) max = i;
			}
		}
		return "The most repeated treasure is: "+treasureName[max];
	}

	/**
	 * <b>Name:mostGenerousEnemy</b><br>
	 * This method finds the enemy that gives the most points to the player once its defeated. 
	 * <b>Pre:</b> The enemies exist <br>
	 * <b>Pos:</b> The most generous enemy has been found <br>
	 * @return a String with the information of the enemy and the level where its located
	 */
	public String mostGenerousEnemy() {
		int level = 0;
		int indexEnemy = 0;
		int points = 0;
		for (int i = 0; i < levels.length; i++) {
			if (levels[i] != null){
				if (levels[i].generousEnemyPoints() != -1){
					if (points < levels[i].generousEnemyPoints()){
						level = i;
						indexEnemy = levels[i].generousEnemyIndex();
						points = levels[i].generousEnemyPoints();
					}
				}
			}
		}

		assert levels[level] != null;
		if (levels[level].generousEnemyPoints() == -1) return "No enemies registered yet";
		assert levels[level] != null;
		return "Enemy is in level "+(level+1)+"\n"+levels[level].showEnemy(indexEnemy);
	}

	/**
	 * <b>Name:numberOfConsonantsEnemyNames</b><br>
	 * This method counts the consonants of the names of the game's enemies. 
	 * <b>Pre:</b> The enemies exist<br>
	 * <b>Pos:</b> The consonants have been counted <br>
	 * @return an int with the number of consonants of the names
	 */
	public int numberOfConsonantsEnemyNames() {
		int consonantNumber = 0;
		for (int i = 0; i < levels.length; i++) {
			consonantNumber += levels[i].consonantNumberNames();
		}
		return consonantNumber;
	}

	/**
	 * <b>Name:topFiveScorePlayers</b><br>
	 * This method saves the information of the player's five highest scores 
	 * <b>Pre:</b> The players exist <br>
	 * <b>Pos:</b> The top five information have been saved <br>
	 * @return a String with the top five information
	 */
	public String topFiveScorePlayers() {
		Player[] topPlayers = sortPlayers(players);
		String message = "";
		for (int i = 0; i < topPlayers.length; i++){
			if (topPlayers[i] != null) message += "  ("+(i+1)+"): "+ topPlayers[i].getNickname() + " | Score: "+ topPlayers[0].getScore() +"\n";
		}
		return message;
	}

	/**
	 * <b>Name:sortPlayers</b><br>
	 * This method organizes the player in an array from biggest to the smallest score
	 * <b>Pre:</b> tHe players exist <br>
	 * <b>Pos:</b> The players have been organized <br>
	 * @param player Player[]. The array that contains the players. player[] != null
	 * @return an Array of Player that contains the organized list of players
	 */
	public Player[] sortPlayers(Player[] player){
		Player max;
		for(int i = 0; i < player.length-1; i++){
			if (player[i] != null){
				for (int j = i; j < player.length-1; j++){
					if (player[j] != null) {
						if(player[i].getScore() < player[j+1].getScore()){
							max = player[j+1];
							player[j+1] = player[i];
							player[i] = max;
						}
					}
				}
			}
		}
		return player;
	}

//Getters ans setters
	public int getNumberEnemiesAvailable() {
		return this.numberEnemiesAvailable;
	}

	public void setNumberEnemiesAvailable(int numberEnemiesAvailable) {
		this.numberEnemiesAvailable = numberEnemiesAvailable;
	}

	public int getNumberTreasuresAvailable() {
		return this.numberTreasuresAvailable;
	}

	public void setNumberTreasuresAvailable(int numberTreasuresAvailable) {
		this.numberTreasuresAvailable = numberTreasuresAvailable;
	}

	public String[] getTreasureName() {
		return treasureName;
	}
}