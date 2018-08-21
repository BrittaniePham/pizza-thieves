/*******************************************
* Author: Steven Nguyen & Brittanie Pham
* 
* Team Assignment: Pizza Thieves
*******************************************/

import java.util.Random;
import java.util.Scanner;

public class Game {
   
   // system objects
   static Random rand = new Random();
   static Scanner input = new Scanner(System.in);
   static ASCII myASCII = new ASCII();
   static CheckPoint myCheckPoint = new CheckPoint();
   
   // entity objects
   static Entities player = new Entities();
   static Entities boss = new Entities();
   static Entities enemy = new Entities();
   
   // fields
   static String choice;     // variable for user input
   static String playerName; // variable for player's name
   
   static String[] characters = {"KNIGHT", "ARCHER", "WARRIOR"};                // player's character         (character1, character2, character3)
   static String[] bosses     = {"SAD STEVEN", "BAD BRITT", "KITTY KAT"};       // boss's character           (boss1, boss2, boss3)
   static String[] enemies    = {"DARK KNIGHT", "DARK ARCHER", "DARK WARRIOR"}; // dungeon enemy's character  (enemy1, enemy2, enemy3)
   static String[] weapons    = {"SWORD", "BOW & ARROW", "SHIELD"};             // player's starting weapon
   static String[] moves      = {"slashed", "shot", "bashed"};
   static String[] abilities  = {"Combo Slash", "Piercing Strike", "Great Heal"};
    
   public static void main(String[] args) {
   
      //adjustable player stats (character1's stats = base stats, character2's and character3's stats will increase/decrease depending on base stats)
      player.setBaseHealth(100);
      player.setBaseMaxHealth(100);
      player.setBaseMana(100);
      player.setBaseMaxMana(100);
      player.setBaseAttack(50);
      
      //adjustable player items
      player.setHealthPotion(2);
      player.setManaPotion(2);
      player.setGold(50);
      
      //adjustable boss stats (boss1's stats = base stats, boss2's and boss3's stats will increase/decrease depending on base stats)
      boss.setBaseHealth(400);
      boss.setBaseMaxHealth(400);
      boss.setBaseAttack(25);
      
      //adjustable enemy stats (enemy1's stats = base stats, enemy2's and enemy3's stats will increase/decrease depending on base stats)
      enemy.setBaseHealth(100);
      enemy.setBaseMaxHealth(100);
      enemy.setBaseAttack(25);
      
      createCharacter();
      levelOne();
      levelTwo();
      levelFinal();
      
      System.out.println("After this long journey to retrieve your pizza,");
      System.out.println("you realize this was not YOUR pizza");
      System.out.println("that you've been chasing this entire time.");
      System.out.println("This one has pineapples on it!");
      System.out.println("\"PINEAPPLES DON'T BELONG ON PIZZA. NOOOOO!!!\"");
      System.out.println();
      System.out.println("If this isn't your pizza, then");
      System.out.println("where could your original pizza be...?\n");
      
      System.out.println("THE END");
   }
   
