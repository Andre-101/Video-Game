package model;

public class Enemy {

	private String idName;
	private EnemyType type;
	private int defeatScore;
	private int victoryScore;
	private int[] position;
	private boolean defeatedByPlayer;

	/**
	 * 
	 * @param idName
	 * @param type
	 * @param defeatScore
	 * @param victoryScore
	 * @param position
	 * @param defeatedByPlayer
	 */
	public Enemy(String idName, int type, int defeatScore, int victoryScore, int[] position, boolean defeatedByPlayer) {
		this.idName =idName;
		this.type = EnemyType.values()[type];
		this.defeatScore = defeatScore;
		this.victoryScore = victoryScore;
		this.position = position;
		this.defeatedByPlayer = defeatedByPlayer;
	}

	public String getIdName() {
		return idName;
	}

	/**
	 * 
	 * @param idName
	 */
	public void setIdName(String idName) {
		this.idName = idName;
	}

	public EnemyType getType() {
		return this.type;
	}

	/**
	 * 
	 * @param type
	 */
	public void setType(EnemyType type) {
		this.type = type;
	}

	public int getDefeatScore() {
		return this.defeatScore;
	}

	/**
	 * 
	 * @param defeatScore
	 */
	public void setDefeatScore(int defeatScore) {
		this.defeatScore = defeatScore;
	}

	public int getVictoryScore() {
		return this.victoryScore;
	}

	/**
	 * 
	 * @param victoryScore
	 */
	public void setVictoryScore(int victoryScore) {
		this.victoryScore = victoryScore;
	}

	public int[] getPosition() {
		return this.position;
	}

	/**
	 * 
	 * @param position
	 */
	public void setPosition(int[] position) {
		this.position = position;
	}

	public boolean getDefeatedByPlayer() {
		return this.defeatedByPlayer;
	}

	/**
	 * 
	 * @param defeatedByPlayer
	 */
	public void setDefeatedByPlayer(boolean defeatedByPlayer) {
		this.defeatedByPlayer = defeatedByPlayer;
	}

}