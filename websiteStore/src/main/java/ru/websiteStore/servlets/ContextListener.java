package ru.websiteStore.servlets;


import ru.websiteStore.dao.UserDAO;
import ru.websiteStore.model.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import static ru.websiteStore.model.User.ROLE.ADMIN;
import static ru.websiteStore.model.User.ROLE.MANAGER;
import static ru.websiteStore.model.User.ROLE.USER;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@WebListener
public class ContextListener implements ServletContextListener {

    private AtomicReference<UserDAO> dao;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent)  {

        dao = new AtomicReference<>(new UserDAO());

        dao.get().add(new User(1, "admin", "1", ADMIN));
        dao.get().add(new User(2, "user", "1", USER));
        dao.get().add(new User(3, "aa", "1", MANAGER));

        final ServletContext servletContext =
                servletContextEvent.getServletContext();

        servletContext.setAttribute("dao", dao);
        
   	 	List<String[]> romagueraList = null;
   	    List<String[]> dataList = null;
        
   	 	try {
    	 
    	 InputStream initialStream = servletContext.getResourceAsStream("/WEB-INF/users.json");
    	 
    	 Reader targetReader = new InputStreamReader(initialStream);
    	 JSONParser parser =new JSONParser();
    	 
    	 JSONArray jsonArray = (JSONArray) parser.parse(targetReader);
    	 targetReader.close();
    	 initialStream.close();
    	 
    	 romagueraList = new ArrayList<String[]>(jsonArray.size());
    	 dataList  = new ArrayList<String[]>(jsonArray.size());
    	 
    	 String[] dataArray=null;
    	
    	 for(int i=0;i < jsonArray.size();i++) {
    		 dataArray= new String[3];
    		 dataArray[0]=((JSONObject)jsonArray.get(i)).get("name").toString();
    		 dataArray[1]=((JSONObject)jsonArray.get(i)).get("username").toString();
    		 dataArray[2]=((JSONObject)jsonArray.get(i)).get("email").toString();
    		 
    		 dataList.add(dataArray);
    		 
    		 if(((JSONObject)jsonArray.get(i)).get("company").toString().contains("Romaguera"))
    			 romagueraList.add(dataArray);
    	 }
    	 
     } catch (IOException | ParseException e) {
			e.printStackTrace();
	 }
     
   	 servletContext.setAttribute("dataList", dataList);
   	 servletContext.setAttribute("romagueraList", romagueraList);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        dao = null;
    }
}