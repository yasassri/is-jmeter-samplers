/*
 * Copyright 2016 Hemika Yasinda Kodikara
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.qa.tooling.gui;

import org.apache.jmeter.gui.util.VerticalPanel;
import org.wso2.qa.tooling.sampler.IDPCreationSampler;
import org.apache.jmeter.samplers.gui.AbstractSamplerGui;
import org.apache.jmeter.testelement.TestElement;
import org.apache.jorphan.gui.JLabeledPasswordField;
import org.apache.jorphan.gui.JLabeledTextField;
import org.apache.jorphan.logging.LoggingManager;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class IDPCreatorGui extends AbstractSamplerGui implements ChangeListener, ActionListener {

    private static final long serialVersionUID = 240L;
    private static final org.apache.log.Logger log = LoggingManager.getLoggerForClass();


    private final JLabeledTextField spName = new JLabeledTextField("Service Provider Name:");

    private final JLabeledTextField description = new JLabeledTextField("Description");
    private final JLabeledTextField isUrl = new JLabeledTextField("IS URL ");
    private final JLabeledTextField isUser = new JLabeledTextField("UserName ");
    private final JLabeledTextField isPswd = new JLabeledPasswordField("Password ");
    private final JButton resetUserNameAndPassword = new JButton("Reset Credentials");



    public IDPCreatorGui() {
        init();
    }

    @Override
    public String getLabelResource() {
        return this.getClass().getSimpleName();
    }

    @Override
    public String getStaticLabel() {
        return "WSO2IS SP Creator";
    }


    @Override
    public TestElement createTestElement() {
        IDPCreationSampler sampler = new IDPCreationSampler();
        modifyTestElement(sampler);
        return sampler;
    }

    /**
     * Modifies a given TestElement to mirror the data in the gui components.
     *
     * @see org.apache.jmeter.gui.JMeterGUIComponent#modifyTestElement(TestElement)
     */
    @Override
    public void modifyTestElement(TestElement s) {
        IDPCreationSampler sampler = (IDPCreationSampler) s;
        this.configureTestElement(sampler);
        sampler.setSPName(spName.getText());
        sampler.setSPName(description.getText());
        sampler.serISUrl(isUrl.getText());
        sampler.setUsername(isUser.getText());
        sampler.setPassword(isPswd.getText());
    }

    /**
     * Initializes all the UI elements
     */
    private void init() {
        setLayout(new BorderLayout());
        setBorder(makeBorder());
        add(makeTitlePanel(), BorderLayout.NORTH);
        JPanel mainPanel = new VerticalPanel();
        add(mainPanel, BorderLayout.CENTER);

        JPanel isInfoPanel = new JPanel();
        isInfoPanel.add(spName);
        isInfoPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.gray),
                "IS Info "));
        isInfoPanel.add(createISUrl());
        isInfoPanel.add(createAuthPane());

        JPanel DPanel = new JPanel();
        DPanel.setLayout(new BoxLayout(DPanel, BoxLayout.X_AXIS));
        DPanel.add(spName);
        JPanel ControlPanel = new VerticalPanel();
        ControlPanel.add(DPanel);
        ControlPanel.add(createDestinationPane());

        ControlPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.gray),
                "SP Information"));
        mainPanel.add(isInfoPanel);
        mainPanel.add(ControlPanel);
        JPanel TPanel = new VerticalPanel();
        TPanel.setLayout(new BoxLayout(TPanel, BoxLayout.X_AXIS));
        mainPanel.add(TPanel);

        // Setting default values and handlers
        resetUserNameAndPassword.setActionCommand("reset_credentials");
        resetUserNameAndPassword.addActionListener(this);

    }

    private Component createAuthPane() {
        isUser.setText("admin");
        isPswd.setText("admin");
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.add(Box.createHorizontalStrut(10));
        panel.add(isUser);
        panel.add(Box.createHorizontalStrut(10));
        panel.add(isPswd);
        panel.add(Box.createHorizontalStrut(10));
        panel.add(resetUserNameAndPassword);
        return panel;
    }

    @Override
    public void configure(TestElement el) {
        super.configure(el);
        IDPCreationSampler sampler = (IDPCreationSampler) el;
        spName.setText(sampler.getSPName());
        description.setText(sampler.getSPName());
        isUser.setText(sampler.getUsername());
        isPswd.setText(sampler.getPassword());

    }

    @Override
    public void clearGui() {
        super.clearGui();
    }


    private JPanel createDestinationPane() {
        JPanel panel = new VerticalPanel(); //new BorderLayout(3, 0)
        this.description.setLayout((new BoxLayout(description, BoxLayout.X_AXIS)));
        panel.add(description);
        JPanel TPanel = new JPanel();
        TPanel.setLayout(new BoxLayout(TPanel, BoxLayout.X_AXIS));
        TPanel.add(Box.createHorizontalStrut(100));
        panel.add(TPanel);
        return panel;
    }

    private JPanel createISUrl() {
        isUrl.setText("https://localhost:9443");
        JPanel panel = new VerticalPanel(); //new BorderLayout(3, 0)
        this.isUrl.setLayout((new BoxLayout(isUrl, BoxLayout.X_AXIS)));
        panel.add(isUrl);
        JPanel TPanel = new JPanel();
        TPanel.setLayout(new BoxLayout(TPanel, BoxLayout.X_AXIS));
        TPanel.add(Box.createHorizontalStrut(100));
        panel.add(TPanel);
        return panel;
    }

    @Override
    public void stateChanged(ChangeEvent e) {

    }

    @Override public void actionPerformed(ActionEvent e) {

    }
}
