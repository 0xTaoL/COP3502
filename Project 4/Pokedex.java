public class Pokedex {

	Pokemon[] pokedex;
	int numPoke = 0;
	int size;
	
	//Constructor that initializes attributes
	public Pokedex(int size) {
		pokedex = new Pokemon[size];
		this.size = size;
	}

	//creates an string array and gets species name from the pokedex, 
	//returns null if 0 pokemon in pokedex array
	public String[] listPokemon() {
		String[] species = new String[numPoke];
		if(numPoke == 0){
			return null;
		}
		for(int i = 0; i < numPoke; i++){
			species[i] = pokedex[i].getSpecies();
		}
		return species;
	}

	//checks if pokedex is at max, then checks for duplicates, if it passes both checks adds to pokedex array
	public boolean addPokemon(String species) {
		Pokemon poke = new Pokemon(species);
		boolean dup = false;
		if(numPoke == size){
			System.out.println("Max");
			return false;
		}
		for(int i = 0; i < numPoke; i++){
			if(pokedex[i].getSpecies().equalsIgnoreCase(poke.getSpecies()))
				dup = true;
		}
		if(dup==false){
			pokedex[numPoke] = poke;
			numPoke++;
			return true;
		}
		else{
			System.out.println("Duplicate");
			return false;
		}
	}

	//checks if pokemon is in pokedex, if passes check, creates and returns array with atk,def,spd
	public int[] checkStats(String species) {
		Pokemon poke = new Pokemon(species);
		boolean inDex = false;
		for(int i = 0; i < numPoke; i++){
			if(pokedex[i].getSpecies().equalsIgnoreCase(poke.getSpecies()))
				inDex = true;
		}
		if(inDex){
			int [] stats = new int[3];
			stats[0] = poke.getAttack();
			stats[1] = poke.getDefense();
			stats[2] = poke.getSpeed();
			return stats;
		}
		else{
			return null;
		}
	}

	//sorts pokedex in alphabetical order
	public void sortPokemon() {
        Pokemon temp;
        for (int i = 0; i < numPoke - 1; i++) {
            for (int j = i + 1; j < numPoke; j++) {
                if (pokedex[i].getSpecies().compareToIgnoreCase(pokedex[j].getSpecies()) > 0) {
                    temp = pokedex[i];
                    pokedex[i] = pokedex[j];
                    pokedex[j] = temp; 

                }
            }
        }
	}
}