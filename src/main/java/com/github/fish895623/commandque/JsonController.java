package com.github.fish895623.commandque;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class JsonController {
  private final Logger logger = LoggerFactory.getLogger(JsonController.class);
  String a;

  JsonController() {
    this.a = "asdf";
  }

  public static void main(String[] args) {
    new JsonController()
            .lockFile("file", "rw");
  }

  public void lockFile(String file, String mode) {
    RandomAccessFile r;
    FileChannel c;

    try {
      r = new RandomAccessFile(file, mode);
      logger.info("RandomAccessFile");
      c = r.getChannel();
      try {
        c.lock();
        logger.info("File Locked");
      } catch (IOException e) {
        logger.error(e.getMessage());
      }
    } catch (FileNotFoundException e) {
      logger.error(e.getMessage());
    }
  }

  // TODO create static class to use this function
  public boolean FileExist(String path) {
    return new File(path)
            .exists();
  }
}
