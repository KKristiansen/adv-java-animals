package us.mattgreen;

public class InputTypeVerifier extends Exception {
    public InputTypeVerifier(String type) {
        super("Unknown type (" + type  +").");
    }
}
