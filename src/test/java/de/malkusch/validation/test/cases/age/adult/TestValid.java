package de.malkusch.validation.test.cases.age.adult;

import java.util.Arrays;
import java.util.List;

import org.joda.time.LocalDate;
import org.joda.time.Years;
import org.junit.runners.Parameterized.Parameters;

import de.malkusch.validation.constraints.age.Adult;
import de.malkusch.validation.test.cases.AbstractValidTest;
import de.malkusch.validation.test.model.bean.AbstractBean;

/**
 * @author Markus Malkusch <markus@malkusch.de>
 */
public class TestValid extends AbstractValidTest {
	
	public static class Bean extends AbstractBean<LocalDate> {
		
		@Override
		@Adult
		public LocalDate getProperty() {
			return super.getProperty();
		}
		
	}
	
	public <T>TestValid(Class<AbstractBean<T>> beanType, T property) {
		super(beanType, property);
	}

	@Parameters
	static public List<Object[]> beans() {
		return Arrays.asList(new Object[][] {
				{ Bean.class, null },
				{ Bean.class, LocalDate.now().minus(Years.years(18)) },
				{ Bean.class, LocalDate.now().minus(Years.years(50)) },
		});
	}

}