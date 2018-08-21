/*******************************************
* Author: Steven Nguyen & Brittanie Pham
* 
* Pizza Thieves - elements for player/boss
*******************************************/

public class Entities {

   // field
   private String character;  // player's/boss's character
   private String weapon;     // player's weapon
   private String move;       // players's weapon move (slash, shoot, bash)
   private String ability;    // player's ability
   
   private int health;        // stats of player/bosses
   private int maxHealth;
   private int attack;
   private int mana;
   private int maxMana;
   private int baseHealth;
   private int baseMaxHealth;
   private int baseAttack;
   private int baseMana;
   private int baseMaxMana;
   
   private int healthPotion;  // number of x items player owns
   private int manaPotion;
   private int gold;
   
   // methods
   public void setCharacter(String c) {
      character = c;
   }
   
   public String getCharacter() {
      return character;
   }
   
   public void setWeapon(String w) {
      weapon = w;
   }
   
   public String getWeapon() {
      return weapon;
   }
   
   public void setMove(String m) {
      move = m;
   }
   
   public String getMove() {
      return move;
   }
   
   public void setAbility(String a) {
      ability = a;
   }
   
   public String getAbility() {
      return ability;
   }
   
   public void setHealth(int h) {
      health = h;
   }
   
   public int getHealth() {
      return health;
   }
   
   public void setMaxHealth(int mh) {
      maxHealth = mh;
   }
   
   public int getMaxHealth() {
      return maxHealth;
   }
   
   public void setAttack(int a) {
      attack = a;
   }
   
   public int getAttack() {
      return attack;
   }
   
   public void setMana(int m) {
      mana = m;
   }
   
   public int getMana() {
      return mana;
   }
   
   public void setMaxMana(int mm) {
      maxMana = mm;
   }
   
   public int getMaxMana() {
      return maxMana;
   }
   
   public void setBaseHealth(int bh) {
      baseHealth = bh;
   }
   
   public int getBaseHealth() {
      return baseHealth;
   }
   
   public void setBaseMaxHealth(int bmh) {
      baseMaxHealth = bmh;
   }
   
   public int getBaseMaxHealth() {
      return baseMaxHealth;
   }
   
   public void setBaseAttack(int ba) {
      baseAttack = ba;
   }
   
   public int getBaseAttack() {
      return baseAttack;
   }
   
   public void setBaseMana(int mm) {
      baseMana = mm;
   }
   
   public int getBaseMana() {
      return baseMana;
   }
   
   public void setBaseMaxMana(int bmm) {
      baseMaxMana = bmm;
   }
   
   public int getBaseMaxMana() {
      return baseMaxMana;
   }
    
   public void setHealthPotion(int hp) {
      healthPotion = hp;
   }
   
   public int getHealthPotion() {
      return healthPotion;
   }
   
   public void setManaPotion(int mp) {
      manaPotion = mp;
   }
   
   public int getManaPotion() {
      return manaPotion;
   }
   
   public void setGold(int g) {
      gold = g;
   }
   
   public int getGold() {
      return gold;
   }
}