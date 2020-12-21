package de.ollie.carp.corelib.gui.user;

import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.KeyDownEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;

import de.ollie.carp.corelib.event.Event;
import de.ollie.carp.corelib.event.EventManager;
import de.ollie.carp.corelib.event.EventType;
import de.ollie.carp.corelib.gui.Disposable;
import de.ollie.carp.corelib.gui.PopupDialog;
import de.ollie.carp.corelib.service.AppConfiguration;
import de.ollie.carp.corelib.service.user.SessionOwner;
import de.ollie.carp.corelib.service.user.UserAuthorizationService;

/**
 * A user login view.
 *
 * @author ollie (21.12.2020)
 */
public class UserLoginView extends VerticalLayout implements ComponentEventListener<KeyDownEvent>, Disposable {

	private Button buttonLogin = new Button("Login");
	private PasswordField passwordFieldPassword = new PasswordField("Passwort");
	private TextField textFieldUserName = new TextField("Benutzername");

	private final transient AppConfiguration appConfiguration;
	private final transient EventManager eventManager;
	private final transient UserAuthorizationService userAuthorizationService;
	private final transient SessionOwner sessionOwner;

	public UserLoginView(AppConfiguration appConfiguration, EventManager eventManager, SessionOwner sessionOwner,
			UserAuthorizationService userAuthorizationService) {
		super();
		this.appConfiguration = appConfiguration;
		this.eventManager = eventManager;
		this.sessionOwner = sessionOwner;
		this.userAuthorizationService = userAuthorizationService;
		buttonLogin.addClickListener(event -> tryLogin());
		buttonLogin.setWidthFull();
		passwordFieldPassword.setWidthFull();
		passwordFieldPassword.addKeyDownListener(this);
		textFieldUserName.setWidthFull();
		textFieldUserName.setAutofocus(true);
		textFieldUserName.addKeyDownListener(this);
		setWidthFull();
		setMargin(false);
		add( //
				textFieldUserName, //
				passwordFieldPassword, //
				buttonLogin, //
				new Label(appConfiguration.getName() + " (" + appConfiguration.getVersion() + ")") //
		);
	}

	private void tryLogin() {
		userAuthorizationService.authenticate(textFieldUserName.getValue(), passwordFieldPassword.getValue()) //
				.ifPresentOrElse( //
						userAuthorization -> {
							sessionOwner.setUserAuthorization(userAuthorization);
							eventManager.fireEvent(new Event(userAuthorization.getUserLogin(), EventType.LOGGED_IN));
						}, //
						() -> {
							PopupDialog.showError("Passwort oder Benutername ist falsch!");
							passwordFieldPassword.setValue("");
							textFieldUserName.focus();
						});
	}

	@Override
	public void onComponentEvent(KeyDownEvent event) {
		if (event.getKey().getKeys().equals(Key.ENTER.getKeys())) {
			if (event.getSource() == passwordFieldPassword) {
				tryLogin();
			} else if (event.getSource() == textFieldUserName) {
				passwordFieldPassword.focus();
			}
		}
	}

	@Override
	public void dispose() {
	}

}