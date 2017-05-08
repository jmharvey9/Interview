package com.jmh.app;

/**
 * Interset Technical Exercise
 * prepared by: Julia Harvey
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ObjectNode;
 
public class App 
{
    public static void main(String[] args) throws IOException 
    {
		
		File inFile = null;
		File outFile = null;
		int linesRead;
		int duplicateEventIdCount;
		int addActions;
		int removeActions;
		int accessedActions;
		int invalidActions;
		int totalDropped;
		int totalActions;
		int uniqueUsers;
		int uniqueFiles;
		string startTime;
		string endTime;
		boolean validAction;
		boolean newUsername;
		boolean newFilename;
		linesRead = 0;
		duplicateEventIdCount = 0;
		addActions = 0;
		removeActions = 0;
		accessedActions = 0;
		invalidActions = 0;
		totalDropped = 0;
		totalActions = 0;
		uniqueUsers = 0;
		uniqueFiles = 0;
		validAction = false;
		newUsername = false;
		newFilename = false;
		
		if (1 < args.length) {
			inFile = new File(args[0]);
			outFile = new File(args[1]);
		} else {
			System.err.println("Invalid arguments count:" + args.length);
			System.exit();
		}
			
		// read json file data to String
		byte[] jsonData = Files.readAllBytes(Paths.get(inFile));
		
		// create ObjectMapper instance
		ObjectMapper objectMapper = new ObjectMapper();
		
		// convert json string to object
		TouchRecord rcd = objectMapper.readValue(jsonData, TouchRecord.class);
		
		
		// parse the file and output to csv
		try 
		{
			// open file for appending
			fileWriter csvOutput = new CsvWriter(new FileWriter(outFile, true), ',');
			
			// if the file didn't already exist then we need to write out the header line
			if (linesRead = 0)
			{
				csvOutput.write("Timestamp");
				csvOutput.write("Action");
				csvOutput.write("User");
				csvOutput.write("Folder");
				csvOutput.write("Filename");
				csvOutput.write("IP");
				csvOutput.endRecord();
			}
			// else assume that the file already has the correct header line
			// write out to file
			for  ()
			{
				linesRead = linesRead+1;
			
				// determine if eventId is a duplicate - not sure how to do this yet - JMH
				if ()
				{	
					// determine action count and validity
					if (rcd.action.equals (createdDoc) || rcd.action.equals (addedText) || rcd.action.equals (changedText))
					{
						addActions = addActions+1;
						validAction = true;
					}
					else if (rcd.action.equals (deletedDoc) || rcd.action.equals (deletedText) || rcd.action.equals (archived))
					{
						removeActions = removeActions+1;
						validAction = true;
					}
					else if (rcd.action.equals (viewDoc))
					{
						accessedActions = accessedActions+1;
						validAction = true;
					}
					else
					{
						invalidActions = invalidActions+1;
						validAction = false;
					}
					
					// output to csv file
					// ****** ran out of time ******
					if (validAction)
					{
						// check for unique User name
						// ****** not sure how to do this/ran out of time ******
						if (newUsername)
						{
							uniqueUsers = uniqueUsers+1;
							newUsername = false;
						}
						// format username it to crop out @*.*
						// ****** not sure how to do this/ran out of time ******
						// check for unique file name 
						// ****** not sure how to do this/ran out of time ******
						if (newFilename)
						{
							uniqueFiles = uniqueFiles+1;
							newFilename = false;
						}
						// split fileanme into folder and file values
						// ****** not sure how to do this/ran out of time ******
						// format time into ISO 8601 compliant string
						// ****** not sure how to do this/ran out of time ******
						// determine earliest start time
						// ****** not sure how to do this/ran out of time ******
						if (timestamp < startTime)
						{
							startTime = timestamp;
						}						
						// determine latest end time
						// ****** not sure how to do this/ran out of time ******
						if (timestamp > endTime)
						{
							endTime = timestamp;
						}
						// write modified values to csv file
						csvOutput.write(timestamp);
						csvOutput.write(action);
						csvOutput.write(user);
						csvOutput.write(folder);
						csvOutput.write(file);
						csvOutput.write(ipAddr);
						csvOutput.endRecord();
					}
				}
				else
				{
					duplicateEventIdCount = duplicateEventIdCount+1;
				}
			}
			
			csvOutput.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}	
				
		// group and printout statistics
		totalDropped = duplicateEventIdCount + invalidActions;
		totalActions = addActions + removeActions + accessedActions;
		
		System.out.println("Number of lines:\n"+linesRead);
		System.out.println("Lines dropped:\n"+totalDropped);
		System.out.println("   Duplicate Event IDs:\n"+duplicateEventIdCount);
		System.out.println("   Invalid Actions:\n"+invalidActions);
		System.out.println("Unique Users:\n"+uniqueUsers);
		System.out.println("Unique Files:\n"+uniqueFiles);
		System.out.println("Start Date:\n"+startTime);
		System.out.println("End Date:\n"+endTime);
		System.out.println("Actions\n");
		System.out.println("   ADD\n"+addActions);
		System.out.println("   REMOVE\n"+removeActions);
		System.out.println("   ACCESSED\n"+accessedActions);
		
		// output to JSON - should be like this example
		// ****** not sure how to do this/ran out of time ******
		// ObjectMapper mapper = new ObjectMapper();
		// System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(metrics));
    }
}	
	
public class TouchRecord {
	private long[] eventId;
	private String user;
	private String ipAddr;
	private String file;
	private String activity;
	private String timestamp;
	private String timeOffset;
	
	public long[] geteventId() {
		return eventId;
	}

	public void seteventId(long[] eventId) {
		this.eventId = eventId;
	}

	public String getuser() {
		return user;
	}
	
	public void setuser(String user) {
		this.user = user;
	}
	
	public String getipAddr() {
		return ipAddr;
	}
	
	public void setipAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}
	
	public String getfile() {
		return file;
	}
	
	public void setfile(String file) {
		this.file = file;
	}
	
	public String getactivity() {
		return activity;
	}

	public void setactivity(String activity) {
		this.activity = activity;
	}

	public String gettimestamp() {
		return timestamp;
	}
	
	public void settimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	
	public String gettimeOffset() {
		return timeOffset;
	}
		
	public void settimeOffset(String timeOffset) {
		this.timeOffset = timeOffset;
	}
}
