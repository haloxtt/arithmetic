/**
 * 背包算法
 * // 现有一个背包容量150kg
 // 有一个宝藏里面有很多物品，物品的重量和价值分别为：
 // 25kg--20
 // 30kg--40
 // 60kg--45
 // 35kg--50
 // 20kg--10
 // 50ke--45
 // 40ke--50
 */
public class BackPack {
    static int[] weight = {25, 30, 60, 35, 20, 50, 40};//重量的数组
    static int[] values = {20, 40, 45, 50, 10, 45, 50};//物品的价值
    static int capacity = 150;//背包容量

    public static void main(String[] args) {
        backPack();
    }
    private static void backPack() {
        int size = values.length;//物品数量
        double[] prices = new double[size];//物品的性价比
        int[] tags = new int[size];
        for (int i = 0; i < size; i++) {
            prices[i] = (double) values[i]/weight[i];
            tags[i] = i;
        }
        //性价比选择排序
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (prices[i] < prices[j]) {
                    double temp = prices[i];
                    prices[i] = prices[j];
                    prices[j] = temp;
                    int tag = tags[i];
                    tags[i] = tags[j];
                    tags[j] = tag;
                }
            }
        }
        // 根据已经从大到小排好序的性价比，和相对应的重量和价值，添加到背包中
        int pick = 0;//已经装包的重量
        for (int i = 0; i < size; i++) {
            while (weight[tags[i]] < capacity) {
                System.out.println("添加了重量为"+weight[tags[i]]+"的物品");
                capacity -= weight[tags[i]];
            }
        }
    }
}
