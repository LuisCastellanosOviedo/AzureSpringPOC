package com.versionManager.versionManager.Util.readJson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.versionManager.versionManager.AzureEntities.VMConfiguration;
import com.versionManager.versionManager.AzureFunctionalAPI.util.FunctionalUtilAPI;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

/**
 * Created by LuisCO on 12/12/2017.
 */

@Component
public class ReadSetupJson {

    public static final String DEFAULT_URL="VersionManagerSetup.json";

    public VMConfiguration readJsonWithObjectMapper(String url) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        VMConfiguration vmConfiguration = objectMapper.readValue(new File(FunctionalUtilAPI.getStringValueOrDefault.apply(url,DEFAULT_URL)), VMConfiguration.class);

        return vmConfiguration;
    }
}
