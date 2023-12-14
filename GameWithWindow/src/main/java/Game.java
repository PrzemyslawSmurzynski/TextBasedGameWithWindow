import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Game {
    Random random = new Random();
    JFrame window;
    Container container;
    JPanel titleNamePanel, startButtonPanel, storylinePanel, optionButtonsPanel, infoPanel;
    JLabel titleNameLabel, healthLabel, healthAmountLabel, weaponLabel, weaponTypeLabel;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
    Font startButtonFont = new Font("Times New Roman", Font.PLAIN, 25);
    Font optionButtonFont = new Font("Times New Roman", Font.PLAIN, 25);
    Font storyLineTextAreaFont = new Font("Times New Roman", Font.PLAIN, 30);
    JButton startButton, option1Button, option2Button, option3Button, option4Button;
    JTextArea storylineTextArea;
    TitleScreenHandler tsHandler = new TitleScreenHandler();
    ChoiceHandler choiceHandler = new ChoiceHandler();
    int playerHealth, goblinDamageDealt, playerDamage, opponentHealth;
    String playerWeapon, playerName, position;
    String silverRing = "no";

    public static void main(String[] args) {
        new Game();
    }

    public Game() {
        window = new JFrame();
        window.setSize(800, 600);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        container = window.getContentPane();

        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100, 100, 600, 150);
        titleNamePanel.setBackground(Color.black);

        titleNameLabel = new JLabel("ADVENTURE");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titleFont);

        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300, 400, 200, 100);
        startButtonPanel.setBackground(Color.black);

        startButton = new JButton("START");
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.white);
        startButton.setFont(startButtonFont);
        startButton.addActionListener(tsHandler);
        startButton.setFocusPainted(false);

        titleNamePanel.add(titleNameLabel);
        container.add(startButtonPanel);
        container.add(titleNamePanel);
        startButtonPanel.add(startButton);
    }

    public void gameScreen() {

        titleNamePanel.setVisible(false);
        startButtonPanel.setVisible(false);

        storylinePanel = new JPanel();
        storylinePanel.setBounds(100, 100, 600, 250);
        storylinePanel.setBackground(Color.black);
        container.add(storylinePanel);

        storylineTextArea = new JTextArea("It will be changed later");
        storylineTextArea.setBounds(100, 100, 600, 250);
        storylineTextArea.setBackground(Color.black);
        storylineTextArea.setForeground(Color.white);
        storylineTextArea.setFont(storyLineTextAreaFont);
        storylineTextArea.setLineWrap(true);
        storylinePanel.add(storylineTextArea);

        optionButtonsPanel = new JPanel();
        optionButtonsPanel.setBounds(250, 350, 350, 150);
        optionButtonsPanel.setBackground(Color.black);
        optionButtonsPanel.setLayout(new GridLayout(4, 1));
        container.add(optionButtonsPanel);

        infoPanel = new JPanel();
        infoPanel.setBounds(100, 15, 600, 50);
        infoPanel.setBackground(Color.black);
        infoPanel.setLayout(new GridLayout(1, 4));
        container.add(infoPanel);

        healthLabel = new JLabel("HP: ");
        healthLabel.setForeground(Color.white);
        healthLabel.setFont(optionButtonFont);
        infoPanel.add(healthLabel);

        healthAmountLabel = new JLabel();
        healthAmountLabel.setForeground(Color.white);
        healthAmountLabel.setFont(optionButtonFont);
        infoPanel.add(healthAmountLabel);

        weaponLabel = new JLabel("Weapon: ");
        weaponLabel.setForeground(Color.white);
        weaponLabel.setFont(optionButtonFont);
        infoPanel.add(weaponLabel);

        weaponTypeLabel = new JLabel(playerWeapon);
        weaponTypeLabel.setForeground(Color.white);
        weaponTypeLabel.setFont(optionButtonFont);
        infoPanel.add(weaponTypeLabel);

        option1Button = new JButton("Choice 1");
        option1Button.setBackground(Color.black);
        option1Button.setForeground(Color.white);
        option1Button.setFont(optionButtonFont);
        option1Button.setFocusPainted(false);
        option1Button.addActionListener(choiceHandler);
        option1Button.setActionCommand("Choice 1");
        optionButtonsPanel.add(option1Button);

        option2Button = new JButton("Choice 2");
        option2Button.setBackground(Color.black);
        option2Button.setForeground(Color.white);
        option2Button.setFont(optionButtonFont);
        option2Button.setFocusPainted(false);
        option2Button.addActionListener(choiceHandler);
        option2Button.setActionCommand("Choice 2");
        optionButtonsPanel.add(option2Button);

        option3Button = new JButton("Choice 3");
        option3Button.setBackground(Color.black);
        option3Button.setForeground(Color.white);
        option3Button.setFont(optionButtonFont);
        option3Button.setFocusPainted(false);
        option3Button.addActionListener(choiceHandler);
        option3Button.setActionCommand("Choice 3");
        optionButtonsPanel.add(option3Button);

        option4Button = new JButton("Choice 4");
        option4Button.setBackground(Color.black);
        option4Button.setForeground(Color.white);
        option4Button.setFont(optionButtonFont);
        option4Button.setFocusPainted(false);
        option4Button.addActionListener(choiceHandler);
        option4Button.setActionCommand("Choice 4");
        optionButtonsPanel.add(option4Button);

        playerSetup();
    }

    public void playerSetup() {
        playerHealth = 100;
        healthAmountLabel.setText("" + playerHealth);
        playerWeapon = "Axe";
        weaponTypeLabel.setText(playerWeapon);
        playerName = "Ovensky";

        townGate();
    }

    public void townGate() {
        position = "townGate";
        storylineTextArea.setText("You are at the gate to the town. \nA guard is standing in front of you. " +
                "\n\nWhat do you want to do?");
        option1Button.setText("Talk to the guard.");
        option2Button.setText("Attack the guard.");
        option2Button.setVisible(true);
        option3Button.setText("Leave");
        option3Button.setVisible(true);
        option4Button.setVisible(false);
    }

    public void talkGuard() {
        position = "talkingWithGuard";
        if (silverRing.equals("no")) {
            storylineTextArea.setText("Guard: Hello there, so your name is " + playerName + "? \nSorry but I can not let you in." +
                    " But if you can \nshow me your good intentions by killing Goblin \nwe can talk about it again.");
        } else if (silverRing.equals("yes")) {
            storylineTextArea.setText("Guard: " + playerName + ", you must be a very brave man. You slained that enormous Goblin." +
                    "As a reward \nI can let you in to the town. \nHave fun and Thank you.");
            gameDone();
        }
        option1Button.setText(">");
        option2Button.setVisible(false);
        option3Button.setVisible(false);
    }

    public void attackGuard() {
        position = "attackingGuard";
        playerHealth = playerHealth - 10;
        healthAmountLabel.setText("" + playerHealth);
        storylineTextArea.setText("Guard: Don't be stupid, or next time \nI will end your life. \nYou got smacked by " +
                "the guard,\nyour current health is: " + playerHealth + "HP");
        option1Button.setText(">");
        option2Button.setVisible(false);
        option3Button.setVisible(false);
    }

    public void leaveGuard() {
        position = "leavingGuard";
        storylineTextArea.setText("You turned arround and went to the crossroad.");
        option1Button.setText(">");
        option2Button.setVisible(false);
        option3Button.setVisible(false);
    }

    public void crossroad() {
        position = "crossroad";
        storylineTextArea.setText("You are at the crossroad. In which direction you want to go?");
        option1Button.setText("North - along river");
        option1Button.setVisible(true);
        option2Button.setText("East - to the forrest");
        option2Button.setVisible(true);
        option3Button.setText("South - back to the town gate");
        option3Button.setVisible(true);
        option4Button.setText("West - to the bridge");
        option4Button.setVisible(true);
    }

    public void north() {
        position = "north";
        playerHealth = playerHealth + 10;
        healthAmountLabel.setText("" + playerHealth);
        storylineTextArea.setText("You are walking along river. \nYou were thirsty so you took a sip of water. " +
                "\nWater had healing abilities so you recovered 10HP. \nCurrent health is: " + playerHealth);
        option1Button.setText("Back to the crossroad");
        option2Button.setVisible(false);
        option3Button.setVisible(false);
        option4Button.setVisible(false);
    }

    public void east() {
        position = "east";
        storylineTextArea.setText("You walked into the forrest \nand found a chest that contains item.");
        option1Button.setText("Open chest");
        option2Button.setText("Back to the crossroad");
        option3Button.setVisible(false);
        option4Button.setVisible(false);
    }

    public void chestOpening() {
        position = "chestOpening";
        playerWeapon = "Long Sword";
        weaponTypeLabel.setText("Long Sword");
        storylineTextArea.setText("You found powerful Long Sword in chest \nand chosen it as your main weapon.");
        option1Button.setText("Back to the crossroad");
        option2Button.setVisible(false);
        option3Button.setVisible(false);
        option4Button.setVisible(false);
    }

    public void south() {
        position = "south";
        storylineTextArea.setText("You are going back to the town gate");
        option1Button.setText(">");
        option2Button.setVisible(false);
        option3Button.setVisible(false);
        option4Button.setVisible(false);
    }

    public void west() {
        position = "west";
        opponentHealth = random.nextInt(200);
        storylineTextArea.setText("You encountered a goblin at the bridge! \nYou must choose what to do now:");
        option1Button.setText("Fight");
        option2Button.setText("Run away");
        option3Button.setVisible(false);
        option4Button.setVisible(false);
    }

    public void fight() {
        position = "fighting";
        storylineTextArea.setText("Your health is: " + playerHealth + "\nGoblin health is: " + opponentHealth);
        option1Button.setText("Attack");
        option2Button.setText("Run away");
        option2Button.setVisible(true);
        option3Button.setVisible(false);
        option4Button.setVisible(false);
    }

    public void attackGoblin() {
        position = "attacking";
        goblinDamageDealt = random.nextInt(30);
        if (playerWeapon.equals("Axe")) {
            playerDamage = random.nextInt(25);
        } else if (playerWeapon.equals("Long Sword")) {
            playerDamage = random.nextInt(50);
        }
        opponentHealth = opponentHealth - playerDamage;
        playerHealth = playerHealth - goblinDamageDealt;
        healthAmountLabel.setText("" + playerHealth);
        if (opponentHealth > 0 & playerHealth > 0) {
            storylineTextArea.setText("You attacked goblin.\nYou dealt " + playerDamage + "dmg" + "\nGoblin dealt " +
                    goblinDamageDealt + "dmg" +  "\nYour current health is: " + playerHealth + "\nGoblin current health is: "
                    + opponentHealth);
            option1Button.setText(">");
            option2Button.setVisible(false);
        } else if (opponentHealth <= 0) {
            position = "victory";
            storylineTextArea.setText("You attacked goblin.\nYou dealt " + playerDamage + "dmg" + "\nGoblin was defeated. " +
                    "\nYou obtained Silver Ring");
            silverRing = "yes";
            option1Button.setText("Get back to crossroads");
            option2Button.setVisible(false);
        } else if (playerHealth <= 0) {
            position = "defeated";
            storylineTextArea.setText("Goblin was too strong for you.");
            option1Button.setText(">");
            option2Button.setVisible(false);
        }
    }

    public void gameDone() {
        position = "gameWon";
        storylineTextArea.setText("You finished the game. \n CONGRATULATION");
        option1Button.setText("Exit");
        option2Button.setVisible(false);
        option3Button.setVisible(false);
    }

    public void gameOver() {
        playerHealth = 100;
        healthAmountLabel.setText("" + playerHealth);
        position = "gameLost";
        storylineTextArea.setText("GAME OVER");
        option1Button.setText("Exit");
        option2Button.setText("Try again.");
        option2Button.setVisible(true);
        option3Button.setVisible(false);
    }

    public void shutDown() {
        System.exit(0);
    }

    public class TitleScreenHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            gameScreen();
        }
    }

    public class ChoiceHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {

            String yourChoice = event.getActionCommand();

            switch (position) {
                case "townGate":
                    switch (yourChoice) {
                        case "Choice 1": talkGuard(); break;
                        case "Choice 2": attackGuard(); break;
                        case "Choice 3": leaveGuard(); break;
                    } break;
                case "talkingWithGuard":
                    switch (yourChoice) {
                        case "Choice 1": townGate(); break;
                    } break;
                case "attackingGuard":
                    switch (yourChoice) {
                        case "Choice 1": townGate(); break;
                    } break;
                case "leavingGuard":
                    switch (yourChoice) {
                        case "Choice 1": crossroad(); break;
                    } break;
                case "crossroad":
                    switch (yourChoice) {
                        case "Choice 1": north(); break;
                        case "Choice 2": east(); break;
                        case "Choice 3": south(); break;
                        case "Choice 4": west(); break;
                    } break;
                case "north":
                    switch (yourChoice) {
                        case "Choice 1": crossroad(); break;
                    } break;
                case "east":
                    switch (yourChoice) {
                        case "Choice 1": chestOpening(); break;
                        case "Choice 2": crossroad(); break;
                    } break;
                case "chestOpening":
                    switch (yourChoice) {
                        case "Choice 1": crossroad(); break;
                    } break;
                case "south":
                    switch (yourChoice) {
                        case "Choice 1": townGate(); break;
                    } break;
                case "west":
                    switch (yourChoice) {
                        case "Choice 1": fight(); break;
                        case "Choice 2": crossroad(); break;
                    } break;
                case "fighting":
                    switch (yourChoice) {
                        case "Choice 1": attackGoblin();break;
                        case "Choice 2": crossroad(); break;
                    } break;
                case "attacking":
                    switch (yourChoice) {
                        case "Choice 1": fight(); break;
                    } break;
                case "victory":
                    switch (yourChoice) {
                        case "Choice 1": crossroad(); break;
                    } break;
                case "gameWon":
                    switch (yourChoice) {
                        case "Choice 1": shutDown(); break;
                    } break;
                case "defeated":
                    switch (yourChoice) {
                        case "Choice 1": gameOver(); break;
                    } break;
                case "gameLost":
                    switch (yourChoice) {
                        case "Choice 1": shutDown(); break;
                        case "Choice 2": townGate(); break;
                    } break;
            }
        }
    }
}
