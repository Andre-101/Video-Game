package model;

public class Enemy {
	//Attributes
	private String idName;
	private EnemyType type;
	private int defeatScore;
	private int victoryScore;
	private int[] position;
	private boolean defeatedByPlayer;

	//Builder
	public Enemy(String idName, int type, int defeatScore, int victoryScore, int[] position, boolean defeatedByPlayer) {
		this.idName =idName;
		this.type = EnemyType.values()[type];
		this.defeatScore = defeatScore;
		this.victoryScore = victoryScore;
		this.position = position;
		this.defeatedByPlayer = defeatedByPlayer;
	}

	@Override
	public String toString() {
		return "Enemy{" +
				"idName='" + idName + '\'' +
				", type=" + type +
				", defeatScore=" + defeatScore +
				", victoryScore=" + victoryScore +
				", position=" + "x: "+position[0]+", y: "+position[1] +
				'}';
	}

	//Setters and getters
	public String getIdName() {
		return idName;
	}

	public void setIdName(String idName) {
		this.idName = idName;
	}

	public EnemyType getType() {
		return this.type;
	}

	public void setType(EnemyType type) {
		this.type = type;
	}

	public int getDefeatScore() {
		return this.defeatScore;
	}

	public void setDefeatScore(int defeatScore) {
		this.defeatScore = defeatScore;
	}
	public int getVictoryScore() {
		return this.victoryScore;
	}

	public void setVictoryScore(int victoryScore) {
		this.victoryScore = victoryScore;
	}

	public int[] getPosition() {
		return this.position;
	}

	public void setPosition(int[] position) {
		this.position = position;
	}

	public boolean getDefeatedByPlayer() {
		return this.defeatedByPlayer;
	}

	public void setDefeatedByPlayer(boolean defeatedByPlayer) {
		this.defeatedByPlayer = defeatedByPlayer;
	}
}