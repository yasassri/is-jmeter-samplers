package org.wso2.qa.tooling.sampler;

import org.apache.jmeter.samplers.AbstractSampler;
import org.apache.jmeter.samplers.Entry;
import org.apache.jmeter.samplers.SampleResult;
import org.apache.jmeter.testelement.TestStateListener;

/**
 * Created by yasassri on 12/16/17.
 */
public class IDPSampler extends AbstractSampler implements TestStateListener {
    @Override public SampleResult sample(Entry entry) {
        SampleResult result = new SampleResult();

        return result;
    }

    @Override public void testStarted() {

    }

    @Override public void testStarted(String s) {

    }

    @Override public void testEnded() {

    }

    @Override public void testEnded(String s) {

    }
}
