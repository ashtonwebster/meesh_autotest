package cmsc420.meeshquest.part2.tests;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import cmsc420.meeshquest.part2.tests.commands.CommandTestUtil;

public class DiffAll {

   @Test
   public void test() {
      //for each input, create output
      Iterator<File> fileIter = FileUtils.iterateFiles(new File("others_inputs/"), null, false);
      File curFile;
      while (fileIter.hasNext()) {
         curFile = fileIter.next();
         String fileName = curFile.getName();
         System.err.println(fileName);
         Process p;
         try {
            p = Runtime.getRuntime().exec(String.format("diff expected_out/%s actual_out/%s", fileName, fileName));
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));

            //output file
            File file = new File("diff/" + fileName + "_diff");

            // if file doesnt exists, then create it
            if (!file.exists()) {
               file.createNewFile();
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);

            String s;
            while ((s = stdInput.readLine()) != null) {
               bw.write(s + "\n");
                  
            }
            bw.close();         
         } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }                                                                                                                                                     
 

      }

   }

}
