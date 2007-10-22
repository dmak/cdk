/* $RCSfile$
 * $Author$    
 * $Date$    
 * $Revision$
 * 
 * Copyright (C) 1997-2007  The Chemistry Development Kit (CDK) project
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
package org.openscience.cdk.templates;

import java.io.FileInputStream;

import javax.vecmath.Point2d;

import org.openscience.cdk.Atom;
import org.openscience.cdk.ChemFile;
import org.openscience.cdk.ChemObject;
import org.openscience.cdk.Molecule;
import org.openscience.cdk.config.IsotopeFactory;
import org.openscience.cdk.interfaces.IAtom;
import org.openscience.cdk.interfaces.IBond;
import org.openscience.cdk.interfaces.IMolecule;
import org.openscience.cdk.io.MDLReader;
import org.openscience.cdk.tools.LoggingTool;

/**
 * This class contains methods for generating simple organic molecules.
 *
 * @cdk.keyword templates
 * @cdk.svnrev  $Revision$
 */
public class MoleculeFactory {

    private static LoggingTool logger = null;
    
    static {
        logger = new LoggingTool(MoleculeFactory.class);
    }
    
	public static Molecule makeAlphaPinene() {
		Molecule mol = new Molecule();
		mol.addAtom(new Atom("C")); // 1
		mol.addAtom(new Atom("C")); // 2
		mol.addAtom(new Atom("C")); // 3
		mol.addAtom(new Atom("C")); // 4
		mol.addAtom(new Atom("C")); // 5
		mol.addAtom(new Atom("C")); // 6
		mol.addAtom(new Atom("C")); // 7
		mol.addAtom(new Atom("C")); // 8
		mol.addAtom(new Atom("C")); // 9
		mol.addAtom(new Atom("C")); // 10

		mol.addBond(0, 1, 2.0); // 1
		mol.addBond(1, 2, 1.0); // 2
		mol.addBond(2, 3, 1.0); // 3
		mol.addBond(3, 4, 1.0); // 4
		mol.addBond(4, 5, 1.0); // 5
		mol.addBond(5, 0, 1.0); // 6
		mol.addBond(0, 6, 1.0); // 7
		mol.addBond(3, 7, 1.0); // 8
		mol.addBond(5, 7, 1.0); // 9
		mol.addBond(7, 8, 1.0); // 10
		mol.addBond(7, 9, 1.0); // 11
		configureAtoms(mol);
		return mol;
	}

	/**
	 * Generate an Alkane (chain of carbons with no hydrogens) of a given length.
	 *
     * <p>This method was written by Stephen Tomkinson.
     *
	 * @param chainLength The number of carbon atoms to have in the chain.
	 * @return A molecule containing a bonded chain of carbons.
	 *
	 * @cdk.created 2003-08-15
	 */
  public static Molecule makeAlkane(int chainLength)
  {
    Molecule currentChain = new Molecule();

    //Add the initial atom
    currentChain.addAtom(new Atom("C"));

    //Add further atoms and bonds as needed, a pair at a time.
    for (int atomCount = 1; atomCount < chainLength; atomCount ++) {
        currentChain.addAtom(new Atom("C"));
        currentChain.addBond(atomCount, atomCount - 1, 1);
    }  

    return currentChain;
  }

	public static Molecule makeEthylCyclohexane()
	{
		Molecule mol = new Molecule();
		mol.addAtom(new Atom("C")); // 1
		mol.addAtom(new Atom("C")); // 2
		mol.addAtom(new Atom("C")); // 3
		mol.addAtom(new Atom("C")); // 4
		mol.addAtom(new Atom("C")); // 5
		mol.addAtom(new Atom("C")); // 6
		mol.addAtom(new Atom("C")); // 7
		mol.addAtom(new Atom("C")); // 8

		mol.addBond(0, 1, 1.0); // 1
		mol.addBond(1, 2, 1.0); // 2
		mol.addBond(2, 3, 1.0); // 3
		mol.addBond(3, 4, 1.0); // 4
		mol.addBond(4, 5, 1.0); // 5
		mol.addBond(5, 0, 1.0); // 6
		mol.addBond(0, 6, 1.0); // 7
		mol.addBond(6, 7, 1.0); // 8
		return mol;
	}

	/**
	 * Returns cyclohexene without explicit hydrogens.
	 * 
	 * @cdk.inchi InChI=1/C6H10/c1-2-4-6-5-3-1/h1-2H,3-6H2
	 */
	public static Molecule makeCyclohexene()
	{
		Molecule mol = new Molecule();
		mol.addAtom(new Atom("C")); // 1
		mol.addAtom(new Atom("C")); // 2
		mol.addAtom(new Atom("C")); // 3
		mol.addAtom(new Atom("C")); // 4
		mol.addAtom(new Atom("C")); // 5
		mol.addAtom(new Atom("C")); // 6

		mol.addBond(0, 1, 1.0); // 1
		mol.addBond(1, 2, 1.0); // 2
		mol.addBond(2, 3, 1.0); // 3
		mol.addBond(3, 4, 1.0); // 4
		mol.addBond(4, 5, 1.0); // 5
		mol.addBond(5, 0, 2.0); // 6
		return mol;
	}

