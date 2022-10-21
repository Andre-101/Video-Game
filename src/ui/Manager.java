package ui;

import model.Controller;

import java.util.Scanner;

public class Manager {
    //Relationship
    private final Scanner sc;
    private final Controller controller;
    //Attributes
    final String errMessage1 = "option not available";
    final String errMessage2 = "only numeric values are allowed";

    //Builder
    public Manager() {
        this.sc = new Scanner(System.in);
        this.controller = new Controller();
    }

    //Executable
    public static void main(String[] args) {
        Manager m = new Manager();
        boolean loop;
        System.out.println("Welcome to video game");
        do {
            m.showMenu();
            loop = m.operation();
        }while (loop);
        System.out.println("Thanks for using the app");
    }

    /**
     * <b>Name:validateInput</b><br>
     * This method allows to validate the user inputs in numbers
     * <b>Pre:</b>The scanner variable is created, define the number that will be requested and the error message must exist<br>
     * <b>Post:</b>The requested number has been validated as numerical data<br>
     * @param min Integer. Variable containing the minimum range in which the integer to be validated can take value. min != null
     * @param max Integer. Variable containing the maximum range in which the integer to be validated can take value. max != null
     * @return an integer that has been validated
     */
    public int validateInput(int min, int max){
        boolean loop = false;
        int value = min -1;
        while (!loop){
            String aux = sc.nextLine();
            if (!aux.matches("[0-9]+")) System.err.println(errMessage2);
            else{
                value = Integer.parseInt(aux);
                loop = inRange(min,max,value);
                if (!loop) System.err.println(errMessage1);
            }
        }
        System.out.println();
        return value;
    }

    /**
     * <b>Name:inRange</b><br>
     * This method checks whether an integer is in range from two integers (min and max).
     * <b>Pre:</b>The numbers must be previously validated<br>
     * <b>Post:</b>Checking was operated correctly<br>
     * @param min Integer. Variable containing the minimum range in which the integer to be validated can take value. min != null
     * @param max Integer. Variable containing the maximum range in which the integer to be validated can take value. max != null
     * @param n int. Variable containing the integer you want to check if it is in range. n != null
     * @return a boolean indicating whether it meets the condition
     */
    public boolean inRange(int min, int max, int n){
        return n >= min && n <= max;
    }

    /**
     * <b>Name:operation</b><br>
     * This method allows you to operate according to the user's selection with regard to the menu the option to follow
     * <b>Pre:</b>The scanner variable is created, The menu was displayed and the error message must exist<br>
     * <b>Post:</b>The option has been successfully executed<br>
     * @return a boolean who will determine if the application closes
     */
    private boolean operation() {
        boolean loop = true;
        int op = validateInput(0, 12);
        switch (op){
            case 0: loop = false; break;
            case 1: createPlayer(); break;
            case 2: registerEnemy(); break;
            case 3: registerTreasure(); break;
            case 4: modifyScorePlayer(); break;
            case 5: increasePlayerLevel(); break;
            case 6: showTreasureAndEnemies(); break;
            case 7: showQuantityTreasures(); break;
            case 8: showQuantityTypeEnemies(); break;
            case 9: mostRepeatTreasure(); break;
            case 10: mostGenerousEnemy(); break;
            case 11: consonantNumberEnemies(); break;
            case 12: topFive(); break;
        }
        return loop;
    }

    /**
     * <b>Name:operation</b><br>
     * This method shows the information of the five players with th highest score
     * <b>Pre:</b> The players exist and have a score <br>
     * <b>Post:</b> The five highest scores have been shown <br>
     */
    private void topFive() {
        System.out.println(controller.topFiveScorePlayers());
    }

    /**
     * <b>Name:consonantNumberEnemies</b><br>
     * This method counts the consonants of the names of each of the enemies of the game
     * <b>Pre:</b> That the enemies exist and contain names <br>
     * <b>Pos:</b> All the consonants have been counted <br>
     */
    private void consonantNumberEnemies() {
        System.out.println("The number of consonants is: "+controller.numberOfConsonantsEnemyNames());
    }

    /**
     * <b>Name:mostRepeatedTreasure</b><br>
     * Este metodo busca el enemigo que le da mas puntos al jugador en todo el juego
     * <b>Pre:</b> Los tesoros existan y contengan nombres <br>
     * <b>Pos:</b> Se ha encontrado el enemigo que da mas puntos <br>
     */
    private void mostGenerousEnemy() {
        System.out.println(controller.mostGenerousEnemy());
    }

    /**
     * <b>Name:mostRepeatedTreasure</b><br>
     * this method looks for the most repeated treasure in the game
     * <b>Pre:</b> the treasures exist and contain names <br>
     * <b>Pos:</b> The most repeated treasure has been shown <br>
     */
    private void mostRepeatTreasure() {
        System.out.println(controller.mostRepeatedTreasure());
    }

    /**
     * <b>Name:showQuantityTypeEnemies</b><br>
     * This method looks for the quantity of a type of enemy
     * <b>Pre:</b> That the enemies exist <br>
     * <b>Pos:</b> The amount of enemies have been shown <br>
     */
    private void showQuantityTypeEnemies() {
        System.out.println(
                "Which enemy wants to know the number?\n"+
                        " (1) OGRE \n (2) ABSTRACT \n (3) BOSS \n (4) MAGICAL"
        );
        System.out.println("The number is: "+controller.numberEnemies(validateInput(1,4)-1));
    }

