package org.openscience.cdk.modulesuites;

import junit.framework.JUnit4TestAdapter;
import junit.framework.Test;
import junit.framework.TestSuite;

import org.openscience.cdk.PcoreCoverageTest;
import org.openscience.cdk.pharmacophore.PharmacophoreMatcherTest;
import org.openscience.cdk.pharmacophore.PharmacophoreUtilityTest;

/**
 * TestSuite that runs all the sample tests for pharmacophore classes.
 *
 * @cdk.module test-pcore
 */
public class MpcoreTests {

    public static Test suite() {
        TestSuite suite = new TestSuite("The cdk.pcore Tests");
        suite.addTest(new JUnit4TestAdapter(PharmacophoreMatcherTest.class));
        suite.addTest(new JUnit4TestAdapter(PharmacophoreUtilityTest.class));
        suite.addTest(new JUnit4TestAdapter(PcoreCoverageTest.class));
        return suite;
    }

}