	/**
	 * Returns cyclohexane without explicit hydrogens.
	 * 
	 * @cdk.inchi InChI=1/C6H12/c1-2-4-6-5-3-1/h1-6H2
	 */
	public static Molecule makeCyclohexane()
	{
		Molecule mol = new Molecule();
		mol.addAtom(new Atom("C")); // 1
		mol.addAtom(new Atom("C")); // 2
		mol.addAtom(new Atom("C")); // 3
		mol.addAtom(new Atom("C")); // 4
		mol.addAtom(new Atom("C")); // 5
		mol.addAtom(new Atom("C")); // 6

		mol.addBond(0, 1, 1.0); // 1
		mol.addBond(1, 2, 1.0); // 2
		mol.addBond(2, 3, 1.0); // 3
		mol.addBond(3, 4, 1.0); // 4
		mol.addBond(4, 5, 1.0); // 5
		mol.addBond(5, 0, 1.0); // 6
		return mol;
	}

	/**
	 * Returns cyclobutane without explicit hydrogens.
	 * 
	 * @cdk.inchi InChI=1/C4H8/c1-2-4-3-1/h1-4H2
	 */
	public static Molecule makeCyclobutane()
	{
		Molecule mol = new Molecule();
		mol.addAtom(new Atom("C")); // 1
		mol.addAtom(new Atom("C")); // 2
		mol.addAtom(new Atom("C")); // 3
		mol.addAtom(new Atom("C")); // 4

		mol.addBond(0, 1, 1.0); // 1
		mol.addBond(1, 2, 1.0); // 2
		mol.addBond(2, 3, 1.0); // 3
		mol.addBond(3, 0, 1.0); // 4
		return mol;
	}

	public static Molecule makePropylCycloPropane()
	{
		Molecule mol = new Molecule();
		mol.addAtom(new Atom("C")); // 0
		mol.addAtom(new Atom("C")); // 1
		mol.addAtom(new Atom("C")); // 2
		mol.addAtom(new Atom("C")); // 3
		mol.addAtom(new Atom("C")); // 4
		mol.addAtom(new Atom("C")); // 4
		mol.addBond(0, 1, 1.0); // 1
		mol.addBond(1, 2, 1.0); // 2
		mol.addBond(2, 0, 1.0); // 3
		mol.addBond(2, 3, 1.0); // 4
		mol.addBond(3, 4, 1.0); // 4
		mol.addBond(4, 5, 1.0); // 4
		
		return mol;
	}
	
	/**
	 * Returns biphenyl without explicit hydrogens.
	 * 
	 * @cdk.inchi InChI=1/C12H10/c1-3-7-11(8-4-1)12-9-5-2-6-10-12/h1-10H
	 */
	public static Molecule makeBiphenyl()
	{
		Molecule mol = new Molecule();
		mol.addAtom(new Atom("C")); // 0
		mol.addAtom(new Atom("C")); // 1		
		mol.addAtom(new Atom("C")); // 2
		mol.addAtom(new Atom("C")); // 3
		mol.addAtom(new Atom("C")); // 4
		mol.addAtom(new Atom("C")); // 5
		mol.addAtom(new Atom("C")); // 6
		mol.addAtom(new Atom("C")); // 7
		mol.addAtom(new Atom("C")); // 8
		mol.addAtom(new Atom("C")); // 9
		mol.addAtom(new Atom("C")); // 10
		mol.addAtom(new Atom("C")); // 11
	
		
		mol.addBond(0, 1, 2.0); // 1
		mol.addBond(1, 2, 1.0); // 2
		mol.addBond(2, 3, 2.0); // 3
		mol.addBond(3, 4, 1.0); // 4
		mol.addBond(4, 5, 2.0); // 5
		mol.addBond(5, 0, 1.0); // 6
	
		mol.addBond(0, 6, 1.0); // 7
		mol.addBond(6, 7, 1.0); // 8
		mol.addBond(7, 8, 2.0); // 5
		mol.addBond(8, 9, 1.0); // 6
		mol.addBond(9, 10, 2.0); // 7
		mol.addBond(10, 11, 1.0); // 8
		mol.addBond(11, 6, 2.0); // 5
		return mol;
	}
	

