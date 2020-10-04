package hadad.commons.miscellaneous;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import hadad.commons.miscellaneous.MathUtils;

public class BinomialCoefficientTest {

	int [] res = {1,7,21,35,35,21,7,1};
	int [] m = {0,1,2,3,4,5,6,7};
	int [] n = {7,7,7,7,7,7,7,7};
	@Test
	public void test() {
		for (int i = 0; i < m.length; i++) {
			int compRes = MathUtils.binomialCoefficient(n[i], m[i]); 
			if(res[i] != compRes)
				fail("Expected " + res[i] + ", got " + compRes);
		}
	}

}
