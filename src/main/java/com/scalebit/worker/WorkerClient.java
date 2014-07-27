package com.scalebit.worker;

import java.io.IOException;

public interface WorkerClient {

    void connect(String host, int port) throws IOException;

}
