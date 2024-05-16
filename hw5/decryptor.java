import java.util.Map;
import java.util.Iterator;

public class decryptor {
	private Map<Character, Map<Character, Character>> map;
	private String key;
	private String keystream = "";
	private String plain_text = "";
	private String cipher_text;
	//Constructs an decryptor instance.
	public decryptor(Map<Character, Map<Character, Character>> _map, String _key, String text) {
		this.map = _map;
		this.key = _key;
		this.cipher_text = text;
		this.plain_text = text;  
		decrypt();
	}
	//Calls generate_keystream and generate_text respectively
	public void decrypt() {
		generate_keystream();
		generate_plain_text();
	}
	//Creates plain string according to plain text length
	private void generate_keystream() {
		StringBuilder st = new StringBuilder();
		while (st.length() < plain_text.length()) {
			st.append(key);
		}
		keystream = st.substring(0, plain_text.length());
	}
	//It produces plaintext by searching the reverse map for each character in the ciphertext using the corresponding character in the keystream.
	private void generate_plain_text() {
		plain_text = ""; 
		for (int i = 0; i < cipher_text.length(); i++) {
			char cipher = cipher_text.charAt(i);
			char key = keystream.charAt(i);
	
			Map<Character, Character> row = map.get(key);
			
			if (row != null) {
				Iterator<Character> rowIt = row.keySet().iterator();
				while (rowIt.hasNext()) {
					Character entry = rowIt.next();
					if (row.get(entry).equals(cipher)) {
						plain_text += entry;
						break;
					}
				}
			} else {
				System.out.println("Error: Key character '" + key + "' not found in map.");
			}
		}
	}
	//return keystream
	public String get_keystream() {
		return keystream;
	}
	//return text
	public String get_plain_text() {
		return plain_text;
	}
}
