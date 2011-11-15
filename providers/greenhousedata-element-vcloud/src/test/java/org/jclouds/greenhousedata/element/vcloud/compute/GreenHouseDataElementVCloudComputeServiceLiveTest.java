/**
 * Licensed to jclouds, Inc. (jclouds) under one or more
 * contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  jclouds licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.jclouds.greenhousedata.element.vcloud.compute;

import org.jclouds.compute.domain.ExecResponse;
import org.jclouds.compute.domain.NodeMetadata;
import org.jclouds.vcloud.compute.VCloudComputeServiceLiveTest;
import org.testng.annotations.Test;

/**
 * 
 * 
 * @author Adrian Cole
 */
@Test(groups = "live", enabled = true, singleThreaded = true, testName = "GreenHouseDataElementVCloudComputeServiceLiveTest")
public class GreenHouseDataElementVCloudComputeServiceLiveTest extends VCloudComputeServiceLiveTest {
   public GreenHouseDataElementVCloudComputeServiceLiveTest() {
      provider = "greenhousedata-element-vcloud";
      // vcloud requires instantiate before deploy, which takes longer than 30 seconds
      nonBlockDurationSeconds = 300;
   }

   @Override
   public void setServiceDefaults() {
      group = "director";
   }

   protected void checkResponseEqualsHostname(ExecResponse execResponse, NodeMetadata node1) {
      // hostname is not predictable based on node metadata
      assert execResponse.getOutput().trim().equals("(none)");
   }
}