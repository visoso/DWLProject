package DWLProject;

import java.awt.Dimension;
import java.awt.Point;
import java.util.List;

import view.modeling.ViewableComponent;
import view.modeling.ViewableDigraph;
import DWLProject.utils.DWLUtils;
import GenCol.entity;

/**
 * DW_1_1.java
 * 
 * @author Ivan C
 * 
 */
public class DW_1_1 extends ViewableDigraph {

	//in port
	private static final String EXT_CAT_IN = "ExtCatIn";
	private static final String LOAD = "load";
	private static final String STOP = "stop";
	//out port
	private static final String STATS = "stats";
	private static final String HALT = "halt";

	private static final String EXT_CAT_OUT = "ExtCatOut";
	private static final String CAT_OUT = "CatOut";
	private int numberOfProcessors;

	// Add Default Constructor
	public DW_1_1() {
		this("DW", 2);
	}

	// Add Parameterized Constructor
	public DW_1_1(String name, int numberOfProcessors) {
		super(name);
		this.numberOfProcessors = numberOfProcessors;

		// Structure information start
		// Add input port names
        // Add input port names
        addInport(EXT_CAT_IN);
        addInport(LOAD);
        addInport(STOP);

        // Add output port names
        addOutport(STATS);
        addOutport(HALT);

		// add test input ports:
        CatFile catFile = new CatFile("Cat1", 100, 1, 5, 3, 1, 1D);
        ExtCatFile extCat = new ExtCatFile("ExtCat11", 100, "L1", 2011, 4, 1D);
        extCat.setParentCatFile(catFile);
        catFile.addExtCatFile(extCat);
        addTestInput(EXT_CAT_IN, extCat);
        extCat = new ExtCatFile("ExtCat12", 80, "L2", 2011, 3, 1D);
        extCat.setParentCatFile(catFile);
        catFile.addExtCatFile(extCat);
        addTestInput(EXT_CAT_IN, extCat);
        extCat = new ExtCatFile("ExtCat13", 20, "L3", 2011, 1, 1D);
        extCat.setParentCatFile(catFile);
        catFile.addExtCatFile(extCat);
        addTestInput(EXT_CAT_IN, extCat);
        addTestInput(LOAD, new entity("start"));
        addTestInput(STOP, new entity("stop"));

		// Initialize sub-components
		DW_Coord_0_0 coordinator = new DW_Coord_0_0("Coordinator");

		// Add sub-components
		add(coordinator);
		addWriters(coordinator);

		// Add Couplings
		addCoupling(this, EXT_CAT_IN, coordinator, EXT_CAT_IN);
		addCoupling(coordinator, HALT, this, HALT);
		addCoupling(this, LOAD, coordinator, LOAD);
		addCoupling(this, STOP, coordinator, STOP);
		addCoupling(coordinator, EXT_CAT_OUT, this, STATS);
		addCoupling(coordinator, CAT_OUT, this, STATS);

		// Structure information end
		initialize();
	}

	private void addWriters(DW_Coord_0_0 coordinator) {
		List<Writer_0_0> writerList = DWLUtils.createWriters(numberOfProcessors);
    	for (Writer_0_0 writer : writerList) {
    		add(writer);
    		addCoupling(coordinator, DW_Coord_0_0.getExtCatOut(), writer, Writer_0_0.getExtCatIn());
    		addCoupling(writer, Writer_0_0.getDone(), coordinator, DW_Coord_0_0.getWriterDone());
    		addCoupling(writer, Writer_0_0.getExtCatOut(), this, STATS);
    	}
    	coordinator.setWriters(writerList);
	}
    /**
     * Automatically generated by the SimView program.
     * Do not edit this manually, as such changes will get overwritten.
     */
    public void layoutForSimView()
    {
        preferredSize = new Dimension(475, 473);
        ((ViewableComponent)withName("Coordinator")).setPreferredLocation(new Point(41, 108));
        ((ViewableComponent)withName("Writer_1")).setPreferredLocation(new Point(55, 297));
    }
}
