package com.lemairepro.reminder.service;

import com.lemairepro.reminder.exception.ResourceNotFoundException;
import com.lemairepro.reminder.mapper.ReminderMapper;
import com.lemairepro.reminder.model.Reminder;
import com.lemairepro.reminder.model.ReminderDTO;
import com.lemairepro.reminder.repository.ReminderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReminderServiceImpl implements ReminderService {
    private final ReminderRepository reminderRepository;

    @Autowired
    public ReminderServiceImpl(ReminderRepository reminderRepository) {
        this.reminderRepository = reminderRepository;
    }

    /**
     * @return all saved reminders
     */
    @Override
    public List<ReminderDTO> list() {
        List<Reminder> reminders = this.reminderRepository.findAll();
        return ReminderMapper.INSTANCE.toReminderDTOList(reminders);
    }

    /**
     * Create a reminder
     *
     * @param reminder the reminder to save
     * @return the saved reminder
     */
    @Override
    public ReminderDTO create(ReminderDTO reminder) {
        Reminder r = ReminderMapper.INSTANCE.toReminder(reminder);
        return ReminderMapper.INSTANCE.toReminderDTO(this.reminderRepository.save(r));
    }

    /**
     * @param id wanted reminder's id
     * @return the found reminder
     */
    @Override
    public ReminderDTO get(Long id) {
        Reminder r = this.reminderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ReminderDTO not found"));
        return ReminderMapper.INSTANCE.toReminderDTO(r);
    }

    /**
     * Delete matching reminder id
     *
     * @param id of reminder
     */
    @Override
    public void delete(Long id) {
        Reminder r = this.reminderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ReminderDTO not found"));
        this.reminderRepository.delete(r);
    }

    /**
     * Update a given reminder
     *
     * @param id       reminder to update
     * @param reminder content to update
     * @return updated reminder
     */
    @Override
    public ReminderDTO update(Long id, ReminderDTO reminder) {
        Reminder r = this.reminderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ReminderDTO not found"));
        r.setDetails(reminder.getDetails());
        r.setTitle(reminder.getTitle());
        r.setDone(reminder.isDone());
        r.setEmail(reminder.getEmail());
        return ReminderMapper.INSTANCE.toReminderDTO(this.reminderRepository.saveAndFlush(r));
    }
}