	public static Molecule makePhenylEthylBenzene()
	{
		Molecule mol = new Molecule();
		mol.addAtom(new Atom("C")); // 0
		mol.addAtom(new Atom("C")); // 1		
		mol.addAtom(new Atom("C")); // 2
		mol.addAtom(new Atom("C")); // 3
		mol.addAtom(new Atom("C")); // 4
		mol.addAtom(new Atom("C")); // 5
		mol.addAtom(new Atom("C")); // 6
		mol.addAtom(new Atom("C")); // 7
		mol.addAtom(new Atom("C")); // 8
		mol.addAtom(new Atom("C")); // 9
		mol.addAtom(new Atom("C")); // 10
		mol.addAtom(new Atom("C")); // 11
		mol.addAtom(new Atom("C")); // 12
		mol.addAtom(new Atom("C")); // 13
		
		mol.addBond(0, 1, 2.0); // 1
		mol.addBond(1, 2, 1.0); // 2
		mol.addBond(2, 3, 2.0); // 3
		mol.addBond(3, 4, 1.0); // 4
		mol.addBond(4, 5, 2.0); // 5
		mol.addBond(5, 0, 1.0); // 6
	
		mol.addBond(0, 6, 1.0); // 7
		mol.addBond(6, 7, 1.0); // 8
		mol.addBond(7, 8, 1.0); // 5
		mol.addBond(8, 9, 1.0); // 6
		mol.addBond(9, 10, 2.0); // 7
		mol.addBond(10, 11, 1.0); // 8
		mol.addBond(11, 12, 2.0); // 5
		mol.addBond(12, 13, 1.0);
		mol.addBond(13, 8, 2.0); // 5
		return mol;
	}

	
	/* build a molecule from 4 condensed triangles */
	public static Molecule make4x3CondensedRings()
	{
		Molecule mol = new Molecule();
		mol.addAtom(new Atom("C")); // 1
		mol.addAtom(new Atom("C")); // 2
		mol.addAtom(new Atom("C")); // 3
		mol.addAtom(new Atom("C")); // 4
		mol.addAtom(new Atom("C")); // 5
		mol.addAtom(new Atom("C")); // 6
		
		mol.addBond(0, 1, 1.0); // 1
		mol.addBond(1, 2, 1.0); // 2
		mol.addBond(2, 0, 1.0); // 3
		mol.addBond(2, 3, 1.0); // 4
		mol.addBond(1, 3, 1.0); // 5
		mol.addBond(3, 4, 1.0); // 6
		mol.addBond(4, 2, 1.0); // 7
		mol.addBond(4, 5, 1.0); // 8
		mol.addBond(5, 3, 1.0); // 9
		
		return mol;
	}
	
	public static Molecule makeSpiroRings()
	{
		Molecule mol = new Molecule();
		mol.addAtom(new Atom("C")); // 0
		mol.addAtom(new Atom("C")); // 1
		mol.addAtom(new Atom("C")); // 2
		mol.addAtom(new Atom("C")); // 3
		mol.addAtom(new Atom("C")); // 4
		mol.addAtom(new Atom("C")); // 5
		mol.addAtom(new Atom("C")); // 6
		mol.addAtom(new Atom("C")); // 7
		mol.addAtom(new Atom("C")); // 8
		mol.addAtom(new Atom("C")); // 9

		
		
		mol.addBond(0, 1, 1.0); // 1
		mol.addBond(1, 2, 1.0); // 2
		mol.addBond(2, 3, 1.0); // 3
		mol.addBond(3, 4, 1.0); // 4
		mol.addBond(4, 5, 1.0); // 5
		mol.addBond(5, 6, 1.0); // 6
		mol.addBond(6, 0, 1.0); // 7
		mol.addBond(6, 7, 1.0); // 8
		mol.addBond(7, 8, 1.0); // 9
		mol.addBond(8, 9, 1.0); // 10
		mol.addBond(9, 6, 1.0); // 11
		return mol;
	}
	

	public static Molecule makeBicycloRings()
	{
		Molecule mol = new Molecule();
		mol.addAtom(new Atom("C")); // 0
		mol.addAtom(new Atom("C")); // 1
		mol.addAtom(new Atom("C")); // 2
		mol.addAtom(new Atom("C")); // 3
		mol.addAtom(new Atom("C")); // 4
		mol.addAtom(new Atom("C")); // 5
		mol.addAtom(new Atom("C")); // 6
		mol.addAtom(new Atom("C")); // 7

		mol.addBond(0, 1, 1.0); // 1
		mol.addBond(1, 2, 1.0); // 2
		mol.addBond(2, 3, 1.0); // 3
		mol.addBond(3, 4, 1.0); // 4
		mol.addBond(4, 5, 1.0); // 5
		mol.addBond(5, 0, 1.0); // 6
		mol.addBond(6, 0, 1.0); // 7
		mol.addBond(6, 7, 1.0); // 8
		mol.addBond(7, 3, 1.0); // 9
		return mol;
	}

