/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.eventmesh.connector.knative.config;

import org.apache.eventmesh.api.factory.ConnectorPluginFactory;
import org.apache.eventmesh.connector.knative.consumer.KnativeConsumerImpl;
import org.apache.eventmesh.connector.knative.producer.KnativeProducerImpl;

import org.junit.Assert;
import org.junit.Test;

public class ClientConfigurationTest {

    @Test
    public void getConfigWhenKnativeConsumerInit() {
        KnativeConsumerImpl consumer =
            (KnativeConsumerImpl) ConnectorPluginFactory.getMeshMQPushConsumer("knative");

        ClientConfiguration config = consumer.getClientConfiguration();
        assertConfig(config);
    }

    @Test
    public void getConfigWhenKnativeProducerInit() {
        KnativeProducerImpl producer =
            (KnativeProducerImpl) ConnectorPluginFactory.getMeshMQProducer("knative");

        ClientConfiguration config = producer.getClientConfiguration();
        assertConfig(config);
    }

    private void assertConfig(ClientConfiguration config) {
        Assert.assertEquals(config.getEmurl(), "127.0.0.1");
        Assert.assertEquals(config.getServiceAddr(), "cloudevents-player.default.127.0.0.1.sslip.io");
    }
}
