/* $Revision: 5865 $ $Author: egonw $ $Date: 2006-03-30 00:42:34 +0200 (Thu, 30 Mar 2006) $
 * 
 * Copyright (C) 2004-2008  Miguel Rojas <miguel.rojas@uni-koeln.de>
 *                          Egon Willighagen <egonw@users.sf.net>
 * 
 * Contact: cdk-devel@lists.sourceforge.net
 * 
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public License
 * as published by the Free Software Foundation; either version 2.1
 * of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA. 
 */
package org.openscience.cdk.qsar.descriptors.bond;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.openscience.cdk.DefaultChemObjectBuilder;
import org.openscience.cdk.exception.CDKException;
import org.openscience.cdk.interfaces.IMolecule;
import org.openscience.cdk.qsar.descriptors.bond.BondPartialPiChargeDescriptor;
import org.openscience.cdk.qsar.descriptors.bond.MassNumberDifferenceDescriptor;
import org.openscience.cdk.qsar.result.DoubleResult;
import org.openscience.cdk.smiles.SmilesParser;

/**
 * TestSuite that runs all QSAR tests.
 *
 * @cdk.module test-qsarmolecular
 */
public class BondPartialPiChargeDescriptorTest extends BondDescriptorTest {
	
	public void setUp() throws Exception {
		super.setDescriptor(MassNumberDifferenceDescriptor.class);
	}
	
	/**
	 *  Constructor for the BondPartialPiChargeDescriptorTest object
	 *
	 */
	public  BondPartialPiChargeDescriptorTest() {
		
	}
	/**
	 *  A unit test suite for JUnit
	 *
	 *@return    The test suite
	 */
	public static Test suite() {
		return new TestSuite(BondPartialPiChargeDescriptorTest.class);
	}
	/**
	 *  A unit test for JUnit
	 */
	public void testBondPiElectronegativityDescriptor() throws ClassNotFoundException, CDKException, java.lang.Exception {
		descriptor  = new BondPartialPiChargeDescriptor() ;
		double [] testResult={0.0,0.0};/* from Petra online: http://www2.chemie.uni-erlangen.de/services/petra/smiles.phtml*/
		 
        SmilesParser sp = new SmilesParser(DefaultChemObjectBuilder.getInstance());
        IMolecule mol = sp.parseSmiles("CF"); 
        addExplicitHydrogens(mol);
        
        for (int i = 0 ; i < 2 ; i++){
			double result= ((DoubleResult)descriptor.calculate(mol.getBond(i),mol).getValue()).doubleValue();
			assertEquals(testResult[i],result,0.01);
		}
        
	}
	/**
	 *  A unit test for JUnit with Allyl bromide
	 */
	public void testBondPiElectronegativityDescriptor_Allyl_bromide() throws ClassNotFoundException, CDKException, java.lang.Exception {
		descriptor  = new BondPartialPiChargeDescriptor() ;
		double [] testResult={0.0022,0.0011,0.0011,0.0011,0.0011,0.0,0.0,0.0}; /* from Petra online: http://www2.chemie.uni-erlangen.de/services/petra/smiles.phtml*/
		
		SmilesParser sp = new SmilesParser(DefaultChemObjectBuilder.getInstance());
		IMolecule mol = sp.parseSmiles("C=CCBr");
		addExplicitHydrogens(mol);
		
		for (int i = 0 ; i < 8 ; i++){
			double result= ((DoubleResult)descriptor.calculate(mol.getBond(i),mol).getValue()).doubleValue();
			assertEquals(testResult[i],result,0.03);
		}
	}
	/**
	 *  A unit test for JUnit with Isopentyl iodide
	 */
	public void testBondPiElectronegativityDescriptor_Isopentyl_iodide() throws ClassNotFoundException, CDKException, java.lang.Exception {
		descriptor  = new BondPartialPiChargeDescriptor() ;
		double testResult = 0.0	; /* from Petra online: http://www2.chemie.uni-erlangen.de/services/petra/smiles.phtml*/
		
		SmilesParser sp = new SmilesParser(DefaultChemObjectBuilder.getInstance());
		IMolecule mol = sp.parseSmiles("C(C)(C)CCI");
		addExplicitHydrogens(mol);
		for (int i = 0 ; i < 6 ; i++){
			double result= ((DoubleResult)descriptor.calculate(mol.getBond(i),mol).getValue()).doubleValue();
			assertEquals(testResult,result,0.001);
		}
	}
	/**
	 *  A unit test for JUnit with Allyl mercaptan
	 */
	public void testBondPiElectronegativityDescriptor_Allyl_mercaptan() throws ClassNotFoundException, CDKException, java.lang.Exception {
		descriptor  = new BondPartialPiChargeDescriptor() ;
		double [] testResult={0.0006,0.0003,0.0003,0.0003,0.0003,0.0,0.0,0.0,0.0}; /* from Petra online: http://www2.chemie.uni-erlangen.de/services/petra/smiles.phtml*/
        
		SmilesParser sp = new SmilesParser(DefaultChemObjectBuilder.getInstance());
		IMolecule mol = sp.parseSmiles("C=CCS");
		addExplicitHydrogens(mol);
		
		for (int i = 0 ; i < 9 ; i++){
			double result= ((DoubleResult)descriptor.calculate(mol.getBond(i),mol).getValue()).doubleValue();
			assertEquals(testResult[i],result,0.03);
		}
	}
}
