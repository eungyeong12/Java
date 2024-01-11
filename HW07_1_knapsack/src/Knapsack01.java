import java.util.ArrayList;
import java.util.Scanner;

public class Knapsack01 {
    Item[] items;

    int capacity;
    int num_items;

    public Knapsack01(int capacity, Scanner fin) {
        this.capacity = capacity;
        num_items = fin.nextInt();
        items = new Item[num_items];
        for(int i=0; i<num_items; i++) {
            String name = fin.next();
            int value = fin.nextInt();
            int weight = fin.nextInt();
            items[i] = new Item(name, value, weight);
        }

    }
    public KSP_Solution BruteForce_KP01() {
        ArrayList<ArrayList<Item>> powerSet = new ArrayList<>();
        ArrayList<Item> subSet_items;
        String binStr;
        int num_items = this.items.length;
        /* obtain powerset */
        for(int i=0; i<Math.pow(2, num_items); i++) {
            binStr = Integer.toBinaryString(i);
            if(binStr.length() > num_items) {
                System.out.printf("getBinaryRepr::num_digits is not enough !!");
            }
            int binStr_length = binStr.length();
            for(int j=0; j<(num_items-binStr_length); j++) {
                binStr = "0" + binStr; // fill the spaces in front with '0'
            }
            subSet_items = new ArrayList<Item>();
            for(int j=0; j<num_items; j++) {
                if(binStr.charAt(j) == '1') {
                    subSet_items.add(this.items[j]);
                }
            }
            powerSet.add(subSet_items);
        }
        /* select the best subset from the powerset */
        int bestSubsetValue = 0, bestSubsetWeight = 0;
        int subsetValue, subsetWeight;
        ArrayList<Item> bestSubset = null;
        for(ArrayList<Item> subSet : powerSet) {
            subsetValue = 0;
            subsetWeight = 0;
            for(Item e : subSet) {
                subsetValue += e.value;
                subsetWeight += e.weight;
            }
            if((subsetWeight <= this.capacity) && (subsetValue > bestSubsetValue)) {
                bestSubsetValue = subsetValue;
                bestSubset = subSet;
                bestSubsetWeight = subsetWeight;
            }
        }

        KSP_Solution solution = new KSP_Solution();
        solution.selectedItems = bestSubset;
        solution.totalValue = bestSubsetValue;
        solution.totalWeight = bestSubsetWeight;

        return solution;
    }

    public void printSolution(KSP_Solution sol) {
        System.out.println("tatal value = " + sol.totalValue + ", total weight = " + sol.totalWeight + ", selected items = " + sol.selectedItems);
    }

    public KSP_Solution DynKSP_BottomUp() {
        KSP_Solution[][] m = new KSP_Solution[this.items.length + 1][this.capacity + 1];
        for (int k=0; k<= this.items.length; k++) {
            for (int w=0; w<= this.capacity; w++) {
                m[k][w] = new KSP_Solution();
                m[k][w].selectedItems = new ArrayList<Item>();
            }
            m[k][0].totalValue = 0;
            m[k][0].totalWeight = 0;
        }
        for (int w=0; w<= this.capacity; w++) {
            m[0][w].totalValue = 0;
            m[0][w].totalWeight = 0;
        }
        for (int k=1, i=0; k<=this.items.length; k++, i++) {
            for (int w=1; w<=this.capacity; w++) {
                if (this.items[i].weight > w) {
                    m[k][w] = m[k-1][w]; // items[i] is excluded
                } else {
                    if (m[k-1][w].totalValue > (m[k-1][w - this.items[i].weight].totalValue + this.items[i].value)) {
                        m[k][w] = m[k-1][w];
                    } else {
                        m[k][w].selectedItems.addAll(m[k-1][w].selectedItems);
                        m[k][w].selectedItems.add(this.items[i]);
                        m[k][w].totalValue = m[k-1][w - this.items[i].weight].totalValue + this.items[i].value;
                        m[k][w].totalWeight = m[k-1][w - this.items[i].weight].totalWeight + this.items[i].weight;
                    }
                }
            }
        }
        KSP_Solution solution = new KSP_Solution();
        solution = m[this.items.length][this.capacity];
        return solution;
    }

    public KSP_Solution _dynKSP_recursive(int index, int avail, KSP_Solution[][] solTbl) {
        KSP_Solution solution = new KSP_Solution();
        if ((index >= this.num_items) || (avail <= 0)) {
            solution = new KSP_Solution();
            solution.selectedItems = new ArrayList<Item>();
            solution.totalValue = 0;
            solution.totalWeight = 0;
            return solution;
        } else if (solTbl[index][avail] != null) {
            return solTbl[index][avail];
        } else if (this.items[index].weight > avail) {
            solution = _dynKSP_recursive(index+1, avail, solTbl);
        } else {
            Item candidateItem = this.items[index];
            KSP_Solution solution_with = new KSP_Solution();
            KSP_Solution solution_without = new KSP_Solution();
            solution_with = _dynKSP_recursive(index+1, avail - candidateItem.weight, solTbl);
            solution_with.totalValue += candidateItem.value;
            solution_with.totalWeight += candidateItem.weight;
            solution_with.selectedItems.add(candidateItem);
            solution_without = _dynKSP_recursive(index+1, avail, solTbl);
            if (solution_with.totalValue > solution_without.totalValue) {
                solution = solution_with;
            } else {
                solution = solution_without; }
        }
        solTbl[index][avail] = new KSP_Solution();
        solTbl[index][avail].selectedItems = solution.selectedItems;
        solTbl[index][avail].totalValue = solution.totalValue;
        solTbl[index][avail].totalWeight = solution.totalWeight;
        return solution;
    }
    public KSP_Solution DynKSP_TopDown() {
        KSP_Solution[][] solutionTable = new KSP_Solution[this.items.length][this.capacity + 1];
        for (int k=0; k< this.items.length; k++) {
            for (int w=1; w<= this.capacity; w++) {
                solutionTable[k][w] = null;
            }
            solutionTable[k][0] = new KSP_Solution();
            solutionTable[k][0].selectedItems = new ArrayList<Item>();
            solutionTable[k][0].totalValue = 0;
            solutionTable[k][0].totalWeight = 0;
        }
        int index_start = 0;
        KSP_Solution solution = _dynKSP_recursive(index_start, this.capacity, solutionTable);
        return solution;
    }


    public Object getNumItems() {
        return num_items;
    }
}
