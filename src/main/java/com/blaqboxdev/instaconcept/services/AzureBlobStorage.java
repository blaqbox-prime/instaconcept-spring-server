package com.blaqboxdev.instaconcept.services;

import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceClient;
import com.blaqboxdev.instaconcept.models.Storage;
import com.ctc.wstx.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AzureBlobStorage implements IAzureBlobStorage {

    @Autowired
    BlobServiceClient blobServiceClient;

    @Autowired
    BlobContainerClient blobContainerClient;

    @Override
    public String write(Storage storage) {
        return null;
    }

    @Override
    public String update(Storage storage) {
        return null;
    }

    @Override
    public byte[] read(Storage storage) {
        return new byte[0];
    }

    @Override
    public void delete(Storage storage) {
        String path = null;
        try {
            path = getPath(storage);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        BlobClient client = blobContainerClient.getBlobClient(path);
        client.delete();
        log.info("Blob is deleted Successfully");
    }

    @Override
    public List<String> ListFiles(Storage storage) {
        return blobContainerClient.listBlobsByHierarchy(storage.getPath()+"/")
                .stream()
                .map(blobItem -> blobItem.getName())
                .toList();
    }

    @Override
    public String getResourceUrl(Storage storage) {
        return null;
    }

    @Override
    public void createContainer(String name) {
        blobServiceClient.createBlobContainer(name);
        log.info("Container Created ✔️");
    }

    @Override
    public void deleteContainer(String name) {
        blobServiceClient.deleteBlobContainer(name);
        log.info("Container Deleted 🚮");
    }

    private String getPath(Storage storage) throws Exception {
        if (StringUtils.isNotBlank(storage.getPath()) && StringUtils.isNotBlank(storage.getFilename())){
            return storage.getPath();
        } else {
            throw new Exception("This is an invalid blob item");
        }
    }
}
