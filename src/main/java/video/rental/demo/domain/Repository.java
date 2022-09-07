package video.rental.demo.domain;

import java.util.List;

public interface Repository {

	List<Customer> findAllCustomers();

	List<Video> findAllVideos();

	void saveCustomer(Customer customer);

	void saveVideo(Video video);

	Customer findCustomerById(int code);

	Video findVideoByTitle(String title);

}