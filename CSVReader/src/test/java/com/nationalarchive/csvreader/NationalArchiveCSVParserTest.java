package com.nationalarchive.csvreader;

import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.nio.file.NoSuchFileException;

public class NationalArchiveCSVParserTest {

    NationalArchiveCSVParser nationalArchiveCSVParser;

    @Before
    public void setUp() throws Exception {
        nationalArchiveCSVParser = new NationalArchiveCSVParser();
    }

    @Test
    public void fileUpdatedCorrectly() {
        nationalArchiveCSVParser.updateRowValues("src/test/resources/csvFile.csv", "origin", "Londom", "London");
    }
}
