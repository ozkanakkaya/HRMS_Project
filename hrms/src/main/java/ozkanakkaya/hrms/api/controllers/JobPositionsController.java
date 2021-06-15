package ozkanakkaya.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ozkanakkaya.hrms.business.abstracts.JobPositionService;
import ozkanakkaya.hrms.core.utilities.results.DataResult;
import ozkanakkaya.hrms.core.utilities.results.Result;
import ozkanakkaya.hrms.entities.concretes.JobPosition;

@RestController
@RequestMapping("/api/jobpositions")
public class JobPositionsController {

	private JobPositionService jobPositonService;
	
	@Autowired
	public JobPositionsController(JobPositionService jobPositonService) {
		super();
		this.jobPositonService = jobPositonService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobPosition>> getAll(){
		return this.jobPositonService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobPosition jobPosition) {
		return this.jobPositonService.add(jobPosition);
	}
	
}
