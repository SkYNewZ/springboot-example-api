package com.lemairepro.reminder.controller;

import com.lemairepro.reminder.model.ReminderDTO;
import com.lemairepro.reminder.service.ReminderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ReminderController {

    private final ReminderService reminderService;

    @Autowired
    public ReminderController(ReminderService reminderService) {
        this.reminderService = reminderService;
    }

    @GetMapping("/reminder")
    public List<ReminderDTO> list() {
        return this.reminderService.list();
    }

    @PostMapping("/reminder")
    public ReminderDTO create(@Valid @RequestBody ReminderDTO reminder) {
        return this.reminderService.create(reminder);
    }

    @GetMapping("/reminder/{id}")
    public ReminderDTO get(@PathVariable Long id) {
        return this.reminderService.get(id);
    }

    @DeleteMapping("/reminder/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        this.reminderService.delete(id);
    }

    @PatchMapping("/reminder/{id}")
    public ReminderDTO update(@PathVariable Long id, @Valid @RequestBody ReminderDTO reminder) {
        return this.reminderService.update(id, reminder);
    }
}
