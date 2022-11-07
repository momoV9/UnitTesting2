package be.thomasmore.splitwise;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SplitWise {
    private final Map<String, Double> bills;
    private boolean isDebtCalculated = false;

    public SplitWise(String[] names) {
        bills = new HashMap<>();
        Arrays.stream(names).toList().forEach(name -> bills.put(name, 0.0));
    }

    public double billFor(String name) {
        return bills.getOrDefault(name, 0.0);
    }

    public void pay(String name, double amount) {
        if (bills.containsKey(name)) {
            if(bills.get(name) == 0) {
                bills.put(name, bills.get(name) + amount);
                if(!isDebtCalculated){
                    bills.forEach((key, value) -> {
                        if(!key.equals(name)){
                            bills.put(key, -1 * (amount / bills.size()));
                        }
                    });
                    isDebtCalculated = true;
                }
            } else {
                bills.put(name, bills.get(name) - amount);
            }
        } else {
            bills.put(name, bills.get(name) + amount);
        }
    }
}
