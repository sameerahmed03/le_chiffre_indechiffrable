public class MonoAlphaSubstitution extends Substitution {
    public char[] substitutionTable;

    /**
     * This is where the substitution table is for MonoAlphaSubstitution
     */
    public MonoAlphaSubstitution() {
        substitutionTable = new char[26];
        for (int i = 0; i < 26; i++) {
            substitutionTable[i] = (char)('a' + i);
        }
    }
    /**
     * This maps the characters from the substitution table and sets the length of rotation
     * @param mapping
     */
    public MonoAlphaSubstitution(String mapping) {
        substitutionTable = new char[26];
        for (int i = 0; i < 26; i++) {
            substitutionTable[i] = (char)('a' + i);
        }
        for (int i = 0; i < mapping.length(); i += 2) {
            char c = mapping.charAt(i + 1);
            if (Character.isUpperCase(c)) {
                c = Character.toLowerCase(c);
            }
            int index = Character.toLowerCase(mapping.charAt(i)) - 'a';
            substitutionTable[index] = c;
        }
    }
    /**
     * This is the method for encryption and alters the code so it counts for both lowercase and uppercase characters 
     * @return c
     */ 
    public char encrypt(char c) {
        if (!Character.isLetter(c)) {
            return c;
        }
        char lc = Character.toLowerCase(c);
        int index = lc - 'a';
        return Character.isUpperCase(c) ? Character.toUpperCase(substitutionTable[index]) : substitutionTable[index];
    }

    /**
     * This is the method for decryption
     * This decodes the text
     * @return c
     */
    public char decrypt(char c) {
        if (!Character.isLetter(c)) {
            return c;
        }
        char lc = Character.toLowerCase(c);
        int index = -1;
        for (int i = 0; i < 26; i++) {
            if (substitutionTable[i] == lc) {
                index = i;
                break;
            }
        }
        return Character.isUpperCase(c) ? Character.toUpperCase((char)('a' + index)) : (char)('a' + index);
    }

    /**
     * This is the main method that accounts for the length of the arguments, and alerts the user for errors
     * @param args
     */
    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Too few parameters!");
            System.out.println("Usage: java MonoAlphaSubstitution encrypt key \"cipher text\"");
            return;
        }
        else if (args.length !=3) {
            System.out.println("Too many parameters!");
            System.out.println("Usage: java MonoAlphaSubstitution encrypt key \"cipher text\"");
            return;
        }

        String mode = args[0];
        String mapping = args[1];
        String text = args[2];
        MonoAlphaSubstitution cipher = new MonoAlphaSubstitution(mapping);
        if (mode.equals("encrypt")) {
            System.out.println(cipher.encrypt(text));
        } else if (mode.equals("decrypt")) {
            System.out.println(cipher.decrypt(text));
        } else {
            System.out.println("The first parameter must be \"encrypt\" or \"decrypt\"!");
            System.out.println("Usage: java MonoAlphaSubstitution encrypt key \"cipher text\"");
            return;
        }
    }
} 
    

    


  
  
