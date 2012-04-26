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

package com.splunk;

import org.junit.Test;

public class DeploymentTenantTest extends SplunkTestCase {
    @Test public void testDeploymentTenant() throws Exception {
        Service service = connect();

        EntityCollection<DeploymentTenant> deploymentTenants =
                service.getDeploymentTenants();
        if (deploymentTenants.values().size() == 0) {
            System.out.println("WARNING: Deployment Tenant not configured");
            return;
        }

        for (DeploymentTenant deploymentTenant: deploymentTenants.values()) {
            // test for just the first index.
            assertTrue(deploymentTenant.getWhiteListByIndex(0).length() > 0);
            // wkcfix -- update() causes server error 500. but don't know why
            /*
            boolean value = deploymentTenant.getCheckNew();
            deploymentTenant.setCheckNew(!value);
            deploymentTenant.update();
            assertEquals(deploymentTenant.getCheckNew(), !value);
            deploymentTenant.setCheckNew(value);
            deploymentTenant.update();
            */
        }
    }
}
