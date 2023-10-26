package com.example.application.views.myview;

import com.example.application.components.avataritem.AvatarItem;
import com.example.application.data.SamplePerson;
import com.example.application.services.SamplePersonService;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.avatar.AvatarGroup;
import com.vaadin.flow.component.avatar.AvatarGroup.AvatarGroupItem;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.listbox.MultiSelectListBox;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.progressbar.ProgressBar;
import com.vaadin.flow.component.tabs.TabSheet;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.spring.data.VaadinSpringDataHelpers;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

@PageTitle("My View")
@Route(value = "my-view", layout = MainLayout.class)
@Uses(Icon.class)
public class MyViewView extends Composite<VerticalLayout> {

    public MyViewView() {
        HorizontalLayout layoutRow = new HorizontalLayout();
        Button buttonPrimary = new Button();
        H1 h1 = new H1();
        RouterLink routerLink = new RouterLink();
        Button buttonSecondary = new Button();
        MenuBar menuBar = new MenuBar();
        Hr hr = new Hr();
        HorizontalLayout layoutRow2 = new HorizontalLayout();
        VerticalLayout layoutColumn2 = new VerticalLayout();
        Accordion accordion = new Accordion();
        MultiSelectListBox avatarItems = new MultiSelectListBox();
        VerticalLayout layoutColumn3 = new VerticalLayout();
        TabSheet tabSheet = new TabSheet();
        Grid multiSelectGrid = new Grid(SamplePerson.class);
        VerticalLayout layoutColumn4 = new VerticalLayout();
        AvatarGroup avatarGroup = new AvatarGroup();
        Icon icon = new Icon();
        HorizontalLayout layoutRow3 = new HorizontalLayout();
        ProgressBar progressBar = new ProgressBar();
        getContent().setHeightFull();
        getContent().setWidthFull();
        layoutRow.setWidthFull();
        layoutRow.addClassName(Gap.MEDIUM);
        buttonPrimary.setText("Button");
        buttonPrimary.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        h1.setText("Heading");
        routerLink.setText("Custom View");
        routerLink.setRoute(MyViewView.class);
        buttonSecondary.setText("Button");
        setMenuBarSampleData(menuBar);
        getContent().setFlexGrow(1.0, layoutRow2);
        layoutRow2.setWidthFull();
        layoutRow2.addClassName(Gap.MEDIUM);
        layoutColumn2.setHeightFull();
        layoutColumn2.setWidth(null);
        setAccordionSampleData(accordion);
        setAvatarItemsSampleData(avatarItems);
        layoutRow2.setFlexGrow(1.0, layoutColumn3);
        layoutColumn3.setHeightFull();
        layoutColumn3.setWidth(null);
        setTabSheetSampleData(tabSheet);
        multiSelectGrid.setSelectionMode(Grid.SelectionMode.MULTI);
        setGridSampleData(multiSelectGrid);
        layoutColumn4.setHeightFull();
        layoutColumn4.setWidth(null);
        setAvatarGroupSampleData(avatarGroup);
        icon.getElement().setAttribute("icon", "lumo:user");
        layoutRow3.setWidthFull();
        layoutRow3.addClassName(Gap.MEDIUM);
        progressBar.setValue(0.5);
        getContent().add(layoutRow);
        layoutRow.add(buttonPrimary);
        layoutRow.add(h1);
        layoutRow.add(routerLink);
        layoutRow.add(buttonSecondary);
        layoutRow.add(menuBar);
        getContent().add(hr);
        getContent().add(layoutRow2);
        layoutRow2.add(layoutColumn2);
        layoutColumn2.add(accordion);
        layoutColumn2.add(avatarItems);
        layoutRow2.add(layoutColumn3);
        layoutColumn3.add(tabSheet);
        layoutColumn3.add(multiSelectGrid);
        layoutRow2.add(layoutColumn4);
        layoutColumn4.add(avatarGroup);
        layoutColumn4.add(icon);
        getContent().add(layoutRow3);
        layoutRow3.add(progressBar);
    }

    private void setMenuBarSampleData(MenuBar menuBar) {
        menuBar.addItem("View");
        menuBar.addItem("Edit");
        menuBar.addItem("Share");
        menuBar.addItem("Move");
    }

    private void setAccordionSampleData(Accordion accordion) {
        Span name = new Span("Sophia Williams");
        Span email = new Span("sophia.williams@company.com");
        Span phone = new Span("(501) 555-9128");
        VerticalLayout personalInformationLayout = new VerticalLayout(name, email, phone);
        personalInformationLayout.setSpacing(false);
        personalInformationLayout.setPadding(false);
        accordion.add("Personal information", personalInformationLayout);
        Span street = new Span("4027 Amber Lake Canyon");
        Span zipCode = new Span("72333-5884 Cozy Nook");
        Span city = new Span("Arkansas");
        VerticalLayout billingAddressLayout = new VerticalLayout();
        billingAddressLayout.setSpacing(false);
        billingAddressLayout.setPadding(false);
        billingAddressLayout.add(street, zipCode, city);
        accordion.add("Billing address", billingAddressLayout);
        Span cardBrand = new Span("Mastercard");
        Span cardNumber = new Span("1234 5678 9012 3456");
        Span expiryDate = new Span("Expires 06/21");
        VerticalLayout paymentLayout = new VerticalLayout();
        paymentLayout.setSpacing(false);
        paymentLayout.setPadding(false);
        paymentLayout.add(cardBrand, cardNumber, expiryDate);
        accordion.add("Payment", paymentLayout);
    }

    private void setAvatarItemsSampleData(MultiSelectListBox multiSelectListBox) {
        record Person(String name, String profession) {
        }
        ;
        List<Person> data = List.of(new Person("Aria Bailey", "Endocrinologist"), new Person("Aaliyah Butler", "Nephrologist"), new Person("Eleanor Price", "Ophthalmologist"), new Person("Allison Torres", "Allergist"), new Person("Madeline Lewis", "Gastroenterologist"));
        multiSelectListBox.setItems(data);
        multiSelectListBox.setRenderer(new ComponentRenderer(item -> {
            AvatarItem avatarItem = new AvatarItem();
            avatarItem.setHeading(((Person) item).name);
            avatarItem.setDescription(((Person) item).profession);
            avatarItem.setAvatar(new Avatar(((Person) item).name));
            return avatarItem;
        }));
    }

    private void setTabSheetSampleData(TabSheet tabSheet) {
        tabSheet.add("Dashboard", new Div(new Text("This is the Dashboard tab content")));
        tabSheet.add("Payment", new Div(new Text("This is the Payment tab content")));
        tabSheet.add("Shipping", new Div(new Text("This is the Shipping tab content")));
    }

    private void setGridSampleData(Grid grid) {
        grid.setItems(query -> samplePersonService.list(
                PageRequest.of(query.getPage(), query.getPageSize(), VaadinSpringDataHelpers.toSpringDataSort(query)))
                .stream());
    }

    @Autowired()
    private SamplePersonService samplePersonService;

    private void setAvatarGroupSampleData(AvatarGroup avatarGroup) {
        avatarGroup.add(new AvatarGroupItem("A B"));
        avatarGroup.add(new AvatarGroupItem("C D"));
        avatarGroup.add(new AvatarGroupItem("E F"));
    }
}
