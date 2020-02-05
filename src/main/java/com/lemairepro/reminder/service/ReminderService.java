package com.lemairepro.reminder.service;

import com.lemairepro.reminder.model.ReminderDTO;

import java.util.List;

public interface ReminderService {
    /**
     * @return all saved reminders
     */
    List<ReminderDTO> list();

    /**
     * Create a reminder
     * @param reminder the reminder to save
     * @return the saved reminder
     */
    ReminderDTO create(ReminderDTO reminder);

    /**
     * @param id wanted reminder's id
     * @return the found reminder
     */
    ReminderDTO get(Long id);

    /**
     * Delete matching reminder id
     * @param id of reminder
     */
    void delete(Long id);

    /**
     * Update a given reminder
     * @param id reminder to update
     * @param reminder content to update
     * @return updated reminder
     */
    ReminderDTO update(Long id, ReminderDTO reminder);
}
