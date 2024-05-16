public class preprocessor {
    private String initial_string;
    private String preprocessed_string;
    //Constructor that initializes the processor 
    public preprocessor(String str) {
        this.initial_string = str;
        preprocess();
    }
    //Main method that orchestrates the preprocessing steps.
    public void preprocess() {
        capitalize();
        clean();
    }
    //To convert lowercase letters to uppercase, we took 32 from ascci.
    private void capitalize() {
        char[] x = initial_string.toCharArray(); 
        for (int i = 0; i < x.length; i++) {
            if (Character.isLowerCase(x[i])) {
                x[i] = (char) (x[i] - 32); 
            }
        }
        this.preprocessed_string = new String(x); 
    } 
    //removes non-uppercase characters from the string
    private void clean() {
        this.preprocessed_string = preprocessed_string.replaceAll("[^A-Z]", "");
    }
    //Returns the preprocessed 
    public String get_preprocessed_string() {
        return preprocessed_string;
    }
}
