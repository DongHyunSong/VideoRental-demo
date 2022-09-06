package video.rental.demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

public class VideoRentalTest {
	
	private GoldenMaster goldenMaster = new GoldenMaster();

	@Test
	@Disabled
	void generateGoldenMaster() {
		// Given (Arrange)
		
		// When (Act)
		goldenMaster.generate();

		// Then (Assert)
	}
	
	@Test
    @EnabledOnOs(OS.WINDOWS)
//	@Disabled
	void check_runResult_agaist_GoldenMaster() {
		// Given (Arrange)
		String expected = goldenMaster.getGoldenMaster();
		
		// When (Act)
		String actual = goldenMaster.getRunResult();

		// Then (Assert)
		assertEquals(expected, actual.replaceAll("\r\n", "\n"));
	}
	
	@Test
    @EnabledOnOs({OS.LINUX, OS.MAC})
//	@Disabled
	void check_runResult_agaist_GoldenMaster2() {
		// Given (Arrange)
		String expected = goldenMaster.getGoldenMaster();
		
		// When (Act)
		String actual = goldenMaster.getRunResult();

		// Then (Assert)
		assertEquals(expected, actual);
	}
}
