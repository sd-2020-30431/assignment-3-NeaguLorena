package com.assignment3.wasteless.Presentation.Controller;

import com.assignment3.wasteless.Bussiness.Service.Query.ReminderQueryService;
import com.assignment3.wasteless.Bussiness.Service.UserService;
import com.assignment3.wasteless.Data.Repository.GoalRepository;
import com.assignment3.wasteless.Presentation.Model.Goal;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin("*")
public class GoalController {

    private final GoalRepository goalRepository;
    private final ReminderQueryService reminderQueryService;

    public GoalController(GoalRepository goalRepository, ReminderQueryService reminderQueryService) {
        this.goalRepository = goalRepository;
        this.reminderQueryService = reminderQueryService;
    }

    @PostMapping("/goal")
    public Goal createGoal(@RequestBody Goal goal ) {
        goal.setUsername(UserService.getLoggedUser().getUsername());
        goal.setDay(new Date());
        return goalRepository.save(goal);
    }

    @GetMapping("/goal")
    public List<Goal> getAllGoals(){
        List<Goal> goals = goalRepository.getAllByUsername(UserService.getLoggedUser().getUsername());
        return goals;
    }

    @GetMapping("/reminder")
    public String getReminderMessage(){
        String message;
        List<Goal> goals = goalRepository.getAllByUsername(UserService.getLoggedUser().getUsername());
        Goal g = goals.get(goals.size() - 1);
        if (g != null)
            message = reminderQueryService.getReminder(UserService.getLoggedUser().getUsername(), g);
        else message = "No goal set yet!";
        return message;
    }
}