   public static void createCharacter() {
      
      System.out.println("----------------------------------\n");
      System.out.print("Enter a name: ");
      playerName = input.nextLine();
      System.out.println();
      
      boolean chooseChar = true;
      while(chooseChar){
         System.out.println("==================================");
         System.out.println("Choose a class for your character:\n");
         System.out.printf("\t> a. %s  (%s)%n", characters[0], weapons[0]);
         System.out.printf("\t> b. %s  (%s)%n", characters[1], weapons[1]);
         System.out.printf("\t> c. %s (%s)%n", characters[2], weapons[2]);
         System.out.println("==================================");
         System.out.print("a/b/c: ");
         choice = input.nextLine();
         System.out.println();
         
         if(choice.equals("a")) {
         
            player.setCharacter(characters[0]);
            player.setWeapon(weapons[0]);
            player.setMove(moves[0]);
            player.setAbility(abilities[0]);
            player.setHealth(player.getBaseHealth());
            player.setMaxHealth(player.getBaseMaxHealth());
            player.setMana(player.getBaseMana());
            player.setMaxMana(player.getBaseMaxMana());
            player.setAttack(player.getBaseAttack());
            
            System.out.printf("Name:      %s%n", playerName);
            System.out.printf("Character: %s%n", player.getCharacter());
            System.out.printf("Weapon:    %s%n", player.getWeapon());
            System.out.printf("Ability:   %s%n", player.getAbility());
            System.out.printf("Health:    %d (Medium)%n", player.getHealth());
            System.out.printf("Mana:      %d (Medium)%n", player.getMana());
            System.out.printf("Attack:    %d (Medium)%n", player.getAttack());
            System.out.println();
            myASCII.knightSword();
            chooseChar = false;
            
         } else if(choice.equals("b")) {
            
            player.setCharacter(characters[1]);
            player.setWeapon(weapons[1]);
            player.setMove(moves[1]);
            player.setAbility(abilities[1]);
            player.setHealth(player.getBaseHealth() - player.getBaseHealth() * 1/4);
            player.setMaxHealth(player.getBaseMaxHealth() - player.getBaseMaxHealth() * 1/4);
            player.setMana(player.getBaseMana() + player.getBaseMana() * 1/4);
            player.setMaxMana(player.getBaseMaxMana() + player.getBaseMaxMana() * 1/4);
            player.setAttack(player.getBaseAttack() + player.getBaseAttack() * 2/4);
            
            System.out.printf("Name:      %s%n", playerName);
            System.out.printf("Character: %s%n", player.getCharacter());
            System.out.printf("Weapon:    %s%n", player.getWeapon());
            System.out.printf("Ability:   %s%n", player.getAbility());
            System.out.printf("Health:    %d (Low)%n", player.getHealth());
            System.out.printf("Mana:      %d (High)%n", player.getMana());
            System.out.printf("Attack:    %d (High)%n", player.getAttack());
            System.out.println();
            myASCII.archerBA();
            chooseChar = false;
            
         } else if(choice.equals("c")) {
            
            player.setCharacter(characters[2]);
            player.setWeapon(weapons[2]);
            player.setMove(moves[2]);
            player.setAbility(abilities[2]);
            player.setHealth(player.getBaseHealth() + player.getBaseHealth() * 3/4);
            player.setMaxHealth(player.getBaseMaxHealth() + player.getBaseMaxHealth() * 3/4);
            player.setMana(player.getBaseMana() - player.getBaseMana() * 1/4);
            player.setMaxMana(player.getBaseMaxMana() - player.getBaseMaxMana() * 1/4);
            player.setAttack(player.getBaseAttack() - player.getBaseAttack() * 1/4);
         
            System.out.printf("Name:      %s%n", playerName);
            System.out.printf("Character: %s%n", player.getCharacter());
            System.out.printf("Weapon:    %s%n", player.getWeapon());
            System.out.printf("Ability:   %s%n", player.getAbility());
            System.out.printf("Health:    %d (High)%n", player.getHealth());
            System.out.printf("Mana:      %d (Low)%n", player.getMana());
            System.out.printf("Attack:    %d (Low)%n", player.getAttack());
            System.out.println();
            myASCII.warriorShield();
            chooseChar = false;
            
         } else {
             System.out.println("\t  ---------------");
             System.out.println("\t- INVALID COMMAND -");
             System.out.println("\t  ---------------\n");
         }
      }
      
      System.out.println("G A M E   S T A R T !\n");
      System.out.println("-- Press ENTER when you see >>> to advance --\n");
      System.out.print(">>>");
      input.nextLine();
      System.out.println();
      System.out.println("---------------------------------------------\n");
   }
   
