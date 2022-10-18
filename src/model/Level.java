package model;

import java.util.Arrays;

public class Level {

	private int idLevel;
	private int scoreNextLevel;
	private Difficulty difficulty;

	private final Enemy[] enemies;
	private final Treasure[] treasures;

	/**
	 * @param idLevel
	 * @param difficulty
	 */
	public Level(int idLevel, int difficulty) {
		this.idLevel = idLevel;
		this.difficulty = Difficulty.values()[difficulty];
		this.treasures = new Treasure[50];
		this.enemies = new Enemy[25];
	}

	/**
	 * 
	 * @param enemy
	 */
	public void addEnemy(Enemy enemy) {
		for (int i = 0; i < enemies.length; i++){
			if (enemies[i] == null){
				enemies[i] = enemy;
			}
		}
	}

	/**
	 * 
	 * @param treasure
	 */
	public void addTreasure(Treasure treasure) {
		for (int i = 0; i < treasures.length; i++){
			if (treasures[i] == null){
				treasures[i] = treasure;
			}
		}
	}

	public boolean defaultDifficulty() {
		int gainScoreTreasures = 0;
		int defeatScoreEnemies = 0;
		if (enemies == null || treasures == null){
			difficulty = Difficulty.UNSPECIFIED;
			return false;
		} else {
			for (int i = 0; i < treasures.length; i++){
				gainScoreTreasures += treasures[i].getGainScore();
				if (i < enemies.length) defeatScoreEnemies += enemies[i].getDefeatScore();
			}
		}
		if (gainScoreTreasures == defeatScoreEnemies){
			if (gainScoreTreasures == 0 && defeatScoreEnemies == 0) difficulty = Difficulty.UNSPECIFIED;
			else difficulty = Difficulty.MEDIUM;
		} else {
			if (gainScoreTreasures > defeatScoreEnemies) difficulty = Difficulty.LOW;
			else difficulty = Difficulty.HIGH;
		}

		return true;
	}

	public int getIdLevel() {
		return idLevel;
	}

	/**
	 * 
	 * @param idLevel
	 */
	public void setIdLevel(int idLevel) {
		this.idLevel = idLevel;
	}

	public int getScoreNextLevel() {
		return scoreNextLevel;
	}

	/**
	 * 
	 * @param scoreNextLevel
	 */
	public void setScoreNextLevel(int scoreNextLevel) {
		this.scoreNextLevel = scoreNextLevel;
	}

	public String getDifficulty() {
		return difficulty.name();
	}

	/**
	 * 
	 * @param difficulty
	 */
	public void setDifficulty(int difficulty) {
		this.difficulty = Difficulty.values()[difficulty];
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
}