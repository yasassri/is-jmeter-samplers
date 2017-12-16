package org.wso2.qa.tooling.gui;

import org.apache.jmeter.samplers.gui.AbstractSamplerGui;
import org.apache.jmeter.testelement.TestElement;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Created by yasassri on 12/16/17.
 */
public class IDPSamplerGui extends AbstractSamplerGui implements ChangeListener, ActionListener {
    @Override public void actionPerformed(ActionEvent e) {

    }

    @Override public void stateChanged(ChangeEvent e) {

    }

    @Override public String getLabelResource() {
        return null;
    }

    @Override public TestElement createTestElement() {
        return null;
    }

    @Override public void modifyTestElement(TestElement testElement) {

    }
}
