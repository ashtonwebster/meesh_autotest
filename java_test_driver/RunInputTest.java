package cmsc420.meeshquest.part2.tests.commands;

import static org.junit.Assert.*;

import java.awt.Point;
import java.awt.geom.Arc2D;
import java.awt.geom.Arc2D.Double;
import java.awt.geom.Point2D;
import java.io.IOException;

import org.junit.Test;

public class RunInputTest {

   @Test
   public void test() throws IOException, InterruptedException {
//      Arc2D.Double arc = new Arc2D.Double();
//      Point2D point1 = new Point(-1, 0);
//      Point2D point2 = new Point(0, 0);
//      Point2D point3 = new Point(1, 1);
//      arc.setArcByTangent(point1, point2, point3, 1.0);
//      System.err.println(arc.getAngleExtent());
      String fileName = "part2.public.avl";
      CommandTestUtil.ioTest("public/" + fileName + ".input.xml", "actual_out/" + fileName + ".xml");
   }

}
