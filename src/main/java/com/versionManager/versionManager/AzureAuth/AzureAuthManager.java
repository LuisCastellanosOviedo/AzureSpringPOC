package com.versionManager.versionManager.AzureAuth;

import com.microsoft.azure.credentials.ApplicationTokenCredentials;
import com.microsoft.azure.management.Azure;
import org.springframework.stereotype.Component;

/**
 * Created by LuisCO on 13/12/2017.
 */
@Component
public class AzureAuthManager {

    public  Azure.Authenticated azureAuth(ApplicationTokenCredentials credentials) {
        return Azure.authenticate(credentials);
    }
}
