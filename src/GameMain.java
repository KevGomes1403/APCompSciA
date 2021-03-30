import java.util.*;

public class GameMain {

    public static void main (String[] args) {

        // Write your code here
        ArrayList<PrizeCard> player1 = new ArrayList<PrizeCard>();
        GameWheel play1 = new GameWheel();

        int counter = 0;
        while (counter <= 4) {
            PrizeCard p = play1.spinWheel();
            if (counter == 0) {
                player1.add(p);
                counter++;
            } else {
                PrizeCard previous = player1.get(counter - 1);
                if (p.getID() != previous.getID()) {
                    player1.add(p);
                    counter++;
                }
            }
        }

        ArrayList<PrizeCard> player2 = new ArrayList<PrizeCard>();
        GameWheel play2 = new GameWheel();

        int counter2 = 0;
        while (counter2 <= 4) {
            PrizeCard p = play2.spinWheel();
            if (counter2 == 0) {
                player2.add(p);
                counter2++;
            } else {
                PrizeCard previous = player2.get(counter2 - 1);
                if (p.getID() != previous.getID()) {
                    player2.add(p);
                    counter2++;
                }
            }
        }

        int total = 0;
        for (PrizeCard p: player1) {
            total += p.getPrizeAmount();
        }

        int total2 = 0;
        for (PrizeCard p2: player2) {
            total2 += p2.getPrizeAmount();
        }

        System.out.println("Player 1 Total: $" + total);

        for (PrizeCard p: player1) {
            System.out.println(p);
        }

        System.out.println("\nPlayer 2 Total: $" + total2);

        for (PrizeCard p: player2) {
            System.out.println(p);
        }

        if (total > total2) {
            int diff = total - total2;
            System.out.println("\nPlayer 1 won by $" + diff + "!");
        } else if (total2 > total) {
            int diff = total2 - total;
            System.out.println("\nPlayer 2 won by $" + diff + "!");
        } else {
            System.out.println("\nIt's a tie! ");
        }
    }
}
