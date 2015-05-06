import org.junit.runner.JUnitCore;


public class PerTestCaseCoverageRunner
{
	public static void main(String[] args)
	{
		int sleepLength = 2000;
		System.out.println("Testing Thread.sleep()");
		System.out.println("Going to sleep for "+sleepLength+" ms.");
		try
		{
			Thread.sleep(sleepLength);
		}
		catch(InterruptedException e)
		{
			System.out.println(e.getMessage());
		}
		System.out.println("Done sleeping.");
		JUnitCore core = new JUnitCore();
		core.addListener(new JacocoListener());
		try
		{
			core.run(Class.forName(args[0]));
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}
}
