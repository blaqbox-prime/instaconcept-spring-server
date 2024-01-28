package com.blaqboxdev.instaconcept.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.InputStream;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Storage {

    private String path;
    private String filename;
    private InputStream inputStream;

}
