package com.sxt;

import java.io.File;

public class rePlay {
    public rePlay() {
        File file3 = new File("ι³δΉει.mp3");
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