   public static void levelOne() {
      
      boss.setCharacter(bosses[0]);
      boss.setHealth(boss.getBaseHealth());
      boss.setMaxHealth(boss.getBaseMaxHealth());
      boss.setAttack(boss.getBaseAttack());
   
      System.out.println("LEVEL 1: PIZZA THIEVES!\n");
      
      System.out.println("It was a fine day in the Kingdom.");
      System.out.printf("A young %s named %s was enjoying some pizza.%n", player.getCharacter(), playerName);
      System.out.println("Suddenly the pizza thieves ran by and stole their pizza!");
      System.out.println();
      myASCII.kittyKatPizza();
      System.out.print(">>>");
      input.nextLine();
      System.out.println();
      
      boolean levelOne = true;
      while(levelOne){
         System.out.println("==============================================");
         System.out.println("What will you do?\n");
         System.out.println("\t> a. Run after them");
         System.out.println("\t> b. Just buy a new pizza");
         System.out.println("\t> c. Drive after them in your car, why run?");
         System.out.println("==============================================");
         System.out.print("a/b/c: ");
         choice = input.nextLine();
         System.out.println();
         
         if(choice.equals("a")) {
            System.out.println("You go after the pizza thieves!\n");
            levelOne = false;
         } else if(choice.equals("b")) {
            System.out.println("==============================================");
            System.out.println("What will you do?\n");
            System.out.println("\t> a. Run after them");
            System.out.println("\t> c. Drive after them in your car, why run?");
            System.out.println("==============================================");
            System.out.println("you're too poor to buy another pizza, choose again.");
            System.out.print("a/c: ");
            levelOne = false;
         } else if(choice.equals("c")) {
            System.out.println("The Pizza Thieves messed with your car.");
            System.out.println("The car blew up, you died, and they got away.\n");
            System.out.println("G A M E  O V E R");
            System.out.println("----------------");
            System.exit(0);
         } else {
            System.out.println("\t  ---------------");
            System.out.println("\t- INVALID COMMAND -");
            System.out.println("\t  ---------------\n");
         }
      }
      
      while(choice.equals("b")) {
         String choice1 = input.nextLine();
         System.out.println();
         if(choice1.equals("a")) {
            System.out.println("You go after the pizza thieves!\n");
            break;
         } else if(choice1.equals("c")) {
            System.out.println("The Pizza Thieves messed with your car.");
            System.out.println("The car blew up, you died, and they got away.\n");
            System.out.println("G A M E  O V E R");
            System.out.println("----------------");
            System.exit(0);
         } else {
            System.out.println("\t  ---------------");
            System.out.println("\t- INVALID COMMAND -");
            System.out.println("\t  ---------------\n");
            System.out.println("==============================================");
            System.out.println("What will you do?\n");
            System.out.println("\t> a. Run after them");
            System.out.println("\t> c. Drive after them in your car, why run?");
            System.out.println("==============================================");
            System.out.println("you're too poor to buy another pizza, choose again.");
            System.out.print("a/c: ");
         }
      }
      
      System.out.printf("As %s adventures onward, they find a good spot to rest.%n", playerName);
      System.out.println("The spot was near a mobile shop for equipment and supplies.");
      System.out.println("It was also near a dungeon, good for defeating enemies to drop");
      System.out.println("potions and gold to spend at the shop.\n");
      System.out.print(">>>");
      input.nextLine();
      System.out.println();
      
      boolean checkPoint = true;
      while(checkPoint) {
         System.out.println("============================================");
         System.out.println("Would you like to enter the nearby shop,");
         System.out.println("enter the nearby dungeon, or continue onward?\n");
         System.out.println("\t> a. Shop");
         System.out.println("\t> b. Dungeon");
         System.out.println("\t> c. Continue onward");
         System.out.println("============================================");
         System.out.print("a/b/c: ");
         choice = input.nextLine();
         System.out.println();
         
         if(choice.equals("a")) {
            myCheckPoint.shop();
         } else if(choice.equals("b")) {
            myCheckPoint.dungeon();
         } else if(choice.equals("c")) {
            checkPoint = false;
         } else {
            System.out.println("\t  ---------------");
            System.out.println("\t- INVALID COMMAND -");
            System.out.println("\t  ---------------\n");
         }
      }
      
      
      System.out.printf("The heroic %s, %s goes after the pizza thieves to retrieve the pizza.%n", player.getCharacter(), playerName);
      System.out.printf("On their way, our %s encounters a menacing but gloomy figure.%n", player.getCharacter());
      System.out.printf("The figure was %s!%n%n", boss.getCharacter());
      System.out.print(">>>");
      input.nextLine();
      System.out.println();
      
      System.out.println("=================================================================");
      System.out.printf(">> Defeat %s to continue, lose the fight and GAME OVER <<%n", boss.getCharacter());
      System.out.println("=================================================================\n");
      System.out.print(">>>");
      input.nextLine();
      System.out.println();
      
      bossBattle();
      
      System.out.println("=================================================================");
      System.out.printf(">>      YOU DEFEATED %s, PRESS ENTER TO CONTINUE.      <<%n", boss.getCharacter());
      System.out.println("=================================================================\n");
      System.out.print(">>>");
      input.nextLine();
      System.out.println();
      
      player.setHealth(player.getMaxHealth());
      player.setMana(player.getMaxMana());
      
      System.out.println("==================================");
		System.out.printf("- HP reset to %d, MP reset to %d%n", player.getHealth(), player.getMana());
      
      int goldReward = 100;
      player.setGold(player.getGold() + goldReward);
      System.out.printf("- Gold Earned: %dg, Gold Total: %dg%n%n", goldReward, player.getGold());
      
      player.setHealthPotion(player.getHealthPotion() + 5);
      player.setManaPotion(player.getManaPotion() + 5);
		System.out.printf("- %s dropped some health & mana potions %n", boss.getCharacter());
		System.out.printf("- You now have %d health potion(s)%n", player.getHealthPotion());
      System.out.printf("- and %d mana potion(s).%n", player.getManaPotion());
      System.out.println("==================================\n");
   }
   
