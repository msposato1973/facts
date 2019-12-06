package facts.rest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_FACTS")
public class Fact {

	private String text;
	private Long id;
	private String url;
	private String language;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long factId) {
		this.id = factId;
	}

	@Column(name = "LANGUAGE", nullable = false)
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	@Column(name = "URL", nullable = true)
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Column(name = "TEXT", nullable = false)
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Fact(String text, Long id, String url, String language) {
		super();
		this.text = text;
		this.id = id;
		this.url = url;
		this.language = language;
	}

	public Fact() {

	}

}
