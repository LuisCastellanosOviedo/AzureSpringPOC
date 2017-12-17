package com.versionManager.versionManager.AzureAuth.AzureCredentials;


import com.microsoft.azure.AzureEnvironment;
import com.microsoft.azure.credentials.ApplicationTokenCredentials;
import com.versionManager.versionManager.AzureAuth.AzureCredentials.AccessCredentials;
import com.versionManager.versionManager.AzureEntities.VMConfiguration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


/**
 * Created by LuisCO on 28/11/2017.
 */

@Component
@Primary
public class AzureCredentialByToken implements AccessCredentials {


    @Override
    public ApplicationTokenCredentials getCredentials(VMConfiguration vmConfiguration) {
            return  new ApplicationTokenCredentials(
                    vmConfiguration.getClientId(),
                    vmConfiguration.getDomain(),
                    vmConfiguration.getSecret(),
                    AzureEnvironment.AZURE);
    }
}