	public static Molecule makeFusedRings()
	{
		Molecule mol = new Molecule();
		mol.addAtom(new Atom("C")); // 0
		mol.addAtom(new Atom("C")); // 1
		mol.addAtom(new Atom("C")); // 2
		mol.addAtom(new Atom("C")); // 3
		mol.addAtom(new Atom("C")); // 4
		mol.addAtom(new Atom("C")); // 5
		mol.addAtom(new Atom("C")); // 6
		mol.addAtom(new Atom("C")); // 7
		mol.addAtom(new Atom("C")); // 8
		mol.addAtom(new Atom("C")); // 9

		mol.addBond(0, 1, 1.0); // 1
		mol.addBond(1, 2, 1.0); // 2
		mol.addBond(2, 3, 1.0); // 3
		mol.addBond(3, 4, 1.0); // 4
		mol.addBond(4, 5, 1.0); // 5
		mol.addBond(5, 0, 1.0); // 6
		mol.addBond(5, 6, 1.0); // 7
		mol.addBond(6, 7, 1.0); // 8
		mol.addBond(7, 4, 1.0); // 9
		mol.addBond(8, 0, 1.0); // 10
		mol.addBond(9, 1, 1.0); // 11
		mol.addBond(9, 8, 1.0); // 11
		return mol;
	}

	public static Molecule makeMethylDecaline()
	{
		Molecule mol = new Molecule();
		mol.addAtom(new Atom("C")); // 0
		mol.addAtom(new Atom("C")); // 1
		mol.addAtom(new Atom("C")); // 2
		mol.addAtom(new Atom("C")); // 3
		mol.addAtom(new Atom("C")); // 4
		mol.addAtom(new Atom("C")); // 5
		mol.addAtom(new Atom("C")); // 6
		mol.addAtom(new Atom("C")); // 7
		mol.addAtom(new Atom("C")); // 8
		mol.addAtom(new Atom("C")); // 9
		mol.addAtom(new Atom("C")); // 10

		
		mol.addBond(0, 1, 1.0); // 1
		mol.addBond(1, 2, 1.0); // 2
		mol.addBond(2, 3, 1.0); // 3
		mol.addBond(3, 4, 1.0); // 4
		mol.addBond(4, 5, 1.0); // 5
		mol.addBond(5, 0, 1.0); // 6
		mol.addBond(5, 6, 1.0); // 7
		mol.addBond(6, 7, 1.0); // 8RingSet
		mol.addBond(7, 8, 1.0); // 9
		mol.addBond(8, 9, 1.0); // 10
		mol.addBond(9, 0, 1.0); // 11
		mol.addBond(5, 10, 1.0); // 12
		return mol;

	}

	public static Molecule makeEthylPropylPhenantren()
	{
		Molecule mol = new Molecule();
		mol.addAtom(new Atom("C")); // 0
		mol.addAtom(new Atom("C")); // 1
		mol.addAtom(new Atom("C")); // 2
		mol.addAtom(new Atom("C")); // 3
		mol.addAtom(new Atom("C")); // 4
		mol.addAtom(new Atom("C")); // 5
		mol.addAtom(new Atom("C")); // 6
		mol.addAtom(new Atom("C")); // 7
		mol.addAtom(new Atom("C")); // 8
		mol.addAtom(new Atom("C")); // 9
		mol.addAtom(new Atom("C")); // 10
		mol.addAtom(new Atom("C")); // 11
		mol.addAtom(new Atom("C")); // 12
		mol.addAtom(new Atom("C")); // 13
		mol.addAtom(new Atom("C")); // 14
		mol.addAtom(new Atom("C")); // 15
		mol.addAtom(new Atom("C")); // 16
		mol.addAtom(new Atom("C")); // 17
		mol.addAtom(new Atom("C")); // 18
		
		mol.addBond(0, 1, 1.0); // 1
		mol.addBond(1, 2, 2.0); // 2
		mol.addBond(2, 3, 1.0); // 3
		mol.addBond(3, 4, 2.0); // 4
		mol.addBond(4, 5, 1.0); // 5
		mol.addBond(5, 6, 2.0); // 6
		mol.addBond(6, 7, 1.0); // 8
		mol.addBond(7, 8, 2.0); // 9
		mol.addBond(8, 9, 1.0); // 10
		mol.addBond(9, 0, 2.0); // 11		
		mol.addBond(9, 4, 1.0); // 12
		mol.addBond(8, 10, 1.0); // 12
		mol.addBond(10, 11, 2.0); // 12
		mol.addBond(11, 12, 1.0); // 12
		mol.addBond(12, 13, 2.0); // 12
		mol.addBond(13, 7, 1.0); // 12
		mol.addBond(3, 14, 1.0); // 12
		mol.addBond(14, 15, 1.0); // 12
		mol.addBond(12, 16, 1.0); // 12		
		mol.addBond(16, 17, 1.0); // 12
		mol.addBond(17, 18, 1.0); // 12	
		configureAtoms(mol);
		return mol;
	}

