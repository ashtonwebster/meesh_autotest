package cmsc420.meeshquest.part2.tests.avlg;

import static org.junit.Assert.*;

import java.util.SortedMap;
import java.util.TreeMap;

import org.junit.Test;

import cmsc420.meeshquest.part2.state.avl.AvlGMap;
import cmsc420.sortedmap.AvlGTree;

public class AvlGContainsTest {

   @Test
   public void test() {
      SortedMap<Integer, String> avlMap = new AvlGTree<Integer, String>();
      SortedMap<Integer, String> treeMap = new TreeMap<Integer, String>();
      Integer[] keyList = {2, 3, 4, 5};
      String[] valList = {"b", "c", "d", "e"};
      for (int i = 0; i < keyList.length; i++ ) {
         avlMap.put(keyList[i], valList[i]);
         treeMap.put(keyList[i], valList[i]);
         assertEquals(treeMap.containsKey(keyList[i]), avlMap.containsKey(keyList[i]));
         assertEquals(treeMap.containsValue(valList[i]), avlMap.containsValue(valList[i]));
      }
      assertFalse(avlMap.containsKey(6));
      assertFalse(avlMap.containsValue(3));
      assertFalse(avlMap.containsValue("bill"));
      assertFalse(avlMap.containsValue(null));
      //assertFalse(avlMap.containsKey(null));
   }

}
