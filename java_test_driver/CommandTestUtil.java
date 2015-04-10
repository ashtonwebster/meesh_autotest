package cmsc420.meeshquest.part2.tests.commands;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;

import cmsc420.meeshquest.part2.MeeshQuest;
import cmsc420.meeshquest.part2.state.StateMediator;

public class CommandTestUtil {

   public static StateMediator ioTest(String inputName, String outputName) throws IOException {
      String inputFileName = inputName;
      String outputFileName = outputName;
      System.setIn(new FileInputStream(new File(inputFileName)));
      File f = new File(outputFileName);
      f.createNewFile();
      System.setOut(new PrintStream(f));
      return MeeshQuest.executeAll();
      
   }
   
}
