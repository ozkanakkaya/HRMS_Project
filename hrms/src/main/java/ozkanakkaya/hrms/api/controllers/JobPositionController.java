package ozkanakkaya.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ozkanakkaya.hrms.business.abstracts.JobPositionService;
import ozkanakkaya.hrms.entities.concretes.JobPosition;

@RestController
@RequestMapping("/api/jobpositions")
public class JobPositionController {

	private JobPositionService jobPositonService;
	
	@Autowired
	public JobPositionController(JobPositionService jobPositonService) {
		super();
		this.jobPositonService = jobPositonService;
	}
	
	@GetMapping("/getall")
	public List<JobPosition> getAll(){
		return this.jobPositonService.getAll();
	}
	
}
