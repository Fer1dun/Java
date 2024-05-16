import java.util.Map;

public class encryptor {
	private Map<Character, Map<Character, Character>> map;
	private String key;
	private String keystream = "";
	private String plain_text;
	private String cipher_text = "";
	
	//Constructs an encryptor instance.
	public encryptor(Map<Character, Map<Character, Character>> _map, String _key, String text) {
		this.map = _map;
		this.key = _key;
		this.plain_text = text;
		encrypt();
	}
	//Calls generate_keystream and generate_chipper respectively
	public void encrypt() {
		generate_keystream();
		generate_cipher_text();
	}
	//Creates key string according to plain text length
	private void generate_keystream() {
		StringBuilder ks = new StringBuilder();
		while (ks.length() < plain_text.length()) {
			ks.append(key);
		}
		keystream = ks.substring(0, plain_text.length());
	}
	//Generates the letter corresponding to each character in the text, using the corresponding character in the keystream
	private void generate_cipher_text() {
		cipher_text = "";
		for (int i = 0; i < plain_text.length(); i++) {
			char plainCh = plain_text.charAt(i);
			char keyCh = keystream.charAt(i);
			cipher_text += map.get(plainCh).get(keyCh);
		}
	}

	//return keystream
	public String get_keystream() {
		return keystream;
	}
	//return text
	public String get_cipher_text() {
		return cipher_text;
	}
}