	public static Molecule makeSteran()
	{
		Molecule mol = new Molecule();
		mol.addAtom(new Atom("C")); // 0
		mol.addAtom(new Atom("C")); // 1
		mol.addAtom(new Atom("C")); // 2
		mol.addAtom(new Atom("C")); // 3
		mol.addAtom(new Atom("C")); // 4
		mol.addAtom(new Atom("C")); // 5
		mol.addAtom(new Atom("C")); // 6
		mol.addAtom(new Atom("C")); // 7
		mol.addAtom(new Atom("C")); // 8
		mol.addAtom(new Atom("C")); // 9
		mol.addAtom(new Atom("C")); // 10
		mol.addAtom(new Atom("C")); // 11
		mol.addAtom(new Atom("C")); // 12
		mol.addAtom(new Atom("C")); // 13
		mol.addAtom(new Atom("C")); // 14
		mol.addAtom(new Atom("C")); // 15
		mol.addAtom(new Atom("C")); // 16
		
		
		mol.addBond(0, 1, 1.0); // 1
		mol.addBond(1, 2,1.0); // 2
		mol.addBond(2, 3, 1.0); // 3
		mol.addBond(3, 4,1.0); // 4
		mol.addBond(4, 5, 1.0); // 5
		mol.addBond(5, 6,1.0); // 6
		mol.addBond(6, 7, 1.0); // 8
		mol.addBond(7, 8,1.0); // 9
		mol.addBond(8, 9, 1.0); // 10
		mol.addBond(9, 0,1.0); // 11		
		mol.addBond(9, 4, 1.0); // 12
		mol.addBond(8, 10, 1.0); // 13
		mol.addBond(10, 11,1.0); // 14
		mol.addBond(11, 12, 1.0); // 15
		mol.addBond(12, 13,1.0); // 16
		mol.addBond(13, 7, 1.0); // 17
		mol.addBond(13, 14, 1.0); // 18
		mol.addBond(14, 15, 1.0); // 19
		mol.addBond(15, 16, 1.0); // 20
		mol.addBond(16, 12, 1.0); // 21
		
		configureAtoms(mol);
		return mol;
	}

	/**
	 * Returns azulene without explicit hydrogens.
	 * 
	 * @cdk.inchi InChI=1/C10H8/c1-2-5-9-7-4-8-10(9)6-3-1/h1-8H
	 */
	public static Molecule makeAzulene()
	{
		Molecule mol = new Molecule();
		mol.addAtom(new Atom("C")); // 0
		mol.addAtom(new Atom("C")); // 1
		mol.addAtom(new Atom("C")); // 2
		mol.addAtom(new Atom("C")); // 3
		mol.addAtom(new Atom("C")); // 4
		mol.addAtom(new Atom("C")); // 5
		mol.addAtom(new Atom("C")); // 6
		mol.addAtom(new Atom("C")); // 7
		mol.addAtom(new Atom("C")); // 8
		mol.addAtom(new Atom("C")); // 9
		
		mol.addBond(0, 1, 2.0); // 1
		mol.addBond(1, 2, 1.0); // 2
		mol.addBond(2, 3, 2.0); // 3
		mol.addBond(3, 4, 1.0); // 4
		mol.addBond(4, 5, 2.0); // 5
		mol.addBond(5, 6, 1.0); // 6
		mol.addBond(6, 7, 2.0); // 8
		mol.addBond(7, 8, 1.0); // 9
		mol.addBond(8, 9, 2.0); // 10
		mol.addBond(9, 5, 1.0); // 11
		mol.addBond(9, 0, 1.0); // 12
		
		return mol;
	}

	/**
	 * Returns indole without explicit hydrogens.
	 * 
	 * @cdk.inchi InChI=1/C8H7N/c1-2-4-8-7(3-1)5-6-9-8/h1-6,9H
	 */
	public static Molecule makeIndole()
	{
		Molecule mol = new Molecule();
		mol.addAtom(new Atom("C")); // 0
		mol.addAtom(new Atom("C")); // 1
		mol.addAtom(new Atom("C")); // 2
		mol.addAtom(new Atom("C")); // 3
		mol.addAtom(new Atom("C")); // 4
		mol.addAtom(new Atom("C")); // 5
		mol.addAtom(new Atom("C")); // 6
		mol.addAtom(new Atom("C")); // 7
		mol.addAtom(new Atom("N")); // 8

		
		mol.addBond(0, 1, 2.0); // 1
		mol.addBond(1, 2, 1.0); // 2
		mol.addBond(2, 3, 2.0); // 3
		mol.addBond(3, 4, 1.0); // 4
		mol.addBond(4, 5, 2.0); // 5
		mol.addBond(5, 6, 1.0); // 6
		mol.addBond(6, 7, 2.0); // 8
		mol.addBond(7, 8, 1.0); // 9
		mol.addBond(0, 5, 1.0); // 11
		mol.addBond(8, 0, 1.0); // 12
		
		return mol;
	}