    /**
     * <b>Name:showQuantityTreasures</b><br>
     * this methid looks for the quatity of a type of treasure (It´s name)
     * <b>Pre:</b> The treasures exist <br>
     * <b>Pos:</b> the number of treasures have benn shown <br>
     */
    private void showQuantityTreasures() {
        System.out.println("Which enemy wants to know the number?");
        for (int i = 0; i < controller.getTreasureName().length; i++) {
            System.out.println(" ("+(i+1)+") "+controller.getTreasureName()[i]);
        }
        System.out.println("The number is: "+controller.numberTreasures(controller.getTreasureName()[validateInput(1, controller.getTreasureName().length)-1]));
    }

    /**
     * <b>Name:showTreasureAndEnemies</b><br>
     * This method shows the treasures and enemies of a level.
     * <b>Pre:</b> The treasures and enemies exist <br>
     * <b>Pos:</b> The information has been shown <br>
     */
    private void showTreasureAndEnemies() {
        System.out.println("Type the level that you know the treasure and the enemies");
        System.out.println(controller.showTreasureAndEnemies(validateInput(1,10)-1));
    }

    /**
     * <b>Name:increasePlayerLeve</b><br>
     * This method allows to increase the level of the player.
     * <b>Pre:</b> The player exists <br>
     * <b>Pos:</b> The score of the player has increased. <br>
     */
    private void increasePlayerLevel() {
        System.out.println("Type nickname player");
        String nickname = sc.nextLine();
        System.out.println("Type score to add");
        int score = sc.nextInt();
        System.out.println(controller.increasePlayerLevel(nickname,score));
    }

    /**
     * <b>Name:modifyScorePlayer</b><br>
     * This method allows to modify the score of the player.
     * <b>Pre:</b> That the player exists. <br>
     * <b>Pos:</b> Th score of the player has been modified. <br>
     */
    private void modifyScorePlayer() {
        String nickname;
        int score;
        boolean loop = true;
        do {
            System.out.println("Type nickname player");
            nickname = sc.nextLine();
            System.out.println("Type score to modify");
            score = sc.nextInt();
            if (!controller.modifyScorePlayer(nickname, score)) System.out.println("Do not found player");
            else loop = false;
        }while (loop);
    }

    /**
     * <b>Name:registerTreasureToLevel</b><br>
     * This method registers a treasure
     * <b>Pos:</b> The method has been registered. <br>
     */
    private void registerTreasure() {
        System.out.println("Type level to add treasure");
        int level = validateInput(1,10);
        System.out.println("Type treasure name");
        String name = sc.nextLine();
        System.out.println("Type image url");
        String imageUrl = sc.nextLine();
        System.out.println("Type gain treasure score");
        int gainScore = sc.nextInt();
        System.out.println(("Type treasure quantity"));
        int quantity = validateInput(1, controller.getNumberTreasuresAvailable());
        controller.setNumberTreasuresAvailable(controller.getNumberTreasuresAvailable()-quantity);
        controller.registerTreasureToLevel(name, imageUrl, gainScore, quantity,level-1);
        controller.defaultDifficultyLevel(level-1);
    }

    /**
     * <b>Name:registerEnemy</b><br>
     * This method registers an enemy
     * <b>Pos:</b> The enemy has been registered<br>
     */
    private void registerEnemy() {
        System.out.println("Type level to add enemy");
        int level = validateInput(1,10);
        System.out.println("Type enemy name");
        String name = sc.nextLine();
        System.out.println("Enemy type:\n  (1)OGRE\n  (2)ABSTRACT\n  (3)BOSS\n  (4)MAGICAL");
        int enemyType = sc.nextInt();
        System.out.println("Type score if player is defeated, only positive number");
        int defeatScore = sc.nextInt();
        System.out.println(("Type score if player wins"));
        int victoryScore = sc.nextInt();
        controller.setNumberEnemiesAvailable(controller.getNumberEnemiesAvailable()-1);
        if (!controller.registerEnemyToLevel(name, enemyType-1, defeatScore, victoryScore, level-1)) System.out.println("No space available to save enemy in the game");
        controller.defaultDifficultyLevel(level-1);
    }

    /**
     * <b>Name:createPlayer</b><br>
     * This method create a player
     * <b>Pos:</b> It registers a new player into the array <br>
     */
    private void createPlayer() {
        String nickname;
        do {
            System.out.println("Type nickname, if it already exists it will be requested again");
            nickname = sc.nextLine();
        } while (controller.verifyNickname(nickname));
        System.out.println("Type enemy name");
        String name = sc.nextLine();
        if (!controller.registerPlayer(nickname,name)) System.out.println("No space available for save enemy in the game");
    }

    /**
     * <b>Name:show</b><br>
     * This method displays the selection menu that can be operated by the user
     * <b>Post:</b>The menu has been displayed<br>
     */
    private void showMenu() {
        System.out.println(
                "Menu: \n"+
                        "  (1) Create player \n"+
                        "  (2) Register enemy to level \n"+
                        "  (3) Register treasure to level \n"+
                        "  (4) Modify score player \n"+
                        "  (5) Increase player level \n"+
                        "  (6) Show treasures and enemies \n"+
                        "  (7) Show quantity treasures \n"+
                        "  (8) Show quantity type enemies \n"+
                        "  (9) Show the most repeat treasure \n"+
                        "  (10) Show the enemy that gives more points \n"+
                        "  (11) Show number of consonants of all enemies \n"+
                        "  (12) Show top 5 of scores players \n"+
                        "  (0)  Exit"
        );
    }
}