/*
 * Copyright 2011 Splunk, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"): you may
 * not use this file except in compliance with the License. You may obtain
 * a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package com.splunk.sdk.tests.com.splunk;

import com.splunk.*;
import com.splunk.sdk.Program;
import com.splunk.Service;

import junit.framework.Assert;
import junit.framework.TestCase;
import org.junit.*;

public class OutputDefaultTest extends TestCase {
    Program program = new Program();

    public OutputDefaultTest() {}

    Service connect() {
        return new Service(
            program.host, program.port, program.scheme)
                .login(program.username, program.password);
    }

    @Before public void setUp() {
        this.program.init(); // Pick up .splunkrc settings
    }

    @Test public void testOutputDefault() throws Exception {
        Service service = connect();

        OutputDefault dof = service.getOutputDefault();

        dof.autoLb();
        dof.blockOnCloning();
        dof.blockOnQueueFull();
        dof.getAutoLbFrequency();
        dof.getConnectionTimeout();
        dof.getDefaultGroup();
        dof.getDropClonedEventsOnQueueFull();
        dof.getDropEventsOnQueueFull();
        dof.getForwardedIndex0Whitelist();
        dof.getForwardedIndex1Blacklist();
        dof.getForwardedIndex2Whitelist();
        dof.getHeartbeatFrequency();
        dof.getMaxConnectionsPerIndexer();
        dof.getMaxFailuresPerInterval();
        dof.getMaxQueueSize();
        dof.getReadTimeout();
        dof.getSecsInFailureInterval();
        dof.getWriteTimeout();
        dof.indexAndForward();
        dof.isCompressed();
        dof.isDisabled();
        dof.isForwardedIndexFilterDisable();
        dof.isIndexAndForward();
        dof.sendCookedData();
        dof.useAck();
    }
}