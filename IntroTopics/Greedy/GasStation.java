public class GasStation {
    // https://leetcode.com/problems/gas-station/description/

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0, totalCost = 0;

        for (int g : gas) {
            totalGas += g;
        }

        for (int c : cost) {
            totalCost += c;
        }

        if (totalGas < totalCost) {
            return -1;
        }

        int ans = 0;
        int tank = 0;

        for (int i = 0; i < gas.length; i++) {
            if (tank + gas[i] >= cost[i]) {
                tank += gas[i] - cost[i];
            } else {
                tank = 0;
                ans = i + 1;
            }
        }

        return ans;
    }
}
