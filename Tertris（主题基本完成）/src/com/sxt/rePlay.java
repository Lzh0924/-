package com.sxt;

import java.io.File;

public class rePlay {
    public rePlay() {
        File file3 = new File("音乐合集.mp3");
        BGM bgm = new BGM(file3.getAbsolutePath());
        bgm.start();
        try {
            Thread.sleep(5000);
        }
        catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}

