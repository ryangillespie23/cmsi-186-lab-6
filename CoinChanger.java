import java.util.Set;
import java.util.HashMap;


public abstract class CoinChanger {
    abstract public int minCoins(int amount, Set<Integer> denominations);

    private static void checkArguments(int amount, Set<Integer> denominations) {
        if (amount < 1) {
            throw new IllegalArgumentException("Amount must be at least 1");
        }
        if (denominations.isEmpty()) {
            throw new IllegalArgumentException("At least one denomination is required");
        }
        for (var d : denominations) {
            if (d < 0) {
                throw new IllegalArgumentException("Denominations must all be positive");
            }
        }
        if (denominations.contains(1) == false) {
            throw new IllegalArgumentException("Denominations must have a 1-unit coin");
        }
    }

    private static HashMap<String, Integer> memo = new HashMap<>();
    
    public static class TopDown extends CoinChanger {
        public int minCoins(int amount, Set<Integer> denominations) {
            checkArguments(amount, denominations);

            var memoKey =  amount + "" + denominations;
            if (memo.containsKey(memoKey)) {
                return memo.get(memoKey);
            }

            var result = Integer.MAX_VALUE;
            for (var d : denominations) {
                if (amount < d) {
                    continue;
                } else if (amount == d) {
                    result = 1;
                } else {
                    var newResult = minCoins(amount - d, denominations);
                    if (newResult < result) {
                        result = 1 + newResult;
                    }
                }
            }
            memo.put(memoKey, result);
            return result;
        }
    }

    public static class BottomUp extends CoinChanger {
        public int minCoins(int amount, Set<Integer> denominations) {
            checkArguments(amount, denominations);

            var newTable = new int[amount + 1];
            newTable[0] = 0;
            for (var i = 0; i <= amount; i++) {
                var newestResult = Integer.MAX_VALUE;
                for (var d : denominations) {
                    if (i < d) {
                        continue;
                    } if (newTable[i - d] >= 0 && newTable[i - d] < newestResult) {
                        newestResult = newTable[i - d] + 1;
                    } if (newestResult == Integer.MAX_VALUE) {
                        newTable[i] = -1;
                    } else {
                        newTable[i] = newestResult;
                    }
                }
            }
            return newTable[amount]; 
        }
    }
}