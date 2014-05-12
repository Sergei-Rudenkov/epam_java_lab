
package by.epam.lab1.bl;
import java.util.List;
import by.epam.lab1.to.TO;

public interface Command {
	 
    public List<TO> execute(TO to);
}
