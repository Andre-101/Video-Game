package model;

public class Player {

	private String nickname;
	private String name;
	private int score;
	private int lifes;
	private int level;

	/**
	 * 
	 * @param nickname
	 * @param name
	 * @param score
	 * @param lifes
	 * @param level
	 */
	public Player(String nickname, String name, int score, int lifes, int level) {
		this.nickname = nickname;
		this.name = name;
		this.score = score;
		this.lifes = lifes;
		this.level = level;
	}

	public String getNickname() {
		return nickname;
	}

	/**
	 * 
	 * @param nickname
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	/**
	 * 
	 * @param score
	 */
	public void setScore(int score) {
		this.score = score;
	}

	public int getLifes() {
		return lifes;
	}

	/**
	 * 
	 * @param lifes
	 */
	public void setLifes(int lifes) {
		this.lifes = lifes;
	}

	public int getLevel() {
		return level;
	}

	/**
	 * 
	 * @param level
	 */
	public void setLevel(int level) {
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
}