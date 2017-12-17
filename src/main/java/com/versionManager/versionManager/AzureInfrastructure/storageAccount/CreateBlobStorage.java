package com.versionManager.versionManager.AzureInfrastructure.storageAccount;

import com.microsoft.azure.credentials.ApplicationTokenCredentials;
import com.microsoft.azure.management.Azure;
import com.microsoft.azure.management.appservice.OperatingSystem;
import com.microsoft.azure.management.resources.fluentcore.arm.Region;
import com.microsoft.azure.management.storage.StorageAccount;
import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.blob.CloudBlobClient;
import com.microsoft.azure.storage.blob.CloudBlobContainer;
import com.versionManager.versionManager.AzureEntities.VMConfiguration;
import com.versionManager.versionManager.AzureFunctionalAPI.util.FunctionalUtilAPI;
import com.versionManager.versionManager.AzureInfrastructure.IAzureElementVO;
import com.versionManager.versionManager.AzureInfrastructure.InfrastructureCommand;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.util.Map;

/**
 * Created by LuisCO on 30/11/2017.
 */

@Component
@Qualifier("storageAccount")
public class CreateBlobStorage implements InfrastructureCommand {

    @Override
    public IAzureElementVO createAzureInfrastructure(Azure.Authenticated auth, VMConfiguration vmConfiguration, Map<String,Object> params) {
        StorageAccount storageAccountCreated = createStorageAccount(vmConfiguration, auth);
        createBlobStorage(vmConfiguration, getConnectionString(storageAccountCreated, vmConfiguration));

        return new StorageAccountVO(storageAccountCreated);
    }

    private StorageAccount createStorageAccount(VMConfiguration vmConfiguration, Azure.Authenticated azureAuth) {


        return azureAuth.withSubscription(vmConfiguration.getSubscription())
                .storageAccounts().define(vmConfiguration.getStorageAccountName())
                .withRegion(Region.US_EAST)
                .withNewResourceGroup(vmConfiguration.getResourceGroupName())
                .create();
    }

    private void createBlobStorage(VMConfiguration vmConfiguration, String storageConnectionString) {
        try {
            CloudStorageAccount storageAccount = CloudStorageAccount.parse(storageConnectionString);
            CloudBlobClient blobClient = storageAccount.createCloudBlobClient();
            CloudBlobContainer container = blobClient.getContainerReference(vmConfiguration.getBlobStorageContainerName());
            container.createIfNotExists();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (StorageException e) {
            e.printStackTrace();
        }
    }

    private String getConnectionString(StorageAccount storageAccountCreated,VMConfiguration vmConfiguration) {
        return "DefaultEndpointsProtocol=http;" +
                "AccountName="+FunctionalUtilAPI.addSemicolonAtTheEnd.apply(vmConfiguration.getStorageAccountName()) +
                "AccountKey=" + FunctionalUtilAPI.getFirstAccessKey.apply(storageAccountCreated.getKeys());
    }



}
