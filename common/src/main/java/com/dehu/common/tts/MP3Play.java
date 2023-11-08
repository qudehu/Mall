package com.dehu.common.tts;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/**
 * 播放本地MP3文件
 * @author 管雷鸣
 *
 */
public class MP3Play {
    private Player player;

    /**
     * @param filePath	MP3文件的绝对路径，如 E:/xnx3/test.mp3
     * @throws JavaLayerException
     * @throws FileNotFoundException
     */
    public MP3Play(String filePath) throws JavaLayerException, FileNotFoundException {
        if(Files.exists(Path.of(filePath))){
            BufferedInputStream buffer = new BufferedInputStream(new FileInputStream(filePath));
            player = new Player(buffer);
        }else{
            throw new FileNotFoundException(filePath+" is not exists");
        }
    }

    /**
     * 开始播放
     * @throws JavaLayerException
     */
    public void play() throws JavaLayerException{
        player.play();
    }

    public static void main(String[] args) throws FileNotFoundException, JavaLayerException{
        new MP3Play("D:\\dev\\musicDownloads\\乌梅子酱 - 李荣浩.mp3").play();
    }
}