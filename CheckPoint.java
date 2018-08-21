/*******************************************
* Author: Steven Nguyen & Brittanie Pham
* 
* Team Assignment: Pizza Thieves
*******************************************/

import java.util.Random;
import java.util.Scanner;

public class CheckPoint {
   
   // system objects
   Game myGame = new Game();
   Random rand = new Random();
   Scanner input = new Scanner(System.in);
   
   // fields
   private String choice;
   private String shopWeapon;
   private int numShopWeapon = 1;
   
   // methods
   public void shop() {
      
      // shop variable
      int healthPotionPrice = 10;
      int manaPotionPrice = 10;
      int shopWeaponPrice = 50;

      // weapon elements/validation
      String[] shopWeapons = {"GREAT SWORD", "GREAT BOW & ARROW", "GREAT SHIELD"};
      if(myGame.player.getCharacter() == myGame.characters[0]) {
         shopWeapon = shopWeapons[0];
      } else if(myGame.player.getCharacter() == myGame.characters[1]) {
         shopWeapon = shopWeapons[1];
      } else if(myGame.player.getCharacter() == myGame.characters[2]) {
         shopWeapon = shopWeapons[2];
      }
      
      // shop
      System.out.println("You have entered the shop.\n");
      
      boolean shop = true;
      while(shop) {
         System.out.println("===================================");
         System.out.println("What would you like to do?\n");
         System.out.println("\t> a. LEAVE SHOP");
         System.out.printf("   > b. %dg - buy HP potion%n", healthPotionPrice);
         System.out.printf("   > c. %dg - buy MP potion%n", manaPotionPrice);
         System.out.printf("   > d. %dg - buy %s%n%n", shopWeaponPrice, shopWeapon);
         System.out.printf("Gold: %dg%n", myGame.player.getGold());
         System.out.println("===================================");
         System.out.print("a/b/c/d: ");
         choice = input.nextLine();
         System.out.println();
         
         if(choice.equals("a")) {
            System.out.println("You leave the shop\n");
            shop = false;
         } else if(choice.equals("b")) {
            if(myGame.player.getGold() >= healthPotionPrice) {
               myGame.player.setGold(myGame.player.getGold() - healthPotionPrice);
               myGame.player.setHealthPotion(myGame.player.getHealthPotion() + 1);
               System.out.println("\t  --------------------------------");
               System.out.printf("   - You now have %d health potion(s) -%n", myGame.player.getHealthPotion());
               System.out.println("\t  --------------------------------\n");
            } else {
               System.out.println("\t  -----------------");
               System.out.println("\t- INSUFFICIENT GOLD -");
               System.out.println("\t  -----------------\n");
            }
         } else if(choice.equals("c")) {
            if(myGame.player.getGold() >= manaPotionPrice) {
               myGame.player.setGold(myGame.player.getGold() - manaPotionPrice);
               myGame.player.setManaPotion(myGame.player.getManaPotion() + 1);
               System.out.println("\t  ------------------------------");
               System.out.printf("   - You now have %d mana potion(s) -%n", myGame.player.getManaPotion());
               System.out.println("\t  ------------------------------\n");
            } else {
               System.out.println("\t  -----------------");
               System.out.println("\t- INSUFFICIENT GOLD -");
               System.out.println("\t  -----------------\n");
            }
         } else if(choice.equals("d")) {
            if(myGame.player.getGold() >= shopWeaponPrice && numShopWeapon > 0) {
               numShopWeapon--;
               myGame.player.setGold(myGame.player.getGold() - shopWeaponPrice);
               myGame.player.setAttack(myGame.player.getAttack() + myGame.player.getAttack()/2);
               myGame.player.setWeapon(shopWeapon);
               System.out.println("\t  ----------------------------------------------------------------");
               System.out.printf("   - You equipped the %s and now have %d attack power -%n", myGame.player.getWeapon(), myGame.player.getAttack());
               System.out.println("\t  ----------------------------------------------------------------\n");
            } else if(myGame.player.getGold() < shopWeaponPrice && numShopWeapon > 0) {
               System.out.println("\t  -----------------");
               System.out.println("\t- INSUFFICIENT GOLD -");
               System.out.println("\t  -----------------\n");
            } else {
               System.out.println("\t  --------");
               System.out.println("\t- SOLD OUT -");
               System.out.println("\t  --------\n");
            }
         } else {
            System.out.println("\t  ---------------");
            System.out.println("\t- INVALID COMMAND -");
            System.out.println("\t  ---------------\n");
         }
      }
   }

