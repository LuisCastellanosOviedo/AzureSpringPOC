package com.versionManager.versionManager.Util.readJson;

import com.versionManager.versionManager.AzureEntities.VMConfiguration;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by LuisCO on 12/12/2017.
 */
public class ReadSetupJsonTest {

    private ReadSetupJson readSetupJson;

    @Before
    public void setUp(){
        readSetupJson = new ReadSetupJson();
    }

    @Test
    public void testReadjsonWithEmptyURL(){
        try {
            VMConfiguration vmConfiguration = readSetupJson.readJsonWithObjectMapper("");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testReadjsonWithURL(){
        try {
            VMConfiguration vmConfiguration = readSetupJson.readJsonWithObjectMapper("VersionManagerSetup.json");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
