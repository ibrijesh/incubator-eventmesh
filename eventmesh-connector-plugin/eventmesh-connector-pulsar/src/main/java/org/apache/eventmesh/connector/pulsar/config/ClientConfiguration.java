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

package org.apache.eventmesh.connector.pulsar.config;

import org.apache.eventmesh.common.config.Config;
import org.apache.eventmesh.common.config.ConfigFiled;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Config(prefix = "eventMesh.server.pulsar", path = "classPath://pulsar-client.properties")
public class ClientConfiguration {

    @ConfigFiled(field = "service")
    private String serviceAddr;

    @ConfigFiled(field = "authPlugin")
    private String authPlugin;

    @ConfigFiled(field = "authParams")
    private String authParams;

    /*
    *   the full format of topic needs a prefix, but the prefix cannot be passed in the url when the topic is carried
    *
    * */
    @ConfigFiled(field = "topicPrefix")
    private String topicPrefix;
}