   public static void levelTwo() {
      
      boss.setCharacter(bosses[1]);
      boss.setHealth(boss.getBaseHealth() + 50);
      boss.setMaxHealth(boss.getBaseMaxHealth() + 50);
      boss.setAttack(boss.getBaseAttack());
      
      System.out.println("LEVEL 2: PIZZA THIEVES!\n");
      
      System.out.printf("After the gruesome battle, you realize that %s was a diversion%n", bosses[0]);
      System.out.println("for the other pizza thief that's carrying the pizza!");
      System.out.println("You head further into the city in hopes of finding your delicious pizza.");
      System.out.println();
      System.out.print(">>>");
      input.nextLine();
      System.out.println();
      
      System.out.println("As you were on your quest, you notice a familiar scent of cheese");
      System.out.println("Could this be your pizza?");
      System.out.println("As you continue searching around for a clue,");
      System.out.println("you are suddenly confronted by a robber");
      System.out.println("\"Give me all your gold or face my wrath\"\n");
      System.out.print(">>>");
      input.nextLine();
      System.out.println();
      
      boolean levelTwo = true;
      while(levelTwo){
         System.out.println("==============================================");
         System.out.println("What will you do?\n");
         System.out.printf("\t> a. Threaten him with your %s%n", player.getWeapon());
         System.out.println("\t> b. Give him all your gold");
         System.out.println("\t> c. \"Do you take credit or debit?\"");
         System.out.println("==============================================");
         System.out.print("a/b/c: ");
         choice = input.nextLine();
         System.out.println();
         
         if(choice.equals("a")) {
            System.out.println("The robber isn't intimidated by your threats.\n");
            System.out.println("==============================================");
            System.out.println("What will you do?\n");
            System.out.println("\t> b. Give him all your gold");
            System.out.println("\t> c. \"Do you take credit or debit?\"");
            System.out.println("==============================================");
            System.out.print("b/c: ");
            levelTwo = false;
         } else if(choice.equals("b")) {
            player.setGold(0);
            System.out.println("\t- Now you are poor again :( -\n");
            System.out.println("Robber looks at the amount he stole from you");
            System.out.println("and is not satisfied by the small amount");
            System.out.println("He hits you in frustration and takes off\n");
            player.setHealth(player.getHealth() - 10);
            System.out.printf("   - %s loses 10 HP and now has %d HP left -%n%n", playerName, player.getHealth());
            levelTwo = false;
         } else if(choice.equals("c")) {
            System.out.println("The robber pulls out his portable card machine");
            System.out.println("\"Swipe here\"\n");
            System.out.println("you swipe your card, but there was no cash in your account!");
            System.out.println("The robber pities you, gives you 10 gold, & takes off\n");
            player.setGold(player.getGold() + 10);
            System.out.printf("   - %s gains 10 gold and now has %d gold -%n%n", playerName, player.getGold());
            levelTwo = false;
         } else {
            System.out.println("\t  ---------------");
            System.out.println("\t- INVALID COMMAND -");
            System.out.println("\t  ---------------\n");
         }
      }
      
      while(choice.equals("a")) {
         String choice1 = input.nextLine();
         System.out.println();
         if(choice1.equals("b")) {
            player.setGold(0);
            System.out.println("\t- Now you are poor again :( -\n");
            System.out.println("Robber looks at the amount he stole from you");
            System.out.println("and is not satisfied by the small amount");
            System.out.println("He hits you in frustration and takes off\n");
            player.setHealth(player.getHealth() - 10);
            System.out.printf("   - %s loses 10 HP and now has %d HP left -%n%n", playerName, player.getHealth());
            break;
         } else if(choice1.equals("c")) {
            System.out.println("The robber out his portable card machine");
            System.out.println("\"Swipe here\"\n");
            System.out.println("you swipe your card, but there was no cash in your account!");
            System.out.println("The robber pities you, gives you 10 gold, & takes off\n");
            player.setGold(player.getGold() + 10);
            System.out.printf("   - %s gains 10 gold and now has %d gold -%n%n", playerName, player.getGold());
            break;
         } else {
            System.out.println("\t  ---------------");
            System.out.println("\t- INVALID COMMAND -");
            System.out.println("\t  ---------------\n");
            System.out.println("The robber isn't intimidated by your threats.\n");
            System.out.println("==============================================");
            System.out.println("What will you do?\n");
            System.out.println("\t> b. Give him all your gold");
            System.out.println("\t> c. \"Do you take credit or debit?\"");
            System.out.println("==============================================");
            System.out.print("b/c: ");
         }
      }
      
      System.out.printf("As %s adventures onward, they find a good spot to rest.%n", playerName);
      System.out.println("The spot was near a mobile shop for equipment and supplies.");
      System.out.println("It was also near a dungeon, good for defeating enemies to drop");
      System.out.println("potions and gold to spend at the shop.\n");
      System.out.print(">>>");
      input.nextLine();
      System.out.println();
      
      boolean checkPoint = true;
      while(checkPoint) {
         System.out.println("============================================");
         System.out.println("Would you like to enter the nearby shop,");
         System.out.println("enter the nearby dungeon, or continue onward?\n");
         System.out.println("\t> a. Shop");
         System.out.println("\t> b. Dungeon");
         System.out.println("\t> c. Continue onward");
         System.out.println("============================================");
         System.out.print("a/b/c: ");
         choice = input.nextLine();
         System.out.println();
         
         if(choice.equals("a")) {
            myCheckPoint.shop();
         } else if(choice.equals("b")) {
            myCheckPoint.dungeon();
         } else if(choice.equals("c")) {
            checkPoint = false;
         } else {
            System.out.println("\t  ---------------");
            System.out.println("\t- INVALID COMMAND -");
            System.out.println("\t  ---------------\n");
         }
      }
      
      System.out.printf("The heroic %s, %s smells that familiar scent again %n", player.getCharacter(), playerName);
      System.out.println("You follow the scent cautiously, afraid to be fooled again.");
      System.out.printf("You spot the beautiful but angry %s escaping with your pizza!%n", boss.getCharacter());
      System.out.printf("You try to stop %s from escaping.%n", boss.getCharacter());
      System.out.println("\"You want a PIZZA me? (haha. get it?)\"\n");
      System.out.print(">>>");
      input.nextLine();
      System.out.println();
      
      System.out.println("=================================================================");
      System.out.printf(">> Defeat %s to continue, lose the fight and GAME OVER <<%n", boss.getCharacter());
      System.out.println("=================================================================\n");
      System.out.print(">>>");
      input.nextLine();
      System.out.println();
      
      bossBattle();
      
      System.out.println("=================================================================");
      System.out.printf(">>      YOU DEFEATED %s, PRESS ENTER TO CONTINUE.      <<%n", boss.getCharacter());
      System.out.println("=================================================================\n");
      System.out.print(">>>");
      input.nextLine();
      System.out.println();
      
      player.setHealth(player.getMaxHealth());
      player.setMana(player.getMaxMana());
      
      System.out.println("==================================");
		System.out.printf("- HP reset to %d, MP reset to %d%n", player.getHealth(), player.getMana());
      
      int goldReward = 100;
      player.setGold(player.getGold() + goldReward);
      System.out.printf("- Gold Earned: %dg, Gold Total: %dg%n%n", goldReward, player.getGold());
      
      player.setHealthPotion(player.getHealthPotion() + 5);
      player.setManaPotion(player.getManaPotion() + 5);
		System.out.printf("- %s dropped some health & mana potions.%n", boss.getCharacter());
		System.out.printf("- You now have %d health potion(s)%n", player.getHealthPotion());
      System.out.printf("- and %d mana potion(s).%n", player.getManaPotion());
      System.out.println("==================================\n");

   }
   
