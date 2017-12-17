package com.versionManager.versionManager;

import com.versionManager.versionManager.AzureCreator.versionManager.AzureVersionManagerConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VersionManagerApplication implements CommandLineRunner {

	@Autowired
	private AzureVersionManagerConstructor azureConstructor;

	public static void main(String[] args) {
		SpringApplication.run(VersionManagerApplication.class, args);
	}


	@Override
	public void run(String... strings) throws Exception {
		System.out.print("*************** STARTING  INFRASTRUCTURE CREATION PROCESS *****************");
		azureConstructor.createVersionmanagerInfrastructure("");
		System.out.print("*************** INFRASTRUCTURE IS READY TO USE *****************");
	}
}
