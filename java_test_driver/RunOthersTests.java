package cmsc420.meeshquest.part2.tests;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import cmsc420.meeshquest.part2.tests.commands.CommandTestUtil;

public class RunOthersTests {

   @Test
   public void test() throws IOException {
      //for each input, create output
      Iterator<File> fileIter = FileUtils.iterateFiles(new File("others_inputs/"), null, false);
      File curFile;
      while (fileIter.hasNext()) {
         curFile = fileIter.next();
         String fileName = curFile.getName();
         try {
            System.err.println(fileName);
         CommandTestUtil.ioTest("others_inputs/" + fileName, "actual_out/" + fileName);
         } catch (Exception e) {
            //i'm so sorry
         }
      }
      
//      CommandTestUtil.ioTest("others_inputs/PMTEST.input.xml", "actual_out/PMTEST.input.xml");

   }

}
