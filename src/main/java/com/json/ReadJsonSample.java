package com.json;

import java.io.File;

public class ReadJsonSample {
    public static void main(String[] args) {
        File file = new File(ReadJsonSample.class.getResource("/wangxiaoer.json").getFile());
    }
}
