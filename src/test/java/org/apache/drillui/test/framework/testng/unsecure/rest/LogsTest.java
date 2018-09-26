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
package org.apache.drillui.test.framework.testng.unsecure.rest;

import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;

public class LogsTest extends BaseRestTest {
  //todo: what if sqlline.log file is not yet created?
  //@Test
  public void checkLogsPage() {
    SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
    given()
        .when()
        .get("/logs.json")
        .then()
        .statusCode(200)
        .body("name", hasItems(
            equalTo("drillbit.log"),
            equalTo("drillbit.out"),
            equalTo("drillbit_queries.json"),
            equalTo("sqlline.log"))
        )
        .body("lastModified", hasItem(containsString(df.format(new Date()))));
  }
}
