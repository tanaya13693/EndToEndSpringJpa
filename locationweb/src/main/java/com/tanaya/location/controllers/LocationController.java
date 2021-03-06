package com.tanaya.location.controllers;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tanaya.location.entities.Location;
import com.tanaya.location.repos.LocationRepository;
import com.tanaya.location.service.LocationService;
import com.tanaya.location.util.EmailUtil;
import com.tanaya.location.util.ReportUtil;

@Controller
public class LocationController {

	@Autowired
	LocationService service;
	
	@Autowired
	EmailUtil emailUtil;
	
	@Autowired
	LocationRepository repository;
	
	@Autowired
	ReportUtil reportUtil;
	
	@Autowired
	ServletContext sc;
	
	@RequestMapping("/showCreate")
	public String showCreate(){
		return "createLocation";
		
	}
	
	@RequestMapping("/saveLoc")
	public String saveLocation(@ModelAttribute("location") Location location, ModelMap modelMapd){
		Location locationSaved = service.saveLocation(location);
		String msg = "Location saved with id:" + locationSaved.getId();
		modelMapd.addAttribute("msg", msg);
		//emailUtil.sendEmail("tanaya13693@gmail.com", "Locationsaved", "Locationsaved");
		return "createLocation";
		
	}
	
	@RequestMapping("/displayLocations")
	public String displayLocations(ModelMap modelMap){
		List<Location> locations = service.getAllLocations();
		modelMap.addAttribute("locations", locations);
		return "displayLocations";
	}
	
	@RequestMapping("deleteLocation")
	public String deleteLocation(@RequestParam("id") int id, ModelMap modelMap){
		Location location = service.getLocationById(id);
		service.deleteLocation(location);
		List<Location> locations = service.getAllLocations();
		modelMap.addAttribute("locations", locations);
		return "displayLocations";		
	}
	
	@RequestMapping("/updateLoc")
	public String updateLocation(@ModelAttribute("location") Location location, ModelMap modelMap){
		Location locationUpdated = service.updateLocation(location);
		List<Location> locations = service.getAllLocations();
		modelMap.addAttribute("locations", locations);
		return "displayLocations";
	}
	
	@RequestMapping("/showUpdate")
	public String showUpdate(@RequestParam("id") int id, ModelMap modelMap){
		Location location = service.getLocationById(id);
		modelMap.addAttribute("location", location);
		return "updateLocation";		
	}
	
	@RequestMapping("/generateReport")
	public String generateReport(){
		
		String path = sc.getRealPath("/");
		List<Object[]> data = repository.findTypeAndTypeCount();
		reportUtil.generatePieChart(path, data);
		return "report";		
	}
	
		
}
