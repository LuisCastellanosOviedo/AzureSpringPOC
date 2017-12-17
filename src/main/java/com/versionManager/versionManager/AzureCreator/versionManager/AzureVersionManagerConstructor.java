package com.versionManager.versionManager.AzureCreator.versionManager;

import com.microsoft.azure.credentials.ApplicationTokenCredentials;
import com.microsoft.azure.management.Azure;
import com.versionManager.versionManager.AzureAuth.AzureAuthManager;
import com.versionManager.versionManager.AzureCreator.versionManager.services.ResourceGroupService;
import com.versionManager.versionManager.AzureAuth.AzureCredentials.AccessCredentials;
import com.versionManager.versionManager.AzureEntities.VMConfiguration;
import com.versionManager.versionManager.AzureInfrastructure.IAzureElementVO;
import com.versionManager.versionManager.AzureInfrastructure.InfrastructureCommand;
import com.versionManager.versionManager.Util.readJson.ReadSetupJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by LuisCO on 30/11/2017.
 */
@Component
public class AzureVersionManagerConstructor {

    @Autowired
    private AccessCredentials accessCredentials;

    @Autowired
    private ResourceGroupService resourceGroupService;

    @Autowired
    @Qualifier("storageAccount")
    private InfrastructureCommand storageAccount;

    @Autowired
    private ReadSetupJson readSetupJson;

    @Autowired
    private AzureAuthManager azureAuthManager;

    public void createVersionmanagerInfrastructure(String url) throws IOException {
        VMConfiguration vmConfiguration = readSetupJson.readJsonWithObjectMapper(url);
        ApplicationTokenCredentials applicationTokenCredentials = accessCredentials.getCredentials(vmConfiguration);
        Azure.Authenticated auth = azureAuthManager.azureAuth(applicationTokenCredentials);
        Map<String,Object> params = new HashMap<>();

        params= resourceGroupService.execute(auth, vmConfiguration,params);
        IAzureElementVO st =storageAccount.createAzureInfrastructure(auth, vmConfiguration,params);


    }


}
