package constants_statics_enumerators;


// Enums define a set of named constant values. 
// They are a way to represent a fixed set of values, like days of the week or status codes.
public class EnumExample {
    public enum Day {
        SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
    }
    public static void main(String[] args) {
        Day today = Day.WEDNESDAY;
        
        switch (today) {
            case MONDAY:
                System.out.println("It's Monday.");
                break;
            case WEDNESDAY:
                System.out.println("It's Wednesday.");
                break;
            default:
                System.out.println("It's not Monday or Wednesday.");
                break;
        }
    }
}

