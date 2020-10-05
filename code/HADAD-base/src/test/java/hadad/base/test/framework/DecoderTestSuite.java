package hadad.base.test.framework;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import hadad.base.rewriting.decoder.rm.RMDecoderTest;
import hadad.base.rewriting.decoder.sj.SJDecoderTest;
import hadad.base.rewriting.decoder.sm.SMDecoderTest;
import hadad.base.rewriting.decoder.sppj.SPPJDecoderTest;


/**
 * Decoders Test Suite.
 * 
 *  
 *
 */
@RunWith(Suite.class)
@SuiteClasses({ SMDecoderTest.class,
        RMDecoderTest.class, SJDecoderTest.class, SPPJDecoderTest.class,})
public class DecoderTestSuite {

};
