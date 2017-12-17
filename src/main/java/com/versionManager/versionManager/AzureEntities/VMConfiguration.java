package com.versionManager.versionManager.AzureEntities;

/**
 * Created by LuisCO on 12/12/2017.
 */
public class VMConfiguration {

    private String clientId;
    private String secret;
    private String domain;
    private String subscription;
    private String resourceGroupName;
    private String storageAccountName;
    private String blobStorageContainerName;
    private String Location;

    public VMConfiguration() {
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getSubscription() {
        return subscription;
    }

    public void setSubscription(String subscription) {
        this.subscription = subscription;
    }

    public String getResourceGroupName() {
        return resourceGroupName;
    }

    public void setResourceGroupName(String resourceGroupName) {
        this.resourceGroupName = resourceGroupName;
    }

    public String getStorageAccountName() {
        return storageAccountName;
    }

    public void setStorageAccountName(String storageAccountName) {
        this.storageAccountName = storageAccountName;
    }

    public String getBlobStorageContainerName() {
        return blobStorageContainerName;
    }

    public void setBlobStorageContainerName(String blobStorageContainerName) {
        this.blobStorageContainerName = blobStorageContainerName;
    }

    @Override
    public String toString() {
        return clientId+secret+domain;
    }
}
