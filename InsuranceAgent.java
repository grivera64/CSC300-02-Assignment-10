//package assignment10;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.Random;
import java.util.Scanner;

public class InsuranceAgent {

    public static Random randy;

    public static void main(String[] args) throws IOException {

        Scanner keyboard = new Scanner(System.in);
        long seed;

        System.out.print("Please enter a seed for the random number generator: ");
        seed = keyboard.nextLong();
        keyboard.nextLine();

        InsuranceAgent.randy = new Random(seed);

        Map<Integer, Integer> clientMap = new HashMap<>();
        Map<Integer, Integer> removedClientMap = new HashMap<>();
        int maxClientNum = 1000;
        int numToRemove;
        int numToAdd;

        InsuranceAgent.initialize(clientMap, maxClientNum);

        for (int days = 1; days <= 365; days++) {

            numToRemove = InsuranceAgent.randy.nextInt(4) + 1;
            InsuranceAgent.removeClients(clientMap, removedClientMap, maxClientNum, numToRemove);

            numToAdd = InsuranceAgent.randy.nextInt(7);
            maxClientNum = InsuranceAgent.addClients(clientMap, maxClientNum, numToAdd);

        }

        String fileName;
        File fileHandler;
        PrintWriter filePrintWriter;

        System.out.print("Please enter the name of the output file: ");
        fileName = keyboard.nextLine();

        fileHandler = new File(fileName);
        filePrintWriter = new PrintWriter(fileHandler);

        filePrintWriter.println("Current Client List");

        for (Map.Entry<Integer, Integer> entry : clientMap.entrySet()) {

            filePrintWriter.printf("Key = %d, Value = %d\n", entry.getKey(), entry.getValue());

        }

        filePrintWriter.println("\n\nRemoved Client List Ordered");

        Map<Integer, Integer> removedClientTreeMap = new TreeMap<>();
        removedClientTreeMap.putAll(removedClientMap);

        for (Map.Entry<Integer, Integer> entry : removedClientTreeMap.entrySet()) {

            filePrintWriter.printf("Key = %d, Value = %d\n", entry.getKey(), entry.getValue());

        }

        filePrintWriter.close();
        keyboard.close();

    }

    private static void initialize(Map<Integer, Integer> clientMap, int maxClientNum) {

        int safetyNumber;

        for (int number = 1; number <= maxClientNum; number++) {

            safetyNumber = InsuranceAgent.randy.nextInt(32) + 9;
            clientMap.put(number, safetyNumber);

        }

    }

    private static void removeClients(Map<Integer, Integer> clientMap, Map<Integer, Integer> removedClientMap,
                                      int maxClientNum, int numToRemove) {

        int tempKeyValue;
        int removedValue;

        for (int numRemoved = 0; numRemoved < numToRemove; numRemoved++) {

            tempKeyValue = InsuranceAgent.randy.nextInt(maxClientNum) + 1;

            if (clientMap.containsKey(tempKeyValue)) {

                removedValue = clientMap.remove(tempKeyValue);
                removedClientMap.put(tempKeyValue, removedValue);

            }

        }

    }

    private static int addClients(Map<Integer, Integer> clientMap, int maxClientNum, int numToAdd) {

        int safetyNumber;

        for (int numAdded = 0; numAdded < numToAdd; numAdded++) {

            maxClientNum++;
            safetyNumber = InsuranceAgent.randy.nextInt(32) + 9;
            clientMap.put(maxClientNum, safetyNumber);

        }

        return maxClientNum;

    }

}
