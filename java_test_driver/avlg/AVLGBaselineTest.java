package cmsc420.meeshquest.part2.tests.avlg;

import static org.junit.Assert.*;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import cmsc420.meeshquest.part2.state.avl.AVLGNode;
import cmsc420.meeshquest.part2.state.avl.AvlGMap;
import cmsc420.meeshquest.part2.state.avl.BlackAVLGNode;
import cmsc420.meeshquest.part2.state.avl.DuplicateKeyException;
import cmsc420.meeshquest.part2.state.avl.WhiteAVLGNode;
import cmsc420.sortedmap.AvlGTree;
import cmsc420.xml.XmlUtility;

public class AVLGBaselineTest {
   

   @Test
   public void test2() {
      AvlGTree<Integer, String> avlMap = new AvlGTree<Integer, String>(2);
      TreeMap<Integer, String> treeMap = new TreeMap<Integer, String>();
      assertTrue(avlMap.equals(treeMap));
      assertTrue(treeMap.equals(avlMap));
      Set<Entry<Integer, String>> treeMapEntrySet = treeMap.entrySet();
      Set<Entry<Integer, String>> avlMapEntrySet = avlMap.entrySet();
      int[] keyList = {2, 3, 4, 5};
      String[] valList = {"b", "c", "d", "e"};
      for (int i = 0; i < keyList.length; i++ ) {
         avlMap.put(keyList[i], valList[i]);
         treeMap.put(keyList[i], valList[i]);
         assertEquals(treeMapEntrySet, avlMapEntrySet);
      }
      assertTrue(avlMap.equals(treeMap));
      assertTrue(treeMap.equals(avlMap));
      
      //empty map sanity test
      AvlGTree<String, String> emptyMap = new AvlGTree<String, String>();
      assertFalse(avlMap.equals(emptyMap));
      assertTrue(avlMap.equals(avlMap));
      assertTrue(avlMap.containsKey(2));
      assertTrue(avlMap.containsValue("d"));
      assertFalse(avlMap.containsKey(6));
      assertFalse(avlMap.containsValue("f"));
      assertEquals(avlMap.get(3), "c");
      assertEquals(avlMap.get(7), null);
      assertEquals("e", avlMap.put(5, "f"));
      System.out.println(avlMap.toString());
      Iterator<Entry<Integer,String>> iterator = avlMapEntrySet.iterator();
      while (iterator.hasNext()) {
         Entry<Integer, String> entry = iterator.next();
         System.out.println(entry);
      }
      assertTrue(avlMap.verifyBalance());
      


   }
   

   
   @Test
   public void test3() {
      AvlGMap<Integer, String> map = new AvlGMap<Integer, String>(1);

      int[] keyList = {2, 4, 3};
      String[] valList = {"b", "c", "d", "e"};
      for (int i = 0; i < keyList.length; i++ ) {
         map.put(keyList[i], valList[i]);
      }
      
      Document doc;
      try {
         doc = XmlUtility.getDocumentBuilder().newDocument();
         Element rootElement = doc.createElement("rootElement");
         doc.appendChild(rootElement);
         map.appendXML(doc, doc.getDocumentElement());
         XmlUtility.print(doc);
      } catch (ParserConfigurationException e) {
         e.printStackTrace();
      } catch (TransformerException e) {
         e.printStackTrace();
      }
      assertTrue(map.verifyBalance());
      assertTrue(map.equals(map));
   }
   
   @Test
   public void test4() {
      AvlGTree<Integer, String> map = new AvlGTree<Integer, String>(2);
      TreeMap<Integer, String> treeMap = new TreeMap<Integer, String>();
      assertTrue(map.equals(treeMap));
      assertTrue(treeMap.equals(map));
      int[] keyList = {7, 6, 5, 4, 3};
      String[] valList = {"a", "b", "c", "d", "e"};
      for (int i = 0; i < keyList.length; i++ ) {
         assertEquals(treeMap.put(keyList[i], valList[i]), map.put(keyList[i], valList[i]));
      }
      
      assertTrue(map.equals(treeMap));
      assertTrue(treeMap.equals(map));
      assertTrue(map.equals(map));
      
      for (int i = 0; i < keyList.length; i++) {
         assertEquals(treeMap.get(keyList[i]), map.get(keyList[i]));
      }
      
      assertEquals(treeMap.put(7, "q"), map.put(7, "q"));
      assertEquals(treeMap, map);
      assertEquals(treeMap.get(7), map.get(7));
      
   }
   

}
