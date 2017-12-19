/*
 * Copyright 2016 Hemika Yasinda Kodikara
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.qa.tooling.client;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;

/**
 * ClientPool holds the client instances in an ArrayList. The main purpose of
 * this is to make it easier to clean up all the instances at the end of a test.
 * If we didn't do this, threads might become zombie.
 * <p/>
 * N.B. This class needs to be fully synchronized as it is called from sample threads
 * and the thread that runs testEnded() methods.
 */
public class ClientPool {

    private static final ArrayList<Closeable> clients = new ArrayList<Closeable>();

    /**
     * Add a ReceiveClient to the ClientPool. This is so that we can make sure
     * to close all clients and make sure all threads are destroyed.
     *
     * @param client the ReceiveClient to add
     */
    public static synchronized void addClient(Closeable client) {
        clients.add(client);
    }

    /**
     * Clear all the clients created by either Publish or Subscribe sampler. We
     * need to do this to make sure all the threads created during the test are
     * destroyed and cleaned up.
     */
    public static synchronized void clearClient() throws IOException {
        for (Closeable client : clients) {
            client.close();
        }
        clients.clear();
    }
}
