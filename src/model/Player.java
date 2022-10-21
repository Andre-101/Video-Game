package model;

public class Player {

	//Attributes
	private String nickname;
	private String name;
	private int score;
	private int lifes;
	private int numLevel;
	private Level level;

	//Builder
	public Player(String nickname, String name, int score, int lifes, int numLevel) {
		this.nickname = nickname;
		this.name = name;
		this.score = score;
		this.lifes = lifes;
		this.numLevel = numLevel;
	}

	public void addLevel(Level level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "Player{" +
				"nickname='" + nickname + '\'' +
				", name='" + name + '\'' +
				", score=" + score +
				", lifes=" + lifes +
				", level=" + level +
				'}';
	}

	//Setters and getters
	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getLifes() {
		return lifes;
	}

	public void setLifes(int lifes) {
		this.lifes = lifes;
	}

	public int getNumLevel() {
		return numLevel;
	}

	public void setNumLevel(int numLevel) {
		this.numLevel = numLevel;
	}

	public void setLevel(Level level) {
		this.level = level;
	}
}