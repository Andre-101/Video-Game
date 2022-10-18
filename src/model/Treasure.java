package model;

public class Treasure {

	private String name;
	private String imageUrl;
	private int gainScore;
	private int[] position;

	/**
	 * 
	 * @param name
	 * @param imageUrl
	 * @param gainScore
	 * @param position
	 */
	public Treasure(String name, String imageUrl, int gainScore, int[] position) {
		this.name = name;
		this.imageUrl = imageUrl;
		this.gainScore = gainScore;
		this.position = position;
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

	public String getImageUrl() {
		return imageUrl;
	}

	/**
	 * 
	 * @param imageUrl
	 */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public int getGainScore() {
		return gainScore;
	}

	/**
	 * 
	 * @param gainScore
	 */
	public void setGainScore(int gainScore) {
		this.gainScore = gainScore;
	}

	public int[] getPosition() {
		return position;
	}

	/**
	 * 
	 * @param position
	 */
	public void setPosition(int[] position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return "Treasure{" +
				"name='" + name + '\'' +
				", imageUrl='" + imageUrl + '\'' +
				", gainScore=" + gainScore +
				", position=" + "x: "+position[0]+", y: "+position[1] +
				'}';
	}
}