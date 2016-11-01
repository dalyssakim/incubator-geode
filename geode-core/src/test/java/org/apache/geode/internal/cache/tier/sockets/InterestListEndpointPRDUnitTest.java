/*
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license
 * agreements. See the NOTICE file distributed with this work for additional information regarding
 * copyright ownership. The ASF licenses this file to You under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License. You may obtain a
 * copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package org.apache.geode.internal.cache.tier.sockets;

import org.junit.experimental.categories.Category;
import org.junit.Test;

import static org.junit.Assert.*;

import org.apache.geode.test.dunit.cache.internal.JUnit4CacheTestCase;
import org.apache.geode.test.dunit.internal.JUnit4DistributedTestCase;
import org.apache.geode.test.junit.categories.DistributedTest;

import org.apache.geode.cache.*;

/**
 * subclass of InterestListEndpointDUnitTest to exercise partitioned regions
 *
 */
@Category(DistributedTest.class)
public class InterestListEndpointPRDUnitTest extends InterestListEndpointDUnitTest {

  public InterestListEndpointPRDUnitTest() {
    super();
  }

  public static void createImpl() {
    impl = new InterestListEndpointPRDUnitTest();
  }

  protected RegionAttributes createServerCacheAttributes() {
    AttributesFactory factory = new AttributesFactory();
    factory.setDataPolicy(DataPolicy.PARTITION);
    factory.setPartitionAttributes((new PartitionAttributesFactory()).create());
    return factory.create();
  }
}