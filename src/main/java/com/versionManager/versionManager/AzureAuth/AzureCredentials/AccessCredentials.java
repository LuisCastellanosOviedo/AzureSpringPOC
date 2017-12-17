package com.versionManager.versionManager.AzureAuth.AzureCredentials;

import com.microsoft.azure.credentials.ApplicationTokenCredentials;
import com.versionManager.versionManager.AzureEntities.VMConfiguration;
import org.springframework.stereotype.Component;

/**
 * Created by LuisCO on 30/11/2017.
 */
@Component
public interface AccessCredentials {

    ApplicationTokenCredentials getCredentials(VMConfiguration vmConfiguration);
}