	/**
	 * Returns pyrrole without explicit hydrogens.
	 * 
	 * @cdk.inchi InChI=1/C4H5N/c1-2-4-5-3-1/h1-5H
	 */
	public static Molecule makePyrrole()
	{
		Molecule mol = new Molecule();
		mol.addAtom(new Atom("C")); // 0
		mol.addAtom(new Atom("N")); // 1
		mol.addAtom(new Atom("C")); // 2
		mol.addAtom(new Atom("C")); // 3
		mol.addAtom(new Atom("C")); // 4
		
		mol.addBond(0, 1, 1.0); // 1
		mol.addBond(1, 2, 1.0); // 2
		mol.addBond(2, 3, 2.0); // 3
		mol.addBond(3, 4, 1.0); // 4
		mol.addBond(4, 0, 2.0); // 5
		
		return mol;
	}

	/**
	 * Returns thiazole without explicit hydrogens.
	 * 
	 * @cdk.inchi InChI=1/C3H3NS/c1-2-5-3-4-1/h1-3H
	 */
	public static Molecule makeThiazole()
	{
		Molecule mol = new Molecule();
		mol.addAtom(new Atom("C")); // 0
		mol.addAtom(new Atom("N")); // 1
		mol.addAtom(new Atom("C")); // 2
		mol.addAtom(new Atom("S")); // 3
		mol.addAtom(new Atom("C")); // 4
		
		mol.addBond(0, 1, 1.0); // 1
		mol.addBond(1, 2, 2.0); // 2
		mol.addBond(2, 3, 1.0); // 3
		mol.addBond(3, 4, 1.0); // 4
		mol.addBond(4, 0, 2.0); // 5
		
		return mol;
	}	

	
	public static Molecule makeSingleRing()
	{
		Molecule mol = new Molecule();
		mol.addAtom(new Atom("C")); // 0
		mol.addAtom(new Atom("C")); // 1
		mol.addAtom(new Atom("C")); // 2
		mol.addAtom(new Atom("C")); // 3
		mol.addAtom(new Atom("C")); // 4
		mol.addAtom(new Atom("C")); // 5
//		mol.addAtom(new Atom("C")); // 6
//		mol.addAtom(new Atom("C")); // 7
//		mol.addAtom(new Atom("C")); // 8
//		mol.addAtom(new Atom("C")); // 9
		
		mol.addBond(0, 1, 1.0); // 1
		mol.addBond(1, 2, 1.0); // 2
		mol.addBond(2, 3, 1.0); // 3
		mol.addBond(3, 4, 1.0); // 4
		mol.addBond(4, 5, 1.0); // 5
		mol.addBond(5, 0, 1.0); // 6
//		mol.addBond(5, 6, 1.0); // 7
//		mol.addBond(6, 7, 1.0); // 8
//		mol.addBond(7, 4, 1.0); // 9
//		mol.addBond(8, 0, 1.0); // 10
//		mol.addBond(9, 1, 1.0); // 11		
		
			
		return mol;
	}
	

	public static Molecule makeDiamantane()
	{
		Molecule mol = new Molecule();
		mol.addAtom(new Atom("C")); // 0
		mol.addAtom(new Atom("C")); // 1
		mol.addAtom(new Atom("C")); // 2
		mol.addAtom(new Atom("C")); // 3
		mol.addAtom(new Atom("C")); // 4
		mol.addAtom(new Atom("C")); // 5
		mol.addAtom(new Atom("C")); // 6
		mol.addAtom(new Atom("C")); // 7
		mol.addAtom(new Atom("C")); // 8
		mol.addAtom(new Atom("C")); // 9
		mol.addAtom(new Atom("C")); // 10
		mol.addAtom(new Atom("C")); // 11
		mol.addAtom(new Atom("C")); // 12
		mol.addAtom(new Atom("C")); // 13
		
		
		mol.addBond(0, 1, 1.0); // 1
		mol.addBond(1, 2, 1.0); // 2
		mol.addBond(2, 3, 1.0); // 3
		mol.addBond(3, 4, 1.0); // 4
		mol.addBond(4, 5, 1.0); // 5
		mol.addBond(5, 0, 1.0); // 6
		mol.addBond(5, 6, 1.0); // 7
		mol.addBond(6, 9, 1.0); // 8
		mol.addBond(1, 7, 1.0); // 9
		mol.addBond(7, 9, 1.0); // 10
		mol.addBond(3, 8, 1.0); // 11		
		mol.addBond(8, 9, 1.0); // 12
		mol.addBond(0, 10, 1.0); // 13
		mol.addBond(10, 13, 1.0); // 14
		mol.addBond(2, 11, 1.0); // 15
		mol.addBond(11, 13, 1.0); // 16
		mol.addBond(4, 12, 1.0); // 17		
		mol.addBond(12, 13, 1.0); // 18		
				
		return mol;
	}


