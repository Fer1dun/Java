import java.util.HashMap;
import java.util.Map;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Iterator;

public class alphabet {
    private Set<Character> english_alphabet = new LinkedHashSet<Character>();
    private Map<Character, Map<Character, Character>> map = new HashMap<Character, Map<Character, Character>>();
	//Constructs an alphabet instance.
    public alphabet() {
        // do not edit this method
        fill_english_alphabet();
        fill_map();
    }
	//Populates the set with uppercase English alphabet characters
    private void fill_english_alphabet() {
        for (char c : "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray()) {
            english_alphabet.add(c);
        }
    }
	//Maps by creating a shifted mapping for each character in the alphabet
	private void fill_map() {
		Iterator<Character> alpIt = english_alphabet.iterator();
		Character[] alpArr = new Character[english_alphabet.size()];
		int index = 0;
	
		while (alpIt.hasNext()) {
			alpArr[index++] = alpIt.next();
		}
	
		for (int i = 0; i < alpArr.length; i++) {
			Map<Character, Character> rowMap = new HashMap<>();
			for (int j = 0; j < alpArr.length; j++) {
				rowMap.put(alpArr[j], alpArr[(j + i) % alpArr.length]);
				
			}
			System.err.println(rowMap);		
			map.put(alpArr[i], rowMap);
		}
	}
	
	//prints map
    public void print_map() {
		System.out.println("*** Viegenere Cipher ***\n\n");
		System.out.println("    " + english_alphabet);
		System.out.print("    ------------------------------------------------------------------------------");
		for(Character x: map.keySet()) {
			System.out.print("\n" + x + " | ");
			System.out.print(map.get(x).values());
		}
		System.out.println("\n");
		
	}
	//return map
    public Map<Character,Map<Character,Character>> get_map() {
        return map;
    }
}
