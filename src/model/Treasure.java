package model;

public class Treasure {

	//Attributes
	private String name;
	private final String imageUrl;
	private final int gainScore;
	private final int[] position;

	//Builder
	public Treasure(String name, String imageUrl, int gainScore, int[] position) {
		this.name = name;
		this.imageUrl = imageUrl;
		this.gainScore = gainScore;
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

	//Setters and getters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public int getGainScore() {
		return gainScore;
	}


}