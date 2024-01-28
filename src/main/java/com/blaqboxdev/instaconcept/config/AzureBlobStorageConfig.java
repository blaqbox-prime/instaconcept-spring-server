package com.blaqboxdev.instaconcept.config;

import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AzureBlobStorageConfig {

    @Value("${azure.storage.container.name}")
    private String containerName;

    @Value("${azure.storage.container.connection.string}")
    private String connectionString;

    @Bean
    public BlobServiceClient getBlobServiceClient(){
        BlobServiceClient blobServiceClient = new BlobServiceClientBuilder()
                .connectionString(connectionString).buildClient();
        return blobServiceClient;
    }

    @Bean
    public BlobContainerClient getBlobContainerClient(){
        return getBlobServiceClient()
                .getBlobContainerClient(containerName);
    }
}