	public static Molecule makeBranchedAliphatic()
	{
		Molecule mol = new Molecule();
		mol.addAtom(new Atom("C")); // 0
		mol.addAtom(new Atom("C")); // 1
		mol.addAtom(new Atom("C")); // 2
		mol.addAtom(new Atom("C")); // 3
		mol.addAtom(new Atom("C")); // 4
		mol.addAtom(new Atom("C")); // 5
		mol.addAtom(new Atom("C")); // 6
		mol.addAtom(new Atom("C")); // 7
		mol.addAtom(new Atom("C")); // 8
		mol.addAtom(new Atom("C")); // 9
		mol.addAtom(new Atom("C")); // 10
		mol.addAtom(new Atom("C")); // 11
		mol.addAtom(new Atom("C")); // 12
		mol.addAtom(new Atom("C")); // 13
		mol.addAtom(new Atom("C")); // 14
		mol.addAtom(new Atom("C")); // 15
		mol.addAtom(new Atom("C")); // 16
		mol.addAtom(new Atom("C")); // 17
		mol.addAtom(new Atom("C")); // 18
		
		mol.addBond(0, 1, 1.0); // 1
		mol.addBond(1, 2, 1.0); // 2
		mol.addBond(2, 3, 2.0); // 3
		mol.addBond(3, 4, 1.0); // 4
		mol.addBond(4, 5, 1.0); // 5
		mol.addBond(2, 6, 1.0); // 6
		mol.addBond(6, 7, 1.0); // 7
		mol.addBond(7, 8, 1.0); // 8
		mol.addBond(6, 9, 1.0); // 9
		mol.addBond(6, 10, 1.0); // 10
		mol.addBond(10, 11, 1.0); // 11
		mol.addBond(8, 12, 3.0); // 12
		mol.addBond(12, 13, 1.0); // 13
		mol.addBond(11, 14, 1.0); // 14
		mol.addBond(9, 15, 1.0);
		mol.addBond(15, 16, 2.0);
		mol.addBond(16, 17, 2.0);
		mol.addBond(17, 18, 1.0);
		
		
		return mol;
	}

	public static Molecule makeBenzene()
	{
		Molecule mol = new Molecule();
		mol.addAtom(new Atom("C")); // 0
		mol.addAtom(new Atom("C")); // 1
		mol.addAtom(new Atom("C")); // 2
		mol.addAtom(new Atom("C")); // 3
		mol.addAtom(new Atom("C")); // 4
		mol.addAtom(new Atom("C")); // 5
		
		mol.addBond(0, 1, 1.0); // 1
		mol.addBond(1, 2, 2.0); // 2
		mol.addBond(2, 3, 1.0); // 3
		mol.addBond(3, 4, 2.0); // 4
		mol.addBond(4, 5, 1.0); // 5
		mol.addBond(5, 0, 2.0); // 6
		return mol;
	}
	
	public static Molecule makeQuinone()
	{
		Molecule mol = new Molecule();
		mol.addAtom(new Atom("O")); // 0
		mol.addAtom(new Atom("C")); // 1
		mol.addAtom(new Atom("C")); // 2
		mol.addAtom(new Atom("C")); // 3
		mol.addAtom(new Atom("C")); // 4
		mol.addAtom(new Atom("C")); // 5
		mol.addAtom(new Atom("C")); // 6
		mol.addAtom(new Atom("O")); // 7
		
		mol.addBond(0, 1, 2.0); // 1
		mol.addBond(1, 2, 1.0); // 2
		mol.addBond(2, 3, 2.0); // 3
		mol.addBond(3, 4, 1.0); // 4
		mol.addBond(4, 5, 1.0); // 5
		mol.addBond(5, 6, 2.0); // 6
		mol.addBond(6, 1, 1.0); // 7
		mol.addBond(4, 7, 2.0); // 8
		return mol;
	}
	
	
	public static org.openscience.cdk.interfaces.IMolecule loadMolecule(String inFile)
	{
		MDLReader mr = null;
		ChemFile chemFile = null;
		org.openscience.cdk.interfaces.IChemSequence chemSequence = null;
		org.openscience.cdk.interfaces.IChemModel chemModel = null;
		org.openscience.cdk.interfaces.IMoleculeSet setOfMolecules = null;
		org.openscience.cdk.interfaces.IMolecule molecule = null;
		try
		{
			FileInputStream fis = new FileInputStream(inFile);
			mr = new MDLReader(fis);
			chemFile = (ChemFile)mr.read((ChemObject)new ChemFile());
			fis.close();
			chemSequence = chemFile.getChemSequence(0);
			chemModel = chemSequence.getChemModel(0);
			setOfMolecules = chemModel.getMoleculeSet();
			molecule = setOfMolecules.getMolecule(0);
			for (int i = 0; i < molecule.getAtomCount(); i++)
			{
				molecule.getAtom(i).setPoint2d(null);
			}
		}
		catch(Exception exc)
		{
			// we just return null if something went wrong
            logger.error("An exception occured while loading a molecule: " + inFile);
            logger.debug(exc);
		}
		
		return molecule;
	}

