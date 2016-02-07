package lab.pawigor.jrtt;

import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.UI;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

@SpringUI
public class VaadinUI extends UI {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    TaskRepository repo;
    Grid grid;
    TaskEditor editor;

    @Autowired
    public VaadinUI(TaskRepository repo, TaskEditor editor) {
        super();
        this.repo = repo;
        this.editor = editor;
        this.grid = new Grid();

    }

    @Override
    protected void init(VaadinRequest request) {
        // setContent(new But-ton("Click me", e -> Notification.show("Hello
        // Spring+Vaadin user!")));

//	HorizontalLayout actions = new HorizontalLayout(filter, addNewBtn);
        HorizontalLayout mainLayout = new HorizontalLayout(grid, editor);

//	actions.setSpacing(true);
        mainLayout.setMargin(true);
        mainLayout.setSpacing(true);

        setContent(mainLayout);

//	setContent(grid);
        grid.setContainerDataSource(
                new BeanItemContainer<Task>(Task.class, (Collection<? extends Task>) repo.findAll()));
    }

}
