package com.flydean.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;

/**
 * @author wayne
 * @version FilePermission,  2020/8/14
 */
public class FilePermission {

    public void createFileWithPermission() throws IOException {
        Set<PosixFilePermission> perms =
                PosixFilePermissions.fromString("rw-------");
        FileAttribute<Set<PosixFilePermission>> attr =
                PosixFilePermissions.asFileAttribute(perms);
        Path file = new File("/tmp/www.flydean.com").toPath();
        Files.createFile(file,attr);
    }
}
