package com.scalebit.worker.testcli;

import com.scalebit.worker.WorkerClient;
import com.scalebit.worker.zk.ZookeeperWorkerClient;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainClass {

    public static void main(String[] args) throws IOException {

        WorkerClient client = new ZookeeperWorkerClient();
        client.connect("localhost", 2181);

        System.out.println("connected");

        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        r.readLine();

    }
}
