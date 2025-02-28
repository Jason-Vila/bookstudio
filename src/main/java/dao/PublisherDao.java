package dao;

import java.util.List;

import models.Publisher;

public interface PublisherDao {
	public List<Publisher> listPublishers();
	public Publisher getPublisher(String publisherId);
	public Publisher createPublisher(Publisher publisher);
	public Publisher updatePublisher(Publisher publisher);
	public List<Publisher> populatePublisherSelect();
}
