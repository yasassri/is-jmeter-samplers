/*
 * Copyright 2017 Hemika Yasinda Kodikara
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

package org.wso2.qa.tooling.sampler;

import org.apache.jmeter.samplers.AbstractSampler;
import org.apache.jmeter.samplers.Entry;
import org.apache.jmeter.samplers.SampleResult;
import org.apache.jmeter.testelement.TestStateListener;
import org.apache.jorphan.logging.LoggingManager;
import org.apache.log.Logger;
import java.util.Date;

/**
 * This is MQTT Publisher sample class. The implementation includes publishing of MQTT messages with the sample
 * processing.
 */
public class IDPCreationSampler extends AbstractSampler implements TestStateListener {


    private static final String nameLabel = "WSO2IS SP Creator";
    private static final long serialVersionUID = 233L;
    private static final Logger log = LoggingManager.getLoggerForClass();

    private static final String IS_URL = "is.url";
    private static final String SP_NAME = "is.sp.name";
    private static final String SP_DES = "is.sp.des";
    private static final String USERNAME = "is.auth.username";
    private static final String PASSWORD = "is.auth.password";


    // Getters
    public String getSPName() {
        return getPropertyAsString(SP_NAME);
    }

    public String getSPDescription() {
        return getPropertyAsString(SP_DES);
    }

    public String getUsername() {
        return getPropertyAsString(USERNAME);
    }

    public String getPassword() {
        return getPropertyAsString(PASSWORD);
    }



    public String getNameLabel() {
        return nameLabel;
    }

    // Setters
    public void setSPName(String isUrl) {
        setProperty(SP_NAME, isUrl.trim());
    }

    public void setSPDescription(String description) {
        setProperty(SP_DES, description.trim());
    }

    public void setUsername(String username) {
        setProperty(USERNAME, username.trim());
    }

    public void setPassword(String password) {
        setProperty(PASSWORD, password.trim());
    }
    public void serISUrl(String url) {
        setProperty(IS_URL, url.trim());
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public void testEnded() {
        log.debug("Thread ended " + new Date());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void testEnded(String arg0) {
        testEnded();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void testStarted() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void testStarted(String arg0) {
        testStarted();
    }
    
    /**
     * Initializes the MQTT client for publishing.
     *
     * @throws
     */
    private void initClient() throws Exception {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SampleResult sample(Entry entry) {
        SampleResult result = new SampleResult();
        result.setSampleLabel(getNameLabel());
        result.sampleStart();
        return result;
    }
}
