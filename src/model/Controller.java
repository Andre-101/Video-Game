public class Controller {

	private int numberEnemiesAvailable;
	private int numberTreasuresAvailable;

	public Controller() {
		// TODO - implement Controller.Controller
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param nickname
	 * @param name
	 */
	public boolean registerPlayer(string nickname, string name) {
		// TODO - implement Controller.registerPlayer
		throw new UnsupportedOperationException();
	}

	public void registerLevel() {
		// TODO - implement Controller.registerLevel
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param name
	 * @param imageUrl
	 * @param gainScore
	 * @param quantity
	 * @param idLevel
	 */
	public boolean registerTreasureToLevel(string name, string imageUrl, int gainScore, int quantity, int idLevel) {
		// TODO - implement Controller.registerTreasureToLevel
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param idName
	 * @param enemyType
	 * @param defeatScore
	 * @param victoryScore
	 */
	public boolean registerEnemyToLevel(string idName, int enemyType, int defeatScore, int victoryScore) {
		// TODO - implement Controller.registerEnemyToLevel
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param idLevel
	 */
	public void defaultDifficultyLevel(int idLevel) {
		// TODO - implement Controller.defaultDifficultyLevel
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param nicknamePlayer
	 * @param newScorePlayer
	 */
	public boolean modifyScorePlayer(string nicknamePlayer, string newScorePlayer) {
		// TODO - implement Controller.modifyScorePlayer
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param nickNamePlayer
	 */
	public boolean increasePlayerLevel(string nickNamePlayer) {
		// TODO - implement Controller.increasePlayerLevel
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param scorePlayer
	 * @param scoreNextLevel
	 */
	public int defaultPlayerLevel(int scorePlayer, int scoreNextLevel) {
		// TODO - implement Controller.defaultPlayerLevel
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param idLevel
	 */
	public string showTreasureAndEnemies(int idLevel) {
		// TODO - implement Controller.showTreasureAndEnemies
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param nameTreasure
	 */
	public int numberTreasures(int nameTreasure) {
		// TODO - implement Controller.numberTreasures
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param enemyType
	 */
	public int numberEnemies(int enemyType) {
		// TODO - implement Controller.numberEnemies
		throw new UnsupportedOperationException();
	}

	public string mostRepeatedTreasure() {
		// TODO - implement Controller.mostRepeatedTreasure
		throw new UnsupportedOperationException();
	}

	public string mostGenerousEnemy() {
		// TODO - implement Controller.mostGenerousEnemy
		throw new UnsupportedOperationException();
	}

	public int numberOfConsonantsEnemyNames() {
		// TODO - implement Controller.numberOfConsonantsEnemyNames
		throw new UnsupportedOperationException();
	}

	public string topFiveScorePlayers() {
		// TODO - implement Controller.topFiveScorePlayers
		throw new UnsupportedOperationException();
	}

	public int getNumberEnemiesAvailable() {
		return this.numberEnemiesAvailable;
	}

	/**
	 * 
	 * @param numberEnemiesAvailable
	 */
	public void setNumberEnemiesAvailable(int numberEnemiesAvailable) {
		this.numberEnemiesAvailable = numberEnemiesAvailable;
	}

	public int getNumberTreasuresAvailable() {
		return this.numberTreasuresAvailable;
	}

	/**
	 * 
	 * @param numberTreasuresAvailable
	 */
	public void setNumberTreasuresAvailable(int numberTreasuresAvailable) {
		this.numberTreasuresAvailable = numberTreasuresAvailable;
	}

}