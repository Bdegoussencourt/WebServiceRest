package fr.treeptik.validator;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import fr.treeptik.exception.ServiceException;
import fr.treeptik.model.User;
import fr.treeptik.service.UserService;

//@FacesValidator(value = "emailAddressValidator")
@ManagedBean
public class EmailAddressValidator implements Validator {
	private static final String regex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private Pattern pattern;
	private Matcher matcher;
	@EJB
	private UserService userService;

	@Override
	public void validate(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		String email = String.valueOf(value);
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(value.toString());
		if (!matcher.matches()) {
			throw new ValidatorException(new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"Renseignez une adresse mail valide !",
					"Renseignez une adresse mail valide !"));
		}
		Boolean exist = false;
		Map<String, Object> map = component.getAttributes();
		Integer id = (Integer) map.get("idUser");
		// Integer id = Integer.valueOf(idUser);
		System.out.println("Id USER : " + id);
		User u = null;
		try {
			u = userService.findWithEmail(email);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (u != null) {
			if (id != null && id != 0) {
				if (u.getId() != id) {
					exist = true;
				}
			} else {
				exist = true;
			}
		}
		if (exist) {
			throw new ValidatorException(new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "L'email existe déjà !",
					"L'email existe déjà !"));
		}
	}
}