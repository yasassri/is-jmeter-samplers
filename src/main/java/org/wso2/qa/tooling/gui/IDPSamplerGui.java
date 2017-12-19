package org.wso2.qa.tooling.gui;

import org.apache.jmeter.gui.util.JSyntaxTextArea;
import org.apache.jmeter.gui.util.JTextScrollPane;
import org.apache.jmeter.samplers.gui.AbstractSamplerGui;
import org.apache.jmeter.testelement.TestElement;
import org.apache.jmeter.util.JMeterUtils;
import org.wso2.qa.tooling.sampler.IDPSampler;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Created by yasassri on 12/16/17.
 */
public class IDPSamplerGui extends AbstractSamplerGui implements ChangeListener, ActionListener {

    private static final long serialVersionUID = 240L;
    private static final String CONDITION_LABEL = "while_controller_label";
    private JSyntaxTextArea theCondition;
    private static final String CONDITION = "While_Condition";

    IDPSamplerGui (){
        this.init();
    }
    @Override public void actionPerformed(ActionEvent e) {

    }

    @Override public void stateChanged(ChangeEvent e) {

    }

    @Override public String getLabelResource() {
        return "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
    }

    public String getStaticLabel() {
        return "YYYYYYYYYYYYYYYYYYYYYYY";
    }


    @Override public TestElement createTestElement() {
        IDPSampler smpl = new IDPSampler();
        return smpl;
    }

    @Override public void modifyTestElement(TestElement testElement) {

    }

    private void init() {
        this.setLayout(new BorderLayout(0, 5));
        this.setBorder(this.makeBorder());
        this.add(this.makeTitlePanel(), "North");
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(this.createConditionPanel(), "North");
        this.add(mainPanel, "Center");
    }

    private JPanel createConditionPanel() {
        JPanel conditionPanel = new JPanel(new BorderLayout(5, 0));
        JLabel conditionLabel = new JLabel(JMeterUtils.getResString("while_controller_label"));
        conditionPanel.add(conditionLabel, "West");
        this.theCondition = JSyntaxTextArea.getInstance(5, 50);
        this.theCondition.setName("While_Condition");
        conditionLabel.setLabelFor(this.theCondition);
        conditionPanel.add(JTextScrollPane.getInstance(this.theCondition), "Center");
        conditionPanel.add(Box.createHorizontalGlue(), "North");
        return conditionPanel;
    }
}
