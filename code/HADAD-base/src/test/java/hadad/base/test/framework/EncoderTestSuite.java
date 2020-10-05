package hadad.base.test.framework;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import hadad.base.compiler.model.encoder.aj.AJQueryBlockTreeNaiveCompilerTest;
import hadad.base.compiler.model.encoder.pj.PJQueryBlockTreeNaiveCompilerTest;
import hadad.base.compiler.model.encoder.pr.PRQueryBlockTreeNaiveCompilerTest;
import hadad.base.compiler.model.encoder.qbt.QueryBlockTreeNaiveCompilerTest;
import hadad.base.compiler.model.encoder.sj.SJQueryBlockTreeNaiveCompilerTest;
import hadad.base.compiler.model.encoder.sppj.SPPJQueryBlockTreeNaiveCompilerTest;
import hadad.base.compiler.model.encoder.xq.XQQueryBlockTreeNaiveCompilerTest;

/**
 * Encoders Test Suite.
 * 
 *   
 *
 */
@RunWith(Suite.class)
@SuiteClasses({ PJQueryBlockTreeNaiveCompilerTest.class, SJQueryBlockTreeNaiveCompilerTest.class,
        SPPJQueryBlockTreeNaiveCompilerTest.class, AJQueryBlockTreeNaiveCompilerTest.class,
        PRQueryBlockTreeNaiveCompilerTest.class, XQQueryBlockTreeNaiveCompilerTest.class,
        QueryBlockTreeNaiveCompilerTest.class })
public class EncoderTestSuite {
};
