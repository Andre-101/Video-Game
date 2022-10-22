package model;

public class Player {

	//Attributes
	private final String nickname;
	private String name;
	private int score;
	private final int lives;
	private Level level;

	//Builder
	public Player(String nickname, String name, int score, int lives, Level level) {
		this.nickname = nickname;
		this.name = name;
		this.score = score;
		this.lives = lives;
		this.level = level;
	}

	@Override
	public String toString() {
		return "Player{" +
				"nickname='" + nickname + '\'' +
				", name='" + name + '\'' +
				", score=" + score +
				", lives=" + lives +
				", level=" + level +
				'}';
	}

	//Setters and getters
	public String getNickname() {
		return nickname;
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

	public void setLevel(Level level) {
		this.level = level;
	}
}