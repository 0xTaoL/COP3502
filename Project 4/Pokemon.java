public class Pokemon {

	//these are the object attributes
	String species = null;
	int attack;
	int defense;
	int speed;
	
	//this constructor initializes all 4 fields of the Pokemon object
	public Pokemon(String species){
		this.species = species;
		this.attack = (species.length()*4) + 2;
		this.defense = (species.length()*2) + 7;
		this.speed = (species.length()*3) + 5;
	}
	
	//This method increases attack based on the given boost
	public void grow(int boost){
		attack += boost;
	}
	
	//This method increases defense based on given boost
	public void harden(int boost){
		defense += boost;
	}
	
	//This method increases speed based on the given boost
	public void haste(int boost){
		speed += boost;
	}
	
	//This method returns the Pokemon name
	public String getSpecies(){
		return species;
	}
	
	//This method sets the pokemon name
	public void setSpecies(String spc){
		this.species = spc;
	}
	
	//This method returns the pokemon attack
	public int getAttack(){
		return attack;
	}
	
	//This method sets the pokemon attack
	public void setAttack(int atk){
		this.attack = atk;
	}
	
	//This method returns the pokemon defense
	public int getDefense(){
		return defense;
	}
	
	//This method sets the pokemon defense
	public void setDefense(int def){
		this.defense = def;
	}
	
	//This method returns the pokemon speed
	public int getSpeed(){
		return speed;
	}
	
	//This method sets the pokemon speed
	public void setSpeed(int spd){
		this.speed = spd;
	}
}