	/**
	 * @cdk.inchi InChI=1/C5H5N5/c6-4-3-5(9-1-7-3)10-2-8-4/h1-2H,(H3,6,7,8,9,10)/f/h7H,6H2
	 */
	public static IMolecule makeAdenine() {
    	IMolecule mol = new Molecule(); // Adenine
    	IAtom a1 = mol.getBuilder().newAtom("C");
    	a1.setPoint2d(new Point2d(21.0223, -17.2946));  mol.addAtom(a1);
    	IAtom a2 = mol.getBuilder().newAtom("C");
    	a2.setPoint2d(new Point2d(21.0223, -18.8093));  mol.addAtom(a2);
    	IAtom a3 = mol.getBuilder().newAtom("C");
    	a3.setPoint2d(new Point2d(22.1861, -16.6103));  mol.addAtom(a3);
    	IAtom a4 = mol.getBuilder().newAtom("N");
    	a4.setPoint2d(new Point2d(19.8294, -16.8677));  mol.addAtom(a4);
    	IAtom a5 = mol.getBuilder().newAtom("N");
    	a5.setPoint2d(new Point2d(22.2212, -19.5285));  mol.addAtom(a5);
    	IAtom a6 = mol.getBuilder().newAtom("N");
    	a6.setPoint2d(new Point2d(19.8177, -19.2187));  mol.addAtom(a6);
    	IAtom a7 = mol.getBuilder().newAtom("N");
    	a7.setPoint2d(new Point2d(23.4669, -17.3531));  mol.addAtom(a7);
    	IAtom a8 = mol.getBuilder().newAtom("N");
    	a8.setPoint2d(new Point2d(22.1861, -15.2769));  mol.addAtom(a8);
    	IAtom a9 = mol.getBuilder().newAtom("C");
    	a9.setPoint2d(new Point2d(18.9871, -18.0139));  mol.addAtom(a9);
    	IAtom a10 = mol.getBuilder().newAtom("C");
    	a10.setPoint2d(new Point2d(23.4609, -18.8267));  mol.addAtom(a10);
    	IBond b1 = mol.getBuilder().newBond(a1, a2, 2.0);
    	mol.addBond(b1);
    	IBond b2 = mol.getBuilder().newBond(a1, a3, 1.0);
    	mol.addBond(b2);
    	IBond b3 = mol.getBuilder().newBond(a1, a4, 1.0);
    	mol.addBond(b3);
    	IBond b4 = mol.getBuilder().newBond(a2, a5, 1.0);
    	mol.addBond(b4);
    	IBond b5 = mol.getBuilder().newBond(a2, a6, 1.0);
    	mol.addBond(b5);
    	IBond b6 = mol.getBuilder().newBond(a3, a7, 2.0);
    	mol.addBond(b6);
    	IBond b7 = mol.getBuilder().newBond(a3, a8, 1.0);
    	mol.addBond(b7);
    	IBond b8 = mol.getBuilder().newBond(a4, a9, 2.0);
    	mol.addBond(b8);
    	IBond b9 = mol.getBuilder().newBond(a5, a10, 2.0);
    	mol.addBond(b9);
    	IBond b10 = mol.getBuilder().newBond(a6, a9, 1.0);
    	mol.addBond(b10);
    	IBond b11 = mol.getBuilder().newBond(a7, a10, 1.0);
    	mol.addBond(b11);
    	
    	return mol;
	}
	
	private static void configureAtoms(Molecule mol)
	{
		try
		{
            IsotopeFactory.getInstance(mol.getBuilder()).configureAtoms(mol);
		}
		catch(Exception exc)
		{
            logger.error("Could not configure molecule!");
            logger.debug(exc);
		}
	}

}

