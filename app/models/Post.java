package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;
@Entity
public class Post extends Model {
	
	@Id
	public String id;
	public String title;
	public String content;

}
