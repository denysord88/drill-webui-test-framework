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
package org.apache.drillui.test.framework.steps.webui;

import org.apache.drillui.test.framework.pages.BasePage;
import org.apache.drillui.test.framework.pages.QueryResultsPage;

import java.util.List;

public final class QueryResultsSteps {

  private static QueryResultsPage getPage() {
    return BasePage.getPage(QueryResultsPage.class);
  }

  private QueryResultsSteps() {
  }

  public static int rowsCount() {
    return getPage()
        .getResultsTableBody()
        .size();
  }

  public static int columnsCount() {
    return getPage()
        .getResultsTableHeader()
        .size();
  }

  public static List getRow(int rowId) {
    return getPage()
        .getResultsTableBody()
        .get(rowId);
  }

  public static List<List<String>> getResultsTableBody() {
    return BasePage.getPage(QueryResultsPage.class)
            .getResultsTableBody();
  }

  public static String getQueryProfile() {
    return getPage().getQueryProfile();
  }
}
