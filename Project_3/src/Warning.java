import java.util.InputMismatchException;

/**
 * Class that handles all warnings. 
 * @author Thomas Ortiz
 * @author Michael Mackrell
 * @author Jacob Stone
 * @author Curtis Moore
 */
public class Warning extends InputMismatchException {

	private static final long serialVersionUID = 1L;

	/**
	 * Simple constructor for warning.
	 */
	public Warning(String message){
		super(message);
	}
}
