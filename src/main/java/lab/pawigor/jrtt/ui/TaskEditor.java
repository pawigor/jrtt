package lab.pawigor.jrtt.ui;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.event.ShortcutAction;
import com.vaadin.server.FontAwesome;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Button;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.DateField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

import lab.pawigor.jrtt.entity.Task;
import lab.pawigor.jrtt.entity.repo.TaskRepository;

@SpringComponent
@UIScope
public class TaskEditor extends VerticalLayout {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private final TaskRepository taskRepository;
    /* Fields to edit properties in Customer entity */
    TextField description = new TextField("Задача");
    DateField dueDate = new DateField("Сделать к");
    CheckBox isDone = new CheckBox("Выполнено");
    /* Action buttons */
    Button save = new Button("Сохранить", FontAwesome.SAVE);
    Button cancel = new Button("Отмена");
    Button delete = new Button("Удалить", FontAwesome.TRASH_O);
    CssLayout actions = new CssLayout(save, cancel, delete);
    private Task task;

    @Autowired
    public TaskEditor(TaskRepository taskRepository) {
        super();
        this.taskRepository = taskRepository;

        addComponents(description, dueDate, isDone, actions);
        // Configure and style components
        setSpacing(true);
        actions.setStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);
        save.setStyleName(ValoTheme.BUTTON_PRIMARY);
        save.setClickShortcut(ShortcutAction.KeyCode.ENTER);

        // wire action buttons to save, delete and reset
        save.addClickListener(e -> taskRepository.save(task));
        delete.addClickListener(e -> taskRepository.delete(task));
        cancel.addClickListener(e -> editTask(task));
        setVisible(false);

    }

    public final void editTask(Task c) {
        final boolean persisted = c.getId() != null;
        if (persisted) {
            // Find fresh entity for editing
            task = taskRepository.findOne(c.getId());
        } else {
            task = c;
        }
        cancel.setVisible(persisted);

        // Bind customer properties to similarly named fields
        // Could also use annotation or "manual binding" or programmatically
        // moving values from fields to entities before saving
        BeanFieldGroup.bindFieldsUnbuffered(task, this);

        setVisible(true);

        // A hack to ensure the whole form is visible
        save.focus();
        // Select all text in firstName field automatically
        description.selectAll();
    }

    public void setChangeHandler(ChangeHandler h) {
        // ChangeHandler is notified when either save or delete
        // is clicked
        save.addClickListener(e -> h.onChange());
        delete.addClickListener(e -> h.onChange());
    }

    public interface ChangeHandler {

        void onChange();
    }

}
