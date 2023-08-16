package conversion;

public class ConversionExample {
    public static void main(String[] args) {
        // String to int
        String strNumber = "123";
        int intValue = Integer.parseInt(strNumber);
        System.out.println("String to int: " + intValue);

        // int to String
        int num = 456;
        String strValue = String.valueOf(num);
        System.out.println("int to String: " + strValue);

        // double to int
        double doubleValue = 78.56;
        int intFromDouble = (int) doubleValue; // Casting
        System.out.println("double to int (casting): " + intFromDouble);

        // int to double
        int intNumber = 789;
        double doubleFromInt = intNumber; // Implicit casting
        System.out.println("int to double (implicit casting): " + doubleFromInt);

        // double to String
        double doubleNum = 45.67;
        String strDouble = Double.toString(doubleNum);
        System.out.println("double to String: " + strDouble);

        // String to double
        String strDoubleValue = "89.12";
        double doubleFromString = Double.parseDouble(strDoubleValue);
        System.out.println("String to double: " + doubleFromString);
    }
}