   public static void levelFinal() {
   
      boss.setCharacter(bosses[2]);
      boss.setHealth(boss.getBaseHealth() + 100);
      boss.setMaxHealth(boss.getBaseMaxHealth() + 100);
      boss.setAttack(boss.getBaseAttack());
      
      System.out.println("FINAL LEVEL: PIZZA THIEVES!\n");      
      
      System.out.println("You rejoice in happiness and finally retrieve your long lost pizza");
      System.out.println("As soon as you try to take a bite, a cute kitten snatches it from your hands!");
      System.out.println("but everything is not as it seems. The kitten turned out to be the");
      System.out.printf("leader of the pizza thieves, %s!%n%n", bosses[2]);
      System.out.print(">>>");
      input.nextLine();
      System.out.println();
      
      System.out.println("=================================================================");
      System.out.printf(">> Defeat %s to continue, lose the fight and GAME OVER <<%n", boss.getCharacter());
      System.out.println("=================================================================\n");
      System.out.print(">>>");
      input.nextLine();
      System.out.println();
      
      bossBattle();
      
      System.out.println("=================================================================");
      System.out.printf(">>      YOU DEFEATED %s, PRESS ENTER TO CONTINUE.      <<%n", boss.getCharacter());
      System.out.println("=================================================================\n");
      System.out.print(">>>");
      input.nextLine();
      System.out.println();
   }
   
