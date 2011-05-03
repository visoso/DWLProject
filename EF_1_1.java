/**
 *			Copyright Author
 * (USE & RESTRICTIONS - Please read COPYRIGHT file)

 * Date		: 4/20/11 1:09 PM
 */
package DWLProject;

import java.awt.Dimension;
import java.awt.Point;

import DWLProject.utils.DWLProperties;

import view.modeling.ViewableAtomic;
import view.modeling.ViewableComponent;
import view.modeling.ViewableDigraph;

/**
 * EF_1_1.java
 * 
 * @author CosMos, Ivan C, Enrique V
 *
 */
public class EF_1_1 extends ViewableDigraph {

	private double observationTime;

	// Add Default Constructor
	public EF_1_1() {
		this("EF_1_1");
	}

	// Add Parameterized Constructor
	public EF_1_1(String name) {
		super(name);

		// Structure information start
		// Add input port names
		addInport("stats");
		addInport("errorFile");

		// Add output port names
		addOutport("measures");
		addOutport("FFout");
		addOutport("start");

		// add test input ports:

		// Initialize sub-components
		ViewableAtomic generator_1_0 = new generator_0_0("Generator", 10);
		observationTime = Double.valueOf(DWLProperties.getInstance().getValue("ObservationTime"));
		ViewableAtomic transducer_1_0 = new Transducer_0_0("Transducer_1_0",
				observationTime);

		// Add sub-components
		add(generator_1_0);
		add(transducer_1_0);

		// Add Couplings
		addCoupling(generator_1_0, "FFout", this, "FFout");
		addCoupling(generator_1_0, "start", this, "start");
		addCoupling(this, "stats", transducer_1_0, "stats");
		addCoupling(this, "ErrorFile", transducer_1_0, "ErrorFile");
		addCoupling(transducer_1_0, "measures", this, "measures");

		// Structure information end
		initialize();
	}

	/**
	 * Automatically generated by the SimView program. Do not edit this
	 * manually, as such changes will get overwritten.
	 */
	public void layoutForSimView() {
		preferredSize = new Dimension(367, 469);
		((ViewableComponent) withName("Transducer_1_0"))
				.setPreferredLocation(new Point(-11, 234));
		((ViewableComponent) withName("Generator"))
				.setPreferredLocation(new Point(64, 30));
	}
}
