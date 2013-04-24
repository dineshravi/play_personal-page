package models;

import javax.persistence.Id;
import javax.persistence.ManyToOne;

import play.db.ebean.Model;

public class Comment extends Model {

	@Id
	public String id;
	public String content;
	@ManyToOne
	public Post post;
}
