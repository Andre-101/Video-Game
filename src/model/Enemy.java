package model;

public class Enemy {
	//Attributes
	private final String idName;
	private EnemyType type;
	private final int defeatScore;
	private final int victoryScore;
	private final int[] position;
	private final boolean defeatedByPlayer;

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

	public EnemyType getType() {
		return this.type;
	}

	public void setType(EnemyType type) {
		this.type = type;
	}

	public int getDefeatScore() {
		return this.defeatScore;
	}

	public int getVictoryScore() {
		return this.victoryScore;
	}
}