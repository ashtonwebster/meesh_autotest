package cmsc420.meeshquest.part2.tests.avlg;

import static org.junit.Assert.*;

import java.util.SortedMap;
import java.util.TreeMap;

import org.junit.Test;

public class MapNoncomparableTest {

   public class MyObject {
      
      int hi;
      
   }
   
   @Test
   public void test() {
      SortedMap<MyObject, Integer> map = new TreeMap<MyObject, Integer>();
      map.put(new MyObject(), 1);
   }

}