   public void dungeon() {
   
		// potion variables
      String[] potions = {"HP potion", "MP potion"};
		int hpAmount = 50;
      int mpAmount = 50;

      // dungeon
      System.out.println("You have entered the dungeon.\n");

		boolean dungeon = true;
		dungeon:
		while(dungeon) {

			myGame.enemy.setCharacter(myGame.enemies[rand.nextInt(myGame.enemies.length)]);
         
         if(myGame.enemy.getCharacter() == myGame.enemies[0]) {
            myGame.enemy.setHealth(myGame.enemy.getBaseHealth());
            myGame.enemy.setMaxHealth(myGame.enemy.getBaseMaxHealth());
            myGame.enemy.setAttack(myGame.enemy.getBaseAttack());
      
         } else if(myGame.enemy.getCharacter() == myGame.enemies[1]) {
            myGame.enemy.setHealth(myGame.enemy.getBaseHealth() - myGame.enemy.getBaseHealth() * 1/4);
            myGame.enemy.setMaxHealth(myGame.enemy.getBaseMaxHealth() - myGame.enemy.getBaseMaxHealth() * 1/4);
            myGame.enemy.setAttack(myGame.enemy.getBaseAttack() + myGame.enemy.getBaseAttack() * 2/4);
            
         } else if(myGame.enemy.getCharacter() == myGame.enemies[2]) {
            myGame.enemy.setHealth(myGame.enemy.getBaseHealth() + myGame.enemy.getBaseHealth() * 3/4);
            myGame.enemy.setMaxHealth(myGame.enemy.getBaseMaxHealth() + myGame.enemy.getBaseMaxHealth() * 3/4);
            myGame.enemy.setAttack(myGame.enemy.getBaseAttack() - myGame.enemy.getBaseAttack() * 1/4);
            
         }
         
         myGame.enemy.setHealth(rand.nextInt(myGame.enemy.getMaxHealth() - 1) + 1);
         myGame.enemy.setMaxHealth(myGame.enemy.getHealth());
         
         System.out.println("----------------------------------\n");
			System.out.printf("== A %s HAS APPEARED! ==%n%n", myGame.enemy.getCharacter());
         
         while(myGame.enemy.getHealth() > 0) {
            System.out.println("----------------------------------\n");
            System.out.println("******************************");
				System.out.printf(" %-15s %s%n", myGame.playerName, myGame.enemy.getCharacter());
				System.out.printf(" HP: %3d/%-7d HP: %3d/%-7d%n", myGame.player.getHealth(), myGame.player.getMaxHealth(),
                                                              myGame.enemy.getHealth(), myGame.enemy.getMaxHealth());
            System.out.printf(" MP: %3d/%-7d%n", myGame.player.getMana(), myGame.player.getMaxMana());
            System.out.println("******************************\n");
				System.out.println("=================================");
            System.out.println("What would you like to do?");
				System.out.println("\t> a. Attack");
            System.out.printf("\t> b. %s%n", myGame.player.getAbility());
				System.out.printf("\t> c. Drink %s%n", potions[0]);
            System.out.printf("\t> d. Drink %s%n", potions[1]);
				System.out.println("\t> e. Run & fight another enemy");
            System.out.println("=================================");
            System.out.print("a/b/c/d/e: ");
            choice = input.nextLine();
            System.out.println();
            
            if(choice.equals("a")) {
					int damageDealt = rand.nextInt(myGame.player.getAttack());
					int damageTaken = rand.nextInt(myGame.enemy.getAttack());

					myGame.enemy.setHealth(myGame.enemy.getHealth() - damageDealt);
					myGame.player.setHealth(myGame.player.getHealth() - damageTaken);
               
					System.out.printf("   - You %s %s for %d damage -%n", myGame.player.getMove(), myGame.enemy.getCharacter(), damageDealt);
					System.out.printf("   - You took %d damage in return -%n%n", damageTaken);
               System.out.print(">>>");
               input.nextLine();
               System.out.println();

					if(myGame.player.getHealth() < 1) {
						System.out.println("\t- You have taken too much damage.\n");
                  System.out.println("\t G A M E  O V E R");
                  System.out.println("----------------------------------");
						System.exit(0);
					}
				} else if(choice.equals("b")) {
               if(myGame.player.getMana() >= 50) {
                  if(myGame.player.getCharacter() == myGame.characters[0]) {
                  
                     myGame.player.setMana(myGame.player.getMana() - 50);
                     int damageDealt1 = rand.nextInt(myGame.player.getAttack());
                     System.out.printf("   - You %s %s for %d damage -%n", myGame.player.getMove(), myGame.enemy.getCharacter(), damageDealt1);
                     int damageDealt2 = rand.nextInt(myGame.player.getAttack());
                     System.out.printf("   - You %s %s for %d damage -%n", myGame.player.getMove(), myGame.enemy.getCharacter(), damageDealt2);
                     int damageDealt3 = rand.nextInt(myGame.player.getAttack());
                     System.out.printf("   - You %s %s for %d damage -%n", myGame.player.getMove(), myGame.enemy.getCharacter(), damageDealt3);
                     int damageDealt4 = rand.nextInt(myGame.player.getAttack());
                     System.out.printf("   - You %s %s for %d damage -%n", myGame.player.getMove(), myGame.enemy.getCharacter(), damageDealt4);
                     int damageDealt5 = rand.nextInt(myGame.player.getAttack());
                     System.out.printf("   - You %s %s for %d damage -%n%n", myGame.player.getMove(), myGame.enemy.getCharacter(), damageDealt5);
					      
                     int totalDamageDealt = damageDealt1 + damageDealt2 + damageDealt3 + damageDealt4 + damageDealt5;
                     int damageTaken = rand.nextInt(myGame.enemy.getAttack());
                     
                     myGame.enemy.setHealth(myGame.enemy.getHealth() - totalDamageDealt);
					      myGame.player.setHealth(myGame.player.getHealth() - damageTaken); 
                     
   					   System.out.printf("   - You took %d damage in return -%n%n", damageTaken);
                     System.out.print(">>>");
                     input.nextLine();
                     System.out.println();
                     
                  } else if(myGame.player.getCharacter() == myGame.characters[1]) {
                  
                     myGame.player.setMana(myGame.player.getMana() - 50);
                     int specialDamageDealt = myGame.player.getAttack() + 25;
                     int damageTaken = rand.nextInt(myGame.enemy.getAttack());
               
                     myGame.enemy.setHealth(myGame.enemy.getHealth() - specialDamageDealt);
   					   myGame.player.setHealth(myGame.player.getHealth() - damageTaken);
   
   					   System.out.printf("   - You %s %s's weakpoint for %d damage -%n", myGame.player.getMove(), myGame.enemy.getCharacter(), specialDamageDealt);
   					   System.out.printf("   - You took %d damage in return -%n%n", damageTaken);
                     System.out.print(">>>");
                     input.nextLine();
                     System.out.println();
                     
                  } else if(myGame.player.getCharacter() == myGame.characters[2]) {
                     myGame.player.setMana(myGame.player.getMana() - 50);
                     myGame.player.setHealth(myGame.player.getHealth() + hpAmount * 2);
                     
                     System.out.printf("   - You healed for %d HP -%n%n", hpAmount * 2);
                     System.out.print(">>>");
                     input.nextLine();
                     System.out.println();
                     
                  }

					   if(myGame.player.getHealth() < 1) {
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
               if (myGame.player.getHealthPotion() > 0) {
                  myGame.player.setHealth(myGame.player.getHealth() + hpAmount);
					   myGame.player.setHealthPotion(myGame.player.getHealthPotion() - 1);
					   System.out.printf("   - Health gained: %d HP -%n", hpAmount);
						System.out.printf("   - You have %d health potions left -%n%n", myGame.player.getHealthPotion());
                  System.out.print(">>>");
                  input.nextLine();
                  System.out.println();
				   } else {
                  System.out.println("\t  =====================================================================");
					   System.out.printf("   - No health potions left, defeat %s or %s to get one -", myGame.enemies[0], myGame.enemies[2]);
                  System.out.println("\t  =====================================================================\n");
               }
            } else if(choice.equals("d")) {
               if (myGame.player.getManaPotion() > 0) {
					   myGame.player.setMana(myGame.player.getMana() + mpAmount);
					   myGame.player.setManaPotion(myGame.player.getManaPotion() - 1);
					   System.out.printf("   - Mana gained: %d MP -%n", mpAmount);
						System.out.printf("   - You have %d mana potions left -%n%n", myGame.player.getManaPotion());
                  System.out.print(">>>");
                  input.nextLine();
                  System.out.println();
				   } else {
                  System.out.println("\t  ===================================================================");
					   System.out.printf("   - No mana potions left, defeat %s or %s to get one -", myGame.enemies[1], myGame.enemies[2]);
                  System.out.println("\t  ===================================================================\n");
               }
            } else if(choice.equals("e")) {
               System.out.println("\t- You run away from the " + myGame.enemy.getCharacter() + " -\n");
               System.out.print(">>>");
               input.nextLine();
               System.out.println();
					continue dungeon;
            } else {
               System.out.println("\t  ---------------");
               System.out.println("\t- INVALID COMMAND -");
               System.out.println("\t  ---------------\n");
            }
         }
         
         System.out.println("==================================");
			System.out.printf("= THE %s IS DEFEATED! =%n%n", myGame.enemy.getCharacter());
			System.out.printf("- %d HP left, %d MP left%n", myGame.player.getHealth(), myGame.player.getMana());
         
         int goldReward = rand.nextInt(100 - 50 + 1) + 50;
         myGame.player.setGold(myGame.player.getGold() + goldReward);
         System.out.printf("- Gold Earned: %dg, Gold Total: %dg%n%n", goldReward, myGame.player.getGold());
         
         if(myGame.enemy.getCharacter() == myGame.enemies[0]) {
				myGame.player.setHealthPotion(myGame.player.getHealthPotion() + 1);
				System.out.printf("- The %s dropped a health potion.%n", myGame.enemy.getCharacter());
				System.out.printf("- You now have %d health potion(s)%n", myGame.player.getHealthPotion());
            System.out.printf("- and %d mana potion(s).%n", myGame.player.getManaPotion());
			} else if(myGame.enemy.getCharacter() == myGame.enemies[1]) {
				myGame.player.setManaPotion(myGame.player.getManaPotion() + 1);
				System.out.printf("- The %s dropped a mana potion.%n", myGame.enemy.getCharacter());
				System.out.printf("- You now have %d health potion(s)%n", myGame.player.getHealthPotion());
            System.out.printf("- and %d mana potion(s).%n", myGame.player.getManaPotion());
			} else if(myGame.enemy.getCharacter() == myGame.enemies[2]) {
				myGame.player.setHealthPotion(myGame.player.getHealthPotion() + 1);
            myGame.player.setManaPotion(myGame.player.getManaPotion() + 1);
				System.out.printf("- The %s dropped a health & mana potion.%n", myGame.enemy.getCharacter());
				System.out.printf("- You now have %d health potion(s)%n", myGame.player.getHealthPotion());
            System.out.printf("- and %d mana potion(s).%n", myGame.player.getManaPotion());
			}
         
         boolean stayExit = true;
         while (stayExit) {
            System.out.println("==================================\n");
   			System.out.println("What would you like to do now?");
   			System.out.println("\t> a. Continue fighting");
   			System.out.println("\t> b. Exit dungeon");
            
   			choice = input.nextLine();
            if(choice.equals("a")) {
   				System.out.println("\t- You continue into the dungeon -\n");
               stayExit = false;
   			} else if(choice.equals("b")) {
   				System.out.println("\t- You exit the dungeon -\n");
               dungeon = false;
               stayExit = false;
   			} else {
               System.out.println("\t  ---------------");
               System.out.println("\t- INVALID COMMAND -");
               System.out.println("\t  ---------------\n");
            }
         }
      }
   }
}