package com.scalebit.worker.zk;

import com.scalebit.worker.WorkerClient;
import org.apache.zookeeper.*;

import java.io.IOException;

public class ZookeeperWorkerClient implements WorkerClient, Watcher {

    private ZooKeeper zk;

    @Override
    public void connect(String host, int port) throws IOException {

        zk = new ZooKeeper(host, port, this);
        try {

            if (zk.exists("/workers", false) == null) {
                zk.create("/workers", new byte[0],
                        ZooDefs.Ids.OPEN_ACL_UNSAFE,
                        CreateMode.PERSISTENT);
            }

            zk.create("/workers/worker-",
                      new byte[0],
                      ZooDefs.Ids.OPEN_ACL_UNSAFE,
                      CreateMode.EPHEMERAL_SEQUENTIAL
                    );
        } catch (KeeperException e) {
            throw new IOException(e);
        } catch (InterruptedException e) {
            throw new IOException(e);
        }


    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        System.out.println("evt: " + watchedEvent);
    }
}
