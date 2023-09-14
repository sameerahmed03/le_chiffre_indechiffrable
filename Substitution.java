public abstract class Substitution implements Cipher {

    /**
     * This encodes the plain text and converts it into a cipher
     * @param plainText
     * @return cipherText.toString
     */
    public String encrypt(String plainText) {
        StringBuilder cipherText = new StringBuilder();

        for (char c : plainText.toCharArray()) {
            cipherText.append(encrypt(c));
        }

        return cipherText.toString();
    }
    /**
     * This decrypts the cipher and converts it back into plain text
     * @param cipherText
     * @return plainText.toString
     */

    public String decrypt(String cipherText) {
        StringBuilder plainText = new StringBuilder();

        for (char c : cipherText.toCharArray()) {
            plainText.append(decrypt(c));
        }

        return plainText.toString();
    }

    /** 
    * This is a public class for encrypt that has been left empty as asked on the assigment specification 
    */
    public abstract char encrypt(char c);
    /**
     * This is a public class for decrypt that has been left empty due to the assignment specification
     */
    public abstract char decrypt(char c);
}

