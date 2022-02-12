import java.util.Arrays;

public class Lunar {

    private static Integer moveUp(Integer value) {
        return value > 3 ? value - 3 : value;
    }

    private static Integer moveDown(Integer value) {
        return value < 7 ? value + 3 : value;
    }

    private static Integer moveLeft(Integer value) {
        if ((value - 1) % 3 != 0) {
            return value - 1;
        } else {
            return value;
        }
    }

    private static Integer moveRight(Integer value) {
        if (value % 3 != 0) {
            return value + 1;
        } else {
            return value;
        }
    }


    private static String getCode(String moves) {
        int value = 5;

        StringBuilder result = new StringBuilder();

        for (String singleValueMoves : moves.split("\n")) {
            for (String move : Arrays.asList(singleValueMoves.split(""))) {
                switch (move.toLowerCase()) {
                    case "u" -> value = moveUp(value);
                    case "d" -> value = moveDown(value);
                    case "l" -> value = moveLeft(value);
                    case "r" -> value = moveRight(value);
                    default -> System.err.printf("Unrecognized value %s, skipping...", move);
                }
            }
            result.append(value);
        }
        return result.toString();
    }


    public static void main(String[] args) {

        String moves1 = "RUU\n" +
                "DDDL\n" +
                "URLLL";

        String moves2 = "RLRLLLULULULUUDUULULRDDLURURDDLDUUDDLRDDUUUDD\n" +
                "LDLRLDDDLUDRDRRUDUURLRULLUDDRLURLUULDLLRLLUDLRLRUDLULRLRRL\n" +
                "LLRRDURRDLDULRDUDLRDRDRURULDU\n" +
                "DULRRDRLRLUDLLURURLLRLRDLLDLLDRDUURL\n" +
                "DUULULUUDUDLLRLRURULLDLRRLURDLLDUDUDDRURRLUDULULD";

        System.out.println(Lunar.getCode(moves1)); // result = 384
        System.out.println(Lunar.getCode(moves2)); // result = 82224

    }
}
