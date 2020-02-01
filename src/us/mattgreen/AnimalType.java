package us.mattgreen;

public class AnimalType {
    private String type;
    private static Object data;
    private static int types = 0;

    public AnimalType(String type, Object data) {
        this.type = type;
        this.data = data;
        types++;
    }

    public String getType() {
        return type;
    }

    public Object getData() {
        return data;
    }

    public static int getTypes() {
        return types;
    }
}
