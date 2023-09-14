public class Caesar extends MonoAlphaSubstitution {
    private int shift;

    /**
     * This method initialises that shift starts from 0
     */
    public Caesar() {
        shift = 0;
    }

    /**
     * This method allows the user to use the private value shift
     * @param shift
     */
    public Caesar(int shift) {
        this.shift = shift;
    }

    /**
     * This method encrypts the plain text and returns the text in cipher form
     * @param plaintext
     * @return ciphertext.toString
     */
    public String encrypt(String plaintext) {
        StringBuilder ciphertext = new StringBuilder();
        for (char c : plaintext.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                c = (char) (((c - base + shift) % 26) + base);
            }
            ciphertext.append(c);
        }
        return ciphertext.toString();
    }

    /**
     * This decodes the cipher text and returns it back into plain text
     * @param ciphertext
     * @return plaintext.toString
     */
    public String decrypt(String ciphertext) {
        StringBuilder plaintext = new StringBuilder();
        for (char c : ciphertext.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                c = (char) (((c - base - shift + 26) % 26) + base);
            }
            plaintext.append(c);
        }
        return plaintext.toString();
    }

    /**
     * This is the main method that counts the length of the argument, and alerts the user when there is an error
     * @param args
     */
    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Too few parameters!");
            System.out.println("Usage: java Caesar encrypt n \"cipher text\"");
            return;
        } else if (args.length > 3) {
            System.out.println("Too many parameters!");
            System.out.println("Usage: java Caesar encrypt n \"cipher text\"");
            return;
        }

        String mode = args[0];
        int shift = Integer.parseInt(args[1]);
        String text = args[2];

        Caesar cipher = new Caesar(shift);

        if (mode.equals("encrypt")) {
            String ciphertext = cipher.encrypt(text);
            System.out.println(ciphertext);
        } else if (mode.equals("decrypt")) {
            String plaintext = cipher.decrypt(text);
            System.out.println(plaintext);
        } else {
            System.out.println("The first parameter must be \"encrypt\" or \"decrypt\"");
            System.out.println("Usage: java Caesar encrypt key \"cipher text\"");
            return;
        }
    }
}



  






