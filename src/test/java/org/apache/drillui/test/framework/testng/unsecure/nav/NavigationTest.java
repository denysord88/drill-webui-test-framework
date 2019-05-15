/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to you under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.drillui.test.framework.testng.unsecure.nav;

import org.apache.drillui.test.framework.steps.webui.BaseSteps;
import org.apache.drillui.test.framework.steps.webui.NavigationSteps;
import static org.testng.Assert.assertEquals;
import org.apache.drillui.test.framework.testng.unsecure.BaseUnsecureTest;
import org.testng.annotations.Test;

public class NavigationTest extends BaseUnsecureTest {

  @Test(groups = {"functional"})
  public void testNav() {
    NavigationSteps.navigateQuery();
    assertEquals(BaseSteps.getURL(), "/query");
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    NavigationSteps.navigateStorage();
    assertEquals(BaseSteps.getURL(), "/storage");
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  @Test(groups = {"functional"})
  public void testNavFail() {
    NavigationSteps.navigateQuery();
    assertEquals(BaseSteps.getURL(), "/query");
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    NavigationSteps.navigateStorage();
    assertEquals(BaseSteps.getURL(), "/storage123");
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

}

