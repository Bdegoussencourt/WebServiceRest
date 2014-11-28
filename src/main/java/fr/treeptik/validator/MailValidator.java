package fr.treeptik.validator;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import fr.treeptik.service.impl.UserServiceImpl;

@FacesValidator(value = "mailValidator")
public class MailValidator implements Validator {

	@EJB
	private UserServiceImpl serviceUser;

	public void validate(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		String email = String.valueOf(value);
		boolean valid = true;
		if (value == null) {
			valid = false;
		} else if (!email.contains("@")) {
			valid = false;
		} else if (!email.contains(".")) {
			valid = false;
		} else if (email.contains(" ")) {
			valid = false;
		}
		if (!valid) {
			FacesMessage message = new FacesMessage();
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			message.setDetail("#{msg['saisie.email.error_detail']}");
			message.setSummary("#{msg['saisie.email.error_summary']}");

			throw new ValidatorException(message);
		}
		// if(serviceUser.exist(email, id)(email)>0)
	}
}