package com.inedo.buildmaster;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.mockito.AdditionalAnswers.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import hudson.EnvVars;
import hudson.model.BuildListener;
import hudson.model.AbstractBuild;
import hudson.model.AbstractProject;

import com.inedo.buildmaster.api.BuildMasterClientApache;

/**
 * Tests for the TriggerBuildHelper class
 * 
 * @author Andrew Sumner
 */
public class TriggerBuildHelperTest {
	public MockServer mockServer;
	
	@SuppressWarnings("rawtypes")
	public AbstractBuild build;
	@SuppressWarnings("rawtypes")	
	public AbstractProject project;
	//public Launcher launcher;
	public BuildListener listener;
	public EnvVars env;
	public PrintStream logger;
	public ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	public String releaseNumber;
	public String buildNumber;
	
	@Test
	public void perform() throws IOException, InterruptedException {
		TriggerableData data = new TriggerableData(MockServer.APPLICATION_ID, releaseNumber, buildNumber);
	
		restLog();
		assertThat("Result should be successful", TriggerBuildHelper.triggerBuild(build, listener, data), is(true));
		
		String log[] = extractLogLinesRemovingApiCall();
		assertThat("Only one action should be performed", log.length, is(1));
		assertThat("Create Build step should be the last actioned performed.", log[log.length - 1], containsString("Create BuildMaster build with BuildNumber="));
	}

	@Test
	public void performWaitTillCompleted() throws IOException, InterruptedException {
		TriggerableData data = new TriggerableData(MockServer.APPLICATION_ID, releaseNumber, buildNumber)
			.setWaitTillBuildCompleted(true)
			.setPrintLogOnFailure(true);
		
		restLog();
		assertThat("Result should be successful", TriggerBuildHelper.triggerBuild(build, listener, data), is(true));
		
		String log[] = extractLogLines();
		assertThat("Wait step should be the last actioned performed for successful build." , log[log.length - 1], containsString("Execution Status: Succeeded"));
	}
	
	@Test
	public void performSetVariables() throws IOException, InterruptedException {
		TriggerableData data = new TriggerableData(MockServer.APPLICATION_ID, releaseNumber, buildNumber)
			.setSetBuildVariables(true)
			.setVariables("hello=performSetVariables")
			.setPreserveVariables(false);
		
		restLog();
		assertThat("Result should be successful", TriggerBuildHelper.triggerBuild(build, listener, data), is(true));
		
		String log = extractLog();
		assertThat("Variable passed", log, containsString("performSetVariables"));
		assertThat("Variable passed", log, not(containsString("trying")));
		
		data.setPreserveVariables(true);
		data.setVariables("trying=again");
		
		restLog();
		assertThat("Result should be successful", TriggerBuildHelper.triggerBuild(build, listener, data), is(true));
		
		log = extractLog();		
		assertThat("Variable passed", log, containsString("hello"));
		assertThat("Variable passed", log, containsString("trying"));
	}
	
	@Test
	public void performEnableReleaseDeployable() throws IOException, InterruptedException {
		TriggerableData data = new TriggerableData(MockServer.APPLICATION_ID, releaseNumber, buildNumber)
			.setEnableReleaseDeployable(true)
			.setDeployableId("2077");
		
		restLog();
		assertThat("Result should be successful", TriggerBuildHelper.triggerBuild(build, listener, data), is(true));
		
		String log = extractLog();
		assertThat("Has requested updated", log, containsString("Releases_CreateOrUpdateRelease"));
		assertThat("Has passed deployable id", log, containsString("Deployable_Id=\"2077\""));
	}
	
	// Mocking of Server
	private void restLog() {
		logger.flush();
		outContent.reset();
	}
	
	private String extractLog() throws UnsupportedEncodingException {
		return URLDecoder.decode(outContent.toString(), "UTF-8");
	}
	
	private String[] extractLogLines() {
		return outContent.toString().split("[\\r\\n]+");
	}
	
	private String[] extractLogLinesRemovingApiCall() {
		return outContent.toString().split("\\G.*Executing request.*[\\r\\n]|[\\r\\n]+");
	}
	
	@Before
	public void before() throws IOException, InterruptedException {
		mockServer = new MockServer(true);
		TriggerBuildHelper.injectConfiguration(mockServer.getBuildMasterConfig());
		
		build = mock(AbstractBuild.class);;
		//launcher = mock(Launcher.class);
		listener = mock(BuildListener.class);
		env = mock(EnvVars.class);
		project = mock(AbstractProject.class);
		logger = new PrintStream(outContent);
		
		when(build.getProject()).thenReturn(project);
		when(build.getEnvironment(listener)).thenReturn(env);
		when(env.expand(anyString())).then(returnsFirstArg());
		when(listener.getLogger()).thenReturn(logger);
		
		BuildMasterClientApache buildmaster = new BuildMasterClientApache(mockServer.getBuildMasterConfig());
		
		this.releaseNumber = buildmaster.getLatestActiveReleaseNumber(MockServer.APPLICATION_ID);
		this.buildNumber = buildmaster.getNextBuildNumber(MockServer.APPLICATION_ID, releaseNumber);
	}
	
	@After
	public void tearDown() throws Exception {
		mockServer.stop();
	}
}