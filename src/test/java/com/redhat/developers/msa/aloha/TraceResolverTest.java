/*
 * Copyright 2016 Juraci Paixão Kröhling
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.redhat.developers.msa.aloha;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.redhat.developers.msa.aloha.tracing.TracerResolver;

/**
 * @author Juraci Paixão Kröhling
 */
public class TraceResolverTest {

    @Test
    public void loadClassFromSystemProperty() {
        System.setProperty("tracer.class", "org.hawkular.apm.client.opentracing.APMTracer");
        assertNotNull(TracerResolver.getTracer());
        System.setProperty("tracer.class", "");
    }

    @Test
    public void cached() {
        System.setProperty("tracer.class", "org.hawkular.apm.client.opentracing.APMTracer");
        assertNotNull(TracerResolver.getTracer());
        assertNotNull(TracerResolver.getTracer());
        System.setProperty("tracer.class", "");
    }

    @Test
    public void serviceLoader() {
        assertNotNull(TracerResolver.getTracer());
    }
}