   public static void bossBattle() {
      
      String[] potions = {"HP potion", "MP potion"};
		int hpAmount = 50;
      int mpAmount = 50;
      
      if(boss.getCharacter() == bosses[0]) {
         myASCII.sadSteven();
      } else if(boss.getCharacter() == bosses[1]) {
         myASCII.badBritt();
      } else if(boss.getCharacter() == bosses[2]) {
         myASCII.kittyKat();
      }
      
      while(boss.getHealth() > 0) {
         System.out.println("----------------------------------\n");
         System.out.println("******************************");
			System.out.printf(" %-15s %s%n", playerName, boss.getCharacter());
			System.out.printf(" HP: %3d/%-7d HP: %3d/%-7d%n", player.getHealth(), player.getMaxHealth(),
                                                           boss.getHealth(), boss.getMaxHealth());
         System.out.printf(" MP: %3d/%-7d%n", player.getMana(), player.getMaxMana());
         System.out.println("******************************\n");
			System.out.println("=================================");
         System.out.println("What would you like to do?");
			System.out.println("\t> a. Attack");
         System.out.printf("\t> b. %s%n", player.getAbility());
			System.out.printf("\t> c. Drink %s%n", potions[0]);
         System.out.printf("\t> d. Drink %s%n", potions[1]);
         System.out.println("=================================");
         System.out.print("a/b/c/d: ");
         choice = input.nextLine();
         System.out.println();
         
         if(choice.equals("a")) {
				int damageDealt = rand.nextInt(player.getAttack());
				int damageTaken = rand.nextInt(boss.getAttack());

				boss.setHealth(boss.getHealth() - damageDealt);
				player.setHealth(player.getHealth() - damageTaken);
            
				System.out.printf("   - You %s %s for %d damage -%n", player.getMove(), boss.getCharacter(), damageDealt);
				System.out.printf("   - You took %d damage in return -%n%n", damageTaken);
            System.out.print(">>>");
            input.nextLine();
            System.out.println();

				if(player.getHealth() < 1) {
					System.out.println("\t- You have taken too much damage.\n");
               System.out.println("\t G A M E  O V E R");
               System.out.println("----------------------------------");
					System.exit(0);
				}
			} else if(choice.equals("b")) {
            if(player.getMana() >= 50) {
               if(player.getCharacter() == characters[0]) {
               
                  player.setMana(player.getMana() - 50);
                  int damageDealt1 = rand.nextInt(player.getAttack());
                  System.out.printf("   - You %s %s for %d damage -%n", player.getMove(), boss.getCharacter(), damageDealt1);
                  int damageDealt2 = rand.nextInt(player.getAttack());
                  System.out.printf("   - You %s %s for %d damage -%n", player.getMove(), boss.getCharacter(), damageDealt2);
                  int damageDealt3 = rand.nextInt(player.getAttack());
                  System.out.printf("   - You %s %s for %d damage -%n", player.getMove(), boss.getCharacter(), damageDealt3);
                  int damageDealt4 = rand.nextInt(player.getAttack());
                  System.out.printf("   - You %s %s for %d damage -%n", player.getMove(), boss.getCharacter(), damageDealt4);
                  int damageDealt5 = rand.nextInt(player.getAttack());
                  System.out.printf("   - You %s %s for %d damage -%n%n", player.getMove(), boss.getCharacter(), damageDealt5);
				      
                  int totalDamageDealt = damageDealt1 + damageDealt2 + damageDealt3 + damageDealt4 + damageDealt5;
                  int damageTaken = rand.nextInt(boss.getAttack());
                  
                  boss.setHealth(boss.getHealth() - totalDamageDealt);
				      player.setHealth(player.getHealth() - damageTaken); 
                  
					   System.out.printf("   - You took %d damage in return -%n%n", damageTaken);
                  System.out.print(">>>");
                  input.nextLine();
                  System.out.println();
                  
               } else if(player.getCharacter() == characters[1]) {
               
                  player.setMana(player.getMana() - 50);
                  int specialDamageDealt = player.getAttack() + 25;
                  int damageTaken = rand.nextInt(boss.getAttack());
            
                  boss.setHealth(boss.getHealth() - specialDamageDealt);
					   player.setHealth(player.getHealth() - damageTaken);

					   System.out.printf("   - You %s %s's weakpoint for %d damage -%n", player.getMove(), boss.getCharacter(), specialDamageDealt);
					   System.out.printf("   - You took %d damage in return -%n%n", damageTaken);
                  System.out.print(">>>");
                  input.nextLine();
                  System.out.println();
                  
               } else if(player.getCharacter() == characters[2]) {
                  player.setMana(player.getMana() - 50);
                  player.setHealth(player.getHealth() + hpAmount * 2);
                  
                  System.out.printf("   - You healed for %d HP -%n%n", hpAmount * 2);
                  System.out.print(">>>");
                  input.nextLine();
                  System.out.println();
                  
               }

				   if(player.getHealth() < 1) {
					   System.out.println("\t- You have taken too much damage.\n");
                  System.out.println("\t G A M E  O V E R");
                  System.out.println("----------------------------------");
					   System.exit(0);
				   }
            } else {
               System.out.println("\t  ===========================");
               System.out.println("\t- YOU DO NOT HAVE ENOUGH MANA -");
               System.out.println("\t  ===========================\n");
            }
         } else if(choice.equals("c")) { 
            if (player.getHealthPotion() > 0) {
               player.setHealth(player.getHealth() + hpAmount);
				   player.setHealthPotion(player.getHealthPotion() - 1);
				   System.out.printf("   - Health gained: %d HP -%n", hpAmount);
					System.out.printf("   - You have %d health potions left -%n%n", player.getHealthPotion());
               System.out.print(">>>");
               input.nextLine();
               System.out.println();
			   } else {
               System.out.println("\t  =====================================================================");
				   System.out.printf("   - No health potions left, defeat %s or %s to get one -", enemies[0], enemies[2]);
               System.out.println("\t  =====================================================================\n");
            }
         } else if(choice.equals("d")) {
            if (player.getManaPotion() > 0) {
				   player.setMana(player.getMana() + mpAmount);
				   player.setManaPotion(player.getManaPotion() - 1);
				   System.out.printf("   - Mana gained: %d MP -%n", mpAmount);
					System.out.printf("   - You have %d mana potions left -%n%n", player.getManaPotion());
               System.out.print(">>>");
               input.nextLine();
               System.out.println();
			   } else {
               System.out.println("\t  ===================================================================");
				   System.out.printf("   - No mana potions left, defeat %s or %s to get one -", enemies[1], enemies[2]);
               System.out.println("\t  ===================================================================\n");
            }
         } else {
            System.out.println("\t  ---------------");
            System.out.println("\t- INVALID COMMAND -");
            System.out.println("\t  ---------------\n");
         }
      }
      
   }

}