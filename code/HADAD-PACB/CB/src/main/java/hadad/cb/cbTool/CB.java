package hadad.cb.cbTool;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import org.apache.log4j.Logger;

public class CB {
    final static Logger logger = Logger.getLogger(CB.class);

    public static void main(String args[]) throws Exception {
        final File[] files = new File("src/test/resources/Part1-NoViews").listFiles();
        final File out = new File("src/test/resources/Part1-NoViews/result.out");
        BufferedWriter writer = new BufferedWriter(new FileWriter(out, true));
//
//          for (File file : files) {
//          if(file.getName().equals("TEST7"))
//          {
//          logger.debug(file.getName() + ": ");
//          CBConfig.loadConfig();
//          long time = 0;
//          for (int i = 0; i < 10; i++) {
//              if (i == 0) {
//                  ToolUtils.ComputeRewritings(file.getAbsolutePath(), CBConfig.getProperties());
//              } else {
//                  long start = System.nanoTime();
//                  ToolUtils.ComputeRewritings(file.getAbsolutePath(), CBConfig.getProperties());
//                  long end = System.nanoTime();
//                  time += (end - start);
//              }
//          }
//          writer.append(file.getName() + ": ");
//          writer.append("" + ((time / 9) * 1e-9));
//          writer.append("\n");
//          }
//    
//      }
//      writer.close();
//        
            
        for (File file : files) {
            if(file.getName().equals("P1.15"))
            {
            logger.debug(file.getName() + ": ");
            CBConfig.loadConfig();
            long time = 0;
            for (int i = 0; i < 100; i++) {
                if (i == 0) {
                    ToolUtils.ComputeRewritings(file.getAbsolutePath(), CBConfig.getProperties());
                } else {
                    long start = System.nanoTime();
                    ToolUtils.ComputeRewritings(file.getAbsolutePath(), CBConfig.getProperties());
                    long end = System.nanoTime();
                    time += (end - start);
                }
            }
            writer.append(file.getName() + ": ");
            writer.append("" + ((time / 99) * 1e-9));
            writer.append("\n");
            }

        }
        writer.close();
//        long s = System.nanoTime();
//        for (int i=0; i<1;i++) {
//            ToolUtils.ComputeRewritings("src/test/resources/ExperTests/Test01", CBConfig.getProperties());
//        }
//        long e = System.nanoTime();
//        System.out.println(((e-s)/10)*1e-9);
        
//        
//        final long [] mask = new long[2];
//        int longplaceP0 = 0 / 63;
//        int longplaceP1 = 1 / 63;
//        int longindP0 = 0 % 63;
//        int longindP1 = 1 % 63;
//        
//        final long [] mask1 = new long[2];
//        int longplaceP01 = 0 / 63;
//        int longplaceP11 = 1 / 63;
//        int longindP01 = 0 % 63;
//        int longindP11 = 1 % 63;
//
//        
//        mask[longplaceP0] |= ((long) 1) << longindP0;
//        mask[longplaceP1] |= ((long) 1) << longindP1;
//        
//        mask1[longplaceP01] |= ((long) 1) << longindP01;
//        mask1[longplaceP11] |= ((long) 1) << longindP11;
//        
//        for (int k = 0; k < 2; ++k) {
//        for (int i = 0; i < 62; ++i) {
//            if ((mask[k] & (((long) 1) << i)) != 0) {
//                  //System.out.println(k * 63 + i);
//            }
//        }
//      
//
//       
//  
//        }
//        System.out.println(Arrays.equals(mask, mask1));

    }
}
