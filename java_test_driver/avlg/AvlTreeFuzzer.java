package cmsc420.meeshquest.part2.tests.avlg;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;

import org.junit.Test;

import cmsc420.meeshquest.part2.state.avl.AvlGMap;
import cmsc420.sortedmap.AvlGTree;

public class AvlTreeFuzzer {
   private static final int COUNT = 10000000;
   private static final int MAX_INT = 10000;
   private enum Command {
      INSERT,
      GET,
      BAD_GET,
   }

   @Test
   public void test() {
      Random randomGen = new Random();
      AvlGTree<Integer, Integer> avlMap = new AvlGTree<Integer, Integer>(8);
      TreeMap<Integer, Integer> treeMap = new TreeMap<Integer, Integer>();
      Set<Entry<Integer, Integer>> avlMapEntrySet = avlMap.entrySet();
      Set<Entry<Integer, Integer>> treeMapEntrySet = treeMap.entrySet();
      List<Integer> insertList = new ArrayList<Integer>();
      for (int i = 0; i < COUNT; i++) {
         Command command = Command.values()[randomGen.nextInt(Command.values().length)]; 
         switch (command) {
         case GET:
            if (insertList.size() > 0) { 
               int getKey = insertList.get(randomGen.nextInt(insertList.size()));
               assertEquals(treeMap.containsKey(getKey), avlMap.containsKey(getKey));
               assertEquals(treeMap.get(getKey), avlMap.get(getKey));
            }
            break;
         case INSERT:
            int key = randomGen.nextInt(MAX_INT);
            int value = randomGen.nextInt(MAX_INT);
//            int key = i;
//            int value = i;
            assertEquals(treeMap.put(key, value), avlMap.put(key, value));
            //assertEquals(treeMap, avlMap);
            //assertEquals(treeMap.get(key), avlMap.get(key));
            //assertTrue(avlMap.verifyBalance());
            //assertEquals(treeMap.size(), avlMap.size());
            //assertEquals(treeMapEntrySet, avlMapEntrySet);
            //manualIteratorCompare(treeMapEntrySet.iterator(), avlMapEntrySet.iterator());

            break;
         case BAD_GET:
            int badGetKey = randomGen.nextInt(MAX_INT);
            assertEquals(treeMap.containsKey(badGetKey), avlMap.containsKey(badGetKey));
            assertEquals(treeMap.get(badGetKey), avlMap.get(badGetKey));
         default:
            break;

         }
      }
   }
   
   public static void manualIteratorCompare(Iterator<Entry<Integer, Integer>> iter1, Iterator<Entry<Integer, Integer>> iter2) {
      
      while (iter1.hasNext()) {
         assertTrue(iter2.hasNext());
         Entry<Integer, Integer> iter1Entry = iter1.next();
         Entry<Integer, Integer> iter2Entry = iter2.next();
         assertEquals(iter1Entry, iter2Entry);
         
      }
      assertTrue(iter2.hasNext() == false);
      
   }

}
