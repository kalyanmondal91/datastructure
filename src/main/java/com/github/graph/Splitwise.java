package com.github.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class GraphNode {
    String node;
    Double amount;

    public GraphNode(String node, Double amount) {
        this.node = node;
        this.amount = amount;
    }
}

public class Splitwise {

    static Map<String, List<GraphNode>> mapGraphAdjList = new HashMap<>();

    public static void insert(String srcNode, String destNode, Double amount) {
        List<GraphNode> list = mapGraphAdjList.getOrDefault(srcNode, new ArrayList<>());
        list.add(new GraphNode(destNode, amount));
        mapGraphAdjList.put(srcNode, list);
    }
    public static void simplifyDebt() {
        Map<String, Double> mapAmount = new HashMap<>();
        mapGraphAdjList.forEach((k,v) -> {
            for(GraphNode graphNode : v) {
                mapAmount.put(k, mapAmount.getOrDefault(k, 0.0) - graphNode.amount);
                mapAmount.put(graphNode.node, mapAmount.getOrDefault(graphNode.node, 0.0) + graphNode.amount);
            }
        });
        minCashFlowRec(mapAmount);
    }

    private static String getMax(Map<String, Double> mapAmount) {
        String maxIndex = mapAmount.entrySet().stream().findAny().get().getKey();
        for(Map.Entry<String, Double> entry : mapAmount.entrySet()) {
            if(entry.getValue() > mapAmount.get(maxIndex)) {
                maxIndex = entry.getKey();
            }
        }
        return maxIndex;
    }

    private static String getMin(Map<String, Double> mapAmount) {
        String minIndex = mapAmount.entrySet().stream().findAny().get().getKey();
        for(Map.Entry<String, Double> entry : mapAmount.entrySet()) {
            if(entry.getValue() < mapAmount.get(minIndex)) {
                minIndex = entry.getKey();
            }
        }
        return minIndex;
    }

    private static void minCashFlowRec(Map<String, Double> mapAmount) {
        String mxCredit = getMax(mapAmount);
        String mxDebit = getMin(mapAmount);
        if(mapAmount.get(mxCredit) == 0.0 && mapAmount.get(mxDebit) == 0.0)
            return;
        Double min = Math.min(-mapAmount.get(mxDebit), mapAmount.get(mxCredit));
        mapAmount.put(mxCredit, mapAmount.get(mxCredit) - min);
        mapAmount.put(mxDebit, mapAmount.get(mxDebit) + min);

        System.out.println(mxDebit + " pays " + min + " to " + mxCredit);

        minCashFlowRec(mapAmount);
    }

    public static void main(String... args) {
        insert("P0", "P1", 1000.0); // P0 owes 1000 to P1
        insert("P0", "P2", 2000.0); // P0 owes 2000 to P2
        insert("P1", "P2", 5000.0); // P1 owes 5000 to P2

        simplifyDebt();
    }
}
