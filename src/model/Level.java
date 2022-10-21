package model;

import java.util.Arrays;

public class Level {

	//Attributes
	private int idLevel;
	private int scoreNextLevel;
	private Difficulty difficulty;

	//Relationship
	private final Enemy[] enemies;
	private final Treasure[] treasures;

	//Builder
	public Level(int idLevel, int difficulty) {
		this.idLevel = idLevel;
		this.difficulty = Difficulty.values()[difficulty];
		this.treasures = new Treasure[50];
		this.enemies = new Enemy[25];
		scoreNextLevel = 0;
	}

	/**
	 * <b>Name:addEnemy</b><br>
	 * This method adds an enemy
	 * <b>Pre:</b> The parameters must be different from null <br>
	 * <b>Pos:</b> It registers a new enemy into the array <br>
	 * @param enemy Enemy. The variable that contains all the information of the enemy. enemy != null
	 * @return a boolean that informs if the enemy was saved
	 */
	public boolean addEnemy(Enemy enemy) {
		if (!verifyName(enemy.getIdName())) {
			for (int i = 0; i < enemies.length; i++){
				if (enemies[i] == null){
					enemies[i] = enemy;
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * <b>Name:verifyName</b><br>
	 * This method verifies if the enemy already exists
	 * <b>Pre:</b> The parameters must be different from null <br>
	 * <b>Pos:</b> The name has been veryfied <br>
	 * @param idName String. The variable saves the name of the enemy. idName != ""
	 * @return a boolean that informs if it faound a repeated name
	 */
	private boolean verifyName(String idName) {
		for (int i = 0; i < enemies.length; i++) {
			if (enemies[i] != null) {
				if (enemies[i].getIdName().equals(idName)) return true;
			}
		}
		return false;
	}

	/**
	 * <b>Name:addTreasure</b><br>
	 * This method adds a treasure.
	 * <b>Pre:</b> The parameters must be different from null <br>
	 * <b>Pos:</b> It registers a new treasure into the array <br>
	 * @param treasure Treasure. Variable tbat saves the treasure. treasure != null
	 */
	public void addTreasure(Treasure treasure) {
		for (int i = 0; i < treasures.length; i++){
			if (treasures[i] == null){
				treasures[i] = treasure;
			}
		}
	}

	/**
	 * <b>Name:defaultDifficulty</b><br>
	 * This method updates the difficulty level
	 * <b>Pre:</b> Th treasures and enemies exist. <br>
	 * <b>Pos:</b> The difficulty has been updated <br>
	 */
	public void defaultDifficulty() {
		int gainScoreTreasures = 0;
		int defeatScoreEnemies = 0;
		if (enemies == null || treasures == null){
			difficulty = Difficulty.UNSPECIFIED;
		} else {
			for (int i = 0; i < treasures.length; i++){
				gainScoreTreasures += treasures[i].getGainScore();
				if (i < enemies.length) defeatScoreEnemies += enemies[i].getDefeatScore();
			}
		}
		if (gainScoreTreasures == defeatScoreEnemies){
			if (gainScoreTreasures == 0) difficulty = Difficulty.UNSPECIFIED;
			else difficulty = Difficulty.MEDIUM;
		} else {
			if (gainScoreTreasures > defeatScoreEnemies) difficulty = Difficulty.LOW;
			else difficulty = Difficulty.HIGH;
		}
	}

	/**
	 * <b>Name:numberTreasures</b><br>
	 * This method looks for the amount of trasures with the same name
	 * <b>Pre:</b> The parameters must be different from null <br>
	 * <b>Pos:</b> The treasures have been counted <br>
	 * @param nameTreasure String. Variable that saves the name of the treasure. nameTreasure != ""
	 * @return an int with the number of treasures that have the same name
	 */
	public int numberTreasures(String nameTreasure) {
		int counter = 0;
		for (int i = 0; i < treasures.length; i++) {
			if (treasures[i].getName().equals(nameTreasure)) counter+=1;
		}
		return counter;
	}

	/**
	 * <b>Name:numberEnemies</b><br>
	 * This method looks for the amount of enemies of the same type
	 * <b>Pre:</b> The parameters must be different from null <br>
	 * <b>Pos:</b> The enemies have been counted <br>
	 * @param enemyType int. The variable saves the type of enemy. enemyType != null
	 * @return an int with the amount of enemies of the same type 
	 */
	public int numberEnemies(int enemyType) {
		int counter = 0;
		for (int i = 0; i < enemies.length; i++) {
			if (enemies[i].getType().equals(EnemyType.values()[enemyType])) counter += 1;
		}
		return counter;
	}

	/**
	 * <b>Name:generousEnemyPoints</b><br>
	 * This method looks for the enemy that gives the most points to the player when it's defeated.
	 * <b>Pre:</b> The enemies exist <br>
	 * <b>Pos:</b> The enemy with the most points have been found <br>
	 * @return an int that contains the score that contains the most points that is given to the player
	 */
	public int generousEnemyPoints() {
		int max = 0;
		if (enemies[0] == null) return -1;
		for (int i = 0; i < enemies.length; i++) {
			if (enemies[i] != null){
				if (max < enemies[i].getVictoryScore()) max = enemies[i].getVictoryScore();
			}
		}
		return max;
	}

	/**
	 * <b>Name:generousEnemyIndex</b><br>
	 * This method looks for the enemy that gives themost points to the olayer when its defeated.
	 * <b>Pre:</b> The enemies exist <br>
	 * <b>Pos:</b> The enemy with the most points have been found. <br>
	 * @return an int that containsthe index if the location of the most generous enemy that gives the player in the array
	 */
	public int generousEnemyIndex() {
		int enemyIndex = 0;
		int max = 0;
		for (int i = 0; i < enemies.length; i++) {
			if (enemies[i] != null){
				if (max < enemies[i].getVictoryScore()){
					max = enemies[i].getVictoryScore();
					enemyIndex = i;
				}
			}
		}
		return enemyIndex;
	}

	/**
	 * <b>Name:showEnemy</b><br>
	 * This method allows to show all the enemies 
	 * <b>Pre:</b> The enemies exist <br>
	 * <b>Pos:</b> The enemies have been displayed <br>
	 * @return a String with all the information of the enemies
	 */
	public String showEnemy() {
		String message = "";
		for (int i = 0; i < enemies.length; i++) {
			if (enemies[i] != null) message += enemies[i].getIdName()+",";
		}
		return message.substring(0, enemies.length-2);
	}

	/**
	 * <b>Name:showEnemy</b><br>
	 * This method allows to show the information of an enemy
	 * <b>Pre:</b> The parameters must be different from null <br>
	 * <b>Pos:</b> The enemies have been displayed <br>
	 * @param indexEnemy int. Variabl that saves the index where the enemy is saved in the array
	 * @return q String that contains the information of the enemy
	 */
	public String showEnemy(int indexEnemy) {
		return enemies[indexEnemy].toString();
	}

	/**
	 * <b>Name:showTreasure</b><br>
	 * This method allows to display all the treasures
	 * <b>Pre:</b> The treasures existed <br>
	 * <b>Pos:</b> The treasures have been shown <br>
	 * @return a String with all the information of the treasures
	 */
	public String showTreasure() {
		String message = "";
		for (int i = 0; i < treasures.length; i ++) {
			if (treasures[i] != null) message += treasures[i].getName()+",";
		}
		return message.substring(0, treasures.length-2);
	}

	/**
	 * <b>Name:consonantNumberNames</b><br>
	 * This method counts the consontants of the names of the enemies
	 * <b>Pre:</b> The enemies exist <br>
	 * <b>Pos:</b> The consontants of the names have been counted <br>
	 * @return an int with the number of the consontants of the names
	 */
	public int consonantNumberNames() {
		String name = "";
		for (int i = 0; i < enemies.length; i++) {
			name += enemies[i].getIdName();
		}
		return name.replaceAll("[AaEeIiOoUu[^A-Za-z]]","").length();
	}


	@Override
	public String toString() {
		return "Level{" +
				"idLevel=" + idLevel +
				", scoreNextLevel=" + scoreNextLevel +
				", difficulty=" + difficulty +
				", enemies=" + Arrays.toString(enemies) +
				", treasures=" + Arrays.toString(treasures) +
				'}';
	}

	//Setters and getters
	public int getIdLevel() {
		return idLevel;
	}

	public void setIdLevel(int idLevel) {
		this.idLevel = idLevel;
	}

	public int getScoreNextLevel() {
		return scoreNextLevel;
	}

	public void setScoreNextLevel(int scoreNextLevel) {
		this.scoreNextLevel = scoreNextLevel;
	}

	public String getDifficulty() {
		return difficulty.name();
	}

	public void setDifficulty(int difficulty) {
		this.difficulty = Difficulty.values()[difficulty];
	}
}