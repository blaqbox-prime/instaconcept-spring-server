package com.blaqboxdev.instaconcept.services;

import com.blaqboxdev.instaconcept.models.Storage;

import java.util.List;

public interface IAzureBlobStorage {
    public String write(Storage storage);
    public String update(Storage storage);

    public byte[] read(Storage storage);

    public void delete(Storage storage);

    public List<String> ListFiles(Storage storage);

    public String getResourceUrl(Storage storage);

    public void createContainer(String name);

    public void deleteContainer(String name);
}
