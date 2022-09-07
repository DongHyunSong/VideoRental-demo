package video.rental.demo;

import video.rental.demo.application.Interactor;
import video.rental.demo.domain.Repository;
import video.rental.demo.infrastructure.RepositoryMemImpl;
import video.rental.demo.presentation.CmdUI;
import video.rental.demo.util.SampleGenerator;

public class Main {

	public static void main(String[] args) {
		Repository repository = new RepositoryMemImpl();
		Interactor interactor = new Interactor(repository);
		CmdUI ui = new CmdUI(interactor);
		new SampleGenerator(repository).generateSamples();
		ui.start();
	}
}
