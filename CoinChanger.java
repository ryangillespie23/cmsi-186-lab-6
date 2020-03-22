import java.util.Set;
// TODO of course, you may wish to import more things...

public abstract class CoinChanger {
    abstract public int minCoins(int amount, Set<Integer> denominations);

    private static void checkArguments(int amount, Set<Integer> denominations) {
        // TODO: Do all of your checks here, according to the lab instructions.
        // Anything wrong? Throw an IllegalArgumentException.
        //
        // Error situations and messages are:
        //   "Amount must be at least 1"
        //   "At least one denomination is required"
        //   "Denominations must all be positive"
        //   "Denominations must have a 1-unit coin"
    }

    public static class TopDown extends CoinChanger {
        public int minCoins(int amount, Set<Integer> denominations) {
            checkArguments(amount, denominations);

            // TODO: Do the top-down-with-memoization algorithm here. You should
            // do this recursively, so write a separate, private, recursive,
            // "helper" method. This method here will call that recursive
            // method with the memo object and the initial amount.
            return 0; // TODO change this line, of course
        }
    }

    public static class BottomUp extends CoinChanger {
        public int minCoins(int amount, Set<Integer> denominations) {
            checkArguments(amount, denominations);

            // TODO: Implement this method using the bottom-up approach with
            // a table.
            return 0; // TODO change this line, of course
        }
    }
}
