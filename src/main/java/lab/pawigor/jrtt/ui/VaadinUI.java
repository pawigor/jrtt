package lab.pawigor.jrtt.ui;

import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import lab.pawigor.jrtt.entity.Task;
import lab.pawigor.jrtt.entity.repo.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

// TODO: 08.02.16 добавить фильтр выполненые/не выполненые/все
// TODO: 08.02.16 добавить изменение isDone из grid

@SpringUI
public class VaadinUI extends UI {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private TaskRepository repo;
    private Grid grid;
    private TaskEditor editor;
    private Button addNewBtn;

    @Autowired
    public VaadinUI(TaskRepository repo, TaskEditor editor) {
        super();
        this.repo = repo;
        this.editor = editor;
        this.grid = new Grid();
        this.addNewBtn = new Button("Добавить задачу");
        addNewBtn.addStyleName("btn btn-success");
    }

    @Override
    protected void init(VaadinRequest request) {
        // setContent(new But-ton("Click me", e -> Notification.show("Hello
        // Spring+Vaadin user!")));

        VerticalLayout actions = new VerticalLayout(addNewBtn, grid);
        HorizontalLayout mainLayout = new HorizontalLayout(actions, editor);

//	actions.setSpacing(true);
        mainLayout.setMargin(true);
        mainLayout.setSpacing(true);

        setContent(mainLayout);

//	setContent(grid);

        // Connect selected Customer to editor or hide if none is selected
        grid.addSelectionListener(e -> {
            if (e.getSelected().isEmpty()) {
                editor.setVisible(false);
            } else {
                editor.editTask((Task) e.getSelected().iterator().next());
            }
        });

        // Instantiate and edit new Customer the new button is clicked
        addNewBtn.addClickListener(e -> editor.editTask(new Task()));

        // Listen changes made by the editor, refresh data from backend
        editor.setChangeHandler(() -> {
            editor.setVisible(false);
            listCustomers();
        });

        // Initialize listing
        listCustomers();

    }

    private void listCustomers() {
        grid.setContainerDataSource(
                new BeanItemContainer<>(Task.class, (Collection<? extends Task>) repo.findAll()));

    }

}
