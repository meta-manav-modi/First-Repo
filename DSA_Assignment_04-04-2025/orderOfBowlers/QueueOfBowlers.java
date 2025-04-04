package orderOfBowlers;

import java.util.PriorityQueue;

/** class QueueOfBowlers, used to find the perfect order of bowlers to bowl */
public class QueueOfBowlers {
    private PriorityQueue<Bowler> maxHeap = new PriorityQueue<>((a, b) -> b.getRemaningBowls() - a.getRemaningBowls());

    /**
     * method orderOfBowlers , find the perfect order to defeat virat kohli
     * @param numBowlers
     * @param totalBalls
     * @param quotes
     * @return string with order
     */
    public String orderOfBowlers(int numBowlers, int totalBalls, int[] quotes) {

        if (quotes.length == 0) {
            throw new AssertionError("Size cannot be less than 1");
        }

        for (int index = 0; index < numBowlers; index++) {
            maxHeap.add(new Bowler(index + 1, quotes[index]));
        }

        // store and return the order of bowlers to bowl
        StringBuilder sb = new StringBuilder();
        while (totalBalls > 0) {
            Bowler curr = maxHeap.poll();
            if (curr.getRemaningBowls() > 0) {
                sb.append(curr.getId()).append(" ");
                curr.setRemaningBowls(curr.getRemaningBowls() - 1);
                totalBalls--;
                if (curr.getRemaningBowls() > 0) {
                    maxHeap.add(curr);
                }
            }
        }
        return sb.toString().trim();
    }
}