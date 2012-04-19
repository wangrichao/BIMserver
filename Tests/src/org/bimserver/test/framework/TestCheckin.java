package org.bimserver.test.framework;

import java.io.File;

import org.bimserver.test.framework.RandomBimServerClientFactory.Type;
import org.bimserver.test.framework.actions.AllActionsFactory;

public class TestCheckin {
	public static void main(String[] args) {
		TestConfiguration testConfiguration = new TestConfiguration();
		TestFramework testFramework = new TestFramework(testConfiguration);

		testConfiguration.setHomeDir(new File("C:\\Testing"));
//		testConfiguration.setActionFactory(new FixedActionFactory(new CreateProjectAction(testFramework), new CheckinAction(testFramework, new CheckinSettings())));
		testConfiguration.setActionFactory(new AllActionsFactory(testFramework));
		testConfiguration.setBimServerClientFactory(new RandomBimServerClientFactory(testFramework, Type.values()));
		testConfiguration.setTestFileProvider(new FolderWalker(new File("C:\\Users\\Ruben de Laat\\Dropbox\\Logic Labs\\Clients\\TNO\\ifc selected")));
//		testConfiguration.setTestFileProvider(new FolderWalker(new File("C:\\Users\\Ruben de Laat\\Documents\\My Dropbox\\Logic Labs\\Clients\\TNO\\ifc selected")));
		testConfiguration.setOutputFolder(new File("output"));
		testConfiguration.setNrVirtualUsers(4);
		
		testFramework.start();
	}
}