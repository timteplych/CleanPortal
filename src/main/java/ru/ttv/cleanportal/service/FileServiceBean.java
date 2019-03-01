package ru.ttv.cleanportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.ttv.cleanportal.api.ConfigService;
import ru.ttv.cleanportal.api.FileService;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * @author Timofey Teplykh
 */
@Component
public class FileServiceBean implements FileService {

    private final ConfigService configService;

    @Autowired
    public FileServiceBean(ConfigService configService) {
        this.configService = configService;
    }


    @Override
    public void findAndProcess() {
        FileVisitor<Path> fileVisitor = new SimpleFileVisitor<Path>(){
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                processFile(file);
                return FileVisitResult.CONTINUE;
            }
        };

        FileSystem fileSystem = FileSystems.getDefault();
        Path directory = fileSystem.getPath(configService.getTargetDir());
        try {
            Files.walkFileTree(directory, fileVisitor);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void processFile(Path file) throws IOException {
        Long fileLastModifiedTime = Files.getLastModifiedTime(file).toMillis();
        Long currentTime = System.currentTimeMillis();
        Long dayInMillis = 1000*60*60*24L;//In days
        if(fileLastModifiedTime < currentTime-dayInMillis*configService.getFileAgeInDays()){
            Files.move(file, getNewPath(file));
        }
        System.out.println();
    }

    @Override
    public Path getNewPath(Path sourcePath) {
        String fileName = sourcePath.toString();
        fileName = fileName.replace(configService.getTargetDir()+"\\","");
        fileName = fileName.replaceAll("\\\\","_");
        return FileSystems.getDefault().getPath(configService.getServiceDir()+"\\"+fileName);
    }
}
