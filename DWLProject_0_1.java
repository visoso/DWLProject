/*
*			Copyright Author
* (USE & RESTRICTIONS - Please read COPYRIGHT file)

* Version		: XX.XX
* Date		: 4/20/11 1:09 PM
*/

// Default Package
package GeneratedModelsDEVS_Suite;

import java.awt.Dimension;
import java.awt.Point;

import view.modeling.ViewableComponent;
import view.modeling.ViewableDigraph;

public class DWLProject_0_1 extends ViewableDigraph{

    // Add Default Constructor
    public DWLProject_0_1(){
        this("DWLProject_0_1");
    }

    // Add Parameterized Constructor
    public DWLProject_0_1(String name){
        super(name);

// Structure information start
        // Add input port names

        // Add output port names

//add test input ports:

        // Initialize sub-components
        ViewableDigraph EF_1_1 =  new EF_1_1("EF_1_1");
        ViewableDigraph DWL_1_1 =  new DWL_1_1("DWL_1_1");
        ViewableDigraph DW_1_1 =  new DW_1_1("DW_1_1");

        // Add sub-components
        add(EF_1_1);
        add(DWL_1_1);
        add(DW_1_1);

        // Add Couplings
        addCoupling(DWL_1_1, "insert", DW_1_1, "insert");
        addCoupling(DWL_1_1, "update", DW_1_1, "update");
        addCoupling(EF_1_1, "FFout", DWL_1_1, "FFin");
        addCoupling(EF_1_1, "start", DWL_1_1, "start");

// Structure information end
        initialize();
        }

    /**
     * Automatically generated by the SimView program.
     * Do not edit this manually, as such changes will get overwritten.
     */
    public void layoutForSimView()
    {
        preferredSize = new Dimension(1618, 543);
        ((ViewableComponent)withName("DW_1_1")).setPreferredLocation(new Point(1139, 40));
        ((ViewableComponent)withName("DWL_1_1")).setPreferredLocation(new Point(400, 42));
        ((ViewableComponent)withName("EF_1_1")).setPreferredLocation(new Point(20, 46));
    }
    }
