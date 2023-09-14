public class Vigenere extends Substitution {
    private String key;
    private int position;

    /** 
    * This sets the positional value of key to 0 
    */
    public Vigenere() {
        this.key = "";
        this.position = 0;
    }

    /**
     * This method gives user access to private value key
     * @param key
     */
    public Vigenere(String key) {
        this.key = key.toUpperCase();
        this.position = 0;
    }

    /**
     * This takes the character (c) and either returns the encrypted character or c depending on input
     * @param c
     * @return encrypted
     * @return c
     */
    @Override
    public char encrypt(char c) {
        if (Character.isLetter(c)) {
            int shift = this.key.charAt(this.position % this.key.length()) - 'A';
            char base = Character.isUpperCase(c) ? 'A' : 'a';
            char encrypted = (char) ((c - base + shift) % 26 + base);
            this.position++;
            return encrypted;
        } else {
            this.position++;
            return c;
        }
    }

    /**
     * This method takes the encrypted character and returns either decrypted or "c" depending on input
     * @param c
     * @return decrpted
     * @return c
     */
    @Override
    public char decrypt(char c) {
        if (Character.isLetter(c)) {
            int shift = this.key.charAt(this.position % this.key.length()) - 'A';
            char base = Character.isUpperCase(c) ? 'A' : 'a';
            char decrypted = (char) ((c - base - shift + 26) % 26 + base);
            this.position++;
            return decrypted;
        } else {
            this.position++;
            return c;
        }
    }

    /**
     * This is the main menu method that accounts for the length of the argument
     * User is alerted if there is an error due to their input
     * @param args
     */
    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Too few parameters!\nUsage: java Vigenere encrypt key \"cipher text\"");
            return;
        }
        if (args.length > 3) {
            System.out.println("Too many parameters!\nUsage: java Vigenere encrypt key \"cipher text\"");
            return;
        }

        String mode = args[0].toLowerCase();
        String key = args[1].toUpperCase();
        String text = args[2];

        Vigenere vigenere = new Vigenere(key);

        if (mode.equals("encrypt")) {
            String encrypted = vigenere.encrypt(text);
            System.out.println(encrypted);
        } else if (mode.equals("decrypt")) {
            String decrypted = vigenere.decrypt(text);
            System.out.println(decrypted);
        } else {
            System.out.println("The first parameter must be \"encrypt\" or \"decrypt\"!");
            System.out.println("Usage: java Vigenere encrypt key \"cipher text\"");
        }
    }
}


